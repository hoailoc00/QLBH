/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import static java.lang.Integer.reverse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

/**
 *
 * @author Acer
 */
public class hoadonDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<hoadon> getALL() {
        MysqlConnect mysqlConnect = new MysqlConnect();
        List<hoadon> ls = new ArrayList<>();
        try {
            String query = "Select * from hoadon";
            conn = mysqlConnect.openConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                hoadon hd = new hoadon();
                hd.setMaHoaDon(rs.getInt(1));
                hd.setNgayLap(rs.getDate(2));
                hd.setTongTien(rs.getDouble(3));
                hd.setMaNhanVien(rs.getInt(4));
                hd.setMaKhachHang(rs.getInt(5));
                hd.setTrangThai(rs.getInt(6));
                hd.setMaVoucher(rs.getInt(7));
                ls.add(hd);
            }
            Collections.sort(ls, Comparator.comparing(hoadon::getNgayLap).reversed());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.closeConnection();
        }
        return ls;
    }

    public List<hoadon> getALLDuyet() {
        MysqlConnect mysqlConnect = new MysqlConnect();
        List<hoadon> ls = new ArrayList<>();
        try {
            String query = "Select * from hoadon WHERE TrangThai = 1";
            conn = mysqlConnect.openConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                hoadon hd = new hoadon();
                hd.setMaHoaDon(rs.getInt(1));
                hd.setNgayLap(rs.getDate(2));
                hd.setTongTien(rs.getDouble(3));
                hd.setMaNhanVien(rs.getInt(4));
                hd.setMaKhachHang(rs.getInt(5));
                hd.setTrangThai(rs.getInt(6));
                hd.setMaVoucher(rs.getInt(7));
                ls.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.closeConnection();
        }
        return ls;
    }

    public List<hoadon> getALLChuaDuyet() {
        MysqlConnect mysqlConnect = new MysqlConnect();
        List<hoadon> ls = new ArrayList<>();
        try {
            String query = "Select * from hoadon WHERE TrangThai = 0";
            conn = mysqlConnect.openConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                hoadon hd = new hoadon();
                hd.setMaHoaDon(rs.getInt(1));
                hd.setNgayLap(rs.getDate(2));
                hd.setTongTien(rs.getDouble(3));
                hd.setMaNhanVien(rs.getInt(4));
                hd.setMaKhachHang(rs.getInt(5));
                hd.setTrangThai(rs.getInt(6));
                hd.setMaVoucher(rs.getInt(7));
                ls.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.closeConnection();
        }
        return ls;
    }

    public boolean denyHoaDon(int MaHoaDon) {
        MysqlConnect mysqlConnect = new MysqlConnect();
        String sqlquery = "UPDATE hoadon SET TrangThai = ? WHERE MaHoaDon = ?";
        conn = mysqlConnect.openConnection();
        try (PreparedStatement ps = conn.prepareStatement(sqlquery)) {
            ps.setInt(1, 2);
            ps.setInt(2, MaHoaDon);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            mysqlConnect.closeConnection();
        }
        return false;
    }

    public boolean acceptHoaDon(int MaHoaDon) {
        MysqlConnect mysqlConnect = new MysqlConnect();
        String sqlquery = "UPDATE hoadon SET TrangThai = ? WHERE MaHoaDon = ?";
        conn = mysqlConnect.openConnection();
        try (PreparedStatement ps = conn.prepareStatement(sqlquery)) {
            ps.setInt(1, 1);
            ps.setInt(2, MaHoaDon);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            mysqlConnect.closeConnection();
        }
        return false;
    }

    public double getTongDoanhThu() {
        List<hoadon> listhd = new ArrayList<hoadon>();
        hoadonDAO hdDAO = new hoadonDAO();
        listhd = hdDAO.getALLDuyet();
        if (listhd == null || listhd.isEmpty()) {
            return 0;
        }
        double TongDoanhThu = 0;
        for (hoadon hd : listhd) {
            TongDoanhThu += hd.getTongTien();
        }
        return TongDoanhThu;
    }

    private static java.time.LocalDate convertToLocalDate(Date date) {
        // Tạo đối tượng Calendar và thiết lập ngày lập từ java.util.Date
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        // Lấy thông tin ngày, tháng, năm từ Calendar
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1; // Tháng bắt đầu từ 0
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // Trả về đối tượng LocalDate
        return java.time.LocalDate.of(year, month, day);
    }

    public double getDoanhThuThang() {
        List<hoadon> listhd = new ArrayList<hoadon>();
        hoadonDAO hdDAO = new hoadonDAO();
        listhd = hdDAO.getALLDuyet();
        if (listhd == null || listhd.isEmpty()) {
            return 0;
        }
        LocalDate currentDate = LocalDate.now();
        int currentMonth = currentDate.getMonthValue();
        double doanhthuthang = 0;
        for (hoadon hd : listhd) {
            Date date = hd.getNgayLap();
            java.time.LocalDate datehd = convertToLocalDate(date);
            int month = datehd.getMonthValue();
            if (month == currentMonth) {
                doanhthuthang += hd.getTongTien();
            }
        }
        return doanhthuthang;
    }

    public List<hoadon> getALLChiTietHoaDon() {
        MysqlConnect mysqlConnect = new MysqlConnect();
        List<hoadon> ls = new ArrayList<>();
        try {
            String query = "SELECT p.MaHoaDon, p.NgayLap, p.TongTien, "
                    + "p.MaNhanVien, p.MaKhachHang, p.MaVoucher, "
                    + "c.MaSanPham, c.SoLuong, c.GiaTien FROM hoadon p "
                    + "INNER JOIN chitiethoadon c ON p.MaHoaDon = c.MaHoaDon WHERE p.TrangThai = 1";
            conn = mysqlConnect.openConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                hoadon hd = new hoadon();
                hd.setMaHoaDon(rs.getInt(1));
                hd.setNgayLap(rs.getDate(2));
                hd.setTongTien(rs.getDouble(3));
                hd.setMaNhanVien(rs.getInt(4));
                hd.setMaKhachHang(rs.getInt(5));
                hd.setMaVoucher(rs.getInt(6));
                chitiethoadon cthd = new chitiethoadon();
                cthd.setMaSanPham(rs.getInt(7));
                cthd.setSoLuong(rs.getInt(8));
                cthd.setGiaTien(rs.getDouble(9));
                hd.setChiTietHoaDon(cthd);
                ls.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.closeConnection();
        }
        return ls;
    }

    public List<hoadon> getChiTietHoaDon(int MaHoaDon) {
        MysqlConnect mysqlConnect = new MysqlConnect();
        List<hoadon> lshd = new ArrayList<>();
        try {
            String query = "SELECT p.MaHoaDon, p.NgayLap, p.TongTien, "
                    + "p.MaNhanVien, p.MaKhachHang, p.MaVoucher, "
                    + "c.MaSanPham, c.SoLuong, c.GiaTien FROM hoadon p "
                    + "INNER JOIN chitiethoadon c ON p.MaHoaDon = c.MaHoaDon WHERE p.MaHoaDon = ?";
            conn = mysqlConnect.openConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, MaHoaDon);
            rs = ps.executeQuery();
            while (rs.next()) {
                hoadon hd = new hoadon();
                hd.setMaHoaDon(rs.getInt(1));
                hd.setNgayLap(rs.getDate(2));
                hd.setTongTien(rs.getDouble(3));
                hd.setMaNhanVien(rs.getInt(4));
                hd.setMaKhachHang(rs.getInt(5));
                hd.setMaVoucher(rs.getInt(6));
                chitiethoadon cthd = new chitiethoadon();
                cthd.setMaSanPham(rs.getInt(7));
                cthd.setSoLuong(rs.getInt(8));
                cthd.setGiaTien(rs.getDouble(9));
                hd.setChiTietHoaDon(cthd);
                lshd.add(hd);
            }
            Collections.sort(lshd, Comparator.comparing(hoadon::getNgayLap).reversed());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.closeConnection();
        }
        return lshd;
    }

    public double soTienDaMua(int MaKhachHang) {
        double tongtien = 0;
        hoadonDAO hddao = new hoadonDAO();
        List<hoadon> hd = new ArrayList<hoadon>();
        hd = hddao.getALLChiTietHoaDon();
        for (hoadon i : hd) {
            if (i.getMaKhachHang() == MaKhachHang) {
                tongtien += i.getChiTietHoaDon().getGiaTien();
            }
        }
        return tongtien;
    }

    public int soSPDaMua(int MaKhachHang) {
        int soSP = 0;
        hoadonDAO hddao = new hoadonDAO();
        List<hoadon> hd = new ArrayList<hoadon>();
        hd = hddao.getALLChiTietHoaDon();
        for (hoadon i : hd) {
            if (i.getMaKhachHang() == MaKhachHang) {
                soSP += i.getChiTietHoaDon().getSoLuong();
            }
        }
        return soSP;
    }

    public List<topkhachhang> top5KhachHang() {
        khachhangDAO khDAO = new khachhangDAO();
        List<khachhang> kh = new ArrayList<khachhang>();
        List<topkhachhang> top = new ArrayList<topkhachhang>();

        kh = khDAO.getALL();
        for (khachhang i : kh) {
            double tongtien = soTienDaMua(i.getMaKhachHang());
            int soSp = soSPDaMua(i.getMaKhachHang());
            topkhachhang topkh = new topkhachhang(i.getMaKhachHang(), i.getHoVaTen(), soSp, tongtien);
            top.add(topkh);
        }
        top.sort(Comparator.comparingDouble(topkhachhang::getTongTien).reversed());
        List<topkhachhang> firstFiveObjects = top.subList(0, Math.min(5, top.size()));
        return firstFiveObjects;
    }

    public int getTongSanPhamDaBan() {
        List<hoadon> listhd = new ArrayList<hoadon>();
        hoadonDAO hdDAO = new hoadonDAO();
        listhd = hdDAO.getALLChiTietHoaDon();
        if (listhd == null || listhd.isEmpty()) {
            return 0;
        }

        int tongdaban = 0;
        for (hoadon hd : listhd) {
            tongdaban += hd.getChiTietHoaDon().getSoLuong();
        }
        return tongdaban;
    }

    public int SLDaBan(int MaSanPham) {
        int soSP = 0;
        hoadonDAO hddao = new hoadonDAO();
        List<hoadon> hd = new ArrayList<hoadon>();
        hd = hddao.getALLChiTietHoaDon();
        for (hoadon i : hd) {
            if (i.getChiTietHoaDon().getMaSanPham() == MaSanPham) {
                soSP += i.getChiTietHoaDon().getSoLuong();
            }
        }
        return soSP;
    }

    public double DoanhThuSP(int MaSanPham) {
        double tongtien = 0;
        hoadonDAO hddao = new hoadonDAO();
        List<hoadon> hd = new ArrayList<hoadon>();
        hd = hddao.getALLChiTietHoaDon();
        for (hoadon i : hd) {
            if (i.getChiTietHoaDon().getMaSanPham() == MaSanPham) {
                tongtien += i.getChiTietHoaDon().getGiaTien();
            }
        }
        return tongtien;
    }

    public List<topsanpham> top10SanPham() {
        SanPhamDAO spDAO = new SanPhamDAO();
        List<SanPham> sp = new ArrayList<SanPham>();
        List<topsanpham> top = new ArrayList<topsanpham>();

        sp = spDAO.getALL();
        for (SanPham i : sp) {
            double tongtien = soTienDaMua(i.getMaSanPham());
            int soSp = soSPDaMua(i.getMaSanPham());
            topsanpham topsp = new topsanpham(i.getMaSanPham(), i.getTenSanPham(), i.getHinhAnh(), i.getGiaBan(), tongtien, soSp);
            top.add(topsp);
        }
        top.sort(Comparator.comparingDouble(topsanpham::getSoLuongDaBan).reversed());
        List<topsanpham> firstTenObjects = top.subList(0, Math.min(10, top.size()));
        return firstTenObjects;

    }
//    public List<SanPham> getTop10(){
//        List<hoadon> lshd = new ArrayList<hoadon>();
//        hoadonDAO hdDAO = new hoadonDAO();
//        lshd = hdDAO.getALLChiTietHoaDon();
//        List<SanPham> lssp = new ArrayList<SanPham>();
//        
//    }

    public static void main(String[] args) {
        hoadonDAO hddao = new hoadonDAO();
        List<topkhachhang> hd = new ArrayList<topkhachhang>();
        hd = hddao.top5KhachHang();
//        double tongtien = hddao.getTongSanPhamDaBan();
        for (topkhachhang i : hd) {
            System.out.println(i);
        }
//        System.out.println(tongtien);

    }

}
