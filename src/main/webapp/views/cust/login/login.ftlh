<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/resources/css/base.css">
    <title>login登录页</title>
    <script src="${ctx.contextPath}/resources/js/jquery.min.js"></script>
    <script src="${ctx.contextPath}/resources/js/canvas.js"></script>
</head>

<body>
    <div class="t_container">
        <div id="mydiv" style="height:500px;padding:0;margin:0;position: absolute;z-index:1;"></div>
        <main class="t_main">
            <ul>
                <li class="t_titles">欢迎登录</li>
                <li>
                    <input class="user" name="userName" type="text" placeholder="请输入您的用户名">
                </li>
                <li>
                    <input type="text" name="pwd" placeholder="请输入您的密码">
                </li>
                <li id="tipMsg">

                </li>
                <input class="t_checkbox" type="checkbox" name="rememberMe">记住账号
                <!--<li class="t_checkbox">
                    <i></i>
                    <span>记住账号</span>
                </li>-->
                <li>
                    <button class="t_btn" onclick="onsubmit11()">登 录</button>
                </li>
            </ul>
        </main>
    </div>
    <script type="text/javascript">
		window.onload = function() {
		    //配置
		    var config = {
		        vx: 4,	//小球x轴速度,正为右，负为左
		        vy: 4,	//小球y轴速度
		        height: 2,	//小球高宽，其实为正方形，所以不宜太大
		        width: 2,
		        count: 100,		//点个数
		        color: "121, 162, 185", 	//点颜色
		        stroke: "220,255,255", 		//线条颜色
		        dist: 6000, 	//点吸附距离
		        e_dist: 20000, 	//鼠标吸附加速距离
		        max_conn: 50 	//点到点最大连接数
		    }

		    //调用
		    CanvasParticle(config);
		};
	</script>

    <script type="text/javascript">
        function onsubmit11() {
            var userName = $("input[name='userName']").val();
            var pwd = $("input[name='pwd']").val();
            var pwdReg = /^(\w){6,20}$/;
            if (!$.trim(userName) && !$.trim(pwd)) {
                $("#tipMsg").html("用户名密码不为空");
                return false;
            }
            if (!pwdReg.test(pwd)) {
                $("#tipMsg").html("密码长度为6-20为字母数字");
                return false;
            }
            $.ajax({
                type: "post",
                url: "${ctx.contextPath}/login/loginIn",
                data: {
                    "username": userName,
                    "password": pwd
                },
                success: function (result) {
                    if(result === "success") {
                        $(window).attr('location','${ctx.contextPath}/login/indexPage');
                    }
                },
                error: function (e) {
                    $("#tipMsg").html("认证失败");
                }
            });
        }
    </script>

</body>
</html>