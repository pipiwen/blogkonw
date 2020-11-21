<!--Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<html lang="zxx">

<head>
	<title>Triple Forms Responsive Widget Template :: w3layouts</title>
	<!-- Meta tag Keywords -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="UTF-8" />
	<meta name="keywords" content="Triple Forms Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
	<script src="${ctx.contextPath}/resources/js/jquery-2.1.1.min.js"></script>
	<link rel="stylesheet" href="${ctx.contextPath}/resources/css/bootstrap.css">
	<link rel="stylesheet" href="${ctx.contextPath}/resources/css/bs4.pop.css">
	<script src="${ctx.contextPath}/resources/js/bootstrap.js"></script>
	<script src="${ctx.contextPath}/resources/js/bs4.pop.js"></script>
	<script>
		addEventListener("load", function () {
			setTimeout(hideURLbar, 0);
		}, false);

		function hideURLbar() {
			window.scrollTo(0, 1);
		}
	</script>
	<!-- Meta tag Keywords -->

	<!-- css files -->
	<link rel="stylesheet" href="${ctx.contextPath}/resources/css/style.css" type="text/css" media="all" />
	<!-- Style-CSS -->
	<link href="${ctx.contextPath}/resources/css/font-awesome.min.css" rel="stylesheet">
	<!-- Font-Awesome-Icons-CSS -->
	<!-- //css files -->

	<!-- web-fonts -->
	<link href="//fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i&amp;subset=cyrillic,cyrillic-ext,greek,greek-ext"
	 rel="stylesheet">
	<!-- //web-fonts -->
</head>

<body>
	<div class="main-bg">
		<!-- title -->
		<h1>Triple Forms</h1>
		<!-- //title -->
		<div class="sub-main-w3">
			<div class="image-style">

			</div>
			<!-- vertical tabs -->
			<div class="vertical-tab">
				<div id="section1" class="section-w3ls">
					<input type="radio" name="sections" id="option1" checked>
					<label for="option1" class="icon-left-w3pvt"><span class="fa fa-user-circle" aria-hidden="true"></span>Login</label>
					<article>
						<form action="#" method="post">
							<h3 class="legend">Login Here</h3>
							<div class="input">
								<span class="fa fa-envelope-o" aria-hidden="true"></span>
								<input type="username" placeholder="Username" name="username" required />
							</div>
							<div class="input">
								<span class="fa fa-key" aria-hidden="true"></span>
								<input type="password" placeholder="Password" name="password" required />
							</div>
							<button type="button" class="btn submit" onclick="onsubmit4Login()">Login</button>
							<a href="#" class="bottom-text-w3ls">Forgot Password?</a>
						</form>
					</article>
				</div>
				<div id="section2" class="section-w3ls">
					<input type="radio" name="sections" id="option2">
					<label for="option2" class="icon-left-w3pvt"><span class="fa fa-pencil-square" aria-hidden="true"></span>Register</label>
					<article>
						<form action="#" method="post">
							<h3 class="legend">Register Here</h3>
							<div class="input">
								<span class="fa fa-user-o" aria-hidden="true"></span>
								<input type="text" placeholder="Username" name="registerName" required />
							</div>
							<div class="input">
								<span class="fa fa-key" aria-hidden="true"></span>
								<input type="password" placeholder="Password" name="password1" required />
							</div>
							<div class="input">
								<span class="fa fa-key" aria-hidden="true"></span>
								<input type="password" placeholder="Confirm Password" name="password2" required />
							</div>
							<button type="button" class="btn submit" onclick="onsubmit4Register()">Register</button>
						</form>
					</article>
				</div>
				<div id="section3" class="section-w3ls">
					<input type="radio" name="sections" id="option3">
					<label for="option3" class="icon-left-w3pvt"><span class="fa fa-lock" aria-hidden="true"></span>Forgot Password?</label>
					<article>
						<form action="#" method="post">
							<h3 class="legend last">Reset Password</h3>
							<p class="para-style">Enter your email address below and we'll send you an email with instructions.</p>
							<p class="para-style-2"><strong>Need Help?</strong> Learn more about how to <a href="#">retrieve an existing
									account.</a></p>
							<div class="input">
								<span class="fa fa-envelope-o" aria-hidden="true"></span>
								<input type="email" placeholder="Email" name="email" required />
							</div>
							<button type="submit" class="btn submit last-btn">Reset</button>
						</form>
					</article>
				</div>
			</div>
			<!-- //vertical tabs -->
			<div class="clear"></div>
		</div>
		<!-- copyright -->
		<div class="copyright">
			<h2>&copy; 2019 Triple Forms. All rights reserved | Design by
				<a href="http://w3layouts.com" target="_blank">W3layouts</a>
			</h2>
		</div>
		<!-- //copyright -->
	</div>
	<script type="text/javascript">
		function onsubmit4Login() {
			var userName = $("input[name='username']").val();
			var pwd = $("input[name='password']").val();
			var pwdReg = /^(\w){6,20}$/;
			if (!$.trim(userName) && !$.trim(pwd)) {
				//$("#tipMsg").html("用户名密码不为空");
				return false;
			}
			if (!pwdReg.test(pwd)) {
				bs4pop.notice('密码长度为6-20为字母数字', {type: 'danger'})
				//$("#tipMsg").html("密码长度为6-20为字母数字");
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
						//$(window).attr('location','${ctx.contextPath}/login/updateLoginTime');
						$(window).attr('location','${ctx.contextPath}/login/indexPage');
					}
					else {
						bs4pop.notice('认证失败!', {type: 'info'});
					}
				},
				error: function (e) {
					bs4pop.notice('认证失败!', {type: 'info'});
					//$("#tipMsg").html("认证失败");
				}
			});
		}
		function onsubmit4Register() {
			var userName = $("input[name='registerName']").val();
			var pwd1 = $("input[name='password1']").val();
			var pwd2 = $("input[name='password2']").val();
			var pwdReg = /^(\w){6,20}$/;
			if (!$.trim(userName) && !$.trim(pwd)) {
				//$("#tipMsg").html("用户名密码不为空");
				return false;
			}
			if (!pwdReg.test(pwd1)) {
				bs4pop.notice('密码长度为6-20为字母数字', {type: 'danger'})
				//$("#tipMsg").html("密码长度为6-20为字母数字");
				return false;
			}
			if (!(pwd1 === pwd2)) {
				bs4pop.notice('2次密码输入不同', {type: 'danger'})
				//$("#tipMsg").html("密码长度为6-20为字母数字");
				return false;
			}
			$.ajax({
				type: "post",
				url: "${ctx.contextPath}/login/register",
				data: {
					"username": userName,
					"password": pwd1
				},
				success: function (result) {
					if(result === "success") {
						bs4pop.notice('注册成功!', {type: 'success'})
					}
					else if(result === "receipt") {
						bs4pop.notice('用户名已存在!', {type: 'danger'});
					}
					else {
						bs4pop.notice('注册失败!', {type: 'danger'});
					}
				},
				error: function (e) {
					{
						bs4pop.notice('系统异常,注册失败!', {type: 'danger'});
					}
				}
			});
		}
	</script>
</body>

</html>