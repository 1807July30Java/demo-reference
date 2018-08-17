var toggle = setInterval(function () {
    console.log("called interval");
    setColor();
}, 4000);

function setColor() {
    var x = document.getElementById("toggleDiv");
    x.style.backgroundColor = x.style.backgroundColor == 'cyan' ? '#97baf5' : 'cyan';
};

function stopColor() {
    clearInterval(toggle);
};

function sendAjaxGet(url, func) {
    // step 1: obtain xhr
    var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
    // step 2: define onreadystatechange
    xhr.onreadystatechange = function () {
        console.log(this.readyState);
        if (this.readyState == 4 && this.status == 200) {
            func(this);
        }
    };
    // step 3: prepare request with open()
    xhr.open("GET", url, true);
    // finally, send()
    xhr.send();
};

function displayHero(xhr) {
    var res = JSON.parse(xhr.responseText);
    console.log(res);
    var resultDiv = document.getElementById("heroResult");
    var namePara = document.createElement("p");
    namePara.innerText = res.name;
    resultDiv.appendChild(namePara);
    var imgLink = res.image.url;
    if (imgLink) {
        var heroPic = document.createElement("img");
        heroPic.setAttribute("src", imgLink);
        resultDiv.appendChild(heroPic);
    }

}

window.onload = function () {
    toggle;
    document.getElementById("heroButton").addEventListener("click", function () {
        var heroId = document.getElementById("heroId").value;
        sendAjaxGet('http://superheroapi.com/api.php/10160885394110714/' + heroId, displayHero);
    });
}