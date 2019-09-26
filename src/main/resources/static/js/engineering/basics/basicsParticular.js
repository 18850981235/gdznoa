/**
 * Created by Administrator on 2019/8/6.
 */
function w() {
    var  id=q("id");
    var url="/ed/EdMassage/MassageParticular?id="+id;
    $.ajax({
        type:"get",
        dataType:"json",
        url:url,
        // date:{"id":id},
        success:function (obj){
            var data=obj.edMessage
            var list=obj.list
            var html="";
            html+='<table border="1" style="width: 1000px ">';
           html+='<tr style="height: 40px ;background-color: #efefef">';
           html+='<td colspan="4" style="text-align: center">';
           html+='<b>工程基础详情</b> </td></tr>';
           html+='<tr style="height:40px;">';
           html+='<td style="width:150px ;;background-color: #efefef">项目名称</td>';
           html+='<td colspan="3" style="width:300px ;">'+data.project.name+'</td>';
            html+='<input id="ap" style="display: none" value='+data.project.id+'>';
           html+='</tr>';
           html+='<tr style="height:40px;">';
           html+='<td style="width:150px ;background-color: #efefef">项目编号</td>';
           html+='<td style="width:300px ;">'+data.project.code+'</td>';
       html+='<td style="width:150px ;background-color: #efefef">项目经理</td>';
           html+='<td style="width:300px ;">'+data.project.projectManager+'</td>';
        html+='</tr>';
        html+='<tr style="height:40px;">';
           html+='<td style="width:150px ;;background-color: #efefef">业务负责人</td>';
           html+='<td  style="width:300px ;">';
            html+='<input class=""  >';
            html+='</td>';
           html+='<td style="width:150px ;background-color: #efefef">项目所属部门</td>';
           html+='<td  style="width:300px ;">';
            html+='<input class=""  >';
            html+='</td>';
           html+='</tr>';
           html+='<tr style="height:40px;">';
           html+='<td style="width:150px ;background-color: #efefef">项目地点</td>';
           html+='<td colspan="3" style="width:300px ;">';
            html+='<input class=""  >';
            html+='</td>';
           html+='</tr>';
           html+='<tr style="height:40px;">';
           html+='<td style="width:150px ;background-color: #efefef">建设单位</td>';
           html+='<td colspan="3" style="width:300px ;">'+data.client.name+'</td>';
           html+='</tr>';
           html+='<tr style="height:40px;">';
           html+='<td style="width:150px ;;background-color: #efefef">甲方代表</td>';
           html+='<td  style="width:300px ;">'+data.fristDeputy+'</td>';
           html+='<td style="width:150px ;;background-color: #efefef">联系电话</td>';
           html+='<td  style="width:300px ;">'+data.fristPhone+'</td>';
           html+='</tr>';
           html+='<tr style="height:40px;">';
           html+='<td style="width:150px ;background-color: #efefef">代建单位</td>';
           html+='<td colspan="3" style="width:300px ;">'+data.agentConstructUnit+'</td>';
           html+='</tr>';
           html+='<tr style="height:40px;">';
           html+='<td style="width:150px ;;background-color: #efefef">代建代表</td>';
           html+='<td  style="width:300px ;">'+data.agentDeputy+'</td>';
           html+='<td style="width:150px ;;background-color: #efefef">联系电话</td>';
           html+='<td  style="width:300px ;">'+data.agentPhone+'</td>';
           html+='</tr>';
           html+='<tr style="height:40px;">';
           html+='<td style="width:150px ;background-color: #efefef">监理单位</td>';
           html+='<td colspan="3" style="width:300px ;">'+data.supervisingUnit+'</td>';
           html+='</tr>';
           html+='<tr style="height:40px;">';
           html+='<td style="width:150px ;;background-color: #efefef">专监</td>';
           html+='<td  style="width:300px ;">'+data.supervisor+'</td>';
           html+='<td style="width:150px ;;background-color: #efefef">联系电话</td>';
           html+='<td  style="width:300px ;">'+data.supervisorPhone+'</td>';
           html+='</tr>';
           html+='</table>';

            html += ' <table class="approval " style="width: 1000px ">';
            html += '<tr style="height: 40px;width:1000px  " >';
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
            $.each(data.list, function (index, list) {
                html += '<tr style="text-align: center;width:900px ;height: 40px">';
                html += '<td style="width: 20px  ">' + (index+1) + '</td>';
                html += '<td style="width: 50px  ">' + list.approvalIdentity + '</td>';
                html += '<td style="width: 50px  ">' + list.user.name + '</td>';
                html += '<td style="width: 50px  ">' + list.approvalDate + '' +
                    '</td>';
                html += '<td style="width: 200px  ">' + list.opinion + '</td>';
                html += '<td style="width: 50px  ">' + list.state + '</td>';
                html += '</tr>';
            })
            html += '</table>';

            $("#center form").prepend(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容

            var id=$("#ap").val()
            $.ajax({
                type:"post",
                dataType:"json",
                url:"/sd/SdSalesContract/getProject",
                success:function (data) {
                    $.each(data,function (index,obj) {
                        if(obj.id==id){


                            $("#center input").eq(1).val(obj.name)
                            $("#center input").eq(2).val(obj.dept.name)
                            $("#center input").eq(3).val(obj.site)
                        }

                    })
                }
            });
        }
    });
}
// w();
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