package vn.iostar.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iostar.services.IUserService;
import vn.iostar.services.impl.UserServiceImpl;

@WebServlet(urlPatterns = {"/login"})
public class LoginController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		//Lấy tham số từ view
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String remember = req.getParameter("remember");
		
		String alertMsg="";
		boolean isRememberMe = false;
		if("on".equals(remember)){
			 isRememberMe = true;
			 }
		IUserService userService = new UserServiceImpl();
	}
}
