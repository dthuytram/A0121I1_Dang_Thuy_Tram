
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
float rate = Float.parseFloat(request.getParameter("rate"));
float usd = Float.parseFloat(request.getParameter("usd"));

float vnd =rate*usd;
%>

<h3>Rate : <%=rate%></h3>
<h3>USD : <%=usd%></h3>
<h3>VND : <%=vnd%></h3>
</body>
</html>
