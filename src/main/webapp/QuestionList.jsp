<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>


</head>
<body>
Here is the list of questions with answers
<table>
    <thead>
    <tr>
        <th>id</th>
        <th>question</th>
        <th>answer</th>
    </tr>
    </thead>
    <c:forEach items="${questionList}" var="question">
        <tr>
            <td>${question.id}</td>
            <td>${question.question}</td>
            <td>${question.answer}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
