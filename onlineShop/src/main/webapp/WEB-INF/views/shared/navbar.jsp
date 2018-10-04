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
                <li class="dropdown">
                    <a href="javascript:void(0)" class="btn btn-outline-primary dropdown-toggle" id="dropdownMenu1"
                    data-toggle="dropdown">
                        Full name
                        <span class="caret"></span>
                    </a>

                </li>
            </ul>

        </div>
    </div>
</nav>

