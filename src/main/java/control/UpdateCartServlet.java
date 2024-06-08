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
import model.CartDAO;

/**
 *
 * @author PC
 */
@WebServlet("/view/web/UpdateCartServlet")
public class UpdateCartServlet extends HttpServlet {

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
            out.println("<title>Servlet CartServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CartServlet at " + request.getContextPath() + "</h1>");
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
        String updateCart = request.getParameter("updateCart");
        int productId = Integer.parseInt(request.getParameter("productId"));
        int newquantity = Integer.parseInt(request.getParameter("newquantity"));
        int accountId = Integer.parseInt(request.getParameter("accountId"));
        // Sử dụng productId và quantity kiểu int ở đây để cập nhật hoặc xử lý logic của bạn
        
        
        // Ví dụ: cartManager.updateQuantity(productId, quantity);
        CartDAO cartDAO = new CartDAO();
        cartDAO.updateQuantity(productId,newquantity,accountId );
//        if (updateCart != null && updateCart.equals("true")) {
//            
//            boolean success = cartDAO.updateCart(productId,accountId); // Gọi phương thức để cập nhật giỏ hàng
//            if (success) {
//                response.getWriter().write("Cập nhật giỏ hàng thành công");
//            } else {
//                response.getWriter().write("Cập nhật giỏ hàng không thành công");
//            }
        }

//        // Trả về một phản hồi nếu cần
//        response.setContentType("text/plain");
//        response.setCharacterEncoding("UTF-8");
//        response.getWriter().write("Cập nhật thành công");
//    }
    
}

/**
 * Returns a short description of the servlet.
 *
 * @return a String containing servlet description
 */
