/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Acer
 */
public class danhmuc {
    public int MaDanhMuc;
    public String TenDanhMuc;
    public int isDeleted;

    public danhmuc() {
    }

    public danhmuc(int MaDanhMuc, String TenDanhMuc, int isDeleted) {
        this.MaDanhMuc = MaDanhMuc;
        this.TenDanhMuc = TenDanhMuc;
        this.isDeleted = isDeleted;
    }

    public int getMaDanhMuc() {
        return MaDanhMuc;
    }

    public String getTenDanhMuc() {
        return TenDanhMuc;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setMaDanhMuc(int MaDanhMuc) {
        this.MaDanhMuc = MaDanhMuc;
    }

    public void setTenDanhMuc(String TenDanhMuc) {
        this.TenDanhMuc = TenDanhMuc;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "danhmuc{" + "MaDanhMuc=" + MaDanhMuc + ", TenDanhMuc=" + TenDanhMuc + ", isDeleted=" + isDeleted + '}';
    }
    
    
}
