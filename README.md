# π»JSP κ²μν
**MVC MODEL 2**λ‘ κ΅¬νν **JSP/Servlet κ²μν**μλλ€.

<br>

## π κ΅¬ν κΈ°λ₯

 - λ‘κ·ΈμΈ
 - λ‘κ·Έμμ
 - νμκ°μ
 - νμμ λ³΄ μμ  λ° μ­μ 
 - κ²μκΈ μμ± λ° μ‘°ν
 - κ²μκΈ μμ  λ° μ­μ 
 - νμ΄μ§ μ²λ¦¬
 - νμΌ μ²¨λΆ

<br>

## π κ°λ° νκ²½ λ° κΈ°μ 

 - Window 10 64bit
 - eclipse
 - DBeaver
 - apache-tomcat v9.0
 - JSP/Servlet
 - Oracle 11g
 - EL / JSTL
 - Bootstrap 5.1
 
<br>

## π κ²μν κ΅¬μ±

κ²μνμ ν¬κ² νμ/κ²μκΈ νλ©΄μΌλ‘ λλ©λλ€.

 - νμ : νμ κ°μμ νμ¬ λ‘κ·ΈμΈμ ν  μ μμ΅λλ€. νμ κ°μ ν λ‘κ·ΈμΈμ νλ©΄ νμ μ λ³΄ μ‘°ν νμ΄μ§μμ νμ μ λ³΄λ₯Ό μμ νκ±°λ νμ μ λ³΄λ₯Ό μ­μ ν  μ μμ΅λλ€.
 - κ²μκΈ : λΉλ‘κ·ΈμΈ μνμμλ κ²μκΈμ μ‘°νν  μ μμ΅λλ€. λ‘κ·ΈμΈ μνμμλ κ²μκΈμ μ‘°ννκ³ , λ³ΈμΈμ΄ μμ±ν κΈμ κ²½μ° κ²μκΈμ μμ νκ±°λ μ­μ ν  μ μμ΅λλ€.
 
 
 <br>

