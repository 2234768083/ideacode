<%--
  Created by IntelliJ IDEA.
  User: YZY15
  Date: 2023/10/28
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>用户详情</title>
</head>
<body>
<div align="center">
    <table border="1">
        <tr>
            <td>用户编号</td>
            <td>用户姓名</td>
            <td>备注信息</td>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td><c:out value=" ${user.id}"></c:out></td>
                <td><c:out value=" ${user.userName}"></c:out></td>
                <td><c:out value=" ${user.note}"></c:out></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
