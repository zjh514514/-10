<%@page import="entities.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="student-list" method="post">
		<table>
			<tr>
				<td>lastName:</td>
				<td><input type="text" name="lastName" /></td>
			</tr>

			<tr>
				<td>firstName:</td>
				<td><input type="text" name="firstName" /></td>
			</tr>

			<tr>
				<td>age:</td>
				<td><input type="text" name="age" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="查询"></td>
				<td><a href="index.jsp">主页</a></td>
				<td><a href="new.jsp">增加学生</a></td>
				<td><a href="student-excel">生成Excel</a></td>
			</tr>
		</table>
	</form>
	
	<%
		List<Student> students = (List<Student>) request.getAttribute("students");
		if (students != null && students.size() > 0){
	%>
			<table border="1" cellpadding="10" cellspacing="1">
			<tr>
				<th>序号</th>
				<th>名</th>
				<th>姓</th>
				<th>年龄</th>
				<th>删除</th>
				<th>更新</th>
			</tr>
			<%
				for (Student student : students) {
			%>
			<tr>
				<td><%=student.getId()%></td>
				<td><%=student.getLastName()%></td>
				<td><%=student.getFirstName()%></td>
				<td><%=student.getAge()%></td>
				<td>
					<a href="student-delete?id=<%=student.getId()%>">delete</a>
				</td>
				<td>
					<a href="student-input?id=<%=student.getId()%>">update</a>
				</td>
				
			</tr>
			<%
				}
			%>
		</table>
		<%	
			}
		%>

</body>
</html>