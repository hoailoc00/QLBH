<%-- 
    Document   : shop_details
    Created on : Nov 4, 2023, 1:26:24 PM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "model.*"%>
<%@page import = "java.io.*"%>
<%@page import = "java.util.*"%>
<!DOCTYPE html>
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

        .icon_close {
            cursor: pointer;
        }
        .quantity-buttons {
            display: flex;
            align-items: center;
        }

        .quantity-buttons div {
            margin: 0 5px;
        }

        .quantity-buttons input[type="number"] {
            width: 50px; /* Điều chỉnh kích thước phù hợp với thiết kế của bạn */
            padding: 5px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

        /* Tùy chỉnh khi input có focus */
        .quantity-buttons input[type="number"]:focus {
            outline: none;
            border-color: #3b88fd;
            box-shadow: 0 0 5px rgba(59, 136, 253, 0.5);
        }
        .update-btn button {
            padding: 10px 20px;
            border: none;
            cursor: pointer;
            background-color: #3b88fd;
            color: white;
            border-radius: 5px;
            font-size: 16px;
        }

        .update-btn button:hover {
            background-color: #3069d9;
        }
        .product__detail__option {
            display: flex;
            align-items: center;
        }

        .quantity {
            margin-right: 15px;
        }

        .quantity-buttons {
            display: flex;
            align-items: center;
        }

        .input-group {

            border-radius: 5px;
            overflow: hidden;
            width: 70px; /* Điều chỉnh chiều rộng input */
        }

        .input-group input {
            width: calc(100% - 30px);
            padding: 5px 10px;
            border: none;
            outline: none;
            float: left;
            font-size: 14px;
            box-sizing: border-box;
        }

        .button-add-to-cart {
            background-color: #4CAF50;
            border: none;
            color: white;
            padding: 8px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
        }

    </style>
</head>
<!-- Shop Details Section Begin -->
<section class="product-details spad">
    <div class="container">

        <div class="row">

            <div class="col-lg-6">
                <div class="product__details__img">
                    <div class="product__details__big__img">
                        <img class="big_img" src="${itemdetail.getProduct().getHinhAnh()}" alt="">
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="product__details__text">
                    <div class="product__label">${itemdetail.getTenDanhMuc()}</div>
                    <h4>${itemdetail.getProduct().getTenSanPham()}</h4>
                    <h5><fmt:formatNumber value="${itemdetail.getProduct().getGiaBan()}" pattern="#,##0"/>đ</h5>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, eiusmod tempor incididunt ut labore
                        et dolore magna aliqua. Quis ipsum suspendisse ultrices gravida</p>
                    <ul>

                        <li>Category: <span>${itemdetail.getProducttype().getTenLoaiSanPham()}</span></li>

                    </ul>
                    <div class="product__detail__option">
                        <div class="quantity">
                            <div class="quantity-buttons">
                                <div class="input-group">
                                    <input type="number" value="1" id="quantityInput">
                                </div>
                            </div>
                        </div>
                        <button onclick="addToCart(${itemdetail.getProduct().getMaSanPham()})">Add to Cart</button>
                    </div>

                </div>
            </div>

        </div>
        <div class="product__details__tab">
            <div class="col-lg-12">
                <ul class="nav nav-tabs" role="tablist">
                    <li class="nav-item">
                        <a class="nav-link active" data-toggle="tab" href="#tabs-1" role="tab">Description</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" data-toggle="tab" href="#tabs-2" role="tab">Additional information</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" data-toggle="tab" href="#tabs-3" role="tab">Previews(1)</a>
                    </li>
                </ul>
                <div class="tab-content">
                    <div class="tab-pane active" id="tabs-1" role="tabpanel">
                        <div class="row d-flex justify-content-center">
                            <div class="col-lg-8">
                                <p>This delectable Strawberry Pie is an extraordinary treat filled with sweet and
                                    tasty chunks of delicious strawberries. Made with the freshest ingredients, one
                                    bite will send you to summertime. Each gift arrives in an elegant gift box and
                                    arrives with a greeting card of your choice that you can personalize online!</p>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane" id="tabs-2" role="tabpanel">
                        <div class="row d-flex justify-content-center">
                            <div class="col-lg-8">
                                <p>This delectable Strawberry Pie is an extraordinary treat filled with sweet and
                                    tasty chunks of delicious strawberries. Made with the freshest ingredients, one
                                    bite will send you to summertime. Each gift arrives in an elegant gift box and
                                    arrives with a greeting card of your choice that you can personalize online!2
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane" id="tabs-3" role="tabpanel">
                        <div class="row d-flex justify-content-center">
                            <div class="col-lg-8">
                                <p>This delectable Strawberry Pie is an extraordinary treat filled with sweet and
                                    tasty chunks of delicious strawberries. Made with the freshest ingredients, one
                                    bite will send you to summertime. Each gift arrives in an elegant gift box and
                                    arrives with a greeting card of your choice that you can personalize online!3
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Shop Details Section End -->
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
<!-- Related Products Section Begin -->
<section class="related-products spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="section-title">
                    <h2>Related Products</h2>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="related__products__slider owl-carousel">
                <c:forEach var="i" items="${listSP}">
                    <c:set var="tontai" value="${i.getIsDeleted()}"/>
                    <c:if test="${tontai != 0}">
                        <div class="col-lg-3">

                            <div class="product__item">
                                <div class="product__item__pic set-bg" >
                                    <a href="pagecontrol?page=shop_details&productId=${i.getMaSanPham()}">
                                        <img src="${i.getHinhAnh()}">
                                    </a>
                                    <div class="product__label">
                                        <span>${i.getProducttype().getTenLoaiSanPham()}</span>
                                    </div>
                                </div>
                                <div class="product__item__text">
                                    <h6><a href="pagecontrol?page=shop_details&productId=${i.getMaSanPham()}">${i.getTenSanPham()}</a></h6>
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
        </div>
    </div>

</section>
<!-- Related Products Section End -->
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
        // Lấy giá trị số lượng từ trường input
        var quantity = parseInt(document.getElementById("quantityInput").value);
        if (accountId !== null && accountId !== "null") {
            $.ajax({
                url: 'AddToCartServlet',
                type: 'POST',
                data: {productId: productId, accountId: accountId, quantity: quantity},
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

</script>
