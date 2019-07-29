
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
            $("#center input").eq(0).val(data.id);
            $("#center input").eq(1).val(data.createtime);
            $("#center input").eq(2).val(data.user.name);
            $("#center input").eq(3).val(data.user.id);
            $("#center input").eq(4).val( data.user.phone);

            $("#center input").eq(5).val(data.consignee);
            $("#center input").eq(6).val(data.consigneePhone);
            $("#center input").eq(7).val(data.sendAddress);
            $("#center input").eq(8).val(data.returnExpressageName);
            $("#center input").eq(9).val(data.returnExpressageWaybill);
            $("#center input").eq(11).val(data.sendExpressageName);
            $("#center input").eq(12).val(data.sendExpressageWaybill);
            if(data.sendtime==""||data.sendtime==null||data.sendtime==undefined){

            }else {
                $("#center input").eq(13).val(data.sendtime);
            }
            if(data.returntime==""||data.returntime==null||data.returntime==undefined){

            }else {
                $("#center input").eq(14).val(data.returntime);
            }

            $(".projectname option").eq(0).text(data.project.abbreviation);
            $(".projectname option").eq(0).val(data.project.id);

            $("#dept option").eq(0).text(data.dept.name);
            $("#dept option").eq(0).val(data.dept.id);


            $(".content").text(data.content);
            // $(".content option").eq(0).val(data.dept.id);

            $(".purpose").text(data.purpose);

            $(".Eliminate4").text(data.name);
            var html="";
            // $.each(data,function (index,project) {

            
            
            
            

            $("#center form").prepend(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容
            // })
        }
    });
}
// w();
$(document).ready(function () {
    w();
    laydate.render({
        elem: '#test1', //指定元素
        event: 'click',
        format: 'yyyy-MM-dd'
    });
    laydate.render({
        elem: '#test2', //指定元素
        event: 'click',
        format: 'yyyy-MM-dd'
    });
    laydate.render({
        elem: '#test3', //指定元素
        event: 'click',
        format: 'yyyy-MM-dd'
    });
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