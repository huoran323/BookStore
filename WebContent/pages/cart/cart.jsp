<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
<%@ include file="/WEB-INF/include/base.jsp" %>
<script type="text/javascript">
	$(function() {
		$(".cartItemCount").change(function(){
			//获取默认值
			var dValue = $(this)[0].defaultValue;
			
			var bookId = $(this).attr("id");
			var count = $(this).val();
			//定义正则规则(非0的正整数)
			var countReg = /^\+?[1-9][0-9]*$/;
			if (!countReg.test(count)) {
			
				alert("购买数量输入有误！请重新输入");
				$(this).val(dValue);
				return false;
			}
			
			//校验库存
			//获取库存
			var stock = $(this).attr("name");
			if (parseInt(count)>parseInt(stock)){
				
				alert("库存不足！库存只剩"+stock+"件商品啦！");
				$(this).val(dValue);
				return false;
			}
			
			//location = "CartServlet?method=updateCartItemCount&bookId="+bookId+"&count="+count;
			var $amountTr = $(this).parent().next().next();
			$.getJSON("CartServlet?method=updateCartItemCount",{"bookId":bookId,"count":count}, function(msg){
				//将数据显示指定位置
				$(".b_count").html(msg.totalCount);
				$(".b_price").html(msg.totalAmount);
				$amountTr.html(msg.amount);
			});
		});
	});
</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
			<%@ include file="/WEB-INF/include/welcome.jsp" %>
	</div>
	
	<div id="main">
		<c:if test="${empty sessionScope.cart.cartItems }">
			<span>购物车暂无数据，去<a href="index.jsp">购物</a></span>
		</c:if>
		<c:if test="${not empty sessionScope.cart.cartItems }">
			<table>
				<tr>
					<td>商品名称</td>
					<td>数量</td>
					<td>单价</td>
					<td>金额</td>
					<td>操作</td>
				</tr>		
				<c:forEach var="cartItem" items="${sessionScope.cart.cartItems }">
					<tr>
						<td>${cartItem.book.title }</td>
						<td>
							<input type="text" class="cartItemCount" name="${cartItem.book.stock }" id="${cartItem.book.id }" value="${cartItem.count }" size="3" style="text-align: center" />	
						</td>
						<td>${cartItem.book.price }</td>
						<td>${cartItem.amount }</td>
						<td><a href="CartServlet?method=delCartItem&bookId=${cartItem.book.id }">删除</a></td>
					</tr>	
				</c:forEach>
			</table>
			
			<div class="cart_info">
				<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount }</span>件商品</span>
				<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalAmount }</span>元</span>
				<span class="cart_span"><a href="CartServlet?method=emptyCart">清空购物车</a></span>
				<span class="cart_span"><a href="OrderServlet?method=checkout">去结账</a></span>
				<span class="cart_span"><a href="index.jsp">继续购物</a></span>
			</div>
		</c:if>
		
	</div>
	
	<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
	</div>
</body>
</html>