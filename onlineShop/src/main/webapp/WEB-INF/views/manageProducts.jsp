<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <div class="row">
        <div class="col-md-8 offset-md-2">
            <%--text text-md-enter bg bg-primary--%>
            <div class="card text-white border-primary">
                <div class="card-header bg-primary">
                    <h4>Product Management</h4>
                </div>

                <div class="card-body">
                    <%--FORm ELEMENTS--%>
                    <form class="form-group row">
                        <label for="name" class="col-form-label col-md-2 text-xl-left text-primary">Name</label>
                        <div class="col-md-10">
                            <input type="text" class="form-control" id="name" name="name" placeholder="Product Name">
                            <em class="help-block">Please enter Product Name!</em>
                        </div>

                    </form>
                    <form class="form-group row">
                        <label for="brand" class="col-form-label col-md-2 text-xl-left text-primary">Brand</label>
                        <div class="col-md-10">
                            <input type="text" class="form-control" id="brand" name="brand" placeholder="Brand Name">
                            <em class="help-block">Please enter Brand Name!</em>
                        </div>
                    </form>
                    <form class="form-group row">
                        <label for="description" class="col-form-label col-md-2 text-xl-left text-primary">Description</label>
                        <div class="col-md-10">
                            <textarea type="text" class="form-control" id="description" name="description" placeholder="Product description"></textarea>
                            <em class="help-block">Please enter Product description!</em>
                        </div>
                    </form>
                    <form class="form-group row">
                        <label for="size" class="col-form-label col-md-2 text-xl-left text-primary">Size</label>
                        <div class="col-md-10">
                            <input type="text" class="form-control" id="size" name="size" placeholder="Size in mm">
                            <em class="help-block">Please enter Product Size in millimeters!</em>
                        </div>
                    </form>
                    <form class="form-group row">
                        <label for="weight" class="col-form-label col-md-2 text-xl-left text-primary">Weight</label>
                        <div class="col-md-10">
                            <input type="text" class="form-control" id="weight" name="weight" placeholder="Product Weight in gr">
                            <em class="help-block">Please enter Product Weight in grams!</em>
                        </div>
                    </form>
                    <form class="form-group row">
                        <label for="price" class="col-form-label col-md-2 text-xl-left text-primary">Price</label>
                        <div class="col-md-10">
                            <input type="number" class="form-control" id="price" name="price" placeholder="Product price in &#8381;">
                            <em class="help-block">Please enter Product price!</em>
                        </div>
                    </form>

                        <%--it is used only if field 'quantity' is exist--%>

                    <%--<form class="form-group row">--%>
                        <%--<label for="quantity" class="col-form-label col-md-2 text-xl-left text-primary">Quantity</label>--%>
                        <%--<div class="col-md-10">--%>
                            <%--<textarea type="number" class="form-control" id="quantity" name="quantity" placeholder="Quantity Available"></textarea>--%>
                            <%--<em class="help-block">Please enter Available Quantity!</em>--%>
                        <%--</div>--%>
                    <%--</form>--%>

                    <form class="form-group row">
                        <label for="categoryId" class="col-form-label col-md-2 text-xl-left text-primary">Select Category</label>
                        <div class="col-md-10">
                            <select type="number" class="form-control" id="categoryId" name="categoryId">
                                <option value="1">Category One</option>
                                <option value="2">Category Two</option>
                            </select>
                        </div>
                    </form>

                    <form class="form-group row">
                        <div class="col-form-label col-md-10">
                             <input type="submit" class="btn btn-outline-primary btn-lg" id="submit" name="submit" value="Submit">
                        </div>
                    </form>

                </div>

            </div>
        </div>
    </div>

</div>
