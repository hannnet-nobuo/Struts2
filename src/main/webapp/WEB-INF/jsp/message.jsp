<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
	<title>message</title>
	<s:head />
</head>
<body>
	<p>message</p>
	<s:text name="global.key"></s:text>
	
	<a href="<s:url  namespace="/" action="message" >
	   <s:param name="request_locale" >en</s:param>
	</s:url>" >English</a>
	
	<a href="<s:url namespace="/" action="message" >
	   <s:param name="request_locale" >ja</s:param>
	</s:url>" >Japanese</a>
	
</body>
</html>