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
public class ProductDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Product> getALL() {
        MysqlConnect mysqlConnect = new MysqlConnect();
        List<Product> ls = new ArrayList<>();
        try {
            String query = "SELECT p.MaSanPham, p.TenSanPham, p.GiaNhap,"
                    + " p.GiaBan, p.HinhAnh, p.SoLuong, p.MaLoaiSanPham,"
                    + " p.isDeleted, c.TenLoaiSanPham FROM SanPham p "
                    + "INNER JOIN loaisanpham c ON p.MaLoaiSanPham = c.MaLoaiSanPham";
            conn = mysqlConnect.openConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product item = new Product();
                item.setMaSanPham(rs.getInt(1));
                item.setTenSanPham(rs.getString(2));
                item.setGiaNhap(rs.getDouble(3));
                item.setGiaBan(rs.getDouble(4));
                item.setHinhAnh(rs.getString(5));
                item.setSoLuong(rs.getInt(6));
                item.setMaLoaiSanPham(rs.getInt(7));
                item.setIsDeleted(rs.getInt(8));
                ProductType lsp = new ProductType();
                lsp.setTenLoaiSanPham(rs.getString(9));
                item.setProducttype(lsp);
                ls.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.closeConnection();
        }
        return ls;
    }

    public boolean increaseProductQuantity(int productId, int accountId) {
        MysqlConnect mysqlConnect = new MysqlConnect();
        Product product = getProductById(productId);
        CartDAO cartDAO = new CartDAO();
        int cartQuantity = cartDAO.getQuantityCartByProductIdAndAccountId(productId, accountId);
        if (product != null) {
            int currentQuantity = product.getSoLuong();
            // Cộng 1 vào số lượng sản phẩm
            int newQuantity = currentQuantity + cartQuantity;
            // Cập nhật số lượng mới vào cơ sở dữ liệu
            updateProductQuantity(productId, newQuantity);
            System.out.println("Đã cộng vào số lượng sản phẩm có ID " + productId);
            System.out.println("Newquantity" + newQuantity);
            System.out.println("CurrentQuantity " + currentQuantity);
            System.out.println("cartQuantity " + cartQuantity);
            return true;
        } else {
            System.out.println("Không tìm thấy sản phẩm có ID " + productId);
        }
        return false;
    }

    public boolean decreaseProductQuantityInCart(int productId) {
        MysqlConnect mysqlConnect = new MysqlConnect();

        try {
            String query = "SELECT SoLuong FROM SanPham WHERE MaSanPham = ?";
            conn = mysqlConnect.openConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, productId);
            rs = ps.executeQuery();
            if (rs.next()) {
                int currentQuantity = rs.getInt("SoLuong");
                // Giảm số lượng sản phẩm nếu số lượng hiện tại lớn hơn 0
                if (currentQuantity > 0) {
                    String updateQuery = "UPDATE SanPham SET SoLuong = SoLuong - 1 WHERE MaSanPham = ?";
                    ps = conn.prepareStatement(updateQuery);
                    ps.setInt(1, productId);
                    int rowsAffected = ps.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Đã giảm số lượng sản phẩm có ID " + productId + " trong giỏ hàng");
                        return true;
                    }
                } else {
                    System.out.println("Số lượng sản phẩm đã bằng 0 trong giỏ hàng");
                    return false;
                }
            } else {
                System.out.println("Không tìm thấy sản phẩm có ID " + productId + " trong giỏ hàng");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.closeConnection();
        }
        return false;
    }

    public boolean decreaseProductQuantityInCart(int productId, int quantity) {
        MysqlConnect mysqlConnect = new MysqlConnect();

        try {
            String query = "SELECT SoLuong FROM SanPham WHERE MaSanPham = ?";
            conn = mysqlConnect.openConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, productId);
            rs = ps.executeQuery();
            if (rs.next()) {
                int currentQuantity = rs.getInt("SoLuong");
                // Giảm số lượng sản phẩm nếu số lượng hiện tại lớn hơn 0
                if (currentQuantity > 0) {
                    String updateQuery = "UPDATE SanPham SET SoLuong = SoLuong - ? WHERE MaSanPham = ?";
                    ps = conn.prepareStatement(updateQuery);
                    ps.setInt(1, quantity);
                    ps.setInt(2, productId);
                    int rowsAffected = ps.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Đã giảm số lượng sản phẩm có ID " + productId + " trong giỏ hàng");
                        return true;
                    }
                } else {
                    System.out.println("Số lượng sản phẩm đã bằng 0 trong giỏ hàng");
                    return false;
                }
            } else {
                System.out.println("Không tìm thấy sản phẩm có ID " + productId + " trong giỏ hàng");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.closeConnection();
        }
        return false;
    }

    public Product getProductById(int productId) {
        MysqlConnect mysqlConnect = new MysqlConnect();
        Product product = null;
        try {
            String query = "SELECT * FROM SanPham WHERE MaSanPham = ?";
            conn = mysqlConnect.openConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, productId);

            rs = ps.executeQuery();
            if (rs.next()) {
                // Lấy thông tin từ ResultSet và tạo một đối tượng Product
                int maSP = rs.getInt("MaSanPham");
                String name = rs.getString("TenSanPham");
                double price = rs.getDouble("GiaBan");
                int SoLuong = rs.getInt("SoLuong");

                // Tạo đối tượng Product từ dữ liệu lấy được từ cơ sở dữ liệu
                product = new Product();
                product.setMaSanPham(maSP);
                product.setTenSanPham(name);
                product.setGiaBan(price);
                product.setSoLuong(SoLuong);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.closeConnection();
        }
        return product;
    }

    public boolean updateProductQuantity(int productId, int newQuantity) {
        MysqlConnect mysqlConnect = new MysqlConnect();

        try {
            String query = "UPDATE SanPham SET SoLuong = ? WHERE MaSanPham = ?";
            conn = mysqlConnect.openConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, newQuantity);
            ps.setInt(2, productId);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Đã cập nhật số lượng sản phẩm có ID " + productId + " thành " + newQuantity);
                System.err.println("Soluong" + newQuantity);
                return true;
            } else {
                System.out.println("Không thể cập nhật số lượng sản phẩm có ID " + productId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.closeConnection();
        }
        return false;
    }

    public Product getProductWithCategory(int productId) {
        Product product = null;
        MysqlConnect mysqlConnect = new MysqlConnect();
        conn = mysqlConnect.openConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Thực hiện kết nối đến cơ sở dữ liệu
            // (Thông tin kết nối đến SQL Server, sử dụng JDBC)

            // Chuẩn bị truy vấn để lấy thông tin sản phẩm và loại sản phẩm
            String query = "SELECT p.MaSanPham, p.TenSanPham, p.MaLoaiSanPham, c.TenLoaiSanPham "
                    + "FROM SanPham p "
                    + "INNER JOIN loaisanpham c ON p.MaLoaiSanPham = c.MaLoaiSanPham "
                    + "WHERE p.MaSanPham = ?";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, productId);

            // Thực hiện truy vấn
            resultSet = preparedStatement.executeQuery();

            // Xử lý kết quả
            if (resultSet.next()) {
                product = new Product();
                product.setMaSanPham(resultSet.getInt("MaSanPham"));
                product.setTenSanPham(resultSet.getString("TenSanPham"));
                product.setMaLoaiSanPham(resultSet.getInt("MaLoaiSanPham"));

                ProductType category = new ProductType();
                category.setMaLoaiSanPham(resultSet.getInt("MaLoaiSanPham"));
                category.setTenLoaiSanPham(resultSet.getString("TenLoaiSanPham"));

                // Gán đối tượng Category vào đối tượng Product
                product.setProducttype(category);
//                System.out.println("TenLoaiSanPham: " + category.getTenLoaiSanPham());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.closeConnection();
            // Đóng kết nối và tài nguyên
            // (Chú ý: Trong thực tế, bạn nên sử dụng try-with-resources hoặc đảm bảo đóng tài nguyên đúng cách)
        }
        return product;
    }

    public List<Product> PageLoad(int Index) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT p.MaSanPham, p.TenSanPham, p.GiaNhap, p.GiaBan,\n"
                + "	p.HinhAnh, p.SoLuong, p.MaLoaiSanPham, p.isDeleted,"
                + " c.TenLoaiSanPham FROM SanPham p iNNER JOIN loaisanpham c ON p.MaLoaiSanPham = c.MaLoaiSanPham \n"
                + "	\n"
                + "	ORDER BY MaSanPham OFFSET ? ROWS FETCH NEXT 4 ROWS ONLY";
        try {
            conn = new MysqlConnect().openConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, (Index - 1) * 4);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product item = new Product();
                item.setMaSanPham(rs.getInt(1));
                item.setTenSanPham(rs.getString(2));
                item.setGiaNhap(rs.getDouble(3));
                item.setGiaBan(rs.getDouble(4));
                item.setHinhAnh(rs.getString(5));
                item.setSoLuong(rs.getInt(6));
                item.setMaLoaiSanPham(rs.getInt(7));
                item.setIsDeleted(rs.getInt(8));
                ProductType lsp = new ProductType();
                lsp.setTenLoaiSanPham(rs.getString(9));
                item.setProducttype(lsp);
                list.add(item);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> PageLoadsearch(String txtSearch, int Index) {
        MysqlConnect mysqlConnect = new MysqlConnect();
        List<Product> list = new ArrayList<>();
        String query = "SELECT p.MaSanPham, p.TenSanPham, p.GiaNhap, p.GiaBan,p.HinhAnh, p.SoLuong, p.MaLoaiSanPham, p.isDeleted,"
                + "c.TenLoaiSanPham FROM SanPham p iNNER JOIN loaisanpham c ON p.MaLoaiSanPham = c.MaLoaiSanPham where TenSanPham like ?"
                + "ORDER BY MaSanPham OFFSET ? ROWS FETCH NEXT 4 ROWS ONLY";
        try {
            conn = new MysqlConnect().openConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");

            ps.setInt(2, (Index - 1) * 4);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product item = new Product();
                item.setMaSanPham(rs.getInt(1));
                item.setTenSanPham(rs.getString(2));
                item.setGiaNhap(rs.getDouble(3));
                item.setGiaBan(rs.getDouble(4));
                item.setHinhAnh(rs.getString(5));
                item.setSoLuong(rs.getInt(6));
                item.setMaLoaiSanPham(rs.getInt(7));
                item.setIsDeleted(rs.getInt(8));
                ProductType lsp = new ProductType();
                lsp.setTenLoaiSanPham(rs.getString(9));
                item.setProducttype(lsp);
                list.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.closeConnection();
        }
        return list;
    }

    public List<Product> danhmuc() {
        MysqlConnect mysqlConnect = new MysqlConnect();
        List<Product> list = new ArrayList<>();
        String query = "SELECT p.MaSanPham, p.TenSanPham, p.GiaNhap, p.GiaBan, p.HinhAnh, p.SoLuong, p.MaLoaiSanPham, p.isDeleted, c.TenLoaiSanPham"
                + "FROM SanPham p"
                + "INNER JOIN loaisanpham c ON p.MaLoaiSanPham = c.MaLoaiSanPham"
                + "WHERE p.MaLoaiSanPham = 1  ";
        try {
            conn = new MysqlConnect().openConnection();
            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();
            while (rs.next()) {
                Product item = new Product();
                item.setMaSanPham(rs.getInt(1));
                item.setTenSanPham(rs.getString(2));
                item.setGiaNhap(rs.getDouble(3));
                item.setGiaBan(rs.getDouble(4));
                item.setHinhAnh(rs.getString(5));
                item.setSoLuong(rs.getInt(6));
                item.setMaLoaiSanPham(rs.getInt(7));
                item.setIsDeleted(rs.getInt(8));
                ProductType lsp = new ProductType();
                lsp.setTenLoaiSanPham(rs.getString(9));
                item.setProducttype(lsp);
                list.add(item);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.closeConnection();
        }

        return list;
    }

    public List<Product> danhmucnuoc() {
        MysqlConnect mysqlConnect = new MysqlConnect();
        List<Product> list = new ArrayList<>();
        String query = "SELECT p.MaSanPham, p.TenSanPham, p.GiaNhap, p.GiaBan, p.HinhAnh, p.SoLuong, p.MaLoaiSanPham, p.isDeleted, c.TenLoaiSanPham"
                + "FROM SanPham p"
                + "INNER JOIN loaisanpham c ON p.MaLoaiSanPham = c.MaLoaiSanPham"
                + "WHERE p.MaLoaiSanPham = 2  ";
        try {
            conn = new MysqlConnect().openConnection();
            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();
            while (rs.next()) {
                Product item = new Product();
                item.setMaSanPham(rs.getInt(1));
                item.setTenSanPham(rs.getString(2));
                item.setGiaNhap(rs.getDouble(3));
                item.setGiaBan(rs.getDouble(4));
                item.setHinhAnh(rs.getString(5));
                item.setSoLuong(rs.getInt(6));
                item.setMaLoaiSanPham(rs.getInt(7));
                item.setIsDeleted(rs.getInt(8));
                ProductType lsp = new ProductType();
                lsp.setTenLoaiSanPham(rs.getString(9));
                item.setProducttype(lsp);
                list.add(item);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.closeConnection();
        }

        return list;
    }

    public int getSanPhamSearch(String txtSearch) {
        MysqlConnect mysqlConnect = new MysqlConnect();
        String query = "select count(*) from SanPham where TenSanPham like ?";
        try {
            conn = new MysqlConnect().openConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.closeConnection();
        }
        return 0;
    }

    public int getSanPham() {
        String query = "select count(*) from SanPham";
        try {
            conn = new MysqlConnect().openConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public static void main(String[] args) {
        ProductDAO spdao = new ProductDAO();
        boolean test = spdao.increaseProductQuantity(4, 4);
        System.out.println("TenLoaiSanPham: " + test);

    }

}
