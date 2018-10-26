<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top">
    <div class="container">
        <a class="navbar-brand" href="${contextRoot}/home">Kniga.md</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav mr-auto">
                <%--<li class="nav-item active">--%>
                    <%--<a class="nav-link" href="#">Home--%>
                        <%--<span class="sr-only">(current)</span>--%>
                    <%--</a>--%>
                <%--</li>--%>

                <li class="nav-item" id="listProducts">
                    <a class="nav-link" href="${contextRoot}/show/all/products">Главная</a>
                </li>
                <li class="nav-item" id="about">
                    <a class="nav-link" href="${contextRoot}/about">О нас</a>
                </li>
                <li class="nav-item" id="contact">
                    <a class="nav-link" href="${contextRoot}/contact">Контакты</a>
                </li>
                <li class="nav-item" id="manageProducts">
                    <a class="nav-link" href="${contextRoot}/manage/products">Управление</a>
                </li>
            </ul>

            <ul class="navbar-nav">
                <security:authorize access="!isAuthenticated()">
                    <li class="nav-item">
                        <a class="nav-link" href="${contextRoot}/login">Войти</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${contextRoot}/register">Регистрация</a>
                    </li>
                </security:authorize>

                <%--<li class="nav-item">--%>

                <%--</li>--%>

            </ul>

            <security:authorize access="isAuthenticated()">

                <div class="btn-group mx-2">
                    <button type="button" class="btn btn-outline-light dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            ${userModel.fullName}
                    </button>
                    <div class="dropdown-menu">
                            <%--<a href="javascript:void(0)" class="dropdown-item"></a>--%>

                        <%--<a href="${contextRoot}/cart/show" class="dropdown-item">--%>
                            <%--<span class="fa fa-cart-arrow-down"></span>--%>
                            <%--<span class="badge">${userModel.cart.getCartLines()}</span>--%>
                            <%--- &#8381; ${userModel.cart.getGrandTotal()}--%>
                        <%--</a>--%>

                        <a href="${contextRoot}/user/details" class="dropdown-item">Настройки</a>

                        <div class="dropdown-divider"></div>

                        <a href="${contextRoot}/perform-logout" class="dropdown-item">Выход</a>
                    </div>
                </div>

                <button type="button" class="btn mx-2">
                    <a href="${contextRoot}/cart/show" class="text-success">
                        <span class="fa fa-cart-arrow-down"></span>
                        <span class="badge">${userModel.cart.getCartLines()}</span>
                        - &#8381; ${userModel.cart.getGrandTotal()}
                    </a>
                </button>

            </security:authorize>

        </div>
    </div>
</nav>

