/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.*;
import model.*;

/**
 *
 * @author Acer
 */
@WebServlet("/view/admin/Update")
public class Update extends HttpServlet {

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
            out.println("<title>Servlet Update</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Update at " + request.getContextPath() + "</h1>");
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
//        System.out.println("Action " + action);
        switch (action) {
            case "UpdateSanPham":
                UpdateSanPham(request, response);
                break;
            case "UpdateKhachHang":
                UpdateKhachHang(request, response);
                break;
            case "UpdateNhaCungCap":
                UpdateNhaCungCap(request, response);
                break;
            case "AcceptHoaDon":
                AcceptHoaDon(request, response);
                break;
            default:
                // Xử lý mặc định hoặc hiển thị thông báo lỗi
                response.getWriter().println("Invalid action");
        }
    }

    private void UpdateSanPham(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int MaSanPham = Integer.parseInt(request.getParameter("MaSanPham"));
        String TenSanPham = request.getParameter("TenSanPham");
        double GiaNhap = Double.parseDouble(request.getParameter("GiaNhap"));
        double GiaBan = Double.parseDouble(request.getParameter("GiaBan"));
        String HinhAnh = request.getParameter("HinhAnh");
        int SoLuong = Integer.parseInt(request.getParameter("SoLuong"));
        int LoaiSanPham = Integer.parseInt(request.getParameter("LoaiSanPham"));

        SanPham sp = new SanPham();
        sp.setMaSanPham(MaSanPham);
        sp.setTenSanPham(TenSanPham);
        sp.setGiaNhap(GiaNhap);
        sp.setGiaBan(GiaBan);
        sp.setHinhAnh(HinhAnh);
        sp.setSoLuong(SoLuong);
        sp.setMaLoaiSanPham(LoaiSanPham);
        SanPhamDAO spDAO = new SanPhamDAO();
        boolean success = spDAO.updateSanPham(sp);
        if (success) {
            response.getWriter().write("success");
        }
    }

    private void UpdateKhachHang(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int MaKhachHang = Integer.parseInt(request.getParameter("MaKhachHang"));
        String TenKhachHang = request.getParameter("TenKhachHang");
        String GioiTinh = request.getParameter("GioiTinh");
        String SDT = request.getParameter("SDT");
        String DiaChi = request.getParameter("DiaChi");
        String Email = request.getParameter("Email");
//        String TaiKhoan = request.getParameter("TaiKhoan");
//        String MatKhau = request.getParameter("MatKhau");

        khachhang kh = new khachhang();
        kh.setMaKhachHang(MaKhachHang);
        kh.setHoVaTen(TenKhachHang);
        kh.setGioiTinh(GioiTinh);
        kh.setSoDienThoai(SDT);
        kh.setDiaChi(DiaChi);
        kh.setEmail(Email);
        khachhangDAO khDAO = new khachhangDAO();
        boolean success = khDAO.updateKhachHang(kh);
        if (success) {
            response.getWriter().write("success");
        }
    }

    private void UpdateNhaCungCap(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int MaNhaCungCap = Integer.parseInt(request.getParameter("MaNhaCungCap"));
        String TenNhaCungCap = request.getParameter("TenNhaCungCap");
        String DiaChi = request.getParameter("DiaChi");
        String SDT = request.getParameter("SDT");

        nhacungcap ncc = new nhacungcap();
        ncc.setMaNhaCungCap(MaNhaCungCap);
        ncc.setTenNhaCungCap(TenNhaCungCap);
        ncc.setSoDienThoai(SDT);
        ncc.setDiaChi(DiaChi);
        nhacungcapDAO nccDAO = new nhacungcapDAO();
        boolean success = nccDAO.updateNhaCungCap(ncc);
        if (success) {
            response.getWriter().write("success");
        }
    }

    private void AcceptHoaDon(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int MaHoaDon = Integer.parseInt(request.getParameter("MaHoaDon"));
        hoadonDAO hdDAO = new hoadonDAO();
        boolean success = hdDAO.acceptHoaDon(MaHoaDon);
        if (success) {
            response.getWriter().write("success");
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
