<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>취공사</title>
    <!-- font -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
    <!-- reset,main css -->
    <link rel="stylesheet" href="/resources/css/reset.css">
    <link rel="stylesheet" href="/resources/css/index.css">
    <link rel="stylesheet" href="/resources/css/board.css">
    <link rel="stylesheet" href="/resources/css/write.css">
    <link rel="stylesheet" href="/resources/css/writeList.css">
      <link href="/resources/css/sb-admin-2.min.css" rel="stylesheet">
      <link href="/resources/css/bootstrap.css" rel="stylesheet">
      <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <!-- jquery연결 -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- jquery UI연결 -->
    <script src='//cdnjs.cloudflare.com/ajax/libs/jquery-throttle-debounce/1.1/jquery.ba-throttle-debounce.min.js'></script>
    <!-- 슬릭 가로 -->
     <link rel="stylesheet" type="text/css" href="http://kenwheeler.github.io/slick/slick/slick.css" />
     <link rel="stylesheet" href="/resources/css/slick.css">
     <!-- main js -->
    <script defer src="/resources/js/index.js"></script>
    <!-- 페이저 -->
     <link rel="stylesheet" type="text/css" href="http://kenwheeler.github.io/slick/slick/slick-theme.css" />
    <!-- 슬라이드  -->
      <script type="text/javascript" src="http://kenwheeler.github.io/slick/slick/slick.min.js"></script> 
       <script src="/resources/js/sb-admin-2.min.js"></script>
       <script src="/resources/js/bootstrap.js"></script>
       <script src="/resources/js/bootstrap.min.js"></script>
	<!-- modal창 start -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
       <div class="modal-dialog">
          <div class="modal-content">
             <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">Comment Modal</h4>
             </div>
             <div class="modal-body">
                <div class="form-group">
                   <label>댓글</label>
                   <input class="form-control" name="co_text" value=""> 
                </div>
                <div class="form-group">
                   <label>작성자</label>
                   <input class="form-control" name="user_id" value="">
                </div>
                <div class="form-group">
                   <label>작성일자</label>
                   <input class="form-control" name="co_date" value="">
                </div>
             </div> <!-- modal-body end -->
             <div class="modal-footer">
                <button id="modalModBtn" type="button" class="btn btn-warning">Modify</button>
                <button id="modalRemoveBtn" type="button" class="btn btn-danger">Remove</button>
                <button id="modalRegisterBtn" type="button" class="btn btn-primary">Register</button>
                <button id="modalCloseBtn" type="button" class="btn btn-default">Close</button>
             </div>
          </div>
       </div>
    </div>
    <!-- modal창 end -->
	<script type="text/javascript" src="/resources/js/comment.js"></script>
	<script type="text/javascript" src="/resources/js/list.js"></script>
 
</head>
<body>
   
        <div id="wrap">

    <header id="header">
        <div id="headerIn">
            <h1 class="logo"><a href="/#">취공사</a></h1>
            <nav class="gnb">
                <ul>
                    <li><a href=""></a></li>
                    <li class="gnb_point"><a href="/hobbyboard/list">게시판</a></li>
                    <li><a href=""></a></li>
                </ul>
            </nav><!-- .gnb -->
            <div class="util">
                <ul>
                    <li class="login_r"><a href="/join/login">로그인</a></li>
                    <li class="login_show"><a href="">로그아웃</a></li>
                    <li class="login_show"><a href="">회원정보수정</a></li>
                    <li class="login_r" ><a href="/join/membership">회원가입</a></li>
                </ul>
            </div><!-- .util -->
        </div><!-- #headerIn -->
    </header>