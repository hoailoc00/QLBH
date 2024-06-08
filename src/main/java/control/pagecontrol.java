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
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.*;

/**
 *
 * @author PC
 */
@WebServlet({"/view/web/pagecontrol"})
public class pagecontrol extends HttpServlet {

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
            out.println("<title>Servlet pagecontrol</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet pagecontrol at " + request.getContextPath() + "</h1>");
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
        String newcheck = (String) request.getAttribute("check");
        String ac = request.getParameter("page");
        String idproduct = request.getParameter("productId");
        request.setAttribute("page", ac);
        //listsp
        String isSearchServlet = "search";
        String indexPage = request.getParameter("Index");
        if (indexPage == null) {
            indexPage = "1";
            int Index = Integer.parseInt(indexPage);
        }

        int Index = Integer.parseInt(indexPage);

        if (isSearchServlet.equals(newcheck)) {
            String indexSearch = request.getParameter("Indexsearch");
            if (indexSearch == null) {
                indexSearch = "1";
                int Search = Integer.parseInt(indexSearch);
            }
            int Search = Integer.parseInt(indexSearch);
            String txt = request.getParameter("txtsearch");
            if (txt != null) {
                request.setAttribute("checksearch", txt);
                request.setAttribute("listSP", null);
                ProductDAO dao = new ProductDAO();
                List<Product> ls = dao.PageLoadsearch(txt, Search);
                request.setAttribute("listSP", ls);
                //khac
                int count = dao.getSanPhamSearch(txt);
                int endPage = count / 4;
                if (count % 4 != 0) {
                    endPage++;
                }
                request.setAttribute("listSearch", endPage);

            } else {
                // Hiển thị toàn bộ sản phẩm nếu không có từ khóa tìm kiếm
                ProductDAO dao = new ProductDAO();
                int count = dao.getSanPham();
                int endPage = count / 4;
                if (count % 4 != 0) {
                    endPage++;
                }
                request.setAttribute("endP", endPage);

                List<Product> ls = dao.getALL();
                request.setAttribute("listSP", ls);
            }
        } else if ("category".equals(newcheck)) {
            ProductDAO dao = new ProductDAO();
            List<Product> ls = dao.danhmuc();
            request.setAttribute("listSP", ls);
        } else {
            if ("nuocuong".equals(newcheck)) {
                ProductDAO dao = new ProductDAO();
                List<Product> ls = dao.danhmucnuoc();
                request.setAttribute("listSP", ls);
            } else {

                String txt = request.getParameter("txtsearch");
                request.setAttribute("txtsearch", txt);
                if (txt == null) {
                    // Hiển thị toàn bộ sản phẩm nếu không có từ khóa tìm kiếm
                    ProductDAO dao = new ProductDAO();
                    List<Product> ls = dao.PageLoad(Index);
                    request.setAttribute("listSP", ls);
                }

                request.setAttribute("checksearch", txt);
                ProductDAO dao = new ProductDAO();
                int count = dao.getSanPhamSearch(txt);

                int endPage = count / 4;
                if (count % 4 != 0) {
                    endPage++;

                }
                request.setAttribute("listSearch", endPage);

            }
        }
        String txt = request.getParameter("txtsearch");
        if (txt == null) {
            ProductDAO dao = new ProductDAO();
            int count = dao.getSanPham();
            int endPage = count / 4;
            if (count % 4 != 0) {
                endPage++;
            }
            request.setAttribute("endP", endPage);
        }
        //chitietsp
        if (idproduct != null) {
            int idSP = Integer.parseInt(idproduct);
            List<Category> ls = new ArrayList<Category>();
            CategoryDAO cateDAO = new CategoryDAO();
            ls = cateDAO.getALLinfor();
            request.setAttribute("listCate", ls);
            Category itemdetail = new Category();
            itemdetail = cateDAO.getProductById(ls, idSP);
            request.setAttribute("itemdetail", itemdetail);
        }
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        //xu ly trang khi dang nhap va khong dang nhap
        int accountId = -1;
        if (account != null) {
            accountId = account.getMaTK();
            //listsp
            List<Product> lsSP = new ArrayList<Product>();
            ProductDAO SPdao = new ProductDAO();
            lsSP = SPdao.getALL();
            request.setAttribute("listSP", lsSP);

            //listgiohang
            List<Cart> lsCart = new ArrayList<Cart>();
            CartDAO Cartdao = new CartDAO();
            lsCart = Cartdao.getALL();
            request.setAttribute("listCart", lsCart);
            List<Cart> listCartitem = new ArrayList<>();
            listCartitem = Cartdao.getCartItemsByCustomerId(accountId);
            request.setAttribute("listCartitem", listCartitem);
            //listkh
            List<Customer> lsCus = new ArrayList<Customer>();
            CustomerDAO Cusdao = new CustomerDAO();
            lsCus = Cusdao.getALL();
            request.setAttribute("listCustomer", lsCus);

            CustomerDAO dao = new CustomerDAO();

            Customer khachhang = dao.getCustomerIdByAccountId(accountId); // Lấy mã khách hàng từ mã tài khoản
            Customer foundCustomer = dao.getCustomerByAccountId(lsCus, accountId);
            int customerId = -1;
            if (foundCustomer != null) {
                request.setAttribute("foundcustomer", foundCustomer);
            }

            if (khachhang != null) {
                customerId = khachhang.getMaKhachHang(); // Lấy mã khách hàng từ đối tượng Customer
            }
            request.setAttribute("customerId", customerId);
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        } else {
            // Người dùng chưa đăng nhập
            if ("shop_cart".equals(ac)) {
                // Nếu truy cập trang giỏ hàng, chuyển hướng đến trang đăng nhập

            } else {
                // Trang khác không yêu cầu đăng nhập, tiếp tục truy cập
                //list DM AND LSP AND SP
                List<Category> ls = new ArrayList<Category>();
                CategoryDAO Catedao = new CategoryDAO();
                ls = Catedao.getALLinfor();
                request.setAttribute("listCate", ls);
                //listsp
                List<Product> lsSP = new ArrayList<Product>();
                ProductDAO SPdao = new ProductDAO();
                lsSP = SPdao.getALL();
                request.setAttribute("listSP", lsSP);
                //listgiohang
                List<Cart> lsCart = new ArrayList<Cart>();
                CartDAO Cartdao = new CartDAO();
                lsCart = Cartdao.getALL();
                request.setAttribute("listCart", lsCart);

                //listkh
                List<Customer> lsCus = new ArrayList<Customer>();
                CustomerDAO Cusdao = new CustomerDAO();
                lsCus = Cusdao.getALL();
                request.setAttribute("listCustomer", lsCus);
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }
        }
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
