<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thêm Mới</title>
        <style>
            @font-face {
                font-family: MyCustomFont;
                src: url(path-to-your-font/font-file.ttf);
            }

            body {
                background-color: #f1f1f1; /* Màu nền trang */
                font-family: Arial, sans-serif;
            }

            h1 {
                text-align: center;
            }

            form {
                background-color: #f9f9f9; /* Màu nền của form */
                width: 300px;
                margin: 0 auto;
                margin-top: 50px;
                padding: 20px;
                border-radius: 5px;
                box-shadow: 0 0 5px rgba(0, 0, 0, 0.3); /* Hiệu ứng đổ bóng */
            }

            label {
                display: block;
                margin-bottom: 5px;
            }

            input[type="text"],
            input[type="date"],
            input[type="submit"],
            select {
                width: 100%;
                padding: 10px;
                margin-bottom: 10px;
                border: 1px solid #ccc;
                border-radius: 3px;
            }

            input[type="submit"] {
                background-color: #4CAF50;
                color: #fff;
                border: none;
                border-radius: 3px;
                cursor: pointer;
            }

            input[type="submit"]:hover {
                background-color: #45a049;
            }

            input[type="reset"] {
                background-color: #f44336;
                color: #fff;
                border: none;
                border-radius: 3px;
                cursor: pointer;
            }

            input[type="reset"]:hover {
                background-color: #d32f2f;
            }
        </style>
    </head>
    <body>
        <h1>Thêm Mới Nhân Viên</h1>
        <form action="Themmoi" method="post">
            Mã Nhân Viên(*) <input type="text" name="EMP_ID" required><br>
            Họ & Tên(*): <input type="text" name="NAME" required><br>
            Chức Vụ: <input type="text" name="POSITION" required><br>
            Ngày Thuê: <input type="date" name="HIRE_DATE"><br>
            Lương: <input type="text" name="SALARY" required><br>
            Mã Ngành: <input type="text" name="BRANCH_CODE" required><br>
            Phòng: <input type="text" name="DEPARTMENT" required><br>
            <input type="submit" value="Lưu">
            <input type="reset" value="Reset">
        </form>
    </body>
</html>
