<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.functions" prefix="fn" %>

<html>
    <head>
        <title>Page-3</title>
    </head>
    <body>
        <c:set var="text" value="java is great because java is everywhere" />
        <c:set var="word" value="java" />

        <!--count the original text length-->
        <c:set var="lenOriginal" value="${fn:length(text)}" />

        <!--text after removing word-->
        <c:set var="textRemoved" value="${fn:replace(text, word, '')}" />

        <!--count the length after word removal-->
        <c:set var="lenRemoved" value="${fn:length(textRemoved)}" />

        <!--count the occurrences-->
        <c:set var="count" value="${(lenOriginal-lenRemoved) div fn:length(word)}" />

        <p>Occurrences of "java": ${count}</p>
    </body>
</html>