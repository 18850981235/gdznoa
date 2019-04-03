/**
 * Created by Administrator on 2019/3/15.
 */
(function () {
    //点击显示隐藏
    // $(window).ready(function () {
    //     $("#left .click").click(function () {
    //         $("#left .name").toggle();
    //     })
    // });
    $(document).ready(function () {

        $('body').on('click', '.click', function () {
            if ($(this).siblings('ul').css('display') == 'none') {
                $(this).siblings('ul').slideDown(100).children('li');
                //判断成功后隐藏
                if ($(this).parents('li').children('ul').css('display') == 'block') {
                    $(this).parents('li').siblings('li').children('ul').slideUp(100);
                }
            }
        })
    });


//ajax
    $.ajax({
        type: "post",
        dataType: "json",
        url: "/util/getDeptUsers",
        success: function (data) {

            // var users=data.names.users;
            $.each(data, function (index, obj) {
                var html = "";
                // 一级
                for (i = 1; i < data.length + 1; i++) {

                    if (i == obj.id) {
                        html += '<li>';
                        html += '<a class="click">' + obj.name + '</a>';

                        // 二级
                        $.each(obj.users, function (index1, obj1) {
                            html += '<ul class="name" style="display: none" >';
                            html += '<li>';
                            html += '<a class="upload" >';
                            html += '<span class="name-block">' + obj1.name + '</span>';
                            html += '<span class="name-none" style="display: none">' + obj1.id + '</span>';
                            html += '</a>';
                            html += '</li>';
                            html += '</ul>';
                        });
                        html += '<li>';
                    }

                }
                $(".yiji").append(html);//append() 方法在被选元素的结尾插入指定内容。//prepend()方法在被选元素的开头插入指定内容


            });
        }
    })


    // $('#close').on('click', function() {
    //
    //         window.opener = null;
    //         window.open('', '_self');
    //         window.close();
    //
    // });
})();