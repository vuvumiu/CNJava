<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập</title>
     <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    
    <style>
        body {
            background: #f0f2f5;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .container {
            background: #ffffff;
            padding: 30px 40px;
            border-radius: 12px;
            box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.1);
            width: 400px;
        }

        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 25px;
        }

        label {
            display: block;
            margin-bottom: 5px;
            color: #555;
            font-weight: 500;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 6px;
            box-sizing: border-box;
            transition: border-color 0.3s;
        }

        input[type="text"]:focus,
        input[type="password"]:focus {
            border-color: #007BFF;
            outline: none;
        }

        .form-check {
            display: flex;
            align-items: center;
            margin-bottom: 10px;
        }

        .form-check input {
            margin-right: 8px;
        }

        .text-end {
            text-align: right;
            margin-bottom: 15px;
        }

        .text-end a {
            font-size: 0.9em;
            color: #007BFF;
            text-decoration: none;
        }

        input[type="submit"] {
            width: 100%;
            background-color: #007BFF;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }

        .error-message {
            color: red;
            text-align: center;
            margin-top: 10px;
        }

        .login-footer {
            text-align: center;
            margin-top: 20px;
        }

        .login-footer a {
            color: #007BFF;
            text-decoration: none;
            font-weight: bold;
        }

        .social-buttons {
            display: flex;
            justify-content: center;
            gap: 10px;
            margin-top: 15px;
        }

        .social-buttons a {
            text-decoration: none;
            padding: 8px 12px;
            border-radius: 5px;
            border: 1px solid #ccc;
            font-size: 14px;
            transition: background-color 0.3s;
            color: #333;
        }

        .social-buttons a:hover {
            background-color: #e9ecef;
        }

    </style>

    <script>
        function validateForm() {
            const username = document.getElementById("username").value.trim();
            const password = document.getElementById("password").value.trim();
            if (username === "" || password === "") {
                alert("Vui lòng nhập đầy đủ tên đăng nhập và mật khẩu.");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>

<div class="container">
    <form action="login" method="post" onsubmit="return validateForm()">
        <h2>Đăng Nhập</h2>

        <label for="username">Tên đăng nhập:</label>
        <input type="text" name="username" id="username">

        <label for="password">Mật khẩu:</label>
        <input type="password" name="password" id="password">

        <div class="form-check">
            <input type="checkbox" id="remember" name="remember">
            <label for="remember">Ghi nhớ đăng nhập</label>
        </div>

        <div class="text-end">
            <a href="#">Quên mật khẩu?</a>
        </div>

        <input type="submit" value="Đăng nhập">

        <!-- Thông báo lỗi từ Server -->
        <%
            String message = (String) request.getAttribute("message");
            if (message != null && !message.isEmpty()) {
        %>
            <p class="error-message"><%= message %></p>
        <% } %>
    </form>

    <div class="login-footer">
        <p>Chưa có tài khoản? <a href="#">Đăng ký ngay</a></p>

        <p style="margin-top: 15px; color: #666;">Hoặc đăng nhập với:</p>
        <div class="social-buttons">
            <a href="#">Facebook</a>
            <a href="#">Google</a>
            <a href="#">GitHub</a>
        </div>
    </div>
</div>

</body>
</html>
