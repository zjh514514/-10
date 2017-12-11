<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<s:form action="student-save" method="post">
		<s:if test="id != null">
			<s:hidden name="id"></s:hidden>
		</s:if>

		<s:textfield name="lastName" label="lastName"></s:textfield>
		<s:textfield name="firstName" label="firstName"></s:textfield>
		<s:textfield name="age" label="age"></s:textfield>
		<s:submit value="提交"></s:submit>

	</s:form>

	<s:a href="student-list">返回查询</s:a>
	<s:a href="index.jsp">主页</s:a>

</body>
</html>