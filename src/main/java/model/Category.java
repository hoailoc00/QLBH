/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author PC
 */
public class Category {
    private int MaDanhMuc;
    private String TenDanhMuc;
    private int isDeleted;
    ProductType producttype;
    Product product;

    public Category(int MaDanhMuc, String TenDanhMuc, int isDeleted, ProductType producttype, Product product) {
        this.MaDanhMuc = MaDanhMuc;
        this.TenDanhMuc = TenDanhMuc;
        this.isDeleted = isDeleted;
        this.producttype = producttype;
        this.product = product;
    }

    

    public Category() {
    }

    public ProductType getProducttype() {
        return producttype;
    }

    public void setProducttype(ProductType producttype) {
        this.producttype = producttype;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getMaDanhMuc() {
        return MaDanhMuc;
    }

    public void setMaDanhMuc(int MaDanhMuc) {
        this.MaDanhMuc = MaDanhMuc;
    }

    public String getTenDanhMuc() {
        return TenDanhMuc;
    }

    public void setTenDanhMuc(String TenDanhMuc) {
        this.TenDanhMuc = TenDanhMuc;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "Category{" + "MaDanhMuc=" + MaDanhMuc + ", TenDanhMuc=" + TenDanhMuc + ", isDeleted=" + isDeleted + '}';
    }
    
    
}
