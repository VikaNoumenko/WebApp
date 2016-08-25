<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<body>

	<%
		HttpSession se = request.getSession();
		
	
		String status = (String) se.getAttribute("pageStatus");
		se.removeAttribute("pageStatus");
		if (status != null) {
			out.println(status);
			se.removeAttribute("pageStatus");
		}

		if (se.getAttribute("messages") == null) {
			response.sendRedirect("/send/index.jsp");
		}
		
	%>


	<div class="tabsLink">
		<a href="#views">Просмотр сообщений</a>
		<a href="#send">Отправка сообщений</a>
		<a href="#users">Пользователи</a>
		<a href="#info">Личная информация</a>
	</div>

	<br>
	<a class="tabs" id="views"></a>
	<div class="tab">
	<fieldset>
		<table>
			<tr>
				<td>Дата отправки</td>
				<td>Отправитель</td>
				<td>Текст сообщений</td>
			</tr>
			<c:forEach var="msg" items="${messages}" varStatus="msgCount">
				<tr>
					<td>${msg.sendDate}</td>
					<td>${msg.sender}</td>
					<td>${msg.text}</td>
					<td><a href="main.jsp#views">удалить</a></td>
				</tr>
			</c:forEach>
		</table>
	</fieldset>
	</div>

	<a class="tabs" id="send"></a>
	<div class="tab">
	<fieldset>
		<form action="send" method="post">
			<p><b>Выберите получателя:</b></p>
			<select multiple name="receiver" required>
				<c:forEach var="user" items="${usersList}" varStatus="status">
					<option value="${user.userName}">${user.userName}</option>
				</c:forEach>
			</select>
			<p><b>Введите текст сообщения:</b></p>
  			<p><textarea name="text"></textarea></p>
    		<input type = "submit" value = "Отправить">
		</form>
	</fieldset>
	</div>
	
</body>
</html>