<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
	<head>
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>Form Đăng Nhập</title>
	    <style>
	        body {
	            font-family: Arial, sans-serif;
	            display: flex;
	            justify-content: center;
	            align-items: center;
	            height: 100vh;
	            background-color: #f0f0f0;
	            margin: 0;
	        }
	        
	        .login-container {
	            background-color: #ffffff;
	            padding: 20px;
	            border-radius: 8px;
	            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	            width: 300px;
	        }
	        
	        .login-container h2 {
	            text-align: center;
	            margin-bottom: 20px;
	            color: #333;
	        }
	        
	        .login-container label {
	            display: block;
	            margin-bottom: 8px;
	            color: #555;
	        }
	        
	        .login-container input[type="text"],
	        .login-container input[type="password"] {
	            width: 95%;
	            padding: 8px;
	            margin-bottom: 15px;
	            border: 1px solid #ccc;
	            border-radius: 4px;
	        }
	        
	        .login-container input[type="submit"] {
	            width: 100%;
	            padding: 8px;
	            background-color: #4CAF50;
	            color: white;
	            border: none;
	            border-radius: 4px;
	            cursor: pointer;
	        }
	        
	        .login-container input[type="submit"]:hover {
	            background-color: #45a049;
	        }
	
	        .error-message {
	            color: red;
	            text-align: center;
	            margin-top: 15px;
	        }
	    </style>
	</head>
	<body>
	    <div class="login-container">
	        <h2>Đăng Nhập</h2>
	        <form action="/Dangnhap_Dangky/home" method="POST">
	            <input type="hidden" name="action" value="login">
	
	            <label for="Email">Tên đăng nhập:</label>
	            <input type="text" id="Email" name="Email" required>
	            
	            <label for="Matkhau">Mật khẩu:</label>
	            <input type="password" id="Matkhau" name="Matkhau" required>
	            
	            <input type="submit" value="Đăng Nhập">
	        </form>
	
	        <c:if test="${not empty message}">
	            <p class="error-message">${message}</p>
	        </c:if>
	    </div>
	</body>
</html>
