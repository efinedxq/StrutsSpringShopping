<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'goodslist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <s:if test="pageNo>1">
  	<a href="getAllGoods?pageNo=1">
  </s:if>
  		第一页
  <s:if test="pageNo>1">
  	</a>
  </s:if>
  
  <s:if test="pageNo>1">
  	<a href="getAllGoods?pageNo=${pageNo-1}">
  </s:if>
  		上一页
  <s:if test="pageNo>1">
  	</a>
  </s:if>
  
  <s:if test="pageNo!=pageCount">
  	<a href="getAllGoods?pageNo=${pageNo+1}">
  </s:if>
  		下一页
  <s:if test="pageNo!=pageCount">
  	</a>
  </s:if>
  
  <s:if test="pageNo!=pageCount">
  	<a href="getAllGoods?pageNo=${pageCount}">
  </s:if>
  		最后一页
  <s:if test="pageNo!=pageCount">
  	</a>
  </s:if>
  共${pageCount }页，当前为第${pageNo }页
  
    <table border=1>
    	<tr>
    		<td>产品编号</td>
    		<td>产品名称</td>
    		<td>产品价格</td>
    	</tr>
		<s:iterator value="goodsList" var="goods" >
			<tr>
				<td>${goods.goodsId}</td>
				<td>${goods.goodsName}</td>
				<td>${goods.price}</td>
				<td><a href="addToCart?goodsId=${goods.goodsId}">将产品添加到购物车里</a></td>
			</tr>
		</s:iterator>    
    </table>
  </body>
</html>
