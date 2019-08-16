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
    <link rel="stylesheet" href="<%=basePath%>/layui/css/modules/laydate/default/laydate.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/bd/project/projectAdd.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/bootstrap.js" type="text/javascript"></script>
    <script src="<%=basePath%>/layui/lay/modules/laydate.js" type="text/javascript"></script>

    <script src="<%=basePath%>/layuiAdmin.std-v1.0.0/src/layuiadmin/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=basePath%>/js/xadmin.js"></script>
    <script src="<%=basePath%>/js/public/jump.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/public/responsible.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/public/see.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/public/company.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/public/region.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/public/department.js" type="text/javascript"></script>
    <script src="<%=basePath%>/js/public/pipelineNumber.js" type="text/javascript"></script>
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
<div id="choice1" style="display: none">
    <p class="title">
        <img src="<%=basePath%>/imgs/root.png" height="40" width="40"/>
        广电智能
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
        广电智能
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
<div id="choice3" style="display: none">
    <p class="title">
        <img src="<%=basePath%>/imgs/root.png" height="40" width="40"/>
        广电智能
    </p>
    <ul class="name3" >
        <li class="co3">
            <a class="upload3" href="">
                <span class="name-block3"></span>
                <span class="name-none3" style="display: none"></span>
            </a>
        </li>
    </ul>

    <div id="close3">
        <a class="close-in" >返回</a >
    </div>
