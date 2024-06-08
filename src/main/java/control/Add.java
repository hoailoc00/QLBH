/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import jakarta.servlet.ServletContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.*;
import model.*;

/**
 *
 * @author Acer
 */
@WebServlet("/view/admin/Add")
public class Add extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Add</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Add at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println("Action " + action);
        switch (action) {
            case "AddSanPham":
                AddSanPham(request, response);
                break;
            case "AddKhachHang":
                AddKhachHang(request, response);
                break;
            case "AddNhaCungCap":
                AddNhaCungCap(request, response);
                break;
            default:
                // Xử lý mặc định hoặc hiển thị thông báo lỗi
                response.getWriter().println("Hành động không hợp lệ: " + action);
        }
    }

    private void AddSanPham(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext context = request.getServletContext();

        String tenSanPham = request.getParameter("TenSanPham");
        double giaNhap = Double.parseDouble(request.getParameter("GiaNhap"));
        double giaBan = Double.parseDouble(request.getParameter("GiaBan"));
        int soLuong = Integer.parseInt(request.getParameter("SoLuong"));
        int loaiSanPham = Integer.parseInt(request.getParameter("LoaiSanPham"));

//        Part filePart = request.getPart("file");
//        String fileName = getFileName(filePart);
        // Thực hiện lưu hình ảnh vào thư mục upload ở đây (sử dụng mã Java I/O)
        String relativePath = "/img/shop";
        String uploadPath = context.getRealPath(relativePath);
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        Part filePart = request.getPart("file");
        String fileName = getFileName(filePart);
        String filePath = uploadPath + File.separator + fileName;
//        filePart.write(filePath);
        try (InputStream inputStream = filePart.getInputStream(); FileOutputStream outputStream = new FileOutputStream(filePath)) {

            // Đọc dữ liệu từ InputStream và ghi vào FileOutputStream
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            String relativeFilePath = relativePath + "/" + fileName;
            SanPham sp = new SanPham();
            sp.setTenSanPham(tenSanPham);
            sp.setGiaNhap(giaNhap);
            sp.setGiaBan(giaBan);
            sp.setHinhAnh(relativeFilePath);
            sp.setSoLuong(soLuong);
            sp.setMaLoaiSanPham(loaiSanPham);
            sp.setIsDeleted(1);
            SanPhamDAO spDAO = new SanPhamDAO();
            boolean success = spDAO.insertSanPham(sp);
            if (success) {
                response.getWriter().write("success");
            }

//            response.getWriter().println("File " + fileName + " has been uploaded successfully!");
        } catch (IOException e) {
            response.getWriter().println("Error while uploading file: " + e.getMessage());
        }

        // Tiếp theo, bạn có thể sử dụng dữ liệu này để thêm sản phẩm vào cơ sở dữ liệu hoặc làm điều gì đó khác
        // Sau cùng, gửi kết quả về trình duyệt
//        response.getWriter().write("success");
//        String TenSanPham = request.getParameter("TenSanPham");
//        double GiaNhap = Double.parseDouble(request.getParameter("GiaNhap"));
//        double GiaBan = Double.parseDouble(request.getParameter("GiaBan"));
//        String HinhAnh = request.getParameter("HinhAnh");
//        int SoLuong = Integer.parseInt(request.getParameter("SoLuong"));
//        int LoaiSanPham = Integer.parseInt(request.getParameter("LoaiSanPham"));
//        int isDeleted = 1;
//        System.out.println("TenSanPham " + TenSanPham);
//        System.out.println("GiaNhap " + GiaNhap);
//        System.out.println("GiaBan " + GiaBan);
//        System.out.println("HinhAnh " + HinhAnh);
//        System.out.println("SoLuong " + SoLuong);
//        System.out.println("LoaiSanPham " + LoaiSanPham);
//
    }

    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf('=') + 2, token.length() - 1);
            }
        }
        return "";
    }

    private void AddKhachHang(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String TenKhachHang = request.getParameter("TenKhachHang");
            String GioiTinh = request.getParameter("GioiTinh");
            String SDT = request.getParameter("SDT");
            String DiaChi = request.getParameter("DiaChi");
            String Email = request.getParameter("Email");
            String TaiKhoan = request.getParameter("TaiKhoan");
            String MatKhau = request.getParameter("MatKhau");

            taikhoan tk = new taikhoan();
            tk.setTenTaiKhoan(TaiKhoan);
            tk.setMatKhau(MatKhau);
            tk.setMaLoaiTaiKhoan(3);
            tk.setIsDeleted(1);

            khachhang kh = new khachhang();
            kh.setHoVaTen(TenKhachHang);
            kh.setGioiTinh(GioiTinh);
            kh.setSoDienThoai(SDT);
            kh.setDiaChi(DiaChi);
            kh.setEmail(Email);

            khachhangDAO khDAO = new khachhangDAO();
            String result = khDAO.insertKhachHang(tk, kh);

            System.out.println("Kết quả của result: " + result);
            switch (result) {
                case "success":
                    response.getWriter().write("success");
                    break;
                case "account existed":
                    response.getWriter().write("account existed");
                    break;
                case "can not create account":
                    response.getWriter().write("can not create account");
                    break;
                case "false":
                    response.getWriter().write("false");
                    break;
                default:
                    // Xử lý trường hợp mặc định nếu cần
                    response.getWriter().write("unknown result");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("exception: " + e.getMessage());
        }
    }
//        int MaKhhachHang= Integer.parseInt(request.getParameter("MaKhachHang"));
    //            response.getWriter().println("File " + fileName + " has been uploaded successfully!");

// Tiếp theo, bạn có thể sử dụng dữ liệu này để thêm sản phẩm vào cơ sở dữ liệu hoặc làm điều gì đó khác
// Sau cùng, gửi kết quả về trình duyệt
//        response.getWriter().write("success");
//        String TenSanPham = request.getParameter("TenSanPham");
//        double GiaNhap = Double.parseDouble(request.getParameter("GiaNhap"));
//        double GiaBan = Double.parseDouble(request.getParameter("GiaBan"));
//        String HinhAnh = request.getParameter("HinhAnh");
//        int SoLuong = Integer.parseInt(request.getParameter("SoLuong"));
//        int LoaiSanPham = Integer.parseInt(request.getParameter("LoaiSanPham"));
//        int isDeleted = 1;
//        System.out.println("TenSanPham " + TenSanPham);
//        System.out.println("GiaNhap " + GiaNhap);
//        System.out.println("GiaBan " + GiaBan);
//        System.out.println("HinhAnh " + HinhAnh);
//        System.out.println("SoLuong " + SoLuong);
//        System.out.println("LoaiSanPham " + LoaiSanPham);
//
    private void AddNhaCungCap(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String TenNhaCungCap = request.getParameter("TenNhaCungCap");
            String DiaChi = request.getParameter("DiaChi");
            String SDT = request.getParameter("SDT");

            nhacungcap ncc = new nhacungcap();
            ncc.setTenNhaCungCap(TenNhaCungCap);
            ncc.setDiaChi(DiaChi);
            ncc.setSoDienThoai(SDT);
            ncc.setIsDeleted(1);

            nhacungcapDAO nccDAO = new nhacungcapDAO();
            boolean result = nccDAO.insertNhaCungCap(ncc);

            if (result) {
                response.getWriter().write("success");
            } else {
                response.getWriter().write("failure");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("exception: " + e.getMessage());
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
