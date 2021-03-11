## 1. 목표

URL을 입력받아 짧게 줄여주고, Shortening된 URL을 입력하면 원래 URL로 리다이렉트하는 URL Shortening Service
예) https://en.wikipedia.org/wiki/URL_shortening => http://localhost/JZfOQNro

 - URL 입력폼 제공 및 결과 출력
 - URL Shortening Key는 8 Character 이내로 생성되어야 합니다.
 - 동일한 URL에 대한 요청은 동일한 Shortening Key로 응답해야 합니다.
 - 동일한 URL에 대한 요청 수 정보를 가져야 한다(화면 제공 필수 아님)
 - Shortening된 URL을 요청받으면 원래 URL로 리다이렉트 합니다.
 - Database 사용은 필수 아님

 ## 2. 개발환경 

  - JDK 11
  - Gradle
  - JPA, h2
  - Spring boot 2.4.3
  - Junit
  - lombok 1.18.18
  - thymeleaf

 ## 3. 설치 

  - Repository Clone

    - `git clone https://github.com/seno-b/UrlShortener.git`
      
- H2 Database 설치
    1. http://www.h2database.com 접속
  2. All Platforms 다운로드 후 압축해제
  3. 압축해제 한 디렉토리 내에서 `./bin/sh.sh`
  4. `application.yml` 접속정보 확인 후 접속
    

## 4. 사용방법
      
  - Build

    - `$ ./gradlew build`

  - Execute

    - `$ java -jar ./build/libs/UrlShorter-0.0.1-SNAPSHOT.jar`

