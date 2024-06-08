/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.Date;
import  java.time.*;
/**
 *
 * @author Acer
 */
public class phieunhap {
    public int MaPhieuNhap;
    public Date NgayLap;
    public double TongTien;
    public int MaNhanVien;
    public int MaNhaCungCap;

    public phieunhap() {
    }

    public phieunhap(int MaPhieuNhap, Date NgayLap, double TongTien, int MaNhanVien, int MaNhaCungCap) {
        this.MaPhieuNhap = MaPhieuNhap;
        this.NgayLap = NgayLap;
        this.TongTien = TongTien;
        this.MaNhanVien = MaNhanVien;
        this.MaNhaCungCap = MaNhaCungCap;
    }

    public int getMaPhieuNhap() {
        return MaPhieuNhap;
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

    public int getMaNhaCungCap() {
        return MaNhaCungCap;
    }

    public void setMaPhieuNhap(int MaPhieuNhap) {
        this.MaPhieuNhap = MaPhieuNhap;
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

    public void setMaNhaCungCap(int MaNhaCungCap) {
        this.MaNhaCungCap = MaNhaCungCap;
    }

    @Override
    public String toString() {
        return "phieunhap{" + "MaPhieuNhap=" + MaPhieuNhap + ", NgayLap=" + NgayLap + ", TongTien=" + TongTien + ", MaNhanVien=" + MaNhanVien + ", MaNhaCungCap=" + MaNhaCungCap + '}';
    }
    
    
}
