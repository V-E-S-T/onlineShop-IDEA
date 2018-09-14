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

    //code for jquery DataTable
    //create dataset

    var products = [
        ['1', 'ABC'],
        ['2', 'DFJ'],
        ['3', 'JKL'],
        ['4', 'MNO'],
        ['5', 'PRS'],
        ['6', 'TUF'],
        ['7', 'HSC']
    ];

    var $table = $('#productListTable');

    // execute this code only where we have this table

    if ($table.length){

        //console.log('Inside the table');

        $table.DataTable({

            lengthMenu: [[3,5,10,-1], ['3 records', '5 records','10 records','All']],
            pageLength: 5,
            data: products

        });
    }



});