<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<table>
		<th>
			<td>id</td>
			<td>名字</td>
			<td>工作单位</td>
			<td>地址</td>
			<td>操作</td>
	
		</th>
	<c:forEach items="${listUser }" var="u">
		<tr>
			<td>${u.id }</td> 
			<td>${u.userName }</td>
			<td>${u.workUnit }</td>
			<td>${u.address }</td>
			<td><a href="${pageContext.request.contextPath }/user/update?id=${u.id }">修改</a></td>
		</tr>
	
	</c:forEach>
		
	
	
	
	</table>
</body>
</html>