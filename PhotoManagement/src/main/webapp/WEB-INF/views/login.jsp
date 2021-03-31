<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta charset="utf-8">
		<meta name="viewport"
			content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="">
		<meta name="author" content="">
		
		<link href="../../css/login.css" rel="stylesheet">
		<!-- Bootstrap core CSS -->
		<link href="../../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		
		<!-- Custom fonts for this template -->
		<link href="../../vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
		<link rel="stylesheet"
			href="../../vendor/simple-line-icons/css/simple-line-icons.css">
		<link href="https://fonts.googleapis.com/css?family=Lato"
			rel="stylesheet">
		<link
			href="https://fonts.googleapis.com/css?family=Catamaran:100,200,300,400,500,600,700,800,900"
			rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Muli"
			rel="stylesheet">
		
		
		<!-- Custom styles for this template -->
		<link href="../../css/new-age.min.css" rel="stylesheet">
		<title>로그인</title>
	</head>
<body id="page-top">

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-light fixed-top"
		id="mainNav" style="background-color: #FA5858;">
		<div class="container">
			<a class="navbar-brand js-scroll-trigger" href="/">MYSNAPS</a>
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				Menu <i class="fas fa-bars"></i>
			</button>
		</div>
	</nav>

	<div id="container">
		<div id="content">
			<form action="index.html" method="post" class="loginForm">
				<h2>Login</h2>
				<div class="idForm">
					<input type="text" class="id" placeholder="ID">
				</div>
				<div class="passForm">
					<input type="password" class="pw" placeholder="PASSWORD">
				</div>
				<button type="button" class="btn" onclick="button()">LOG IN
				</button>
				<div class="bottomText">
					Don't you have ID? <a href="#">sign up</a>
				</div>
				<div id="kakao_id_login">
					<a href="${kakaoLoginUrl}"> 
						<img src="/img/kakao_login_medium_narrow.png" />
					</a>
				</div>
				<div id="naver_id_login">
					<a href="${naverLoginUrl}"> 
						<img src="https://developers.naver.com/doc/review_201802/CK_bEFnWMeEBjXpQ5o8N_20180202_7aot50.png" />
					</a>
				</div>
			</form>
		</div>
	</div>

	<!-- Bootstrap core JavaScript -->
  <script src="../../vendor/jquery/jquery.min.js"></script>
  <script src="../../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Plugin JavaScript -->
  <script src="../../vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for this template -->
  <script src="../../js/new-age.min.js"></script>
</body>
</html>