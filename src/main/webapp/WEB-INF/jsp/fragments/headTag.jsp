<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: T
  Date: 27.08.2016
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<head>
    <title>TestApp</title>
    <c:set var="url">${pageContext.request.requestURL}</c:set>
    <base href="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}/" />
    <link rel="stylesheet" href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="resources/css/custom.css"/>
    <meta http-equiv="content-type" content="text/html charset=UTF-8" >
</head>
