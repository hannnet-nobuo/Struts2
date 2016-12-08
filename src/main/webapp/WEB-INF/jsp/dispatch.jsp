<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
	<title>処理を変える</title>
	<s:head />
</head>
<body>
	<s:form action="dispatch">
		<s:submit method="action1" />
		<s:submit method="action2" />
	</s:form>
	<s:textfield name="text"></s:textfield>
</body>
</html>
	