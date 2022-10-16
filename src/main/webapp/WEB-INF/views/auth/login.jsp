<%@include file="../../include/head.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--Spring Security TagLibs--%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Login</h1>
<form method="post">
  <input type="text" name="username" placeholder="Username">
  <input type="password" name="password" placeholder="Password">
  <button>Login</button>
</form>
<c:out value="${error}"/>
<a href="/auth/register">회원가입 하기</a>
<%@include file="../../include/footer.jsp"%>
