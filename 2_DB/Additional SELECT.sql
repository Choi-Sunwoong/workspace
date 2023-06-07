1.영어영문학과(학과코드 002) 학생들의 학번과 이름, 입학 년도를 입학 년도가 빠른 순으로 표시하는 SQL
문장을 작성하시오.( 단, 헤더는 "학번","이름","입학년도"가 표시되도록 한다.)

SELECT DEPARTMENT_NO AS "학번",STUDENT_NAME AS "이름",ENTRANCE_DATE AS "입학년도" 
FROM TB_STUDENT 
ORDER BY ENTRANCE_DATE;

2. 춘 기술대하교의 교수 중 이름이 세 글자가 아닌 교수가 한 명 있다고 한다. 그 교수의 
이름과 주민번호를 화면에 출력하는 SQL 문장을 작성해 보자. (*이때 올바르게 작성한 SQL
문장의 결과 값이 예상과 다르게 나올 수 있다. 원인이 무엇일지 생각해볼 것)

SELECT PROFESSOR_NAME,PROFESSOR_SSN
FROM TB_PROFESSOR 
WHERE PROFESSOR_NAME NOT LIKE '___' ;

3. 춘 기술대학교의 남자 교수들의 이름과 나이를 출력하는 SQL 문장을 작성하시오. 단 이때 나이가 적은 사람에서
많은 사람 순서로 화면에 출력되도록 만드시오.( 단,교수 중 2000년 이후 출생자는 없으며 출력 헤더는 "교수이름","나이"로 한다.
나이는 '만'으로 계산하다.)

SELECT PROFESSOR_NAME AS "교수이름",PROFESSOR_SSN AS "나이"
FROM TB_PROFESSOR 


SELECT FLOOR(MONTHS_BETWEEN(sysdate, TO_DATE(birth_ymd,'yyyymmdd'))/12)
FROM
(
SELECT PROFESSOR_SSN,
       CASE WHEN SUBSTR(PROFESSOR_SSN,7,1) IN ('1','2','5','6') THEN '19'
            WHEN SUBSTR(PROFESSOR_SSN,7,1) IN ('3','4','7','8') THEN '20'
            WHEN SUBSTR(PROFESSOR_SSN,7,1) IN ('9','0') THEN '18' END
       || SUBSTR(PROFESSOR_SSN,1,6) birth_ymd
FROM dual
)


4. 교수들의 이름 중 성을 제외한 이름만 출력하는  SQL 문장을 작성하시오. 출력 헤더는 "이름"이 찍히도록 한다.
(성이 2자인 경우는 교수는 없다고 가정하시오)

SELECT SUBSTR( PROFESSOR_NAME, 2) AS "이름"
FROM TB_PROFESSOR ;





5. 춘 기술대학교의 재수생 입학자를 구하려고 한다. 어떻게 찾아낼 것인가? 이때,
19살에 입학하면 재수를 하지 않은 것으로 간주한다.

SELECT STUDENT_NO,STUDENT_NAME
FROM TB_STUDENT

6. 2020년 크리스마스는 무슨 요일인가?


7. 



8. 춘 기술대학교의 2000 년도 이후 입학자들은 학번이 A로 시작하게 되어있다. 2000 년도 
이전 학번을 받은 학생들의 학번과 이름을 보여주는 SQL 문장을 작성하시오.





9.학번이 A517178 인 한아름 학생의 학점 총 평점을 구하는 SQL 문을 작성하시오. 단, 이떄 출력 화면의 헤더는 "평전"이라고
찍히게 하고, 점수는 반올림하여 소수점 이하 한 자리까지만 표시한다.



10. 학과별 학생수를 구하여 "학과번호", "학생수(명)" 의 형태로 헤더를 만들어 결과값이 출력되도록 하시오.


11.지도 교수를 배정받지 못한 학생의 수는 몇 명 정도 되는 알아내는 SQL 문을 작성하시오.



12. 학번이 A112113인 김고운 학생의 년도 별 평점을 구하는 SQL 문을 작성하시오. 단, 이때 출력 화면의 
헤더는 "년도", "년도 별 평점" 이라고 찍히게 하고, 점수는 반올림하여 소수점 이하 한 자리까지만 표시한다.




13. 학과 별 휴학생 수를 파악하고자 한다. 학과 번호와 휴학생 수를 표시하는 SQL 문장을 작성하시오.





14. 춘 대학교에 다니는 동명이인 학생들의 이름을 찾고자 한다. 어떤 SQL 문장을 사용하면 가능하겠는가?




15. 학번이 A112113 인 김고운 학생의 년도, 학기 별 평점과 년도 별 평점과 년도 별 누적 평점, 총 평점을 구하는 SQL 문을
작성하시오.( 단, 평점은 소수점 1자리까지만 반올림하여 표시한다.)