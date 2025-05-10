<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head><title>Chuyển đổi nhiệt độ</title></head>
<body>
<h2>Ứng dụng chuyển đổi nhiệt độ</h2>

<form action="convert" method="post">
    <input type="text" name="temperature" value="${param.temperature}" />
    <select name="type">
        <option value="CtoF" ${param.type == 'CtoF' ? 'selected' : ''}>C -> F</option>
        <option value="FtoC" ${param.type == 'FtoC' ? 'selected' : ''}>F -> C</option>
    </select>
    <button type="submit">Chuyển đổi</button>
</form>

<c:if test="${not empty error}">
    <p style="color:red"><c:out value="${error}"/></p>
</c:if>

<c:if test="${not empty result}">
    <p>Kết quả: <c:out value="${result}"/></p>
</c:if>

<c:set var="requestCount" value="${applicationScope.requestCount != null ? applicationScope.requestCount : 0}"/>
<p>Đã có <c:out value="${requestCount}"/> yêu cầu.</p>

</body>
</html>