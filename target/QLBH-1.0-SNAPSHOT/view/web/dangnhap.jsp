<%-- 
    Document   : dangnhap
    Created on : Nov 14, 2023, 2:43:47 PM
    Author     : datht
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="vi">

    <head>
        <title>Đăng nhập | Website hệ thống bán hàng</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="fonts/fonts-dangnhap/font-awesome-4.7.0/css/font-awesome.min.css">
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
        <style>
            /* Đặt vị trí cho dòng chữ "Trở về trang chủ" trên hình ảnh */
            .login100-pic {
                position: relative;
            }

            .login100-pic a.txt2 {
                position: absolute;
                top: 10px; /* Điều chỉnh vị trí theo chiều dọc từ phía trên */
                left: 10px; /* Điều chỉnh vị trí theo chiều ngang từ phía trái */
                color: white; /* Màu chữ */
                z-index: 1; /* Đảm bảo hiển thị trên top của hình ảnh */
            }

        </style>
    </head>
    <body>
        <div class="limiter">
            <div class="container-login100">
                <div class="wrap-login100">
                    <a href="/QLBH/view/web/pagecontrol">
                        <div class="login100-pic js-tilt" data-tilt>
                            <img src="image/cake-store.jpg" alt="IMG">
                            <a class="txt2" href="/QLBH/view/web/pagecontrol">
                                Trở về trang chủ
                            </a>
                        </div>
                    </a>
                    <!--=====TIÊU ĐỀ======-->
                    <div class="login100-form validate-form">
                        <span class="login100-form-title">
                            <b>ĐĂNG NHẬP</b>
                        </span>
                        <!--=====FORM INPUT TÀI KHOẢN VÀ PASSWORD======-->
                        <form action="login" method="post" onsubmit="return validateForm()">
                            <div class="wrap-input100 validate-input">
                                <input class="input100" type="text" placeholder="Tài khoản" name="username"
                                       id="username">
                                <span class="focus-input100"></span>
                                <span class="symbol-input100">
                                    <i class='bx bx-user'></i>
                                </span>
                            </div>
                            <div class="wrap-input100 validate-input">
                                <input autocomplete="off" class="input100" type="password" placeholder="Mật khẩu"
                                       name="current-password" id="password-field">
                                <span toggle="#password-field" class="bx fa-fw bx-hide field-icon click-eye"></span>
                                <span class="focus-input100"></span>
                                <span class="symbol-input100">
                                    <i class='bx bx-key'></i>
                                </span>
                            </div>
                            <div class="text-right p-t-12">
                                <a class="txt2" href="quenMk.jsp">
                                    Bạn quên mật khẩu?
                                </a>
                            </div>
                            <!--=====ĐĂNG NHẬP======-->
                            <div class="container-login100-form-btn">
                                <input type="submit" value="Đăng nhập" id="submit" onclick="return validateForm()" />
                            </div>
                            <!--=====LINK TÌM MẬT KHẨU======-->
                            <div class="p-t-12 text-center">

                                <a href="dangky.jsp">
                                    Đăng ký
                                </a>

                            </div>

                            <div id="error-message" style="color: red;"></div>
                            <%-- Kiểm tra và hiển thị thông báo lỗi (nếu có) --%>
                            <% String errorMessage = (String)request.getAttribute("loginErrorMessage");
                               if (errorMessage != null && !errorMessage.isEmpty()) {
                            %>
                            <div style="color: red;"><%= errorMessage %></div>
                            <% } %>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!--Javascript-->
        <script src="/js/main.js"></script>
        <script src="https://unpkg.com/boxicons@latest/dist/boxicons.js"></script>
        <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
        <script src="vendor/bootstrap/js/popper.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <script src="vendor/select2/select2.min.js"></script>
        <script type="text/javascript">
                                    //show - hide mật khẩu
                                    function myFunction() {
                                        var x = document.getElementById("myInput");
                                        if (x.type === "password") {
                                            x.type = "text"
                                        } else {
                                            x.type = "password";
                                        }
                                    }
                                    $(".click-eye").click(function () {
                                        $(this).toggleClass("bx-show bx-hide");
                                        var input = $($(this).attr("toggle"));
                                        if (input.attr("type") == "password") {
                                            input.attr("type", "text");
                                        } else {
                                            input.attr("type", "password");
                                        }
                                    });
                                    // ktr ô tài khoản - mật khẩu để trống
                                    function validateForm() {
                                        var username = document.getElementById("username").value;
                                        var password = document.getElementById("password-field").value;

                                        if (username.trim() === '' || password.trim() === '') {
                                            var errorDiv = document.getElementById("error-message");
                                            errorDiv.innerText = "Tài khoản và mật khẩu không được để trống!";
                                            return false;
                                        }

                                        return true;
                                    }
        </script>
    </body>

</html>