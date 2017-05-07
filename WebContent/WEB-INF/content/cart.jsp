<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'cart.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 <script type="text/javascript">
    function modifyGoods(i){
    	
    	alert("MMMMMMM:i"+i);
    	f = document.forms[i-1];
    	f.action = "modifyGoods";
    }
    function deleteGoods( i){
    	alert("DDDDDDD:i"+i);
    	f = document.forms[i-1];
    	f.action = "deleteGoods";
    }
  </script>
  </head>
  
  <body>
  <a href="getAllGoods">继续购物</a>
  <a href="clearCart">清空购物车</a>
  
  
  <s:if test="!cart.isEmpty()">
  	
	<table border="1">
		<tr>
			<td>物品编号</td>
			<td>物品名称</td>
			<td>物品价格</td>
			<td>物品数量</td>
			<td></td>
		</tr>
		<s:iterator value="cart" var="item" status="st">
		<tr>
		<form  method="post" >
		<input type="hidden" name="goodsId" value="${item.goods.goodsId}"/>
			<td>${item.goods.goodsId}</td>
			<td>${item.goods.goodsName}</td>
			<td>${item.goods.price}</td>
			<td><input type="text" name="quantity" value="${item.quantity}"/></td>
			<td>
			  <input type="submit" id="modify" onclick="modifyGoods(<s:property value="#st.count"/>);"  value="修 改" />  
			  <input type="submit" id="delete" onclick="deleteGoods(<s:property value='#st.count'/>);" value="删 除" /></td>
		</form>
		</tr>
		</s:iterator>
  	
  	</table> 
  </s:if>
   <s:if test="cart==null||cart.isEmpty()">
   	购物车为空，请直接购物！
   </s:if>
 
  </body>
</html>
