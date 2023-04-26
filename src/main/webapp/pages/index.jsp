<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1 class="pb-3 pt-3">Reports</h1>
		<form:form action="search" modelAttribute="search" method="post">
			<table>
				<tr>
					<td>Plan Name :</td>
					<td><form:select path="PLANNAME">
							<form:option value="">--select--</form:option>
							<form:options items="${plannames}" />
						</form:select></td>
					<td>Plan Status :</td>
					<td><form:select path="PLANSTATUS">
							<form:option value="">--select--</form:option>
							<form:options items="${planstatus}" />
						</form:select></td>
					<td>Gender :</td>
					<td><form:select path="GENDER">
							<form:option value="">--select--</form:option>
							<form:option value="male">Male</form:option>
							<form:option value="Female">FeMale</form:option>
						</form:select></td>
				</tr>
				<tr>
					<td>Plan StartDate :</td>
					<td><form:input path="STARTDATE" type="date"
							data-date-format="mm/dd/yyyy" /></td>
					<td>Plan EndDate :</td>
					<td><form:input path="ENDDATE" type="date"
							data-date-format="mm/dd/yyyy" /></td>
				</tr>
				<tr>
				<td ><a href="/" class="btn btn-outline-secondary" >clear</a></td>
					<td><input type="submit" value="search"
						class="btn btn-outline-primary"></td>
				</tr>
			</table>
		</form:form>
		<hr>
		<table class="table table-dark table-hover">
			<thead>
				<tr>
					<th>S.no</th>
					<th>Holder Name</th>
					<th>Plan Name</th>
					<th>Gender</th>
					<th>Plan Status</th>
					<th>Start Date</th>
					<th>End Date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${plans}" var="plan" varStatus="index">
					<tr>
						<td>${index.count}</td>
						<td>${plan.CITEGEN_NAME}</td>
						<td>${plan.CITEGENPLANNAME}</td>
						<td>${plan.CITEGEN_GENDER}</td>
						<td>${plan.CITEGENPLANSTATUS}</td>
						<td>${plan.START_DATE}</td>
						<td>${plan.END_DATE}</td>

					</tr>

				</c:forEach>
				<tr>
					<c:if test="${empty plans}">
						<td colspan="7" style="text-align: center;">no records
							found..</td>
					</c:if>
				</tr>
			</tbody>
		</table>
		<hr>
		Export : <a href="">Excel</a> <a href="">Pdf</a>

		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
			crossorigin="anonymous"></script>
	</div>
</body>
</html>