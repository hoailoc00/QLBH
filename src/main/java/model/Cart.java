/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class Cart {
    
    private int MaKhachHang;
    private int MaSanPham;
    private String TenSanPham;
    private int SoLuong;
    private double GiaTien;
    private Product productcart;
    private Bill hoadon;

    public Cart(int MaKhachHang, int MaSanPham, String TenSanPham, int SoLuong, double GiaTien, Product productcart, Bill hoadon) {
        this.MaKhachHang = MaKhachHang;
        this.MaSanPham = MaSanPham;
        this.TenSanPham = TenSanPham;
        this.SoLuong = SoLuong;
        this.GiaTien = GiaTien;
        this.productcart = productcart;
        this.hoadon = hoadon;
    }

   

    public Cart() {
    }

    public Bill getHoadon() {
        return hoadon;
    }

    public void setHoadon(Bill hoadon) {
        this.hoadon = hoadon;
    }

    public Product getProductcart() {
        return productcart;
    }

    public void setProductcart(Product productcart) {
        this.productcart = productcart;
    }

    public int getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(int MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public int getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(int MaSanPham) {
        this.MaSanPham = MaSanPham;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String TenSanPham) {
        this.TenSanPham = TenSanPham;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public double getGiaTien() {
        return GiaTien;
    }

    public void setGiaTien(double GiaTien) {
        this.GiaTien = GiaTien;
    }

    @Override
    public String toString() {
        return "Cart{" + "MaKhachHang=" + MaKhachHang + ", MaSanPham=" + MaSanPham + ", TenSanPham=" + TenSanPham + ", SoLuong=" + SoLuong + ", GiaTien=" + GiaTien + '}';
    }
    
    
}
