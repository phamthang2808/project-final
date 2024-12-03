<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Sign up account</title>

    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

    <link href="css/sb-admin-2.min.css" rel="stylesheet">

</head>
<body class="bg-gradient-primary">
<div class="container">
    <div class="card o-hidden border-0 shadow-lg my-5">
        <div class="card-body p-0">
            <div class="row">
                <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                <div class="col-lg-7">
                    <div class="p-5">
                        <div class="text-center">
                            <h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
                        </div>
                        <form id="signupForm" class="user">
                            <%--                            <div class="form-group row">--%>
                            <%--                                <div class="col-sm-6 mb-3 mb-sm-0">--%>
                            <%--                                    <input type="text" class="form-control form-control-user" id="exampleFirstName"--%>
                            <%--                                           placeholder="First Name">--%>
                            <%--                                </div>--%>
                            <%--                                <div class="col-sm-6">--%>
                            <%--                                    <input type="text" class="form-control form-control-user" id="exampleLastName"--%>
                            <%--                                           placeholder="Last Name">--%>
                            <%--                                </div>--%>
                            <%--                            </div>--%>
                            <div class="form-group">
                                <input type="text" class="form-control form-control-user" id="username"
                                       placeholder="User Name">
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-control form-control-user" id="fullname"
                                       placeholder="Full Name">
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <input type="password" class="form-control form-control-user"
                                           id="password" placeholder="Password">
                                </div>
                                <div class="col-sm-6">
                                    <input type="password" class="form-control form-control-user"
                                           id="confirm_password" placeholder="Repeat Password">
                                </div>
                            </div>
                                <button type="submit" class="btn btn-primary btn-user btn-block" id="signup"> Register Account</button>
<%--                            <a href="login.html" class="btn btn-primary btn-user btn-block">--%>
<%--                                Register Account--%>
<%--                            </a>--%>
                            <hr>
                            <a href="index.html" class="btn btn-google btn-user btn-block">
                                <i class="fab fa-google fa-fw"></i> Register with Google
                            </a>
                            <a href="index.html" class="btn btn-facebook btn-user btn-block">
                                <i class="fab fa-facebook-f fa-fw"></i> Register with Facebook
                            </a>
                        </form>
                        <hr>
                        <div class="text-center">
                            <a class="small" href="forgot-password.html">Forgot Password?</a>
                        </div>
                        <div class="text-center">
                            <a class="small"   href="${pageContext.request.contextPath}/login">Already have an account? Login!</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>
<script src="js/sb-admin-2.min.js"></script>
<script>

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







