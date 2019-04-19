/**
 * Created by Administrator on 2019/4/15.
 */
function w() {
    var  id=q("id");
    var url="/mc/dispatched/particular.json?id="+id;
    $.ajax({
        type:"get",
        dataType:"json",
        url:url,
        // date:{"id":id},
        success:function (data) {
            var html="";
            var personnelDispatched=data.personnelDispatched;
            var list=data.list;

            // $.each(data,function (index,project) {

            // $("#center input").eq(0).val(data.id);
            // $("#center input").eq(1).val(data.personnelDispatched.projectName);
            // $("#center input").eq(2).val(data.personnelDispatched.dept.name);
            // $("#center input").eq(3).val(data.personnelDispatched.demand);
            // $("#center input").eq(4).val(data.personnelDispatched.evectionTime);
            // $("#center input").eq(5).val(data.personnelDispatched.evectionCost);
            // // $("#center input").eq(6).val(data.personnelDispatched.accessory);
            //
            // if (data.personnelDispatched.accessory == undefined) {
            //     html += '<td colspan="3" >' + "无" + '</td>';
            //     $("#center input").eq(6).val("无");
            // } else {
            //     var strs = new Array(); //定义一数组
            //     strs = data.personnelDispatched.accessory.split(","); //字符分割
            //     for (i = 0; i < strs.length; i++) {
            //         if (strs[i] != "") {
            //             for(s=6;s<strs.length+7;s++){
            //                 $("#center input").eq(s).val(strs[i]);
            //                 $("#center input").eq(s+1).css("value","点击下载");
            //             }
            //
            //
            //         }
            //     }
            //     html += '</td>';
            // }
              html+='<input style="display: none" value='+data.id+' name="id">';

          html+='<table border="1">';
              html+='<tr style="height: 40px ;background-color: #efefef">';
              html+='<td colspan="4" style="text-align: center"><b>人员派遣详情</b></td>';
              html+='</tr>';
              html+='<tr style="height:40px;">';
              html+='<td style="width:150px ;;background-color: #efefef">项目名</td>';
              html+='<td style="width:300px ;">'+personnelDispatched.projectName+'</td>';
              html+='<td style="width:150px ;background-color: #efefef;">申请部门</td>';
              html+='<td style="width:300px ;">'+personnelDispatched.dept.name+'</td>';
              html+='</tr>';
              html+='<tr  style="height:40px;">';
              html+='<td style="width:150px ;background-color: #efefef;">申请人派遣要求</td>';
              html+='<td colspan="3">'+personnelDispatched.demand+'</td>';
              html+='</tr>';
              html+='<tr style="height:40px;">';
              html+='<td style="width:150px ;background-color: #efefef;">预计出差时间</td>';
              html+='<td >'+personnelDispatched.evectionTime+'</td>';
              html+='<td style="width:150px ;background-color: #efefef;">人员出场费用</td>';
              html+='<td >'

                  +personnelDispatched.evectionCost+'</td>';
              html+='</tr>';
              html+='<tr style="height:40px;">';
              html+='<td style="width:150px ;background-color: #efefef;">附件</td>';
            if(personnelDispatched.accessory==undefined){
                html += '<td colspan="3" >' + "无" + '</td>';
            }else {
                var strs= new Array(); //定义一数组
                strs=personnelDispatched.accessory.split(","); //字符分割
                html += '<td colspan="3" style="width: 600px " >'
                for(i=0;i<strs.length;i++){
                    if(strs[i]!="") {
                        html += '<form action="/util/fileDown" style="width: 600px ;display: inline-block">';
                        html += '<input name="file" style="width:400px ;" value=' + strs[i] + ' >';
                        html += '<input style="background-color: transparent;float: right"  type="submit" value="点击下载">';
                        html += ' </form>';
                    }
                }
                html +='</td>';
            }
              html+='</tr>';

              html+='</table>';

            html += ' <table class="approval " >';
            html += '<tr style="height: 40px " >';
            html += '<td colspan="4" style="text-align: center;width: 900px ">';
            html += '<b>审批流程</b>';
            html += '</td>';
            html += '</tr>';
            html += '<tr style="text-align: center;background-color: #0099ff ;height: 45px ">';
            html += '<td style="width: 250px  ">名称</td>';
            html += '<td style="width: 250px  ">时间</td>';
            html += '<td style="width: 200px  ">审批意见</td>';
            html += '<td style="width: 200px  ">审核状态</td>';
            html += '</tr>';
            $.each(list,function (index,list) {
                html+='<tr style="text-align: center;height: 45px ">';
                html+='<td>'+list.user.name+'</td>';
                html+='<td>'+list.approvalDate+'</td>';
                html+='<td>'+list.opinion+'</td>';
                html+='<td>'+list.state+'</td>';
                html+='</tr>';
            })
            html += '</table>';
            $("#center").prepend(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
            // })
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