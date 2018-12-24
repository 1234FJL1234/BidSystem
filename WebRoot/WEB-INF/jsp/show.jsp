<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<style>
div {
	border: 0px solid white;
}

#infoes {
	height: 40px;
	font-size: 20px;
	te
}

#info {
	width: 180px;
	height: 360px;
	float: left;
}

#showInfo {
	width: 1200px;
	height: 400px;
}

li {
	list-style: none;
	font-size: 20px;
}

#infoList {
	margin-top: 0px;
}
</style>
</head>
<body>
<div>
		<div align="center" style="line-height: 100px">
			<h1>采购评标专家抽签系统</h1>
		</div>
		<div id="infoes"> 
			用户名:<span>${session_user.userName }</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="#">退出</a>
			<a href="${pageContext.request.contextPath }/user/updatepwd">修改密码</a>
		</div>
		<div id="info">
			<div align="center" id="infoList">
				<ul>
					<li><a href="${pageContext.request.contextPath}/user/finduser" target="show">用户管理</a></li>
				</ul>
				<ul>
					<li><a href="${pageContext.request.contextPath}/RealEstate/findAll" target="show">项目管理</a></li>
				</ul>
				<ul>
					<li><a href="${pageContext.request.contextPath}/RealEstate/findAll" target="show">专家管理</a></li>
				</ul>
			</div>
		</div>
		<div id="showInfo">
			<iframe name="show" width="880" height="355" src="${pageContext.request.contextPath}/Users/welcome">
			</iframe>
		</div>
	</div>
</body>
</html>