/**
 * Created by Administrator on 2019/4/15.
 */
function w() {
    var  id=q("id");
    var url="http://192.168.1.191:8080/mc/stamp/update.json?id="+id;
    $.ajax({
        type:"get",
        dataType:"json",
        url:url,
        // date:{"id":id},
        success:function (data) {
            var html="";
             // $.each(data,function (index,project) {
                html+='<input style="display: none" value='+data.id+' name="id">';
                html += '<table border="1" >';
                html += ' <tr style="text-align: center;height: 45px ">';
                html += ' <td colspan="4" style="width: 900px;background-color: #efefef ">';
                html += '<b>商务盖章修改</b>';
                html += '</td>';
                html += '</tr>';
                html += '  <tr style="height: 45px ">';
                html += '<td style="width:150px ;background-color: #efefef;">申请部门</td>';
                html += '<td style="width:300px ;">';
                html += ' <select class="department" style="width: 100px;height: 30px " name="deptid">';
                $.ajax({
                    type:"post",
                    dataType:"json",
                    url:"<%=basePath%>/json/section.json",
                    success:function (data1) {
                        var names=data1.list;
                        $.each(names,function (index,obj) {
                            if(data.dept.id=obj.id){
                                html+='<option value='+obj.id+'select>';
                                html+='<span>'+obj.name+'</span>';
                                html+='</option>';
                            }else{html+='<option value='+obj.id+'>';
                                html+='<span>'+obj.name+'</span>';
                                html+='</option>';}
                            $(".department").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
                        });
                    }
                });
                html += '  </select>';
                html += '</td>';
                html += ' <td style="width:150px ;;background-color: #efefef">申请日期</td>';
                html += '<td style="width:300px ;">';
                html += '<input type="date" style="width:280px " name="createtime" value='+data.createtime+'>';
                html += '</td>';
                html += '</tr>';
                html += '<tr style="height: 45px ">';
                html += '<td style="width:150px ;;background-color: #efefef">联系电话</td>';
                html += '<td style="width:300px ;">';
                html += ' <input style="width:280px " name="phone" value='+data.phone+'>';
                html += '</td>';
                html += ' <td style="width:150px ;;background-color: #efefef">所需相关文件份数</td>';
                html += '<td style="width:300px ;">';
                html += ' <input style="width:280px " name="fileNum" value='+data.fileNum+' >';
                html += '</td>';
                html += '</tr>';
                html += '<tr style="height: 45px ">';
                html += ' <td style="width:150px ;;background-color: #efefef">用章类型说明</td>';
                html += '<td colspan="3" style="width:300px ;">';
                html += '  <input style="width:700px " name="content" value='+data.stampType+'>';
                html += '</td>';
                html += '</tr>';
                html += '</tr>';
                html += '<tr style="height: 45px ">';
                html += ' <td style="width:150px ;;background-color: #efefef">盖章用途说明</td>';
                html += '<td colspan="3" style="width:300px ;">';
                html += '  <input style="width:700px " name="content" value='+data.content+'>';
                html += '</td>';
                html += '</tr>';
                html += '</tr>';
                html += '</tr>';
                html += '<tr style="height: 45px ">';
                html += ' <td style="width:150px ;;background-color: #efefef">收件地址</td>';
                html += '<td colspan="3" style="width:300px ;">';
                html += '  <input style="width:700px "name="consigneeAddress" value='+data.consigneeAddress+'>';
                html += '</td>';
                html += '</tr>';
                html += '<tr style="height: 45px ">';
                html += '   <td style="width:150px ;background-color: #efefef;">收件人</td>';
                html += '    <td style="width:300px ;">';
                html += '    <input style="width:280px " name="consignee" value='+data.consignee+'>';
                html += '   </td>';
                html += '   <td style="width:150px ;;background-color: #efefef">联系电话</td>';
                html += '    <td style="width:300px ;">';
                html += '   <input style="width:280px " name="consigneePhone" value='+data.consigneePhone+'>';
                html += '</td>';
                html += '</tr>';
                html += '<tr style="height: 45px ">';

                html += '<td style=";background-color: #efefef">附件</td>';
                html += '<td colspan="3">';
                html += '<input type="file" name="file" value='+data.accessory+'>';
                html += '</td>';
                html += '</tr>';
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