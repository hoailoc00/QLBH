/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author PC
 */
public class Customer {
    private int MaKhachHang;
    private String HoVaTen;
    private String GioiTinh;
    private String SoDienThoai;
    private String DiaChi;
    private String Email;
    private int MaTaiKhoan;
    private int isDeleted;
    private Cart cart;

    public Customer(int MaKhachHang, String HoVaTen, String GioiTinh, String SoDienThoai, String DiaChi, String Email, int MaTaiKhoan, int isDeleted, Cart cart) {
        this.MaKhachHang = MaKhachHang;
        this.HoVaTen = HoVaTen;
        this.GioiTinh = GioiTinh;
        this.SoDienThoai = SoDienThoai;
        this.DiaChi = DiaChi;
        this.Email = Email;
        this.MaTaiKhoan = MaTaiKhoan;
        this.isDeleted = isDeleted;
        this.cart = cart;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }
    public Customer() {
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public int getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(int MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public String getHoVaTen() {
        return HoVaTen;
    }

    public void setHoVaTen(String HoVaTen) {
        this.HoVaTen = HoVaTen;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getMaTaiKhoan() {
        return MaTaiKhoan;
    }

    public void setMaTaiKhoan(int MaTaiKhoan) {
        this.MaTaiKhoan = MaTaiKhoan;
    }

    @Override
    public String toString() {
        return "Customer{" + "MaKhachHang=" + MaKhachHang + ", HoVaTen=" + HoVaTen + ", GioiTinh=" + GioiTinh + ", SoDienThoai=" + SoDienThoai + ", DiaChi=" + DiaChi + ", Email=" + Email + ", MaTaiKhoan=" + MaTaiKhoan + '}';
    }
    
    
    
}
