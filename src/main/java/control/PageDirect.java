/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model.*;

/**
 *
 * @author Acer
 */
@WebServlet("/view/admin/PageDirect")
public class PageDirect extends HttpServlet {

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
            out.println("<title>Servlet PageDirect</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PageDirect at " + request.getContextPath() + "</h1>");
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
//        processRequest(request, response);
        String param = request.getParameter("page");
        String id = request.getParameter("id");
        if (param != null) {
            request.setAttribute("page", param);
        }
        if ("itemupdate".equals(param) && id != null) {
            int idsp = Integer.parseInt(id);
            SanPham sp = new SanPham();
            SanPhamDAO SPdao = new SanPhamDAO();
            sp = SPdao.getSanPhambyID(idsp);
            request.setAttribute("ctsp", sp);
        }
        if ("customerupdate".equals(param) && id != null) {
            int customerid = Integer.parseInt(id);
            khachhang kh = new khachhang();
            khachhangDAO KHdao = new khachhangDAO();
            kh = KHdao.getKhachHangbyID(customerid);
            request.setAttribute("kh", kh);
        }
        if ("supplierupdate".equals(param) && id != null) {
            int supplierid = Integer.parseInt(id);
            nhacungcap ncc = new nhacungcap();
            nhacungcapDAO nccDAO = new nhacungcapDAO();
            ncc = nccDAO.getNhaCungCapbyID(supplierid);
            request.setAttribute("ncc", ncc);
        }
        if ("billdetail".equals(param) || "allbill".equals(param) && id != null) {
            int billid = Integer.parseInt(id);
            List<hoadon> hddetail = new ArrayList<>();
            hoadonDAO hdDAO = new hoadonDAO();
            hddetail = hdDAO.getChiTietHoaDon(billid);
            request.setAttribute("hdid", id);
            request.setAttribute("hddetail", hddetail);
        }

        List<SanPham> lsSP = new ArrayList<SanPham>();
        SanPhamDAO SPdao = new SanPhamDAO();
        lsSP = SPdao.getALL();
        request.setAttribute("listSP", lsSP);

//        List<SanPham> top10 = new ArrayList<SanPham>();
//        top10 = SPdao.getTop10();
//        request.setAttribute("top10", top10);
        List<taikhoan> listtk = new ArrayList<taikhoan>();
        taikhoanDAO tkdao = new taikhoanDAO();
        listtk = tkdao.getALLUser();
        request.setAttribute("listtk", listtk);

        List<hoadon> hd = new ArrayList<hoadon>();
        hoadonDAO hddao = new hoadonDAO();
        hd = hddao.getALL();
        request.setAttribute("hd", hd);

        List<hoadon> hd1 = new ArrayList<hoadon>();
        hd1 = hddao.getALLDuyet();
        request.setAttribute("hd1", hd1);

        List<hoadon> hd0 = new ArrayList<hoadon>();
        hd0 = hddao.getALLChuaDuyet();
        request.setAttribute("hd0", hd0);

        double tongdoanhthu = hddao.getTongDoanhThu();
        request.setAttribute("tongdoanhthu", tongdoanhthu);

        double doanhthuthang = hddao.getDoanhThuThang();
        request.setAttribute("doanhthuthang", doanhthuthang);

        List<hoadon> cthd = new ArrayList<hoadon>();
        cthd = hddao.getALLChiTietHoaDon();
        request.setAttribute("cthd", cthd);

        int spdaban = hddao.getTongSanPhamDaBan();
        request.setAttribute("spdaban", spdaban);

        List<loaisanpham> lslsp = new ArrayList<loaisanpham>();
        loaisanphamDAO lspDAO = new loaisanphamDAO();
        lslsp = lspDAO.getALL();
        request.setAttribute("lslsp", lslsp);

        List<khachhang> lsKH = new ArrayList<khachhang>();
        khachhangDAO KHdao = new khachhangDAO();
        lsKH = KHdao.getALL();
        request.setAttribute("listKH", lsKH);

        List<nhacungcap> lsNCC = new ArrayList<nhacungcap>();
        nhacungcapDAO NCCdao = new nhacungcapDAO();
        lsNCC = NCCdao.getALL();
        request.setAttribute("lsNCC", lsNCC);

        List<topkhachhang> topkh = new ArrayList<topkhachhang>();
        topkh = hddao.top5KhachHang();
        request.setAttribute("top5kh", topkh);

        List<topsanpham> topsp = new ArrayList<topsanpham>();
        topsp = hddao.top10SanPham();
        request.setAttribute("top10sp", topsp);

        request.getRequestDispatcher("index.jsp").forward(request, response);

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
//        processRequest(request, response);
        String TenSanPham = request.getParameter("TenSanPham");
        String GiaNhap = request.getParameter("GiaNhap");
        String GiaBan = request.getParameter("GiaBan");
        String HinhAnh = request.getParameter("HinhAnh");
        String SoLuong = request.getParameter("SoLuong");
        String LoaiSanPham = request.getParameter("LoaiSanPham");
        int isDeleted = 1;

        SanPham sp = new SanPham();
        sp.setTenSanPham(TenSanPham);
        sp.setGiaNhap(Double.parseDouble(GiaNhap));
        sp.setGiaBan(Double.parseDouble(GiaBan));
        sp.setHinhAnh(HinhAnh);
        sp.setSoLuong(Integer.parseInt(SoLuong));
        sp.setMaLoaiSanPham(Integer.parseInt(LoaiSanPham));
        sp.setIsDeleted(1);
        SanPhamDAO spDAO = new SanPhamDAO();
        spDAO.insertSanPham(sp);
        response.getWriter().write("success");
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
