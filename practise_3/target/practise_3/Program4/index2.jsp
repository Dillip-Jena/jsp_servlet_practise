<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>

<html>
    <head>
        <title>Page-2</title>
    </head>
    <body>
        <form method="post">
            <label for="salary">Salary: </label>
            <input type="number" name="salary" id="salary" step="0.01">
            <button type="submit">Submit</button>
        </form>

        <h4>Formatted Salary: </h4>
        <fmt:setLocale value="en_IN" />
        <fmt:formatNumber value="${param.salary}" type="currency" />

        <hr>

        <form method="post">
            <label for="percent">Enter 0.85 for 85%: </label>
            <input type="number" step="0.01" name="percent" id="percent">
            <button type="submit">OK</button>
        </form>

        <h4>Formatted Percent: </h4>
        <fmt:formatNumber value="${param.percent}" type="percent" />

        <hr>

        <form method="post">
            <label for="amount">Input your amount: </label>
            <input type="number" name="amount" id="amount">
            <button type="submit">OK</button>
        </form>

        <h4>Formatted Amount: </h4>
        <fmt:parseNumber var="amt" value="${param.amount}" />
        <fmt:formatNumber value="${amt}" type="number" groupingUsed="true" />

        <hr>

        <form method="post">
            <label for="decimal">Input a decimal value: </label>
            <input type="number" id="decimal" name="decimal" step="0.001">
            <button type="submit">OK</button>
        </form>

        <h4>Number: </h4>
        <fmt:formatNumber value="${param.decimal}" type="number" maxFractionDigits="0" />
    </body>
</html>