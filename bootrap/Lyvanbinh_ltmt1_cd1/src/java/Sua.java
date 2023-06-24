
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Sua extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Hiển thị trang JSP Sua.jsp để xác nhận sửa thông tin
        request.getRequestDispatcher("Sua.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Lấy thông tin từ request
    String stt = request.getParameter("STT");
    String emp_id = request.getParameter("EMP_ID");
    String name = request.getParameter("NAME");
    String position = request.getParameter("POSITION");
    String hire_date = request.getParameter("HIRE_DATE");
    String salary = request.getParameter("SALARY");
    String branch_code = request.getParameter("BRANCH_CODE");
    String department = request.getParameter("DEPARTMENT");

    // Kết nối cơ sở dữ liệu
    String jdbcURL = "jdbc:mysql://localhost:3306/lyvanbinh_ltmt1_cd1";
    String dbUser = "root";
    String dbPassword = "";

    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);

        // Chuẩn bị câu lệnh SQL để cập nhật thông tin sản phẩm
        String sql = "UPDATE quanlinhanvien SET EMP_ID=?, NAME=?, POSITION=?, SALARY=?, BRANCH_CODE=?, DEPARTMENT=?";
        if (hire_date != null && !hire_date.isEmpty()) {
            sql += ", HIRE_DATE=?";
        }
        sql += " WHERE STT=?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, emp_id);
        statement.setString(2, name);
        statement.setString(3, position);
        statement.setString(4, salary);
        statement.setString(5, branch_code);
        statement.setString(6, department);
        int parameterIndex = 7;
        if (hire_date != null && !hire_date.isEmpty()) {
            statement.setString(parameterIndex++, hire_date);
        }
        statement.setString(parameterIndex, stt);

        // Thực thi câu lệnh SQL
        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            response.sendRedirect("Trangchu.jsp");
        } else {
            response.getWriter().println("Lỗi: Không tìm thấy sản phẩm để sửa");
        }

        statement.close();
        conn.close();
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
        response.getWriter().println("Lỗi: " + e.getMessage());
    }
}

}
