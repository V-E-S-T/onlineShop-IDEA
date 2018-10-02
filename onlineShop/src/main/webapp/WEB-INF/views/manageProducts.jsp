<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <div class="row">
        <c:if test="${not empty successMessage}">

            <div class="col-12">
                <div class="alert alert-success alert-dismissible">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    ${successMessage}
                </div>
            </div>

        </c:if>
        <c:if test="${not empty failedMessage}">

            <div class="col-12">
                <div class="alert alert-warning alert-dismissible">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                        ${failedMessage}
                </div>
            </div>

        </c:if>
        <div class="col-md-8 offset-md-2">
            <%--text text-md-enter bg bg-primary--%>
            <div class="card text-white border-primary">
                <div class="card-header bg-primary">
                    <h4>Product Management</h4>
                </div>

                <div class="card-body">
                    <%--FORm ELEMENTS--%>
                    <%--in the spring form not needed to include _csrf token because it is included automatically--%>
                    <sf:form modelAttribute="newProduct" action="${contextRoot}/manage/products" method="POST" enctype="multipart/form-data">
                        <div class="form-group row">
                            <label for="name" class="col-form-label col-md-2 text-xl-left text-primary">Name</label>
                            <div class="col-md-10">
                                <%--attribute path="name" should be correspond Product field "name" --%>
                                <sf:input path="name" type="text" class="form-control" id="name" name="name" placeholder="Product Name"/>
                                <sf:errors path="name" cssClass="help-block" element="em"/>
                                <%--<em class="help-block">Please enter Product Name!</em>--%>
                            </div>

                        </div>
                        <div class="form-group row">
                            <label for="brand" class="col-form-label col-md-2 text-xl-left text-primary">Brand</label>
                            <div class="col-md-10">
                                <sf:input path="brand" type="text" class="form-control" id="brand" name="brand" placeholder="Brand Name"/>
                                <sf:errors path="brand" cssClass="help-block" element="em"/>
                                <%--<em class="help-block">Please enter Brand Name!</em>--%>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="description" class="col-form-label col-md-2 text-xl-left text-primary">Description</label>
                            <div class="col-md-10">
                                <sf:textarea path="description" type="text" class="form-control" id="description" name="description" placeholder="Product description"/>
                                <sf:errors path="description" cssClass="help-block" element="em"/>
                                <%--<em class="help-block">Please enter Product description!</em>--%>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="size" class="col-form-label col-md-2 text-xl-left text-primary">Size</label>
                            <div class="col-md-10">
                                <sf:input path="size" type="text" class="form-control" id="size" name="size" placeholder="Size in mm"/>
                                <sf:errors path="size" cssClass="help-block" element="em"/>
                                <%--<em class="help-block">Please enter Product Size in millimeters!</em>--%>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="weight" class="col-form-label col-md-2 text-xl-left text-primary">Weight</label>
                            <div class="col-md-10">
                                <sf:input path="weight" class="form-control" id="weight" name="weight" placeholder="Product Weight in gr"/>
                                <sf:errors path="weight" cssClass="help-block" element="em"/>
                                <%--<em class="help-block">Please enter Product Weight in grams!</em>--%>
                            </div>
                        </div>
                        <%--File element for image uppload--%>
                        <div class="form-group row">
                            <label for="file" class="col-form-label col-md-2 text-xl-left text-primary">Select an image: </label>
                            <div class="col-md-10">
                                <sf:input path="file" type="file" class="form-control-plaintext"/>
                                <sf:errors path="file" cssClass="help-block" element="em"/>
                                <%--<em class="help-block">Please enter Product price!</em>--%>
                            </div>
                        </div>

                        <%--it is used only if field 'quantity' is exist--%>

                        <%--<div class="form-group row">--%>
                        <%--<label for="quantity" class="col-form-label col-md-2 text-xl-left text-primary">Quantity</label>--%>
                        <%--<div class="col-md-10">--%>
                        <%--<textarea type="number" class="form-control" id="quantity" name="quantity" placeholder="Quantity Available"></textarea>--%>
                        <%--<em class="help-block">Please enter Available Quantity!</em>--%>
                        <%--</div>--%>
                        <%--</div>--%>

                        <div class="form-group row">
                            <label for="price" class="col-form-label col-md-2 text-xl-left text-primary">Price</label>
                            <div class="col-md-10">
                                <sf:input path="unitPrice" type="number" class="form-control" id="price" name="price" placeholder="Product price in &#8381;"/>
                                <sf:errors path="unitPrice" cssClass="help-block" element="em"/>
                                    <%--<em class="help-block">Please enter Product price!</em>--%>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="categoryId" class="col-form-label col-md-2 text-xl-left text-primary">Select Category</label>
                            <div class="col-md-10">
                                <%--items="${categories}" we take from ManageController @ModelAttribute("categories")--%>
                                <%--itemLabel="name" it is the field from Categoty class, which will be displayed inside select button--%>
                                <%--itemValue="id" it is the field from Categoty class, which corresponded with path="categoryID"--%>
                                <sf:select path="categoryID" class="form-control" id="categoryId"
                                           items="${categories}"
                                           itemLabel="name"
                                           itemValue="id"
                                />

                                <c:if test="${newProduct.id == 0}">

                                    <div class="text-right">

                                        <br/>
                                        <button type="button" data-toggle="modal" data-target="#myCategoryModal" class="btn btn-primary btn-sm">Add Category</button>
                                    </div>

                                </c:if>

                            </div>
                        </div>

                        <div class="form-group row">
                            <div class="col-form-label col-md-10">
                                <input type="submit" class="btn btn-outline-primary btn-lg" id="submit" name="submit" value="Submit">
                                <sf:hidden path="id"/>
                                <sf:hidden path="code"/>
                                <sf:hidden path="active"/>
                                <sf:hidden path="purchases"/>
                                <sf:hidden path="views"/>
                            </div>
                        </div>
                    </sf:form>


                </div>

            </div>
        </div>

    </div>

    <div class="row">
        <div class="col-12">
            <hr/>
            <h1>Available Products</h1>
            <hr/>
        </div>
        <div class="col-12">

            <%--stile="overflow:auto"--%>
            <%--<div >--%>

                <%--Products table for admin--%>


            <table id="adminProductsTable" class="table table-condensed table-bordered" style="overflow:auto">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>&#160;</th>
                    <th>Name</th>
                    <th>Brand</th>
                    <th>Description</th>
                    <th>Size</th>
                    <th>Weight</th>
                    <%--<th>Qty. Avail</th>--%>
                    <th>Unit Price</th>
                    <th>Activate</th>
                    <th>Edit</th>
                </tr>
                </thead>

                <tfoot>
                <tr>
                    <th>Id</th>
                    <th>&#160;</th>
                    <th>Name</th>
                    <th>Brand</th>
                    <th>Description</th>
                    <th>Size</th>
                    <th>Weight</th>
                    <%--<th>Qty. Avail</th>--%>
                    <th>Unit Price</th>
                    <th>Activate</th>
                    <th>Edit</th>
                </tr>
                </tfoot>
            </table>
        </div>
    </div>

    <div class="modal" id="myCategoryModal" role="dialog" tabindex="-1">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <%--Modal header--%>
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"></button>
                    <span>&times;</span>
                    <h4 class="modal-title"></h4>
                </div>
                <div class="modal-body">
                    <%--Category Form--%>
                    <sf:form modelAttribute="category" action="${contextRoot}/manage/category" method="POST" cssClass="form-group" id="categoryForm">
                        <div class="row">

                            <label for="category_name" class="col-form-label col-md-4 text-xl-left text-primary">Category Name</label>
                            <div class="col-md-8">
                                    <%--attribute path="name" should be correspond Product field "name" --%>
                                <sf:input path="name" type="text" class="form-control" id="category_name" name="category_name" placeholder="Category Name"/>
                                <sf:errors path="name" cssClass="help-block" element="em"/>
                                    <%--<em class="help-block">Please enter Product Name!</em>--%>
                            </div>
                        </div>

                        <div class="row">

                            <label for="category_description" class="col-form-label col-md-4 text-xl-left text-primary">Category Description</label>
                            <div class="col-md-8">
                                    <%--attribute path="name" should be correspond Product field "name" --%>
                                <sf:textarea path="description" cols="" rows="5" class="form-control" id="category_description" name="category_description" placeholder="Category Description"/>
                                <sf:errors path="description" cssClass="help-block" element="em"/>
                                    <%--<em class="help-block">Please enter Product Name!</em>--%>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-form-label col-md-10">

                                <input type="submit" class="btn btn-outline-primary btn-lg" id="submit" name="submit" value="Submit">
                            </div>
                        </div>

                    </sf:form>
                </div>

            </div>

        </div>
    </div>

</div>
