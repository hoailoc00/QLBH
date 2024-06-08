/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Acer
 */
public class topkhachhang {
    public int MaKhachHang;
    public String TenKhachHang;
    public int SoLuongSanPham;
    public Double TongTien;

    public topkhachhang(int MaKhachHang, String TenKhachHang, int SoLuongSanPham, Double TongTien) {
        this.MaKhachHang = MaKhachHang;
        this.TenKhachHang = TenKhachHang;
        this.SoLuongSanPham = SoLuongSanPham;
        this.TongTien = TongTien;
    }

    

    public topkhachhang() {
    }

    public int getMaKhachHang() {
        return MaKhachHang;
    }

    public int getSoLuongSanPham() {
        return SoLuongSanPham;
    }

    public Double getTongTien() {
        return TongTien;
    }

    public void setMaKhachHang(int MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public void setSoLuongSanPham(int SoLuongSanPham) {
        this.SoLuongSanPham = SoLuongSanPham;
    }

    public void setTongTien(Double TongTien) {
        this.TongTien = TongTien;
    }

    public String getTenKhachHang() {
        return TenKhachHang;
    }

    public void setTenKhachHang(String TenKhachHang) {
        this.TenKhachHang = TenKhachHang;
    }

    @Override
    public String toString() {
        return "topkhachhang{" + "MaKhachHang=" + MaKhachHang + ", TenKhachHang=" + TenKhachHang + ", SoLuongSanPham=" + SoLuongSanPham + ", TongTien=" + TongTien + '}';
    }
    

    
    
    
}
