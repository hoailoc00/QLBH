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
import jakarta.servlet.http.HttpSession;
import model.Account;
import model.CartDAO;
import model.ProductDAO;

/**
 *
 * @author PC
 */
@WebServlet("/view/web/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {

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
            out.println("<title>Servlet AddToCartServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddToCartServlet at " + request.getContextPath() + "</h1>");
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
        // Lấy thông tin tài khoản từ Session
        String quantityStr = request.getParameter("quantity");
        int productId = Integer.parseInt(request.getParameter("productId"));
        int accountId = Integer.parseInt(request.getParameter("accountId"));

        System.out.println("Product ID: " + productId);
        System.out.println("Account ID: " + accountId);
        // Thực hiện xử lý thêm sản phẩm vào giỏ hàng dựa trên productId và accountId
        CartDAO cartDAO = new CartDAO();
        ProductDAO productDAO = new ProductDAO();
        if (quantityStr != null) {
            int quantity = Integer.parseInt(quantityStr);
            boolean giamSP = productDAO.decreaseProductQuantityInCart(productId,quantity);
            if (giamSP) {
                boolean addtocart = cartDAO.addToCart(productId, accountId,quantity);

                if (addtocart) {
                    // Trả về mã thành công nếu xóa thành công
                    response.getWriter().write("success");
                } else {
                    // Trả về mã lỗi nếu có lỗi xảy ra khi xóa
                    response.getWriter().write("error");
                }
            } else {
                response.getWriter().write("error");
            }
        }else {
            boolean giamSP = productDAO.decreaseProductQuantityInCart(productId);
        if (giamSP) {
            boolean addtocart = cartDAO.addToCart(productId, accountId);

            if (addtocart) {
                // Trả về mã thành công nếu xóa thành công
                response.getWriter().write("success");
            } else {
                // Trả về mã lỗi nếu có lỗi xảy ra khi xóa
                response.getWriter().write("error");
            }
        } else {
            response.getWriter().write("error");
        }
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
