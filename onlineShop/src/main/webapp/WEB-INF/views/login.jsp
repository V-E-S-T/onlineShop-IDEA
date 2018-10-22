<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

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
    <meta name="_csrf" content="${_csrf.token}">
    <meta name="_csrf_header" content="${_csrf.headerName}">

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

        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <a class="navbar-brand" href="${contextRoot}/home">Online Shopping</a>
                </div>
            </div>
        </nav>

        <!-- Page Content -->

        <div class="content">

            <div class="container">

                <%--this will be displayed only if authorisation failed--%>
                <c:if test="${not empty message}">
                    <div class="row">
                        <div class="offset-md-3 col-md-6">
                            <div class="alert alert-danger">${message}</div>

                        </div>

                    </div>
                </c:if>

                <%--this will be displayed only if User logged out--%>
                <c:if test="${not empty logout}">
                    <div class="row">
                        <div class="offset-md-3 col-md-6">
                            <div class="alert alert-success">${logout}</div>
                        </div>
                    </div>
                </c:if>

                <div class="row">

                    <div class="col-md-6 offset-md-3">

                        <div class="panel panel-primary">

                            <div class="card-header">
                                <h4>Login</h4>
                            </div>

                            <div class="card-body">

                                <form action="${contextRoot}/login" method="POST"
                                      id="loginForm">

                                    <div class="form-group row">
                                        <label class="col-form-label col-md-4" for="userName">Email: </label>
                                        <div class="col-md-8">
                                            <%--default parameter is name="username"--%>
                                            <input type="text" name="userName" id="userName" class="form-control"/>
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <label class="col-form-label col-md-4" for="password">Password</label>
                                        <div class="col-md-8">
                                            <%--default parameter is name="password"--%>
                                            <input type="text" name="password" id="password" class="form-control"/>
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <div class="offset-md-4 col-md-8">
                                            <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
                                            <input type="submit" value="Login" class="btn btn-primary"/>
                                        </div>
                                    </div>

                                </form>

                            </div>

                        </div>

                    </div>

                </div>

            </div>

        </div>

        <!-- Footer -->
        <%@include file="shared/footer.jsp"%>

        <!-- jQuery JavaScript -->
        <script src="${js}/jquery.js"></script>

        <!-- jQuery-validation -->
        <script src="${js}/jquery.validate.js"></script>

        <!-- Bootstrap core JavaScript -->
        <script src="${js}/bootstrap.js"></script>

        <!-- Self coded JavaScript -->
        <script src="${js}/myapp.js"></script>

    </div>

</body>

</html>