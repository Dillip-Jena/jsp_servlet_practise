<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<%@ taglib uri="jakarta.tags.sql" prefix="sql" %>

<fmt:setBundle basename="db" />

<!--Load the properties-->
<fmt:message key="db.driver" var="dbDriver" />
<fmt:message key="db.url" var="dbUrl" />
<fmt:message key="db.user" var="dbUser" />
<fmt:message key="db.password" var="dbPassword" />

<!--Configure the datasource-->
<sql:setDataSource var="db"
    driver="${dbDriver}"
    url="${dbUrl}"
    user="${dbUser}"
    password="${dbPassword}"
/>