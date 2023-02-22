// 한 줄 주석
/* 범위 주석 */

// js파일은 <script> 태그 내부라고 생각하면 됨


function btnClick2() {
    alert("external 버튼이 클릭됨");
}

function changeColor1() {
   document.getElementById("box").style.backgroundColor = "red";
}

function changeColor2() {
    document.getElementById("box").style.backgroundColor = "yellow";
 }

 document.getElementById("button1").style.backgroundColor ="gray";
 document.getElementById("button2").style.backgroundColor ="gray";
 
 
 document.getElementById("button1").onclick = function(){
             this.style.backgroundColor ="black";
             document.getElementById("button2").style.backgroundColor ="gray";
         };
 
 document.getElementById("button2").onclick = function(){
             this.style.backgroundColor ="black";
             document.getElementById("button1").style.backgroundColor ="gray";
         };