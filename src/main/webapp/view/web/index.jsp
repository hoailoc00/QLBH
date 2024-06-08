<%-- 
    Document   : index
    Created on : Oct 30, 2023, 9:12:47 AM
    Author     : PC
--%>

<%@page import = "control.*"%>
<%@page import = "java.io.*"%>
<%@page import = "java.util.*"%>
<%@ page import="model.*" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Cake Template">
        <meta name="keywords" content="Cake, unica, creative, html">
        <meta name="ort" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Cake | Template</title>

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@400;500;600;700;800;900&display=swap"
              rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;500;600;700;800;900&display=swap"
              rel="stylesheet">

        <!-- Css Styles -->
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/flaticon.css" type="text/css">
        <link rel="stylesheet" href="css/barfiller.css" type="text/css">
        <link rel="stylesheet" href="css/magnific-popup.css" type="text/css">
        <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
        <link rel="stylesheet" href="css/nice-select.css" type="text/css">
        <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
        <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
        <link rel="stylesheet" href="css/style.css" type="text/css">
    </head>
    <body>
        <!-- Page Preloder -->
        <div id="preloder">
            <div class="loader"></div>
        </div>
        <!-- Offcanvas Menu Begin -->
        <div class="offcanvas-menu-overlay"></div>
        <div class="offcanvas-menu-wrapper">
            <div class="offcanvas__cart">
                <div class="offcanvas__cart__links">
                    <a href="#" class="search-switch"><img src="image/icon/search.png" alt=""></a>
                    <a href="#"><img src="img/icon/heart.png" alt=""></a>
                </div>
                <div class="offcanvas__cart__item">
                    <a href="#"><img src="img/icon/cart.png" alt=""> <span>0</span></a>
                    <div class="cart__price">Cart: <span>$0.00</span></div>
                </div>
            </div>
            <div class="offcanvas__logo">
                <a href="./index.html"><img src="img/logo.png" alt=""></a>
            </div>
            <div id="mobile-menu-wrap"></div>
            <div class="offcanvas__option">
                <ul>
                    <li>USD <span class="arrow_carrot-down"></span>
                        <ul>
                            <li>EUR</li>
                            <li>USD</li>
                        </ul>
                    </li>
                    <li>ENG <span class="arrow_carrot-down"></span>
                        <ul>
                            <li>Spanish</li>
                            <li>ENG</li>
                        </ul>
                    </li>
                    <li><a href="#">Sign in</a> <span class="arrow_carrot-down"></span></li>
                </ul>
            </div>
        </div>
        <!-- Offcanvas Menu End -->
        <!-- Header Section Begin -->

        <header class="header">
            <div class="header__top">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="header__top__inner">
                                <div class="header__top__left">
                                    <ul>
                                        <li>USD <span class="arrow_carrot-down"></span>
                                            <ul>
                                                <li>EUR</li>
                                                <li>USD</li>
                                            </ul>
                                        </li>
                                        <li>ENG <span class="arrow_carrot-down"></span>
                                            <ul>
                                                <li>Spanish</li>
                                                <li>ENG</li>
                                            </ul>
                                        </li>
                                        <%

                                            if (session != null && session.getAttribute("account") != null) {
                                                Account loggedInAccount = (Account) session.getAttribute("account");
                                                String loggedInUsername = loggedInAccount.getTenTK();
                                        %>

                                        <li><%= loggedInUsername %>
                                            <ul>
                                                
                                                <a href="logout"><li>Logout</li></a>
                                                <a href="update"><li>Edit</li></a>
                                            </ul>
                                        </li>

                                        <%
                                            } else {
                                        %>
                                        <li><a href="./dangnhap.jsp">Sign in</a> <span class="arrow_carrot-down"></span>
                                            <ul>
                                                <a href="dangky.jsp"><li>Register</li></a>
                                            </ul>
                                        </li>
                                        <%
                                            }
                                        %>
                                    </ul>
                                </div>
                                <div class="header__logo">
                                    <a href="/QLBH/view/web/pagecontrol"><img src="image/logo.png" alt=""></a>
                                </div>
                                <div class="header__top__right">

                                    <div class="header__top__right__cart">
                                        <a href="./pagecontrol?page=shop_cart&id=user"><img src="image/icon/cart.png" alt=""> <span>0</span></a>
                                        <div class="cart__price">Cart: <span>$0.00</span></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="canvas__open"><i class="fa fa-bars"></i></div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <nav class="header__menu mobile-menu">
                            <ul>
                                <li><a href="./pagecontrol">Home</a></li>
                                <li><a href="./pagecontrol?page=about">About</a></li>
                                <li><a href="./pagecontrol?page=shop">Shop</a></li>
                                <li><a href="#">Pages</a>
                                    <ul class="dropdown">
