<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

	
	<%@include file="../includes/header.jsp" %>
	
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Board Read</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                        	Board Read Page
                        </div>
                        
                        <div class="panel-body">
                        
	                        
	                        	<div class="form-group">
	                        		<label>Bno</label> 
	                        		<input class="form-control" name="bno" value="${board.bno }" readonly>
	                        	</div>
	                        
	                        	<div class="form-group">
	                        		<label>Title</label> 
	                        		<input class="form-control" name="title" value="${board.title }" readonly>
	                        	</div>
	                        	
	                        	<div class="form-group">
	                        		<label>Text area</label> 
	                        		<textarea class="form-control" rows="3" name="content" readonly>${board.content }</textarea>
	                        	</div>
	                        	
	                        	<div class="form-group">
	                        		<label>Writer</label> <input class="form-control" name="writer" value="${board.writer }" readonly>
	                        	</div>
	                        	
								<button data-oper="modify" class="btn btn-default">수정</button>	                        	
								<button data-oper="list" class="btn btn-info">리스트</button>
	                        
	                        <form id="operForm" action="/board/modify" method="get">
	                        	<input type="hidden" id="bno" name="bno" value="${board.bno}">
	                        </form>
	                        
                        </div>
						<!-- end panel-body -->                        
                     </div>   
                     <!-- end panel-default -->
				</div>
				<!-- end col-lg-12  -->
			</div>	
			<!-- end row -->
			
	<%@include file="../includes/footer.jsp" %>		
			
			
<script>
	$(document).ready(function(){
	
		var operForm = $("#operForm");
		
		$("button[data-oper='modify']").on("click",function(e){
			operForm.attr("action","/board/modify").submit();	
		});
		
		$("button[data-oper='list'").on("click",function(e){
			operForm.find("#bno").remove();
			operForm.attr("action","/board/list").submit();
		});
	});
</script>			
			