//存放主要交互逻辑的js代码
// javascript 模块化(package.类.方法)

var seckill = {

    //封装秒杀相关ajax的url
    URL: {
        now: function () {
            return '/seckill/time';
        },
        exposer: function () {
            return '/seckill/exposer';
        },
        execution: function (md5) {
            return '/seckill/'  + md5 + '/execution';
        }
    },

    //详情页秒杀逻辑
    detail: {
        //详情页初始化
        init: function (params) {
            //计时交互
            var seckillTime = params['seckillTime'];

            $.get(seckill.URL.now(), {}, function (result) {
                if (result && result['success']) {
                    var nowTime = result['data'];

                    //时间判断 计时交互
                    seckill.countDown(nowTime, seckillTime);
                } else {
                    alert("请求失败");
                }
            });
        }
    },

    handlerSeckill: function (node) {
        //获取秒杀地址,控制显示器,执行秒杀
        node.hide().html('<button class="btn btn-primary btn-lg" id="killBtn">开始秒杀</button>');
        $.get(seckill.URL.exposer(), {}, function (result) {
            //在回调函数种执行交互流程
            if (result && result['success']) {
                var exposer = result['data'];
                if (exposer['exposed']) {
                    //开启秒杀
                    //获取秒杀地址
                    var md5 = exposer['md5'];
                    var killUrl = seckill.URL.execution(md5);
                    //点击开始秒杀按钮
                    $('#killBtn').one('click', function () {
                        //禁用按钮
                        $(this).addClass('disabled');
                        //发送秒杀请求
                        $.post(killUrl, {}, function (result) {
                            if (result && result['success']) {
                                //获得SeckillExecution对象
                                var killResult = result['data'];
                                //获得状态信息
                                var stateInfo = killResult['stateInfo'];

                                node.html('<span class="label label-success">' + stateInfo + '</span>');
                            }
                        });
                    });
                    node.show();
                } else {
                    //未开启秒杀(浏览器计时偏差)
                    var now = exposer['now'];

                    var end = exposer['end'];
                    seckill.countDown(now, start, end);
                }
            } else {
                console.log('result: ' + result);
            }
        });

    },

    countDown: function (nowTime, seckillTime) {

        var seckillBox = $('#seckill-box');
        if (nowTime > seckillTime) {
            //秒杀结束
            seckillBox.html('秒杀结束!');
        } else if (nowTime < seckillTime) {
            //秒杀未开始,计时事件绑定
            var killTime = new Date(seckillTime + 1000);//todo 防止时间偏移
            seckillBox.countdown(killTime, function (event) {
                //时间格式
                var format = event.strftime('秒杀倒计时: %D天 %H时 %M分 %S秒 ');
                seckillBox.html(format);
            }).on('finish.countdown', function () {
                //时间完成后回调事件
                //获取秒杀地址,控制现实逻辑,执行秒杀
                seckill.handlerSeckill(seckillBox);
            });
        } else {
            //秒杀开始
            seckill.handlerSeckill(seckillBox);
        }
    }

}
