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
@WebServlet("/view/admin/Delete")
public class Delete extends HttpServlet {

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
            out.println("<title>Servlet Delete</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Delete at " + request.getContextPath() + "</h1>");
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
            case "DeleteSanPham":
                DeleteSanPham(request, response);
                break;
            case "DeleteKhachHang":
                DeleteKhachHang(request, response);
                break;
            case "DeleteNhaCungCap":
                DeleteNhaCungCap(request, response);
                break;
            case "DenyHoaDon":
                DenyHoaDon(request, response);
                break;
            default:
                // Xử lý mặc định hoặc hiển thị thông báo lỗi
                response.getWriter().println("Invalid action");
        }
    }

    private void DeleteSanPham(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int MaSanPham = Integer.parseInt(request.getParameter("MaSanPham"));
        SanPhamDAO spDAO = new SanPhamDAO();
        boolean success = spDAO.deleteSanPham(MaSanPham);
        if (success) {
            response.getWriter().write("success");
        }
    }

    private void DeleteKhachHang(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int MaKhachHang = Integer.parseInt(request.getParameter("MaKhachHang"));
        khachhangDAO khDAO = new khachhangDAO();
        boolean success = khDAO.deleteKhachHang(MaKhachHang);
        if (success) {
            response.getWriter().write("success");
        }
    }

    private void DeleteNhaCungCap(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int MaNhaCungCap = Integer.parseInt(request.getParameter("MaNhaCungCap"));
        nhacungcapDAO nccDAO = new nhacungcapDAO();
        boolean success = nccDAO.deleteNhaCungCap(MaNhaCungCap);
        if (success) {
            response.getWriter().write("success");
        }
    }

    private void DenyHoaDon(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int MaHoaDon = Integer.parseInt(request.getParameter("MaHoaDon"));
        hoadonDAO hdDAO = new hoadonDAO();
        boolean success = hdDAO.denyHoaDon(MaHoaDon);
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
