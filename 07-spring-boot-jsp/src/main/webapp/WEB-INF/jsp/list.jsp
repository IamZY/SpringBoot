<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户列表展示</title>
</head>
<body>
	<h1>用户列表展示</h1>

	<table>
		<tr>
			<td>编号</td>
			<td>姓名</td>
			<td>年龄</td>
		</tr>

		<c:forEach items="${list}" var="user">
			<tr>
				<td>${user.id}</td>
				<td>${user.name}</td>
				<td>${user.age}</td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>