</div>
<div id="choice4" style="display: none">
    <p class="title">
        <img src="<%=basePath%>/imgs/root.png" height="40" width="40"/>
        广电智能
    </p>
    <ul class="name4" >
        <li class="co4">
            <a class="upload4" href="">
                <span class="name-block4"></span>
                <span class="name-none4" style="display: none"></span>
            </a>
        </li>
    </ul>

    <div id="close4">
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
                    <td class="Color" style="width: 150px ">项目编号</td>
                    <td style="width: 300px "><input id="xdataLX" style="width: 250px "  name="code" readonly></td>
                    <td class="Color" style="width: 150px ">项目简称</td>
                    <td style="width: 300px "><input style="width: 250px " required name="abbreviation" required></td>
                </tr>
                <tr style="height: 45px ">
                    <td class="Color">项目名称</td>
                    <td colspan="3"><input style="width: 650px " requiredb name="name" required></td>
                </tr>
                <tr style="height: 45px ">
                    <td class="Color">项目类别</td>
                    <td>
                        <%--<a  onclick="+xadmin.add_tab('我的工作','<%=basePath%>/showMyWork')"><b>aaaaaaaaa</b></a>--%>
                        <select  style="height: 25px " required required name="type">
                            <option value="">请选择</option>
                            <option >政府公建</option>
                            <option  >央企项目</option>
                            <option >国有企业</option>
                            <option >民营企业</option>
                            <option >房地产</option>
                            <option >私营企业分包</option>
                            <option >国有企业分包</option>
                        </select>
                    </td>
                    <td class="Color">项目地点</td>
                    <td><input style="width: 250px " name="site"></td>
                </tr>
                <tr style="height: 45px ">
                    <td class="Color">项目阶段</td>
                    <td>
                        <select style="height: 25px " name="stage">
                            <option value="">请选择</option>
                            <option >前期业务阶段</option>
                            <option >签约施工阶段</option>
                            <option >售后服务阶段</option>
                            <option>合约完成结束</option>
                            <option >未中标终止</option>
                        </select>
                    </td>
                    <td class="Color">项目预算金额</td>
                    <td><input style="width: 250px "  name="budget" oninput="value=value.replace(/[^\d]/g,'')"></td>

                </tr>
                <tr style="height: 45px ">
                    <td class="Color">项目资金来源</td>
                    <td>
                        <select style="height: 25px " name="capitalSource">
                            <option value="">请选择</option>
                            <option >财政预算投资</option>
                            <option >自筹资金投资</option>
                            <option >银行贷款投资</option>
                            <option >利用外资</option>
                        </select>
                    </td>

                    <td class="Color">项目招标方式</td>
                    <td>
                        <select style="height: 25px " name="biddingType">
                            <option value="">请选择</option>
                            <option value="公开招标">公开招标</option>
                            <option value="邀请招标">邀请招标</option>
                            <option value="涉密招标">涉密招标</option>
                        </select>
                    </td>

                </tr>
                <tr style="height: 45px ">
                    <td class="Color">项目负责人</td>
                    <td >
                        <input class="Eliminate" readonly>
                        <input style="display: none" class="Eliminate-no" name="principal">
                        <a target="_blank " class="add-to">添加</a>
                        <a class="clear-to" >
                            <input value="清空" class="input"  onClick="" type="button">
                        </a>
                    </td>
                    <td class="Color">项目单位名称</td>
                    <td>
                        <input class="Eliminate-1" readonly required>
                        <input style="display: none" class="Eliminate-no-1" name="clientid">
                        <a target="_blank "  class="add-to1">添加</a>
                        <a class="clear-to1" >
                            <input value="清空" class="input1"  onClick="" type="button">
                        </a>
                    </td>

                </tr>
                <tr style="height: 45px ">
                    <td class="Color">区域负责人</td>
                    <td>
                        <input class="Eliminate-3" readonly required>
                        <input style="display: none" class="Eliminate-no-3" name="areaManager">
                        <a target="_blank "  class="add-to3">添加</a>
                        <a class="clear-to3" >
                            <input value="清空" class="input3"  onClick="" type="button">
                        </a>
                    </td>

                    <td class="Color">所属机构</td>
                    <td>
                        <select class="department" style="height: 25px " name="deptid">
                            <option value="">请选择</option>
                        </select>
                    </td>

                </tr>
                <tr style="height: 45px ">
                    <td class="Color">项目立项时间</td>
                    <td ><input  type="text" class="demo-input" placeholder="请选择日期" id="test1"  name="createtime"></td>

                    <!--<input type="text" class="demo-input" placeholder="请选择日期" id="test1">-->
                    <td class="Color">预计项目投标时间</td>
                    <td>
                        <input style="width: 250px "  type="text" class="demo-input" placeholder="请选择日期" id="test2"  name="biddate">
                    </td>

                </tr>
                <!--<tr style="height: 45px ">-->

                <!--<td>项目业务情况</td>-->
                <!--<td colspan="3">-->
                <!--<input style="width: 750px ">-->
                <!--</td>-->
                <!--</tr>-->

                <!--<tr style="height: 45px ">-->
                <!--<td>项目查看者</td>-->
                <!--<td colspan="3" >-->
                <!--<textarea class="eliminate-2"  readonly required  style="width: 400px "></textarea>-->
                <!--<input style="display: none" class="eliminate-no-2"  name="examine">-->
                <!--<a target="_blank "  class="add-to2">添加</a>-->
                <!--<a class="clear-to2" >-->
                <!--<input value="清空" class="input2"  onClick="" type="button">-->
                <!--</a>-->
                <!--</td>-->

                <!--</tr>-->
                <tr style="height: 45px ">
                    <td class="Color">项目描述</td>
                    <td colspan="3">
                        <textarea name="content" style="width: 750px;height: 43px"> </textarea>
                    </td>
                </tr>
                <tr style="height: 45px ">
                    <td class="Color">添加附件</td>
                    <td colspan="3">
                        <input type="file" name="file">
                    </td>
                </tr>
            </table>
            <input  id="ok" type="submit" value="保存" style="margin-left: 350px ">

            <a href="/bd/project/query;" id="no" style="">返回</a>
        </form>
    </div>

</div>
<script type="text/javascript">
    laydate.render({
        elem: '#test1', //指定元素
        event: 'click',
        format: 'yyyy-MM-dd'
    });
    laydate.render({
        elem: '#test2', //指定元素
        event: 'click',
        format: 'yyyy-MM-dd'
    });
</script>
</body>
</html>
