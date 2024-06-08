/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Properties;
import model.Account;
import model.AccountDAO;


/**
 *
 * @author datht
 */
@WebServlet("/view/web/sendEmail")
public class sendEmail extends HttpServlet {

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
            out.println("<title>Servlet sendEmail</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet sendEmail at " + request.getContextPath() + "</h1>");
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
        String guicho = request.getParameter("guicho");
        String TaiKhoan = request.getParameter("taikhoan");
        String tieude = request.getParameter("tieude");
        String noidung = request.getParameter("noidung");
//        String mess = guicho + tieude + noidung;

        try {
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.debug", "true");
            props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            props.put("mail.smtp.ssl.protocols", "TLSv1.2");

            Session session = Session.getInstance(props, new Authenticator() {
                @Override
                protected jakarta.mail.PasswordAuthentication getPasswordAuthentication() {
                    String username = "datht2604@gmail.com";
                    String password = "chjt qwxd giht gxks";
                    return new jakarta.mail.PasswordAuthentication(username, password);
                }
            });
            AccountDAO dao = new AccountDAO();
            Account a = dao.check(TaiKhoan);
            if(a!=null){
                        
            
            
            List<Account> list = dao.getAlltaikhoan();
            for (Account o : list) {
            if(o.getTenTK().equals(TaiKhoan)) {
            System.out.println(o.getMatKhauTK());
            noidung = o.getMatKhauTK();
        }
        }
            MimeMessage message = new MimeMessage(session);
            message.addHeader("Content-type", "text/HTML; charset=UTF-8");
            message.setFrom(new InternetAddress("likesoccer113@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(guicho, false));
            message.setSubject("Gửi tài khoản: "+TaiKhoan, "utf-8");
            message.setText("Mật khẩu là: "+noidung, "utf-8", "html");
            message.setReplyTo(message.getFrom());
            Transport.send(message);
            }
            else{
                request.setAttribute("errorMessage", "Tài khoản " + TaiKhoan + " không tồn tại.");
                request.getRequestDispatcher("quenMk.jsp").forward(request, response);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        
//        taikhoanDAO dao = new taikhoanDAO();
//        dao.sendPassword(pass);
        
        
        
        
        request.getRequestDispatcher("dangnhap.jsp").forward(request, response);
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
