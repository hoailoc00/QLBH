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
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Acer
 */
public class SanPhamDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<SanPham> getALL() {
        MysqlConnect mysqlConnect = new MysqlConnect();
        List<SanPham> ls = new ArrayList<>();
        try {
            String query = "SELECT p.MaSanPham, p.TenSanPham, p.GiaNhap,"
                    + " p.GiaBan, p.HinhAnh, p.SoLuong, p.MaLoaiSanPham,"
                    + " p.isDeleted, c.TenLoaiSanPham FROM SanPham p "
                    + "INNER JOIN loaisanpham c ON p.MaLoaiSanPham = c.MaLoaiSanPham";
            conn = mysqlConnect.openConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                SanPham item = new SanPham();
                item.setMaSanPham(rs.getInt(1));
                item.setTenSanPham(rs.getString(2));
                item.setGiaNhap(rs.getDouble(3));
                item.setGiaBan(rs.getDouble(4));
                item.setHinhAnh(rs.getString(5));
                item.setSoLuong(rs.getInt(6));
                item.setMaLoaiSanPham(rs.getInt(7));
                item.setIsDeleted(rs.getInt(8));
                loaisanpham lsp = new loaisanpham();
                lsp.setTenLoaiSanPham(rs.getString(9));
                item.setLoaisanpham(lsp);
                if (item.getIsDeleted() == 1) {
                    ls.add(item);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.closeConnection();
        }
        return ls;
    }

