<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/resources/css/reset.css">
    <link rel="stylesheet" href="/resources/css/write.css">
</head>
<body>

    <div id="wrap">
        <header id="header">
            <div id="headerIn">
                <h1 class="logo"><a href="./index.html"><img src="img/logo.png" alt="취공사"></a></h1>
                <nav class="gnb">
                    <ul>
                        <li><a href=""></a></li>
                        <li class="gnb_point"><a href="/hobbyboard/list">게시판</a></li>
                        <li><a href=""></a></li>
                    </ul>
                </nav><!-- .gnb -->
                <div class="util">
                    <ul>
                        <li><a href="Login_main.html">로그인</a></li>
                        <li class="login_show"><a href="">로그아웃</a></li>
                        <li class="login_show"><a href="">회원정보수정</a></li>
                        <li><a href="join.html">회원가입</a></li>
                        <li><a href="index1.html">ENG</a></li>
                    </ul>
                </div><!-- .util -->
                <div class="search">
                    <form action="" name="h_search_box">
                        <fieldset>
                            <legend>검색</legend>
                            <input type="text" class="hs_input_text" name="hs_pd_name" id="hs_pd_name">
                            <input type="button" value="" class="hs_input_btn" id="hs_sesarch_submit">
                        </fieldset>
                    </form>
                </div><!--.search-->
            </div><!-- #headerIn -->
        </header>
    <div id="write-wrap">
    <form action="modify" method="post" >
        <div id="write-main">
            <div class="write-title">
                <div>제목</div>
                <div>
                	<input type="text" id="bo_title" name="bo_title" value="${modify.bo_title}">
                	<input type="hidden" name="bo_num" value="${modify.bo_num}">
                </div>
            </div>
            <div class="write-text">
                <div>내용</div><div><textarea  name="bo_text" id="bo_text" cols="50" rows="30" maxlength="2000" style="resize: none;">${modify.bo_text}</textarea></div>
            </div>
            <div>
            	<div>작성자</div><div id="bo_title" name="user_id">${modify.user_id}</div>
            </div>
            <ul>
                <li><button type="submit">글수정</button></li>
                <li><a href="/hobbyboard/read"><button type="reset">취소</button></a></li>
            </ul>
        </div>
    </form>
    </div>

    <div id="footer">
        <div class="footerIn">
            <div class="fL">
                <div class="fLogo"><img src="img/logo.png" alt=""></div>
                <div class="copyright">
                    Copyright ⓒ 2021 취공사 All Rights Reserved.
                </div>
            </div><!-- .fL-->
            <div class="fR">
                <div class="fCs">
                    <h3>문의사항</h3>
                    <p class="tel">
                        <img src="./img/icon_tel.png" alt="">
                        <span></span>
                    </p>
                    <P class="time">
                        Mon-Fri. 10:00 ~ 17:00  / Lunch.12:00 ~ 13:30 <br>
                        korea_gywls@naver.com
                    </P>
                </div>
            <div class="goTop">
                <a href="#"><img src="./img/btn_top.png"></a>
            </div>
        </div><!-- .footerIn-->
    </div><!-- #footer -->

</div><!-- #wrap -->
</body>
</html>