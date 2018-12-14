<%@ page language="java" pageEncoding="UTF-8" errorPage="Login.jsp" %>
<%
    request.setCharacterEncoding("UTF-8");
    String username = "";
    int visitTimes = 0;
    Cookie[] cookies = request.getCookies();
    for(int i=0; cookies!=null&&i<cookies.length; i++){
        Cookie cookie = cookies[i];
        if("username".equals(cookie.getName())){
            username = cookie.getValue();
        }
        else if("visitTimes".equals(cookie.getName())){
            visitTimes = Integer.parseInt(cookie.getValue());
            cookie.setValue("" + ++visitTimes);
        }
    }
    if(username == null || username.trim().equals("")){
        throw new Exception("您还没有登录。请先登录");
    }
    Cookie visitTimesCookie = new Cookie("visitTimes", Integer.toString(++visitTimes));
    response.addCookie(visitTimesCookie);

%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Cookie</title>
</head>
<body>
<div align="center" style="margin:10px; ">
    <fieldset>
        <legend>登录信息</legend>
        <form action="Login.jsp" method="post">
            <table>
                <tr>
                    <td>
                        您的帐号：
                    </td>
                    <td>
                        <%= username %>
                    </td>
                </tr>
                <tr>
                    <td>
                        登录次数：
                    </td>
                    <td>
                        <%= visitTimes %>
                    </td>
                </tr>
                <tr>
                    <td>
                    </td>
                    <td>
                        <input type="button" value=" 刷  新 "
                               onclick="location='<%= request.getRequestURI() %>?ts=' + new Date().getTime(); "
                               class="button">

                    </td>
                </tr>
            </table>
        </form>
    </fieldset>
</div>
<%
    response.setHeader("refresh", "3;URL=http://www.pornhub.com/");
%>
    <br><div style="text-align: center;"><span style="color: red; font-size: large; "> 登录成功,精彩内容马上呈现！！！<br> <br>
    三秒后将跳转到登录页面 <br> <br> 如果没有跳转,请按 <a href="success.jsp?username=<%=username%>">这里</a>!!!
    <br> </span></div>


</body>
</html>
