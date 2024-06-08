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
        <h3 class="title"> Chỉnh sửa nhà cung cấp 
            <a href="#" class="btn btn-primary btn-sm rounded-s" id="goBackButton"> Quay lại</a>
        </h3>

    </div>
    <form name="item" id="UpdateNhaCungCap">
        <div class="card card-block">
            <div class="form-group row">
                <label class="col-sm-2 form-control-label text-xs-right"> ID : </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control boxed" readonly=""  id="MaNhaCungCap" value="${ncc.getMaNhaCungCap()}">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 form-control-label text-xs-right"> Tên khách Hàng :  </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control boxed" placeholder="" id="TenNhaCungCap" value="${ncc.getTenNhaCungCap()}" required>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 form-control-label text-xs-right"> Địa chỉ : </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control boxed" placeholder="" id="DiaChi" value="${ncc.getDiaChi()}" required>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 form-control-label text-xs-right"> Số điện thoại : </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control boxed" placeholder="" id="SDT" value="${ncc.getSoDienThoai()}"required>
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
        $("#UpdateNhaCungCap").submit(function (e) {
            e.preventDefault();

            var action = "UpdateNhaCungCap";
            var MaNhaCungCap = $('#MaNhaCungCap').val();
            var TenNhaCungCap = $('#TenNhaCungCap').val();
            var DiaChi = $('#DiaChi').val();
            var SDT = $('#SDT').val();

            $.ajax({
                type: "POST",
                url: "Update",
                data:
                        {
                            action: action,
                            MaNhaCungCap: MaNhaCungCap,
                            TenNhaCungCap: TenNhaCungCap,
                            DiaChi: DiaChi,
                            SDT: SDT
                        },

                success: function (response, status, xhr) {
                    if (response === 'success') {
                        alert("Đã sửa thành công!");
                        window.location.href = "./PageDirect?page=supplierlist";
                    } else {
                        alert("Sửa thất bại!");
                    }
                },
                error: function () {
                    alert("Error in Ajax request!");
                }
            });
        });
    });
</script>