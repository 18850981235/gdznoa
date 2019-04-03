<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>验证码使用演示</title>
    <link href="<%=basePath%>/css/register.css" rel="stylesheet">
    <script src="<%=basePath%>/js/jquery-3.3.1.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/register.js" type="text/javascript"></script>
    <script>
        function getBasePath() {
            return '<%=basePath%>';
        }
    </script>
</head>
<body>
<form>
    <div class="row">
        <label>姓名: </label><input name="name">
    </div>
    <div class="row">
        <label>手机号:</label><input name="mobile"><span id="a" style="color: red"></span>
    </div>
    <div class="row">
        <label>密码:</label><input name="password">
    </div>
    <div class="row">
        <label>验证码:</label>
        <input name="verifyCode">
        <button type="button" class="sendVerifyCode">获取短信验证码</button>
    </div>
    <div>
        <button type="button" class="sub-btn">提交</button>
    </div>
</form>
</body>
</html>