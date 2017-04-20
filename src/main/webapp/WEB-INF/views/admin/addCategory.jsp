<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/admin/plugins/datatables/dataTables.bootstrap.css">

</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<jsp:include page="header.jsp"></jsp:include>
		<jsp:include page="sidebar.jsp"></jsp:include>

		<div class="content-wrapper">

			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div class="box-body">
					<c:choose>
						    <c:when test="${categoryMasterDtoResponse.categoryMasterId eq 0}">
						      <form action="insertCategoryMaster" method="post"  modelAttribute="categoryMasterDto">
									<!-- text input -->
											<div class="form-group">
												<label>Category</label> <input type="text" class="form-control"
													placeholder="Enter Category..." name="categoryMasterName">
											</div>		
																			
									<button type="submit" class="btn btn-block btn-primary btn-sm">ADD</button>
								</form>
						    </c:when>
						    <c:otherwise>
						       <form action="/ECOMM/updateCategoryMaster" method="post"  modelAttribute="categoryMasterDto">
									<!-- text input -->
											<div class="form-group">
												<input type="hidden" name="categoryMasterId" value="${categoryMasterDtoResponse.categoryMasterId}">
											
												<label>Category</label> <input type="text" class="form-control"
													placeholder="Enter Category..." name="categoryMasterName" value="${categoryMasterDtoResponse.categoryMasterName}">
													 
											</div>		
																			
									<button type="submit" class="btn btn-block btn-primary btn-sm">Update</button>
								</form>
						    </c:otherwise>
						</c:choose>
				
				</div>
			</div>
			<div class="col-md-3"></div>

			<div>
				<!-- /.box-header -->
				<div class="box-body">
					<c:if
						test="${!empty categoryMasterDtoResponse.getCategoryMasterList()}">

						<table id="example1" class="table table-bordered table-striped">
							<thead>
								<tr>
									<th>Cateory Id</th>
									<th>Cateory Name</th>
									<th>Operation</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<c:forEach
										items="${categoryMasterDtoResponse.getCategoryMasterList()}"
										var="categoryList">
										<td>${categoryList.categoryMasterId}</td>
										<td>${categoryList.categoryMasterName}</td>
										<td>
										<a href="getCategoryMasterInformationById/${categoryList.categoryMasterId}"><button type="button" class="btn bg-purple margin">Update</button></a>
										<a href="#"><button type="button" class="btn bg-orange margin">Delete</button></a>
 										
										</td>
										</tr>
									</c:forEach>
								
							</tbody>
							<tfoot>
								<tr>
									<th>Cateory Id</th>
									<th>Cateory Name</th>
									<th>Operation</th>
								</tr>
							</tfoot>
						</table>

					</c:if>


				</div>
				<!-- /.box-body -->
			</div>
		
		</div>






		<jsp:include page="footer.jsp"></jsp:include>
		<script
			src="${pageContext.request.contextPath}/resources/admin/plugins/jQuery/jquery-2.2.3.min.js"></script>
		<!-- Bootstrap 3.3.6 -->
		<script
			src="${pageContext.request.contextPath}/resources/admin/bootstrap/js/bootstrap.min.js"></script>
		<!-- DataTables -->
		<script
			src="${pageContext.request.contextPath}/resources/admin/plugins/datatables/jquery.dataTables.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/resources/admin/plugins/datatables/dataTables.bootstrap.min.js"></script>
		<!-- SlimScroll -->
		<script
			src="${pageContext.request.contextPath}/resources/admin/plugins/slimScroll/jquery.slimscroll.min.js"></script>
		<!-- FastClick -->
		<script
			src="${pageContext.request.contextPath}/resources/admin/plugins/fastclick/fastclick.js"></script>
		<!-- AdminLTE App -->
		<script
			src="${pageContext.request.contextPath}/resources/admin/dist/js/app.min.js"></script>
		<!-- AdminLTE for demo purposes -->
		<script
			src="${pageContext.request.contextPath}/resources/admin/dist/js/demo.js"></script>
		<!-- page script -->
		<script>
			$(function() {
				$("#example1").DataTable();
				$('#example2').DataTable({
					"paging" : true,
					"lengthChange" : false,
					"searching" : false,
					"ordering" : true,
					"info" : true,
					"autoWidth" : false
				});
			});
		</script>

	</div>
</body>
</html>