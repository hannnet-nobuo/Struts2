<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Hibernate検索</title>
<s:head />
</head>
<body>
	<p>Hibernate検索</p>
	<s:form action="hiSearch" theme="simple">
		<s:textfield label="IDを入力" name="s_id" />
		<s:submit />
		<table>
			<tr>
				<th>id</th>
				<th>name</th>
				<th>memo</th>
				<th>編集</th>
				<th>削除</th>
			</tr>
			<s:iterator value="myMappings">
				<tr>
					<td><s:property value="id" /></td>
					<td><s:property value="name" /></td>
					<td><s:property value="memo" /></td>
					<td>
						<a href="<s:url namespace="/" action="hiEdit" ><s:param name="editid" ><s:property value="id" /></s:param></s:url>" >編集</a>
					</td>
					<td><s:submit type="button" value="%{id}" name="delid" >削除</s:submit></td>
				</tr>
			</s:iterator>
		</table>
	</s:form>
	<p><a href="<s:url namespace="/" action="hiNew" ></s:url>" >新規作成</a></p>
</body>
</html>