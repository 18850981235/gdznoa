<%--
  Created by IntelliJ IDEA.
  User: lpy
  Date: 2019/1/9
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>资历证书修改</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/layui/css/modules/laydate/default/laydate.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/mc/mcStamp/mcStampAdd.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <script src="<%=basePath%>/layui/lay/modules/laydate.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/public/jump.js"></script>
    <script src="<%=basePath%>/js/public/department.js"></script>
    <script src="<%=basePath%>/js/public/responsible.js"></script>
    <script src="<%=basePath%>/js/public/yearPeople.js"></script>
    <script src="<%=basePath%>/js/mc/mcCertificate/mcCertificatePadute.js"></script>
</head>
<body>
<div id="choice" style="display: none">
    <p class="title">
        <img src="<%=basePath%>/imgs/root.png" height="40" width="40"/>
        广电智能
    </p>
    <ul class="yiji-no">
        <li style="display:none;">
            <a href="#" class="click"></a>
            <ul class="name" style="display: none">
                <li class="co">
                    <a class="upload" href="">
                        <span class="name-block"></span>
                        <span class="name-none" style="display: none"></span>
                    </a>
                </li>
            </ul>
        </li>
    </ul>
    <div id="close">
        <a class="close-in" >返回</a >
    </div>
</div>
<div id="choice6" style="display: none">
    <p class="title">
        <img src="<%=basePath%>/imgs/root.png" height="40" width="40"/>
        广电智能
    </p >
    <ul class="yiji-no6">
        <li style="display:none;">
            <a href=" " class="click"></a>
            <ul class="name" style="display: none">
                <li class="co6">
                    <a class="upload6" href="">
                        <span class="name-block6"></span>
                        <span class="name-none6" style="display: none"></span>
                    </a>
                </li>
            </ul>
        </li>
    </ul>
    <div id="close6">
        <a class="close-in" >返回</a>
    </div>
</div>
<div id="content-in">
    <div id="center">
        <form action="/mc/qualification/updateImpl" method="post" enctype="multipart/form-data">
             <input style="display: none"  name="id">
             <table border="1">  
             <tr style="height: 40px ;background-color: #efefef">  
                 <td colspan="4" style="text-align: center">  
                     <b>资历证书修改</b>  
                     </td>  
                 </tr>  
             <tr style="height:40px;">  
                 <td style="width:150px ;background-color: #efefef;">  
                     <span>证书名称</span>  
                     </td>  
                 <td style="width:300px ;">  
                     <input style="width: 280px "  name="name">
                     </td>  
                 <td style="width:150px ;background-color: #efefef;">管理负责人</td>  
                 <td >  
                     <input  class="Eliminate" readonly  >
                     <input required style="display: none" class="Eliminate-no"  name="userid">
                     <a target="_blank " class="add-to">添加</a>  
                     <a class="clear-to" >  
                         <input value="清空" class="input"  onClick="" type="button">  
                         </a>  
                     </td>  

                 </tr>  
             <tr  style="height:40px;">  
                 <td style="width:150px ;;background-color: #efefef">证书类型</td>  
                 <td style="width:300px ;">  
                     <select class="zhengshu" style="width: 100px;height: 30px " name="type">  
                         <option  > '+data[0].type+'</option>  
                         <option>类型1</option>  
                         <option>类型2</option>  
                         </select>  
                     </td>  
                 <td style="width:150px ;background-color: #efefef;">证书管理部门</td>  
                 <td style="width:300px ;">  
                     <select class="department" style="width: 100px;height: 30px " name="deptid">
                         </select>  
                     </td>  
                 <tr style="height:40px;">  
                 <td style="width:150px ;background-color: #efefef;">级别内容</td>  
                 <td > <select class="neiron"  required style="width: 100px;height:30px " name="content">  
                     <option>'+data[0].content+'</option>  
                     <option>类型1</option>  
                     <option>类型2</option>  
                     </select></td>  
                 <td style="width:150px;background-color: #efefef;">证书状态</td>  
                 <td >  
                     <select class="state" style="width: 100px;height: 30px " name="state">  
                         <option ></option>
                         <option>类型1</option>  
                         <option>类型2</option>  
                         </select>  
                     </td>  
                 </tr>  

             <tr style="height:40px;">  
                 <td style="width:150px ;background-color: #efefef;">证书借用情况</td>  
                 <td ><input style="width: 280px "  name="borrow"></td>
                 <td style="width:150px ;background-color: #efefef;">年审时间</td>  
                 <td  ><input style="width: 280px "   type="text"   placeholder="请选择日期" id="test1"  name="annualTime"  ></td>
                 </tr>  
             <tr style="height:40px;">  
                 <td style="width:150px ;background-color: #efefef;">年审负责人</td>  
                 <td >  
                     <input class="Eliminate-6" readonly  >
                     <input style="display: none" class="Eliminate-no-6" name="annualPrincipal">
                      <a target="_blank " class="add-to6">添加</a>  
                      <a class="clear-to6" >  
                          <input value="清空" class="input6"  onClick="" type="button">  
                          </a>  
                     </td>  
                 <td style="width:150px ;background-color: #efefef;">PDF导出</td>  
                 <td >  
                     <form  href="/mc/qualification/pdf" >  
                         <input type="file" value="添加水印" />  
                         <input type="submit" value="制作"/>  
                         </form>  
                     </td>  

                 </tr>  
             <tr style="height:40px;">  
                 <td style="width:150px ;background-color: #efefef;">证书</td>  
                 <td colspan="3">  
                     <input  type=file  name="file">'
                     </td>  

                 </tr>  
             </table>  

            <%--$("#center form").prepend(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容--%>

            <input id="ok"  type="submit" value="确定" style="margin-left:400px ">
            <a href="/mc/qualification/query"id="no"  >取消</a>
        </form>

    </div>
</div>
<script type="text/javascript">
    laydate.render({
        elem: '#test1', //指定元素
        event: 'click',
        format: 'yyyy-MM-dd'
    });

</script>
</body>

</html>

