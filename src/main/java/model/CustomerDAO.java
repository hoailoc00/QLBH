/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class CustomerDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Customer> getALL() {
        MysqlConnect mysqlConnect = new MysqlConnect();
        List<Customer> ls = new ArrayList<>();
        try {
            String query = "SELECT k.MaKhachHang, k.HoVaTen, k.GioiTinh,"
                    + " k.SoDienThoai, k.DiaChi, k.Email, k.MaTaiKhoan, k.isDeleted, p.MaSanPham,"
                    + " p.TenSanPham, p.SoLuong, p.GiaTien FROM khachhang k "
                    + "INNER JOIN giohang p ON k.MaKhachHang = p.MaKhachHang";
            conn = mysqlConnect.openConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Customer kh = new Customer();
                kh.setMaKhachHang(rs.getInt(1));
                kh.setHoVaTen(rs.getString(2));
                kh.setGioiTinh(rs.getString(3));
                kh.setSoDienThoai(rs.getString(4));
                kh.setDiaChi(rs.getString(5));
                kh.setEmail(rs.getString(6));
                kh.setMaTaiKhoan(rs.getInt(7));
                kh.setIsDeleted(rs.getInt(8));
                Cart giohang = new Cart();
                giohang.setMaSanPham(rs.getInt(9));
                giohang.setTenSanPham(rs.getString(10));
                giohang.setSoLuong(rs.getInt(11));
                giohang.setGiaTien(rs.getDouble(12));

                kh.setCart(giohang);
                ls.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.closeConnection();
        }
        return ls;
    }

    public Customer getCustomerByAccountId(List<Customer> lsCus, int accountId) {
        CustomerDAO customerDAO = new CustomerDAO();
        Customer khachhang = customerDAO.getCustomerIdByAccountId(accountId);
        for (Customer customer : lsCus) {
            if (customer.getMaKhachHang() == khachhang.getMaKhachHang()) {
                return customer;
            }
        }
        return null; // Hoặc trả về giá trị mặc định nếu không tìm thấy
    }

    public void updateInfocustomer(String hoVaten, String gioiTinh, String soDienThoai, String diaChi, String email, int maTaiKhoan) {
        MysqlConnect mysqlConnect = new MysqlConnect();
        String updateQuery = "UPDATE khachhang SET [HoVaTen] = ?, GioiTinh = ?, SoDienThoai = ?, DiaChi = ?, Email = ? WHERE MaTaiKhoan = ?";
        try {
            conn = new MysqlConnect().openConnection();
            ps = conn.prepareStatement(updateQuery);
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

    public Customer getCustomerIdByAccountId(int accountId) {
        MysqlConnect mysqlConnect = new MysqlConnect();
        Customer khachhang = null;
        try {
            String query = "SELECT * FROM khachhang WHERE MaTaiKhoan = ? AND isDeleted = ?";
            conn = mysqlConnect.openConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, accountId);
            ps.setInt(2, 1);
            rs = ps.executeQuery();
            if (rs.next()) {
                // Lấy thông tin từ ResultSet và tạo một đối tượng Product
                int maKH = rs.getInt("MaKhachHang");
                String name = rs.getString("HoVaTen");
                String gioitinh = rs.getString("GioiTinh");
                String sdt = rs.getString("SoDienThoai");
                String diachi = rs.getString("DiaChi");
                String email = rs.getString("Email");

                // Tạo đối tượng Product từ dữ liệu lấy được từ cơ sở dữ liệu
                khachhang = new Customer();
                khachhang.setMaKhachHang(maKH);
                khachhang.setHoVaTen(name);
                khachhang.setGioiTinh(gioitinh);
                khachhang.setSoDienThoai(sdt);
                khachhang.setDiaChi(diachi);
                khachhang.setEmail(email);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.closeConnection();
        }
        return khachhang;
    }

    public static void main(String[] args) {
        CustomerDAO customerDAO = new CustomerDAO();
        List<Customer> customers = customerDAO.getALL();

        for (Customer customer : customers) {
            System.out.println("Customer ID: " + customer.getMaKhachHang());
            System.out.println("Customer Name: " + customer.getHoVaTen());
            // In thông tin khác tương tự
            Cart cart = customer.getCart();
            System.out.println("Product ID: " + cart.getMaSanPham());
            System.out.println("Product Name: " + cart.getTenSanPham());
            // In thông tin giỏ hàng khác tương tự
        }
    }
}
