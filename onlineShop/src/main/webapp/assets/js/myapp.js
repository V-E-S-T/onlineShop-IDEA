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
        case'List products':
            $('#listProducts').addClass('active');   //#listProducts - is a selector id=listProducts from navbar.jsp
            break;
        default:
            $('#listProducts').addClass('active');   //#listProducts - is a selector id=listProducts from navbar.jsp
            $('#a_'+menubar).addClass('active');     // menubar = '${title}' from PageController = category.getName()
            break;
    }
});