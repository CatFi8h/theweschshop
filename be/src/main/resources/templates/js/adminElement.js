
function changeVisibilityOfSizeBlock() {
    var divsToHide = document.getElementsByClassName("hidden_size");
    for(var i = 0; i < divsToHide.length; i++){
        var disp = divsToHide[i].style.display;
        if (disp === "none") {
            divsToHide[i].style.display = "block";
        }else {
            divsToHide[i].style.display = "none";
        }
    }
}