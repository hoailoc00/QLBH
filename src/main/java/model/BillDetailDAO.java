/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class BillDetailDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public boolean addChiTietHoaDon(int accountId) {
        MysqlConnect mysqlConnect = new MysqlConnect();
        
        CustomerDAO customerDAO = new CustomerDAO();
        Customer khachhang = customerDAO.getCustomerIdByAccountId(accountId);
        
        List<Cart> listcartbill = new ArrayList<Cart>();
        CartDAO cartDAO = new CartDAO();
        listcartbill = cartDAO.getALLBill(accountId);
        BillDetail billdetail = new BillDetail();
        try {
            String query = "INSERT INTO chitiethoadon (MaHoaDon, MaSanPham, SoLuong, GiaTien) VALUES (?, ?, ?, ?)";
            conn = mysqlConnect.openConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            for (Cart cart : listcartbill) {
                preparedStatement.setInt(1, cart.getHoadon().getMaHoaDon());
                preparedStatement.setInt(2, cart.getMaSanPham());
                preparedStatement.setInt(3, cart.getSoLuong());
                preparedStatement.setDouble(4, cart.getGiaTien());
                preparedStatement.executeUpdate();

            }
            preparedStatement.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.closeConnection();
        }
        return false;
    }

    public static void main(String[] args) {
        BillDetailDAO billDetailDAO = new BillDetailDAO();

        // Giả sử accountId của khách hàng cần kiểm tra
        int accountId = 4;

        // Gọi phương thức để thêm chi tiết hóa đơn
        boolean result = billDetailDAO.addChiTietHoaDon(accountId);

        // Kiểm tra kết quả của phương thức
        if (result) {
            System.out.println("Chi tiết hóa đơn đã được thêm thành công!");
        } else {
            System.out.println("Có lỗi xảy ra khi thêm chi tiết hóa đơn!");
        }
    }
}
