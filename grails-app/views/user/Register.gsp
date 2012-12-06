<%--
  Created by IntelliJ IDEA.
  User: homeLaptop
  Date: 05/12/12
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>

%{--Notice that the profile-related fields are kept in form controls--}%
%{--with the prefix “profile”: profile.fullName, profile.bio, profile.email. Grails--}%
%{--makes use of this prefix when the form is submitted to bind the field to a relation on--}%
%{--the saved object. This demonstrates how the single set of parameters are split off--}%
%{--into the User object and its nested Profile object.--}%
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Register New User</title>
    <meta name="layout" content="main">
</head>

<body>
<h1>Register New User</h1>

<g:hasErrors>
    <div class="errors">
        <g:renderErrors bean="${user}" as="list"/>
    </div>
</g:hasErrors>

<g:form action="register">
    <dl>%{--Use ? to prevent nulls--}%
        <dt>User Id</dt>
        <dd><g:textField name="userId"
                         value="${user?.userId}"/></dd>
        <dt>Password</dt>
        <dd><g:passwordField name="password"
                             value="${user?.password}"/></dd>
        <dt>Full Name</dt>
        <dd><g:textField name="profile.fullName"
                         value="${user?.profile?.fullName}"/></dd>
        <dt>Bio</dt>
        <dd><g:textField name="profile.bio"
                         value="${user?.profile?.bio}"/></dd>
        <dt>Email</dt>
        <dd><g:textField name="profile.email"
                         value="${user?.profile?.email}"/></dd>
        <dt><g:submitButton name="register" value="Register"/></dt>
    </dl>
</g:form>

</body>
</html>