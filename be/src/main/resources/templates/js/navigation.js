function nav_bar_open() {

    var element = document.getElementsByClassName('site-nav')[0];
    toggleClass(element, 'site-nav--open');
    toggleClass(document.getElementsByClassName('menu-toggle')[0], 'open' )
};

function toggleClass(element, className){
    if (!element || !className){
        return;
    }

    var classString = element.className, nameIndex = classString.indexOf(className);
    if (nameIndex == -1) {
        classString += ' ' + className;
    }
    else {
        classString = classString.substr(0, nameIndex) + classString.substr(nameIndex+className.length);
    }
    element.className = classString;
};


/*
----------------------------------------------------------
*/
