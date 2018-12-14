<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/14
  Time: 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录失败！！！</title>
</head>
<body>
<%
    String name = request.getParameter("username");
%>
<%=
"Login failed,No ID named "+ name+" was found "+"<br/>"
%>

</body>
</html>
