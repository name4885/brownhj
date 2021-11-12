<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../includes/header.jsp" %>

    <div id="writingList-wrap">
    	<div>
        <table id="write-main">
        	<tr><td>번호</td><td><input type="hidden" id="bo_num" name="bo_num" value="${read.bo_num}">${read.bo_num}</td></tr>
            <tr><td>제목</td><td class="write-title">${read.bo_title}</td></tr>
            <tr><td>내용</td><td class="write-text">${read.bo_text }</td></tr>
            <tr><td>작성자</td><td>${read.user_id}</td></tr>
			<tr><td>작성일자</td><td>${read.bo_date}</td></tr>
        </table><!-- #write-main -->
            <div class="list-btn">
                <ul class="btn-L">
                    <li><a href="/hobbyboard/list"><button type="menu">목록</button></a></li>
                </ul>
                <ul class="btn-R">
                    <li><button><a href="/hobbyboard/modify?bo_num=${read.bo_num}">글수정</a></button></li>
                    <li><button><a href="/hobbyboard/remove?bo_num=${read.bo_num}">글삭제</a></button></li>
                </ul>
            </div>
         </div>
    </div>
    
    
    
	<div id="comment" style="color:'red'"><!-- row -->
	      <div class="col-lg-12">
	         <div class="panel panel-default">
	               <h1>댓글 달기</h1>
	            <div id="comment-in">
	            
	               <div class="comment-list">
	                  <ul class="chat">
	                     </ul>      
	               </div><!--panel-body -->
	            </div>
	               <button id="addCommentBtn" class="btn btn-primary">글쓰기</button>
	            
	            <div class="panel-footer">
	         
	            </div>
	            
	         </div><!--panel-default -->
	      </div><!-- col-lg-12 -->
	   </div><!-- row -->
    
    
    
    
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