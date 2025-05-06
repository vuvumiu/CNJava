<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kiểm tra tam giác</title>
</head>
<body>
    <h2>Kiểm tra xem 3 số có phải là độ dài 3 cạnh của tam giác không</h2>
    <form method="get">
        <label>Nhập cạnh a: </label><input type="text" name="a"><br>
        <label>Nhập cạnh b: </label><input type="text" name="b"><br>
        <label>Nhập cạnh c: </label><input type="text" name="c"><br>
        <input type="submit" value="Kiểm tra">
    </form>
    <hr>
<%
    String sa = request.getParameter("a");
    String sb = request.getParameter("b");
    String sc = request.getParameter("c");

    if (sa != null && sb != null && sc != null) {
        try {
            int a = Integer.parseInt(sa);
            int b = Integer.parseInt(sb);
            int c = Integer.parseInt(sc);

            if (a > 0 && b > 0 && c > 0 && a + b > c && a + c > b && b + c > a) {
                out.println("<p style='color:green;'>Ba số " + a + ", " + b + ", " + c + " là độ dài 3 cạnh của một tam giác.</p>");
            } else {
                out.println("<p style='color:red;'>Ba số " + a + ", " + b + ", " + c + " không thể là 3 cạnh của một tam giác.</p>");
            }
        } catch (NumberFormatException e) {
            out.println("<p style='color:red;'>Vui lòng nhập đúng định dạng số nguyên.</p>");
        }
    }
%>
</body>
</html>
