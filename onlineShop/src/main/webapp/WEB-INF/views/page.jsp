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
        </script>

        <!-- Bootstrap core CSS -->
        <link href="${contextRoot}/assets/css/bootstrap.min.css" rel="stylesheet">

        <!-- Bootstrap readable theme -->
        <%--<link href="${contextRoot}/assets/css/bootstrap-readable-theme.css" rel="stylesheet">--%>

        <%--<!-- Bootstrap Readable Theme -->--%>
        <%--<link href="/assets/css/bootstrap-readable-theme.css" rel="stylesheet">--%>

        <%--<!-- Bootstrap Readable Theme -->--%>
        <link href="${contextRoot}/assets/css/_bootswatch.scss" rel="stylesheet">
        <link href="${contextRoot}/assets/css/_variables.scss" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="${contextRoot}/assets/css/shop-homepage.css" rel="stylesheet">

    </head>

    <body>

    <div class="wrapper">
        <!-- Navigation -->
        <%@include file="./shared/navbar.jsp"%>
        <!-- Page Content -->

        <div class="content">
            <c:if test="${userClickHome == true}">
                <%@include file="home.jsp"%>
            </c:if>

            <%--Load only user click about--%>
            <c:if test="${userClickAbout == true}">
                <%@include file="about.jsp"%>
            </c:if>

            <%--Load only user click contact--%>
            <c:if test="${userClickContact == true}">
                <%@include file="contact.jsp"%>
            </c:if>

            <%--Load all products or products by category--%>
            <c:if test="${userClickCategoryProducts == true or userClickAllProducts == true}">
                <%@include file="listProducts.jsp"%>
            </c:if>
        </div>

        <!-- Footer -->
        <%@include file="./shared/footer.jsp"%>

        <!-- Bootstrap core JavaScript -->
        <script src="${contextRoot}/assets/js/jquery.js"></script>
        <script src="${contextRoot}/assets/js/bootstrap.bundle.js"></script>
        <!-- Self coded JavaScript -->
        <script src="${contextRoot}/assets/js/myapp.js"></script>

    </div>

    </body>

</html>

