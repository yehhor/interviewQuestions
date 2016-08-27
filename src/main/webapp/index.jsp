<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<html>
<head>
    <title>TestApp</title>
    <c:set var="url">${pageContext.request.requestURL}</c:set>
    <base href="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}/" />
    <link rel="stylesheet" href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="resources/css/stylish-portfolio.css"/>
    <meta http-equiv="content-type" content="text/html charset=UTF-8" >
</head>

<body>
<header id="top" class="header">
    <div class="text-vertical-center">
        <h1>Prepare yourself!</h1>
        <h3>Free interview question service</h3>
        <br>
        <a href="questions/all" class="btn btn-dark btn-lg">Get all questions</a>
    </div>
</header>
<!-- jQuery -->
<script src="webjars/jquery/3.1.0/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
</body>
</html>
