window.onload = function() {
    document.getElementById("divWithText").addEventListener("mousemove",trackMouse);
    var displayDivs = document.getElementsByClassName("displayDiv");
    for (var i = 0; i<displayDivs.length; i++){
        displayDivs[i].addEventListener("click", function(){
            console.log("target: "+event.target.id+" and this: "+this.id);
        }, true);
    }
    function trackMouse(event) {
        console.log(event.timeStamp);
        document.getElementById("mouseX").innerText = event.clientX;
        document.getElementById("mouseY").innerText = event.clientY;
    }

    //Canceling events: 
    //check if event.cancelable. If true, preventDefault()
    //use stopPropagation() to prevent propagation beyond a certain element
    //use returnFalse()
}