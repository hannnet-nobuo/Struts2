<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Hibernate登録</title>
<s:head />
</head>
<body>
	<p>Hibernate登録</p>
	<p><s:text name="msg" /></p>
	<s:form action="springNew">
		<s:textfield label="IDを入力" name="id" />
		<s:textfield label="名前を入力" name="name" />
		<s:textfield label="メモを入力" name="memo" />
		<s:submit type="button" value="insert" name="insert" >確定</s:submit>
	</s:form>
	<a href="<s:url namespace="/" action="springSearch" />">検索に戻る</a>
</body>
</html>