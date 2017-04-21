<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Map Discount</title>
<script
	src="${pageContext.request.contextPath}/resources/admin/js/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/admin/js/jquery.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/admin/css/datepicker.css" />
<script
	src="${pageContext.request.contextPath}/resources/admin/js/bootstrap-datepicker.js"></script>
<script type="text/javascript">
			$(document).ready(function() {
				$('#fromDate').datepicker({
					format : "dd-mm-yyyy"
				});
			});
		</script>

<script type="text/javascript">
    $(document).ready(function () {
        $('#toDate').datepicker({
            format: "dd-mm-yyyy"
        });
    });
</script>

<%-- <script
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
		</script> --%>

</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<jsp:include page="header.jsp"></jsp:include>
		<jsp:include page="sidebar.jsp"></jsp:include>
       
		<div class="content-wrapper">
			<div>
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<div class="box-body">
					   
						<form:form modelAttribute="subProductMasterDiscountMapperDto"
							action="insertSubProductDiscountMapperInformation" >

							<!-- <div class="form-group">
								<label>From Date</label> <input type="text"
									name="subProductMasterDiscountMapperFromDate"
									class="form-control" placeholder="Enter From Date.."
									id="fromDate" />
							</div>

							<div class="form-group">
								<label>To Date</label> <input type="text"
									name="subProductMasterDiscountMapperToDate"
									class="form-control" placeholder="Enter To Date.." id="toDate" />
							</div> -->

							<div class="form-group">
								<label>Select Product</label> 
								<select name="subProductMaster.subProductId" class="form-control">
					           				<c:forEach items="${subProductMasterList}" var="subProduct">
											<option value="${subProduct.subProductId }">${subProduct.subProductName }</option>
								 		</c:forEach>
									 </select> 
							</div>

							<div class="form-group">
							     <label>Select Discount</label> 
								<select name="discountMaster.discountMasterId" class="form-control">
					           				<c:forEach items="${discountMasterList}" var="discount">
											<option value="${discount.discountMasterId }">${discount.dicountMasterName }</option>
								 		</c:forEach>
									 </select> 
							</div>


							<button type="submit" class="btn btn-block btn-primary btn-sm">Submit</button>
						</form:form>

					</div>
				</div>
				<div class="col-md-3"></div>

			</div>
			<div>
				<!-- /.box-header -->


				<div class="box-body">
					<table id="example1" class="table table-bordered table-striped">
						<thead>
							<tr>
								<th>DiscountMapper Id</th>
								<th>Discount FromDate</th>
								<th>Discount ToDate</th>
								<th>Sub Product Name</th>
								<th>Discount Name</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="subProductDiscount"
								items="${ subProductMasterDiscountMapperList}">
								<tr>
									<td>${subProductDiscount.subProductMasterDiscountMapperId}</td>
									<td><fmt:formatDate
											value="${subProductDiscount.subProductMasterDiscountMapperFromDate}"
											pattern="dd-MMM-yyyy"></fmt:formatDate></td>
									<td><fmt:formatDate
											value="${subProductDiscount.subProductMasterDiscountMapperToDate}"
											pattern="dd-MMM-yyyy"></fmt:formatDate></td>
									<td>${subProductDiscount.subProductMaster.subProductName}</td>
									<td>${subProductDiscount.discountMaster.dicountMasterName}</td>
									<td><a
										href="/ECOMM/getDiscountMasterInformationById/${discount.discountMasterId}"><input
											type="button" value="Update" class="btn btn-primary"></a></td>
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

	</div>


</body>
</html>