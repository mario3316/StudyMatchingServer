# :wave: 스터디 매칭 서비스 Server

---

### 프로젝트 설정

- Gradle
- Java 11
- Spring Boot 2.4.2
- Packaging : JAR
- Dependencies
  - Spring Web
  - Spring Security
  - Spring Data JPA
  - H2 Database
  - Lombok
  - Validation

---

### 구현 목록

- **_회원가입_**
- JWT 인증을 이용한 로그인
- 소셜 로그인
- 프로필
- 게시판
  - 글쓰기
  - 게시물 삭제
  - 게시물 수정
  - 댓글
- 지도 기반 스터디 매칭

---

### 공부 목록

- CSRF 토큰

  - CSRF (Cross-site Request Forgery)
    - 사이트에 로그인한 유저처럼 행세하는 공격
  - CSRF 공격을 방지하기 위해 View 와 통신할 때 확인용으로 Token 정보를 주고 받아서 인증을 받는다.
  - Spring Security에 기본적으로 설정되어 있음
  - 세션 쿠키와 랜덤으로 생성된 토큰을 포함한 Request를 요청하면 Spring Security가 Request를 검증하고 검증이 통과된 Request만 처리한다.

  - html form 전송시 POST 사용, hidden 타입으로 csrf를 전송
    ```
    <form action="/login" method="POST">
      <input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}" />
    ```
  - 클라이언트와 서버가 독립된 구조인 경우에는 CSRF를 적용하기 힘드므로 JWT를 대신 사용한다.

### 발생 Issue

- Lombok의 @RequiredArgsConstructor를 선언해도 Variable ~~ might not have been initialized 에러가 발생
  - Lombok Plugin 설치후 Restart .......
- Lombok not initialized in default constructor 에러
  - build.gradle에 아래 dependency 추가
  ```
  compileOnly 'org.projectlombok:lombok'
  annotationProcessor 'org.projectlombok:lombok'
  ```
