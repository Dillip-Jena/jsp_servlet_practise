<%@ taglib uri="jakarta.tags.custom" prefix="custom" %>

<html>
    <head>
        <title>Page-3</title>
    </head>
    <body>
        <custom:isEven number="12">
            <p>Even Number.</p>
        </custom:isEven>

        <custom:isEven number="3">
            <p>This is odd so it don't display anything.</p>
        </custom:isEven>
    </body>
</html>