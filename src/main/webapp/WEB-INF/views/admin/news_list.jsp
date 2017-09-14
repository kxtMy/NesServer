<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://"
+ request.getServerName() + ":" + request.getServerPort()
+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <base href="<%=basePath%>">
    <title>摄影</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <!-- basic styles -->
    <link href="resources/assets/css/bootstrap.min.css" rel="stylesheet" />
    <jsp:include page="../head.jsp"/>
</head>
<body>
 <div class="main-content" style="margin-left:0;margin-bottom:0;">
    <div class="breadcrumbs" id="breadcrumbs">
<!-- <script type="text/javascript">
    try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
</script> -->
<ul class="breadcrumb">
    <li>
        <i class="icon-camera-retro"></i>
        <a href="#">信息管理</a>
    </li>
    <li class="active">信息列表</li>
</ul><!-- .breadcrumb -->
</div>
<div class="page-content">
    <div class="page-header">
        <h1>
            信息列表
            <small>
                <i class="icon-double-angle-right"></i>
                查看
            </small>
        </h1>
    </div><!-- /.page-header -->

    <div class="row">
        <div class="col-xs-12">
            <!-- PAGE CONTENT BEGINS -->
            <div class="row">
                <div class="col-xs-12">
                    <!-- PAGE CONTENT BEGINS -->

                    <div class="row">
                        <div class="col-xs-12">
                            <form id="potography-select" class="clearfix form-actions" action="admin/photography-list" method="POST" enctype="form-data">
                                <div class="row">
                                    <div class="col-sm-3">
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1">作品名称</label>
                                              
                                            <div class="col-sm-9">
                                              <c:choose>
                                                		<c:when test="">
                                                    		<input type="text" id="form-field-1" name="title" placeholder="tilte" class="form-control" value="">
                                                		</c:when>
                                                		<c:otherwise>
                                                			<input type="text" id="form-field-1" name="title" placeholder="tilte" class="form-control">
                                                		</c:otherwise>
                                                	</c:choose>
                                            </div>
                                        </div>
                                    </div>
                                    
                                    <div class="col-sm-3">
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1">起始时间</label>

                                            <div class="col-sm-9">
                                                <div class="input-group">
                                                   <c:if test="">
                                                        	<input placeholder="yyyy-MM-dd" id="begin-time" name="begintime" onclick="laydate({istime: false, format: 'YYYY-MM-DD'})" class="laydate-icon form-control" type="text" value="">
                                                    	</c:if>
                                                    	<c:if test="">
                                                    		<input placeholder="yyyy-MM-dd" id="begin-time" name="begintime" onclick="laydate({istime: false, format: 'YYYY-MM-DD'})" class="laydate-icon form-control" type="text">
                                                    	</c:if>
                                                        <span class="input-group-addon">
															<i class="icon-calendar bigger-110"></i>
														</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <br />
                                <div class="row">
                                    <div class="col-sm-3">
                                        <!--添加下拉菜单-->
                                        <div class="form-group">
                                            <label class="col-sm-3 control-label no-padding-right" for="form-field-1">类别</label>

                                            <div class="col-sm-9">
                                               <select class="form-control" name="typeid" id="pid" onchange="gradeChange()">
													<option  value="Andorid"/>Andorid</a>
													<option  value="iOS"/>iOS</a>
                                                    <%-- <option value=""></option>
		                                                <c:forEach items="" var="photoStyle" varStatus="status">
		                                                	<c:choose>
		                                                		<c:when test="@@@@@@">
		                                                			<option value="@@@@@@@" selected="selected">@@@@@@@</option>
		                                                		</c:when>
		                                                		<c:otherwise>
		                                                			<option value="@@@@@@@@@">@@@@@@@@@</option>
		                                                		</c:otherwise>
		                                                	</c:choose>
		                                                </c:forEach> --%>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    
                                    
                                </div>
                                <br />
                                
                                     
                                </div>
                                <br />
                             
                                <br />
 <!--                                <div class="row">
                                    <div class="form-actions">
                                        <div class="col-sm-offset-5 col-md-3">
                                            <button class="btn btn-primary" type="submit">
                                                <i class="icon-ok bigger-110"></i>
                                                查询
                                            </button>

                                            &nbsp; &nbsp; &nbsp;
                                            <button class="btn btn-info" type="reset">
                                                <i class="icon-undo bigger-110"></i>
                                                重置
                                            </button>
                                        </div>
                                    </div>
                                </div> -->


                            </form>
                        </div>

                        <div class="col-xs-12">

                            <div class="row">
                                <div class="col-sm-6">
                                    <div class="dataTables_info" id="sample-table-2_info">
                                        <div class="btn-group">
                                            <a class="btn btn-info" onclick="updata()"> <i
												class="icon-edit bigger-125"></i> 更新
											</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-6">

                                </div>
                            </div>

                            <div class="table-header">
                                信息概要
                            </div>

                            <div class="table-responsive">
                                <table id="sample-table-2" class="table table-striped table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th class="center"></th>
                                        <th>序号</th>
                                        <th>描述</th>
                                        <th>类别</th>
                                        <th>作品来源</th>
                                        <th>
                                            <i class="icon-time bigger-110 hidden-480"></i>
                                            创建时间
                                        </th>
                                        <th class="hidden-480">操作</th>
                                    </tr>
                                    </thead>
                                      <tbody>
                                        	<%-- <c:choose>
                                        		<c:when test="@@@@@@@"> --%>
                                        			<%-- <c:forEach items="@@@@@@" var="photophotography" varStatus="statu"> --%>
	                                        			 <tr id="AndroidNewstb">
				                                            <td class="center">
				                                                <label>
				                                                    <input type="checkbox" class="ace" />
				                                                    <span class="lbl"></span>
				                                                </label>
				                                            </td>
				                                            <td>@@@@@</td>
				                                            <td>@@@@@@</td>
				                                            <td>@@@@@@</td>
				                                            <td>@@@@@@@</td>
				                                            <td>@@@@@@</td>
				                                            <td>@@@@@@</td>
				                                            <td>
				                                            	<%-- <fmt:formatDate value="${photophotography.publishtime}" pattern="yyyy-MM-dd" /> --%>
				                                            	@@@@@
				                                            </td>
				                                            <%-- <td> 
				                                                <div class="visible-md visible-lg hidden-sm hidden-xs action-buttons">
				
				                                                    <a class="blue" href="admin/photography-view?pictureid=${photophotography.pictureid }&photostyleid=${photophotography.styletypeid }&sporttypeid=${photophotography.sporttypeid }">
				                                                        <i class="icon-search bigger-130"></i> 详情
				                                                    </a>
				
				                                                    <a class="green" href="admin/photography?pictureid=${photophotography.pictureid }&photostyleid=${photophotography.styletypeid }&sporttypeid=${photophotography.sporttypeid }">
				                                                        <i class="icon-pencil bigger-130"></i> 编辑
				                                                    </a>
				                                                   <a class="red" style="cursor:pointer;" href="javascript:void(0);" data-did="${photophotography.pictureid}"
				                                                   href="admin/photography-del?pictureid=${photophotography.pictureid}&photourl=${photophotography.photourl}"   --%><%--  attr-id="${photophotography.pictureid }">
				                                                        <i class="icon-trash bigger-130"></i> 删除
				                                                    </a>
				                                                </div>
				                                            </td> --%>
				                                         </tr>
			                                       <%--  </c:forEach> --%>
                                        		<%-- </c:when>
                                        		<c:otherwise>
                                        			<tr>
														<td colspan="9" align="center">对不起，暂无数据！</td>
													</tr>
                                        		</c:otherwise>
                                        	</c:choose> --%>
                                       
                                        </tbody>
                                </table>
                            </div>
                            	<div class="row">
									<div class="col-sm-8 col-sm-offset-4">
										<div class="dataTables_paginate paging_bootstrap">
											<ul class="pagination">1
											</ul>
										</div>
									</div>
								</div>
                        </div>
                    </div>
                </div><!-- /.col -->
            </div><!-- /.row -->

            <!-- PAGE CONTENT ENDS -->
        </div><!-- /.col -->
    </div><!-- /.row -->
