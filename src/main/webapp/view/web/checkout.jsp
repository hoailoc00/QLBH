<%-- 
    Document   : checkout
    Created on : Nov 4, 2023, 1:55:25 PM
    Author     : PC
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import = "model.*"%>
<%@page import = "java.io.*"%>
<%@page import = "java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Checkout Section Begin -->
<section class="checkout spad">
    <div class="container">
        <div class="checkout__form">
            <form action="pagecontrol" method="get">

                <div class="row">

                    <div class="col-lg-8 col-md-6">
                        <h6 class="coupon__code"><span class="icon_tag_alt"></span> Have a coupon? <a href="#">Click
                                here</a> to enter your code</h6>
                        <h6 class="checkout__title">Billing Details</h6>

                        <div class="row">
                            <div class="col-lg-6">
                                <div class="checkout__input">
                                    <p>Name<span>*</span></p>
                                    <input type="text"  readonly placeholder="${foundcustomer.getHoVaTen()}">
                                </div>
                            </div>

                        </div>

                        <div class="checkout__input">
                            <p>Address<span>*</span></p>
                            <input type="text" class="checkout__input__add"  readonly placeholder="${foundcustomer.getDiaChi()}">

                        </div>
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="checkout__input">
                                    <p>Phone<span>*</span></p>
                                    <input type="text"  readonly placeholder="${foundcustomer.getSoDienThoai()}">
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="checkout__input">
                                    <p>Email<span>*</span></p>
                                    <input type="text"  readonly placeholder="${foundcustomer.getEmail()}" >
                                </div>
                            </div>
                        </div>


                    </div>
                    <div class="col-lg-4 col-md-6">
                        <div class="checkout__order">
                            <h6 class="order__title">Your order</h6>
                            <div class="checkout__order__products">Product <span>Total</span></div>
                            <c:forEach var="i" items="${listCartitem}">
                                <ul class="checkout__total__products">
                                    <li>${i.getTenSanPham()} <span><fmt:formatNumber value="${i.getGiaTien()}" pattern="#,##0"/>đ</span></li>

                                </ul>
                            </c:forEach>
                            <ul class="checkout__total__all">
                                <li>Total <span id="totalAmount"></span></li>

                            </ul>


                            <button onclick="placeOrder()" class="site-btn">PLACE ORDER</button>
                        </div>
                    </div>

                </div>

            </form>

        </div>
    </div>
</section>
<!-- Checkout Section End -->
<script>
    document.addEventListener('DOMContentLoaded', function () {
        var totalAmount = 0;
        var cartItems = document.querySelectorAll('.checkout__total__products');

        cartItems.forEach(function (item) {
            var priceString = item.textContent.trim().replace('đ', '');
            var price = parseFloat(priceString.replace(/\D/g, ''));

            if (!isNaN(price)) {
                totalAmount += price;
            }
        });

        var formatter = new Intl.NumberFormat('vi-VN', {style: 'currency', currency: 'VND'});
        var formattedTotal = formatter.format(totalAmount);

        var totalSpan = document.getElementById('totalAmount');
        totalSpan.textContent = formattedTotal;
    });
    function placeOrder() {
        var totalAmountElement = document.getElementById('totalAmount');
        var totalAmount = totalAmountElement.textContent.trim().replace('đ', '').replace(/\D/g, '');
        var accountId = '<%= (session.getAttribute("account") != null) ? ((Account)session.getAttribute("account")).getMaTK() : null %>';

        // Gửi tổng tiền lên server để xử lý đặt hàng
        $.ajax({
            url: 'PlaceOrderServlet', // Thay 'PlaceOrderServlet' bằng URL endpoint của bạn để xử lý đặt hàng
            type: 'POST',
            data: {totalAmount: totalAmount, accountId: accountId},
            success: function (response) {
                if (response === 'success') {
                    alert('Order placed successfully!');
                } else {
                    alert('Failed to place order. Please try again later.');
                }
            },
            error: function (xhr, status, error) {
                console.log(error); // Xử lý lỗi (nếu có)
                alert('Failed to place order. Please check your internet connection or try again later.'); // Thông báo đặt hàng thất bại
            }
        });
    }


</script>