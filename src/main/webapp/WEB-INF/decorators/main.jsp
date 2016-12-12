
<!DOCTYPE html>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
	<meta charset="utf-8">
	<title><decorator:title default="Struts Starter"/></title>
  <link rel="stylesheet" type="text/css" href="style/style.css" title="style" />
  <decorator:head/>
</head>
<body>
  <div id="main">
    <div id="header">
      <div id="logo">
        <div id="logo_text">
          <!-- class="logo_colour", allows you to change the colour of the text -->
          <h1><a href="index.action">Struts2<span class="logo_colour">練習</span></a></h1>
          <h2>Struts2 練習</h2>
        </div>
      </div>
      <div id="menubar">
      </div>
    </div>
    <div id="site_content">
      <div class="sidebar">
        <!-- insert your sidebar items here -->
      </div>
      <div id="content">
        <!-- insert the page content here -->
        <h1><decorator:title default="Struts Starter"/></h1>
        <decorator:body/>
        <h2>ページ一覧</h2>
        <ul>
          <li><a href="index.action">トップページ</a></li>
          <li><a href="dispatch.action">処理を変える</a></li>
          <li><a href="message.action">国際化</a></li>
          <li><a href="messageBord.action">掲示板</a></li>
          <li><a href="testFilter.action">フィルター</a></li>
          <li><a href="token1.action">トークン</a></li>
          <li><a href="hibernate.action">Hibernateテスト</a></li>
          <li><a href="hiSearch.action">Hibernate編集</a></li>
        </ul>
      </div>
    </div>
    <div id="content_footer"></div>
    <div id="footer">
      Copyright &copy; colour_orange | <a href="http://validator.w3.org/check?uri=referer">HTML5</a> | <a href="http://jigsaw.w3.org/css-validator/check/referer">CSS</a> | <a href="http://www.html5webtemplates.co.uk">Simple web templates by HTML5</a>
    </div>
  </div>
</body>
</html>
