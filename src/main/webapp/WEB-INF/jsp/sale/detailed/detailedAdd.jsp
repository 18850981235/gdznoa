<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/26
  Time: 11:13
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
    <title>销售合同清单新增</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" href="<%=basePath%>/icon-font/iconfont.css">
    <link rel="stylesheet" href="<%=basePath%>/../layui/css/modules/laydate/default/laydate.css">
    <link rel="stylesheet" href="<%=basePath%>/css/jump-in.css">
    <link rel="stylesheet" href="<%=basePath%>/css/sale/detailed/detailedAdd.css">
    <script src="<%=basePath%>/js/jquery-3.3.1.js"></script>
    <!--<script src="https://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>-->
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/bootstrap-paginator.js"></script>
    <!--<script src="<%=basePath%>/../layui/lay/modules/laydate.js" type="text/javascript"></script>-->
    <!--<script src="<%=basePath%>/js/public/jump.js"></script>-->
    <script src="<%=basePath%>/js/sale/detailed/detailedAdd.js"></script>
    <base Target="_blank" />
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
<div id="content-in">
    <div id="center">
        <div >
            <table border="1">
                <tr style="height: 40px  ;background-color: #efefef">
                    <td colspan="4" style="text-align: center;width: 1200px">
                        <b>销售合同清单新增</b>
                    </td>
                </tr>

            </table>
            <form id="on"   enctype="multipart/form-data">
                <span>项目名称</span>
                <select id="ap" style="height: 30px;width: 250px  " name="projectId">
                    <option value="">请选择</option>
                </select>
                <span>状态</span>
                <select class="type" style="width: 200px ;height:35px " name="type">
                    <option value="">请选择</option>
                    <option value="新建清单">新建清单</option>
                    <option value="增加清单">增加清单</option>
                    <option value="减少清单">减少清单</option>
                </select>
                <span>系统名称</span>
                <select class="systemId"  style="height: 30px;width: 120px  " name="system">
                    <option>请选择</option>
                </select>
                <!--<form id="uploadForm" enctype="multipart/form-data">-->
                <input class="File" type="file" style="float: left;margin-top: 50px " name="file">
                <!--</form>-->
                <!--<input class="File" type="file" style="float: left;margin-top: 50px " name="file">-->
                <!--<input class="File-in" style="float: left; cursor: pointer;margin-top: 45px "  type="submit">-->
            </form>
            <button id="upfile">上传文件</button>
            <a onclick="clearMethod3()">清空</a>

            <table  style="text-align: center">
                <tr style="height: 40px ;background-color:#c4de83 ">
                    <td style="width: 40px; ">序号</td>
                    <td style="width: 130px ">设备编码</td>
                    <td style="width: 130px ">名称</td>
                    <td style="width: 100px ">规格型号</td>
                    <td style="width: 100px ">参数</td>
                    <td style="width: 150px ">品牌</td>
                    <td style="width: 100px ">单位</td>
                    <td style="width: 100px ">数量</td>
                    <td style="width: 100px ">单价</td>
                    <td style="width: 100px ">小计</td>
                    <td style="width: 150px ">备注</td>
                </tr>
            </table>
            <table id="con" style="border: 1px solid;height: 400px ;overflow: auto">
                <!--<tr class="huo" style="height: 40px;display:none; ">-->
                <!--<td style="width: 40px; ">serialnum</td>-->
                <!--<td style="width: 130px; ">code</td>-->
                <!--<td style="width: 131px;">name</td>-->
                <!--<td style="width: 100px; ">model</td>-->
                <!--<td style="width: 100px; ">parameter</td>-->
                <!--<td style="width: 150px;padding: 3px ">trademark</td>-->
                <!--<td style="width: 100px; ">unit</td>-->
                <!--<td style="width: 100px ">num</td>-->
                <!--<td style="width: 100px; ">unitCost</td>-->
                <!--<td style="width: 100px; ">subtotal</td>-->
                <!--<td style="width: 150px; ">remarks</td>-->
                <!--</tr>-->

                <!--<tr style="height: 40px; "><td style="width: 150px; "><input style="width: 140px " name="code"></td><td style="width: 151px;"><input style="width: 143px " name="name"></td><td style="width: 100px; "><input style="width: 95px " name="model"></td><td style="width: 100px; "><input  style="width: 95px " name="parameter"></td><td style="width: 150px; ;padding: 3px "><select style="width: 140px ;height: 30px;margin-right: auto;margin-left: auto  " id="trademarkid" name="trademark"><option value="">请选择</option></select></td><td style="width: 100px; "><input style="width: 95px " name="unit"> </td><td style="width: 100px "><input style="width: 95px " name="num"></td><td style="width: 100px; "><input style="width: 95px " name="unitCost"></td><td style="width: 100px; "><input style="width: 95px " name="subtotal"></td><td style="width: 150px; "><input style="width: 140px " name="remarks"></td></tr>-->
            </table>
            <div style="float: right;margin-top: 10px ">
                <span>合计</span>
                <span id="dian" style="color: #ff061c">点击计算</span>

                <input id="heji"  style="width: 250px;height: 30px;border: 1px solid  "  >
                <input id="id" style="display: none">
            </div>


            <input id="ok"  type="submit" value="确定" style="margin-left:520px ">
            <a  id="no">取消</a>
        </div>
    </div>
</div>
<script>
    function qwe() {
//      var   ee=$(".huo").val();
////        console.log(ee)
////       ee.find("td").each(function(){
////            console.log(this)
////       })
//
//        for(var i=0 ;i<$(".huo").length;i++){
////            for(var q=0 ;q<$(".huo").length;q++) {
//             var   eee=$("tr").eq(i).find("td:first").val();
////            }
//        }
//        console.log(eee)

        $("#con").find("tr").each(function() {
            var tdArr = $(this).children();
            var q = tdArr.eq(0).find("input").val();//收入类别
            var w = tdArr.eq(1).find("input").val();//收入金额
            var e = tdArr.eq(2).find("input").val();//    备注
            var r = tdArr.eq(3).find("input").val();//    备注
            var t = tdArr.eq(4).find("select").val();//    备注
        })
//        console.log("name="+q+"code="+w+"id="+e)
    }
    //清空历史文件（上传文件）
    function clearMethod3() {
        $("#con").html(value="")
        var objFile=document.getElementsByTagName('input')[0];
        objFile.outerHTML=objFile.outerHTML.replace(/(value=\").+\"/i,"$1\"");
        return false
    }
</script>
</body>
</html>