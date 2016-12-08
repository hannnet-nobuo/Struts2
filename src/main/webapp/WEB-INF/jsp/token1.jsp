<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
	<title>トークン１</title>
	<s:head />
</head>
<body>
	<p>トークン１</p>
	<s:form action="token2">
		<s:token />
		<s:submit />
	</s:form>
</body>
</html>