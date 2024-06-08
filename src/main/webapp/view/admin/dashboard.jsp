<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@page import="control.*"%>
<%@page import="model.*" %>
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
                <li class="active open">
                    <a href="./PageDirect?page=dashboard">
                        <i class="fa fa-home"></i> Dashboard </a>
                </li>
                <li>
                    <a href="">
                        <i class="fa fa-tag"></i> Items Manager <i class="fa arrow"></i>
                    </a>
                    <ul class="sidebar-nav">
                        <li>
                            <a href="./PageDirect?page=itemlist"> Items List </a>
                        </li>
                        <li>
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
<article class="content dashboard-page">
    <section class="section">
        <div class="row sameheight-container">
            <div class="col col-12 col-sm-12 col-md-6 col-xl-5 stats-col">
                <div class="card sameheight-item stats" data-exclude="xs">
                    <div class="card-block">
                        <div class="title-block">
                            <h4 class="title"> Stats </h4></p>
                        </div>
                        <div class="row row-sm stats-container">
                            <div class="col-12 col-sm-6 stat-col">
                                <div class="stat-icon">
                                    <i class="fa fa-rocket"></i>
                                </div>
                                <div class="stat">
                                    <div class="value"> <c:out value="${fn:length(listSP)}" /> </div>
                                    <div class="name"> Sản phẩm </div>
                                </div>
                            </div>
                            <div class="col-12 col-sm-6 stat-col">
                                <div class="stat-icon">
                                    <i class="fa fa-shopping-cart"></i>
                                </div>
                                <div class="stat">
                                    <div class="value"> ${spdaban} </div>
                                    <div class="name"> Sản phẩm đã bán </div>
                                </div>
                            </div>
                            <div class="col-12 col-sm-6  stat-col">
                                <div class="stat-icon">
                                    <i class="fa fa-line-chart"></i>
                                </div>
                                <div class="stat">
                                    <div class="value">
                                        <c:set var="doanhthuthang" value="${doanhthuthang}"/>
                                        <fmt:formatNumber value="${doanhthuthang}" pattern="#,##0"/>đ
                                    </div>
                                    <div class="name"> Doanh thu tháng này </div>   
                                </div>
                            </div>
                            <div class="col-12 col-sm-6  stat-col">
                                <div class="stat-icon">
                                    <i class="fa fa-users"></i>
                                </div>
                                <div class="stat">
                                    <div class="value"> <c:out value="${fn:length(listtk)}" /> </div>
                                    <div class="name"> Tổng số người dùng </div>
                                </div>
                            </div>
                            <div class="col-12 col-sm-6  stat-col">
                                <div class="stat-icon">
                                    <i class="fa fa-list-alt"></i>
                                </div>
                                <div class="stat">
                                    <div class="value"> <c:out value="${fn:length(hd0)}" /> </div>
                                    <div class="name"> Đơn hàng chưa duyệt </div>
                                </div>
                            </div>
                            <div class="col-12 col-sm-6 stat-col">
                                <div class="stat-icon">
                                    <i class="fa fa-dollar"></i>
                                </div>
                                <div class="stat">
                                    <div class="value"> 
                                        <c:set var="tongdoanhthu" value="${tongdoanhthu}"/>
                                        <fmt:formatNumber value="${tongdoanhthu}" pattern="#,##0"/>đ
                                    </div>
                                    <div class="name"> Tổng doanh thu </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--            <div class="col col-12 col-sm-12 col-md-6 col-xl-7 history-col">
                            <div class="card sameheight-item" data-exclude="xs" id="dashboard-history">
                                <div class="card-header card-header-sm bordered">
                                    <div class="header-block">
                                        <h3 class="title">History</h3>
                                    </div>
                                    <ul class="nav nav-tabs pull-right" role="tablist">
                                        <li class="nav-item">
                                            <a class="nav-link active" href="#visits" role="tab" data-toggle="tab">Visits</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="#downloads" role="tab" data-toggle="tab">Downloads</a>
                                        </li>
                                    </ul>
                                </div>
                                <div class="card-block">
                                    <div class="tab-content">
                                        <div role="tabpanel" class="tab-pane active fade show" id="visits">
                                            <p class="title-description"> Number of unique visits last 30 days </p>
                                            <div id="dashboard-visits-chart"></div>
                                        </div>
                                        <div role="tabpanel" class="tab-pane fade" id="downloads">
                                            <p class="title-description"> Number of downloads last 30 days </p>
                                            <div id="dashboard-downloads-chart"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>-->
            <div class="col-xl-7">
                <div class="card sameheight-item items" data-exclude="xs,sm,lg">
                    <div class="card-header bordered">
                        <div class="header-block">
                            <h3 class="title"> Khách hàng mua nhiều nhất </h3>
                        </div>
                    </div>
                    <ul class="item-list striped">
                        <li class="item item-list-header">
                            <div class="item-row">
                                <div class="item-col item-col-header item-col-stats">
                                    <div>
                                        <span>Mã khách hàng</span>
                                    </div>
                                </div>
                                <div class="item-col item-col-header item-col-title">
                                    <div>
                                        <span>Tên khách hàng</span>
                                    </div>
                                </div>
                                <div class="item-col item-col-header item-col-stats">
                                    <div>
                                        <span>Sản phẩm mua</span>
                                    </div>
                                </div>
                                <div class="item-col item-col-header item-col-sales">
                                    <div>
                                        <span>Tổng tiền</span>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <c:forEach var="top5kh" items="${top5kh}">
                            <li class="item">
                                <div class="item-row">
                                    <div class="item-col item-col-stats">
                                        <!--<div class="item-heading">Sales</div>-->
                                        <div> ${top5kh.getMaKhachHang()} </div>
                                    </div>
                                    <div class="item-col item-col-title no-overflow">
                                        <div>
                                            <a href="./PageDirect?page=customerupdate&id=${top5kh.getMaKhachHang()}" class="" style="text-decoration: none">
                                                <h4 class="item-title no-wrap" > ${top5kh.getTenKhachHang()} </h4>
                                            </a>
                                        </div>
                                    </div>
                                    <div class="item-col item-col-stats">
                                        <!--<div class="item-heading">Sales</div>-->
                                        <div> ${top5kh.getSoLuongSanPham()} </div>
                                    </div>
                                    <div class="item-col item-col-sales">
                                        <!--<div class="item-heading">Published</div>-->
                                        <div>
                                            <c:set var="tongtiendamua" value="${top5kh.getTongTien()} "/>
                                            <fmt:formatNumber value="${tongtiendamua}" pattern="#,##0"/>đ
                                        </div>
                                    </div>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
    </section>
    <section class="section">
        <div class="row sameheight-container">
            <div class="col-xl-12">
                <div class="card sameheight-item items" data-exclude="xs,sm,lg">
                    <div class="card-header bordered">
                        <div class="header-block">
                            <h3 class="title"> Best Seller </h3>
                        </div>
                    </div>
                    <ul class="item-list striped">
                        <li class="item item-list-header">
                            <div class="item-row">
                                <div class="item-col item-col-header fixed item-col-img md">
                                    <div>
                                        <span>Hình ảnh</span>
                                    </div>
                                </div>
                                <div class="item-col item-col-header item-col-title">
                                    <div>
                                        <span>Tên sản phẩm</span>
                                    </div>
                                </div>
                                <div class="item-col item-col-header item-col-sales">
                                    <div>
                                        <span>Số lượng đã bán</span>
                                    </div>
                                </div>
                                <div class="item-col item-col-header item-col-sales">
                                    <div class="no-overflow">
                                        <span>Giá bán</span>
                                    </div>
                                </div>
                                <div class="item-col item-col-header item-col-sales">
                                    <div>
                                        <span>Tổng doanh thu</span>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <c:forEach var="top10" items="${top10sp}">
                            <li class="item">
                                <div class="item-row">
                                    <div class="item-col fixed item-col-img md">
                                        <a href="PageDirect?page=itemupdate&id=${top10.getMaSanPham()}">
                                            <div class="item-img xs rounded" style="background-image: url('${top10.getPathHinhAnh()}')"></div>
                                        </a>
                                    </div>
                                    <div class="item-col item-col-title no-overflow">
                                        <div>
                                            <a href="PageDirect?page=itemupdate&id=${top10.getMaSanPham()}" class="" style="text-decoration: none">
                                                <h4 class="item-title no-wrap" > ${top10.getTenSanPham()} </h4>
                                            </a>
                                        </div>
                                    </div>
                                    <div class="item-col item-col-sales">
                                        <!--<div class="item-heading">Sales</div>-->
                                        <div> ${top10.getSoLuongDaBan()} </div>
                                    </div>
                                    <div class="item-col item-col-sales">
                                        <!--<div class="item-heading">Stats</div>-->
                                        <div class="no-overflow">
                                            <!--<div class="item-stats sparkline" data-type="bar"></div>-->
                                            <c:set var="giabantop10" value="${top10.getGiaBan()}"/>
                                            <fmt:formatNumber value="${giabantop10}" pattern="#,##0"/>đ
                                        </div>
                                    </div>
                                    <div class="item-col item-col-sales">
                                        <!--<div class="item-heading">Published</div>-->
                                        <div> 
                                            <c:set var="giabantop10" value="${top10.getTongDoanhThu()}"/>
                                            <fmt:formatNumber value="${giabantop10}" pattern="#,##0"/>đ
                                        </div>
                                    </div>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
    </section>
</article>
