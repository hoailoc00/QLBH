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
public class taikhoanDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<taikhoan> getALLUser() {
        MysqlConnect mysqlConnect = new MysqlConnect();
        List<taikhoan> ls = new ArrayList<>();
        try {
            String query = "Select * from taikhoan WHERE MaLoaiTaiKhoan = 3 AND isDeleted = 1";
            conn = mysqlConnect.openConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                taikhoan tk = new taikhoan();
                tk.setMaTaiKhoan(rs.getInt(1));
                tk.setTenTaiKhoan(rs.getString(2));
                tk.setMatKhau(rs.getString(3));
                tk.setMaLoaiTaiKhoan(rs.getInt(4));
                tk.setIsDeleted(rs.getInt(5));
                ls.add(tk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.closeConnection();
        }
        return ls;
    }
//    public int getMaTaiKhoanByTen(taikhoan TaiKhoan){
//        MysqlConnect mysqlConnect = new MysqlConnect();
//        taikhoanDAO tkDAO = new taikhoanDAO();
//        List<taikhoan> lstk = tkDAO.getALLUser();
//        for(taikhoan i : lstk){
//            if(TaiKhoan.getTenTaiKhoan().equals(i.getTenTaiKhoan())){
//                return i.getMaTaiKhoan();
//            }
//        }
//        return 0;
//    }
//    public boolean insertTaiKhoan(taikhoan TaiKhoan) {
//        MysqlConnect mysqlConnect = new MysqlConnect();
//        taikhoanDAO tkDAO = new taikhoanDAO();
//        List<taikhoan> lstk = tkDAO.getALLUser();
//        for(taikhoan i : lstk){
//            if(TaiKhoan.getTenTaiKhoan().equals(i.getTenTaiKhoan())){
//                return false;
//            }
//        }
//        String sqlquery = "INSERT INTO taikhoan(TenTaiKhoan,MatKhau,MaLoaiTaiKhoan,isDeleted)"
//                + " VALUES (?,?,?,?)";
//        conn = mysqlConnect.openConnection();
//        try (PreparedStatement ps = conn.prepareStatement(sqlquery)) {
//            ps.setString(1, TaiKhoan.getTenTaiKhoan());
//            ps.setString(2, TaiKhoan.getMatKhau());
//            ps.setInt(3, TaiKhoan.getMaLoaiTaiKhoan());
//            ps.setInt(4, TaiKhoan.getIsDeleted());
//            ps.executeUpdate();
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        } finally {
//            mysqlConnect.closeConnection();
//        }
//        return false;
//    }
//    public static void main(String[] args) {
//        taikhoanDAO tkdao = new taikhoanDAO();
//        List<taikhoan> ls = new ArrayList<taikhoan>();
//        ls= tkdao.getALLUser();
//        System.out.println(ls);
//    }
}
