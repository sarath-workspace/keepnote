
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>KeepNote</title>
	<script type="application/javascript">


		function validateForm() {
			var noteid = document.forms["addnote"]["noteId"];
			var notetitle = document.forms["addnote"]["noteTitle"];
			var notescontent = document.forms["addnote"]["noteContent"];
			var notestatus = document.forms["addnote"]["noteStatus"];
			if("" == noteid) {
				alert("Note ID cannot be empty");
				return false;
			}
			if("" == notetitle) {
				alert("Note Title cannot be empty");
				return false;
			}
			if("" == notescontent) {
				alert("Note Content cannot be empty");
				return false;
			}
			if("" == notestatus) {
				alert("Note Status cannot be empty");
				return false;
			}
			return true;
		}
	</script>
</head>
<body>
	<!-- Create a form which will have text boxes for Note ID, title, content and status along with a Send 
		 button. Handle errors like empty fields -->
	<form name="addnote" action="/saveNote" onsubmit="validateForm()">
		<table>
			<tr>
				<td>Note ID  :</td>
				<td><input type="text" name="noteId"/></td>
			</tr>
			<tr>
				<td>Note Title:</td>
				<td><input type="text" name="noteTitle"/></td>
			</tr>
			<tr>
				<td>Note Content:</td>
				<td><input type="text" name="noteContent"/></td>
			</tr>
			<tr>
				<td>Note Status:</td>
				<td><input type="text" name="noteStatus"/></td>
			</tr>
			<tr>
				<td><input type="submit" /></td>
			</tr>
		</table>
	</form>
	<!-- display all existing notes in a tabular structure with Id, Title,Content,Status, Created Date and Action -->
	<table>
		<th>
			<td>Note Id</td>
			<td>Note Title</td>
			<td>Note Content</td>
			<td>Note Status</td>
			<td>Created Date</td>

		</th>
		<jstl:forEach items="${notes}" var="note">
			<tr>
				<form name="deletenNote" action="/deleteNote?nodeId=${note.noteId}">
				<td>${note.noteId}</td>
				<td>${note.noteTitle}</td>
				<td>${note.noteContent}</td>
				<td>${note.noteStatus}</td>
				<td>${note.createdAt}</td>
				<td><input type="submit" value="Delete"></td>
				</form>
			</tr>
		</jstl:forEach>
	</table>
</body>
</html>