<%-- 
    Document   : shop
    Created on : Oct 30, 2023, 10:18:48 AM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "model.*"%>
<%@page import = "java.io.*"%>
<%@page import = "java.util.*"%>

<head>
    <style>
        /* Style cho khung modal */
        .modal {
            display: none; /* Ẩn ban đầu */
            position: fixed;
            z-index: 1;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: rgba(0, 0, 0, 0.4); /* Màu nền mờ */
        }
        .moda {
            display: none; /* Ẩn ban đầu */
            position: fixed;
            z-index: 1;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: rgba(0, 0, 0, 0.4); /* Màu nền mờ */
        }

        /* Nội dung của khung modal */
        .modal-content {
            background-color: #fefefe;
            margin: 15% auto; /* Canh giữa theo chiều dọc */
            padding: 20px;
            border: 1px solid #888;
            width: 40%; /* Kích thước khung modal */
        }

        /* Nút đóng modal */
        .close {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }

        .close:hover,
        .close:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;
        }
        /* ... (các style cũ) ... */

        /* Nút đăng nhập */
        .btn-login {
            background-color: #3498db; /* Màu nền cho nút đăng nhập */
            color: white; /* Màu chữ cho nút đăng nhập */
            padding: 10px 20px; /* Kích thước nút */
            margin-right: 10px; /* Khoảng cách giữa các nút */
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        /* Nút hủy */
        .btn-cancel {
            background-color: #e74c3c; /* Màu nền cho nút hủy */
            color: white; /* Màu chữ cho nút hủy */
            padding: 10px 20px; /* Kích thước nút */
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        /* ... (các style cũ) ... */

    </style>
</head>
<!DOCTYPE html>
<!-- Shop Section Begin -->
<section class="shop spad">
    <div class="container">
        <div class="shop__option">
            <div class="row">
                <div class="col-lg-7 col-md-7">
                    <div class="shop__option__search">
                        <form action="search">
                            <select name="category" onchange="redirectToIndex(this.value)">
                                <option name="Categories" value="1"> Categories</option>
                                <option name="Cakes" value="2">Cakes</option>
                                <option name="Beverages" value="3">Beverages</option>

                            </select>
                            <input value="${txtsearch}" type="text" placeholder="Search" name="txtsearch">
                            <button type="submit"><i class="fa fa-search"></i></button>
                        </form>
                    </div>
                </div>
                <div class="col-lg-5 col-md-5">
                    <div class="shop__option__right">
                        <select>
                            <option value="">Default sorting</option>
                            <option value="">A to Z</option>
                            <option value="">1 - 8</option>
                            <option value="">Name</option>
                        </select>
                        <a href="#"><i class="fa fa-list"></i></a>
                        <a href="#"><i class="fa fa-reorder"></i></a>
                    </div>
                </div>
            </div>
        </div>
        <div class="row" id="content">
            <c:forEach var="i" items="${listSP}">
                <c:set var="tontai" value="${i.getIsDeleted()}"/>
                <c:if test="${tontai != 0}">          
                    <div class="col-lg-3 col-md-6 col-sm-6" >

                        <div class="product__item">

                            <div class="product__item__pic set-bg" ><img src="${i.getHinhAnh()}">
                                <div class="product__label">
                                    <span>${i.getProducttype().getTenLoaiSanPham()}</span>
                                </div>
                            </div>
                            <div class="product__item__text">
                                <h6><a href="#">${i.getTenSanPham()}</a></h6>
                                <div class="product__item__price"><fmt:formatNumber value="${i.getGiaBan()}" pattern="#,##0"/>đ</div>
                                <div class="cart_add">
                                    <button onclick="addToCart(${i.getMaSanPham()})">Add to Cart</button>
                                </div>
                            </div>

                        </div>

                    </div>

                </c:if>
            </c:forEach>
            
            <c:forEach var="i" items="${listSPsearch}">
                <c:set var="tontai" value="${i.getIsDeleted()}"/>
                <c:if test="${tontai != 0}">          
                    <div class="col-lg-3 col-md-6 col-sm-6" >

                        <div class="product__item">

                            <div class="product__item__pic set-bg" ><img src="${i.getHinhAnh()}">
                                <div class="product__label">
                                    <span>${i.getProducttype().getTenLoaiSanPham()}</span>
                                </div>
                            </div>
                            <div class="product__item__text">
                                <h6><a href="#">${i.getTenSanPham()}</a></h6>
                                <div class="product__item__price"><fmt:formatNumber value="${i.getGiaBan()}" pattern="#,##0"/>đ</div>
                                <div class="cart_add">
                                    <button onclick="addToCart(${i.getMaSanPham()})">Add to Cart</button>
                                </div>
                            </div>

                        </div>

                    </div>

                </c:if>
            </c:forEach>
            
        </div>

        <div class="shop__last__option">
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-6">
                    
                        <div class="shop__pagination">
                            <c:forEach begin="1" end="${endP}" var="i">
                            <a href="listProduct?Index=${i}" value="${i}">${i}</a> 
                             </c:forEach>
                            <c:forEach begin="1" end="${listSearch}" var="i">
                            <a href="listProduct?Indexsearch=${i}&txtsearch=${checksearch}&${endP==0}" value="${i}">${i}</a> 
                             </c:forEach>
                        </div>
                </div>
                <div class="col-lg-6 col-md-6 col-sm-6">
                    <div class="shop__last__text">
                        <p>Showing 1-9 of 10 results</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Shop Section End -->
<div id="myModal" class="modal">
    <div class="modal-content">
        <span class="close" onclick="closeConfirmation()">&times;</span>
        <div class="text_addsp" style="text-align: center"><p>Vui lòng đăng nhập để thêm sản phẩm vào giỏ hàng.</p></div>

        <div class="button-container" style="text-align: center">
            <button class="btn-login" onclick="redirectToLogin()">Đăng nhập</button>
            <button class="btn-cancel" onclick="closeConfirmation()">Hủy</button>
        </div>
    </div>
</div>
<div id="myModa" class="moda">
    <div class="modal-content">
        <span class="close" onclick="closeConfirmatio()">&times;</span>
        <div class="text_addsp" style="text-align: center"><p>Sản phẩm đã hết hàng!</p></div>

        <div class="button-container" style="text-align: center">
            <button class="btn-cancel" onclick="closeConfirmatio()">Tiếp tục mua</button>
        </div>
    </div>
</div>
<!-- Include jQuery library -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script>
                function showConfirmation() {
                    var modal = document.getElementById('myModal');
                    modal.style.display = 'block';
                }
                function showConfirmatio() {
                    var modal = document.getElementById('myModa');
                    modal.style.display = 'block';
                }
                // Close confirmation modal
                function closeConfirmation() {
                    var modal = document.getElementById('myModal');
                    modal.style.display = 'none';
                }
                function closeConfirmatio() {
                    var modal = document.getElementById('myModa');
                    modal.style.display = 'none';
                }
                // Redirect to login page
                function redirectToLogin() {
                    // Redirect to login page
                    window.location.href = 'dangnhap.jsp';
                }
                // Function to add product to cart using AJAX
                function addToCart(productId) {
                    var accountId = '<%= (session.getAttribute("account") != null) ? ((Account)session.getAttribute("account")).getMaTK() : null %>';

                    if (accountId !== null && accountId !== "null") {
                        $.ajax({
                            url: 'AddToCartServlet',
                            type: 'POST',
                            data: {productId: productId, accountId: accountId},
                            success: function (response) {
                                console.log(accountId);
                                if (response === "success") {
                                    alert('Product added to cart!');

                                } else {
                                    showConfirmatio();
                                }
                            },
                            error: function (xhr, status, error) {

                                console.log(accountId);
                            }
                        });
                    } else {
                        showConfirmation();

                    }
                }
                function redirectToIndex(category) {
                    if (category === "1") {
                        window.location.href = "pagecontrol?page=shop";
                    }
                    if (category === "2") {
                        window.location.href = "category";
                    }
                    if (category === "3") {
                        window.location.href = "category1";
                    }
                }
</script>