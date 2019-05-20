/**
 * Created by Administrator on 2019/4/15.
 */
function w() {
    var  id=q("id");
    var url="/mc/materials/particular.json?id="+id;
    $.ajax({
        type:"get",
        dataType:"json",
        url:url,
        // date:{"id":id},
        success:function (data) {
            var html="";
            // $.each(data,function (index,project) {
            var materials=data.materials;
            var list=data.list;
            html+='   <input style="display: none" value='+data.id+' name="id">';
            html += '<table border="1">';
            html += '<tr style="text-align: center;height: 45px ">';
            html += '<td colspan="4" style="width: 900px;background-color: #efefef "><b>商务材料详情 </b><input style="display: none" name="id"></td>';
            html += '</tr>';
            html += '<tr style="height: 45px ">';
            html += '<td style="width:150px ;background-color: #efefef;">申请部门  </td>';
            html += '<td style="width:300px ;"> '+materials.dept.name+'  </td>';
            html += '<td style="width:150px ;;background-color: #efefef">申请日期  </td>';
            html += '<td style="width:300px ;">  '+materials.createtime+' </td>';
            html += '</tr>';
            html += '<tr  style="height: 45px ">';
            html += '<td style="width:150px ;background-color: #efefef;">提供方式   </td>';
            html += '<td style="width:300px ;">  '+materials.offerTpye+' </td>';
            html += '<td style="width:150px ;background-color: #efefef;">项目名   </td>';
            html += '<td style="width:300px ;"> '+materials.projectName+' </td>';
            html += '</tr>';

            html += '<tr style="height: 45px ">';
            html += '<td style="width:150px ;background-color: #efefef;">收件人电话   </td>';
            html += '<td  > '+materials.consigneePhone+'</td>';
            html += '<td style="width:150px ;background-color: #efefef;">收件人   </td>';
            html += '<td style="width:300px ;"> '+materials.consignee+' </td>';
            html += '</tr>';
            html += '<tr style="height: 45px ">';
            html += '<td style="width:150px ;background-color: #efefef;">收件地址  </td>';
            html += '<td colspan="3" >'+materials.consigneeAddress+' </td>';
            html += '</tr>';
            html += '<tr style="height: 45px ">';
            html += '<td style="width:150px ;background-color: #efefef;">申请商务资料的内容及要求 </td>';
            html += '<td colspan="3" > '+materials.content+' </td>';
            html += '</tr>';
            html += '<tr style="height: 45px ">';
            html += '<td style="width:150px ;background-color: #efefef;">资料用途说明   </td>';
            html += '<td colspan="3" >'+materials.purpose+' </td>';
            html += '</tr>';
            html += '<tr style="height: 45px ">';
            html += '<td style="width:150px ;background-color: #efefef;">附件  </td>';

            if(materials.accessory==undefined){
                html += '<td colspan="3" >' + "无" + '</td>';
            }else {
                var strs= new Array(); //定义一数组
                strs=materials.accessory.split(","); //字符分割
                html += '<td colspan="3" >'
                for(i=0;i<strs.length;i++){
                    if(strs[i]!="") {
                        html += '<form action="/util/fileDown" >';
                        html += '<input name="file" style="width:400px ;" value=' + strs[i] + ' >';
                        html += '<input style="background-color: transparent"  type="submit" value="点击下载">';
                        html += ' </form>';
                    }
                }
                html +='</td>';
            }

            html += '</tr>';

            html += '</table>';



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

            $("#center form").prepend(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
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