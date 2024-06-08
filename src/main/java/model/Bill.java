/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author PC
 */
public class Bill {
    private int MaHoaDon;
    private Date NgayLap;
    private double TongTien;
    private int MaNhanVien;
    private int MaKhachHang;
    private int TrangThai;
    private int MaVoucher;

    public Bill(int MaHoaDon, Date NgayLap, double TongTien, int MaNhanVien, int MaKhachHang, int TrangThai, int MaVoucher) {
        this.MaHoaDon = MaHoaDon;
        this.NgayLap = NgayLap;
        this.TongTien = TongTien;
        this.MaNhanVien = MaNhanVien;
        this.MaKhachHang = MaKhachHang;
        this.TrangThai = TrangThai;
        this.MaVoucher = MaVoucher;
    }

    

    public Bill() {
    }

    public int getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(int MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public Date getNgayLap() {
        return NgayLap;
    }

    public void setNgayLap(Date NgayLap) {
        this.NgayLap = NgayLap;
    }

    public double getTongTien() {
        return TongTien;
    }

    public void setTongTien(double TongTien) {
        this.TongTien = TongTien;
    }

    public int getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(int MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public int getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(int MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public int getMaVoucher() {
        return MaVoucher;
    }

    public void setMaVoucher(int MaVoucher) {
        this.MaVoucher = MaVoucher;
    }

    @Override
    public String toString() {
        return "Bill{" + "MaHoaDon=" + MaHoaDon + ", NgayLap=" + NgayLap + ", TongTien=" + TongTien + ", MaNhanVien=" + MaNhanVien + ", MaKhachHang=" + MaKhachHang + ", TrangThai=" + TrangThai + ", MaVoucher=" + MaVoucher + '}';
    }

    
    
    
}
