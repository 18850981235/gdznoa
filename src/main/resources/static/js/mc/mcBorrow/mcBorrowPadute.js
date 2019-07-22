
/**
 * Created by Administrator on 2019/4/15.
 */
function w() {
    var  id=q("id");
    var url="/mc/borrow/update.json?id="+id;
    $.ajax({
        type:"get",
        dataType:"json",
        url:url,
        // date:{"id":id},
        success:function (data) {

            var html="";
            // $.each(data,function (index,project) {
          html+='<table border="1">';

              html+='<tr style="height: 40px ;background-color: #efefef">';
              html+='<td colspan="4" style="text-align: center">';
              html+='<b>文件借用修改</b>';
              html+='</td>';
              html+='</tr>';
              html+='<tr style="height:40px;">';
              html+='<td  class="Color" style="width:150px  ">';
              html+='<span>项目名称</span>';
              html+='</td>';
              html+='<td colspan="3" style="width:300px ;">';
              html+='<select  required class="projectname" style="height: 30px ; " name="projectid">';
              html+='<option value='+data.project.id+'>'+data.project.abbreviation+ '</option>';
              html+='</select>';
              html+='</td>';
              html+='</tr>';
              html+='<tr style="height:40px;">';
              html+='<td class="Color" style="width:150px ">';
              html+='<span>申请部门:</span>';
          html+='</td>';
          html+='<td style="width:300px ;">';
              html+='<select class="department" style="width: 100px;height: 30px " name="deptid">';
            $.ajax({
                type:"post",
                dataType:"json",
                url:"/util/getDept",
                success:function (date) {
                    var names=date.list;
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
              html+='</select>';
              html+='</td>';
              html+='<td class="Color" style="width:150px ">申请日期:</td>';
          html+='<td style="width:300px ;">';
              html+='<input type="text" class="demo-input" placeholder="请选择日期" id="test1" style="width:280px " name="createtime" value='+data.createtime+' >';
              html+='</td>';
              html+='</tr>';
              html+='<tr  style="height:40px;">';


            $.ajax({
                type: "get",
                url: "/util/getUser",
                dataType: "json",
                success: function (data) {
                    html+='<td  class="Color"  style="width:150px  ">申请人</td>';
                    html+='<td >';
                    html+='<input class="" readonly value='+data.name+' >';
                    html+='<input class="" style="display: none"  name="userid" value='+data.id+'>';
                    html+='</td>';
                    html+='<td class="Color" style="width:150px  ">联系电话 </td>';
                    html+='<td style="width:300px ;">';
                    html+='<input style="width:280px " name="phone" value='+data.account+'>';
                    html+='</td>';
                }
            })


              html+='</tr>';
              html+='<tr style="height:40px;">';
              html+='<td class="Color" style="width:150px  ">申请原件内容</td>';
              html+='<td colspan="3">';
              html+='<textarea  style="width: 700px ;height: 30px " name="content" >'+data.content+'</textarea>';
              html+='</td>';
              html+='</tr>';
              html+='<tr style="height:40px;">';
              html+='<td class="Color" style="width:150px  ">原件借用用途</td>';
              html+='<td colspan="3">';
              html+='<textarea style="width: 700px ;height: 40px " name="purpose">'+data.purpose+'</textarea>';
              html+='</td>';
              html+='</tr>';
              html+='<tr style="height:40px;">';
              html+='<td class="Color"  style="width:150px  " >收件人</td>';
              html+='<td  ><input style="width: 280px " name="consignee" value='+data.consignee+'></td>';
              html+='<td class="Color" style="width:150px  ">收件人电话</td>';
              html+='<td ><input style="width: 280px " name="consigneePhone" value='+data.consigneePhone+'></td>';
              html+='</tr>';
              html+='<tr style="height:40px;">';
              html+='<td class="Color" style="width:150px  ">原件寄往地址</td>';
              html+='<td colspan="3">';
              html+='<input style="width: 700px " name="sendAddress" value='+data.sendAddress+'>';
              html+='</td>';
              html+='</tr>';
              html+='<tr style="height:40px;">';
              html+='<td class="Color"  style="width:150px  ">快递公司（归还）</td>';
          html+='<td  ><input style="width: 280px " name="returnExpressageName" value='+data.returnExpressageName+'></td>';
              html+='<td class="Color" style="width:150px  ">快递单号（归还）</td>';
          html+='<td ><input style="width: 280px " name="returnExpressageWaybill" value='+data.returnExpressageWaybill+'></td>';
              html+='</tr>';
              html+='<tr style="height: 40px ;background-color: #efefef">';
              html+='<td colspan="4" style="text-align: center">';
              html+='<span>(以下非申请人填写)</span>';
              html+='</td>';
              html+='</tr>';
              html+='<tr style="height:40px;">';
              html+='<td class="Color" style="width:150px  ">原件名称</td>';
              html+='<td colspan="3">';
              html+='<textarea class="Eliminate4" style="width: 600px ;height: 30px "name="name" vocab='+data.name+'></textarea>';
            html+='<a target="_blank " class="add-to4">添加</a>';
            html+=' <a class="clear-to4" >';
            html+='<input value="清空" class="input44"  onClick="" type="button">';
            html+='</a>';
              html+='</td>';

              html+='</tr>';
              html+='<tr style="height:40px;">';
              html+='<td class="Color"  style="width:150px  ">快递公司（寄出）</td>';
          html+='<td  ><input style="width: 280px " name="sendExpressageName" value='+data.sendExpressageName+'></td>';
              html+='<td class="Color" style="width:150px  ">快递单号（寄出）</td>';
          html+='<td ><input style="width: 280px " name="sendExpressageWaybill" value='+data.sendExpressageWaybill+'></td>';
              html+='</tr>';
              html+='<tr style="height:40px;">';
              html+='<td class="Color"  style="width:150px  ">原件寄出时间</td>';
              html+='<td colspan="3" ><input style="width: 280px " type="text" class="demo-input" placeholder="请选择日期" id="test2" name="sendtime" value='+data.sendtime+'></td>';
              html+='</tr>';

              html+='<tr style="height:40px;">';
              html+='<td class="Color" style="width:150px  ">原件归还时间</td>';
              html+='<td style="width:300px ;" colspan="3">';
              html+='<input  style="width:280px "   type="text" class="demo-input" placeholder="请选择日期" id="test3" name="returntime" value='+data.returntime+'>';
          html+='</td>';
          html+='</tr>';

          html+='</table>';
            
            
            
            

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
$(document).ready(function () {
    $(document).on("click",".search-3",function () {
        $(".choice4-con").show();
        $(".noe-no").hide();
        $(".tow-no").hide();
        $(".on").hide();
    });
    $(document).on("click",".noe",function () {
        $(".choice4-con").hide();
        $(".noe-no").show();
    });
    // $(document).on("click",".tow-in-1",function () {
    //     $(".tow-on").toggle();
    //
    // });
    $(document).on('click','.tow-in-1',function(){
        if($(this).siblings('ul').css('display')=='none'){
            $(this).siblings('ul').slideDown(10).children('li');
            //判断成功后隐藏
            if($(this).parents('li').children('ul').css('display')=='block'){
                $(this).parents('li').siblings('li').children('ul').slideUp(100);
            }
        }
    });
    $(document).on("click",".add-to4",function () {
        $("#choice4").show();
    });
    $(document).on("click",".close-in",function () {
        $("#choice4").hide();
    });
    $(document).on("click","#choice4 .noe",function () {
        $(".choice4-con").hide();

    });
    $(document).on("click","#choice4 .tow",function () {
        $(".choice4-con").hide();
        $(".tow-no").show();
    });
    $(document).on("click",".input44",function f() {
        $('.Eliminate4').text("");
    });
    $(document).on("click",".noe-in",function () {
        var c2,d2;
        var name4=$(this).find(".noe-in-1").text();
        d2=$(".Eliminate4").text();
        if(d2==""){
            $(".Eliminate4").text(name4);
        }else {
            c2= d2+","+name4;
            $(".Eliminate4").text(c2);
        }
    })
    $(document).on("click","#choice4 .tow-li-1",function () {
        var c1,d1;
        var name1=$(this).find(".tow-in-2").text();
        d1=$(".Eliminate4").text();
        if(d1==""){
            $(".Eliminate4").text(name1);

        }else {
            c1= d1+","+name1;
            $(".Eliminate4").text(c1);
        }

        // console.log(c1);
    })
    $(document).on("click","#choice4 .tow-li-2",function () {
        var c2,d2;
        var name2=$(this).find(".tow-in-3").text();
        d2=$(".Eliminate4").text();
        if(d2==""){
            $(".Eliminate4").text(name2);
        }else {
            c2= d2+","+name2;
            $(".Eliminate4").text(c2);
        }
    })
    $(document).on("click","#choice4 .tow-li-3",function () {
        var c2,d2;
        var name2=$(this).find(".tow-in-4").text();
        d2=$(".Eliminate4").text();
        if(d2==""){
            $(".Eliminate4").text(name2);
        }else {
            c2= d2+","+name2;
            $(".Eliminate4").text(c2);
        }
    })
    $(document).on("click","#choice4 .tow-li-4",function () {
        var c2,d2;
        var name2=$(this).find(".tow-in-5").text();
        d2=$(".Eliminate4").text();
        if(d2==""){
            $(".Eliminate4").text(name2);
        }else {
            c2= d2+","+name2;
            $(".Eliminate4").text(c2);
        }
    })


})
$.ajax({
    type: "get",
    url: "/mc/borrow/queryMailFile",
    dataType: "json",
    success: function (data) {
        var  qualification=data.McQualificationCertificate;
        var html="";
        html += '<ul>';
        $.each(qualification,function (index,obj) {
            html +='<li class="noe-in"><a class="noe-in-1">'+obj.name+'</a></li>';
        })
        html += '</ul>';
        $("#choice4 .noe-no").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
    }
})
$.ajax({
    type: "get",
    url: "/mc/borrow/queryMailFile",
    dataType: "json",
    success: function (data) {
        var  per=data.McPerformanceDate;
        var html="";
        html += '<ul>';
        $.each(data.McPerformanceDate,function (index,obj1) {
            html +='<li class="tow-in">'
            html +=   '<a class="tow-in-1 ">'+obj1.project.abbreviation+'</a>';
            html += '<ul class="tow-on" style="height: 70px;display: none ">';
            html +='<li class="tow-li-1">';
            html +='<a class="tow-in-2">'+obj1.acceptanceReport+'</a>';
            html +='</li>';
            html +='<li class="tow-li-2">';
            html +='<a class="tow-in-3">'+obj1.biddingNotice+'</a>';
            html +='</li>';
            html +='<li class="tow-li-3">';
            html +='<a class="tow-in-4">'+obj1.maintenanceProof+'</a>';
            html +='</li>';
            html +='<li class="tow-li-4">';
            html +='<a class="tow-in-5">'+obj1.performanceContract+'</a>';
            html +='</li>';
            html += '</ul>';
            html +=    '</li>';
        })
        html += '</ul>';
        $("#choice4 .tow-no").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
    }
})
function lo() {
    $(".on").html(value="");
    var search=$(".search-1").val();
    $.ajax({
        type: "get",
        url: "/mc/borrow/queryMailFile",
        data:{"projectName":search},
        dataType: "json",
        success: function (data) {
            var  qual=data.McQualificationCertificate;
            var  per=data.McPerformanceDate;
            var html="";
            html += '<ul>';
            if(qual!=""){
                $.each(qual,function (index,obj) {
                    html +='<li class="noe-in"><a class="noe-in-1">'+obj.name+'</a></li>';
                })
            }
            if(per!=""){
                $.each(per,function (index,obj1) {
                    html +='<li class="tow-in">'
                    html +=   '<a class="tow-in-1 ">'+obj1.project.abbreviation+'</a>';
                    html += '<ul class="tow-on" style="height: 70px;display: none ">';
                    html +='<li class="tow-li-1">';
                    html +='<a class="tow-in-2">'+obj1.acceptanceReport+'</a>';
                    html +='</li>';
                    html +='<li class="tow-li-2">';
                    html +='<a class="tow-in-3">'+obj1.biddingNotice+'</a>';
                    html +='</li>';
                    html +='<li class="tow-li-3">';
                    html +='<a class="tow-in-4">'+obj1.maintenanceProof+'</a>';
                    html +='</li>';
                    html +='<li class="tow-li-4">';
                    html +='<a class="tow-in-5">'+obj1.performanceContract+'</a>';
                    html +='</li>';
                    html += '</ul>';
                    html +=    '</li>';
                })
            }
            html += '</ul>';
            $("#choice4 .on").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
        }
    })
}
$(document).on("click",".search-2",function () {
    $(".choice4-con").hide();
    $(".noe-no").hide();
    $(".tow-no").hide();
    $(".on").show();
    lo();
})