<!--                                        <li><a href="./pagecontrol?page=shop_details">Shop Details</a></li>-->
                                        <li><%
    
    HttpSession existingSession = request.getSession();
    Account loggedInAccount = (Account) existingSession.getAttribute("account");

    if (loggedInAccount != null) {
        // Nếu đã đăng nhập, chuyển hướng đến trang giỏ hàng
                                            %>
                                            <a href="./pagecontrol?page=shop_cart">Shop Cart</a>
                                            <%
                                                } else {
                                                    // Nếu chưa đăng nhập, hiển thị thông báo và yêu cầu xác nhận
                                            %>
                                            <a href="#" onclick="confirmRedirect()">Shop Cart</a>
                                            <script>
                                                function confirmRedirect() {
                                                    if (confirm('Vui lòng đăng nhập để xem giỏ hàng.')) {
                                                        window.location.href = './dangnhap.jsp';
                                                    }
                                                }
                                            </script>
                                            <%
                                                }
                                            %></li>
                                        <li><a href="./pagecontrol?page=checkout">Check Out</a></li>
                                        <!--                                        <li><a href="./pagecontrol?page=wishlist">Wishlist</a></li>-->
                                        <li><a href="./pagecontrol?page=blog_details">Blog Details</a></li>
                                    </ul>
                                </li>
                                <!--                            <li><a href="./pagecontrol?page=blog">Blog</a></li>-->
                                <li><a href="./pagecontrol?page=contact">Contact</a></li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </header>
        <!-- Header Section End -->
        <div class="home_container">
            <c:choose>
                <c:when test="${page=='shop'}">
                    <jsp:include page="shop.jsp"/>
                </c:when>
                <c:when test="${page=='about'}">
                    <jsp:include page="about.jsp"/>
                </c:when>
                <c:when test="${page=='shop_details'}">
                    <jsp:include page="shop_details.jsp"/>
                </c:when>
                <c:when test="${page=='shop_cart'}">
                    <jsp:include page="shop_cart.jsp"/>
                </c:when>
                <c:when test="${page=='checkout'}">
                    <jsp:include page="checkout.jsp"/>
                </c:when>
                <c:when test="${page=='wishlist'}">
                    <jsp:include page="wishlist.jsp"/>
                </c:when>
                <c:when test="${page=='contact'}">
                    <jsp:include page="contact.jsp"/>
                </c:when>
                <c:when test="${page=='blog'}">
                    <jsp:include page="blog.jsp"/>
                </c:when>
                <c:when test="${page=='blog_details'}">
                    <jsp:include page="blog_details.jsp"/>
                </c:when>
                <c:otherwise >
                    <jsp:include page="home.jsp"/>
                </c:otherwise>

            </c:choose>
        </div>
        <!-- Footer Section Begin -->
        <footer class="footer set-bg" data-setbg="image/footer-bg.jpg">
            <div class="container">
                <div class="row">
                    <div class="col-lg-4 col-md-6 col-sm-6">
                        <div class="footer__widget">
                            <h6>WORKING HOURS</h6>
                            <ul>
                                <li>Monday - Friday: 08:00 am – 08:30 pm</li>
                                <li>Saturday: 10:00 am – 16:30 pm</li>
                                <li>Sunday: 10:00 am – 16:30 pm</li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 col-sm-6">
                        <div class="footer__about">
                            <div class="footer__logo">
                                <a href="#"><img src="image/footer-logo.png" alt=""></a>
                            </div>
                            <p>Lorem ipsum dolor amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut
                                labore dolore magna aliqua.</p>
                            <div class="footer__social">
                                <a href="#"><i class="fa fa-facebook"></i></a>
                                <a href="#"><i class="fa fa-twitter"></i></a>
                                <a href="#"><i class="fa fa-instagram"></i></a>
                                <a href="#"><i class="fa fa-youtube-play"></i></a>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 col-sm-6">
                        <div class="footer__newslatter">
                            <h6>Subscribe</h6>
                            <p>Get latest updates and offers.</p>
                            <form action="#">
                                <input type="text" placeholder="Email">
                                <button type="submit"><i class="fa fa-send-o"></i></button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="copyright">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-7">
                            <p class="copyright__text text-white"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                                Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
                                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                            </p>
                        </div>
                        <div class="col-lg-5">
                            <div class="copyright__widget">
                                <ul>
                                    <li><a href="#">Privacy Policy</a></li>
                                    <li><a href="#">Terms & Conditions</a></li>
                                    <li><a href="#">Site Map</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
        <!--         Footer Section End 
        <!-- Search Begin -->
        <div class="search-model">
            <div class="h-100 d-flex align-items-center justify-content-center">
                <div class="search-close-switch">+</div>
                <form class="search-model-form">
                    <input type="text" id="search-input" placeholder="Search here.....">
                </form>
            </div>
        </div>
        <!-- Search End -->
        Js Plugins 
        -->     <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.nice-select.min.js"></script>
        <script src="js/jquery.barfiller.js"></script><!--
        -->     <script src="js/jquery.magnific-popup.min.js"></script>
        <script src="js/jquery.slicknav.js"></script><!--
        -->     <script src="js/owl.carousel.min.js"></script>
        <script src="js/jquery.nicescroll.min.js"></script>
        <script src="js/main.js"></script>
        <script>
                                    var pt = "${page}";
                                    if (pt.trim() !== '') {
                                        var title = pt.replace(/_/g, ' ').replace(/\b\w/g, function (l) {
                                            return l.toUpperCase();
                                        });
                                        document.title = 'Cake | ' + title;
                                    } else {
                                        document.title = 'Cake ';
                                    }
        </script>
        <script>
            document.addEventListener("DOMContentLoaded", function () {
                var navItems = document.querySelectorAll(".header__menu.mobile-menu li");

                var currentURL = window.location.href;

                var selectedNavItem = "Home"; // Giá trị mặc định là "Home"

                if (currentURL.includes("about")) {
                    selectedNavItem = "About";
                } else if (currentURL.includes("shop")) {
                    selectedNavItem = "Shop";
                } else if (currentURL.includes("page=")) {
                    selectedNavItem = "Pages"; // Nếu có "page=", coi đó là trang "Pages"
                } else if (currentURL.includes("contact")) {
                    selectedNavItem = "Contact";
                }

                navItems.forEach(function (navItem) {
                    if (navItem.textContent.trim() === selectedNavItem) {
                        navItem.classList.add("active");
                    }
                });
            });


        </script>

    </body>
</html>
