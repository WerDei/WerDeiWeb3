var valueXvalid;
var valueYvalid;
var valueRvalid;


function init()
{
    console.log("Initialising the page...");

    var date = new Date();
    var timezoneOffset = date.getTimezoneOffset();

    valueXvalid = false;
    valueYvalid = false;
    valueRvalid = false;

    drawGraph();
    onYChange();
    isDataValidAndReady();
}


function onXChange() {
    valueXvalid = true;
    isDataValidAndReady();
}

function onYChange() {
    var y = document.getElementById("pointsend-form_value_y_display").innerHTML;
    console.log(valueYvalid);
    isDataValidAndReady();
}

function onRChange()
{
    console.log("R value has changed!");

    valueRvalid = true;
    var r = document.getElementById("pointsend-form_value_r_container").value;

    drawHitArea(r);
    drawPointsFromTable();
    isDataValidAndReady();
}


function isDataValidAndReady()
{
    var valid = valueXvalid && valueYvalid && valueRvalid;
    document.getElementById("form_button_submit").disabled = !valid;
}

function onGraphClick(event, testPointGraph)
{
    if (!valueRvalid)
    {
         document.getElementById("pointsend-form_value_r_display").innerHTML
            = "You first need to enter the R, silly!";
    }
    else
    {
        var r = document.getElementById("pointsend-form_value_r_container").value;
        var canvas = document.getElementById("pointCanvas");
        var rect = canvas.getBoundingClientRect();

        var x = Number(((event.pageX - window.pageXOffset - rect.x - canvas.width / 2) / pixelsPerUnit).toFixed(2));
        var y = Number((-(event.pageY - window.pageYOffset - rect.y - canvas.height / 2) / pixelsPerUnit).toFixed(2));

        if (x >= -5 && x <= 5 && y >= -5 && y <= 5) {
            document.getElementById("graphform-xGraph").value = x;
            document.getElementById("graphform-yGraph").value = y;
            document.getElementById("graphform-rGraph").value = r;
            testPointGraph();
        }
    }
}

function historyClearPageUpdate()
{
    console.log("Updating the page after history clear...");

    document.getElementById("results").classList.add("hidden");

    clearPoints();
}

function showResults()
{
    document.getElementById("results").classList.remove("hidden");
}

function drawPointsFromTable()
{
    console.log("Putting previous points on the graph...");

    var table = document.getElementById("resultTable").getElementsByTagName("tbody")[0];
    for (var i = 0; i < table.children.length; i++) {
        var row = table.children[i];
        if (row.children[2].innerHTML != 0)
            putPoint(row.children[0].innerHTML, row.children[1].innerHTML, row.children[4].innerHTML.includes("true"));
    }
}