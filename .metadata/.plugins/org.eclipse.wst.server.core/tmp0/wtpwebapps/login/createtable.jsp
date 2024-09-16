<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vn.iostar.configs.DBMyconnect"%>
<%@ page import = "java.sql.*"%>

<%
	try{
		Connection con = DBMyconnect.getConn();
		Statement st = con.createStatement();
		
		string q1 = "create table users(name varchar )";
		system.out.println(q1); // hiển thị hệ thống
		st.execute(q1);
		system.out.println(st);
		con.close();
		
	}catch(Exception e){
		system.out.println(e);
	}




%>