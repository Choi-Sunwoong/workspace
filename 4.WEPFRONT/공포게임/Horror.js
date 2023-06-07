const ho = document.getElementById("ho");

    let count = 0; 
function game() {

    if (count == 0) {
        ho.style.backgroundColor = "red";
        ho.style.color = "white";
        ho.innerText = "사랑해"
        count++;

    } else if(count < 10) {
        ho.style.backgroundColor = "red";
        ho.style.color = "white";
        ho.innerText += "사랑해"
        count++;

    } else {
        ho.style.backgroundColor = "black";
        ho.style.color = "white";
        ho.innerText = "그만해!!!"
        ho.style.textAlign = "center";
        ho.style.lineHeight = "40px";
    }
}