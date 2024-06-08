/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author PC
 */
public class Account {
    private int MaTK;
    private String TenTK;
    private String MatKhauTK;
    private int MaLoaiTK;
    private int isDel;

    public Account(int MaTK, String TenTK, String MatKhauTK, int MaLoaiTK, int isDel) {
        this.MaTK = MaTK;
        this.TenTK = TenTK;
        this.MatKhauTK = MatKhauTK;
        this.MaLoaiTK = MaLoaiTK;
        this.isDel = isDel;
    }

    public Account() {
    }

    public int getMaTK() {
        return MaTK;
    }

    public void setMaTK(int MaTK) {
        this.MaTK = MaTK;
    }

    public String getTenTK() {
        return TenTK;
    }

    public void setTenTK(String TenTK) {
        this.TenTK = TenTK;
    }

    public String getMatKhauTK() {
        return MatKhauTK;
    }

    public void setMatKhauTK(String MatKhauTK) {
        this.MatKhauTK = MatKhauTK;
    }

    public int getMaLoaiTK() {
        return MaLoaiTK;
    }

    public void setMaLoaiTK(int MaLoaiTK) {
        this.MaLoaiTK = MaLoaiTK;
    }

    public int getIsDel() {
        return isDel;
    }

    public void setIsDel(int isDel) {
        this.isDel = isDel;
    }
    public boolean isAdmin() {
        return MaLoaiTK == 1 || MaLoaiTK == 2; // Kiểm tra xem MaLoaiTK có phải là 1 không (admin)
    }
    @Override
    public String toString() {
        return "Account{" + "MaTK=" + MaTK + ", TenTK=" + TenTK + ", MatKhauTK=" + MatKhauTK + ", MaLoaiTK=" + MaLoaiTK + ", isDel=" + isDel + '}';
    }
    
    
    
    
}
