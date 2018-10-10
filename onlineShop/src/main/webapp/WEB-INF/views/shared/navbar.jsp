<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="${contextRoot}/home">Online shopping</a>
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
                    <a class="nav-link" href="${contextRoot}/show/all/products">All Products</a>
                </li>
                <li class="nav-item" id="about">
                    <a class="nav-link" href="${contextRoot}/about">About</a>
                </li>
                <li class="nav-item" id="contact">
                    <a class="nav-link" href="${contextRoot}/contact">Contact</a>
                </li>
                <li class="nav-item" id="manageProducts">
                    <a class="nav-link" href="${contextRoot}/manage/products">Manage Products</a>
                </li>
            </ul>

            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="${contextRoot}/login">Login</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${contextRoot}/register">Register</a>
                </li>
                <%--<li class="nav-item">--%>

                <%--</li>--%>

            </ul>

            <c:if test="${userModel != null}">

                <div class="btn-group nav-link">
                    <button type="button" class="btn btn-outline-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            ${userModel.fullName}
                    </button>
                    <div class="dropdown-menu">
                            <%--<a href="javascript:void(0)" class="dropdown-item"></a>--%>
                        <a href="${contextRoot}/cart/show" class="dropdown-item">
                            <span class="fa fa-cart-arrow-down"></span>
                            <span class="badge">${userModel.cart.getCartLines()}</span>
                            - &#8381; ${userModel.cart.getGrandTotal()}
                        </a>
                        <div class="dropdown-divider"></div>
                        <a href="${contextRoot}/perform-logout" class="dropdown-item">Logout</a>
                    </div>
                </div>
            </c:if>

        </div>
    </div>
</nav>

