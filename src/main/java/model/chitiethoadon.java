/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Acer
 */
public class chitiethoadon {
    public int MaHoaDon;
    public int MaSanPham;
    public int SoLuong;
    public double GiaTien;

    public chitiethoadon() {
    }

    
    public chitiethoadon(int MaHoaDon, int MaSanPham, int SoLuong, double GiaTien) {
        this.MaHoaDon = MaHoaDon;
        this.MaSanPham = MaSanPham;
        this.SoLuong = SoLuong;
        this.GiaTien = GiaTien;
    }

    public int getMaHoaDon() {
        return MaHoaDon;
    }

    public int getMaSanPham() {
        return MaSanPham;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public double getGiaTien() {
        return GiaTien;
    }

    public void setMaHoaDon(int MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public void setMaSanPham(int MaSanPham) {
        this.MaSanPham = MaSanPham;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public void setGiaTien(double GiaTien) {
        this.GiaTien = GiaTien;
    }

    @Override
    public String toString() {
        return "chitiethoadon{" + "MaHoaDon=" + MaHoaDon + ", MaSanPham=" + MaSanPham + ", SoLuong=" + SoLuong + ", GiaTien=" + GiaTien + '}';
    }
    
    
}
