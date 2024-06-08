/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author PC
 */
public class Product {
    private int MaSanPham;
    private String TenSanPham;
    private double GiaNhap;
    private double GiaBan;
    private String HinhAnh;
    private int SoLuong;
    private int MaLoaiSanPham;
    private int isDeleted;
    private ProductType producttype;

    public Product(int MaSanPham, String TenSanPham, double GiaNhap, double GiaBan, String HinhAnh, int SoLuong, int MaLoaiSanPham, int isDeleted, ProductType producttype) {
        this.MaSanPham = MaSanPham;
        this.TenSanPham = TenSanPham;
        this.GiaNhap = GiaNhap;
        this.GiaBan = GiaBan;
        this.HinhAnh = HinhAnh;
        this.SoLuong = SoLuong;
        this.MaLoaiSanPham = MaLoaiSanPham;
        this.isDeleted = isDeleted;
        this.producttype = producttype;
    }

    

    

    public Product() {
        
    }

    public int getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(int MaSanPham) {
        this.MaSanPham = MaSanPham;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String TenSanPham) {
        this.TenSanPham = TenSanPham;
    }

    public double getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(double GiaNhap) {
        this.GiaNhap = GiaNhap;
    }

    public double getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(double GiaBan) {
        this.GiaBan = GiaBan;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getMaLoaiSanPham() {
        return MaLoaiSanPham;
    }

    public void setMaLoaiSanPham(int MaLoaiSanPham) {
        this.MaLoaiSanPham = MaLoaiSanPham;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public ProductType getProducttype() {
        return producttype;
    }

    public void setProducttype(ProductType producttype) {
        this.producttype = producttype;
    }

    @Override
    public String toString() {
        return "Product{" + "MaSanPham=" + MaSanPham + ", TenSanPham=" + TenSanPham + ", GiaNhap=" + GiaNhap + ", GiaBan=" + GiaBan + ", HinhAnh=" + HinhAnh + ", SoLuong=" + SoLuong + ", MaLoaiSanPham=" + MaLoaiSanPham + ", isDeleted=" + isDeleted + '}';
    }

    
    
}
