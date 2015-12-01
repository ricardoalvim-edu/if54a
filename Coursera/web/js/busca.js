function showHint(str) {
    if (str.length == 0) {                    
        document.getElementById("searchArea").innerHTML = "";
        return;
    } else {
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                document.getElementById("searchArea").innerHTML = xmlhttp.responseText;
            }
        };
        xmlhttp.open("GET", "pesquisar.jsp?q=" + str, true);
        xmlhttp.send();
    }
}

