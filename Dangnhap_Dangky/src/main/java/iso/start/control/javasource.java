package iso.start.control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/home","/login"})
public class javasource extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");

        if ("login".equals(action)) {
            // Xử lý đăng nhập
            String tendangnhap = req.getParameter("Email");
            String matkhau = req.getParameter("Matkhau");

            try (Connection con = DBConnectMySQL.getDatabaseConnection()) {
                if (con != null) {
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM taikhoan WHERE Email = ? AND Matkhau = ?");
                    ps.setString(1, tendangnhap);
                    ps.setString(2, matkhau);

                    ResultSet rs = ps.executeQuery();
                    
                    if (rs.next()) {
                        RequestDispatcher rd = req.getRequestDispatcher("Views/Trangchu.jsp");
                        rd.forward(req, resp);
                    } else {
                        resp.getWriter().println("Tên đăng nhập hoặc mật khẩu không đúng.");
                    }
                } else {
                    throw new SQLException("Không thể kết nối tới cơ sở dữ liệu.");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                resp.getWriter().println("Lỗi kết nối cơ sở dữ liệu: " + ex.getMessage());
            }
        } else if ("register".equals(action)) {
            String hovaten = req.getParameter("Hovaten");
            String sdt = req.getParameter("SDT");
            String email = req.getParameter("Email");
            String matkhau = req.getParameter("Matkhau");

            try (Connection con = DBConnectMySQL.getDatabaseConnection()) {
                if (con != null) {
                    PreparedStatement checkStmt = con.prepareStatement("SELECT * FROM taikhoan WHERE Email = ?");
                    checkStmt.setString(1, email);
                    ResultSet rs = checkStmt.executeQuery();
                    
                    if (rs.next()) {
                        resp.getWriter().println("Email này đã được sử dụng. Vui lòng chọn email khác.");
                    } else {
                        PreparedStatement ps = con.prepareStatement("INSERT INTO taikhoan (SDT, Hovaten, Email, Matkhau) VALUES (?, ?, ?, ?)");
                        ps.setString(1, sdt);
                        ps.setString(2, hovaten);
                        ps.setString(3, email);
                        ps.setString(4, matkhau);
                        
                        
                        int result = ps.executeUpdate();
                        
                        if (result > 0) {
                            RequestDispatcher rd = req.getRequestDispatcher("Views/Dangnhap/Dangnhap.jsp");
                            rd.forward(req, resp);
                        } else {
                            resp.getWriter().println("Đăng ký thất bại. Vui lòng thử lại sau.");
                        }
                    }
                } else {
                    throw new SQLException("Không thể kết nối tới cơ sở dữ liệu.");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                resp.getWriter().println("Lỗi kết nối cơ sở dữ liệu: " + ex.getMessage());
            }
        }
    }


}
