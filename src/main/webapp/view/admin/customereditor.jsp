<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@page import="control.*"%>
<%@page import = "java.io.*"%>
<%@page import = "java.util.*"%>

<article class="content item-editor-page">
    <div class="title-block" style="display: flex">
        <h3 class="title"> Thêm khách hàng
            <a href="./PageDirect?page=customerlist" class="btn btn-primary btn-sm rounded-s"> Quay lại</a>
        </h3>

    </div>
    <form name="item" id="AddKhachHang">
        <div class="card card-block">
            <div class="form-group row">
                <label class="col-sm-2 form-control-label text-xs-right"> ID : </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control boxed" readonly=""  id="MaKhachHang">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 form-control-label text-xs-right"> Tên khách Hàng :  </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control boxed" placeholder="" id="TenKhachHang" required>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 form-control-label text-xs-right"> Giới tính </label>
                <div class="col-sm-10">
                    <select class="c-select form-control boxed" id="GioiTinh" required>
                        <option selected="" value="Nam">Nam</option>
                        <option value="Nữ">Nữ</option>
                    </select>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 form-control-label text-xs-right"> Số điện thoại : </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control boxed" placeholder="" id="SDT" required>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 form-control-label text-xs-right"> Địa chỉ : </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control boxed" placeholder="" id="DiaChi" required>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 form-control-label text-xs-right"> Email : </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control boxed" placeholder="" id="Email" required>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 form-control-label text-xs-right"> Tài khoản : </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control boxed" placeholder="" id="TaiKhoan" required>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 form-control-label text-xs-right"> Mật khẩu : </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control boxed" placeholder="" id="MatKhau" required>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-10 col-sm-offset-2">
                    <button type="submit" class="btn btn-primary"> Thêm </button>
                </div>
            </div>
        </div>
    </form>
</article>
<script>
    $(document).ready(function () {
        $("#AddKhachHang").submit(function (e) {
            e.preventDefault();

            var MaKhachHang = $('#MaKhachHang').val();
            var action = "AddKhachHang";
            var TenKhachHang = $('#TenKhachHang').val();
            var GioiTinh = document.getElementById("GioiTinh").value;
            var SDT = $('#SDT').val();
            var DiaChi = $('#DiaChi').val();
            var Email = $('#Email').val();
            var TaiKhoan = $('#TaiKhoan').val();
            var MatKhau = $('#MatKhau').val();

            $.ajax({
                type: "POST",
                url: "Add",
                data:
                        {
                            action: action,
                            MaKhachHang: MaKhachHang,
                            TenKhachHang: TenKhachHang,
                            GioiTinh: GioiTinh,
                            SDT: SDT,
                            DiaChi: DiaChi,
                            Email: Email,
                            TaiKhoan: TaiKhoan,
                            MatKhau: MatKhau
                        },
                
                success: function (response, status, xhr) {
//                    if(response === 'create customer success') {
//                        alert("Đã thêm thành công!");
//                        window.location.href = "./PageDirect?page=customerlist";
//
//                        // Thêm mã JavaScript ở đây nếu cần
//                    } else if (response === 'account existed') {
//                        alert("Tài khoản dã tồn tại!");
//                        $('#TaiKhoan').focus();
//                        console.log(response);
//                    } else if(response === 'can not create account'){
////                        console.log(TenKhachHang);
////                        console.log(GioiTinh);
////                        console.log(SDT);
////                        console.log(DiaChi);
////                        console.log(Email);
////                        console.log(TaiKhoan);
////                        console.log(MatKhau);
//                        alert("Tạo tài khoản thất bại!");
//                    } else if(response === 'false'){
//                        alert("Thêm khách hàng thất bại!");
//                    }
                    switch (response) {
                        case "success":
                            alert("Đã thêm thành công!");
                            window.location.href = "./PageDirect?page=customerlist";
                            // Thêm mã JavaScript ở đây nếu cần
                            break;
                        case "account existed":
                            alert("Tài khoản đã tồn tại!");
                            $('#TaiKhoan').focus();
                            break;
                        case "can not create account":
                            // console.log(TenKhachHang);
                            // console.log(GioiTinh);
                            // console.log(SDT);
                            // console.log(DiaChi);
                            // console.log(Email);
                            // console.log(TaiKhoan);
                            // console.log(MatKhau);
                            alert("Thêm tài khoản thất bại!");
                            break;
                        case 'unknown result':
                            alert("Lỗi không xác định!");
                            break;
                        case "false":
                            alert("Không thể thêm khách hàng!");
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