<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin|Add State</title>
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
					<h3 style="color: green;">${msg}</h3>
					<form:form role="form" action="saveState" method="post"
						modelAttribute="stateMasterDto">
						<!-- text input -->
						<div class="form-group">
							<label>Add State</label>
							<form:hidden path="stateId" />
							<form:input path="stateName" class="form-control"
								placeholder="Enter State..." />
							<form:hidden path="isActive" value="isActive"/>
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

								<th>State Name</th>
								<th>Status</th>
								<th>Change Status</th>
								<th>Operation</th>

							</tr>
						</thead>
						<tbody>

							<c:forEach items="${stateList}" var="state">
								<tr>

									<td>${state.stateName }</td>
									<td><c:set var="val" value="${state.isActive}"></c:set> <c:if
											test="${val=='A' }">
                      Active
          </c:if> <c:if test="${val=='I' }">
                       Inactive
         </c:if></td>
									<td><a href="deleteState?stateId=${state.stateId}">Active</a>/
										<a href="deleteState?stateId=${state.stateId}">Deactive</a>
									<td><a href="editState?stateId=${state.stateId}">Edit</a></td>

								</tr>

							</c:forEach>

						</tbody>
						<tfoot>
							<tr>
								<th></th>
								<th></th>

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