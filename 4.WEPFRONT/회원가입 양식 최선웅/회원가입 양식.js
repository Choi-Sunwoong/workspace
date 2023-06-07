function joinform_check() {
     var uid = document.getElementById("uid");
     var regid = /^[a-z0-9]{6,14}$/;
     var pw = document.getElementById("pw");
     var pw2 = document.getElementById("pw2");
     var uname = document.getElementById("uname");
     var regname = /^[가-힣]{2,6}$/;
     var women = document.getElementById("women");
     var man = document.getElementById("man");
     var phone = document.getElementById("phone");
     var reg =  /^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})-?[0-9]{3,4}-?[0-9]{4}$/; 
     var email_id = document.getElementById("email_id");
   

//1. 아이디 : 이벤트 (값이 변했을 때) 
//- 영어 소문자로 시작하고, 영어 대/소문자, 숫자, - , _ 로만 이루어진 6~14 글자 사이 문자열인지 검사
//- 형식이 일치할 경우, 입력창의 배경색을 springgreen 으로 변경
//- 형식이 일치하지 않은 경우 입력창의 배경색을 red, 글자색을 white 로 변경


if (!regid.test(uid.value)) { 
     uid.style.backgroundColor = "red";
     uid.style.color = "white";
     return false; 
   } else {
     uid.style.backgroundColor = "springgreen";
   }
   
 


   if (pw2.value !== pw.value) {
     pw.innerText = "비밀번호 불일치";
     pw.style.color = 'red';
     pw2.focus();
     return false;
   } else {
     pw.innerText = '비밀번호 일치';
     pw.style.color = 'green';
   }
   
   if(!regname.test(uname.value)){
     uname.innerText = "한글만 입력하세요"
     uname.style.color = 'red';
     return false;
 } else {
     uname.innerText = "정상입력"
     uname.style.color = 'green'
 }
 

     if (!women.checked && !man.checked) { //둘다 미체크시
       alert("성별을 선택해 주세요.");
       women.focus();
       return false;
     }

  
   
     if (!reg.test(phone.value)) {
       alert("전화번호의 형식이 올바르지 않습니다.");
       phone.focus();
       return false;
     }
   

     if (email_id.value == "") {
       alert("이메일 주소를 입력하세요.");
       email_id.focus();
       return false;
     }

     
     //입력 값 전송
 document.join_form.submit(); //유효성 검사의 포인트   
   


}