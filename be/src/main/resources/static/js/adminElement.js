function changeVisibilityOfSizeBlock(className) {
    var divsToHide = document.getElementsByClassName(className);
    for (var i = 0; i < divsToHide.length; i++) {
        var disp = divsToHide[i].style.display;
        if (disp === "block") {
            divsToHide[i].style.display = "none";
        } else {
            divsToHide[i].style.display = "block";
        }
    }
}