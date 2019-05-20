/**
 * Created by Administrator on 2019/4/12.
 */
//审批
function w() {
    var id = q("id");
    var url = "http://192.168.1.191:8080/mc/stamp/update.json?id=" + id;
    $.ajax({
        type: "post",
        dataType: "json",
        url: url,
        success: function (data) {
            var project = data.project;
            var list = data.list;
            var users = data.users;
            var html = "";
            $.each(project, function (index, project) {
                html += '<input style="display: none" value=' + data.id + ' name="id">';
                html += '<table border="1" >';
                html += '<tr>';
                html += '<td colspan="4" style="text-align: center">';
                html += '<b>项目详细</b>';
                html += '</td>';
                html += '<tr>';
                html += '<td style="width:150px ">项目编号：</td>';
                html += '<td style="width:300px ">' + project.code + '</td>';
                html += '<td style="width:150px ">项目简称：</td>';
                html += '<td style="width:300px ">' + project.name + '</td>';
                html += '</tr>';
                html += '<tr>';
                html += '<td >项目名称：</td>';
                html += '<td colspan="3">' + project.abbreviation + '</td>';
                html += '</tr>';
                html += '<tr>';
                html += '<td>项目负责人：</td>';
                html += '<td>' + project.principalUser.name + '</td>';
                html += '<td>项目地点：</td>';
                html += '<td>' + project.site + '</td>';
                html += '</tr>';
                html += '<tr>';
                html += '<td>项目类别：</td>';
                html += '<td>' + project.type + '</td>';
                html += '<td>项目立项时间：</td>';
                html += '<td>' + project.biddate + '</td>';
                html += '</tr>';
                html += '<tr>';
                html += '<td>项目阶段：</td>';
                html += '<td>' + project.stage + '</td>';
                html += '<td>项目预算金额：</td>';
                html += '<td>' + project.budget + '</td>';
                html += '</tr>';
                html += '<tr>';
                html += '<td>项目招标方式：</td>';
                html += '<td>' + project.biddingType + '</td>';
                html += '<td>预计项目投标时间：</td>';
                html += '<td>' + project.updatetime + '</td>';
                html += '</tr>';
                html += '<tr>';
                html += '<td>项目单位名称：</td>';
                html += '<td>' + project.cooperationUnit + '</td>';
                html += '<td>项目合作方式：</td>';
                html += '<td>' + project.cooperationType + '</td>';
                html += '</tr>';
                html += '<tr>';
                html += '<td>合作单位：</td>';
                html += '<td>' + project.cooperationUnit + '</td>';
                html += '<td>合作伙伴姓名：</td>';
                html += '<td>' + project.cooperationName + '</td>';
                html += '</tr>';
                html += '<tr>';
                html += '<td>职务：</td>';
                html += '<td>' + project.cooperationRole + '</td>';
                html += '<td>联系方式：</td>';
                html += '<td>' + project.cooperationPhone + '</td>';
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
                html += '<td colspan="3">' + project.content + '</td>';
                html += '</tr>';
                html += '<tr>';
                html += '<td>附件文档：</td>';
                if (project.accessory == undefined) {
                    html += '<td colspan="3" >' + "无" + '</td>';
                } else {
                    var strs = new Array(); //定义一数组
                    strs = project.accessory.split(","); //字符分割
                    html += '<td colspan="3" >'
                    for (i = 0; i < strs.length; i++) {

                        if (strs[i] != "") {
                            html += '<form action="http://192.168.1.191:8080/util/fileDown" >';
                            html += '<input name="file" style="width:400px ;" value=' + strs[i] + ' >';
                            html += '<input style="background-color: transparent"  type="submit" value="点击下载">';
                            html += ' </form>';
                        }
                    }
                    html += '</td>';
                }

                html += '</tr>';
                html += '</table>';
                html += ' <table class="approval " >';
                html += '<tr style="height: 40px " >';
                html += '<td colspan="4" style="text-align: center;width: 900px ">';
                html += '<b>审批流程</b>';
                html += '</td>';
                html += '</tr>';
                html += '<tr style="text-align: center;background-color: #0099ff">';
                html += '<td style="width: 250px  ">名称</td>';
                html += '<td style="width: 250px  ">时间</td>';
                html += '<td style="width: 200px  ">审批意见</td>';
                html += '<td style="width: 200px  ">审核状态</td>';
                html += '</tr>';
                $.each(list, function (index, list) {
                    html += '<tr style="text-align: center">';
                    html += '<td>' + list.user.name + '</td>';
                    html += '<td>' + list.approvalDate + '</td>';
                    html += '<td>' + list.opinion + '</td>';
                    html += '<td>' + list.state + '</td>';
                    html += '</tr>';
                })
                html += '</table>';
                $("#center").prepend(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
            })

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