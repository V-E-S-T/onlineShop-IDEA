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
        default:
            if (menubar == "Home") break;
            $('#listProducts').addClass('active');   //#listProducts - is a selector id=listProducts from navbar.jsp
            $('#a_'+menubar).addClass('active');     // menubar = '${title}' from PageController = category.getName()
            break;
    }


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
                        str += '<a href="'+ window.contextRoot + '/cart/add/' + data + '/product" class="btn btn-success"><span class="fa fa-cart-plus"></span></a>';
                        return str;
                    }
                }
            ]

        });
    }
});