/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Acer
 */
public class khachhang {
    public int MaKhachHang;
    public String HoVaTen;
    public String GioiTinh;
    public String SoDienThoai;
    public String DiaChi;
    public String Email;
    public int MaTaiKhoan;
    public int isDeleted;
    public taikhoan TaiKhoan;
    public khachhang() {
    }

    public khachhang(int MaKhachHang, String HoVaTen, String GioiTinh, String SoDienThoai, String DiaChi, String Email, int MaTaiKhoan, int isDeleted) {
        this.MaKhachHang = MaKhachHang;
        this.HoVaTen = HoVaTen;
        this.GioiTinh = GioiTinh;
        this.SoDienThoai = SoDienThoai;
        this.DiaChi = DiaChi;
        this.Email = Email;
        this.MaTaiKhoan = MaTaiKhoan;
        this.isDeleted = isDeleted;
    }

    public int getMaKhachHang() {
        return MaKhachHang;
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

    public int getMaTaiKhoan() {
        return MaTaiKhoan;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setMaKhachHang(int MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
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

    public void setMaTaiKhoan(int MaTaiKhoan) {
        this.MaTaiKhoan = MaTaiKhoan;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public taikhoan getTaiKhoan() {
        return TaiKhoan;
    }

    public void setTaiKhoan(taikhoan TaiKhoan) {
        this.TaiKhoan = TaiKhoan;
    }

    @Override
    public String toString() {
        return "khachhang{" + "MaKhachHang=" + MaKhachHang + ", HoVaTen=" + HoVaTen + ", GioiTinh=" + GioiTinh + ", SoDienThoai=" + SoDienThoai + ", DiaChi=" + DiaChi + ", Email=" + Email + ", MaTaiKhoan=" + MaTaiKhoan + ", isDeleted=" + isDeleted + ", TaiKhoan=" + TaiKhoan + '}';
    }
    

    
    
    
    
}
