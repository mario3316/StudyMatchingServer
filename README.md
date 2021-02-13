# :wave: Algorithm
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
- JWT
    - JSON 객체를 사용해서 토큰 자체에 정보들을 저장하고 있는 Web Token
    - 구조
        - Header
            - Signature 를 해싱하기 위한 알고리즘 정보 저장
        - Payload
            - 서버와 클라이언트에서 주고받는 실제 정보들을 저장
        - Signature
            - 토큰의 유효성을 검증하기 위한 문자열
    - 장점
        - 중앙의 인증서버와 데이터 스토어에 대한 의존성이 없기 때문에 수평 확장이 유리하다.
        - Base 64 URL Safe Encoding을 이용하기 때문에 URL, Cookie, Header 모두에서 사용 가능하다.
    - 단점
        - Payload 의 정보가 많아지면 트래픽이 커진다.
        - 토큰이 클라이언트에 저장되기 때문에 서버는 클라이언트에 저장된 각 토큰을 조작할 수 없다.
            