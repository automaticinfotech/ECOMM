<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
					<form:form role="form" action="addAddress" method="post"
						modelAttribute="addressMasterDto">

						<div class="form-group">
							<label>Select State</label> <select class="form-control">
								<option>option 1</option>
								<option>option 2</option>
								<option>option 3</option>
								<option>option 4</option>
								<option>option 5</option>
							</select>
						</div>
						<div class="form-group">
							<label>Select City</label> <select class="form-control">
								<option>option 1</option>
								<option>option 2</option>
								<option>option 3</option>
								<option>option 4</option>
								<option>option 5</option>
							</select>
						</div>
						
						<div class="form-group">
							<label>Select Pincode</label> <select class="form-control">
								<option>option 1</option>
								<option>option 2</option>
								<option>option 3</option>
								<option>option 4</option>
								<option>option 5</option>
							</select>
						</div>

						<!-- text input -->
						<div class="form-group">
							<label>Add Address Line 1</label>
							<form:input path="addressLine1" class="form-control"
								placeholder="Enter AddressLine..." />
						</div>
						<div class="form-group">
							<label>Add Address Line 2</label>
							<form:input path="addressLine2" class="form-control"
								placeholder="Enter AddressLine..." />
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
								<th>Address ID</th>
								<th>Address Line 1</th>
								<th>Address Line 2</th>
								<th>State Name</th>
								<th>City Name</th>
								<th>Pincode Number</th>
								

							</tr>
						</thead>
						<tbody>
							<c:forEach var="address" items="${ addressMasterDtoResponceList}">
								<tr>
									<td>${address.addressId}</td>
									<td>${address.addressLine1}</td>
									<td>${address.addressLine2}</td>
									<td>${address.}</td>
									<td>${address.}</td>
									<td>${address.}</td>


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
		<%-- <script
			src="${pageContext.request.contextPath}/resources/admin/plugins/jQuery/jquery-2.2.3.min.js"></script>
 --%>
		<script
			src="${pageContext.request.contextPath}/resources/admin/plugins/datatables/jquery.dataTables.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/resources/admin/plugins/datatables/dataTables.bootstrap.min.js"></script>

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