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
        <link href="$${css}/fontawesome.css" rel="stylesheet">

        <!-- Bootstrap readable theme -->
        <%--<link href="${contextRoot}/assets/css/bootstrap-readable-theme.css" rel="stylesheet">--%>

        <!-- Bootstrap Readable Theme -->
        <link href="$${css}/bootstrap-theme.css" rel="stylesheet">

        <%--<!-- Bootstrap Readable Theme ->--%>
        <%--<link href="${contextRoot}/assets/css/_bootswatch.scss" rel="stylesheet">--%>
        <%--<link href="${contextRoot}/assets/css/_variables.scss" rel="stylesheet">--%>

        <%--<!-- DataTable -->--%>
        <link href="$${css}/dataTables.bootstrap.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="$${css}/shop-homepage.css" rel="stylesheet">

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

            <%--Load single product page--%>
            <c:if test="${userClickShowProduct == true}">
                <%@include file="singleProduct.jsp"%>
            </c:if>
        </div>

        <!-- Footer -->
        <%@include file="./shared/footer.jsp"%>

        <!-- jQuery JavaScript -->
        <script src="${js}/jquery.js"></script>
        <!-- Bootstrap core JavaScript -->
        <script src="${js}/bootstrap.js"></script>
        <%--<script src="${contextRoot}/assets/js/bootstrap.bundle.js"></script>--%>
        <!-- DataTable Plugin -->
        <script src="${js}/jquery.dataTables.js"></script>

        <!-- DataTable Bootstrap JavaScript -->
        <script src="$${js}/dataTables.bootstrap4.js"></script>


        <!-- Self coded JavaScript -->
        <script src="${js}/myapp.js"></script>



    </div>

    </body>

</html>

