<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sửa Thông Tin</title>
      
    </head>
    <body>
        <h1>Sửa Thông Tin Nhân Viên</h1>
        <form action="Sua" method="post">
            Nhập STT Nhân Viên cần sửa: <input type="text" name="STT" required><br>
            EMP_ID(*) <input type="text" name="EMP_ID" required><br>
            NAME(*): <input type="text" name="NAME" required><br>
            POSITION: <input type="text" name="POSITION" required><br>
            HIRE_DATE: <input type="date" name="HIRE_DATE"><br>
            SALARY: <input type="text" name="SALARY" required><br>
            BRANCH_CODE: <input type="text" name="BRANCH_CODE" required><br>
            DEPARTMENT: <input type="text" name="DEPARTMENT" required><br>
            <input type="submit" value="Lưu">
            <input type="reset" value="Reset">
        </form>
    </body>
    
</html>
