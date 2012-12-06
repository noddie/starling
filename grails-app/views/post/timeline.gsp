<%--
  Created by IntelliJ IDEA.
  User: homeLaptop
  Date: 02/12/12
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <title>Timeline for ${user.profile.fullName}</title>
    <meta name="layout" content="main">
</head>

<body>
<h1>Timeline for ${user.profile.fullName}</h1>


%{--Create a text box so the user can add more posts--}%
<div id="newPost">
    <g:if test="${flash.message}">
        <div class="flash">
            ${flash.message}
        </div>
    </g:if>
    <h3>
        what is ${user.profile.fullName} hacking right now?
    </h3>

    <p>
    %{--get the id from the params so that we can add data to it--}%
        <g:form action="addPost" id="${params.id}">
        %{--create the text box for the message--}%
            <g:textArea id='postContent' name="content"
                        row="3" cols="50"/>  </br>
        %{--create a submit button--}%
            <g:submitButton name="post" value="Post"/>
        </g:form>
    </p>
</div>

%{--create a div for post and loop through them, we can reference them as they have come from the controller--}%
%{--Although we are in the post view, we can use the user reference. In essence we are using the users' profile--}%
<div class="allPosts">
%{--loop through the post object--}%
    <g:each in="${user.posts}" var="post">
    %{--create a header of each entry--}%
        <div class="postEntry">
            %{--the actual text--}%
            <div class="postText">
                ${post.content}
            </div>

            <div class="postDate">
                ${post.dateCreated}
            </div>
        </div>
    </g:each>
</div>
</body>
</html>