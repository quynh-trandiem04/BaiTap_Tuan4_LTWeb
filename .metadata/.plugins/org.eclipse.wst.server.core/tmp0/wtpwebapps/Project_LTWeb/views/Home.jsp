<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>File Upload Page</title>
</head>
<body>
    <h1>Hello</h1>

    <!-- Form to handle logout -->
    <form action="${pageContext.request.contextPath}/logout" method="get">
        <button type="submit">Logout</button>
    </form>

    <br/>

    <!-- Form to upload a file using Servlet Multipart -->
    <form method="post" action="${pageContext.request.contextPath}/multiPartServlet" enctype="multipart/form-data">
        <!-- File input for uploading a file -->
        Choose a file: 
        <input type="file" name="uploadFile" required /> 
        <input type="submit" value="Upload" />
    </form>

</body>
</html>
