<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập</title>
</head>
<body>
    <form action="login" method="post">
        <h2>Đăng nhập</h2>
        
        <c:if test="${alert != null}">
            <h3 class="alert alert-danger">${alert}</h3>
        </c:if>
        
        <section>
            <div class="input-group">
                <span class="input-group-addon">
                    <i class="fa fa-user"></i>
                </span>
                <input type="text" placeholder="Tài khoản" name="username" class="form-control" required>
            </div>
        </section>

        <section>
            <div class="input-group">
                <span class="input-group-addon">
                    <i class="fa fa-lock"></i>
                </span>
                <input type="password" placeholder="Mật khẩu" name="password" class="form-control" required>
            </div>
        </section>

        <button type="submit" class="btn btn-primary">Đăng nhập</button>
    </form>

    <!-- Thêm phần đăng ký -->
    <div>
        <p>Bạn chưa có tài khoản? <a href="${pageContext.request.contextPath}/register">Đăng ký ngay</a></p>
    </div>

</body>
</html>
