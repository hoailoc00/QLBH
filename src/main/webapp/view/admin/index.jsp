<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@page import="control.*"%>
<%@page import="model.*" %>
<%@page import = "java.io.*"%>
<%@page import = "java.util.*"%>
<!doctype html>
<html class="no-js" lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Admin</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="apple-touch-icon" href="apple-touch-icon.png">
        <link rel="stylesheet" href="css/vendor.css">
        <link rel="stylesheet" id="theme-style" href="css/app.css">
        <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    </head>
    <body>
        <div class="main-wrapper">
            <div class="app" id="app">
                <header class="header" style="position: fixed">
                    <div class="header-block header-block-collapse d-lg-none d-xl-none">
                        <button class="collapse-btn" id="sidebar-collapse-btn">
                            <i class="fa fa-bars"></i>
                        </button>
                    </div>
                    <div class="header-block header-block-nav">
                        <ul class="nav-profile">
                            <li class="profile dropdown">
                                <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                                    <%
                                    if (session != null && session.getAttribute("account") != null) {
                                    Account loggedInAccount = (Account) session.getAttribute("account");
                                    String loggedInUsername = loggedInAccount.getTenTK();

                                    %>
                                    <span class="name"> <%= loggedInUsername %> </span>
                                    <% }%>
                                </a>

                                <div class="dropdown-menu profile-dropdown-menu" aria-labelledby="dropdownMenu1">
                                    <!--<a class="dropdown-item" href="#">-->
                                    <!--<i class="fa fa-user icon"></i> Profile </a>-->
                                    <!--<div class="dropdown-divider"></div>-->
                                    <a class="dropdown-item" href="../web/dangnhap.jsp">
                                        <i class="fa fa-power-off icon"></i> Logout </a>
                                </div>
                            </li>
                        </ul>
                    </div>
                </header>
                <aside class="sidebar" style="position: fixed">
                    <div class="sidebar-container">
                        <div class="sidebar-header">
                            <div class="brand">
                                <div class="logo" style="background-image: url('img/logo.png'); background-size: contain"></div>Administrator
                            </div>
                        </div>
                        <nav class="menu">
                            <ul class="sidebar-menu metismenu" id="sidebar-menu">
                                <li class="active">
                                    <a href="./PageDirect?page=dashboard">
                                        <i class="fa fa-home"></i> Thống kê </a>
                                </li>
                                <li>
                                    <a href="./PageDirect?page=itemlist">
                                        <i class="fa fa-tag"></i> Quản lí sản phẩm
                                        <!--<i class="fa arrow"></i>-->
                                    </a>
                                    <!--                                    <ul class="sidebar-nav">
                                                                            <li>
                                                                                <a href="./PageDirect?page=itemlist"> Items List </a>
                                                                            </li>
                                                                            <li>
                                                                                <a href="./PageDirect?page=itemeditor"> Item Editor </a>
                                                                            </li>
                                                                        </ul>-->
                                </li>
                                <li>
                                    <a href="./PageDirect?page=customerlist">
                                        <i class="fa fa-group"></i> Quản lí khách hàng 
                                        <!--<i class="fa arrow"></i>-->
                                    </a>
                                    <!--                                    <ul class="sidebar-nav">
                                                                            <li>
                                                                                <a href="./PageDirect?page=customerlist"> Custommer List </a>
                                                                            </li>
                                                                            <li>
                                                                                <a href="./PageDirect?page=customereditor"> Custommer Editor </a>
                                                                            </li>
                                                                        </ul>-->
                                </li>
                                <!--                                <li class="">
                                                                    <a href="./PageDirect?page=employeelist">
                                                                        <i class="fa fa-user"></i> Quản lí nhân viên 
                                                                        <i class="fa arrow"></i>
                                                                    </a>
                                                                                                        <ul class="sidebar-nav">
                                                                                                            <li>
                                                                                                                <a href="./PageDirect?page=employeelist"> Employee List </a>
                                                                                                            </li>
                                                                                                            <li>
                                                                                                                <a href="./PageDirect?page=employeeeditor"> Employee Editor </a>
                                                                                                            </li>
                                                                                                        </ul>
                                                                </li> -->
                                <li>
                                    <a href="./PageDirect?page=supplierlist">
                                        <i class="fa fa-android"></i> Quản lí nhà cung cấp 
                                    </a>
                                </li> 
                                <li>
                                    <a href="./PageDirect?page=billlist">
                                        <i class="fa fa-check"></i> Quản lí hóa đơn 
                                    </a>
                                </li> 
                            </ul>      
                        </nav>
                    </div>
                </aside>
                <div class="sidebar-overlay" id="sidebar-overlay"></div>
                <div class="sidebar-mobile-menu-handle" id="sidebar-mobile-menu-handle"></div>
                <div class="mobile-menu-handle"></div>
                <c:choose>
                    <c:when test="${page=='itemlist'}">
                        <jsp:include page="itemlist.jsp"/>
                    </c:when>       
                    <c:when test="${page=='itemeditor'}">
                        <jsp:include page="itemeditor.jsp"/>
                    </c:when>     
                    <c:when test="${page=='itemupdate'}">
                        <jsp:include page="itemupdate.jsp"/>
                    </c:when>  
                    <c:when test="${page=='employeelist'}">
                        <jsp:include page="employeelist.jsp"/>
                    </c:when>              
                    <c:when test="${page=='employeeeditor'}">
                        <jsp:include page="employeeeditor.jsp"/>
                    </c:when>    
                    <c:when test="${page=='customerlist'}">
                        <jsp:include page="customerlist.jsp"/>
                    </c:when>
                    <c:when test="${page=='customereditor'}">
                        <jsp:include page="customereditor.jsp"/>
                    </c:when>  
                    <c:when test="${page=='customerupdate'}">
                        <jsp:include page="customerupdate.jsp"/>
                    </c:when>  
                    <c:when test="${page=='supplierlist'}">
                        <jsp:include page="supplierlist.jsp"/>
                    </c:when>
                    <c:when test="${page=='suppliereditor'}">
                        <jsp:include page="suppliereditor.jsp"/>
                    </c:when>  
                    <c:when test="${page=='supplierupdate'}">
                        <jsp:include page="supplierupdate.jsp"/>
                    </c:when>
                    <c:when test="${page=='billlist'}">
                        <jsp:include page="billlist.jsp"/>
                    </c:when>
                    <c:when test="${page=='billdetail'}">
                        <jsp:include page="billdetail.jsp"/>
                    </c:when>  
                    <c:when test="${page=='allbill'}">
                        <jsp:include page="allbill.jsp"/>
                    </c:when>
                    <c:otherwise>
                        <jsp:include page="dashboard.jsp"/>
                    </c:otherwise>
                </c:choose>
                <footer class="footer"></footer>
            </div>
        </div>
        <!-- Reference block for JS -->
        <div class="ref" id="ref">
            <div class="color-primary"></div>
            <div class="chart">
                <div class="color-primary"></div>
                <div class="color-secondary"></div>
            </div>
        </div>
        <script>
            (function (i, s, o, g, r, a, m)
            {
                i['GoogleAnalyticsObject'] = r;
                i[r] = i[r] || function ()
                {
                    (i[r].q = i[r].q || []).push(arguments);
                }, i[r].l = 1 * new Date();
                a = s.createElement(o),
                        m = s.getElementsByTagName(o)[0];
                a.async = 1;
                a.src = g;
                m.parentNode.insertBefore(a, m);
            })(window, document, 'script', 'https://www.google-analytics.com/analytics.js', 'ga');
            ga('create', 'UA-80463319-4', 'auto');
            ga('send', 'pageview');
        </script>
        <script src="js/vendor.js"></script>
        <script src="js/app.js"></script>
        <div class="responsive-bootstrap-toolkit">
            <div class="device-xshidden-sm-up"></div>
            <div class="device-sm hidden-xs-down hidden-md-up"></div>
            <div class="device-md hidden-sm-down hidden-lg-up"></div>
            <div class="device-lg hidden-md-down hidden-xl-up"></div>
            <div class="device-xl hidden-lg-down"></div>        
        </div>
        <script>
            var sidebarItems = document.querySelectorAll('.sidebar-menu li');
            sidebarItems.forEach(function (item) {
                item.addEventListener('click', function () {
                    sidebarItems.forEach(function (otherItem) {
                        otherItem.classList.remove('active');
                    });
                    item.classList.add('active');
                });
            });

        </script>
    </body>
</html>
