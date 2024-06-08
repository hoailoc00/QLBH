/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author PC
 */
public class ProductType {
    private int MaLoaiSanPham;
    private String TenLoaiSanPham;
    private int MaDanhMuc;
    private int isDeleted;

    public ProductType(int MaLoaiSanPham, String TenLoaiSanPham, int MaDanhMuc, int isDeleted) {
        this.MaLoaiSanPham = MaLoaiSanPham;
        this.TenLoaiSanPham = TenLoaiSanPham;
        this.MaDanhMuc = MaDanhMuc;
        this.isDeleted = isDeleted;
    }

    public ProductType() {
    }

    public int getMaLoaiSanPham() {
        return MaLoaiSanPham;
    }

    public void setMaLoaiSanPham(int MaLoaiSanPham) {
        this.MaLoaiSanPham = MaLoaiSanPham;
    }

    public String getTenLoaiSanPham() {
        return TenLoaiSanPham;
    }

    public void setTenLoaiSanPham(String TenLoaiSanPham) {
        this.TenLoaiSanPham = TenLoaiSanPham;
    }

    public int getMaDanhMuc() {
        return MaDanhMuc;
    }

    public void setMaDanhMuc(int MaDanhMuc) {
        this.MaDanhMuc = MaDanhMuc;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "ProductType{" + "MaLoaiSanPham=" + MaLoaiSanPham + ", TenLoaiSanPham=" + TenLoaiSanPham + ", MaDanhMuc=" + MaDanhMuc + ", isDeleted=" + isDeleted + '}';
    }
    
    
}
