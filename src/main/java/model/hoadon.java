/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.xml.crypto.Data;
import java.util.Date;
import  java.time.*;
/**
 *
 * @author Acer
 */
public class hoadon {
    public int MaHoaDon;
    public Date NgayLap;
    public double TongTien;
    public int MaNhanVien;
    public int MaKhachHang;
    public int TrangThai;
    public int MaVoucher;
    public chitiethoadon ChiTietHoaDon;

    public hoadon() {
    }

    public hoadon(int MaHoaDon, Date NgayLap, double TongTien, int MaNhanVien, int MaKhachHang, int TrangThai, int MaVoucher) {
        this.MaHoaDon = MaHoaDon;
        this.NgayLap = NgayLap;
        this.TongTien = TongTien;
        this.MaNhanVien = MaNhanVien;
        this.MaKhachHang = MaKhachHang;
        this.TrangThai = TrangThai;
        this.MaVoucher = MaVoucher;
    }

    public int getMaHoaDon() {
        return MaHoaDon;
    }

    public Date getNgayLap() {
        return NgayLap;
    }

    public double getTongTien() {
        return TongTien;
    }

    public int getMaNhanVien() {
        return MaNhanVien;
    }

    public int getMaKhachHang() {
        return MaKhachHang;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public int getMaVoucher() {
        return MaVoucher;
    }

    public void setMaHoaDon(int MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public void setNgayLap(Date NgayLap) {
        this.NgayLap = NgayLap;
    }

    public void setTongTien(double TongTien) {
        this.TongTien = TongTien;
    }

    public void setMaNhanVien(int MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public void setMaKhachHang(int MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public void setMaVoucher(int MaVoucher) {
        this.MaVoucher = MaVoucher;
    }

    public chitiethoadon getChiTietHoaDon() {
        return ChiTietHoaDon;
    }

    public void setChiTietHoaDon(chitiethoadon ChiTietHoaDon) {
        this.ChiTietHoaDon = ChiTietHoaDon;
    }

    @Override
    public String toString() {
        return "hoadon{" + "MaHoaDon=" + MaHoaDon + ", NgayLap=" + NgayLap + ", TongTien=" + TongTien + ", MaNhanVien=" + MaNhanVien + ", MaKhachHang=" + MaKhachHang + ", TrangThai=" + TrangThai + ", MaVoucher=" + MaVoucher + ", ChiTietHoaDon=" + ChiTietHoaDon + '}';
    }

    
    
    
    
}
