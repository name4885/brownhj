/**
 *  rest방식으로 댓글처리하기 (ajax사용)
 */
//항상 이벤트 안에서 호출!
$(document).ready(function(){
	var bo_numValue=$('#bo_num').val();
	var commentUL=$(".chat")
	console.log(bo_numValue);
	   showList(1);    
	   
	   var pageNum=1;
	   
	   var commentPageFooter=$(".panel-footer");
	   
	   function showCommentPage(ctCnt){
		   var endNum=Math.ceil(pageNum/10.0)*10;
		   
		   var startNum=endNum-9;
		   var prev=startNum!=1;
		   var next=false;

		   if(endNum*10>=ctCnt){ 
			   endNum=Math.ceil(ctCnt/10.0)
		   }
		   if(endNum*10<ctCnt){ 
			   next=true;
		   }
		   var str="<ul class='pagination pull-right'>"
		
		   if(prev){//이전버튼을 누르면
			   str+="<li class='page-item'><a class='page-link' href='"+(startNum-1)+"'>prev</a></li>"
		   }													 
		   for(var i=1;i<=endNum;i++){ 
			   var active=pageNum==i?"active":"";
			   str+="<li class='page-item "+active+"'><a class='page-link' href='"+i+"'>"+i+"</a></li>"
		   }
		   if(next){//다음버튼을 누르면
			   str+="<li class='page-item'><a class='page-link' href='"+(endNum+1)+"'>next</a></li>"
		   }													 
		   str+="</ul></div>";
		   console.log(str);
		   commentPageFooter.html(str);
	   }
	   
	   function showList(page){   
	      CommentService.getList({bo_num:bo_numValue,page:page||1},function(ctCnt,list){ // getList 함수 호출 시작
	         
	    	  var str="";

	    	  if(page==-1){//page번호가 없으면
	    		  pageNum=Math.ceil(ctCnt/10.0)
	    		  showList(pageNum);
	    		  return;
	    	  }
	    	  
	         if(list==null || list.length==0){
	            commentUL.html("");
	            return;
	         }
	         
	         
	         console.log(list.length);
	         for(var i=0, len=list.length||0; i<len ; i++){
	        	 str+="<li class='left clearfix' data-co_num='"+list[i].co_num+"'>"
		         str+="<div>"
		         str+="<div class='header'>"
		         str+="<strong class='primary-font'>"+list[i].user_id+"</strong>"
		         str+="<small class='pull-right text_muted'>"+CommentService.displayTime(list[i].co_date)+"</small>"
		         str+="</div>"
		      	 str+="<p>"+list[i].co_text+"</p>"
		         str+="</div></li>";
	        	 
	         }      
	         commentUL.html(str);
	         showCommentPage(ctCnt);
	      }) 
	   }   //   showList함수 선언 끝
	   
	   
	   
	   
	   
	   var modal=$(".modal")
	   var modalInputCo_text=modal.find("input[name='co_text']")// 모달 안 댓글 인풋창
	   var modalInputUser_id=modal.find("input[name='user_id']")// 모달 안 작성자 인풋창
	   var modalInputCo_date=modal.find("input[name='co_date']")// 모달 안 날짜 인풋 창
	   var modalModBtn=$("#modalModBtn")// 모달 수정 버튼
 	   var modalRemoveBtn=$("#modalRemoveBtn")// 모달 삭제 버튼
	   var modalRegisterBtn=$("#modalRegisterBtn")// 모달 글쓰기 버튼 
	   var modalCloseBtn=$("#modalCloseBtn")// 모달 닫기 버튼
	   console.log("아하하하하하")
	   $('#addCommentBtn').on("click",function(){
//		   alert("댓글쓰기")
		   modal.modal("show");
		   
		   modalCloseBtn.click(function(){modal.modal("hide")})
		   
		   modal.find("input").val("");
		   
		   modalInputCo_date.closest("div").hide();
		   
		   modal.find("button[id!='modalCloseBtn']").hide();
		   
		   modalRegisterBtn.show();

		   		
	
	   })// 클릭 이벤트 함수
	   
   	   modalRegisterBtn.click(function(){
		   
		   var comment={co_text:modalInputCo_text.val(),
				   user_id:modalInputUser_id.val(),
				   bo_num:bo_numValue};
			//CommentService함수 호출
			CommentService.add(comment,
					function(result){alert("Result : "+result);
					modal.modal("hide");
					showList(1);});
			
		
	   })// modalRegisterBtn 클릭이벤트 함수
	   
 

	   $(".chat").on("click","li",function(e){
	      var co_num=$(this).data("co_num");
	      
	      console.log(co_num);
	      modal.modal("show"); 
	      modalCloseBtn.click(function(){modal.modal("hide")})
	      
	      CommentService.get(co_num,function(comment){
	    	  modalInputCo_text.val(comment.co_text);
	    	  modalInputUser_id.val(comment.user_id);
	    	  modalInputCo_date.val(CommentService.displayTime(comment.co_date)).attr("readonly","readonly");
	    	 
	    	  modal.data("co_num",comment.co_num);												
	    	 
	    	  modal.find("button[id!='modalCloseBtn']").hide();
	    	  modalModBtn.show();
	    	  modalRemoveBtn.show();
	      })
	   })//chat함수 
	   
	   
	   
	   //댓글수정처리
	   modalModBtn.on("click",function(e){
		   var comment={co_num:modal.data("co_num"),co_text:modalInputCo_text.val()};
		   CommentService.update(comment,
							   function(result){ 
							         alert("수정완료");
							         modal.modal("hide");
							         showList(pageNum);
							      }                 
							   ) 

	   })
	   
	   
	   
	   //댓글삭제처리
	   modalRemoveBtn.on("click",function(e){
		   var co_num=modal.data("co_num");
			CommentService.remove(co_num, 
					
		function(count){console.log(count);if(count==="success")
		{alert("removed");modal.modal("hide");showList(pageNum);}}, 
		
		function(err){alert("error....")}) 
	   })
	   
	   
	   
	   
	   commentPageFooter.on("click","li a",function(e){ 
		   e.preventDefault(); 

		   var targetPageNum=$(this).attr("href");
		   pageNum=targetPageNum; 
		   showList(pageNum); 
	   })
})//document 준비 함수







