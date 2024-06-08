<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@page import="control.*"%>
<%@page import="model.*"%>
<%@page import = "java.util.*"%>
<article class="content items-list-page">
    <div class="title-search-block">
        <div class="title-block">
            <div class="row">
                <div class="col-md-6">
                    <h3 class="title"> Quản lí hóa đơn
                        <a href="./PageDirect?page=allbill" class="btn btn-primary btn-sm rounded-s"> Xem tất cả hóa đơn </a>
                    </h3>
                    <p class="title-description">Danh sách hóa đơn chưa duyệt</p>
                </div>
            </div>
        </div>
        <div class="items-search">
            <form class="form-inline">
                <div class="input-group">
                    <input type="text" class="form-control boxed rounded-s" placeholder="Search for...">
                    <span class="input-group-btn">
                        <button class="btn btn-secondary rounded-s" type="button">
                            <i class="fa fa-search"></i>
                        </button>
                    </span>
                </div>
            </form>
        </div>
    </div>
    <div class="card items">
        <ul class="item-list striped">
            <li class="item item-list-header">
                <div class="item-row">
                    <div class="item-col item-col-header item-col-stats">
                        <div>
                            <span>Mã hóa đơn</span>
                        </div>
                    </div>
                    <div class="item-col item-col-header item-col-stats">
                        <div>
                            <span>Khách hàng</span>
                        </div>
                    </div>
                    <div class="item-col item-col-header item-col-stats">
                        <div>
                            <span>Mã nhân viên</span>
                        </div>
                    </div>
                    <div class="item-col item-col-header item-col-stats">
                        <div class="no-overflow">
                            <span>Trạng thái</span>
                        </div>
                    </div>
                    <div class="item-col item-col-header item-col-stats">
                        <div class="no-overflow">
                            <span>Tổng tiền</span>
                        </div>
                    </div>
                    <div class="item-col item-col-header item-col-stats">
                        <div>
                            <span> Mã Voucher </span>
                        </div>
                    </div>
                    <div class="item-col item-col-header item-col-date">
                        <div>
                            <span>Ngày lập</span>
                        </div>
                    </div>
                    <div class="item-col item-col-header fixed item-col-actions-dropdown">
                    </div>
                </div>
            </li>
            <c:forEach var="hd0" items="${hd0}">
                <li class="item">
                    <div class="item-row">
                        <div class="item-col item-col-header item-col-stats">
                            <div>
                                <a href="./PageDirect?page=billdetail&id=${hd0.getMaHoaDon()}" class="" style="text-decoration: none">
                                    <span>${hd0.getMaHoaDon()}</span>
                                </a>
                            </div>
                        </div>
                        <div class="item-col item-col-stats no-overflow">
                            <!--<div class="item-heading">Stats</div>-->
                            <div class="no-overflow">
                                <c:forEach var="lskh" items="${listKH}">
                                    <c:set var="khid" value="${lskh.getMaKhachHang()}"/>
                                    <c:set var="khhdid" value="${hd0.getMaKhachHang()}"/>
                                    <c:choose>
                                        <c:when test="${khid == khhdid}">
                                            <div> ${lskh.getHoVaTen()}</div>
                                        </c:when>
                                    </c:choose>
                                </c:forEach>
                            </div>
                        </div>
                        <div class="item-col item-col-header item-col-stats">
                            <div>
                                <span>${hd0.getMaNhanVien()}</span>
                            </div>
                        </div>
                        <div class="item-col item-col-stats">
                            <div class="no-overflow">
                                <c:set var="trangthai" value="${hd0.getTrangThai()}"/>
                                <c:if test="${trangthai == 0}">
                                    <div>Chưa duyệt</div>
                                </c:if>
                            </div>
                        </div>
                        <div class="item-col item-col-stats">
                            <!--<div class="item-heading">Published</div>-->
                            <div class="no-overflow"> <fmt:formatNumber value="${hd0.getTongTien()}" pattern="#,##0"/>đ</div>
                        </div>
                        <div class="item-col item-col-stats">
                            <!--<div class="item-heading">Số lượng</div>-->
                            <div> ${hd0.getMaVoucher()} </div>
                        </div>
                        <div class="item-col item-col-date">
                            <div class="no-overflow"> ${hd0.getNgayLap()}</div>
                        </div>
                        <div class="item-col fixed item-col-actions-dropdown">
                            <div class="item-actions-dropdown">
                                <a class="item-actions-toggle-btn">
                                    <span class="inactive">
                                        <i class="fa fa-cog"></i>
                                    </span>
                                    <span class="active">
                                        <i class="fa fa-chevron-circle-right"></i>
                                    </span>
                                </a>
                                <div class="item-actions-block">
                                    <ul class="item-actions-list">
                                        <li>
                                            <a class="remove" data-bill-id="${hd0.getMaHoaDon()}" style="cursor: pointer" >
                                                <i class="fa fa-trash-o "></i>
                                            </a>
                                        </li>
                                        <li>
                                            <a class="edit" data-bill-id="${hd0.getMaHoaDon()}" style="cursor: pointer">
                                                <i class="fa fa-pencil"></i>
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
    <nav class="text-right">
        <ul class="pagination">
            <li class="page-item">
                <a class="page-link" href=""> Prev </a>
            </li>
            <li class="page-item active">
                <a class="page-link" href=""> 1 </a>
            </li>
            <li class="page-item">
                <a class="page-link" href=""> 2 </a>
            </li>
            <li class="page-item">
                <a class="page-link" href=""> 3 </a>
            </li>
            <li class="page-item">
                <a class="page-link" href=""> 4 </a>
            </li>
            <li class="page-item">
                <a class="page-link" href=""> 5 </a>
            </li>
            <li class="page-item">
                <a class="page-link" href=""> Next </a>
            </li>
        </ul>
    </nav>
</article>
<script>
    var MaHoaDon;
    $('.remove').on('click', function () {
        MaHoaDon = $(this).data('bill-id');
        console.log("ID sản phẩm cần xóa: " + MaHoaDon);
        var DenyHoaDon = 'DenyHoaDon';

        $.ajax({
            type: "POST",
            url: "Delete",
            data: {
                MaHoaDon: MaHoaDon,
                action: DenyHoaDon
            },
            success: function (response, status, xhr) {

                if (response === 'success') {
                    alert("Đã từ chối thành công!");
                } else {
                    alert("Từ chối thất bại!");
                }

            },
            error: function () {
                alert("Error");

            },
            complete: function () {
                // Sau khi Ajax hoàn thành, load lại trang
                location.reload();
            }
        });
    });

    $('.edit').on('click', function () {
        MaHoaDon = $(this).data('bill-id');
        var AcceptHoaDon = 'AcceptHoaDon';

        $.ajax({
            type: "POST",
            url: "Update",
            data: {
                MaHoaDon: MaHoaDon,
                action: AcceptHoaDon
            },
            success: function (response, status, xhr) {

                if (response === 'success') {
                    alert("Đã duyệt thành công!");
                } else {
                    alert("Duyệt thất bại!");
                }

            },
            error: function () {
                alert("Error");

            },
            complete: function () {
                // Sau khi Ajax hoàn thành, load lại trang
                location.reload();
            }
        });
    });

</script>
