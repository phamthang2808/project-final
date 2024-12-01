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
<body>

<form id="signupForm">
    <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col-12 col-md-8 col-lg-6 col-xl-5">
            <div class="card text-white" style="border-radius: 1rem; background-color: #0a58ca;">
                <div class="card-body p-2 px-5 text-center">
                    <div class="md-5 md-4 mt-4 pb-2">
                        <h2 class="fw-bold mb-2 text-uppercase">Thêm tài khoản</h2>

                        <div class="form-outline form-white mb-2">
                            <label class="form-label" for="username">Tên người dùng</label>
                            <input type="text" id="username" class="form-control form-control-sm">
                        </div>

                        <div class="form-outline form-white mb-2">
                            <label class="form-label" for="password">Mật khẩu</label>
                            <input type="password" id="password" class="form-control form-control-sm">
                        </div>

                        <div class="form-outline form-white mb-2">
                            <label class="form-label" for="confirm_password">Nhập lại mật khẩu</label>
                            <input type="password" id="confirm_password" class="form-control form-control-sm">
                        </div>

                        <button type="submit" class="btn btn-outline-light btn-lg px-5" id="signup">Đăng ký</button>

                        <div class="d-flex justify-content-center text-center mt-2 pt-1">
                            <a href="#!" class="login-extension text-white"><i class="fab fa-facebook-f fa-lg"></i></a>
                            <a href="#!" class="login-extension text-white"><i
                                    class="fab fa-twitter fa-lg mx-4 px-2"></i></a>
                            <a href="#!" class="login-extension text-white"><i class="fab fa-google fa-lg"></i></a>
                        </div>

                        <p class="text-center text-muted mt-2 mb-0">Tài khoản đã tồn tại? <a
                                href="${pageContext.request.contextPath}/login" class="fw-bold text-body"><u
                                style="color: white ;">Đăng nhập ở đây</u></a></p>

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
        const confirmPassword = document.getElementById("confirm_password").value;

        if (username.trim().length === 0) {
            alert("Tên người dùng không được để trống!");
            return;
        }
        // Kiểm tra mật khẩu và xác nhận mật khẩu
        if (password !== confirmPassword) {
            alert("Mật khẩu không khớp!");
            return false;
        }

        // Xóa thông báo lỗi nếu mật khẩu hợp lệ
        // errorMessage.textContent = "";

        const json = {
            userName: username,
            password: password
        };

        // Gọi hàm đăng ký
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
                location.replace("/trang-chu");  // Điều hướng sau khi đăng ký thành công
            },
            error: function (result) {
                console.log(result.message);
                alert(result.detail);  // Hiển thị thông báo lỗi nếu có
            }
        });
    }
</script>


</body>
</html>



