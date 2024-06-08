<%-- 
    Document   : dangky
    Created on : Nov 17, 2023, 2:11:20 PM
    Author     : datht
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html lang="vi">

    <head>
        <title>Đăng nhập quản trị | Website quản trị v2.0</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
        <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
        <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
        <link rel="stylesheet" type="text/css" href="css/util.css">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-sweetalert/1.0.1/sweetalert.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
        <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
    </head>

    <body>
        <div class="limiter">
            <div class="container-login100">
                <div class="wrap-login100">
                    <div class="login100-pic js-tilt" data-tilt>
                        <img src="image/cake-store.jpg" alt="IMG">

                    </div>

                    <!--=====TIÊU ĐỀ======-->
                    <form action="addTK" method="post" onsubmit="return checkLogin()">
                        <span class="login100-form-title">
                            <b>Đăng Ký Tài Khoản</b>
                        </span>

                        <!--=====FORM INPUT TÀI KHOẢN VÀ PASSWORD======-->
                        <%
                    String error = request.getParameter("error");
                    if (error != null) {
                    %>
                    <div class="error-message">
                        Tài khoản đã tồn tại. Vui lòng đăng nhập bằng tài khoản khác.
                    </div>
                    <%
                        }
                    %>
                        <div class="wrap-input100 validate-input">
                            <input class="input100" type="text" placeholder="Nhập tên tài khoản" name="name"
                                   id="username">
                            <span class="focus-input100"></span>
                            <span class="symbol-input100">
                                <i class='bx bx-user'></i>
                                
                            </span>
                        </div>
                        <div class="wrap-input100 validate-input">
                            <input autocomplete="off" class="input100" type="password" placeholder="Mật khẩu"
                                   name="password" id="password-field">
                            <span toggle="#password-field" class="bx fa-fw bx-hide field-icon click-eye"></span>
                            <span class="focus-input100"></span>
                            <span class="symbol-input100">
                                <i class='bx bx-key'></i>
                            </span>
                        </div>
                        <div class="wrap-input100 validate-input">
                            <input autocomplete="off" class="input100" type="password" placeholder="Nhập lại mật khẩu"
                                   name="repass" id="repassword">
                            <span toggle="#password-field" class="bx fa-fw bx-hide field-icon click-eye"></span>
                            <span class="focus-input100"></span>
                            <span class="symbol-input100">
                                <i class='bx bx-key'></i>
                            </span>
                        </div>


                        <div class="wrap-input100 validate-input">
                            <input class="input100" type="text" placeholder="Họ và Tên" name="hovaten" id="hovaten">
                            <span class="focus-input100"></span>
                            <span class="symbol-input100">
                                <i class='bx bx-happy-alt'></i>
                            </span>
                        </div>
<!--                        <div class="wrap-input100 validate-input">
                            <input class="input100" type="text" placeholder="Nhập giới tính của bạn" name="gioitinh" id="gioitinh">
                            <span class="focus-input100"></span>
                            <span class="symbol-input100">
                                <i class='bx bx-male-sign'></i>
                            </span>
                        </div>-->
                        
                        <div class="wrap-input100 validate-input">
                            <select class="input100" name="gioitinh" id="gioitinh">
                                <option value="Nam">Nam</option>
                                <option value="Nữ">Nữ</option>
                            </select>
                            <span class="focus-input100"></span>
                            <span class="symbol-input100">
                                <i class='bx bx-male-sign'></i>
                            </span>
                        </div>
                        <div class="wrap-input100 validate-input">
                            <input class="input100" type="text" placeholder="Email" name="email" id="email">
                            <span class="focus-input100"></span>
                            <span class="symbol-input100">
                                <i class='bx bx-envelope'></i>
                            </span>
                        </div>
                        <div class="wrap-input100 validate-input">
                            <input class="input100" type="text" placeholder="Phone" name="sodienthoai" id="Phone">
                            <span class="focus-input100"></span>
                            <span class="symbol-input100">
                                <i class='bx bxs-phone-call'></i>
                            </span>
                        </div>
                        <div class="wrap-input100 validate-input">
                            <input class="input100" type="text" placeholder="Address" name="diachi" id="Address">
                            <span class="focus-input100"></span>
                            <span class="symbol-input100">
                                <i class='bx bx-map'></i>
                            </span>
                        </div>
                        

                        <!--=====BUTTON ĐĂNG NHẬP======-->
                        <div class="container-login100-form-btn">
                            <button class="login100-form-btn" type="submit" name="login">
                                Đăng ký
                            </button>
                        </div>
                        <div class="text-center p-t-12">
                            <span class="txt1">
                                Quay lại
                            </span>
                            <a class="txt2" href="dangnhap.jsp">
                                Đăng nhập
                            </a>
                        </div>

                    </form>
                </div>
            </div>
        </div>

        <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
        <script src="vendor/bootstrap/js/popper.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <script src="vendor/select2/select2.min.js"></script>
        <script src="vendor/tilt/tilt.jquery.min.js"></script>
        <script>
                        $('.js-tilt').tilt({
                            scale: 1.1
                        })
        </script>
        <script>

            function checkLogin() {
                var username = document.getElementById("username").value;
                var password = document.getElementById("password-field").value;
                var rpw = document.getElementById("repassword").value;
                var hovaten = document.getElementById("hovaten").value;
                var gioitinh = document.getElementById("gioitinh").value;
                var email = document.getElementById("email").value;
                var sodienthoai = document.getElementById("Phone").value;
                var diachi = document.getElementById("Address").value;


                if (username.trim() === "" ||
                        password.trim() === "" ||
                        email.trim() === "" ||
                        sodienthoai.trim() === "" ||
                        diachi.trim() === "" || hovaten.trim() === "" || gioitinh.trim() === ""
                        ) {
                    swal("Lỗi", "Vui lòng điền đầy đủ thông tin", "error");
                    return false;
                }
                if (password !== rpw) {
                    swal("Lỗi", "Mật khẩu không khớp", "error");
                    return false;
                }
            }


        </script>
    </body>

</html>