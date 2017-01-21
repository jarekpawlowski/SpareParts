<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<body>
	<h2 align = center>Magazyn części - informacje ogólne</h2>
	
	<table>
		<td>
			<form action="createTables" method="get">
				<button>Wygeneruj czesci w bazie danych</button>
			</form>
		</td>
	
		<td>
			<form action="listTyp" method="GET">
				<button>Wyświetl spis części</button>
			</form>
		</td>
		
		<td>
			<form action="insertPart" method="get">
				<!-- <input type="hidden" name="typId" value="1"> -->
				<button>Wprowadź częśc ręcznie</button>
			</form>
		</td>
	</table>
	
	<br>
	
	<table border="2" width="100%" class="w3-table w3-striped">
		<tr>
			<th>l.p.</th>
			<th>Rodzaj</th>
			<th>Typ</th>
			<th>Producent</th>
			<th>Info</th>
			<th>Ilość</th>
		</tr>
		<c:forEach var="row" varStatus="i" items="${result}">
			<tr>
				<td><c:out value="${i.count}"/></td>
				<td><c:out value="${row[1]}" /></td>
				<td><c:out value="${row[2]}" /></td>
				<td><c:out value="${row[4]}" /></td>
				<td><form action="modelList" method="get">
						<input type="hidden" name="typId" value="${row[0]}">
						<button>Info dodatkowe</button>
					</form></td>
				<td><c:out value="5" /></td>
			</tr>
		</c:forEach>
	</table>


<h2>Submitted Student Information</h2>
   <table>
    <tr>
        <td>Name</td>
        <td>${name}</td>
    </tr>
    </table>

</body>
</html>
<h2>${message}</h2>
</body>
</html>
