<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
	<title>Hibernateテスト</title>
	<s:head />
</head>
<body>
<p>Hibernateのテストです</p>
<table>
<tr><th>id</th><th>name</th><th>memo</th></tr>
<s:iterator value="myMappings">
  <tr>
  <td><s:property value="id" /></td>
  <td><s:property value="name" /></td>
  <td><s:property value="memo" /></td>
  </tr>
</s:iterator>
</table>
</body>
</html>