var CommentService = (function(){ 
	
	function add(comment,callback,error){ 
		console.log("reply.....")	
	
		$.ajax({
			type:"post", 
			url:"/replies/new", 
			data:JSON.stringify(comment), 
			contentType:"application/json; charset=UTF-8",
			success:function(result,status,xhr){ 
				if(callback){callback(result)}}, 
			error:function(result,status,er){ 
				if(error){error(er)}}
		}) 
	}  
	
	
function getList(param,callback,error){ 
		
		var bo_num = param.bo_num;
		var page= param.page || 1;
		
		$.getJSON("/replies/pages/"+bo_num+"/"+page+".json",  
	function(data){
			if(callback){
				callback(data.ctCnt,data.list);
			}
		})  
		.fail(function(xhr,status,err){ 
			if(error){
				error();
			}
		}); 
	}



function remove(co_num,callback,error){ 
	$.ajax({ // ajax 시작
		type:"delete", 
		url:"/replies/"+co_num, 
		success:function(result,status,xhr){
			if(callback){callback(result)}}, 
		error:function(result,status,er){
			if(error){error(er)}}
	}) // ajax 끝
}	


   function update(comment, callback, error){   
	      console.log("RNO = "+comment.co_num); 
	      $.ajax({                        // ajax 시작
	         type:"put",
	         url:"/replies/"+comment.co_num,
	         data:JSON.stringify(comment),
	         contentType:"application/json; charset=UTF-8",
	         success:function(result,status,xhr){   // 수정 성공시 시작
	            if(callback){
	               callback(result)
	            }
	         },   // 수정 성공 끝
	         error:function(xhr,status,er){   // 수정 실패시 시작
	            if(error){
	               error(er);
	            }            
	         }   // 수정 실패 끝
	      })   // ajax 끝
	   }   // update함수 선언 끝
   
   
   
   
   function get(co_num,callback,error){   
	      $.get("/replies/"+co_num+".json",
	         function(result){
	            if(callback){
	               callback(result);
	            }
	         }).fail(function(xhr,status,err){
	            if(error){
	               error();
	            }
	         });
	   }   
   
   
   function displayTime(timeValue){
	   var today = new Date(); 
	   var gap = today.getTime - timeValue;
	   var dateObj = new Date(timeValue); 
	   var str="";
	   if(gap<(1000*60*60*24)){ 
		   var hh = dateObj.getHours();
		   var mm = dateObj.getMinutes();
		   var ss = dateObj.getSeconds();
		   
		   return [(hh>9 ? '':'0')+hh,':',(mi>9?'':'0')+mi,
			   ':',(ss>9? '':'0')+ss].join('');
	   } else{
		   var yy=dateObj.getFullYear();
		   var mm=dateObj.getMonth()+1;
		   var dd=dateObj.getDate(); 
		   return [yy,'/',(mm>9?'':'0')+mm,'/',(dd>9?'':'0')+dd].join('');
	   }
   }
	   
	return {add:add,
		getList:getList,
		remove:remove,
		update:update,
		get:get,
		displayTime:displayTime};
})();