<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">修改用户信息</h1>
<div align="center">
		<form action="${pageContext.request.contextPath}/user/doupdate" method="post">
			<table border="1">
				<tr>
					<td>用户名</td>
					<td><input type="text" name="userName" value="${user.userName }"></td>
				</tr>
				<tr>
					<td>密码</td>
					<td><input type="text" name="user.userpwd" value="${user.userpwd }"></td>
				</tr>
				<tr>
					<td>工作单位</td>
					<td><input type="text" name="workUnit" value="${user.workUnit }"></td>
				</tr>
				<tr>
					<td>地址</td>
					<td><input type="text" name="address" value="${user.address }"></td>
					
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="提交"> 
						&nbsp;&nbsp;
						<input type="reset"	value="重置">
						<input type="hidden" name="id" value="${user.id }">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>