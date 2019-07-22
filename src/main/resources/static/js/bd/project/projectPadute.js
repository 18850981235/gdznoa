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
        var list=data.list;
        var html="";

        html+='<input style="display: none" value='+project.id+' name="id">';


        html +='<table border="1">';
        html +='<tr style="height: 45px ">';
        html +='<td colspan="4" style="text-align: center;background-color: #efefef">立项修改</td>';
        html +='</tr>';
        html +='<tr style="height:45px ">';
        html +='<td style="width: 150px " class="Color">项目编号</td>';
        html +='<td style="width: 300px "><input style="width: 250px " required  name="code" value='+project.code+'></td>';
        html +='<td style="width: 150px " class="Color">项目简称</td>';
        html +='<td style="width: 300px "><input style="width: 250px " required name="abbreviation" value='+project.abbreviation+'></td>';
        html +='</tr>';
        html +='<tr style="height: 45px ">';
        html +='<td class="Color">项目名称</td>';
        html +='<td colspan="3"><input style="width: 650px " required name="name" value='+project.name+'></td>';
        html +='</tr>';
        html +=' <tr style="height: 45px ">';
        html +='<td class="Color">项目类别</td>';
        html +='<td>';
        html +='<select  style="height: 25px " required required name="type">';
        html +='<option >'+project.type+'</option>';
        html +='<option >政府公建</option>';
        html +='<option  >央企项目</option>';
        html +='<option >国有企业</option>';
        html +='<option >民营企业</option>';
        html +=' <option >房地产</option>';
        html +=' <option >私营企业分包</option>';
        html +=' <option >国有企业分包</option>';
        html +=' </select>';
        html +='</td>';
        html +='<td class="Color">项目地点</td>';
        html +='<td><input style="width: 250px " name="site" value='+project.site+'></td>';
        html +='</tr>';
        html +='<tr style="height: 45px ">';
        html +='<td class="Color">项目阶段</td>';
        html +='<td>';
        html +='<select style="height: 25px " name="stage">';
        html +=' <option >'+project.stage+'</option>';
        html +='<option >前期业务阶段</option>';
        html +='<option >签约施工阶段</option>';
        html +='<option >售后服务阶段</option>';
        html +='<option>合约完成结束</option>';
        html +=' <option >未中标终止</option>';
        html +='</select>';
        html +='</td>';
        html +='<td class="Color">项目预算金额</td>';
        html +="<td><input style='width: 250px ' value="+project.budget+"  name='budget' oninput='value=value.replace(/[^\d]/g,'')' ></td>";

        html +='</tr>';
        html +='<tr style="height: 45px ">';
        html +='<td class="Color">项目资金来源</td>';
        html +=' <td>';
        html +='<select style="height: 25px " name="capitalSource">';
        html +='<option >'+project.capitalSource+'</option>';
        html +=' <option >财政预算投资</option>';
        html +='<option >自筹资金投资</option>';
        html +=' <option >银行贷款投资</option>';
        html +=' <option >利用外资</option>';
        html +=' </select>';
        html +=' </td>';

        html +='<td class="Color">项目招标方式</td>';
        html +='<td>';
        html +=' <select style="height: 25px " name="biddingType" required>';
        html +=' <option >'+project.biddingType+'</option>';
        html +=' <option value="公开招标">公开招标</option>';
        html +='  <option value="邀请招标">邀请招标</option>';
        html +='  <option value="涉密招标">涉密招标</option>';
        html +='  </select>';
        html +='  </td>';

        html +='</tr>';
        html +=' <tr style="height: 45px ">';
        html +=' <td class="Color">项目负责人</td>';
        html +=' <td >';
        html +=' <input class="Eliminate" readonly value='+project.principalUser.name+'>';
        html +=' <input style="display: none" class="Eliminate-no" name="principal" value='+project.principal+'>';
        html +='  <a target="_blank " class="add-to">添加</a>';
        html +='  <a class="clear-to" >';
        html +=' <input value="清空" class="input"  onClick="" type="button">';
        html +=' </a>';
        html +='  </td>';
        html +=' <td class="Color">项目单位名称</td>';
        html +=' <td>';
        html +=' <input class="Eliminate-1" readonly required value='+project.client.name+'>';
        html +='<input style="display: none" class="Eliminate-no-1" name="deptid" value='+project.client.id+'>';
        html +=' <a target="_blank "  class="add-to1">添加</a>';
        html +=' <a class="clear-to1" >';
        html +=' <input value="清空" class="input1"  onClick="" type="button">';
        html +='  </a>';
        html +='   </td>';

        html +='</tr>';
        html +='<tr style="height: 45px ">';
        html +=' <td class="Color">区域负责人</td>';
        html +=' <td>';
        html +='  <input class="Eliminate-3" readonly required value='+project.areaManagerUser.name+'>';
        html +='<input style="display: none" class="Eliminate-no-3" name="areaManager" value='+project.areaManager+'>';
        html +=' <a target="_blank "  class="add-to3">添加</a>';
        html +='  <a class="clear-to3" >';
        html +='  <input value="清空" class="input3"  onClick="" type="button">';
        html +='  </a>';
        html +='  </td>';

        html +=' <td class="Color">所属机构</td>';
        html +='  <td>';
        html +='  <select class="department" style="height: 25px ">';
        html +=' <option value='+project.deptid+'>'+project.dept.name+'</option>';
        html +='  </select>';
        html +='  </td>';

        html +='</tr>';
        html +='<tr style="height: 45px ">';
        html +='<td class="Color">项目立项时间</td>';
        html +=' <td ><input  type="text" class="demo-input" placeholder="请选择日期" id="test1"  name="createtime" value='+project.createtime+'></td>';
        html +=' <td class="Color">预计项目投标时间</td>';
        html +=' <td>';
        html +='<input style="width: 250px "  type="text" class="demo-input" placeholder="请选择日期" id="test2"  name="biddate" value='+project.biddate+'>';
        html +='</td>';

        html +='</tr>';
        // html +='<tr style="height: 45px ">';
        //
        // html +='<td>项目业务情况</td>';
        // html +='<td colspan="3">';
        // html +='<input style="width: 750px " value='+project.content+'>';
        // html +='</td>';
        // html +='</tr>';

        // html +='<tr style="height: 45px ">';
        // html +='<td>项目查看者</td>';
        // html +='<td colspan="3" >';
        // var names="";
        //     for (var i = 0; i < users1.length; i++) {
        //         names+=users1[i].name+",";
        //     }
        // html += '<input class="eliminate-2"  style="width: 500px " readonly required value=' + names + '>';
        // var ids="";
        // for (var a = 0; a < users1.length; a++) {
        //     if(a<users1.length-1){
        //         ids+=users1[a].id+",";
        //     }else {
        //         ids+=users1[a].id;
        //     }
        //
        // }
        // html +='<input style="display: none" class="eliminate-no-2" name="examine" value='+ids+'>';
        // html +='<a target="_blank "  class="add-to2">添加</a>';
        // html +='<a class="clear-to2" >';
        // html +='<input value="清空" class="input2"  onClick="" type="button">';
        // html +='</a>';
        // html +='</td>';
        // html +='</tr>';
        html +='<tr style="height: 45px ">';
        html +='<td class="Color">项目描述</td>';
        html +='<td colspan="3">';
        html +='<textarea name="content"style="width: 700px ">'+ project.content+'</textarea>';
        html +='</td>';
        html +='</tr>';
        html +='<tr style="height: 45px ">';
        html +='<td class="Color">附件</td>';
        if(project.accessory==undefined){
            html += '<td colspan="3" >' + "无" + '</td>';
        }else {
            var strs= new Array(); //定义一数组
            strs=project.accessory.split(","); //字符分割
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
        html +='</tr>';
        html +='</table>';
        $("#form1").prepend(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
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