/**
 * Created by Administrator on 2019/4/12.
 */
function w() {
    var id = q("id");
    var url = "/bd/project/particular.html?id=" + id;
    $.ajax({
        type: "post",
        dataType: "json",
        url: url,
        success: function (data) {
            var project = data.project;
            var list = data.list;

            var html = "";
            html += '<input style="display: none" value=' + project.id + ' name="id">';
            html +='<table border="1">';
            html +='<tr style="height: 45px ">';
            html +='<td colspan="4" style="text-align: center;background-color: #efefef">立项详情</td>';
            html +='</tr>';
            html +='<tr style="height:45px ">';
            html +='<td style="width: 150px " class="Color">项目编号</td>';
            html +='<td style="width: 300px ">'+project.code+'</td>';
            html +='<td style="width: 150px " class="Color">项目简称</td>';
            html +='<td style="width: 300px ">'+project.abbreviation+'</td>';
            html +='</tr>';
            html +='<tr style="height: 45px ">';
            html +='<td class=" Color">项目名称</td>';
            html +='<td colspan="3">'+project.name+'</td>';
            html +='</tr>';
            html +=' <tr style="height: 45px ">';
            html +='<td class="Color">项目类别</td>';
            html +='<td>'+project.type+'</td>';
            html +='<td class="Color">项目地点</td>';
            html +='<td>'+project.site+'</td>';
            html +='</tr>';
            html +='<tr style="height: 45px ">';
            html +='<td class="Color">项目阶段</td>';
            html +='<td>'+project.stage+'</td>';
            html +='<td class="Color">项目预算金额</td>';
            html +='<td>'+project.budget+'</td>';
            html +='</tr>';
            html +='<tr style="height: 45px ">';
            html +='<td class="Color">项目资金来源</td>';
            html +=' <td>'+project.capitalSource+'</td>';
            html +='<td class="Color">项目招标方式</td>';
            html +='<td>'+project.biddingType+'</td>';
            html +='</tr>';
            html +=' <tr style="height: 45px ">';
            html +=' <td class="Color">项目负责人</td>';
            html +=' <td >'+project.principalUser.name+'</td>';
            html +=' <td class="Color">项目单位名称</td>';
            html +=' <td>'+project.client.name+'</td>';
            html +='</tr>';
            html +='<tr style="height: 45px ">';
            html +=' <td class="Color">区域负责人</td>';
            html +=' <td>'+project.areaManagerUser.name+'</td>';
            html +=' <td class="Color">所属机构</td>';
            html +='  <td>'+project.dept.name+'</td>';
            html +='</tr>';
            html +='<tr style="height: 45px ">';
            html +='<td class="Color">项目立项时间</td>';
            html +=' <td >'+project.createtime+'</td>';
            html +=' <td class="Color">预计项目投标时间</td>';
            html +=' <td>'+project.biddate+'</td>';
            html +='</tr>';
            html +='<tr style="height: 45px ">';
            html +='<td class="Color">项目描述</td>';
            html +='<td colspan="3">'+ project.content+'</td>';
            html +='</tr>';

            html += '<tr>';
            html += '<td class="Color">附件</td>';
            if (project.accessory == undefined) {
                html += '<td colspan="3" >' + "无" + '</td>';
            } else {
                var strs = new Array(); //定义一数组
                strs = project.accessory.split(","); //字符分割
                html += '<td colspan="3" >'
                for (i = 0; i < strs.length; i++) {

                    if (strs[i] != "") {
                        html += '<form action="/util/fileDown" >';
                        html += '<input name="file" style="width:400px ;" value=' + strs[i] + ' >';
                        html += '<input style="background-color: transparent"  type="submit" value="点击下载">';
                        html += ' </form>';
                    }
                }
                html += '</td>';
            }

            html += '</tr>';
            html += '</table>';

            html += ' <table class="approval " style="width: 900px ">';
            html += '<tr style="height: 40px;width:900px  " >';
            html += '<td colspan="6" style="text-align: center;width: 900px ">';
            html += '<b>审批流程</b>';
// html += '<a style="float: right;color: red">'+project.processState+'</ a>';
            html += '</td>';
            html += '</tr>';
            html += '<tr style="text-align: center;background-color: #0099ff;width:900px ;height: 40px ">';
            html += '<td style="width: 20px  ">序号</td>';
            html += '<td style="width: 50px  ">审批部门</td>';
            html += '<td style="width: 50px  ">审批人员</td>';
            html += '<td style="width: 50px  ">审批时间</td>';
            html += '<td style="width: 200px  ">审批意见</td>';
            html += '<td style="width: 50px  ">审核状态</td>';
            html += '</tr>';
            $.each(list, function (index, list) {
                html += '<tr style="text-align: center;width:900px ;height: 40px">';
                html += '<td style="width: 50px  ">' + (index+1) + '</td>';
                html += '<td style="width: 150px  ">' + list.approvalIdentity + '</td>';
                html += '<td style="width: 150px  ">' + list.user.name + '</td>';
                html += '<td style="width: 150px  ">' + list.approvalDate +'</td>';
                html += '<td style="width: 250px ">' + list.opinion + '</td>';
                html += '<td style="width: 150px  ">' + list.state + '</td>';
                html += '</tr>';
            });
            html += '<tr style="background-color: transparent;text-align: center">';
            html += '<td style="width: 50px  ">'+project.processNode+'<input style="display:none" value='+project.id+' name="approvalId">';
            html += '</td>';


            if(project.processNode==1){
                html += '<td style="width: 150px;text-align: center  ">区域负责人</td>';
                // html += '<input style="display:block;width: 200px ;text-align: center;margin: 0px " value="商务部审核">';
            }else if(project.processNode==2){
                html += '<td style="width: 150px;text-align: center  ">信息中心</td>';
                // html += '<input style="display:block;width: 200px ;text-align: center;margin: 0px" value="分公司总经理审准">';
            }else if(project.processNode==3){
                html += '<td style="width: 150px;text-align: center  ">公司分管领导</td>';
                // html += '<input style="display:block;width: 200px ;text-align: center;margin: 0px" value="信息中心复核">';
            }else if(project.processNode==4){
                html += '<td style="width: 150px;text-align: center  ">公司领导</td>';
                // html += '<input style="display:block;width: 200px ;text-align: center;margin: 0px" value="申请人归还">';
            }

            html += '<td style="width: 150px  ">'+project.processUser.name+'<input style="display:none" value='+project.processUser.id+' name="approvalUser"></td>';
            html += '<td style="width: 150px  "><input type="text"  id="test1" style="text-align: center" ></td>';
            html += '<td style="width: 250px  "><input style="width: 180px;text-align: center;border: 1px solid " name="opinion"></td>';
            html += '<td style="width: 150px  "><select style="height: 27px" name="state"><option value="同意">同意</option><option value="退回">退回</option></select></td>';
            html += '</tr>';
            $("#center").prepend(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
        }
    });
}
$(document).ready(function () {
    w();
})
function q(name){
    var search = document.location.search;
    var pattern = new RegExp("[?&]"+name+"\=([^&]+)", "g");
    var matcher = pattern.exec(search);
    var items = null;
    if(null != matcher){
        try{
            items = decodeURIComponent(decodeURIComponent(matcher[1]));
        }catch(e){
            try{
                items = decodeURIComponent(matcher[1]);
            }catch(e){
                items = matcher[1];
            }
        }
    }
    return items;
};

$(document).ready(function () {

    // var year=myDate.getFullYear(); //年
    // var mon=date.getMonth()+1;	//月
    // var day=date.getDate();		//日
    var myDate = new Date();
//获取当前年
    var year=myDate.getFullYear();
//获取当前月
    var month=myDate.getMonth()+1;
//获取当前日
    var date=myDate.getDate();
    if(month<10){
        daytime=year +"-0"+month+"-"+date;
    }else {
        daytime=year +"-"+month+"-"+date;
    }

    $("#test1").val(daytime);

})