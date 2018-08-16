window.onload = function(){
    document.getElementById("p1").innerText = "NEW TEXT";
    var p2Text = document.getElementById("p2").firstChild.nodeValue;
    console.log(p2Text);
    var p2 = document.getElementById("p2");
    console.log(p2);
    var p3 = document.createElement("p");
    var node = document.createTextNode("this is new");
    p3.appendChild(node);
    document.getElementById("div1").insertBefore(p3,p2);
}