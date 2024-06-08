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
public class CategoryDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public List<Category> getALLinfor() {
        MysqlConnect mysqlConnect = new MysqlConnect();
        List<Category> ls = new ArrayList<>();
        try {
            String query = "SELECT DanhMuc.*, LoaiSanPham.*, SanPham.* " +
                           "FROM DanhMuc " +
                           "INNER JOIN LoaiSanPham ON DanhMuc.MaDanhMuc = LoaiSanPham.MaDanhMuc " +
                           "INNER JOIN SanPham ON LoaiSanPham.MaLoaiSanPham = SanPham.MaLoaiSanPham";
            conn = mysqlConnect.openConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Category cate = new Category();
                cate.setMaDanhMuc(rs.getInt(1));
                cate.setTenDanhMuc(rs.getString(2));
                cate.setIsDeleted(rs.getInt(3));
                ProductType typeitem = new ProductType();
                typeitem.setMaLoaiSanPham(rs.getInt(4));
                typeitem.setTenLoaiSanPham(rs.getString(5));
                typeitem.setMaDanhMuc(rs.getInt(6));
                typeitem.setIsDeleted(rs.getInt(7));
                Product item = new Product();
                item.setMaSanPham(rs.getInt(8));
                item.setTenSanPham(rs.getString(9));
                item.setGiaNhap(rs.getDouble(10));
                item.setGiaBan(rs.getDouble(11));
                item.setHinhAnh(rs.getString(12));
                item.setSoLuong(rs.getInt(13));
                item.setIsDeleted(rs.getInt(14));
                cate.setProducttype(typeitem);
                cate.setProduct(item);
                
                ls.add(cate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.closeConnection();
        }
        return ls;
    }
    public Category getProductById(List<Category> listcate, int productId) {
        for (Category cate : listcate) {
            if (cate.getProduct().getMaSanPham() == productId) {
                return cate; // Trả về sản phẩm nếu tìm thấy productId
            }
        }
        return null; // Trả về null nếu không tìm thấy sản phẩm với productId tương ứng
    }
}
