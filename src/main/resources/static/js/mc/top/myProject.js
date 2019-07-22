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
            var project1 = data.project;
            var list = data.list;
            var users = data.users;
            var html = "";
            html += '<input style="display: none" value=' + data.id + ' name="id">';
            html += '<table border="1" >';
            html += '<tr style="height: 40px ;background-color: #efefef">';
            html += '<td colspan="4" style="text-align: center">';
            html += '<b>项目详细</b>';
            html += '</td>';
            html += '<tr>';
            html += '<td style="width:150px ">项目编号：</td>';
            html += '<td style="width:300px ">' + project1.code + '</td>';
            html += '<td style="width:150px ">项目简称：</td>';
            html += '<td style="width:300px ">' + project1.name + '</td>';
            html += '</tr>';
            html += '<tr>';
            html += '<td >项目名称：</td>';
            html += '<td colspan="3">' + project1.abbreviation + '</td>';
            html += '</tr>';
            html += '<tr>';
            html += '<td>项目负责人：</td>';
            html += '<td>' + project1.principalUser.name + '</td>';
            html += '<td>项目地点：</td>';
            html += '<td>' + project1.site + '</td>';
            html += '</tr>';
            html += '<tr>';
            html += '<td>项目类别：</td>';
            html += '<td>' + project1.type + '</td>';
            html += '<td>项目立项时间：</td>';
            html += '<td>' + project1.createtime + '</td>';
            html += '</tr>';
            html += '<tr>';
            html += '<td>项目阶段：</td>';
            html += '<td>' + project1.stage + '</td>';
            html += '<td>项目预算金额：</td>';
            html += '<td>' + project1.budget + '</td>';
            html += '</tr>';
            html += '<tr>';
            html += '<td>项目招标方式：</td>';
            html += '<td>' + project1.biddingType + '</td>';
            html += '<td>预计项目投标时间：</td>';
            html += '<td>' + project1.biddate + '</td>';
            html += '</tr>';
            html += '<tr>';
            html += '<td>项目单位名称：</td>';
            html += '<td>' + project1.cooperationUnit + '</td>';
            html += '<td>项目合作方式：</td>';
            html += '<td>' + project1.cooperationType + '</td>';
            html += '</tr>';
            html += '<tr>';
            html += '<td>合作单位：</td>';
            html += '<td>' + project1.cooperationUnit + '</td>';
            html += '<td>合作伙伴姓名：</td>';
            html += '<td>' + project1.cooperationName + '</td>';
            html += '</tr>';
            html += '<tr>';
            html += '<td>职务：</td>';
            html += '<td>' + project1.cooperationRole + '</td>';
            html += '<td>联系方式：</td>';
            html += '<td>' + project1.cooperationPhone + '</td>';
            html += '</tr>';
            html += '<tr>';
            html += '<td>项目查看者：</td>';
            html += '<td colspan="3">';
            $.each(users, function (index, users) {
                html += '<span>' + users.name + "," + '</span>';
            })
            html += '</td>';
            html += '</tr>';
            html += '<tr>';
            html += '<td>项目描述：</td>';
            html += '<td colspan="3">' + project1.content + '</td>';
            html += '</tr>';
            html += '<tr>';
            html += '<td>附件文档：</td>';
            if (project1.accessory == undefined) {
                html += '<td colspan="3" >' + "无" + '</td>';
            } else {
                var strs = new Array(); //定义一数组
                strs = project1.accessory.split(","); //字符分割
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
            // html += ' <table class="approval " >';
            // html += '<tr style="height: 40px " >';
            // html += '<td colspan="4" style="text-align: center;width: 900px ">';
            // html += '<b>审批流程</b>';
            // html += '</td>';
            // html += '</tr>';
            // html += '<tr style="text-align: center;background-color: #0099ff">';
            // html += '<td style="width: 250px  ">名称</td>';
            // html += '<td style="width: 250px  ">时间</td>';
            // html += '<td style="width: 200px  ">审批意见</td>';
            // html += '<td style="width: 200px  ">审核状态</td>';
            // html += '</tr>';
            // $.each(list, function (index, list) {
            //     html += '<tr style="text-align: center">';
            //     html += '<td>' + list.user.name + '</td>';
            //     html += '<td>' + list.approvalDate + '</td>';
            //     html += '<td>' + list.opinion + '</td>';
            //     html += '<td>' + list.state + '</td>';
            //     html += '</tr>';
            // })
            // html += '</table>';
            html += ' <table class="approval " style="width: 900px ">';
            html += '<tr style="height: 40px;width:900px  " >';
            html += '<td colspan="6" style="text-align: center;width: 900px ">';
            html += '<b>审批流程</b>';
            // html += '<a style="float: right;color: red">'+project.processState+'</a>';
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
                html += '<td style="width: 20px  ">' + (index+1) + '</td>';
                html += '<td style="width: 50px  ">' + list.approvalIdentity + '</td>';
                html += '<td style="width: 50px  ">' + list.user.name + '</td>';
                html += '<td style="width: 50px  ">' + list.approvalDate + '' +
                    '</td>';
                html += '<td style="width: 200px  ">' + list.opinion + '</td>';
                html += '<td style="width: 50px  ">' + list.state + '</td>';
                html += '</tr>';
            });
            html += '<tr style="background-color: transparent;text-align: center">';
            html += '<td style="width: 20px  "><input style="text-align: center;border: 1px solid">';
            html += '<input style="display:none" value='+project1.id+'>';
            if(project1.processNode==1){
                html += '<input style="display:none" value="区域负责人">';
            }else if(project1.processNode==2){
                html += '<input style="display:none" value="信息中心">';
            }else if(project1.processNode==3){
                html += '<input style="display:none" value="公司分管领导">';
            }else if(project1.processNode==4){
                html += '<input style="display:none" value="公司领导">';
            }

            html += '</td>';

            html += '<td style="width: 50px  ">';
            html +=  '<select style="height: 27px">';
            html += '<option>请选择</option>';
            html += '<option>区域负责人</option>';
            html += '<option>信息中心</option>';
            html += '<option>公司分管领导</option>';
            html += '<option>公司领导</option>';
            html +=   '</select>';
            html += '</td>';
            html += '<td style="width: 50px  "><input style="text-align:center;border: 1px solid"></td>';
            html += '<td style="width: 50px  "><input type="text"  id="test1" style="text-align: center"></td>';
            html += '<td style="width: 200px  "><input style="width: 180px;text-align: center;border: 1px solid "></td>';
            html += '<td style="width: 50px  "><select style="height: 27px"><option>通过</option><option>转交</option></select></td>';
            html += '</tr>';
            html += '</table>';
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