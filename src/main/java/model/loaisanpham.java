/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Acer
 */
public class loaisanpham {
    public int MaLoaiSanPham;
    public String TenLoaiSanPham;
    public int MaDanhMuc;
    public int isDeleted;

    public loaisanpham() {
    }

    public loaisanpham(int MaLoaiSanPham, String TenLoaiSanPham, int MaDanhMuc, int isDeleted) {
        this.MaLoaiSanPham = MaLoaiSanPham;
        this.TenLoaiSanPham = TenLoaiSanPham;
        this.MaDanhMuc = MaDanhMuc;
        this.isDeleted = isDeleted;
    }

    public int getMaLoaiSanPham() {
        return MaLoaiSanPham;
    }

    public String getTenLoaiSanPham() {
        return TenLoaiSanPham;
    }

    public int getMaDanhMuc() {
        return MaDanhMuc;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setMaLoaiSanPham(int MaLoaiSanPham) {
        this.MaLoaiSanPham = MaLoaiSanPham;
    }

    public void setTenLoaiSanPham(String TenLoaiSanPham) {
        this.TenLoaiSanPham = TenLoaiSanPham;
    }

    public void setMaDanhMuc(int MaDanhMuc) {
        this.MaDanhMuc = MaDanhMuc;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "loaisanpham{" + "MaLoaiSanPham=" + MaLoaiSanPham + ", TenLoaiSanPham=" + TenLoaiSanPham + ", MaDanhMuc=" + MaDanhMuc + ", isDeleted=" + isDeleted + '}';
    }
    
    
}
