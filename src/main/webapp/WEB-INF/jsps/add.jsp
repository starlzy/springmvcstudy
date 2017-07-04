<%--
  Created by IntelliJ IDEA.
  User: lzy
  Date: 02/07/17
  Time: 下午 02:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>添加用户</title>
</head>
<body>
<!-- 如没写action, 也会提交给add(匹配文件名) -->
<sf:form method="post" modelAttribute="student" action="addOne">
    name:<sf:input path="name"/><sf:errors path="name"/><br/>
    class:<sf:input path="course"/><sf:errors path="course"/><br/>
    score:<sf:input path="score"/><sf:errors path="score"/><br/>
    <input type="submit" value="添加用户"/>
</sf:form>
</body>
</html>