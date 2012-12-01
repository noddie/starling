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
    <table>

        <g:form action="results">
            <tr>
                <td>Name</td>
                <td><g:textField name="fullName"/></td>
            </tr>

            <tr>
                <td>EmailAddress</td>
                <td><g:textField name="password"/></td>
            </tr>
            <tr><td>Homepage</td>
                <td><g:textField name="homepage"/></td>
            </tr>
            <tr>
                <td>Query Type</td>
                %{--The order of the lables tag and values seem to matter here!--}%
                <td><g:radioGroup name="queryType" labels="['And', 'Or', 'Not']" values="['and', 'or', 'not']"
                                  value="and">
                    ${it.radio} ${it.label}
                </g:radioGroup>
                </td>
            </tr>
            <tr>
                <td><g:submitButton name="search" value="Search"/></td>
            </tr>

        </g:form>
    </table>
</formset>
</body>
</html>