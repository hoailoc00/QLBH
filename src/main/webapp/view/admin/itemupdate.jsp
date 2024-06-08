<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@page import="control.*"%>
<%@page import = "java.io.*"%>
<%@page import = "java.util.*"%>
<!--<aside class="sidebar" style="position: fixed">
    <div class="sidebar-container">
        <div class="sidebar-header">
            <div class="brand">
                <div class="logo" style="background-image: url('../img/logo.png'); background-size: contain"></div>Administrator
            </div>
        </div>
        <nav class="menu">
            <ul class="sidebar-menu metismenu" id="sidebar-menu">
                <li>
                    <a href="./PageDirect?page=dashboard">
                        <i class="fa fa-home"></i> Dashboard </a>
                </li>
                <li class="active open">
                    <a href="">
                        <i class="fa fa-tag"></i> Items Manager <i class="fa arrow"></i>
                    </a>
                    <ul class="sidebar-nav">
                        <li>
                            <a href="./PageDirect?page=itemlist"> Items List </a>
                        </li>
                        <li class="active">
                            <a href="./PageDirect?page=itemeditor"> Item Editor </a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="">
                        <i class="fa fa-group"></i> Custommer Manager <i class="fa arrow"></i>
                    </a>
                    <ul class="sidebar-nav">
                        <li>
                            <a href="./PageDirect?page=customerlist"> Custommer List </a>
                        </li>
                        <li>
                            <a href="./PageDirect?page=customereditor"> Custommer Editor </a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="">
                        <i class="fa fa-user"></i> Employee Manager <i class="fa arrow"></i>
                    </a>
                    <ul class="sidebar-nav">
                        <li>
                            <a href="./PageDirect?page=employeelist"> Employee List </a>
                        </li>
                        <li>
                            <a href="./PageDirect?page=employeeeditor"> Employee Editor </a>
                        </li>
                    </ul>
                </li> 
            </ul>
        </nav>
    </div>
</aside>
<div class="sidebar-overlay" id="sidebar-overlay"></div>
<div class="sidebar-mobile-menu-handle" id="sidebar-mobile-menu-handle"></div>
<div class="mobile-menu-handle"></div>-->
<article class="content item-editor-page">
    <div class="title-block" style="display: flex">
        <h3 class="title"> Chỉnh sửa sản phẩm
            <a href="#" class="btn btn-primary btn-sm rounded-s" id="goBackButton"> Quay lại</a>
        </h3>
        
    </div>
    <form name="item" id="UpdateSanPham">
        <div class="card card-block">
            <div class="form-group row">
                <label class="col-sm-2 form-control-label text-xs-right"> ID : </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control boxed" value="${ctsp.getMaSanPham()}" readonly=""  id="MaSanPham">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 form-control-label text-xs-right"> Tên sản phẩm :  </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control boxed" placeholder="" id="TenSanPham" value="${ctsp.getTenSanPham()}" required>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 form-control-label text-xs-right"> Giá Nhập : </label>
                <div class="col-sm-10">
                    <c:set var="gianhap" value="${ctsp.getGiaNhap()}"/>
                    <input type="text" class="form-control boxed" placeholder="" id="GiaNhap" value="<fmt:formatNumber value="${gianhap}" pattern="###0.#" />" required>
                </div>
            </div>
            <div class="form-group row">
                <c:set var="giaban" value="${ctsp.getGiaBan()}"/>
                <label class="col-sm-2 form-control-label text-xs-right"> Giá Bán : </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control boxed" placeholder="" id="GiaBan" value="<fmt:formatNumber value="${giaban}" pattern="###0.#" />" required>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 form-control-label text-xs-right"> Hình ảnh : </label>
                <div class="col-sm-10">
                    <div class="images-container">
                        <div class="image-container">
                            <div class="controls">
                                <!--
                                --><a href="#" class="control-btn remove" data-toggle="modal" data-target="#confirm-modal">
                                    <i class="fa fa-trash-o"></i>
                                </a>
                            </div>
                            <div class="image" data-image-url="../${ctsp.getPathHinhAnh()}" 
                                 style="background-image:url('../${ctsp.getPathHinhAnh()}')" required></div>
                        </div>
                        <a href="#" class="add-image" data-toggle="modal" data-target="#modal-media">
                            <div class="image-container new">
                                <div class="image">
                                    <i class="fa fa-plus"></i>
                                </div>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 form-control-label text-xs-right"> Số lượng : </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control boxed" placeholder="" id="SoLuong" value="${ctsp.getSoLuong()}" required>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 form-control-label text-xs-right"> Loại sản phẩm </label>
                <div class="col-sm-10">
                    <select class="c-select form-control boxed" id="LoaiSanPham" required>
                        <option selected>Chọn loại sản phảm</option>
                        <c:forEach var="listlsp" items="${lslsp}">
                            <c:set var="lsp" value="${listlsp.getMaLoaiSanPham()}" />
                            <c:set var="lspsp" value="${ctsp.getMaLoaiSanPham()}" />
                            <c:choose>
                                <c:when test="${lsp == lspsp}">
                                    <option value="${listlsp.getMaLoaiSanPham()}" selected>${listlsp.getTenLoaiSanPham()}</option>
                                </c:when> 
                                <c:otherwise>
                                    <option value="${listlsp.getMaLoaiSanPham()}">${listlsp.getTenLoaiSanPham()}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="form-group row">
                <div class="col-sm-10 col-sm-offset-2">
                    <button type="submit" class="btn btn-primary"> Lưu </button>
                </div>
            </div>
        </div>
    </form>
