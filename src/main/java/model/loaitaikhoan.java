/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Acer
 */
public class loaitaikhoan {
    public int MaLoaiTaiKhoan;
    public String TenLoaiTaiKhoan;
    public String MoTa;
    public int isDeleted;

    public loaitaikhoan() {
    }

    public loaitaikhoan(int MaLoaiTaiKhoan, String TenLoaiTaiKhoan, String MoTa, int isDeleted) {
        this.MaLoaiTaiKhoan = MaLoaiTaiKhoan;
        this.TenLoaiTaiKhoan = TenLoaiTaiKhoan;
        this.MoTa = MoTa;
        this.isDeleted = isDeleted;
    }

    public int getMaLoaiTaiKhoan() {
        return MaLoaiTaiKhoan;
    }

    public String getTenLoaiTaiKhoan() {
        return TenLoaiTaiKhoan;
    }

    public String getMoTa() {
        return MoTa;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setMaLoaiTaiKhoan(int MaLoaiTaiKhoan) {
        this.MaLoaiTaiKhoan = MaLoaiTaiKhoan;
    }

    public void setTenLoaiTaiKhoan(String TenLoaiTaiKhoan) {
        this.TenLoaiTaiKhoan = TenLoaiTaiKhoan;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "loaitaikhoan{" + "MaLoaiTaiKhoan=" + MaLoaiTaiKhoan + ", TenLoaiTaiKhoan=" + TenLoaiTaiKhoan + ", MoTa=" + MoTa + ", isDeleted=" + isDeleted + '}';
    }
    
    
}
