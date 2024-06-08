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
 * @author Acer
 */
public class loaisanphamDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    
    public List<loaisanpham> getALL() {
        MysqlConnect mysqlConnect = new MysqlConnect();
        List<loaisanpham> ls = new ArrayList<>();
        try {
            String query = "Select * from loaisanpham";
            conn = mysqlConnect.openConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                loaisanpham lsp = new loaisanpham();
                lsp.setMaLoaiSanPham(rs.getInt(1));
                lsp.setTenLoaiSanPham(rs.getString(2));
                lsp.setMaDanhMuc(rs.getInt(3));
                lsp.setIsDeleted(rs.getInt(4));
                ls.add(lsp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.closeConnection();
        }
        return ls;
    }
    public loaisanpham getloaiSanPhambyID(int MaLoaiSanPham){
        MysqlConnect mysqlConnect = new MysqlConnect();
        loaisanpham loaiSanpham = null;
        String sqlquery = "SELECT * FROM loaisanpham WHERE MaLoaiSanPham = ?";
        conn = mysqlConnect.openConnection();
        try(PreparedStatement ps = conn.prepareStatement(sqlquery)) {
            ps.setInt(1, MaLoaiSanPham);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    loaiSanpham = new loaisanpham();
                    loaiSanpham.setMaLoaiSanPham(rs.getInt("MaLoaiSanPham"));
                    loaiSanpham.setTenLoaiSanPham(rs.getString("TenLoaiSanPham"));
                    loaiSanpham.setMaDanhMuc(rs.getInt("MaDanhMuc"));
                    loaiSanpham.setIsDeleted(rs.getInt("isDeleted"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.closeConnection();
        }
        return loaiSanpham;
    }
}
