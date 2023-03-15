# Traduler

<div align="left">
<img width="232" alt="스크린샷 2023-02-26 오후 5 52 05" src="https://user-images.githubusercontent.com/102651155/222057876-0d44a491-7e7a-4ba2-ae66-eeebac57fc19.png">

</div>


> **개인 토이 프로젝트(Spring)** <br/> **개발기간: 2022.08.25 ~ 2022.09.01**


## 프로젝트 참여

|      고재찬      |         권 해        |                                                                                                             
| :------------------------------------------------------------------------------: | :---------------------------------------------------------------------------------------------------------------------------------------------------: 
| 동국대학교 컴퓨터공학전공 3학년 | 전남대학교 컴퓨터정보통신공학과 3학년 

## 프로젝트 소개

Spring Boot, Spring Data JPA, Spring Security, Thymeleaf, Bootstrap 등의 스프링 프레임워크와 관련 기술들과, MVC패턴의 공부를 목적으로, <br>
약 7일에 거쳐 여행계획짜기 웹 어플리케이션 "Traduler(Travel+Scheduler)"을 개발하였다.<br>
이 어플리케이션은 회원가입, 로그인, 여행계획짜기, 여행지 추천, 커뮤니티 등의 기능을 포함한다.<br>
배포나 기능에 초점을 맞추기 보단, 간단한 CRUD 위주의 Spring 기초와 서버 동작의 이해를 목적으로 한 프로젝트이다. 



## Stacks 🐈

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=Spring%20Boot&logoColor=white)
![Bootstrap](https://img.shields.io/badge/Bootstrap-7952B3?style=for-the-badge&logo=Bootstrap&logoColor=white)
![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=HTML5&logoColor=white)
![Spring Security](https://img.shields.io/badge/Spring%20Security-6DB33F?style=for-the-badge&logo=Spring%20Security&logoColor=white)
<br>
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=MySQL&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-005F0F?style=for-the-badge&logo=Thymeleaf&logoColor=white)
![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=Git&logoColor=white)

---
## 화면 구성 📺
| 홈 화면 |  나만의 여정  |
| :-------------------------------------------: | :------------: |
|  <img width="329" src="https://user-images.githubusercontent.com/102651155/222075233-59535efe-9a6e-4da6-aa89-eded31a34bef.png"/> |  <img width="329" src="https://user-images.githubusercontent.com/102651155/222075420-89c3f97a-baa0-427b-ba09-266fb0ba5711.png"/>|  
| 여행지 추천 |  커뮤니티  |  
| <img width="329" src="https://user-images.githubusercontent.com/102651155/222075636-1ea19a75-ed3b-42f3-8cd0-5fab6e1ff745.png"/>   |  <img width="329" src="https://user-images.githubusercontent.com/102651155/222075780-63d80b21-994d-4320-bf66-c25711c30f06.png"/>     |

---
## 주요 기능 📦

### ⭐️ 로그인 & 회원가입 
사용자가 계정을 만들고 로그인하여 후 여행계획을 만들 수 있다.<br>
회원가입과 로그인 기능을 구현하기 위해 Spring Security를 사용하였다.<br>
로그인 여부에 따라, "나만의 여정", 커뮤니티의 "글쓰기" 와 같은 메뉴의 이용은 제한될 수 있다.
### ⭐️ 나만의 여정 
여행지, 일정, 예산 등을 입력하여 내 여행 계획을 저장할 수 있다. 계획은 입력된 순서에 관계없이 여행 일자 기준으로 오름차순 정렬된다.

### ⭐️ 여행지 추천 
단순 정보제공 메뉴이다. 지역 별 여행지에 대한 정보를 추천받을 수 있다.

### ⭐️ 커뮤니티 
공지사항, 여행정보 공유를 위한 게시판이다. 커뮤니티 메뉴는 누구나 접근이 가능하지만, 글쓰기 기능은 로그인 한 유저만 가능하고, 글 삭제는 글쓴이 본인만 가능하다.




