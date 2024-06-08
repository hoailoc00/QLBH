/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Acer
 */
public class khachhangDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    int accountID;

    public List<khachhang> getALL() {
        MysqlConnect mysqlConnect = new MysqlConnect();
        List<khachhang> ls = new ArrayList<>();
        try {
            String query = "SELECT p.MaKhachHang, p.HoVaTen, p.GioiTinh,"
                    + " p.SoDienThoai, p.DiaChi, p.Email, p.MaTaiKhoan,"
                    + " c.TenTaiKhoan, c.MatKhau, c.MaLoaiTaiKhoan FROM khachhang p "
                    + "INNER JOIN taikhoan c ON p.MaTaiKhoan = c.MaTaiKhoan WHERE p.isDeleted = 1";
            conn = mysqlConnect.openConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                khachhang kh = new khachhang();
                kh.setMaKhachHang(rs.getInt(1));
                kh.setHoVaTen(rs.getString(2));
                kh.setGioiTinh(rs.getString(3));
                kh.setSoDienThoai(rs.getString(4));
                kh.setDiaChi(rs.getString(5));
                kh.setEmail(rs.getString(6));
                kh.setMaTaiKhoan(rs.getInt(7));
                taikhoan tk = new taikhoan();
                tk.setTenTaiKhoan(rs.getString(8));
                tk.setMatKhau(rs.getString(9));
                tk.setMaLoaiTaiKhoan(rs.getInt(10));
                kh.setTaiKhoan(tk);
                ls.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.closeConnection();
        }
        return ls;
    }

    public khachhang getKhachHangbyID(int MaKhachHang) {
        MysqlConnect mysqlConnect = new MysqlConnect();
        khachhang kh = null;
        String sqlquery = "SELECT p.HoVaTen, p.GioiTinh,"
                + " p.SoDienThoai, p.DiaChi, p.Email, p.MaTaiKhoan,"
                + " c.TenTaiKhoan, c.MatKhau, c.MaLoaiTaiKhoan FROM khachhang p "
                + "INNER JOIN taikhoan c ON p.MaTaiKhoan = c.MaTaiKhoan WHERE p.MaKhachHang=? AND p.isDeleted = 1";
        conn = mysqlConnect.openConnection();
        try (PreparedStatement ps = conn.prepareStatement(sqlquery)) {
            ps.setInt(1, MaKhachHang);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    kh = new khachhang();
                    kh.setMaKhachHang(MaKhachHang);
                    kh.setHoVaTen(rs.getString(1));
                    kh.setGioiTinh(rs.getString(2));
                    kh.setSoDienThoai(rs.getString(3));
                    kh.setDiaChi(rs.getString(4));
                    kh.setEmail(rs.getString(5));
                    kh.setMaTaiKhoan(rs.getInt(6));
                    taikhoan tk = new taikhoan();
                    tk.setTenTaiKhoan(rs.getString(7));
                    tk.setMatKhau(rs.getString(8));
                    tk.setMaLoaiTaiKhoan(rs.getInt(9));
                    kh.setTaiKhoan(tk);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.closeConnection();
        }
        return kh;
    }

    public String insertKhachHang(taikhoan TaiKhoan, khachhang Khachhang) throws SQLException {
        MysqlConnect mysqlConnect = new MysqlConnect();
        taikhoanDAO tkDAO = new taikhoanDAO();
        List<taikhoan> lstk = tkDAO.getALLUser();
        for (taikhoan i : lstk) {
            if (TaiKhoan.getTenTaiKhoan().equals(i.getTenTaiKhoan())) {
                return "account existed";
            }
        }
        String sqlquerytk = "INSERT INTO taikhoan(TenTaiKhoan,MatKhau,MaLoaiTaiKhoan,isDeleted)"
                + " VALUES (?,?,?,?)";
        conn = mysqlConnect.openConnection();
        ps = conn.prepareStatement(sqlquerytk, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, TaiKhoan.getTenTaiKhoan());
        ps.setString(2, TaiKhoan.getMatKhau());
        ps.setInt(3, TaiKhoan.getMaLoaiTaiKhoan());
        ps.setInt(4, TaiKhoan.getIsDeleted());
        int affectedRows = ps.executeUpdate();

        if (affectedRows > 0) {
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                accountID = rs.getInt(1);
//                    System.out.println(accountID);
            }
//                System.out.println(accountID);
        } else {
            return "can not create account";
        }

//        System.out.println(accountID);
        String sqlquerykh = "INSERT INTO khachhang(HoVaTen,GioiTinh,SoDienThoai,DiaChi,Email,MaTaiKhoan,isDeleted)"
                + " VALUES (?,?,?,?,?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sqlquerykh)) {
            ps.setString(1, Khachhang.getHoVaTen());
            ps.setString(2, Khachhang.getGioiTinh());
            ps.setString(3, Khachhang.getSoDienThoai());
            ps.setString(4, Khachhang.getDiaChi());
            ps.setString(5, Khachhang.getEmail());
            ps.setInt(6, accountID);
            ps.setInt(7, 1);
//            System.out.println(accountID);
            int result = ps.executeUpdate();
            if (result > 0) {
                return "success";
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            mysqlConnect.closeConnection();
        }
        return "false";
    }

    public boolean updateKhachHang(khachhang KhachHang) {
        MysqlConnect mysqlConnect = new MysqlConnect();
        String sqlquery = "UPDATE khachhang SET HoVaTen = ?, GioiTinh = ?,"
                + " SoDienThoai = ?, DiaChi = ?, Email = ? WHERE MaKhachHang = ?";
        conn = mysqlConnect.openConnection();
        try (PreparedStatement ps = conn.prepareStatement(sqlquery)) {
            ps.setString(1, KhachHang.getHoVaTen());
            ps.setString(2, KhachHang.getGioiTinh());
            ps.setString(3, KhachHang.getSoDienThoai());
            ps.setString(4, KhachHang.getDiaChi());
            ps.setString(5, KhachHang.getEmail());
            ps.setInt(6, KhachHang.getMaKhachHang());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            mysqlConnect.closeConnection();
        }
        return false;
    }

    public boolean deleteKhachHang(int MaKhachHang) {
        MysqlConnect mysqlConnect = new MysqlConnect();
        String sqlquery = "UPDATE khachhang SET isDeleted = ? WHERE MaKhachHang = ?";
        conn = mysqlConnect.openConnection();
        try (PreparedStatement ps = conn.prepareStatement(sqlquery)) {
            ps.setInt(1, 0);
            ps.setInt(2, MaKhachHang);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            mysqlConnect.closeConnection();
        }
        return false;
    }

    public static void main(String[] args) {
        khachhangDAO khdao = new khachhangDAO();
//        List<khachhang> kh = new ArrayList<khachhang>();
//        kh = khdao.getALL();
//        for (khachhang i : kh) {
//            System.out.println(i);
//        }
//        taikhoan tk = new taikhoan();
//        tk.setTenTaiKhoan("user2");
//        tk.setMatKhau("123");
//        tk.setMaLoaiTaiKhoan(3);
//        tk.setIsDeleted(1);
//        khachhang kh = new khachhang();
//        kh.setHoVaTen("User2");
//        kh.setGioiTinh("Nam");
//        kh.setSoDienThoai("1234");
//        kh.setDiaChi("123456");
//        kh.setEmail("user2@gmail.com");
//        kh.setIsDeleted(1);
//        String result = khdao.insertKhachHang(tk, kh);
//        System.out.println(result);
//        

    }
}
