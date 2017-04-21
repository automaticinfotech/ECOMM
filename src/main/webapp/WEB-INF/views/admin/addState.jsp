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
<style type="text/css">
.switch {
  position: relative;
  display: inline-block;
  width: 60px;
  height: 34px;
}

/* Hide default HTML checkbox */
.switch input {display:none;}

/* The slider */
.slider {
  position: absolute;
  cursor: pointer;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: #ccc;
  -webkit-transition: .4s;
  transition: .4s;
}

.slider:before {
  position: absolute;
  content: "";
  height: 26px;
  width: 26px;
  left: 4px;
  bottom: 4px;
  background-color: white;
  -webkit-transition: .4s;
  transition: .4s;
}

input:checked + .slider {
  background-color: #2196F3;
}

input:focus + .slider {
  box-shadow: 0 0 1px #2196F3;
}

input:checked + .slider:before {
  -webkit-transform: translateX(26px);
  -ms-transform: translateX(26px);
  transform: translateX(26px);
}

/* Rounded sliders */
.slider.round {
  border-radius: 34px;
}

.slider.round:before {
  border-radius: 50%;
}
Try it Yourself »

❮ PreviousNext ❯
COLOR PICKER

 colorpicker

</style>
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
							<label>${operation }</label>
							<form:hidden path="stateId" />
							<form:input path="stateName" class="form-control"
								placeholder="Enter State..." />
							<form:hidden path="isActive" value="isActive" />
						</div>
						<button type="submit" class="btn btn-block btn-primary btn-sm">submit</button>
					</form:form>
				</div>
			</div>
			<div class="col-md-3"></div>

			<div>
				<!-- /.box-header -->
				<div class="box-body">
					<table id="example2" class="table table-bordered table-hover">
						<thead>
							<tr>
								<th>State ID</th>
								<th>State Name</th>
								<th>Status</th>

								<th>Operation</th>
								<th>Change Status</th>

							</tr>
						</thead>
						<tbody>



							<c:forEach items="${stateList}" var="state">
								<tr>
									<td>${state.stateId}</td>
									<td>${state.stateName }</td>
									<td><c:set var="val" value="${state.isActive}"></c:set> <c:if
											test="${val=='A' }"> Active
											</c:if> <c:if test="${val=='I' }">Inactive
                                            </c:if></td>

									<td><a href="editState?stateId=${state.stateId}"><button
												type="button" class="btn bg-purple margin">Update</button></a></td>
									<td><a href="activeState?stateId=${state.stateId}">Active</a>/
										<a href="inactiveState?stateId=${state.stateId}">Inactive</a></td>
									<td><label class="switch"> <input type="checkbox">
											<div class="slider round"></div>
									</label></td>

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
					"lengthChange" : true,
					"searching" : false,
					"ordering" : false,
					"info" : true,
					"autoWidth" : true
				});
			});
		</script>

	</div>
</body>
</html>