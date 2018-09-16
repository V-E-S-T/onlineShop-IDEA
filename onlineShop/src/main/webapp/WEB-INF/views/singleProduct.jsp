<div class="container">

    <!-- Breadcrumb -->
    <div class="row">

        <div class="col-xs-12">

            <ol class="breadcrumb">

                <li><a href="${contextRoot}/home">Home&nbsp;</a></li>
                <li><a href="${contextRoot}/show/all/products">/ Products&nbsp;</a></li>
                <li><a href="${contextRoot}/show/category/${product.categoryID}/products">/ ${category.name}&nbsp;</a></li>
                <li class="active">${product.name}</li>

            </ol>

        </div>

    </div>

    <div class="row">

        <!-- Display the product image -->
        <div class="col-12 col-sm-4">

            <%--<div class="thumbnail">--%>

                <%--<img src="${images}/${product.code}.jpg" class="img img-responsive"/>--%>

            <%--</div>--%>

            <div class="img">
                <img src="${images}/${product.code}.jpg" alt="" class="img-item">
            </div>

        </div>

        <!-- Display the product description -->
        <div class="col-12 col-sm-8">

            <h3>${product.name}</h3>
            <hr/>

            <p>${product.description}</p>
            <hr/>

            <h4>Price: <strong> &#8381; ${product.unitPrice}</strong></h4>
            <hr/>

            <a href="${contextRoot}/cart/add/${product.id}/product" class="btn btn-outline-success btn-lg">
                <span class="fa fa-cart-plus"></span> Add to Cart</a>
            <a href="${contextRoot}/show/all/products" class="btn btn-outline-danger btn-lg">Back</a>

            <%--not needed becouse will be uploaded only exist products--%>

            <%--<c:choose>--%>

                <%--<c:when test="${product.quantity < 1}">--%>

                    <%--<h6>Qty. Available: <span style="color:red">Out of Stock!</span></h6>--%>

                <%--</c:when>--%>
                <%--<c:otherwise>--%>

                    <%--<h6>Qty. Available: ${product.quantity}</h6>--%>

                <%--</c:otherwise>--%>

            <%--</c:choose>--%>

            <%--<security:authorize access="isAnonymous() or hasAuthority('USER')">--%>

                <%--<c:choose>--%>

                    <%--<c:when test="${product.quantity < 1}">--%>

                        <%--<a href="javascript:void(0)" class="btn btn-success disabled"><strike>--%>
                            <%--<span class="glyphicon glyphicon-shopping-cart"></span> Add to Cart</strike></a>--%>

                    <%--</c:when>--%>
                    <%--<c:otherwise>--%>

                        <%--<a href="${contextRoot}/cart/add/${product.id}/product" class="btn btn-success">--%>
                            <%--<span class="glyphicon glyphicon-shopping-cart"></span> Add to Cart</a>--%>

                    <%--</c:otherwise>--%>

                <%--</c:choose>--%>
            <%--</security:authorize>--%>

            <%--<security:authorize access="hasAuthority('ADMIN')">--%>
                <%--<a href="${contextRoot}/manage/${product.id}/product" class="btn btn-success">--%>
                    <%--<span class="glyphicon glyphicon-pencil"></span> Edit</a>--%>
            <%--</security:authorize>--%>

            <%--<a href="${contextRoot}/show/all/products" class="btn btn-warning">--%>
                <%--Continue Shopping</a>--%>

        </div>

    </div>

</div>