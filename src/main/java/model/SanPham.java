/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Acer
 */
public class SanPham {
    public int MaSanPham;
    public String TenSanPham;
    public double GiaNhap;
    public double GiaBan;
    public String HinhAnh;
    public int SoLuong;
    public int MaLoaiSanPham;
    public int isDeleted;
    public loaisanpham Loaisanpham;

    public SanPham() {
    }

    public SanPham(int MaSanPham, String TenSanPham, double GiaNhap, double GiaBan, String HinhAnh, int SoLuong, int MaLoaiSanPham, int isDeleted) {
        this.MaSanPham = MaSanPham;
        this.TenSanPham = TenSanPham;
        this.GiaNhap = GiaNhap;
        this.GiaBan = GiaBan;
        this.HinhAnh = HinhAnh;
        this.SoLuong = SoLuong;
        this.MaLoaiSanPham = MaLoaiSanPham;
        this.isDeleted = isDeleted;
    }

    public String getPathHinhAnh(){
        String path = HinhAnh;
        String rppath = path.replace("\\", "/");
        return rppath;
    }
    
    
    public int getMaSanPham() {
        return MaSanPham;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public double getGiaNhap() {
        return GiaNhap;
    }

    public double getGiaBan() {
        return GiaBan;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public int getMaLoaiSanPham() {
        return MaLoaiSanPham;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setMaSanPham(int MaSanPham) {
        this.MaSanPham = MaSanPham;
    }

    public void setTenSanPham(String TenSanPham) {
        this.TenSanPham = TenSanPham;
    }

    public void setGiaNhap(double GiaNhap) {
        this.GiaNhap = GiaNhap;
    }

    public void setGiaBan(double GiaBan) {
        this.GiaBan = GiaBan;
    }

    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public void setMaLoaiSanPham(int MaLoaiSanPham) {
        this.MaLoaiSanPham = MaLoaiSanPham;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public loaisanpham getLoaisanpham() {
        return Loaisanpham;
    }

    public void setLoaisanpham(loaisanpham Loaisanpham) {
        this.Loaisanpham = Loaisanpham;
    }

    @Override
    public String toString() {
        return "SanPham{" + "MaSanPham=" + MaSanPham + ", TenSanPham=" + TenSanPham + ", GiaNhap=" + GiaNhap + ", GiaBan=" + GiaBan + ", HinhAnh=" + HinhAnh + ", SoLuong=" + SoLuong + ", MaLoaiSanPham=" + MaLoaiSanPham + ", isDeleted=" + isDeleted + '}';
    }
    
    
}
