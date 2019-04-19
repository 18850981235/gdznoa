
/**
 * Created by Administrator on 2019/4/15.
 */
function w() {
    var  id=q("id");
    var url="http://192.168.1.191:8080/mc/dispatched/update.json?id="+id;
    $.ajax({
        type:"get",
        dataType:"json",
        url:url,
        // date:{"id":id},
        success:function (data) {
            $("#center input").eq(0).val(data.id);
            $("#center input").eq(1).val(data.demand);
            $("#center input").eq(2).val(data.evectionTime);
            $("#center input").eq(3).val(data.evectionCost);
            $("#center input").eq(4).val(data.accessory);

            $(".projectname option").eq(0).text(data.projectName);
            $(".department option").eq(0).text(data.dept.name);
            // $.each(data,function (index,project) {
            // html+='<input style="display: none" value='+data.id+' name="id">';
            // html+='<table border="1">';
            //     html+='<tr style="height: 40px ;background-color: #efefef">';
            //     html+='<td colspan="4" style="text-align: center"><b>人员派遣修改</b></td>';
            //     html+='</tr>';
            //     html+='<tr style="height:40px;">';
            //     html+='<td style="width:150px ;;background-color: #efefef">项目名</td>';
            //     html+='<td style="width:300px ;"><input  style="width:280px "  name="projectName" value='+data.projectName+'></td>';
            //     html+='<td style="width:150px ;background-color: #efefef;">申请部门</td>';
            //     html+='<td style="width:300px ;">';
            //     html+='<select class="department" style="width: 100px;height: 30px " name="deptid">';
            //     html+='<option value='+data.dept.id+'>'+data.dept.name+'</option>';
            //     html+='<option value="">请选择</option>';
            //     html+='</select>';
            //     html+='</td>';
            //     html+='</tr>';
            //     html+='<tr  style="height:40px;">';
            //     html+='<td style="width:150px ;background-color: #efefef;">申请人派遣要求</td>';
            // html+='<td colspan="3"><input style="width: 700px " name="demand" value='+data.demand+'></td>';
            //
            //     html+='</tr>';
            //     html+='<tr style="height:40px;">';
            //     html+='<td style="width:150px ;background-color: #efefef;">预计出差时间</td>';
            // html+='<td ><input style="width: 300px " type="date" name="evectionTime" value='+data.evectionTime+'></td>';
            //     html+='<td style="width:150px ;background-color: #efefef;">人员出场费用</td>';
            // html+='<td ><input style="width: 300px " name="evectionCost" value='+data.evectionCost+'></td>';
            //     html+='</tr>';
            //     html+='<tr style="height:40px;">';
            //     html+='<td style="width:150px ;background-color: #efefef;">附件</td>';
            //     html+='<td colspan="3"><input style="width: 700px " type="file" name="file" value='+data.accessory+'></td>';
            //     html+='</tr>';
            //
            // html+='</table>';
            // $("#center form").prepend(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
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