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

    <!-- Bootstrap readable theme -->
    <%--<link href="${contextRoot}/assets/css/bootstrap-readable-theme.css" rel="stylesheet">--%>

    <!-- Bootstrap Readable Theme -->
    <link href="${css}/bootstrap-theme.css" rel="stylesheet">

    <%--<!-- Bootstrap Readable Theme ->--%>
    <%--<link href="${contextRoot}/assets/css/_bootswatch.scss" rel="stylesheet">--%>
    <%--<link href="${contextRoot}/assets/css/_variables.scss" rel="stylesheet">--%>

    <%--<!-- DataTable -->--%>
    <link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${css}/shop-homepage.css" rel="stylesheet">

</head>

<body>

<div class="wrapper">
    <!-- Navigation -->

    <%@include file="flow-navbar.jsp"%>

    <!-- Page Content -->

    <div class="content">