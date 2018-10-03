$ (function () {

    // Solving the active menu problem
    switch (menubar)     //menubar - this is a property from window global js object (window.menubar = '${title}' from PageController)
    {
        case'About us':
            $('#about').addClass('active');   //#about - is a selector id=about from navbar.jsp
            break;
        case'Contact Us':
            $('#contact').addClass('active');   //#about - is a selector id=contact from navbar.jsp
            break;
        case'All products':
            $('#listProducts').addClass('active');   //#listProducts - is a selector id=listProducts from navbar.jsp
            break;
        case'Manage Products':
            $('#manageProducts').addClass('active');   //#listProducts - is a selector id=listProducts from navbar.jsp
            break;
        default:
            if (menubar == "Home") break;
            $('#listProducts').addClass('active');   //#listProducts - is a selector id=listProducts from navbar.jsp
            $('#a_'+menubar).addClass('active');     // menubar = '${title}' from PageController = category.getName()
            break;
    }

    //transferring _csrf token into ajax request for allows change the data with ajax request from the data table

    var token = $('meta[name="_csrf"]').attr('content');
    var header = $('meta[name="_csrf_header"]').attr('content');

    if(token.length > 0 && header.length > 0){

        $(document).ajaxSend(function (e, xhr, options) {

            xhr.setRequestHeader(header, token);
        });
    }

    //*********************************************************************************************

    var $table = $('#productListTable');

    // execute this code only where we have this table

    if ($table.length){

        var jsonUrl = '';
        // window.categoryID is added into listProduct.jsp when checking userClickAllProducts or userClickCategoryProducts from PageController
        if (window.categoryID == ''){

            jsonUrl = window.contextRoot + '/json/data/all/products';
        }
        else {
            jsonUrl = window.contextRoot + '/json/data/category/' + window.categoryID + '/products';
        }

        //console.log('Inside the table');

        $table.DataTable({

            lengthMenu: [[3,5,10,-1], ['3 records', '5 records','10 records','All']],
            pageLength: 5,
            ajax: {
                url: jsonUrl,
                dataSrc: ''
            },
            columns: [
                {
                    data: 'code',
                    mRender: function (data, type, row) {
                        return '<img src="'+ window.contextRoot + '/resources/images/' + data + '.jpg" class="dataTableImg"/>';
                    }
                },
                {
                    data: 'name'
                },
                {
                    data: 'size'
                },
                {
                    data: 'weight'
                },
                ////not needed if 'quantity' is not used in this case
                // {
                //     data : 'quantity',
                //     mRender : function(data, type, row) {
                //
                ////this block make the button in the table with red colour if product out of stock
                //         if (data < 1) {
                //             return '<span style="color:red">Out of Stock!</span>';
                //         }
                //
                //         return data;
                //
                //     }
                // },
                {
                    data: 'unitPrice',
                    // &#8381; it is symbol for RUB (russian ruble)
                    mRender: function (data, type, row) {
                        return '&#8381; ' + data
                    }
                },
                {
                    data: 'id',
                    bSortable: false,
                    mRender: function (data, type, row) {
                        var str = '';
                        str += '<a href="'+ window.contextRoot + '/show/' + data + '/product" class="btn btn-info"><span class="fa fa-eye"></span></a> &#160';

                        ////it is used for display 'Out of Stock!' instead '0' in column 'quantity'
                        // if (row.quantity < 1) {
                        //     str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
                        // } else {
                        //     str += '<a href="'+ window.contextRoot + '/cart/add/' + data + '/product" class="btn btn-success"><span class="fa fa-cart-plus"></span></a>';
                        // }
                        str += '<a href="'+ window.contextRoot + '/cart/add/' + data + '/product" class="btn btn-success"><span class="fa fa-cart-plus"></span></a>';
                        return str;
                    }
                }
            ]

        });
    }
    //------------------------------------------------------------


    //dismissing alert message after 3 seconds
    var $alert = $('.alert');
    if ($alert.length){
        setTimeout(function () {
            $alert.fadeOut('slow');
        }, 3000)
    }
    //------------------------------------------------------------



    //modal dialog window for activation and deactivation product

    $('.switch input[type="checkbox"]').on("change", function () {
        var checkbox = $(this);
        var checked = checkbox.prop("checked");
        var dMsg = (checked)? 'You want to activate the product?': 'You want to deactivate the product?';
        var value = checkbox.prop('value');

        bootbox.confirm({
            size: 'medium',
            title: 'Product activation and product deactivation',
            message: dMsg,
            callback: function(confirmed) {

                if (confirmed){

                    console.log(value);
                    bootbox.alert({
                        size: 'medium',
                        title: 'Information',
                        message: 'You are going to perform operation ' + value
                    });
                }
                else{
                    checkbox.prop('checked', !checked);
                }
            }

        });

    });
    //------------------------------------------------------------


    //dataTable for admin

    var $adminProductsTable = $('#adminProductsTable');

    // execute this code only where we have this table

    if ($adminProductsTable.length){

        var jsonUrl = window.contextRoot + '/json/data/admin/all/products';


        //console.log('Inside the table');

        $adminProductsTable.DataTable({

            lengthMenu: [[10,30,50,-1], ['10 records', '30 records','50 records','All']],
            pageLength: 30,
            ajax: {
                url: jsonUrl,
                dataSrc: ''
            },
            columns: [
                {
                    data: 'id'
                },
                {
                    data: 'code',
                    mRender: function (data, type, row) {
                        return '<img src="'+ window.contextRoot + '/resources/images/' + data + '.jpg" class="adminDataTableImg"/>';
                    }
                },
                {
                    data: 'name'
                },
                {
                    data: 'brand'
                },
                {
                    data: 'description'
                },
                {
                    data: 'size'
                },
                {
                    data: 'weight'
                },
                ////not needed if 'quantity' is not used in this case
                // {
                //     data : 'quantity',
                //     mRender : function(data, type, row) {
                //
                ////this block make the button in the table with red colour if product out of stock
                //         if (data < 1) {
                //             return '<span style="color:red">Out of Stock!</span>';
                //         }
                //
                //         return data;
                //
                //     }
                // },
                {
                    data: 'unitPrice',
                    // &#8381; it is symbol for RUB (russian ruble)
                    mRender: function (data, type, row) {
                        return '&#8381; ' + data
                    }
                },
                {
                    data: 'active',
                    bSortable: false,
                    mRender: function (data, type, row) {
                        var str = '';

                        str += '<label class="switch">';

                        if (data){
                            str += '<input type="checkbox" checked="checked" value="'+ row.id +'"/>';
                        }
                        else{
                            str += '<input type="checkbox" value="'+ row.id +'"/>';
                        }

                        str += '<span class="slider round"></span></label>';

                        return str;
                    }
                },
                {
                    data: 'id',
                    bSortable: false,
                    mRender: function (data, type, row) {
                        var str = '';

                        // str += '<a href="${contextRoot}/manage/' + data + '/product" class="btn btn-warning">';
                        // str += '<span class="fas fa-pencil-alt"></span></a>';
                        str += '<a href="'
                            + window.contextRoot
                            + '/manage/'
                            + data
                            + '/product" class="btn btn-warning"><span class="fas fa-pencil-alt"></span></a>';

                        return str;
                    }
                }
            ],

            initComplete: function () {

                var api = this.api();

                api.$('.switch input[type="checkbox"]').on('change', function () {
                    var checkbox = $(this);
                    var checked = checkbox.prop("checked");
                    var dMsg = (checked)? 'You want to activate the product?': 'You want to deactivate the product?';
                    var value = checkbox.prop('value');

                    bootbox.confirm({
                        size: 'medium',
                        title: 'Product Activation/Deactivation',
                        message: dMsg,
                        callback: function(confirmed) {

                            if (confirmed){

                                console.log(value);

                                var activationURL = window.contextRoot + '/manage/products/' + value + '/activation';

                                //TODO second alert modal window not worked - need to fix it
                                // $.get(activationURL, function (data) {
                                //
                                //     bootbox.alert({
                                //         size: 'medium',
                                //         title: 'Information',
                                //         message: data
                                //     });
                                // });

                                $.get(activationURL);
                            }
                            else{
                                checkbox.prop('checked', !checked);
                            }
                        }
                    });
                });
            }
        });
    }
    //------------------------------------------------------------

    //validation code for category

    var $categoryForm = $('#categoryForm');

    if ($categoryForm.length){

        $categoryForm.validate({

            rules: {
                name:{
                    required: true,
                    minLength: 2
                },
                description: {
                    required: true
                }
            },
            messages:{
                name: {
                    required: 'Please add the Category Name',
                    minLength: 'The Category Name should not be less than ' + this.minLength +  ' characters'
                },
                description:{
                    required: 'Please add the Category Description'
                }
            },
            errorElement: 'em',
            errorPlacement: function(error, element){
                error.addClass('help-block');
                error.insertAfter(element);
            }
        });
    }
    //-----------------------------------------

    //validation code for login form

    var $loginForm = $('#loginForm');

    if ($loginForm.length){

        $loginForm.validate({

            rules: {
                userName:{
                    required: true,
                    email: true
                },
                password: {
                    required: true
                }
            },
            messages:{
                userName: {
                    required: 'Please enter the Username (email)',
                    email: 'Please enter valid email'
                },
                password:{
                    required: 'Please enter the Password'
                }
            },
            errorElement: 'em',
            errorPlacement: function(error, element){

                // Add the 'help-block' class to the error element
                error.addClass("help-block");

                // add the error label after the input element
                error.insertAfter(element);
            }
        });
    }
    //-----------------------------------------


});