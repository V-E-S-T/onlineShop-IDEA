<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url var="css" value="/resources/css"/>   <%-- /resources/   is a logical name (variable) defined in dispatcher-servlet.xml with phisic location="/assets/"--%>
<spring:url var="js" value="/resources/js"/>   <%-- /resources/   is a logical name (variable) defined in dispatcher-servlet.xml with phisic location="/assets/"--%>
<spring:url var="images" value="/resources/images"/>   <%-- /resources/   is a logical name (variable) defined in dispatcher-servlet.xml with phisic location="/assets/"--%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>



<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Online shopping ${title}</title>

    <script>
        <%--variable ${title} we get from PageController as attribute name "title"--%>
        window.menubar = '${title}';

        window.contextRoot = '${contextRoot}';
    </script>

    <!-- Bootstrap core CSS -->
    <link href="${css}/bootstrap.css" rel="stylesheet">

    <!-- fontAwesome icons -->
    <link href="${css}/fontawesome.css" rel="stylesheet">

    <!-- Bootstrap Readable Theme -->
    <link href="${css}/bootstrap-theme.css" rel="stylesheet">

    <%--<!-- DataTable -->--%>
    <link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${css}/shop-homepage.css" rel="stylesheet">

</head>

<body>

<div class="wrapper">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
        <div class="container">
            <div class="navbar-brand">
                <a href="${contextRoot}/home">Home</a>
            </div>
        </div>
    </nav>

    <div class="content">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="jumbotron">
                        <h1>${errorTitle}</h1>
                        <hr/>
                        <blockquote style="word-wrap:break-word">
                            ${errorDescription}
                        </blockquote>

                    </div>
                </div>
            </div>
        </div>

        </div>


    </div>

    <!-- Footer -->
    <%@include file="./shared/footer.jsp"%>

</div>

</body>

</html>