</div><!-- /.page-content -->
</div><!-- /.main-content -->

<jsp:include page="../foot.jsp"/>
<script type="text/javascript">
	$(document).ready(function init(){
		refresh("Android");
		alert("刷新");
	});
	
	
	function gradeChange(){
		var objS = document.getElementById("pid");
		var type = objS.options[objS.selectedIndex].value;
			refresh(type);
		}
		
	
	
function updata(){
	$.ajax({
		url:"news-update",
		type:"GET",
		connection: "close",
		success:function reload(data){
			if("success"==(data)){
				refresh("Android");
				alert("更新成功");
			}
			
		}
	});
}

function refresh(type){
	 $.ajax({
		  url:"news-list?type="+type,
		  type:"POST",
		  dataType: "json",
		  contentType:"charset=UTF-8",
		  //async: false, 
		  success:function(data){
			  var i=0;
			  var news;
			  var html = "";
			  data.forEach(function(news,i){
				  //var date = new Date(news.publishedAt).format('yyyy-MM-dd');
				  html += "<tr>"
						+"<td class=\"center\" width='4'>"
							+"<label>"
								+"<input type=\"checkbox\" class=\"ace\" />"
								+"<span class=\"lbl\"></span>"
							+"</label>"
						+"</td>"
						+"<td width='3'>"+(i + 1)+"</td>"
						+"<td width='60'>"+news.desc +"</td>"
						+"<td>"+news.type +"</td>"
						+"<td>"+news.url +"</td>"
						+"<td>"+news.data+"</td>"
						+"<td>"
							+"<div class='visible-md visible-lg hidden-sm hidden-xs action-buttons'>"
								+"<a class='blue' href='admin/photography-view?newsid="+news.id+"&newstype="+news.type+"'>"
									+"<i class=\"icon-search bigger-130\"></i> 详情"
							    +"</a>"
							    +"<a class=\"green\" href=\"admin/photography-view?newsid="+news.id+"&newstype="+news.type+"\">"
						         	+"<i class=\"icon-pencil bigger-130\"></i> 编辑"
							     +"</a>"
							     +" <a class=\"red\" href=\"news-delete?newsid="+news.id+"&newstype="+news.type+" \">"
							         +"<i class=\"icon-trash bigger-130\"></i> 删除"
								 +"</a>"
							+"</div>"
						+"</td>" 
					+"</tr>"; 
					console.log(html);
					$("#sample-table-2 tbody").empty().append(html);
			  });
			  
		  },
		  error:function(){
			  alert("获取数据失败");
		  }
	  });
}
		
