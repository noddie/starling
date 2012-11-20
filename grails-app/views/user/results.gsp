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
    <title>Search Results</title>
    <meta name="layout" content="main"/>
</head>

<body>
<h1>Results</h1>

<p>Searched ${com.psychicTyrion.User.count()} records
for items matching <em>${term}</em>.
Found <strong>${users.size()}</strong> hits.
</p>
<ul>
    <g:each var="user" in="${users}">
        <li>${user.userId}</li>
    </g:each>
</ul>




</p>
</body>
</html>