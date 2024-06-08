/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Acer
 */
public class taikhoan {
    public int MaTaiKhoan ;
    public String TenTaiKhoan;
    public String MatKhau;
    public int MaLoaiTaiKhoan;
    public int isDeleted;

    public taikhoan() {
    }

    public taikhoan(int MaTaiKhoan, String TenTaiKhoan, String MatKhau, int MaLoaiTaiKhoan, int isDeleted) {
        this.MaTaiKhoan = MaTaiKhoan;
        this.TenTaiKhoan = TenTaiKhoan;
        this.MatKhau = MatKhau;
        this.MaLoaiTaiKhoan = MaLoaiTaiKhoan;
        this.isDeleted = isDeleted;
    }

    public int getMaTaiKhoan() {
        return MaTaiKhoan;
    }

    public String getTenTaiKhoan() {
        return TenTaiKhoan;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public int getMaLoaiTaiKhoan() {
        return MaLoaiTaiKhoan;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setMaTaiKhoan(int MaTaiKhoan) {
        this.MaTaiKhoan = MaTaiKhoan;
    }

    public void setTenTaiKhoan(String TenTaiKhoan) {
        this.TenTaiKhoan = TenTaiKhoan;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public void setMaLoaiTaiKhoan(int MaLoaiTaiKhoan) {
        this.MaLoaiTaiKhoan = MaLoaiTaiKhoan;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "taikhoan{" + "MaTaiKhoan=" + MaTaiKhoan + ", TenTaiKhoan=" + TenTaiKhoan + ", MatKhau=" + MatKhau + ", MaLoaiTaiKhoan=" + MaLoaiTaiKhoan + ", isDeleted=" + isDeleted + '}';
    }
    
    
}
