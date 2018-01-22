<%--
  Created by IntelliJ IDEA.
  User: llh
  Date: 2018/1/22
  Time: 23:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--<form action="${pageContext.request.contextPath}/use/login" method="get">--%>
        <%--用户名：<input type="text" name="username"/><br/>--%>
        <%--密码：<input type="password" name="password"/><br/>--%>
        <%--<input type="submit" value="登录"/>--%>
    <%--</form>--%>

    <form action="${pageContext.request.contextPath}/book/list" method="get">
        <input type="submit" value="查看"/>
    </form>
${list}
</body>
</html>
