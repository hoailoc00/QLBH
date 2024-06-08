<%-- 
    Document   : shop_cart
    Created on : Nov 4, 2023, 1:48:51 PM
    Author     : PC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "model.*"%>
<%@page import = "java.io.*"%>
<%@page import = "java.util.*"%>
<!DOCTYPE html>
<head>
    <style>
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

    </style>
</head>
<!-- Shopping Cart Section Begin -->
<section class="shopping-cart spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-8">
                <div class="shopping__cart__table">
                    <table>
                        <thead>
                            <tr>
                                <th>Product</th>
                                <th>Quantity</th>
                                <th>Total</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>

                            <c:forEach var="i" items="${listCart}">
                                <c:set var="customerIdString" value="${i.getMaKhachHang()}" />
                                <c:set var="customerId" value="${customerId}" />
                                <c:if test="${customerIdString == customerId}">
                                    <tr id="cartItem_${product.productId}">
                                        <td class="product__cart__item">
                                            <div class="product__cart__item__pic">
                                                <img style="width:80px ;height: 80px" src="${i.getProductcart().getHinhAnh()}" alt="">
                                            </div>
                                            <div class="product__cart__item__text">
                                                <h6>${i.getTenSanPham()}</h6>
                                                <h5><fmt:formatNumber value="${i.getProductcart().getGiaBan()}" pattern="#,##0"/>đ</h5>
                                            </div>
                                        </td>
                                        <td class="quantity__item">
                                            <div class="quantity-buttons">
                                                <div >
                                                    <input type="number" value="${i.getSoLuong()}" onchange="updateQuantity(${i.getMaSanPham()}, this.value)">
                                                </div>
                                            </div>
                                        </td>
                                        <td class="cart__price"><fmt:formatNumber value="${i.getGiaTien()}" pattern="#,##0"/>đ</td>
                                        <td class="cart__close"><span class="icon_close" onclick="DeleteCartItem(${i.getMaSanPham()})"></span></td>
                                    </tr>

                                </c:if>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="row">
                    <div class="col-lg-6 col-md-6 col-sm-6">
                        <div class="continue__btn">
                            <a href="./pagecontrol?page=shop">Continue Shopping</a>
                        </div>
                    </div>

                    <div class="update-btn">
                        <button onclick="updateCart()">Update Cart</button>
                    </div>

                </div>
            </div>

            <div class="col-lg-4">
                <div class="cart__discount">
                    <h6>Discount codes</h6>
                    <form action="#">
                        <input type="text" placeholder="Coupon code">
                        <button type="submit">Apply</button>
                    </form>
                </div>
                <div class="cart__total">
                    <h6>Cart total</h6>
                    <ul>
                        
                        <li>Total <span id="totalAmount"></span></li>
                    </ul>
                    <a href="./pagecontrol?page=checkout" class="primary-btn">Proceed to checkout</a>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Shopping Cart Section End -->
<script>
    function DeleteCartItem(productId) {
        // Sử dụng AJAX để gửi yêu cầu xóa hàng với productId tương ứng
        var accountId = '<%= (session.getAttribute("account") != null) ? ((Account)session.getAttribute("account")).getMaTK() : null %>';
        $.ajax({
            type: "POST", // Hoặc "GET" tùy thuộc vào cách bạn cấu hình server-side
            url: "DeleteCartItemServlet", // Địa chỉ của servlet xử lý việc xóa hàng
            data: {productId: productId, accountId: accountId},
            success: function (response) {
                if (response === 'success') {
                    console.log(accountId);
                    const cartItem = document.getElementById(`cartItem_${productId}`);
                    if (cartItem) {
                        cartItem.remove();
                    }
                }
            },
            error: function (xhr, status, error) {
                // Xử lý lỗi nếu có
                console.error(error); // In ra thông báo lỗi (nếu có)
            }
        });
    }
    function updateQuantity(productId, newQuantity) {
        var accountId = '<%= (session.getAttribute("account") != null) ? ((Account)session.getAttribute("account")).getMaTK() : null %>';
        if (accountId !== null && accountId !== "null") {
            $.ajax({
                type: "POST",
                url: "UpdateCartServlet", // Địa chỉ của Servlet xử lý yêu cầu
                data: {productId: productId, newquantity: newQuantity, accountId: accountId}, // Dữ liệu gửi đi
                success: function (response) {
                    // Xử lý kết quả trả về nếu cần
                    console.log(newQuantity);
                    console.log("Cập nhật thành công!");
                    // Cập nhật lại giao diện nếu cần
                },
                error: function (error) {
                    console.log("Đã xảy ra lỗi: " + error);
                    console.log(newQuantity);
                    console.log(productId);
                    console.log(accountId);
                }
            });
        }
    }
    function updateCart() {
        location.reload(); // Reload trang
    }
    document.addEventListener('DOMContentLoaded', function() {
    var totalAmount = 0;
    var cartItems = document.querySelectorAll('.cart__price');

    cartItems.forEach(function(item) {
        var priceString = item.textContent.trim().replace('đ', '');
        var price = parseFloat(priceString.replace(/\D/g, ''));

        if (!isNaN(price)) {
            totalAmount += price;
        }
    });

    var formatter = new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' });
    var formattedTotal = formatter.format(totalAmount);
    
    var totalSpan = document.getElementById('totalAmount');
    totalSpan.textContent = formattedTotal;
});

</script>