/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Acer
 */
public class nhacungcap {
    public int MaNhaCungCap;
    public String TenNhaCungCap;
    public String DiaChi;
    public String SoDienThoai;
    public int isDeleted;

    public nhacungcap() {
    }

    public nhacungcap(int MaNhaCungCap, String TenNhaCungCap, String DiaChi, String SoDienThoai, int isDeleted) {
        this.MaNhaCungCap = MaNhaCungCap;
        this.TenNhaCungCap = TenNhaCungCap;
        this.DiaChi = DiaChi;
        this.SoDienThoai = SoDienThoai;
        this.isDeleted = isDeleted;
    }

    public int getMaNhaCungCap() {
        return MaNhaCungCap;
    }

    public String getTenNhaCungCap() {
        return TenNhaCungCap;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setMaNhaCungCap(int MaNhaCungCap) {
        this.MaNhaCungCap = MaNhaCungCap;
    }

    public void setTenNhaCungCap(String TenNhaCungCap) {
        this.TenNhaCungCap = TenNhaCungCap;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "nhacungcap{" + "MaNhaCungCap=" + MaNhaCungCap + ", TenNhaCungCap=" + TenNhaCungCap + ", DiaChi=" + DiaChi + ", SoDienThoai=" + SoDienThoai + ", isDeleted=" + isDeleted + '}';
    }
    
    
}
