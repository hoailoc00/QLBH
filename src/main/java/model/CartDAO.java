/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class CartDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Cart> getALL() {
        MysqlConnect mysqlConnect = new MysqlConnect();
        List<Cart> ls = new ArrayList<>();
        try {
            String query = "SELECT k.MaKhachHang, k.MaSanPham, k.TenSanPham,"
                    + " k.SoLuong, k.GiaTien, p.GiaNhap, p.GiaBan, p.HinhAnh, p.MaLoaiSanPham,"
                    + " p.isDeleted FROM giohang k "
                    + "INNER JOIN SanPham p ON k.MaSanPham = p.MaSanPham";
            conn = mysqlConnect.openConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cart item = new Cart();
                item.setMaKhachHang(rs.getInt(1));
                item.setMaSanPham(rs.getInt(2));
                item.setTenSanPham(rs.getString(3));
                item.setSoLuong(rs.getInt(4));
                item.setGiaTien(rs.getDouble(5));
                Product pt = new Product();
                pt.setGiaNhap(rs.getDouble(6));
                pt.setGiaBan(rs.getDouble(7));
                pt.setHinhAnh(rs.getString(8));
                pt.setMaLoaiSanPham(rs.getInt(9));
                pt.setIsDeleted(rs.getInt(10));
                item.setProductcart(pt);
                ls.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.closeConnection();
        }
        return ls;
    }

    public List<Cart> getALLBill(int accountId) {
        MysqlConnect mysqlConnect = new MysqlConnect();
        CustomerDAO customerDAO = new CustomerDAO();
        Customer khachhang = customerDAO.getCustomerIdByAccountId(accountId);
        List<Cart> ls = new ArrayList<>();
        try {
            String query = "SELECT k.MaKhachHang, k.MaSanPham, k.TenSanPham,"
                    + " k.SoLuong, k.GiaTien, h.MaHoaDon, h.NgayLap, h.TongTien, h.MaNhanVien,"
                    + " h.TrangThai, h.MaVoucher FROM giohang k "
                    + "INNER JOIN hoadon h ON k.MaKhachHang = h.MaKhachHang"
                    + " WHERE k.MaKhachHang = ?";
            conn = mysqlConnect.openConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, khachhang.getMaKhachHang());
            rs = ps.executeQuery();
            while (rs.next()) {
                Cart item = new Cart();
                item.setMaKhachHang(rs.getInt(1));
                item.setMaSanPham(rs.getInt(2));
                item.setTenSanPham(rs.getString(3));
                item.setSoLuong(rs.getInt(4));
                item.setGiaTien(rs.getDouble(5));
                Bill bill = new Bill();
                bill.setMaHoaDon(rs.getInt(6));
                bill.setNgayLap(rs.getDate(7));
                bill.setTongTien(rs.getDouble(8));
                bill.setMaNhanVien(rs.getInt(9));
                bill.setTrangThai(rs.getInt(10));
                bill.setMaVoucher(rs.getInt(11));
                item.setHoadon(bill);
                ls.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.closeConnection();
        }
        return ls;
    }

    public List<Cart> getCartItemsByCustomerId(int accountId) {
        CustomerDAO customerDAO = new CustomerDAO();
        Customer khachhang = customerDAO.getCustomerIdByAccountId(accountId);
        MysqlConnect mysqlConnect = new MysqlConnect();
        List<Cart> ls = new ArrayList<>();
        try {
            String query = "SELECT * FROM giohang WHERE MaKhachHang = ?";
            conn = mysqlConnect.openConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, khachhang.getMaKhachHang());
            rs = ps.executeQuery();
            while (rs.next()) {
                Cart item = new Cart();

                item.setMaSanPham(rs.getInt(2));
                item.setTenSanPham(rs.getString(3));
                item.setSoLuong(rs.getInt(4));
                item.setGiaTien(rs.getDouble(5));

                ls.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.closeConnection();
        }
        return ls;
    }

    public boolean addToCart(int productId, int accountId) {
        MysqlConnect mysqlConnect = new MysqlConnect();
        int quantity = 1;
        ProductDAO productDAO = new ProductDAO();
        Product product = productDAO.getProductById(productId);

        CustomerDAO customerDAO = new CustomerDAO();
        Customer khachhang = customerDAO.getCustomerIdByAccountId(accountId);
        if (isProductInCart(productId, accountId)) {
            increaseProductQuantity(productId, accountId);
            return true;
        } else {
            String query = "INSERT INTO giohang VALUES (?, ?, ?, ?, ?)";
            conn = mysqlConnect.openConnection();
            try {
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setInt(1, khachhang.getMaKhachHang());
                preparedStatement.setInt(2, product.getMaSanPham());
                preparedStatement.setString(3, product.getTenSanPham());
                preparedStatement.setInt(4, quantity);
                preparedStatement.setDouble(5, product.getGiaBan() * quantity);
                preparedStatement.executeUpdate();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                mysqlConnect.closeConnection();
            }

        }
        return false;
    }

    public boolean addToCart(int productId, int accountId, int quantity) {
        MysqlConnect mysqlConnect = new MysqlConnect();
        ProductDAO productDAO = new ProductDAO();
        Product product = productDAO.getProductById(productId);

        CustomerDAO customerDAO = new CustomerDAO();
        Customer khachhang = customerDAO.getCustomerIdByAccountId(accountId);
        if (isProductInCart(productId, accountId)) {
            increaseProductQuantity(productId, accountId,quantity);
            return true;
        } else {
            String query = "INSERT INTO giohang VALUES (?, ?, ?, ?, ?)";
            conn = mysqlConnect.openConnection();
            try {
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setInt(1, khachhang.getMaKhachHang());
                preparedStatement.setInt(2, product.getMaSanPham());
                preparedStatement.setString(3, product.getTenSanPham());
                preparedStatement.setInt(4, quantity);
                preparedStatement.setDouble(5, product.getGiaBan() * quantity);
                preparedStatement.executeUpdate();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                mysqlConnect.closeConnection();
            }

        }
        return false;
    }

    public boolean isProductInCart(int productId, int accountId) {
        MysqlConnect mysqlConnect = new MysqlConnect();
        ProductDAO productDAO = new ProductDAO();
        Product product = productDAO.getProductById(productId);

        CustomerDAO customerDAO = new CustomerDAO();
        Customer khachhang = customerDAO.getCustomerIdByAccountId(accountId);
        try {
            String query = "SELECT COUNT(*) AS count FROM giohang WHERE MaKhachHang = ? AND MaSanPham = ?";
            conn = mysqlConnect.openConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, khachhang.getMaKhachHang());
            ps.setInt(2, productId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt("count");
                return count > 0; // Trả về true nếu sản phẩm đã có trong giỏ hàng, ngược lại trả về false
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.closeConnection();
        }
        return false; // Mặc định trả về false nếu có lỗi xảy ra
    }

    public boolean increaseProductQuantity(int productId, int accountId) {
        MysqlConnect mysqlConnect = new MysqlConnect();
        ProductDAO productDAO = new ProductDAO();
        Product product = productDAO.getProductById(productId);

        CustomerDAO customerDAO = new CustomerDAO();
        Customer khachhang = customerDAO.getCustomerIdByAccountId(accountId);
        try {
            String query = "UPDATE giohang SET SoLuong = SoLuong + 1 WHERE MaKhachHang = ? AND MaSanPham = ?";
            conn = mysqlConnect.openConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, khachhang.getMaKhachHang());
            ps.setInt(2, productId);
            int rowsAffected = ps.executeUpdate();
            // Nếu số lượng sản phẩm được cập nhật thành công, cập nhật giá tiền
            if (rowsAffected > 0) {
                String updatePriceQuery = "UPDATE giohang SET GiaTien = SoLuong * ? WHERE MaKhachHang = ? AND MaSanPham = ?";
                ps = conn.prepareStatement(updatePriceQuery);
                ps.setDouble(1, product.getGiaBan());
                ps.setInt(2, khachhang.getMaKhachHang());
                ps.setInt(3, productId);
                ps.executeUpdate();

                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.closeConnection();
        }
        return false; // Mặc định trả về false nếu có lỗi xảy ra
    }

    public boolean increaseProductQuantity(int productId, int accountId, int quantity) {
        MysqlConnect mysqlConnect = new MysqlConnect();
        ProductDAO productDAO = new ProductDAO();
        Product product = productDAO.getProductById(productId);

        CustomerDAO customerDAO = new CustomerDAO();
        Customer khachhang = customerDAO.getCustomerIdByAccountId(accountId);
        try {
            String query = "UPDATE giohang SET SoLuong = SoLuong + ? WHERE MaKhachHang = ? AND MaSanPham = ?";
            conn = mysqlConnect.openConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, quantity);
            ps.setInt(2, khachhang.getMaKhachHang());
            ps.setInt(3, productId);
            int rowsAffected = ps.executeUpdate();
            // Nếu số lượng sản phẩm được cập nhật thành công, cập nhật giá tiền
            if (rowsAffected > 0) {
                String updatePriceQuery = "UPDATE giohang SET GiaTien = SoLuong * ? WHERE MaKhachHang = ? AND MaSanPham = ?";
                ps = conn.prepareStatement(updatePriceQuery);
                ps.setDouble(1, product.getGiaBan());
                ps.setInt(2, khachhang.getMaKhachHang());
                ps.setInt(3, productId);
                ps.executeUpdate();

                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.closeConnection();
        }
        return false; // Mặc định trả về false nếu có lỗi xảy ra
    }

    public boolean deleteCartItem(int productId, int accountId) {
        MysqlConnect mysqlConnect = new MysqlConnect();
        CustomerDAO customerDAO = new CustomerDAO();
        Customer khachhang = customerDAO.getCustomerIdByAccountId(accountId);
        boolean deleted = false;

        try {
            String query = "DELETE FROM giohang WHERE MaSanPham = ? AND MaKhachHang = ?";
            Connection conn = mysqlConnect.openConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, productId);
            ps.setInt(2, khachhang.getMaKhachHang());
            int rowsAffected = ps.executeUpdate();

            // Kiểm tra xem hàng đã được xóa thành công hay không
            if (rowsAffected > 0) {
                deleted = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.closeConnection();
        }

        return deleted;
    }

    public int getQuantityCartByProductIdAndAccountId(int productId, int accountId) {
        MysqlConnect mysqlConnect = new MysqlConnect();
        CustomerDAO customerDAO = new CustomerDAO();
        Customer khachhang = customerDAO.getCustomerIdByAccountId(accountId);
        int quantity = 0;

        try {
            String query = "SELECT SoLuong FROM giohang WHERE MaSanPham = ? AND MaKhachHang = ?";
            Connection conn = mysqlConnect.openConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, productId);
            ps.setInt(2, khachhang.getMaKhachHang());
            // Thực thi truy vấn
            rs = ps.executeQuery();

            // Lấy số lượng từ kết quả truy vấn
            if (rs.next()) {
                quantity = rs.getInt("SoLuong");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.closeConnection();
        }

        return quantity;
    }

    public boolean updateQuantity(int productId, int newquantity, int accountId) {
        MysqlConnect mysqlConnect = new MysqlConnect();
        CustomerDAO customerDAO = new CustomerDAO();
        Customer khachhang = customerDAO.getCustomerIdByAccountId(accountId);
        ProductDAO productDAO = new ProductDAO();
        Product product = productDAO.getProductById(productId);
        double giaban = product.getGiaBan();

        double giatien = giaban * newquantity;
        boolean success = false;

        try {
            String query = "UPDATE giohang SET SoLuong = ?, GiaTien = ? WHERE MaSanPham = ? AND MaKhachHang = ?";
            Connection conn = mysqlConnect.openConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, newquantity);
            ps.setDouble(2, giatien);
            ps.setInt(3, productId);
            ps.setInt(4, khachhang.getMaKhachHang());
            int rowsAffected = ps.executeUpdate();

            // Kiểm tra xem hàng đã được xóa thành công hay không
            if (rowsAffected > 0) {
                success = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.closeConnection();
        }

        return success;
    }

    public static void main(String[] args) {
        int productId = 4; // Thay productId bằng mã sản phẩm cần kiểm tra
        int accountId = 4; // Thay accountId bằng mã tài khoản cần kiểm tra
        int quantity = 10;
        CartDAO cartDAO = new CartDAO();
        int soluong = cartDAO.getQuantityCartByProductIdAndAccountId(productId, accountId);
        System.out.println("Quantity: " + soluong);

    }
}
