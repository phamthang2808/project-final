<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Đăng ký tài khoản</title>
</head>
<style>
    body, html {
        margin: 0;
        padding: 0;
        height: 100%;
        width: 100%;
    }

    a {
        display: block; /* Thẻ <a> chiếm toàn bộ màn hình */
        height: 100%;
        width: 100%;
    }

    a img {
        width: 100%; /* Chiều rộng 100% màn hình */
        height: 100%; /* Chiều cao 100% màn hình */
        object-fit: cover; /* Ảnh bao phủ và giữ tỷ lệ */
    }
</style>
<body>
<a src="https://www.google.com.vn/url?sa=i&url=https%3A%2F%2Fmaisonoffice.vn%2Ftin-tuc%2Ftop-22-toa-nha-cao-nhat-tai-ha-noi%2F&psig=AOvVaw2J11V-hoGqyiy9fmfNjbGT&ust=1733241485109000&source=images&cd=vfe&opi=89978449&ved=0CBQQjRxqFwoTCMiRn-25iYoDFQAAAAAdAAAAABAE">

</a>
<form id="signupForm">
    <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col-12 col-md-8 col-lg-6 col-xl-5">
            <div class="card text-white" style="border-radius: 1rem; background-color: #2e8965;">
                <div class="card-body p-2 px-5 text-center">
                    <div class="md-5 md-4 mt-4 pb-2">
                        <h2 class="fw-bold mb-2 text-uppercase">Sign up</h2>

                        <div class="form-outline form-white mb-2">
                            <label class="form-label" for="username">Username</label>
                            <input type="text" id="username" class="form-control form-control-sm">
                        </div>
                        <div class="form-outline form-white mb-2">
                            <label class="form-label" for="username">Fullname</label>
                            <input type="text" id="fullname" class="form-control form-control-sm">
                        </div>
                        <div class="form-outline form-white mb-2">
                            <label class="form-label" for="password">Password</label>
                            <input type="password" id="password" class="form-control form-control-sm">
                        </div>

                        <div class="form-outline form-white mb-2">
                            <label class="form-label" for="confirm_password">Confirm Password</label>
                            <input type="password" id="confirm_password" class="form-control form-control-sm">
                        </div>

                        <button type="submit" class="btn btn-outline-light btn-lg px-5" id="signup">Register</button>

                        <div class="d-flex justify-content-center text-center mt-2 pt-1">
                            <a href="#!" class="login-extension text-white"><i class="fab fa-facebook-f fa-lg"></i></a>
                            <a href="#!" class="login-extension text-white"><i
                                    class="fab fa-twitter fa-lg mx-4 px-2"></i></a>
                            <a href="#!" class="login-extension text-white"><i class="fab fa-google fa-lg"></i></a>
                        </div>

                        <p class="text-center text-muted mt-2 mb-0">Account already exists? <a
                                href="${pageContext.request.contextPath}/login" class="fw-bold text-body"><u
                                style="color: white ;">Login here</u></a></p>

                    </div>
                </div>
            </div>
        </div>
    </div>
</form>

<script>
    // Thêm sự kiện submit cho form
    document.getElementById('signupForm').addEventListener('submit', function (event) {
        event.preventDefault(); // Ngăn việc gửi form tự động

        const username = document.getElementById("username").value;
        const password = document.getElementById("password").value;
        const fullname = document.getElementById("fullname").value;
        const confirmPassword = document.getElementById("confirm_password").value;

        if (username.trim().length === 0) {
            alert("Username can not be Blank!");
            return;
        }
        if (fullname.trim().length === 0) {
            alert("Fullname can not be Blank!")
        }
        if (password !== confirmPassword) {
            alert("Password does not match!");
            return false;
        }

        const json = {
            fullName: fullname,
            userName: username,
            password: password
        };

        signup(json);
    });

    function signup(json) {
        $.ajax({
            url: "/api/user/signup",
            type: "POST",
            data: JSON.stringify(json),
            contentType: "application/json",
            success: function (result) {
                console.log("success");
                alert("Đăng ký thành công!");
                location.replace("/trang-chu");
            },
            error: function (result) {
                console.log(result.message);
                alert(result.detail);
            }
        });
    }
</script>


</body>
</html>