</article>
<script>
    function goBack() {
        window.history.back();
    }
    document.getElementById("goBackButton").addEventListener("click", goBack);
    $(document).ready(function () {
        $("#UpdateSanPham").submit(function (e) {
            e.preventDefault();

//                    var MaSanPham = $('#MaSanPham').val();
            var action = "UpdateSanPham";
            var MaSanPham = $('#MaSanPham').val();
            var TenSanPham = $('#TenSanPham').val();
            var GiaNhap = $('#GiaNhap').val();
            var GiaBan = $('#GiaBan').val();
            var imageElement = document.querySelector('.image');
            var HinhAnh = imageElement.getAttribute('data-image-url');
            var SoLuong = $('#SoLuong').val();
            var LoaiSanPham = document.getElementById("LoaiSanPham").value;

            $.ajax({
                type: "POST",
                url: "Update",
                data: {
                    MaSanPham: MaSanPham,
                    action: action,
                    TenSanPham: TenSanPham,
                    GiaNhap: GiaNhap,
                    GiaBan: GiaBan,
                    HinhAnh: HinhAnh,
                    SoLuong: SoLuong,
                    LoaiSanPham: LoaiSanPham
                },
                success: function (response, status, xhr) {
                    if (response === 'success') {
                        alert("Đã sửa thành công!");
                        window.location.href = "./PageDirect?page=itemlist";
//                        console.log(TenSanPham);
//                        console.log(GiaNhap);
//                        console.log(GiaBan);
//                        console.log(HinhAnh);
//                        console.log(SoLuong);
//                        console.log(LoaiSanPham);
                        // Thêm mã JavaScript ở đây nếu cần
                    } else {
                        alert("Sửa thất bại!");
                    }
                },
                error: function () {
//                    console.log(TenSanPham);
//                    console.log(GiaNhap);
//                    console.log(GiaBan);
//                    console.log(HinhAnh);
//                    console.log(SoLuong);
//                    console.log(LoaiSanPham);
                    alert("Error in Ajax request!");
                }
            });
        });
    });
//    function AddItem() {
////        var MaSanPham = $('#MaSanPham').val();
//        var TenSanPham = $('#TenSanPham').val();
//        var GiaNhap = $('#GiaNhap').val();
//        var GiaBan = $('#GiaBan').val();
//        var imageElement = document.querySelector('.image');
//        var HinhAnh = imageElement.getAttribute('data-image-url');
//        var SoLuong = $('#SoLuong').val();
//        var LoaiSanPham = document.getElementById("LoaiSanPham").value;
//        $.ajax({
//            type: "POST",
//            url: "/views/admin/PageDirect",
//            data: {
////                MaSanPham : MaSanPham,
//                TenSanPham: TenSanPham,
//                GiaNhap: GiaNhap,
//                GiaBan: GiaBan,
//                HinhAnh: HinhAnh,
//                SoLuong: SoLuong,
//                LoaiSanPham: LoaiSanPham
//            },
//            success: function (response) {
//                if (response === 'success') {
//                    alert("Product added successfully!");
//                }
//            },
//            error: function (error) {
//                console.error(error);
//                console.log(TenSanPham);
//                console.log(GiaNhap);
//                console.log(GiaBan);
//                console.log(HinhAnh);
//                console.log(SoLuong);
//                console.log(LoaiSanPham);
//                alert("Error adding product: " + error.responseText);
//            }
//        });
//    }
</script>