</script>
<!-- <script type="text/javascript" src="resources/js/laydate/laydate.js"></script>
	<script type="text/javascript">
		$/* ('.date_calendar').datetimepicker({
			timeFormat : "HH:mm:ss",
			dateFormat : "yy-mm-dd",
			showSecond : true,
			beforeShow : function(input) {
				$(input).css({
					"position" : "relative",
					"z-index" : 9999
				});
			}
		}); */
		$(".red").click(
				function() {
					var data = new Object();
					data.pictureid = $(this).data('did');
					//alert(data.equipid);
					jQuery.ajax({
						headers : {
							'Accept' : 'application/json',
							'Content-Type' : 'application/json'
						},
						type : "POST",
						url : "admin/photography-del",
						data : JSON.stringify(data),
						success : function(message, tst, jqXHR) {
							if (message.result == "success") {
								return dialog.success(message.messageInfo,
										"/ostp/admin/photography-list");
							} else {
								return dialog.error(message.result);
							}
						}
					});
				})
	</script>
	<script type="text/javascript">
$("body").on("click",".pagination li a",function(){
	var url = $(this).attr("href");
	var datas = $("#potography-select").serialize();
	$(this).attr("href","javascript:;");
	$.ajax({
		url : url,
		type : "POST",
		data : datas,
		//async: false,
		dataType : "json",
		success : function(data){
			var pageStr = data[0];
			var photophotography = data[1];
			var html = "";
			for(var i = 0; i < photophotography.length; i++) {
				html += "<tr>"
					+"<td class=\"center\">"
						+"<label>"
							+"<input type=\"checkbox\" class=\"ace\" />"
							+"<span class=\"lbl\"></span>"
						+"</label>"
					+"</td>"
					+"<td>"+(i + 1)+"</td>"
					+"<td>"+photophotography[i].title +"</td>"
					+"<td>"+photophotography[i].author +"</td>"
					+"<td>"+photophotography[i].basicPhotoStyle.photostylename +"</td>"
					+"<td>"+photophotography[i].basicSportType.sporttypename +"</td>"
					+"<td>"+photophotography[i].origin+"</td>"
					+"<td>"+photophotography[i].publishtime.toString()+"</td>"
					+"<td>"
						+"<div class='visible-md visible-lg hidden-sm hidden-xs action-buttons'>"
							+"<a class='blue' href='admin/photography-view?pictureid="+photophotography[i].pictureid +"&photostyleid="+photophotography[i].styletypeid +"&sporttypeid="+photophotography[i].sporttypeid +"'>"
								+"<i class=\"icon-search bigger-130\"></i> 详情"
						    +"</a>"
						    +"<a class=\"green\" href=\"admin/photography?pictureid="+photophotography[i].pictureid +"&photostyleid="+photophotography[i].styletypeid +"&sporttypeid="+photophotography[i].sporttypeid +"\">"
					         	+"<i class=\"icon-pencil bigger-130\"></i> 编辑"
						     +"</a>"
						     +" <a class=\"red\" href=\"admin/photography-del?pictureid="+photophotography[i].pictureid +"&pictureurl="+photophotography[i].pictureurl +"\" id=\"delete_a\">"
						         +"<i class=\"icon-trash bigger-130\"></i> 删除"
							 +"</a>"
						+"</div>"
					+"</td>"
				+"</tr>";
			}
			$("#sample-table-2 tbody").empty().append(html);
			$(".pagination li").detach();
			//$(".pagination").empty().append(pageStr);
			$(".pagination").append(pageStr);
		},
	});
});
</script> -->
</body>
</html>