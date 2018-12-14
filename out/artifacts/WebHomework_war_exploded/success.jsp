<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/13
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>"登录成功"</title>

</head>
<body><%
    String name = request.getParameter("username");
%>
<%=
    "Welcome "+ name+"<br/>"
%>

    <%=
    "Login Successfully!"
    %>
</body>
</html>
