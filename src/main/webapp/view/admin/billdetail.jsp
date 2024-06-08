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
                    <h3 class="title"> Chi tiết hóa đơn
                        <a href="#" class="btn btn-primary btn-sm rounded-s" id="goBackButton"> Quay lại </a>
                    </h3>
                    <p class="title-description">Mã hóa đơn : ${hdid}</p>
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
                            <span>Sản phẩm</span>
                        </div>
                    </div>
                    <div class="item-col item-col-header item-col-stats">
                        <div>
                            <span>Số lượng</span>
                        </div>
                    </div>
                    <div class="item-col item-col-header item-col-stats">
                        <div class="no-overflow">
                            <span>Giá tiền</span>
                        </div>
                    </div>
                </div>
            </li>
            <c:forEach var="detail" items="${hddetail}">
                <li class="item">
                    <div class="item-row">
                        <div class="item-col item-col-stats no-overflow">
                            <!--<div class="item-heading">Stats</div>-->
                            <div class="no-overflow">
                                <c:forEach var="lssp" items="${listSP}">
                                    <c:set var="spid" value="${lssp.getMaSanPham()}"/>
                                    <c:set var="sphdid" value="${detail.getChiTietHoaDon().getMaSanPham()}"/>
                                    <c:choose>
                                        <c:when test="${spid == sphdid}">
                                            <div> ${lssp.getTenSanPham()}</div>
                                        </c:when>
                                    </c:choose>
                                </c:forEach>
                            </div>
                        </div>
                        <div class="item-col item-col-header item-col-stats">
                            <div>
                                <span>${detail.getChiTietHoaDon().getSoLuong()}</span>
                            </div>
                        </div>
                        <div class="item-col item-col-stats">
                            <!--<div class="item-heading">Published</div>-->
                            <div class="no-overflow"> <fmt:formatNumber value="${detail.getChiTietHoaDon().getGiaTien()}" pattern="#,##0"/>đ</div>
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
    <!--    <nav class="text-right">
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
        </nav>-->
</article>
<script>
    function goBack() {
        window.history.back();
    }
    document.getElementById("goBackButton").addEventListener("click", goBack);
</script>