<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <div class="row">
        <%--Would be to display sidebar--%>
        <div class="col-md-3">
            <%@include file="./shared/sidebar.jsp"%>
        </div>

        <%--to display actual products--%>

        <div class="col-md-9">

            <%--Added breadcrumb component--%>

            <div class="row">
                <div class="col-lg-12">
                    <c:if test="${userClickAllProducts == true}">
                        <ol class="breadcrumb">
                            <li><a href="${contextRoot}/home">Home&nbsp;</a></li>
                            <li class="active">/ All products</li>
                        </ol>
                    </c:if>

                    <c:if test="${userClickCategoryProducts == true}">
                        <ol class="breadcrumb">
                            <li><a href="${contextRoot}/home">Home&nbsp;</a></li>
                            <li class="active">/ Category&nbsp;</li>
                            <li class="active">/ ${category.name}</li>
                        </ol>
                    </c:if>
                </div>
            </div>

            <div class="row">
                <div class="col-12">
                    <table id="productListTable" class="table table-striped table-bordered">

                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>name</th>
                            </tr>
                        </thead>

                    </table>
                </div>
            </div>

        </div>
    </div>
</div>
