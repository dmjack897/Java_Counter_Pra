<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	int intCnt=0;
    	if(session.getAttribute("CNT")!=null)
    	{
    		intCnt = (Integer)session.getAttribute("CNT");
    	}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>カウンタ 数 : <%= intCnt %></h1>
</body>
</html>