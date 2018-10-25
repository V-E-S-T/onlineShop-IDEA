<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>

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
                    <h4>Профиль пользователя</h4>
                </div>

                <div class="card-body">
                    <%--FORm ELEMENTS--%>
                    <%--in the spring form not needed to include _csrf token because it is included automatically--%>
                    <sf:form modelAttribute="user" action="${contextRoot}/user/detail" method="POST" enctype="multipart/form-data">
                        <div class="form-group row">
                            <label for="first_name" class="col-form-label col-md-2 text-xl-left text-primary">Имя</label>
                            <div class="col-md-10">
                                    <%--attribute path="name" should be correspond Product field "name" --%>
                                <sf:input path="first_name" type="text" class="form-control" id="first_name" name="first_name" placeholder="Имя"/>
                                <sf:errors path="first_name" cssClass="help-block" element="em"/>
                                    <%--<em class="help-block">Please enter Product Name!</em>--%>
                            </div>

                        </div>
                        <div class="form-group row">
                            <label for="last_name" class="col-form-label col-md-2 text-xl-left text-primary">Фамилия</label>
                            <div class="col-md-10">
                                <sf:input path="last_name" type="text" class="form-control" id="last_name" name="last_name" placeholder="Фамилия"/>
                                <sf:errors path="last_name" cssClass="help-block" element="em"/>
                                    <%--<em class="help-block">Please enter Brand Name!</em>--%>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="email" class="col-form-label col-md-2 text-xl-left text-primary">email</label>
                            <div class="col-md-10">
                                <sf:textarea path="email" type="text" class="form-control" id="email" name="email" placeholder="email"/>
                                <sf:errors path="email" cssClass="help-block" element="em"/>
                                    <%--<em class="help-block">Please enter Product description!</em>--%>
                            </div>
                        </div>
                        <div class="form-group row">

                            <div class="col-md-10">
                                <button type="button" data-toggle="modal" data-target="#changePasswordModal" class="btn btn-outline-primary btn-sm">Сменить пароль</button>
                            </div>
                        </div>

                        <div class="form-group row">
                            <div class="col-form-label col-md-10">
                                <input type="submit" class="btn btn-outline-primary btn-lg" id="submit" name="submit" value="Submit">
                                <sf:hidden path="id"/>
                                <sf:hidden path="role"/>
                                <sf:hidden path="active"/>
                            </div>
                        </div>
                    </sf:form>


                </div>

            </div>
        </div>

    </div>

    <div class="modal" id="changePasswordModal" role="dialog" tabindex="-1">
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
                    <sf:form modelAttribute="user" action="${contextRoot}/user/password" method="POST" cssClass="form-group" id="changePasswordForm">
                        <div class="row">

                            <label for="new_password" class="col-form-label col-md-4 text-xl-left text-primary">Новый пароль</label>
                            <div class="col-md-8">
                                    <%--attribute path="name" should be correspond Product field "name" --%>
                                <sf:input path="password" type="text" class="form-control" id="new_password" name="new_password" placeholder="Пароль"/>
                                <sf:errors path="password" cssClass="help-block" element="em"/>
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
