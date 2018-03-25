var table = document.querySelector("table");
var rows = table.rows;

calculateAverage = function () {
    for(var i=1; i<rows.length; i++) {
        var cells = rows[i].cells;
        var sum = 0;
        var counter=0;
        for(var j=2; j<cells.length-1; j++, counter++) {
            var cell = Number(cells[j].innerHTML);
            if(Number.isInteger(cell) && cell>=0 && cell<=100){
                sum += cell;
            }
            else {
                cells[j].innerHTML = "-";
            }
        }
        var average = parseInt(sum/counter);
        cells[rows[0].cells.length-1].innerHTML = average + " %";
        
        if(average < 40){
            cells[rows[0].cells.length-1].style.backgroundColor = "red";
            cells[rows[0].cells.length-1].style.color = "white";
        }
        else {
            cells[rows[0].cells.length-1].style.backgroundColor = "white";
            cells[rows[0].cells.length-1].style.color = "black";
        }
    }
}

addRow = function () {
    // Insert a row in the table at the last row
    var newRow = table.insertRow(rows.length);
    newRow.setAttribute("class", "normal");
    // Insert a cell in the row at index 0
    for(i=0; i<rows[0].cells.length; i++){
        var newCell = newRow.insertCell(i);
        // Append a text node to the cell
        var newText = document.createTextNode('-');
        newCell.appendChild(newText);
        newCell.setAttribute('contentEditable','true');
        newCell.setAttribute('onkeyup', 'calculateAverage()');
        newCell.setAttribute('class', 'normal');
        newCell.setAttribute("id", "number");
        if(newCell.cellIndex === 0) {
            newCell.setAttribute('onclick', 'highlightRow(this)');
        }
        if(newCell.cellIndex === 0 || newCell.cellIndex === 1){
            newCell.style.textAlign = "left";
        }
    }
}

addCol = function () {
    // Insert a cell in the row at index 0
    for(i=0; i<rows.length; i++){
        var newCol = rows[i].insertCell(rows[i].cells.length-1);
        // Append a text node to the cell
        var newText = document.createTextNode('-');
        if(rows[i].innerHTML == rows[0].innerHTML) {
            newCol.setAttribute('class', 'normal');
            newText = document.createTextNode('Assignment ' + Number(rows[0].cells.length-3));
            newCol.appendChild(newText);
            newCol.setAttribute('onclick', 'highlightCol(this)');
        }
        else {
            newCol.appendChild(newText);
            newCol.setAttribute('contentEditable','true');
            newCol.setAttribute('onkeyup', 'calculateAverage()');
            newCol.setAttribute('id', 'number');
            newCol.setAttribute('class', 'normal');
        }
    }
}

saveToCookie = function (days) {
    var tableData = "";
    for(var i=0; i<rows.length; i++) {
        for(var j=0; j<rows[i].cells.length; j++) {
            tableData += rows[i].cells[j].innerHTML + ", ";
        }
    }
    var date = new Date();
    date.setTime(date.getTime() + (days*24*60*60*1000));
    var expires = "expires="+ date.toUTCString();
    var name = "tableCookie";
    var numRows = rows.length;
    var numCols = rows[0].cells.length;
    document.cookie = name + "=," + numRows + "," + numCols + "," + tableData + ";" + expires + ";path=/";
    console.log(document.cookie);
}

loadCookie = function() {
    var tableData = document.cookie;
    var csvArray = tableData.split(',');

    for (var i=rows.length; i<csvArray[1]; i++) {
        addRow();
    }
    for (var i=rows[0].cells.length; i<csvArray[2]; i++) {
        addCol();
    }
    var counter = 3;

    for(var i=0; i<rows.length; i++) {
        for(var j=0; j<rows[i].cells.length; j++, counter+i) {
            rows[i].cells[j].innerHTML = csvArray[counter];
            counter++;
        }
    }
}

highlightRow = function(td) {
    var rowNumber = td.parentNode.rowIndex;
    rows[rowNumber].getAttribute("class");
    if(rows[rowNumber].getAttribute("class") == "normal") {
        rows[rowNumber].setAttribute("class", "highlight");
    }
    else{
        rows[rowNumber].setAttribute("class", "normal");
    }
}

highlightCol = function(th) {
    var colNumber = th.cellIndex;
    for(var i=1; i<rows.length; i++){
        if(rows[i].cells[colNumber].getAttribute("class") == "normal") {
            rows[i].cells[colNumber].setAttribute("class", "highlight");
        }
        else{
            rows[i].cells[colNumber].setAttribute("class", "normal");
        }
    }
}

deleteRow = function() {
    for(var i=0; i<rows.length; i++) {
        if(rows[i].getAttribute("class") == "highlight"){
            table.deleteRow(i);
        }
    }
}

deleteCol = function() {
    var rowLength = rows[0].cells.length;
    for(var i=0; i<rows.length; i++) {
        for(var j=0; j<rows[i].cells.length; j++) {
            if(rows[i].cells[j].getAttribute("class") === "highlight"){
                rows[i].deleteCell(j);
                if(rows[0].cells.length === rowLength){
                    rows[0].deleteCell(j);
                }
            }
        }
    }
}

retrieveData = function() {

}