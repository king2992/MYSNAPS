<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta charset="utf-8">
		<meta name="viewport"
			content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="">
		<meta name="author" content="">
		
		<link href="../../css/repo.css" rel="stylesheet">
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
		<title>저장소</title>
	</head>
<body id="page-top">

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav" style="background-color: #FA5858;">
    <div class="container">
      <a class="navbar-brand js-scroll-trigger" href="/">MYSNAPS</a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        Menu
        <i class="fas fa-bars"></i>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <c:if test="${member eq 'kakaoMember'}">
          	<li>
				<a class="nav-link js-scroll-trigger" href="/login/page">Sign Out</a>
			</li>
		  </c:if>
		  <c:if test="${member eq null}">
		 	<li>
				<a class="nav-link js-scroll-trigger" href="/login/page">Sign In</a>
			</li>
		  </c:if>
		  <c:if test="${member ne null}">
		  	<c:if test="${member eq 'kakaoMember'}">
		  		<li>
		  			<a class="nav-link js-scroll-trigger" href="${kakaoLogoutUrl}">Sign Out</a>
		  		</li>
		  	</c:if>
		    <c:if test="${member eq 'naverMember'}">
		    	<li>
		    		<a class="nav-link js-scroll-trigger" href="/naver/logout">Sign Out</a>
		    	</li>
		    </c:if>
		  </c:if>
        </ul>
      </div>
    </div>
  </nav>

	<div id="container">
		<div class="support-grid"></div>

		<div class="band">
			<div class="item-1">
				<div class="card">
					<div class="thumb" style="background-image: url(https://cdn.pixabay.com/photo/2017/01/14/10/57/woman-1979272_1280.jpg);"></div>
					<article>
						<h1>Title Area</h1>
						<span>Tag Area</span>
					</article>
				</div>
			</div>
			<div class="item-2">
				<div class="card">
					<div class="thumb" style="background-image: url(https://s3-us-west-2.amazonaws.com/s.cdpn.io/210284/flex-1.jpg);"></div>
					<article>
						<h1>Title Area</h1>
						<span>Tag Area</span>
					</article>
				</div>
			</div>
			<div class="item-3">
				<div class="card">
					<div class="thumb" style="background-image: url(https://cdn.pixabay.com/photo/2020/03/06/05/05/corona-19-4906057_1280.jpg);"></div>
					<article>
						<h1>Title Area</h1>
						<p>Explanation Area</p>
						<span>Tag Area</span>
					</article>
				</div>
			</div>
			<div class="item-4">
				<div class="card">
					<div class="thumb" style="background-image: url(https://cdn.pixabay.com/photo/2016/05/17/22/12/fashion-1399315_960_720.jpg);"></div>
					<article>
						<h1>Title Area</h1>
						<p>Explanation Area</p>
						<span>Tag Area</span>
					</article>
				</div>
			</div>
			<div class="item-5">
				<div class="card">
					<div class="thumb" style="background-image: url(https://cdn.pixabay.com/photo/2016/02/22/08/29/scenery-1214950_1280.jpg);">
					</div>
					<article>
						<h1>Title Area</h1>
						<span>Tag Area</span>
					</article>
				</div>
			</div>
			<div class="item-6">
				<div class="card">
					<div class="thumb" style="background-image: url(https://s3-us-west-2.amazonaws.com/s.cdpn.io/210284/flor.jpg);">
					</div>
					<article>
						<h1>Title Area</h1>
						<span>Tag Area</span>/span>
					</article>
				</div>
			</div>
			<div class="item-7">
				<div class="card">
					<div class="thumb" style="background-image: url(https://cdn.pixabay.com/photo/2017/10/07/17/48/woman-2827333_1280.jpg);"></div>
					<article>
						<h1>Title Area</h1>
						<span>Tag Area</span>
					</article>
				</div>
			</div>
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