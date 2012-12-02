<%--
  Created by IntelliJ IDEA.
  User: AmysDelight
  Date: 20/11/12
  Time: 22:55
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Advanced Search Results</title>
    <meta name="layout" content="main"/>
</head>

<body>
<h1>Advanced Results</h1>

<p>Searched for items matching <em>${term}</em>.
Found <strong>${profiles.size()}</strong> hits.
</p>
<ul>
    <g:each var="profile" in="${profiles}">
        <li>${profile.fullName}</li>
    </g:each>
</ul>
<g:link action='advSearch'>Search Again</g:link>
</body>
</html>