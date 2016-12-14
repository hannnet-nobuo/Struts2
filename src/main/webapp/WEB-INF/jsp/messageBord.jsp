<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
	<title>掲示板</title>
	<s:head />
</head>
<body>
<jsp:useBean id="bordData" scope="application" class="jp.hannet.sample.model.DataList" />
	<s:form action="messageBord">
		<s:textfield label="タイトル" name="title" />
		<s:textfield label="メッセージ" name="msg" />
		<s:submit />
	</s:form>
<table>
<tr>
	<th>タイトル</th>
	<th>メッセージ</th>
	<th>時間</th>
</tr>
<s:iterator value="bordData.data">
  <tr>
  <td><s:property value="title" /></td>
  <td><s:property value="msg" /></td>
  <td><s:property value="date" /></td>
  </tr>
</s:iterator>
</table>
</body>
</html>