<%--
  Created by IntelliJ IDEA.
  User: AmysDelight
  Date: 20/11/12
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Search Starling</title>
    <meta name="layout" content="main"/>
</head>

<body>
<formset>
    <legend>Search for Friends</legend>
    <g:form action="results">
        <label for="userId">User Id</label>
        <g:textField name="userId"/>

        <g:submitButton name="earch" value="Search"/>
    </g:form>

</formset>
</body>
</html>