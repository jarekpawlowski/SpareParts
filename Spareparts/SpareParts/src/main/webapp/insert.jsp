<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<body>
	<h2 align = center>Magazyn części - wprowadzanie części</h2>
	
	<table>
		<td>
			<form action="listTyp" method="GET">
				<button>Spis części</button>
			</form>
		</td>
	</table>
	<hr>
	<br>

		<form action="insertAction" method="POST">
			<table border="1" width="50%">
			<tr><td>Nazwa części: 			</td><td><input type="text" name="Name"/></td></tr>
			<tr><td>Rodzaj: 				</td><td><input type="text" name="rodzaj" /></td></tr>
			<tr><td>Typ: 					</td><td><input type="text" name="typ" /></td></tr>
			<tr><td>Informacje dodatkowe: 	</td><td><textarea name="infoDodatkowe" cols="16" rows="5" /></textarea></td></tr>
			<tr><td>Ilość: 					</td><td><input type="text" name="ilosc" /></td></tr>
			</table>
			<br>
			<input type="submit" value="Wyślij" />
		</form>
	
</body>
</html>
<h2>${message}</h2>
</body>
</html>
