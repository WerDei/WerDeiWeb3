var oddUpdate;

function init()
{
    oddUpdate = true;
    window.setInterval(updateClock, 1000);
    updateClock();
    onNameEnter();
}

function updateClock()
{
    var d = new Date();
    var f = new Intl.NumberFormat('en-GB', {minimumIntegerDigits: 2});

    var timeString = "";
    timeString += f.format(d.getHours());
    timeString += getSeparator();
    timeString += f.format(d.getMinutes());
    timeString += getSeparator();
    timeString += f.format(d.getSeconds());


    document.getElementById("clock").innerHTML = timeString;

    oddUpdate = !oddUpdate;
}

function getSeparator()
{
    return oddUpdate ? " " : ":";
}

function onNameEnter() {
    var nameError = document.getElementById("loginform-name").value === "";
    document.getElementById("loginform-form_button_login").disabled = nameError;
}