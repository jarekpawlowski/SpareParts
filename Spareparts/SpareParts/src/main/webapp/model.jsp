<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<body>
	<h2 align = center>Magazyn części - informacje szczegółowe</h2>
	
	<table>
		<td>
			<form action="listTyp" method="get">
				<button>Spis części</button>
			</form>
		</td>
	</table>
	<br>
	
	<table border="1" width="100%">
		<tr>
			<th>l.p.</th>
			<th>Nazwa czesci</th>
			<th>Obudowa</th>
			<th>Informacje dodatkowe</th>
		</tr>
		<c:forEach var="row" varStatus="i" items="${model}">
			<tr>
				<td><c:out value="${i.count}"/></a></td>
				<td><c:out value="${row[0]}" /></td>
				<td><c:out value="${row[1]}" /></td>
				<td><c:out value="informacje"/></td>
			</tr>
		</c:forEach>
	</table>



</body>
</html>
<h2>${message}</h2>
</body>
</html>
