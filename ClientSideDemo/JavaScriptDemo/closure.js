//behavior that will execute when page loads
window.onload = function () {
    console.log("page loaded!");
    counter = getCount();
    bearCounter = getCount("bear");
    penguinCounter = getCount("penguin");
    failedLoginCounter = getCount("failed login");
    isLoggedIn = false;
}

function getCount(noun) {
    var count = 0;
    return function () {
        count += 1;
        if (noun) {
            console.log(noun + " count is: " + count);
        } else {
            console.log("count is: " + count);
        }
        return count;
    }
}

function login() {
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    if (username && password ){
        if (username === "Aretha" && password === 'awesome'){
            isLoggedIn = true;
            console.log("success");
            //do some logic
        } else {
            isLoggedIn = false;
            if (failedLoginCounter() > 3) {
                console.log("too many attempts! Account locked");
                //do some logic
            }
        }
    }
}