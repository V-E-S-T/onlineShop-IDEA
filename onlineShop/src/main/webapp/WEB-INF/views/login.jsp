<%@include file="flows/shared/flow-header.jsp"%>

<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<div class="container">

    <div class="row">

        <div class="col-md-6 offset-md-3">

            <div class="panel panel-primary">

                <div class="card-header">
                    <h4>Login</h4>
                </div>

                <div class="card-body">

                    <%--<sf:form--%>
                            <%--method="POST"--%>
                            <%--modelAttribute="billing"--%>
                            <%--id="billingForm"--%>
                    <%-->--%>
                    <sf:form modelAttribute="">

                        <div class="form-group row">
                            <label class="col-form-label col-md-4" for="userName">User Name</label>
                            <div class="col-md-8">
                                <div class="form-control" id="userName">

                                </div>
                                <%--<sf:input type="text" path="addressLineOne" class="form-control"--%>
                                          <%--placeholder="Enter Address Line One" />--%>
                                <%--<sf:errors path="addressLineOne" cssClass="help-block" element="em"/>--%>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-form-label col-md-4" for="password">Password</label>
                            <div class="form-control" id="password">

                            </div>
                            <div class="col-md-8">
                                <%--<sf:input type="text" path="addressLineTwo" class="form-control"--%>
                                          <%--placeholder="Enter Address Line Two" />--%>
                                <%--<sf:errors path="addressLineTwo" cssClass="help-block" element="em"/>--%>
                            </div>
                        </div>


                    </sf:form>


                </div>


            </div>


        </div>


    </div>


</div>


<%@include file="flows/shared/flow-footer.jsp"%>