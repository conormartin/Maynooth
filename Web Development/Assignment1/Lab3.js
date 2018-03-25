var table = document.getElementById("tableData");
var csvTextbox = document.querySelector("#csvTextArea");
var inputValue = document.querySelector("input");
var unsubmitted = document.querySelector("span");

var rows = table.rows;

function calculateAverage() {
    for(var i=1; i<rows.length; i++) {
        var cells = rows[i].cells;
        var sum = 0;
        var counter=0;
        for(var j=2; j<cells.length-1; j++, counter++) {
            var cell = Number(cells[j].innerHTML);
            if(Number.isInteger(cell) && cell>=0 && cell<=100){
                sum += cell;
                rows[i].cells[j].style.backgroundColor = "white";
            }
            else {
                rows[i].cells[j].innerHTML = "-";
                rows[i].cells[j].style.backgroundColor = "yellow";
            }
        }
        var average = parseInt(sum/counter);
        rows[i].cells[7].innerHTML = average + " %";
        
        if(average < 40){
            rows[i].cells[7].style.backgroundColor = "red";
            rows[i].cells[7].style.color = "white";
        }
        else {
            rows[i].cells[7].style.backgroundColor = "white";
            rows[i].cells[7].style.color = "black";
        }
    }
}

function totalUnsubmitted() {
    var total = 0;
    for(var i=1; i<rows.length; i++) {
        for(var j=2; j<rows[i].cells.length-1; j++) {
            if(rows[i].cells[j].innerHTML === "-") {
                total++;
            }
        }
    }
    unsubmitted.textContent = total;
}

var csvTextbox = document.querySelector("#csvTextArea");


function convertToCsv() {
    var csv = "";
    for(var i=0; i<rows.length; i++) {
        for(var j=0; j<rows[i].cells.length; j++) {
            csv += rows[i].cells[j].innerHTML + ", ";
        }
    }
    csvTextbox.textContent = csv;
}