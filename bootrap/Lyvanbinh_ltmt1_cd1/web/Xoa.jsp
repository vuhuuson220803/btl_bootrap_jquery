<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Xóa Nhân Viên</title>
    <style>
        /* CSS cho giao diện trang JSP */
        /* ... */
    </style>
</head>
<body>
    <h1>Xác nhận Xóa Nhân Viên</h1>
    <form action="Xoa" method="post">
        Nhập STT Nhân Viên: <input type="text" name="stt" required><br>
        <input type="submit" value="Xóa">
        <input type="reset" value="Reset">
    </form>
</body>
</html>
