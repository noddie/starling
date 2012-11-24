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
    <legend>Advanced Search for Friends</legend>
    <g:form action="results">
        <label for="userId">User Id</label>
        <g:textField name="userId"/>
        <br>
        <label for="password">Password</label>
        <g:textField name="password"/>
        <br>
        <label for="homepage">Homepage</label>
        <g:textField name="homepage"/>
        <br>
        <label for="queryType">Query Type</label>
        <g:radioGroup values="1,2,3" name="queryType"/>
        <g:submitButton name="search" value="Search"/>

    </g:form>

</formset>
</body>
</html>