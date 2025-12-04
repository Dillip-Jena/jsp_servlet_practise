<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.functions" prefix="fn" %>

<html>
    <head>
        <title>Page-8</title>
    </head>
    <body>
        <form method="post">
            <label for="email">Input email address: </label>
            <input type="text" id="email" name="mail">
            <button type="submit">Mask</button>
        </form>

        <c:set var="uemail" value="${param.mail}" />

        <!--extract the username-->
        <c:set var="username" value="${fn:substringBefore(uemail, '@')}" />

        <!--extract the domain name-->
        <c:set var="domain" value="${fn:substringAfter(uemail, '@')}" />

        <!--Take first 3 character from the username-->
        <c:set var="first3" value="${fn:substring(username, 0, 3)}" />

        <!--Create star for the remaining character-->
        <c:set var="remaining" value="${fn:length(username) - fn:length(first3)}" />

        <!--Loop to add stars-->
        <c:set var="stars" value="" />
        <c:forEach begin="1" end="${remaining}">
            <c:set var="stars" value="${stars}*" />
        </c:forEach>

        <!--Build the final masked email-->
        <c:set var="masked" value="${first3}${stars}@${domain}" />

        <p>Masked Email: ${masked}</p>
    </body>
</html>