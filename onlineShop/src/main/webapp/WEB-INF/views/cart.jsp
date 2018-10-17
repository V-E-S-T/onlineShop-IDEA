<div class="container">
    <c:choose>
        <c:when test="${not empty cartLines}">

            <table id="cart" class="table table-hover table-condensed">
                <thead>
                <tr>
                    <th style="width:50%">Product</th>
                    <th style="width:10%">Price</th>
                    <th style="width:8%">Quantity</th>
                    <th style="width:22%" class="text-center">Subtotal</th>
                    <th style="width:10%"></th>
                </tr>
                </thead>
                <tbody>

                <c:forEach items="${cartLines}" var="cartLine">

                    <tr>
                        <td data-th="Product">
                            <div class="row">
                                <%--.img-fluid. max-width: 100%; and height: auto;--%>
                                <%--${images} - variable from page.jsp--%>
                                <div class="col-sm-2 hidden-xs"><img src="${images}/${cartLine.product.code}.jpg" alt="/resources/images/no_image_available.jpg" class="img-fluid cartImg" /></div>
                                <div class="col-sm-10">
                                    <h4 class="nomargin">${cartLine.product.name}>
                                        <c:if test="${cartLine.available == false}">
                                            <strong>(NOT AVAILABLE)</strong>
                                        </c:if>
                                    </h4>
                                    <p>Brand - ${cartLine.product.brand}</p>
                                    <p>Description - ${cartLine.product.description}</p>
                                </div>
                            </div>
                        </td>
                        <td data-th="Price" class="text-center">&#8381; ${cartLine.buyingPrice}</td>
                        <td data-th="Quantity">
                            <input type="number" id="count_${cartLine.id}" min="1" max="3" class="form-control text-center" value="${cartLine.productCount}">
                        </td>
                        <td data-th="Subtotal" class="text-center">&#8381; ${cartLine.total}</td>
                        <td class="actions" data-th="">
                            <button type="button" id="refreshCart" value="${cartLine.id}" class="btn btn-info btn-sm"><span class="fas fa-sync"></span></button>
                            <button class="btn btn-danger btn-sm"><span class="fas fa-trash-alt"></span></button>
                        </td>
                    </tr>

                </c:forEach>

                </tbody>
                <tfoot>
                <tr class="visible-xs">
                    <td class="text-center"><strong>&#8381; ${userModel.cart.grandTotal}</strong></td>
                </tr>
                <tr>
                    <td><a href="#" class="btn btn-warning"><span class="fas fa-chevron-left"></span> Continue Shopping</a></td>
                    <td colspan="2" class="hidden-xs"></td>
                    <td class="d-none d-sm-block text-center"><strong>Total &#8381; ${userModel.cart.grandTotal}</strong></td>
                    <td><a href="#" class="btn btn-success btn-block">Checkout <span class="fas fa-chevron-right"></span></a></td>
                </tr>
                </tfoot>
            </table>

        </c:when>

        <c:otherwise>
            <div class="jumbotron">
                <div class="text-center">
                    <h1>Your Cart is empty</h1>
                </div>

            </div>
        </c:otherwise>
    </c:choose>

</div>
