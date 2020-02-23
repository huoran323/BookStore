<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>
<%@ include file="/WEB-INF/include/base.jsp" %>
<script type="text/javascript">
	
	$(function() {
		$(".dela").click(function(){
			/* 获取删除的title */
			//var title = $(this).parents("tr").children().html();
			//两种方式获取title
			var title = $(this).attr("id");
			if (confirm("确定删除【"+title+"】吗？") == false) {
				return false;
			}
		});
	});
</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">图书管理系统</span>
			<%@ include file="/WEB-INF/include/header.jsp" %>
	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>		
			<c:forEach items="${requestScope.books}" var="book">
				<tr>
					<td>${book.title }</td>
					<td>${book.price }</td>
					<td>${book.author }</td>
					<td>${book.sales }</td>
					<td>${book.stock }</td>
					<td><a href="BookServlet?method=getBookById&bookId=${book.id}">修改</a></td>
					<!-- 删除操作 需要将需要删除的id，传过去 -->
					<td><a class="dela" id="${book.title }" href="BookServlet?method=delBookById&bookId=${book.id}">删除</a></td>
				</tr>
			</c:forEach>
					
			
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_update.jsp">添加图书</a></td>
			</tr>	
		</table>
	</div>
	
	<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
	</div>
</body>
</html>