    public SanPham getSanPhambyID(int MaSanPham) {
        MysqlConnect mysqlConnect = new MysqlConnect();
        SanPham sanpham = null;
        String sqlquery = "SELECT * FROM SanPham WHERE MaSanPham = ?";
        conn = mysqlConnect.openConnection();
        try (PreparedStatement ps = conn.prepareStatement(sqlquery)) {
            ps.setInt(1, MaSanPham);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    sanpham = new SanPham();
                    sanpham.setMaSanPham(rs.getInt("MaSanPham"));
                    sanpham.setTenSanPham(rs.getString("TenSanPham"));
                    sanpham.setMaLoaiSanPham(rs.getInt("MaLoaiSanPham"));
                    sanpham.setGiaBan(rs.getInt("GiaBan"));
                    sanpham.setGiaNhap(rs.getInt("GiaNhap"));
                    sanpham.setHinhAnh(rs.getString("HinhAnh"));
                    sanpham.setSoLuong(rs.getInt("SoLuong"));
                    sanpham.setIsDeleted(rs.getInt("isDeleted"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.closeConnection();
        }
        return sanpham;
    }

    public boolean insertSanPham(SanPham sanPham) {
        MysqlConnect mysqlConnect = new MysqlConnect();
        String sqlquery = "INSERT INTO SanPham(TenSanPham,GiaNhap,GiaBan,HinhAnh,SoLuong,MaLoaiSanPham,isDeleted)"
                + " VALUES (?,?,?,?,?,?,?)";
        conn = mysqlConnect.openConnection();
        try (PreparedStatement ps = conn.prepareStatement(sqlquery)) {
            ps.setString(1, sanPham.getTenSanPham());
            ps.setDouble(2, sanPham.getGiaNhap());
            ps.setDouble(3, sanPham.getGiaBan());
            ps.setString(4, sanPham.getHinhAnh());
            ps.setInt(5, sanPham.getSoLuong());
            ps.setInt(6, sanPham.getMaLoaiSanPham());
            ps.setInt(7, sanPham.getIsDeleted());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            mysqlConnect.closeConnection();
        }
        return false;
    }

    public boolean deleteSanPham(int MaSanPham) {
        MysqlConnect mysqlConnect = new MysqlConnect();
        String sqlquery = "UPDATE SanPham SET isDeleted = ? WHERE MaSanPham = ?";
        conn = mysqlConnect.openConnection();
        try (PreparedStatement ps = conn.prepareStatement(sqlquery)) {
            ps.setInt(1, 0);
            ps.setInt(2, MaSanPham);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            mysqlConnect.closeConnection();
        }
        return false;
    }

    public boolean updateSanPham(SanPham sanPham) {
        MysqlConnect mysqlConnect = new MysqlConnect();
        String sqlquery = "UPDATE SanPham SET TenSanPham = ?, GiaNhap = ?,"
                + " GiaBan = ?, HinhAnh = ?, SoLuong = ?, MaLoaiSanPham = ? WHERE MaSanPham = ?";
        conn = mysqlConnect.openConnection();
        try (PreparedStatement ps = conn.prepareStatement(sqlquery)) {
            ps.setString(1, sanPham.getTenSanPham());
            ps.setDouble(2, sanPham.getGiaNhap());
            ps.setDouble(3, sanPham.getGiaBan());
            ps.setString(4, sanPham.getHinhAnh());
            ps.setInt(5, sanPham.getSoLuong());
            ps.setInt(6, sanPham.getMaLoaiSanPham());
            ps.setInt(7, sanPham.getMaSanPham());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            mysqlConnect.closeConnection();
        }
        return false;
    }
//      public List<SanPham> getTop10(){
//          List<SanPham> ls = new ArrayList<>();
//          SanPhamDAO spDAO = new SanPhamDAO();
//          ls = spDAO.getALL();
//          ls.sort( Comparator.comparingInt(SanPham::getSoLuong).reversed());
//          List<SanPham> top10 = ls.subList(0, Math.min(10, ls.size()));
//          return top10;
//      }
//    public List<SanPham> getAllProductsWithCategory() {
//        List<SanPham> productList = new ArrayList<>();
//        MysqlConnect mysqlConnect = new MysqlConnect();
//        conn = mysqlConnect.openConnection();
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//
//        try {
//            // Chuẩn bị truy vấn để lấy thông tin sản phẩm và loại sản phẩm
//            String query = "SELECT p.MaSanPham, p.TenSanPham, p.MaLoaiSanPham, c.TenLoaiSanPham "
//                    + "FROM SanPham p "
//                    + "INNER JOIN loaisanpham c ON p.MaLoaiSanPham = c.MaLoaiSanPham";
//            preparedStatement = conn.prepareStatement(query);
//
//            // Thực hiện truy vấn
//            resultSet = preparedStatement.executeQuery();
//
//            // Xử lý kết quả
//            while (resultSet.next()) {
//                SanPham product = new SanPham();
//                product.setMaSanPham(resultSet.getInt("MaSanPham"));
//                product.setTenSanPham(resultSet.getString("TenSanPham"));
//                product.setMaLoaiSanPham(resultSet.getInt("MaLoaiSanPham"));
//
//                loaisanpham category = new loaisanpham();
//                category.setMaLoaiSanPham(resultSet.getInt("MaLoaiSanPham"));
//                category.setTenLoaiSanPham(resultSet.getString("TenLoaiSanPham"));
//
//                product.setLoaisanpham(category);
//
//                // Thêm sản phẩm vào danh sách
//                productList.add(product);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            mysqlConnect.closeConnection();
//        }
//
//        return productList;
//    }

//    public SanPham getProductWithCategory(int productId) {
//        SanPham product = null;
//        MysqlConnect mysqlConnect = new MysqlConnect();
//        conn = mysqlConnect.openConnection();
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//
//        try {
//            // Thực hiện kết nối đến cơ sở dữ liệu
//            // (Thông tin kết nối đến SQL Server, sử dụng JDBC)
//
//            // Chuẩn bị truy vấn để lấy thông tin sản phẩm và loại sản phẩm
//            String query = "SELECT p.MaSanPham, p.TenSanPham, p.MaLoaiSanPham, c.TenLoaiSanPham "
//                    + "FROM SanPham p "
//                    + "INNER JOIN loaisanpham c ON p.MaLoaiSanPham = c.MaLoaiSanPham "
//                    + "WHERE p.MaSanPham = ?";
//            preparedStatement = conn.prepareStatement(query);
//            preparedStatement.setInt(1, productId);
//
//            // Thực hiện truy vấn
//            resultSet = preparedStatement.executeQuery();
//
//            // Xử lý kết quả
//            if (resultSet.next()) {
//                product = new SanPham();
//                product.setMaSanPham(resultSet.getInt("MaSanPham"));
//                product.setTenSanPham(resultSet.getString("TenSanPham"));
//                product.setMaLoaiSanPham(resultSet.getInt("MaLoaiSanPham"));
//
//                loaisanpham category = new loaisanpham();
//                category.setMaLoaiSanPham(resultSet.getInt("MaLoaiSanPham"));
//                category.setTenLoaiSanPham(resultSet.getString("TenLoaiSanPham"));
//
//                // Gán đối tượng Category vào đối tượng Product
//                product.setLoaisanpham(category);
//
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            mysqlConnect.closeConnection();
//            // Đóng kết nối và tài nguyên
//            // (Chú ý: Trong thực tế, bạn nên sử dụng try-with-resources hoặc đảm bảo đóng tài nguyên đúng cách)
//        }
//        return product;
//    }
    public static void main(String[] args) {
//        SanPhamDAO spdao = new SanPhamDAO();
//        List<SanPham> sp = new ArrayList<SanPham>();
//        sp = spdao.getALL();
//        for(SanPham i : sp){
//            System.out.println(i.getLoaisanpham().getTenLoaiSanPham());
//        }
        SanPham sp = new SanPham();
        sp.setTenSanPham("Bánh");
        sp.setGiaNhap(15000);
        sp.setGiaBan(20000);
        sp.setHinhAnh("twitter/eduardo_olv/128.jpg");
        sp.setSoLuong(30);
        sp.setMaLoaiSanPham(2);
        sp.setIsDeleted(1);
        SanPhamDAO spDAO = new SanPhamDAO();

        boolean addSuccess = spDAO.insertSanPham(sp);

        if (addSuccess) {
            System.out.println("Product added successfully!");

            // Hiển thị danh sách sản phẩm từ cơ sở dữ liệu
//            displayProductList();
        } else {
            System.out.println("Failed to add product!");
        }

    }
}
