<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<html>
    <head>
        <title>Page-7</title>
    </head>
    <body>
        <!-- forTokens it breaks string into parts and loop to each part -->
        <c:forTokens items="Java,Hibernate,Spring,Cloud,Kubernetes" delims="," var="topic">
            <p>${topic}</p>
        </c:forTokens>
    </body>
</html>