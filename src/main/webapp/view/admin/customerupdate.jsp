<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@page import="control.*"%>
<%@page import = "java.io.*"%>
<%@page import = "java.util.*"%>

<article class="content item-editor-page">
    <div class="title-block" style="display: flex">
        <h3 class="title"> Chỉnh sửa thông tin khách hàng
            <a href="#" class="btn btn-primary btn-sm rounded-s" id="goBackButton"> Quay lại</a>
        </h3>

    </div>
    <form name="item" id="UpdateKhachHang">
        <div class="card card-block">
            <div class="form-group row">
                <label class="col-sm-2 form-control-label text-xs-right"> ID : </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control boxed" readonly="" id="MaKhachHang" value="${kh.getMaKhachHang()}">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 form-control-label text-xs-right"> Tên khách Hàng :  </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control boxed" placeholder="" id="TenKhachHang" value="${kh.getHoVaTen()}" required>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 form-control-label text-xs-right"> Giới tính </label>
                <div class="col-sm-10">
                    <select class="c-select form-control boxed" id="GioiTinh" required>
                        <c:set var="gender" value="${kh.getGioiTinh()}"/>
                        <c:choose>
                            <c:when test="${gender == 'Nam'}">
                                <option selected="" value="Nam">Nam</option>
                                <option value="Nữ">Nữ</option>
                            </c:when>
                            <c:when test="${gender == 'Nữ'}">
                                <option value="Nam">Nam</option>
                                <option selected="" value="Nữ">Nữ</option>
                            </c:when>  
                        </c:choose>
                    </select>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 form-control-label text-xs-right"> Số điện thoại : </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control boxed" placeholder="" id="SDT" value="${kh.getSoDienThoai()}" required>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 form-control-label text-xs-right"> Địa chỉ : </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control boxed" placeholder="" id="DiaChi" value="${kh.getDiaChi()}" required>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 form-control-label text-xs-right"> Email : </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control boxed" placeholder="" id="Email" value="${kh.getEmail()}" required>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 form-control-label text-xs-right"> Tài khoản : </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control boxed" placeholder="" id="TaiKhoan" 
                           readonly="" value="${kh.getTaiKhoan().getTenTaiKhoan()}" required>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 form-control-label text-xs-right"> Mật khẩu : </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control boxed" placeholder="" 
                           readonly="" id="MatKhau" value="${kh.getTaiKhoan().getMatKhau()}" required>
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
        $("#UpdateKhachHang").submit(function (e) {
            e.preventDefault();

            var MaKhachHang = $('#MaKhachHang').val();
            var action = "UpdateKhachHang";
            var TenKhachHang = $('#TenKhachHang').val();
            var GioiTinh = document.getElementById("GioiTinh").value;
            var SDT = $('#SDT').val();
            var DiaChi = $('#DiaChi').val();
            var Email = $('#Email').val();
            var TaiKhoan = $('#TaiKhoan').val();
            var MatKhau = $('#MatKhau').val();

            $.ajax({
                type: "POST",
                url: "Update",
                data:
                        {
                            MaKhachHang: MaKhachHang,
                            action: action,
                            TenKhachHang: TenKhachHang,
                            GioiTinh: GioiTinh,
                            SDT: SDT,
                            DiaChi: DiaChi,
                            Email: Email,
                            TaiKhoan: TaiKhoan,
                            MatKhau: MatKhau
                        },
                success: function (response) {
                    switch (response) {
                        case "success":
                            alert("Đã chỉnh sửa thành công!");
                            window.location.href = "./PageDirect?page=customerlist";
                            // Thêm mã JavaScript ở đây nếu cần
                            break;
                        default:
                            // Xử lý trường hợp mặc định nếu cần
//                            console.log(response);
                            alert("Giá trị phản hồi không xác định!");
                    }
                },
                error: function () {
                    alert("Error in Ajax request!");
                }
            });
        });
    });

//    function AddItem() {
////        var MaSanPham = $('#MaSanPham').val();
//        var TenSanPham = $('#TenSanPham').val();
//        var GiaNhap = $('#GiaNhap').val();
//        var GiaBan = $('#GiaBan').val();
//        var imageElement = document.querySelector('.image');
//        var HinhAnh = imageElement.getAttribute('data-image-url');
//        var SoLuong = $('#SoLuong').val();
//        var LoaiSanPham = document.getElementById("LoaiSanPham").value;
//        $.ajax({
//            type: "POST",
//            url: "/views/admin/PageDirect",
//            data: {
////                MaSanPham : MaSanPham,
//                TenSanPham: TenSanPham,
//                GiaNhap: GiaNhap,
//                GiaBan: GiaBan,
//                HinhAnh: HinhAnh,
//                SoLuong: SoLuong,
//                LoaiSanPham: LoaiSanPham
//            },
//            success: function (response) {
//                if (response === 'success') {
//                    alert("Product added successfully!");
//                }
//            },
//            error: function (error) {
//                console.error(error);
//                console.log(TenSanPham);
//                console.log(GiaNhap);
//                console.log(GiaBan);
//                console.log(HinhAnh);
//                console.log(SoLuong);
//                console.log(LoaiSanPham);
//                alert("Error adding product: " + error.responseText);
//            }
//        });
//    }
</script>