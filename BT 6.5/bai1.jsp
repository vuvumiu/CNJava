<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Giải phương trình bậc 2</title>
</head>
<body>
    <h2>Giải phương trình bậc 2: ax² + bx + c = 0</h2>
    <form method="get">
        <label>Nhập a: <input type="text" name="a" required></label><br><br>
        <label>Nhập b: <input type="text" name="b" required></label><br><br>
        <label>Nhập c: <input type="text" name="c" required></label><br><br>
        <input type="submit" value="Giải" />
    </form>

    <hr>

    <%
        // Kiểm tra xem đã truyền tham số chưa
        String sa = request.getParameter("a");
        String sb = request.getParameter("b");
        String sc = request.getParameter("c");
        if (sa != null && sb != null && sc != null) {
            try {
                double a = Double.parseDouble(sa);
                double b = Double.parseDouble(sb);
                double c = Double.parseDouble(sc);

                out.println("<h3>Kết quả:</h3>");
                if (a == 0) {
                    // Trường hợp a = 0 trở về phương trình b x + c = 0
                    if (b == 0) {
                        if (c == 0) {
                            out.println("Phương trình vô số nghiệm.");
                        } else {
                            out.println("Phương trình vô nghiệm.");
                        }
                    } else {
                        double x = -c / b;
                        out.println(String.format("Phương trình bậc nhất có nghiệm x = %.4f", x));
                    }
                } else {
                    double delta = b * b - 4 * a * c;
                    if (delta < 0) {
                        out.println("Phương trình vô nghiệm (delta &lt; 0).");
                    } else if (delta == 0) {
                        double x = -b / (2 * a);
                        out.println(String.format("Phương trình có nghiệm kép x1 = x2 = %.4f", x));
                    } else {
                        double sqrtDelta = Math.sqrt(delta);
                        double x1 = (-b + sqrtDelta) / (2 * a);
                        double x2 = (-b - sqrtDelta) / (2 * a);
                        out.println(String.format("Phương trình có 2 nghiệm phân biệt:<br>x1 = %.4f<br>x2 = %.4f", x1, x2));
                    }
                }
            } catch (NumberFormatException e) {
                out.println("Vui lòng nhập các giá trị số hợp lệ!");
            }
        }
    %>
</body>
</html>