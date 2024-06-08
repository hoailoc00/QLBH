/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Acer
 */
public class topsanpham {
    public int MaSanPham;
    public String  TenSanPham;
    public String HinhAnh;
    public double GiaBan;
    public double TongDoanhThu;
    public int SoLuongDaBan;

    public topsanpham() {
    }

    public topsanpham(int MaSanPham, String TenSanPham, String HinhAnh, double GiaBan, double TongDoanhThu, int SoLuongDaBan) {
        this.MaSanPham = MaSanPham;
        this.TenSanPham = TenSanPham;
        this.HinhAnh = HinhAnh;
        this.GiaBan = GiaBan;
        this.TongDoanhThu = TongDoanhThu;
        this.SoLuongDaBan = SoLuongDaBan;
    }
    
    public String getPathHinhAnh(){
        String path = HinhAnh;
        String rppath = path.replace("\\", "/");
        return rppath;
    }
    public int getMaSanPham() {
        return MaSanPham;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public double getGiaBan() {
        return GiaBan;
    }

    public double getTongDoanhThu() {
        return TongDoanhThu;
    }

    public int getSoLuongDaBan() {
        return SoLuongDaBan;
    }

    public void setMaSanPham(int MaSanPham) {
        this.MaSanPham = MaSanPham;
    }

    public void setTenSanPham(String TenSanPham) {
        this.TenSanPham = TenSanPham;
    }

    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
    }

    public void setGiaBan(double GiaBan) {
        this.GiaBan = GiaBan;
    }

    public void setTongDoanhThu(double TongDoanhThu) {
        this.TongDoanhThu = TongDoanhThu;
    }

    public void setSoLuongDaBan(int SoLuongDaBan) {
        this.SoLuongDaBan = SoLuongDaBan;
    }

    @Override
    public String toString() {
        return "topsanpham{" + "MaSanPham=" + MaSanPham + ", TenSanPham=" + TenSanPham + ", HinhAnh=" + HinhAnh + ", GiaBan=" + GiaBan + ", TongDoanhThu=" + TongDoanhThu + ", SoLuongDaBan=" + SoLuongDaBan + '}';
    }
    
    
}
