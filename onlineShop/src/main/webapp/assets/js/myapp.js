$ (function () {

    // Solving the active menu problem
    switch (menubar)     //menubar - this is a property from window global js object (window.menubar = '${title}')
    {
        case'About us':
            $('#about').addClass('active');   //#about - is a selector id=about from navbar.jsp
            break;
        case'Contact Us':
            $('#contact').addClass('active');   //#about - is a selector id=about from navbar.jsp
            break;
        default:
            $('#home').addClass('active');   //#about - is a selector id=about from navbar.jsp
            break;
    }

});