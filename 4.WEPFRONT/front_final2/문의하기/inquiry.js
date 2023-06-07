function changeBtnName()  {
    const btnElement = document.getElementById('btn');
    btnElement.innerText = '완료';
  }

function memberJoinCheck() {
	/* 폼 이름 변수 지정, action 경로 지정 */
	var f = userForm;
	f.action ='memberJoinProcess.jsp';	
	
	if(f.userName.value.trim() == ""){
		alert('이름을 입력하세요');
		f.userName.focus();
		return;
	}	
	
	/* 아이디 검사 */
	if(f.userId.value.trim() == ""){
		//db에서 중복검사도 해야됨
		alert('아이디를 입력하세요');
		f.userId.focus();
		return;
	}
	
	/* 패스워드 검사 */
	if(f.userPw.value.trim() == ""){
		alert('패스워드를 입력하세요');
		f.userPw.focus();
		return;
	}
	if(f.userPw.value != f.userPwCheck.value){
		alert('패스워드확인 오류입니다.');
		f.userPwCheck.value="";
		f.userPwCheck.focus();
		return;
	}
	
	/* 성별 검사 */
	var cnt = 0;
	for(var i=0; i<f.userGender.length; i++){
		if(f.userGender[i].checked){cnt++;}
	}
	if(cnt == 0){
		alert('성별을 선택하세요');
		f.userGender[0].focus();
		return;
	}
	
	/* 이메일 검사 */
	if(f.userEmail.value.trim() == ""){
		alert('이메일을 입력하세요');
		f.userEmail.focus();
		return;
	}
	
	/* 전화번호 검사 */
	if(f.userPhone.value.trim() == ""){
		alert('전화번호를 입력하세요');
		f.userPhone.focus();
		return;
	}
	
	/* 관심과목 검사 */
	cnt = 0;
	for(var i=0; i<f.userSubject.length; i++){
		if(f.userSubject[i].checked){cnt++;}
	}	
	if(cnt==0){
		alert('관심과목을 선택하세요');
		f.userSubject[0].focus();
		return;
	}	
	
	/* 서버로 보내기 */
	f.submit();	
	
}