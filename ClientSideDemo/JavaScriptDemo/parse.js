var bearText = '{"bears":[{"id":4,"name":"Aretha","cave":{"id":56,"name":"Valhalla"}},' +
    '{"id":7,"name":"Gandalf","cave":{"id":34,"name":"Isengard"}}]}';
var bearObj = JSON.parse(bearText);

function showBears() {
    var bearDiv = document.getElementById("bearDiv");
    var bears = bearObj.bears;
    for (var i = 0; i < bears.length; i++) {
        var b = bears[i];
        var newPara = document.createElement("p");
        newPara.innerText = "name: "+b.name+"; cave: "+b.cave.name;
        bearDiv.appendChild(newPara);
        console.log(bears[i]);
    }
}