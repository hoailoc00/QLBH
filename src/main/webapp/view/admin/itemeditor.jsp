<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@page import="control.*"%>
<%@page import = "java.io.*"%>
<%@page import = "java.util.*"%>

<article class="content item-editor-page">
    <div class="title-block" style="display: flex">
        <h3 class="title"> Thêm sản phẩm 
            <a href="./PageDirect?page=itemlist" class="btn btn-primary btn-sm rounded-s"> Quay lại</a>
        </h3>

    </div>
    <form name="item" id="AddSanPham">
        <div class="card card-block">
            <div class="form-group row">
                <label class="col-sm-2 form-control-label text-xs-right"> ID : </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control boxed" readonly=""  id="MaSanPham">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 form-control-label text-xs-right"> Tên sản phẩm :  </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control boxed" placeholder="" id="TenSanPham" required>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 form-control-label text-xs-right"> Giá Nhập : </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control boxed" placeholder="" id="GiaNhap" required>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 form-control-label text-xs-right"> Giá Bán : </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control boxed" placeholder="" id="GiaBan" required>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 form-control-label text-xs-right"> Hình ảnh : </label>
                <div class="col-sm-10">
                    <div class="images-container">
                        <input type="file" name="hinhAnh" accept="image/*" id="fileInput" style="display: none;" onchange="displayImage()"  />
                        <div class="image-container" id="selectedImageContainer" style="display: none;">               
                            <div class="controls">                              
                                <a href="#" class="control-btn remove" onclick="removeImage()">
                                    <i class="fa fa-trash-o"></i>
                                </a>
                            </div>
                            <div class="image" id="selectedImage" data-image-url="" style="background-image: none;"></div>
                        </div>
                        <a href="javascript:void(0);" onclick="chooseFile()" id="fileLink">
                            <div class="image-container new">
                                <div class="image">
                                    <i class="fa fa-plus"></i>
                                </div>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 form-control-label text-xs-right"> Số lượng : </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control boxed" placeholder="" id="SoLuong" required>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 form-control-label text-xs-right"> Loại sản phẩm </label>
                <div class="col-sm-10">
                    <select class="c-select form-control boxed" id="LoaiSanPham" required>
                        <option selected>Chọn loại sản phảm</option>
                        <c:forEach var="listlsp" items="${lslsp}">
                            <option>${listlsp.getTenLoaiSanPham()}</option>
                        </c:forEach>
                    </select>
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
    function chooseFile() {
        // Kích thích sự kiện click của ô chọn file
        document.getElementById('fileInput').click();
    }

    function displayImage() {
        // Lấy đường dẫn hình ảnh từ ô chọn file
        var input = document.getElementById('fileInput');
        var imageUrl = URL.createObjectURL(input.files[0]);

        // Ẩn ô chọn file
        document.getElementById('fileInput').style.display = 'none';
        document.getElementById('fileLink').style.display = 'none';
        // Hiển thị hình ảnh được chọn
        var selectedImageContainer = document.getElementById('selectedImageContainer');
        selectedImageContainer.style.display = 'block';

        var selectedImage = document.getElementById('selectedImage');
        selectedImage.style.backgroundImage = 'url(' + imageUrl + ')';
        selectedImage.setAttribute('data-image-url', imageUrl);
        console.log(imageUrl);
    }

    function removeImage() {
        // Xóa hình ảnh và hiển thị ô chọn file lại
        var selectedImageContainer = document.getElementById('selectedImageContainer');
        selectedImageContainer.style.display = 'none';
        selectedImage.setAttribute('data-image-url', null);
        // Hiển thị ô chọn file
        document.getElementById('fileInput').style.display = 'none';
        document.getElementById('fileLink').style.display = 'block';
        imageUrl = undefined;
        var input = document.getElementById('fileInput');
        input.value = '';
    }
    $(document).ready(function () {
        $("#AddSanPham").submit(function (e) {
            e.preventDefault();

//                    var MaSanPham = $('#MaSanPham').val();
            var formData = new FormData();
//            var imageElement = document.querySelector('.image');
//            var action = "AddSanPham";
//            var TenSanPham = $('#TenSanPham').val();
//            var GiaNhap = $('#GiaNhap').val();
//            var GiaBan = $('#GiaBan').val();
//            var imageElement = document.querySelector('.image');
//            var HinhAnh = $('#fileInput')[0].files[0]));
//            var SoLuong = $('#SoLuong').val();
//            var LoaiSanPham = document.getElementById("LoaiSanPham").value;
            formData.append('file', $('#fileInput')[0].files[0]); // Thêm hình vào FormData
            formData.append('TenSanPham', $('#TenSanPham').val());
            formData.append('GiaNhap', $('#GiaNhap').val());
            formData.append('GiaBan', $('#GiaBan').val());
            formData.append('SoLuong', $('#SoLuong').val());
            formData.append('LoaiSanPham', $('#LoaiSanPham').val());
            formData.append('Action', 'AddSanPham');

            $.ajax({
                type: "POST",
                url: "Add",
                data: formData,
//                        {
////                    MaSanPham: MaSanPham,
//                    action: action,
//                    TenSanPham: TenSanPham,
//                    GiaNhap: GiaNhap,
//                    GiaBan: GiaBan,
//                    HinhAnh: HinhAnh,
//                    SoLuong: SoLuong,
//                    LoaiSanPham: LoaiSanPham
//                },
                contentType: false,
                processData: false,
                success: function (response, status, xhr) {
                    if (response === 'success') {
                        alert("Đã thêm thành công!");
                        window.location.href = "./PageDirect?page=itemlist";
//                        console.log(TenSanPham);
//                        console.log(GiaNhap);
//                        console.log(GiaBan);
//                        console.log(HinhAnh);
//                        console.log(SoLuong);
//                        console.log(LoaiSanPham);
                        // Thêm mã JavaScript ở đây nếu cần
                    } else {
                        alert("Thêm thất bại!");
                    }
                },
                error: function () {
//                    console.log(action);
//                    console.log(TenSanPham);
//                    console.log(GiaNhap);
//                    console.log(GiaBan);
////                    console.log(HinhAnh);
//                    console.log(SoLuong);
//                    console.log(LoaiSanPham);
//                    alert("Error in Ajax request!");
                    console.log("Error in Ajax request:", error);
                    console.log("Server Response:", xhr.responseText);
                    // Hiển thị thông báo lỗi từ server
                    alert("Error in Ajax request. Check console for details.");
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