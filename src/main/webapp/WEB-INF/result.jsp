<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>회원 가입 결과</title>
</head>
<body>
<h1><%= "회원 가입 처리 완료" %></h1>
<br/>

<%
  String message = (String) request.getAttribute("resultMessage");

  if (message == null) {
    message = "데이터 처리 중 알 수 없는 오류가 발생했습니다.";
  }
%>

<p>
  **<%= message %>**
</p>

<br/>

<a href="memberRegister.html">첫 화면으로</a>
</body>
</html>