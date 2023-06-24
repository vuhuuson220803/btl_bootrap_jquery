import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Themmoi extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Hiển thị trang "ThemMoi.jsp" để thêm mới nhân viên
        request.getRequestDispatcher("Themmoi.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy thông tin từ request
        String emp_id = request.getParameter("EMP_ID");
        String name = request.getParameter("NAME");
        String position = request.getParameter("POSITION");
        String hire_date_str = request.getParameter("HIRE_DATE");
        String salary = request.getParameter("SALARY");
        String branch_code = request.getParameter("BRANCH_CODE");
        String department = request.getParameter("DEPARTMENT");

        // Chuyển đổi chuỗi hire_date_str thành đối tượng Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date hire_date = null;
        try {
            if (!hire_date_str.isEmpty()) {
                hire_date = dateFormat.parse(hire_date_str);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Kết nối cơ sở dữ liệu
        String jdbcURL = "jdbc:mysql://localhost:3306/lyvanbinh_ltmt1_cd1";
        String dbUser = "root";
        String dbPassword = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);

            // Chuẩn bị câu lệnh SQL
            String sql = "INSERT INTO quanlinhanvien (EMP_ID, NAME, POSITION, HIRE_DATE, SALARY, BRANCH_CODE, DEPARTMENT) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, emp_id);
            statement.setString(2, name);
            statement.setString(3, position);
            if (hire_date != null) {
                statement.setDate(4, new java.sql.Date(hire_date.getTime()));
            } else {
                statement.setNull(4, java.sql.Types.DATE);
            }
            statement.setString(5, salary);
            statement.setString(6, branch_code);
            statement.setString(7, department);

            // Thực thi câu lệnh SQL
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                response.sendRedirect("Trangchu.jsp");
            } else {
                response.getWriter().println("Lỗi: Không thể thêm mới nhân viên.");
            }

            statement.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Lỗi: " + e.getMessage());
        }
    }
}