## π μΉ νλ‘μ νΈ κ΅¬μ‘°
![μΉνλ‘μ νΈ](https://user-images.githubusercontent.com/92250627/150120415-ace249a4-7da2-4513-9b1b-5f787e0725be.png)

<br>

## π UML κ΅¬μ‘°
![JSP UML](https://user-images.githubusercontent.com/92250627/150120481-b9d58c1c-7dfd-4210-802e-9ce5993987c0.gif)

 - νμ κ΄λ ¨ ν΄λμ€ λ€μ΄μ΄κ·Έλ¨
 - κ²μκΈ κ΄λ ¨ ν΄λμ€ λ€μ΄μ΄κ·Έλ¨
<br>

## π JSP/Servlet

<br>

> πκ³΅ν΅λΆλΆ
<img width="140" alt="κ³΅ν΅λΆλΆ" src="https://user-images.githubusercontent.com/92250627/150121893-322191e2-230d-4774-bff2-0db64a298cbc.PNG">

<br>

 - Action : execute() λ©μλλ₯Ό μ€ννλ©° ActionForward κ°μ²΄λ₯Ό λ°ν
 - ActionForward : forward/redirect μ€μ  λ° κ²½λ‘ μ€μ 
 - DBConnection : DBμ μ κ·ΌνκΈ° μν κ°μ²΄
 - EncodingFilter : νκΈ μΈμ½λ©μ μν Filter
 
<br>

> πνμλΆλΆ
<img width="175" alt="νμλΆλΆ" src="https://user-images.githubusercontent.com/92250627/150121774-247c3285-92b4-4894-89ea-47e33aa99dee.PNG">
<img width="144" alt="νμλΆλΆ2" src="https://user-images.githubusercontent.com/92250627/150121796-883ede90-5ef0-4d06-9d05-7f359ddf1932.PNG">

<br>

 - Model
	 - MemberBean : νμ λ°μ΄ν° κ΄λ ¨ getter/setter κ΅¬ν
	 - MemberDAO : νμ λ°μ΄ν°μ κ΄λ ¨λ λ°μ΄ν° μ²λ¦¬ λ΄λΉ
 - Properties
	 - member.properties : νμ κ΄λ ¨ property
 - Action
	 - MeberDeleteAction : νμ μ­μ  κ΅¬ν
	 - MeberDetailAction : νμ μ λ³΄ μμΈ λ³΄κΈ° κ΅¬ν
	 - MeberFormChangeAction : λ·° νμ΄μ§ μ ν κ΅¬ν
	 - MeberLoginAction : λ‘κ·ΈμΈ κ΅¬ν
	 - MeberLogoutAction : λ‘κ·Έμμ κ΅¬ν
	 - MeberModifyAction : νμ μ λ³΄ μμ  κ΅¬ν
	 - MeberSignUpAction : νμ κ°μ κ΅¬ν
 - Controller
	 - MemberController : νμ κ΄λ ¨ μ»¨νΈλ‘€λ¬
	 
<br>

> πκ²μκΈλΆλΆ
<img width="188" alt="κ²μκΈλΆλΆ" src="https://user-images.githubusercontent.com/92250627/150121826-fe023683-d12a-43f1-9bd8-54121c32ee02.PNG">
<img width="151" alt="κ²μκΈλΆλΆ2" src="https://user-images.githubusercontent.com/92250627/150121835-22f30441-ec5f-406b-8a2a-fa00e172ef6a.PNG">

<br>

 - Model
	 - BoardBean : κ²μκΈ λ°μ΄ν° κ΄λ ¨ getter/setter κ΅¬ν
	 - BoardDAO : κ²μκΈ λ°μ΄ν°μ κ΄λ ¨λ λ°μ΄ν° μ²λ¦¬ λ΄λΉ
 - Properties
	 - board.properties : κ²μκΈ κ΄λ ¨ property
 - Action
	 - BoardDeleteAction : κ²μκΈ μ­μ  κ΅¬ν
	 - BoardDetailAction : κ²μκΈ μμΈλ³΄κΈ° κ΅¬ν
	 - BoardDownloadAction : μ²¨λΆνμΌ λ€μ΄λ‘λ κ΅¬ν
	 - BoardFormChangeAction : λ·° νμ΄μ§ μ ν κ΅¬ν
	 - BoardListAction : κ²μκΈ λͺ©λ‘ νμ κ΅¬ν
	 - BoardUpdateAction : κ²μκΈ μμ  κ΅¬ν
	 - BoardUpdateFormAction : κ²μκΈ μμ  νλ©΄μΌλ‘ μ ν κ΅¬ν
	 - BoardWriteAction : κ²μκΈ μμ± κ΅¬ν
 - Controller
	 - BoardController : κ²μκΈ κ΄λ ¨ μ»¨νΈλ‘€λ¬
	 
<br>

> πλ·° νμ΄μ§
<img width="161" alt="λ·°νμ΄μ§" src="https://user-images.githubusercontent.com/92250627/150121872-f0879ed9-93bd-4eab-8869-116d651e7412.PNG">

<br>

 - main : λ©μΈ νμ΄μ§ κ΅¬ν
 - header : νλ©΄ μλ¨ κ΅¬ν
 - firstView : μ΅μ΄ μ μ μ νμλλ νλ©΄ κ΅¬ν

νλ©΄μ main νμ΄μ§μμ headerμ contentλ₯Ό 'include'νμ¬ κ΅¬νν  μ μλλ‘ νμκ³ , μ λ¬λλ contentκ° μμ κ²½μ° κΈ°λ³Έμ μΌλ‘ 'firstView'λ₯Ό μΆλ ₯ν  μ μλλ‘ νλ©΄μ λΆλ¦¬νμ¬ κ΅¬ννμμ΅λλ€.

- board
	- BoardDetailForm : κ²μκΈ μμΈ λ³΄κΈ° νλ©΄
	- BoardListForm : κ²μκΈ λͺ©λ‘ νλ©΄
	- BoardUpdateForm : κ²μκΈ μμ  νλ©΄
	- BoardWriteForm : κ²μκΈ μμ± νλ©΄
- member
	- LoginForm : λ‘κ·ΈμΈ νλ©΄
	- MemberDetail : νμ μ λ³΄ μμΈλ³΄κΈ° νλ©΄
	- PwdCheckForm : λΉλ°λ²νΈ νμΈ νλ©΄
	- ResultForm : κ²°κ³Ό νλ©΄
	- SignUpForm : νμκ°μ νλ©΄
	
<br>

## π νμ΄λΈ/μνμ€

### πνμ΄λΈ κ΅¬μ‘°
<img width="20%" alt="νμ΄λΈ κ΅¬μ‘° 1" src="https://user-images.githubusercontent.com/92250627/150120680-fecc72c2-10e5-4ef1-a15f-014c7d6a912a.PNG">
  - MEMBERμ BOARDλ‘ κ΅¬μ±

<br>

### πMEMBER
 
- λ©€λ² νμ΄λΈ κ΅¬μ‘°
 <img width="50%" alt="λ©€λ²νμ΄λΈ 1" src="https://user-images.githubusercontent.com/92250627/150121000-9862f2bf-7f26-4992-a1ab-a80a58737348.PNG">
 <img width="20%" alt="νμ νμ΄λΈ κ΅¬μ‘°" src="https://user-images.githubusercontent.com/92250627/150121223-457937a9-3fc5-4ad8-bff5-20b1fab62cd1.PNG">

<br>

- λ©€λ² νμ΄λΈ DDL 

<br>

<img width="50%" alt="λ©€λ² ddl" src="https://user-images.githubusercontent.com/92250627/150121040-9519ee24-d243-402e-b812-a384d4dfb5f5.PNG">
  
<br>

### πBOARD


- κ²μκΈ νμ΄λΈ κ΅¬μ‘° 

<br>

<img width="50%" alt="κ²μκΈνμ΄λΈ 1" src="https://user-images.githubusercontent.com/92250627/150121460-6903d099-9d24-49a9-a9e8-a8c9e0c4bdf4.PNG">
<img width="20%" alt="κ²μκΈνμ΄λΈ 2" src="https://user-images.githubusercontent.com/92250627/150121505-1a1c875e-ae66-4662-927b-d556df3d89e4.PNG">

<br>

- κ²μκΈ νμ΄λΈ DDL 

<br>

<img width="50%" alt="κ²μκΈ νμ΄λΈ ddl" src="https://user-images.githubusercontent.com/92250627/150121533-b0c9fac4-f94e-4eba-9fa3-75558fa7abf3.PNG">

<br>

### πμνμ€

<br> 

κ²μκΈ λ²νΈ μλ μ¦κ°λ₯Ό μν μνμ€ 

<br>

<img width="20%" alt="μνμ€" src="https://user-images.githubusercontent.com/92250627/150121593-c4e4b2cc-9570-438d-89c2-87721f30a9f1.PNG">

<br>

## π λμ νλ©΄

 1. μ°μ»΄ νμ΄μ§ μλλ€. νμκ°μ νλ©΄μΌλ‘ μ΄λν΄λ³΄κ² μ΅λλ€.
<br>
<img width="958" alt="1μ°μ»΄νμ΄μ§" src="https://user-images.githubusercontent.com/92250627/150133242-f635bf18-8864-47de-a893-d3383c4ff4f3.PNG">
 2. νμκ°μ νλ©΄μλλ€.

<br>
<img width="957" alt="2νμκ°μ" src="https://user-images.githubusercontent.com/92250627/150133131-cb0111e0-9881-442f-aac6-28d21e6f8311.PNG">
<br>
 3. λ΄μ©μ μλ ₯νμ§ μκ³  νμκ°μ μλμ κ²½κ³ μ°½μ΄ νμλ©λλ€.
<br>
<img width="959" alt="3νμκ°μκ²½κ³ μ°½" src="https://user-images.githubusercontent.com/92250627/150133132-6f196cfc-8398-4b55-9a2a-3bf574bedbeb.PNG">
<br>
 4. λΉλ°λ²νΈμ κ²½μ° 2λ² μ²΄ν¬νλλ‘ κΈ°λ₯μ κ΅¬ννμ΅λλ€.
<br>
<img width="957" alt="4νμκ°μλΉλ°λ²νΈμ²΄ν¬" src="https://user-images.githubusercontent.com/92250627/150133134-bc5a6516-bbc4-4bcf-a37c-978deb1212b9.PNG">
<br>
 5. νμκ°μ κ²°κ³Όμ°½μλλ€.
<br>
<img width="958" alt="5νμκ°μκ²°κ³Όμ°½" src="https://user-images.githubusercontent.com/92250627/150133135-27ac114a-fc19-40df-98cf-113aa6fe9629.PNG">
<br>
 6. μ΄μ  λ‘κ·ΈμΈ νλ©΄μΌλ‘ μ΄λν΄λ³΄κ² μ΅λλ€.
<br>
<img width="958" alt="6λ‘κ·ΈμΈνλ©΄" src="https://user-images.githubusercontent.com/92250627/150133138-f778ca1e-3d09-49a3-aebc-e6170535f75a.PNG">
<br>
 7. λ‘κ·ΈμΈ μ λ³΄λ₯Ό μ λͺ» μλ ₯νλ©΄ κ²½κ³ μ°½μ΄ νμλ©λλ€.
<br>
<img width="959" alt="7λ‘κ·ΈμΈκ²½κ³ μ°½" src="https://user-images.githubusercontent.com/92250627/150133141-aba3fccd-0f43-4efc-a29a-825da8ecb8d7.PNG">
<br>
 8. λ‘κ·ΈμΈμ νκ³  λλ©΄ μ°μ»΄ νμ΄μ§κ° λ°λλλ€.
<br>
<img width="959" alt="8λ‘κ·ΈμΈνμ°μ»΄νμ΄μ§" src="https://user-images.githubusercontent.com/92250627/150133144-ec4f83c9-c181-4af9-8560-4227eb5602e9.PNG"> 
<br>
 9. νμμ λ³΄ μμΈλ³΄κΈ° νλ©΄μ λλ₯΄λ©΄ λΉλ°λ²νΈ νμΈμ°½μ΄ νμλ©λλ€.
<br>
<img width="956" alt="9λ©λ΄νμμ λ³΄λΉλ°λ²νΈνμΈ" src="https://user-images.githubusercontent.com/92250627/150133149-031c2fce-8619-4053-8c26-18c7881112ab.PNG">
<br>
 10. λΉλ°λ²νΈλ₯Ό μλ§κ² μλ ₯νλ©΄ νμμ λ³΄ μμΈλ³΄κΈ°κ° κ°λ₯ν©λλ€.
<br>
<img width="947" alt="10νμμ λ³΄μμΈλ³΄κΈ°" src="https://user-images.githubusercontent.com/92250627/150133151-903afd94-136f-4791-aefc-e7568839628f.PNG">
<br>
 11. νμμ λ³΄ μμ μ ν΄λ¦­νμ¬ νμμ λ³΄λ₯Ό μμ ν  μ μμ΅λλ€.
<br>
<img width="949" alt="11νμμ λ³΄μμ ν΄λ¦­" src="https://user-images.githubusercontent.com/92250627/150133388-3b2aa4b2-7036-4bc6-8599-223e05d4acda.PNG">
<br>
 12. νμμ λ³΄ μμ  ν νμΈμ ν΄λ¦­νλ©΄ μλμ κ°μ κ²°κ³Ό νμ΄μ§λ₯Ό μ»μ μ μμ΅λλ€.
<br>
<img width="956" alt="12νμμ λ³΄μμ νκ²°κ³Όνμ΄μ§" src="https://user-images.githubusercontent.com/92250627/150133154-be7ab676-4341-4907-a0a5-91aa0078aa9c.PNG">
<br>
 13. νμμ λ³΄ μ­μ λ₯Ό ν΄λ¦­νλ©΄ μλμ κ°μ κ²°κ³Ό νμ΄μ§λ₯Ό μ»μ μ μμ΅λλ€.
<br>
<img width="951" alt="13νμμ λ³΄μ­μ " src="https://user-images.githubusercontent.com/92250627/150133099-27f5ed1c-80a9-4848-bdfa-8ff7d60199dc.PNG">
<br>
 14. κ²μνμΌλ‘ μ΄λνκ² μ΅λλ€.
<br>
<img width="950" alt="15κ²μννλ©΄" src="https://user-images.githubusercontent.com/92250627/150133107-672e4b0d-318b-4888-b9a1-daec00c37a73.PNG">
<br>
 15. λ‘κ·ΈμΈμ νμ§ μμΌλ©΄ 'κΈμ°κΈ°' λ²νΌμ΄ μΆλ ₯λμ§ μμ΅λλ€.
<br>
<img width="950" alt="16κ²μννλ©΄(λΉλ‘κ·ΈμΈ)" src="https://user-images.githubusercontent.com/92250627/150133109-4de3cf03-1b60-4605-a049-c879d68a1869.PNG">
<br>
 16. κΈ μμ± νλ©΄μλλ€.
<br>
<img width="957" alt="17κΈμμ±νλ©΄" src="https://user-images.githubusercontent.com/92250627/150133114-ce4463d3-887a-43d1-8b93-dcab7f8d10ef.PNG">
<br>
 17. κΈμ μμ±νλ©΄ μλμ κ°μ΄ κ²μκΈ λͺ©λ‘μ΄ μλ°μ΄νΈ λ©λλ€.
<br>
<img width="952" alt="19κ²μκΈμΆκ°" src="https://user-images.githubusercontent.com/92250627/150133115-5016cc1e-814c-47df-b876-dc2083307c65.PNG">
<br>
 18. κ²μκΈ μμΈλ³΄κΈ° νλ©΄μλλ€.
<br>
<img width="957" alt="22κ²μκΈμμΈλ³΄κΈ°νλ©΄" src="https://user-images.githubusercontent.com/92250627/150133123-b22b5e42-b262-42c7-a89f-ea7ae52d72c4.PNG">
<br>
 19. κ²μκΈ μμ μ λλ₯΄κ³  μ²¨λΆνμΌμ μΆκ°ν΄λ³΄κ² μ΅λλ€.
<br>
<img width="959" alt="20κ²μκΈμμ " src="https://user-images.githubusercontent.com/92250627/150133118-3b59b00a-fb90-48e1-a1e1-0e0703b665bb.PNG">
<br>
<img width="956" alt="21μ²¨λΆνμΌμΆκ°" src="https://user-images.githubusercontent.com/92250627/150133119-868b6dbb-1e01-421c-b66c-3854ab02e44c.PNG">
<br>
 20. κ²μκΈ μμΈλ³΄κΈ°λ₯Ό νμ¬ μΆκ°ν μ²¨λΆνμΌμ λ€μ΄λ°μ μ μμ΅λλ€.
<br>
<img width="956" alt="22μ²¨λΆνμΌλ€μ΄λ‘λ" src="https://user-images.githubusercontent.com/92250627/150133125-61ffa872-28a2-455b-a40e-9010571ee387.PNG">
<br>
 21. κ²μκΈμ μ­μ λ₯Ό λλ₯΄λ©΄ κ²μκΈ μ­μ  νμΈμ°½μ΄ μΆλ ₯λ©λλ€.
<br>
<img width="959" alt="24κ²μκΈμ­μ νμΈμ°½" src="https://user-images.githubusercontent.com/92250627/150133126-42b0d1e0-ec99-46f0-9550-4064d7885456.PNG">
<br>
 22. νμΈμ λλ₯΄λ©΄ μλμ κ°μ΄ κ²μν λͺ©λ‘μμ ν΄λΉ κΈμ΄ μ­μ λ κ²μ λ³Ό μ μμ΅λλ€.
<br>
<img width="949" alt="25κ²μκΈμ­μ νμΈ" src="https://user-images.githubusercontent.com/92250627/150133128-ff7c2690-45c1-4870-8046-75898fff8dc4.PNG">

## π μμΈν μ€λͺ
κ²μν κ΅¬νμ λν μμΈν μ€λͺμ λΈλ‘κ·Έμ μμΈνκ² μ λ¦¬ν΄λμ΅λλ€.
ν΄λΉ μΉμ¬μ΄νΈκ° μ΄λ»κ² λμνλμ§ μ΄ν΄νκ³  μΆμ λΆλ€μ
λΈλ‘κ·Έ λ§ν¬λ₯Ό ν΅ν΄ λΈλ‘κ·Έμμ λ΄μ©μ νμΈν΄μ£ΌμΈμ!
[***λΈλ‘κ·Έ μ΄λνκΈ°***](https://determination.tistory.com/entry/JSP-%EA%B2%8C%EC%8B%9C%ED%8C%90-Model-2-JSPServlet-%EA%B2%8C%EC%8B%9C%ED%8C%90-%EB%A7%8C%EB%93%A4%EA%B8%B010-%EC%B5%9C%EC%A2%85)

## π μμ±μ

π©βπ» κΉμμ­
 - BLOG : [Determination](https://determination.tistory.com/)
 - Email : ungseopkim@naver.com
