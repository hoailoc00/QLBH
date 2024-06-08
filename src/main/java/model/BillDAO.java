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

/**
 *
 * @author PC
 */
public class BillDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public boolean addHoaDon(int totalAmount, int accountId) {
        MysqlConnect mysqlConnect = new MysqlConnect();
        // Tạo một đối tượng HoaDon với NgayLap là ngày hiện tại
        Bill bill = new Bill();
        CustomerDAO customerDAO = new CustomerDAO();
        Customer khachhang = customerDAO.getCustomerIdByAccountId(accountId);
        try {
            String query = "INSERT INTO hoadon (NgayLap, TongTien, MaNhanVien, MaKhachHang, TrangThai, MaVoucher) VALUES (?, ?, ?, ?, ?, ?)";
            conn = mysqlConnect.openConnection();

            PreparedStatement preparedStatement = conn.prepareStatement(query);
            bill.setNgayLap(Date.valueOf(LocalDate.now()));
            preparedStatement.setDate(1, bill.getNgayLap());
            preparedStatement.setDouble(2, totalAmount);
            preparedStatement.setInt(3, 1);
            preparedStatement.setInt(4, khachhang.getMaKhachHang());
            preparedStatement.setInt(5, bill.getTrangThai());
            preparedStatement.setInt(6, 0);

            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.closeConnection();
        }
        return false;
    }

    public static void main(String[] args) {
        BillDAO billDAO = new BillDAO();
        
        // Gọi phương thức addHoaDon và kiểm tra kết quả
        boolean result = billDAO.addHoaDon( 250000, 4);
        if (result == true) {
            System.out.println("Thêm hóa đơn thành công!");
        } else {
            System.out.println("Thêm hóa đơn không thành công!");
        }
    }
}
