var id =document.getElementById("id");
var pw = document.getElementById("pw");
var pw2 = document.getElementById("pw2");
var name1 = document.getElementById("name1");
var phone = document.getElementById("phone");
var idnum1 = document.getElementById("idnum1");
var idnum2 = document.getElementById("idnum2");
var email = document.getElementById("email");

var Arr = new Array(6).fill(flase);

//아이디
id.addEventListener("keyup", function() {


    const regEx1 = /^[a-z0-9]{5,}$/;

    const resultid = document.getElementById("resultid");

    if(regEx1.test(this.value)) {
        resultid.innerText = "사용가능"

        resultid.classList.add("confirm");
        resultid.classList.remove("error");
        Arr[0] = true;
        
    } else {
        resultid.innerText = "사용불가능"
        resultid.classList.add("error");
        resultid.classList.remove("confirm");
        Arr[0] = flase;
     
    }
})

//비밀번호
pw.addEventListener("keyup", function() {

    const regEx2 = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$/;;

    const resultpw = document.getElementById("resultpw");

   
    if(regEx2.test(this.value)) {
        resultpw.innerText = "사용가능"

        resultpw.classList.add("confirm");
        resultpw.classList.remove("error");
        Arr[1] = true;

    } else {
        resultpw.innerText = "사용불가능"
        resultpw.classList.add("error");
        resultpw.classList.remove("confirm");
        Arr[1] = flase;
    }
})

//비밀번호 확인
pw2.addEventListener("keyup", function() {

    const resultpw2 = document.getElementById("resultpw2");
   
    if(pw.value == pw2.value) {
        resultpw2.innerText = "사용가능."

        resultpw2.classList.add("confirm");
        resultpw2.classList.remove("error");
        Arr[2] = true;

        
    } else {
        resultpw2.innerText = "사용불가능."
        resultpw2.classList.add("error");
        resultpw2.classList.remove("confirm");
        Arr[2] = flase;
    }
})



//이름
name1.addEventListener("keyup", function() {

    // 한글 2글자 이상 6자 이하 문자열
    const regEx3 = /^[가-힣]{2,6}$/;

    const resultname = document.getElementById("resultname");

   
    if(regEx3.test(this.value)) {
        resultname.innerText = "t사용가능."

        resultname.classList.add("confirm");
        resultname.classList.remove("error");
        Arr[3] = true;
        
    } else {
        resultname.innerText = "사용불가능."
        resultname.classList.add("error");
        resultname.classList.remove("confirm");
        Arr[3] = flase;
    }
})




// 주민번호
idnum1.addEventListener("keyup", function() {


    const regEx4 = /\d{2}([0]\d|[1][0-2])([0][1-9]|[1-2]\d|[3][0-1])/;

    const resultidnum = document.getElementById("resultidum");



    if(regEx4.test(this.value)) {
        resultidnum.innerText = "사용가능."

        resultidnum.classList.add("confirm");
        resultidnum.classList.remove("error");
        
    } else {
        resultidnum.innerText = "사용불가능."
        resultidnum.classList.add("error");
        resultidnum.classList.remove("confirm");
    }
})

idnum2.addEventListener("keyup", function() {


    const regEx5 = /[1-4]\d{6}/;

    const resultidnum = document.getElementById("resultdnum");


    if(regEx5.test(this.value)) {
        resultidnum.innerText = "사용가능."

        resultidnum.classList.add("confirm");
        resultidnum.classList.remove("error");
        Arr[4] = true;
        
    } else {
        resultidnum.innerText = "사용불가능."
        resultidnum.classList.add("error");
        resultidnum.classList.remove("confirm");
        Arr[4] = flase;
    }
})

//이메일
email.addEventListener("keyup", function() {


    const regEx6 = /[@]([a-z]+\.)+(com)/;

    const resultemail = document.getElementById("resultemail");


    if(regEx6.test(this.value)) {
        resultemail.innerText = "사용가능."

        resultemail.classList.add("confirmem");
        resultemail.classList.remove("error");
        Arr[5] = true;
        
    } else {
        resultemail.innerText = "사용불가능."
        resultemail.classList.add("error");
        resultemail.classList.remove("confirm");
        Arr[5] = flase;
    }
})


//휴대폰
phone.addEventListener("keyup", function() {


    const regEx7 = /^01([0])-?([0-9]{3,4})-?([0-9]{4})$/;

    const resultphone = document.getElementById("resultphone");


    if(regEx7.test(this.value)) {
        resultphone.innerText = "사용가능."

        resultphone.classList.add("confirmem");
        resultphone.classList.remove("error");
        Arr[6] = true;
        
    } else {
        resultphone.innerText = "사용불가능."
        resultphone.classList.add("error");
        resultphone.classList.remove("confirm");
        Arr[6] = flase;
    }
})

var validAll = true;
for(var i = 0; i < inval_Arr.length; i++){
    
    if(inval_Arr[i] == false){
        validAll = false;
    }
}

document.getElementById("submit").addEventListener("click", function() {

if(validAll) {
   alert("사용 가능한 계정입니다!")
}else {
    alert("유효성 검사가 완료되지 않았습니다.")
}

})