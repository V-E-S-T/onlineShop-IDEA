<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@include file="../shared/flow-header.jsp"%>

<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<div class="container">

    <div class="row">

        <div class="col-md-6 offset-md-3">

            <div class="panel panel-primary">

                <div class="card-header">
                    <h4>Sign Up - Address</h4>
                </div>

                <div class="card-body">

                    <%--TODO autocompletion of addresses in the form with library: https://developers.google.com/maps/documentation/javascript/places?hl=ru#places_autocomplete
                        HTML:
                        <input id="autocomplete" type="text"
                            placeholder="Введите адрес" style="width: 100%">
                        JavaScript:
                        var autocomplete = new google.maps.places.Autocomplete(document.getElementById('autocomplete'), {
                            language: 'ru',
                            componentRestrictions: {country: 'md'}
                        });
                    --%>
                    <sf:form
                            method="POST"
                            modelAttribute="billing"
                            id="billingForm"
                    >


                        <div class="form-group row">
                            <label class="col-form-label col-md-4" for="addressLineOne">Address Line One</label>
                            <div class="col-md-8">
                                <sf:input type="text" path="addressLineOne" class="form-control"
                                          placeholder="Enter Address Line One" />
                                <sf:errors path="addressLineOne" cssClass="help-block" element="em"/>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-form-label col-md-4" for="addressLineTwo">Address Line Two</label>
                            <div class="col-md-8">
                                <sf:input type="text" path="addressLineTwo" class="form-control"
                                          placeholder="Enter Address Line Two" />
                                <sf:errors path="addressLineTwo" cssClass="help-block" element="em"/>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-form-label col-md-4" for="city">City</label>
                            <div class="col-md-8">
                                <sf:input type="text" path="city" class="form-control"
                                          placeholder="Enter City Name" />
                                <sf:errors path="city" cssClass="help-block" element="em"/>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-form-label col-md-4" for="postalCode">Postal Code</label>
                            <div class="col-md-8">
                                <sf:input type="text" path="postalCode" class="form-control"
                                          placeholder="XXXXXX" />
                                <sf:errors path="postalCode" cssClass="help-block" element="em"/>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-form-label col-md-4" for="state">State</label>
                            <div class="col-md-8">
                                <sf:input type="text" path="state" class="form-control"
                                          placeholder="Enter State Name" />
                                <sf:errors path="state" cssClass="help-block" element="em"/>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-form-label col-md-4" for="country">Country</label>
                            <div class="col-md-8">
                                <sf:input type="text" path="country" class="form-control"
                                          placeholder="Enter Country Name" />
                                <sf:errors path="country" cssClass="help-block" element="em"/>
                            </div>
                        </div>


                        <div class="form-group row">
                            <div class="offset-md-4 col-md-8">
                                <button type="submit" name="_eventId_personal" class="btn btn-primary">
                                    <span class="fas fa-chevron-circle-left"></span> Back - Personal
                                </button>
                                <button type="submit" name="_eventId_confirm" class="btn btn-primary">
                                    Next - Confirm<span class="fas fa-chevron-circle-right"></span>
                                </button>
                            </div>
                        </div>


                    </sf:form>


                </div>


            </div>


        </div>


    </div>


</div>


<%@include file="../shared/flow-footer.jsp"%>