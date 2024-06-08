/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Acer
 */
public class nhanvien {
    public int MaNhanVien;
    public String TenTaiKhoan;
    public String HoVaTen;
    public String GioiTinh;
    public String SoDienThoai;
    public String DiaChi;
    public String Email;
    public double LuongCoBan;
    public int isDeleted;

    public nhanvien() {
    }

    public nhanvien(int MaNhanVien, String TenTaiKhoan, String HoVaTen, String GioiTinh, String SoDienThoai, String DiaChi, String Email, double LuongCoBan, int isDeleted) {
        this.MaNhanVien = MaNhanVien;
        this.TenTaiKhoan = TenTaiKhoan;
        this.HoVaTen = HoVaTen;
        this.GioiTinh = GioiTinh;
        this.SoDienThoai = SoDienThoai;
        this.DiaChi = DiaChi;
        this.Email = Email;
        this.LuongCoBan = LuongCoBan;
        this.isDeleted = isDeleted;
    }

    public int getMaNhanVien() {
        return MaNhanVien;
    }

    public String getTenTaiKhoan() {
        return TenTaiKhoan;
    }

    public String getHoVaTen() {
        return HoVaTen;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public String getEmail() {
        return Email;
    }

    public double getLuongCoBan() {
        return LuongCoBan;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setMaNhanVien(int MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public void setTenTaiKhoan(String TenTaiKhoan) {
        this.TenTaiKhoan = TenTaiKhoan;
    }

    public void setHoVaTen(String HoVaTen) {
        this.HoVaTen = HoVaTen;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setLuongCoBan(double LuongCoBan) {
        this.LuongCoBan = LuongCoBan;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "nhanvien{" + "MaNhanVien=" + MaNhanVien + ", TenTaiKhoan=" + TenTaiKhoan + ", HoVaTen=" + HoVaTen + ", GioiTinh=" + GioiTinh + ", SoDienThoai=" + SoDienThoai + ", DiaChi=" + DiaChi + ", Email=" + Email + ", LuongCoBan=" + LuongCoBan + ", isDeleted=" + isDeleted + '}';
    }
    
    
    
}
