import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Xoa extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Hiển thị trang JSP Xoa.jsp để xác nhận xóa
        request.getRequestDispatcher("/Xoa.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy thông tin Id sản phẩm cần xóa từ request
        String stt = request.getParameter("stt");

        // Kết nối cơ sở dữ liệu
        String jdbcURL = "jdbc:mysql://localhost:3306/lyvanbinh_ltmt1_cd1";
        String dbUser = "root";
        String dbPassword = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);

            // Chuẩn bị câu lệnh SQL để xóa sản phẩm
            String sql = "DELETE FROM quanlinhanvien WHERE STT=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, stt);

            // Thực hiện xóa nhân viên
            int rowsDeleted = statement.executeUpdate();

            // Đóng kết nối
            statement.close();
            conn.close();

            if (rowsDeleted > 0) {
                response.sendRedirect("Trangchu.jsp");
            } else {
                response.getWriter().println("Lỗi: Không tìm thấy nhân viên để xóa");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Lỗi: " + e.getMessage());
        }
    }
}
