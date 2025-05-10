<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head><meta charset="UTF-8"><title>Login</title></head>
<body>
<h2>Form đăng nhập</h2>

<c:if test="${not empty error}">
    <p style="color:red;"><c:out value="${error}"/></p>
</c:if>

<form action="login" method="post">
    <label>Username:</label>
    <input type="text" name="username" value="${param.username}" required />
    <br/><br/>
    <label>Password:</label>
    <input type="password" name="password" required />
    <br/><br/>
    <button type="submit">Login</button>
</form>
</body>
</html>