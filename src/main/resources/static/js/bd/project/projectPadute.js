/**
 * Created by Administrator on 2019/4/15.
 */
function w() {
var  id=q("id");
var url="/bd/project/update.json?id="+id;
$.ajax({
    type:"get",
    dataType:"json",
    url:url,
    // date:{"id":id},
    success:function (data) {
        var project=data.project;
        var users1=data.users;
        var html="";

        html+='<input style="display: none" value='+project.id+' name="id">';
        html +='<table border="1">';
        html +='<tr style="height: 45px ">';
        html +='<td colspan="4" style="text-align: center;background-color: #efefef"><b>立项修改</b></td>';
        html +='</tr>';
        html +='<tr style="height:45px ">';
        html +='<td style="width: 150px ">项目编号</td>';
        html +='<td style="width: 300px "><input style="width: 250px " name="code" required value='+project.code+'></td>';
        html +='<td style="width: 150px ">项目简称</td>';
        html +='<td style="width: 300px "><input style="width: 250px " required name="name" value='+project.name+'></td>';
        html +='</tr>';
        html +='<tr style="height: 45px ">';
        html +='<td>项目名称</td>';
        html +='<td colspan="3"><input style="width: 650px " required name="abbreviation" value='+project.abbreviation+'></td>';
        html +='</tr>';
        html +='<tr style="height: 45px ">';
        html +='<td>项目负责人:</td>';
        html +='<td >';
        html +='<input class="Eliminate" readonly value='+project.principalUser.name+'>';
        html +='<input style="display: none" class="Eliminate-no" name="principal" value='+project.principalUser.id+'>';
        html +='<a target="_blank " class="add-to">添加</a>';
        html +='<a class="clear-to" >';
        html +='<input value="清空" class="input"  onClick="" type="button">';
        html +='</a>';
        html +='</td>';
        html +='<td>项目地点</td>';
        html +='<td><input style="width: 250px " name="site" value='+project.site+'></td>';
        html +='</tr>';
        html +='<tr style="height: 45px ">';
        html +='<td>项目类别:</td>';
        html +='<td>';
        html +='<select  style="height: 25px " required name="type"  >';
        html +='<option value='+project.type+'>'+project.type+'</option>';
        html +='<option value="">请选择</option>';
        html +='<option >政府公建项目</option>';
        html +='<option >国有企业项目</option>';
        html +='<option >民营企业项目</option>';
        html +='<option >地产类项目</option>';
        html +='<option >政府BT型项目</option>';
        html +='<option >国企BT型项目</option>';
        html +='<option >其他类型项目</option>';
        html +='</select>';
        html +='</td>';
        html +='<td>项目立项时间：</td>';
        html +='<td ><input  type="date" name="createtime" value='+project.createtime+'></td>';
        html +='</tr>';
        html +='<tr style="height: 45px ">';
        html +='<td>项目阶段</td>';
        html +='<td>';
        html +='<select style="height: 25px " name="stage" >';
        html +='<option value='+project.stage+'>'+project.stage+'</option>';
        html +='<option value="">请选择</option>';
        html +='<option >前期业务阶段</option>';
        html +='<option  >签约施工阶段</option>';
        html +='<option >售后服务阶段</option>';
        html +='<option >合约完成结束</option>';
        html +='<option >未中标终止</option>';
        html +='</select>';
        html +='</td>';
        html +='<td>项目预算金额：</td>';
        html +='<td><input style="width: 250px " name="budget" value='+project.budget+'></td>';
        html +='</tr>';
        html +='<tr style="height: 45px ">';
        html +='<td>项目招标方式</td>';
        html +='<td>';
        html +='<select style="height: 25px " name="biddingType" >';
        html +='<option  value='+project.biddingType+'>'+project.biddingType+'</option>';
        html +='<option value="">请选择</option>';
        html +='<option >公开招标</option>';
        html +='<option >邀请招标</option>';
        html +='<option >涉密招标</option>';
        html +='</select>';
        html +='</td>';
        html +='<td>预计项目投标时间：</td>';
        html +='<td>';
        html +='<input style="width: 250px " type="date" name="biddate" value='+project.biddate+' >';
        html +='</td>';
        html +='</tr>';
        html +='<tr style="height: 45px ">';
        html +='<td>项目单位名称</td>';
        html +='<td>';
        html +='<input class="Eliminate-1" readonly required value='+project.client.name+'>';
        html +='<input style="display: none" class="Eliminate-no-1" name="clientid" value='+project.client.id+'>';
        html +='<a target="_blank "  class="add-to1">添加</a>';
        html +='<a class="clear-to1" >';
        html +='<input value="清空" class="input1"  onClick="" type="button">';
        html +='</a>';
        html +='</td>';
        html +='<td>项目合作方式：</td>';
        html +='<td>';
        html +='<select style="height: 25px " required name="cooperationType" >';
        html +='<option value='+project.cooperationType+'>'+project.cooperationType+'</option>';
        html +='<option value="">请选择</option>';
        html +='<option >公司自主项目</option>';
        html +='<option>合作项目</option>';
        html +='</select>';
        html +='</td>';
        html +='</tr>';
        html +='<tr style="height: 45px ">';
        html +='<td>合作单位</td>';
        html +='<td><input style="width: 250px " name="cooperationUnit" value='+project.cooperationUnit+'></td>';
        html +='<td>合作伙伴姓名</td>';
        html +='<td><input style="width: 250px " name="cooperationName" value='+project.cooperationName+'></td>';
        html +='</tr>';
        html +='<tr style="height: 45px ">';
        html +='<td>职务</td>';
        html +='<td><input style="width: 250px " name="cooperationRole" value='+project.cooperationRole+'></td>';
        html +='<td>联系方式</td>';
        html +='<td><input style="width: 250px " name="cooperationPhone"  value='+project.cooperationPhone+'></td>';
        html +='</tr>';
        html +='<tr style="height: 45px ">';
        html +='<td>项目查看者</td>';
        html +='<td colspan="3" >';
        var names="";
            for (var i = 0; i < users1.length; i++) {
                names+=users1[i].name+",";
            }
        html += '<input class="eliminate-2"  style="width: 500px " readonly required value=' + names + '>';
        var ids="";
        for (var a = 0; a < users1.length; a++) {
            if(a<users1.length-1){
                ids+=users1[a].id+",";
            }else {
                ids+=users1[a].id;
            }

        }
        html +='<input style="display: none" class="eliminate-no-2" name="examine" value='+ids+'>';
        html +='<a target="_blank "  class="add-to2">添加</a>';
        html +='<a class="clear-to2" >';
        html +='<input value="清空" class="input2"  onClick="" type="button">';
        html +='</a>';
        html +='</td>';
        html +='</tr>';
        html +='<tr style="height: 45px ">';
        html +='<td>项目描述</td>';
        html +='<td colspan="3">';
        html +='<textarea name="content"style="width: 700px ">'+ project.content+'</textarea>';
        html +='</td>';
        html +='</tr>';
        html +='<tr style="height: 45px ">';
        html +='<td>附件</td>';
        if(project.accessory==undefined){
            html += '<td colspan="3" >' + "无" + '</td>';
        }else {
            var strs= new Array(); //定义一数组
            strs=project.accessory.split(","); //字符分割
            html += '<td colspan="3" >'
            for(i=0;i<strs.length;i++){
                if(strs[i]!="") {
                    html += '<form action="http://192.168.1.191:8080/util/fileDown" >';
                    html += '<input name="file" style="width:400px ;" value=' + strs[i] + ' >';
                    html += '<input style="background-color: transparent"  type="submit" value="点击下载">';
                    html += ' </form>';
                }
            }
            html +='</td>';
        }
        html +='</tr>';
        html +='</table>';
        $("form").prepend(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
        // })
    }
});
}
w();
// $(document).ready(function () {
//     w();
// })
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