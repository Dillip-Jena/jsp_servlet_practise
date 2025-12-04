<%@ taglib uri="jakarta.tags.custom" prefix="custom" %>

<html>
    <head>
        <title>Page-7</title>
    </head>
    <body>
        <custom:ifContains text="Java Language is my favourite programming language" word="Java" >
            <p>Word Found!</p>
        </custom:ifContains>
    </body>
</html>