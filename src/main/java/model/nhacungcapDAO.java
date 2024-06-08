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
public class nhacungcapDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<nhacungcap> getALL() {
        MysqlConnect mysqlConnect = new MysqlConnect();
        List<nhacungcap> ls = new ArrayList<>();
        try {
            String query = "SELECT * FROM nhacungcap WHERE isDeleted=1";
            conn = mysqlConnect.openConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                nhacungcap ncc = new nhacungcap();
                ncc.setMaNhaCungCap(rs.getInt(1));
                ncc.setTenNhaCungCap(rs.getString(2));
                ncc.setDiaChi(rs.getString(3));
                ncc.setSoDienThoai(rs.getString(4));
                ncc.setIsDeleted(rs.getInt(5));

                ls.add(ncc);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.closeConnection();
        }
        return ls;
    }

    public nhacungcap getNhaCungCapbyID(int MaNhaCungCap) {
        MysqlConnect mysqlConnect = new MysqlConnect();
        nhacungcap ncc = null;
        String sqlquery = "SELECT * FROM nhacungcap WHERE MaNhaCungCap = ?";
        conn = mysqlConnect.openConnection();
        try (PreparedStatement ps = conn.prepareStatement(sqlquery)) {
            ps.setInt(1, MaNhaCungCap);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    ncc = new nhacungcap();
                    ncc.setMaNhaCungCap(rs.getInt(1));
                    ncc.setTenNhaCungCap(rs.getString(2));
                    ncc.setDiaChi(rs.getString(3));
                    ncc.setSoDienThoai(rs.getString(4));
                    ncc.setIsDeleted(rs.getInt(5));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.closeConnection();
        }
        return ncc;
    }

    public boolean insertNhaCungCap(nhacungcap NhaCungCap) {
        MysqlConnect mysqlConnect = new MysqlConnect();
        String sqlquery = "INSERT INTO nhacungcap(TenNhaCungCap,DiaChi,SoDienThoai,isDeleted)"
                + " VALUES (?,?,?,?)";
        conn = mysqlConnect.openConnection();
        try (PreparedStatement ps = conn.prepareStatement(sqlquery)) {
            ps.setString(1, NhaCungCap.getTenNhaCungCap());
            ps.setString(2, NhaCungCap.getDiaChi());
            ps.setString(3, NhaCungCap.getSoDienThoai());
            ps.setInt(4, NhaCungCap.getIsDeleted());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            mysqlConnect.closeConnection();
        }
        return false;
    }

    public boolean deleteNhaCungCap(int MaNhaCungCap) {
        MysqlConnect mysqlConnect = new MysqlConnect();
        String sqlquery = "UPDATE nhacungcap SET isDeleted = ? WHERE MaNhaCungCap = ?";
        conn = mysqlConnect.openConnection();
        try (PreparedStatement ps = conn.prepareStatement(sqlquery)) {
            ps.setInt(1, 0);
            ps.setInt(2, MaNhaCungCap);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            mysqlConnect.closeConnection();
        }
        return false;
    }

    public boolean updateNhaCungCap(nhacungcap NhaCungCap) {
        MysqlConnect mysqlConnect = new MysqlConnect();
        String sqlquery = "UPDATE nhacungcap SET TenNhaCungCap = ?, DiaChi = ?,"
                + " SoDienThoai = ? WHERE MaNhaCungCap = ?";
        conn = mysqlConnect.openConnection();
        try (PreparedStatement ps = conn.prepareStatement(sqlquery)) {
            ps.setString(1, NhaCungCap.getTenNhaCungCap());
            ps.setString(2, NhaCungCap.getDiaChi());
            ps.setString(3, NhaCungCap.getSoDienThoai());
            ps.setInt(4, NhaCungCap.getMaNhaCungCap());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            mysqlConnect.closeConnection();
        }
        return false;
    }
}
