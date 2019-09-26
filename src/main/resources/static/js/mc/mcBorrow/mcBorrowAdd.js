/**
 * Created by Administrator on 2019/5/8.
 */
//用户默认申请人
$.ajax({
    type: "get",
    url: "/util/getUser",
    dataType: "json",
    success: function (data) {
        $("#center input").eq(1).val(data.name);
        $("#center input").eq(2).val(data.id);
        $("#center input").eq(3).val(data.account);
    }
})

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
          console.log(1)
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
        console.log(data)
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
            console.log(data)
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
