<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示</title>
<script type="text/javascript"src="${pageContext.request.contextPath}/statics/js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#exportAllBtn").click(function() {
			if (window.confirm("确定导出吗？")) {
				window.location.href = "${pageContext.request.contextPath}/project/export";
			}
		});
		$("#exportChkBtn").click(function() {
			if ($("input[type=checkbox]").size() == 0) {
				alert("请选择要导出的数据！");
			} else {
				if (window.confirm("确定导出吗？")) {
					var sendData = "";
					$.each($(":checkbox[name='id']:checked"),function(i,n){
						sendData += "&id=" + n.value;
					});
					sendData = sendData.substr(1);
					window.location.href = "${pageContext.request.contextPath}/project/exportChk?"+sendData;
				}
			}
		});
		$("#checkId").click(function(){
			if(($("#checkId").attr("checked"))){
				$(".chkbox").attr("checked",true);
			}else{
				$(".chkbox").attr("checked",false);
			}
		});
	});
</script>
</head>
<body>
	<div align="center">
		<table border="1">
			<tr>
				<td><input type="checkbox" name="id" id="checkId">全选</td>
				<td>项目编号</td>
				<td>项目名称</td>
				<td>开标地点</td>
				<td>预算</td>
			</tr>
			<c:forEach var="list" items="${project}">
				<tr>
					<td><input type="checkbox" name="id" class="chkbox" value="${list.id}"></td>
					<td>${list.id }</td>
					<td>${list.projectName }</td>
					<td>${list.startAddress }</td>
					<td>${list.budget }</td>
				</tr>
			</c:forEach>
		</table>
		<button type="button" id="exportAllBtn">导出全部</button>
		<button type="button" id="exportChkBtn">导出选中</button>
	</div>
</body>
</html>