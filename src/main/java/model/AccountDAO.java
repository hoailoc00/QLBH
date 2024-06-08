/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import model.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class AccountDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Account> getAlltaikhoan() {
        List<Account> list = new ArrayList<>();
        String query = "select * from taikhoan";
        try {
            conn = new MysqlConnect().openConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5)));
            }
        } catch (Exception e) {
        }

        return list;
    }

    public Account checkLogin(String user, String pass) {
        MysqlConnect mysqlConnect = new MysqlConnect();
        try {
            String query = "SELECT * FROM taikhoan WHERE TenTaiKhoan = ? AND MatKhau = ? AND isDeleted = 1";
            conn = mysqlConnect.openConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account a = new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
                return a;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.closeConnection();
        }
        return null;
    }

    public boolean isAdmin(String username) {
        MysqlConnect mysqlConnect = new MysqlConnect();
        try {
            String query = "SELECT * FROM taikhoan WHERE TenTaiKhoan = ?";
            conn = mysqlConnect.openConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                int isAdmin = rs.getInt(4);
                return isAdmin == 1 || isAdmin == 2; // Kiểm tra xem giá trị isAdmin có bằng 1 hay không (đã được set là admin)
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.closeConnection();
        }
        return false; // Trả về false nếu có lỗi hoặc không tìm thấy thông tin về tài khoản
    }

    public Account check(String user) {
        MysqlConnect mysqlConnect = new MysqlConnect();
        String query = "SELECT * FROM taikhoan WHERE TenTaiKhoan=?";
        try {
            conn = new MysqlConnect().openConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.closeConnection();
        }
        return null;
    }

    public Account addtaikhoan(String user, String password) {
        MysqlConnect mysqlConnect = new MysqlConnect();
        String query = "insert into taikhoan values(?,?,3,1)";
        try {
            conn = new MysqlConnect().openConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, password);
            ps.executeUpdate();
        } catch (Exception e) {
        }

        String query1 = "SELECT MaTaiKhoan FROM taikhoan";
        String User = ""; // Khởi tạo biến mới để lưu giá trị user

        try {
            conn = new MysqlConnect().openConnection();
            ps = conn.prepareStatement(query1);
            rs = ps.executeQuery();
            if (rs.last()) {
                User = rs.getString(1); // Lấy giá trị của TentaiKhoan từ kết quả truy vấn
            }
//    User = rs.getString() ;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.closeConnection();
        }

        return null;
    }

    public void addInfo(String hoVaten, String gioiTinh, String soDienThoai, String diaChi, String email) {
        MysqlConnect mysqlConnect = new MysqlConnect();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = new MysqlConnect().openConnection();

            // Lấy mã tài khoản cuối cùng trong bảng taikhoan
            String getMaTaiKhoanQuery = "SELECT TOP 1 MaTaiKhoan FROM taikhoan ORDER BY MaTaiKhoan DESC";
            ps = conn.prepareStatement(getMaTaiKhoanQuery);
            rs = ps.executeQuery();

            int maTaiKhoan = 0;
            if (rs.next()) {
                maTaiKhoan = rs.getInt("MaTaiKhoan");
            }

            // Thực hiện truy vấn INSERT vào bảng khachhang
            String insertQuery = "INSERT INTO khachhang VALUES (?,?,?,?,?,?,1)";
            ps = conn.prepareStatement(insertQuery);
            ps.setString(1, hoVaten);
            ps.setString(2, gioiTinh);
            ps.setString(3, soDienThoai);
            ps.setString(4, diaChi);
            ps.setString(5, email);
            ps.setInt(6, maTaiKhoan);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.closeConnection();
        }
    }
}
