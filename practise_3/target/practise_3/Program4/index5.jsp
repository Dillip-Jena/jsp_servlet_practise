<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>

<jsp:useBean id="now" class="java.util.Date"/>

<html>
    <head>
        <title>Page-5</title>
    </head>
    <body>
        <form method="post">
            <label for="lang">Select one language: </label>
            <select name="lang" id="lang">
                <option value="en_US">English</option>
                <option value="ja_JP">Japanese</option>
                <option value="hi_IN">Hindi</option>
            </select>
            <button type="submit">Change Locale</button>
        </form>

        <fmt:setLocale value="${param.lang}" />
        <fmt:formatDate value="${now}" type="date" dateStyle="full" />
    </body>
</html>