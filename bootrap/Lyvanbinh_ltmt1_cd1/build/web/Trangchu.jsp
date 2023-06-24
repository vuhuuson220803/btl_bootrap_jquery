<%-- 
    Document   : danhsachnhanvien
    Created on : Jun 5, 2023, 8:28:10 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Quản lí nhân viên</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    </head>

    <body>
        <div class="container">
            <div class="form-container">
                <h2>Danh sách nhân viên</h2>
                <div class="table-responsive">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>STT</th>
                                <th>EMP_ID</th>
                                <th>NAME</th>
                                <th>POSITION</th>
                                <th>HIRE_DATE</th>
                                <th>SALARY</th>
                                <th>BRANCH_CODE</th>
                                <th>DEPARTMENT</th>
                                <th>Chức Năng</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                try {
                                    Class.forName("com.mysql.jdbc.Driver");
                                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lyvanbinh_ltmt1_cd1", "root", "");
                                    Statement stmt = conn.createStatement();
                                    ResultSet rs = stmt.executeQuery("SELECT * FROM quanlinhanvien");
                                    while (rs.next()) {
                                        String stt = rs.getString("STT");
                                        String emp_id = rs.getString("EMP_ID");
                                        String name = rs.getString("NAME");
                                        String position = rs.getString("POSITION");
                                        Date hire_date = rs.getDate("HIRE_DATE");
                                        String salary = rs.getString("SALARY");
                                        String branch_code = rs.getString("BRANCH_CODE");
                                        String department = rs.getString("DEPARTMENT");
                            %>
                            <tr>
                                <td><%= stt%></td>
                                <td><%= emp_id%></td>
                                <td><%= name%></td>
                                <td><%= position%></td>
                                <td><%= hire_date%></td>
                                <td><%= salary%></td>
                                <td><%= branch_code%></td>
                                <td><%= department%></td>                            
                                  

                            </tr>
                            
                        
                            <%
                                    }
                                    rs.close();
                                    stmt.close();
                                    conn.close();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            %>
                        </tbody>
                    </table>
                        <tr>
                                <td>
                                    <a href="Sua.jsp?">Sửa</a>
                                    <a href="Xoa.jsp?">Xóa</a>

                                </td> 
                            </tr>
                </div>
            </div>
        </div>
        <div class="btn-container">
            <a href="Themmoi.jsp" class="btn btn-primary">Thêm Nhân Viên Mới</a>
        </div>

        <!-- Bootstrap JS -->
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    </body>
</html>
