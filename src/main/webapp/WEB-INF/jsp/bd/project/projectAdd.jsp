<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/28
  Time: 14:53
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
    <title>立项申请</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/bd/project/projectAdd.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/public/jump.js"></script>
    <script src="<%=basePath%>/js/public/responsible.js"></script>
    <script src="<%=basePath%>/js/public/see.js"></script>
    <script src="<%=basePath%>/js/public/company.js"></script>
</head>
<body>
<jsp:include page="../../in-topleft.jsp"/>
<div id="page">
    <!---->
    <a class="page-left ">项目立项</a>
</div>
<div id="choice" style="display: none">
    <p class="title">
        <img src="<%=basePath%>/imgs/root.png" height="40" width="40"/>
        福建省广电智能系统集成工贸有限公司
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

<div id="choice1" style="display: none">
    <p class="title">
        <img src="<%=basePath%>/imgs/root.png" height="40" width="40"/>
        福建省广电智能系统集成工贸有限公司
    </p>
    <ul class="name1" >
        <li class="co1">
            <a class="upload1" href="">
                <span class="name-block1"></span>
                <span class="name-none1" style="display: none"></span>
            </a>
        </li>
    </ul>

    <div id="close1">
        <a class="close-in" >返回</a >
    </div>
</div>
<div id="choice2" style="display: none">
    <p class="title">
        <img src="<%=basePath%>/imgs/root.png" height="40" width="40"/>
        福建省广电智能系统集成工贸有限公司
    </p>
    <ul class="yiji-no2">
        <li style="display:none;">
            <a href="#" class="click"></a>
            <ul class="name2" style="display: none">
                <li>
                    <a class="upload-noe" href="">
                        <span class="name-block2"></span>
                        <span class="name-none2" style="display: none"></span>
                    </a>
                </li>
            </ul>
        </li>
    </ul>
    <div id="close2">
        <a class="close-in" >返回</a >
    </div>
</div>
<!---->
<div id="content-in">
    <div id="center">
        <form  method="post" action="/bd/project/addProject" enctype="multipart/form-data">
            <table border="1">
                <tr style="height: 45px ">
                    <td colspan="4" style="text-align: center;background-color: #efefef">项目立项</td>
                </tr>
                <tr style="height:45px ">
                    <td style="width: 150px ">项目编号:</td>
                    <td style="width: 300px "><input style="width: 250px " required  name="code"></td>
                    <td style="width: 150px ">项目简称</td>
                    <td style="width: 300px "><input style="width: 250px " required name="abbreviation"></td>
                </tr>
                <tr style="height: 45px ">
                    <td>项目名称:</td>
                    <td colspan="3"><input style="width: 650px " requiredb name="name"></td>
                </tr>
                <tr style="height: 45px ">
                    <td>项目负责人:</td>
                    <td >
                        <input class="Eliminate" readonly>
                        <input style="display: none" class="Eliminate-no" name="principal">
                        <a target="_blank " class="add-to">添加</a>
                        <a class="clear-to" >
                            <input value="清空" class="input"  onClick="" type="button">
                        </a>
                    </td>
                    <td>项目地点：</td>
                    <td><input style="width: 250px " name="site"></td>
                </tr>
                <tr style="height: 45px ">
                    <td>项目类别:</td>
                    <td>
                        <select  style="height: 25px " required required name="type">
                            <option value="">请选择</option>
                            <option value="政府公建项目">政府公建项目</option>
                            <option value="国有企业项目" >国有企业项目</option>
                            <option value="民营企业项目">民营企业项目</option>
                            <option value="地产类项">地产类项目</option>
                            <option value="政府BT型项目">政府BT型项目</option>
                            <option value="国企BT型项目">国企BT型项目</option>
                            <option value="其他类型项目">其他类型项目</option>
                        </select>
                    </td>
                    <td>项目立项时间：</td>
                    <td ><input  type="date"  name="createtime"></td>
                </tr>
                <tr style="height: 45px ">
                    <td>项目阶段:</td>
                    <td>
                        <select style="height: 25px " name="stage">
                            <option value="">请选择</option>
                            <option value="政府公建项目">前期业务阶段</option>
                            <option value="国有企业项目" >签约施工阶段</option>
                            <option value="民营企业项目">售后服务阶段</option>
                            <option value="地产类项">合约完成结束</option>
                            <option value="政府BT型项目">未中标终止</option>
                        </select>
                    </td>
                    <td>项目预算金额：</td>
                    <td><input style="width: 250px "  name="budget"></td>
                </tr>
                <tr style="height: 45px ">
                    <td>项目招标方式：</td>
                    <td>
                        <select style="height: 25px " name="biddingType">
                            <option value="">请选择</option>
                            <option value="公开招标">公开招标</option>
                            <option value="邀请招标">邀请招标</option>
                            <option value="涉密招标">涉密招标</option>
                        </select>
                    </td>
                    <td>预计项目投标时间：</td>
                    <td>
                        <input style="width: 250px " type="date" name="biddate">
                    </td>
                </tr>
                <tr style="height: 45px ">
                    <td>项目单位名称</td>
                    <td>
                        <input class="Eliminate-1" readonly required>
                        <input style="display: none" class="Eliminate-no-1" name="clientid">
                        <a target="_blank "  class="add-to1">添加</a>
                        <a class="clear-to1" >
                            <input value="清空" class="input1"  onClick="" type="button">
                        </a>
                    </td>
                    <td>项目合作方式：</td>
                    <td>
                        <select style="height: 25px " required name="cooperationType">
                            <option value="">请选择</option>
                            <option value="公司自主项目">公司自主项目</option>
                            <option value="合作项目">合作项目</option>
                        </select>
                    </td>
                </tr>
                <tr style="height: 45px ">
                    <td>合作单位：</td>
                    <td><input style="width: 250px " name="cooperationUnit"></td>
                    <td>合作伙伴姓名：</td>
                    <td><input style="width: 250px " name="cooperationName"></td>
                </tr>
                <tr style="height: 45px ">
                    <td>职务：</td>
                    <td><input style="width: 250px " name="cooperationRole"></td>
                    <td>联系方式：</td>
                    <td><input style="width: 250px " name="cooperationPhone"></td>
                </tr>
                <tr style="height: 45px ">
                    <td>项目查看者：</td>
                    <td colspan="3" >
                        <textarea class="eliminate-2"  readonly required></textarea>
                        <input style="display: none" class="eliminate-no-2"  name="examine">
                        <a target="_blank "  class="add-to2">添加</a>
                        <a class="clear-to2" >
                            <input value="清空" class="input2"  onClick="" type="button">
                        </a>
                    </td>

                </tr>
                <tr style="height: 45px ">
                    <td>项目描述：</td>
                    <td colspan="3">
                        <textarea name="content"> </textarea>
                    </td>
                </tr>
                <tr style="height: 45px ">
                    <td>添加附件：</td>
                    <td colspan="3">
                        <input type="file" name="file">
                    </td>
                </tr>
            </table>
            <input id="ok" type="submit" value="保存" style="margin-left: 350px ">
            <a href="" id="no" style="">返回</a>
        </form>
    </div>

</div>
</body>
</html>
