var pixelsPerUnit = 29;
var marks = 4;

function drawGraph() {
    var canvas = document.getElementById("axisCanvas");
    var context = canvas.getContext('2d');

    var h = canvas.height;
    var w = canvas.width;
    context.strokeStyle = "black";
    context.lineWidth = 1;
    context.beginPath();
    context.moveTo(w/2, h);
    context.lineTo(w/2, 0);
    context.lineTo(w/2+6, 10);
    context.moveTo(w/2, 0);
    context.lineTo(w/2-6, 10);

    drawSeparatorsX(context, w, h);
    context.stroke();

    context.beginPath();
    context.moveTo(0, h/2);
    context.lineTo(w, h/2);
    context.lineTo(w-10, h/2+6);
    context.moveTo(w, h/2);
    context.lineTo(w-10, h/2-6);

    drawSeparatorsY(context, w, h);
    context.stroke();

}

function drawSeparatorsX(context, w, h) {
    var t=w/2;
    for (var j=0; j<marks; j++){
        t+=pixelsPerUnit;
        context.moveTo(t, h/2+3);
        context.lineTo(t, h/2-3)
    }
    t=w/2;
    for (var j=0; j<marks; j++){
        t-=pixelsPerUnit;
        context.moveTo(t, h/2+3);
        context.lineTo(t, h/2-3)
    }
}

function drawSeparatorsY(context, w, h) {
    var t=h/2;
    for (var j=0; j<marks; j++){
        t+=pixelsPerUnit;
        context.moveTo(w/2+3, t);
        context.lineTo(w/2-3, t);
    }
    t=h/2;
    for (var j=0; j<marks; j++){
        t-=pixelsPerUnit;
        context.moveTo(w/2+3, t);
        context.lineTo(w/2-3, t);
    }
}

function drawHitArea(r) {
    console.log("Drawing the area, r=" + r);
    var canvas = document.getElementById("areaCanvas");
    var context = canvas.getContext('2d');

    var h = canvas.height;
    var w = canvas.width;

    context.fillStyle = "#869cff";
    context.strokeStyle = context.fillStyle;

    context.clearRect(0, 0, w, h);

    context.beginPath();
    context.arc(w/2,h/2,r/2*pixelsPerUnit,0,Math.PI/2);
    context.lineTo(w/2, h/2 + r*pixelsPerUnit);
    context.lineTo(w/2-r/2*pixelsPerUnit, h/2 + r*pixelsPerUnit);
    context.lineTo(w/2-r/2*pixelsPerUnit, h/2);
    context.lineTo(w/2, h/2);
    context.lineTo(w/2, h/2 - r*pixelsPerUnit);
    context.lineTo(w/2 + r/2*pixelsPerUnit, h/2);
    context.fill();
}


function drawPoint(x, y, inside)
{
    console.log("Drawing a point - " + x*1 + " " + y*1 + " " + inside);
    var canvas = document.getElementById("pointCanvas");
    var context = canvas.getContext('2d');

    context.strokeStyle = context.fillStyle = inside ? "#93FF3C" : "#FF552F";

    context.beginPath();
    context.arc(canvas.width/2+x*pixelsPerUnit,canvas.height/2-y*pixelsPerUnit,3,0,Math.PI*2, true);
    context.fill();
}

function drawPermanentPoint(x, y)
{
    console.log("Drawing a permanent point - " + x*1 + " " + y*1);
    var canvas = document.getElementById("permanentPointCanvas");
    var context = canvas.getContext('2d');

    context.strokeStyle = context.fillStyle = "#000000";
    context.globalAlpha=0.1;

    context.beginPath();
    context.arc(canvas.width/2+x*pixelsPerUnit,canvas.height/2-y*pixelsPerUnit,3,0,Math.PI*2, true);
    context.fill();
}

function clearPoints() {
    var canvas = document.getElementById("pointCanvas");
    var context = canvas.getContext('2d');

    context.clearRect(0, 0, canvas.width, canvas.height);
}

