<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin | Add City</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/admin/plugins/datatables/dataTables.bootstrap.css">

<script>
			function updateCityStatus(id,status) {
			
				var data = {"cityId":id,"isActive": status}
			
				 $.ajax({
					type : "POST",
					url : "/ECOMM/updateCityStatus",
					datatype : "application/json",
					contentType: "application/json; charset=utf-8",
					data : JSON.stringify(data),
					timeout : 100000,
					success : function(data) {
						//alert("success");
					},
					error : function(e) {
						//alert("error");
					},
					done : function(e) {
						console.log("DONE");
					}
				});
			    
			};
			</script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<jsp:include page="header.jsp"></jsp:include>
		<jsp:include page="sidebar.jsp"></jsp:include>

		<div class="content-wrapper">

			<div class="col-md-3"></div>
			<div class="col-md-6">
				<div class="box-body">
					<form:form role="form" action="saveCity" method="post"
						modelAttribute="cityMasterDto">

						<div class="form-group">

							<form:hidden path="cityId" />

							<label>Select State</label> <select class="form-control"
								name="stateMaster.stateId">

								<c:forEach items="${stateList}" var="state">

									<option value="${state.stateId}">${state.stateName}</option>
								</c:forEach>
							</select>
						</div>

						<!-- text input -->
						<div class="form-group">
							<label>Add City</label>
							<form:input path="cityName" class="form-control"
								placeholder="Enter City..." />
						</div>
						<button type="submit" class="btn btn-block btn-primary btn-sm">submit</button>
					</form:form>
				</div>
			</div>
			<div class="col-md-3"></div>

			<div>
				<!-- /.box-header -->
				<div class="box-body">
					<table id="example1" class="table table-bordered table-striped">
						<thead>
							<tr>
								<th>City ID</th>
								<th>City Name</th>
								<th>State Name</th>
								<th>Operation</th>
								<th>Status</th>

							</tr>
						</thead>
						<tbody>
							<c:forEach var="city" items="${cityList}">
								<tr>
									<td>${city.cityId}</td>
									<td>${city.cityName }</td>
									<td>${city.stateMaster.stateName}</td>
									<td><a href="editCity?cityId=${city.cityId}"><button
												type="button" class="btn bg-purple margin">Update</button></a></td>
									<td>
									<c:choose>
											<c:when test="${city.isActive eq 'A'}">

												<input type="checkbox" checked data-toggle="toggle"
													onchange="updateCityStatus(${city.cityId},'I')">
											</c:when>
											<c:otherwise>
												<input type="checkbox" data-toggle="toggle"
													onchange="updateCityStatus(${city.cityId},'A')">
											</c:otherwise>
									</c:choose>
										
										</td>


								</tr>
							</c:forEach>

						</tbody>
						<tfoot>
							<tr>
								<th>Rendering engine</th>
								<th>Browser</th>


							</tr>
						</tfoot>
					</table>
				</div>
				<!-- /.box-body -->
			</div>


		</div>






		<jsp:include page="footer.jsp"></jsp:include>

		<!-- DataTables -->
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