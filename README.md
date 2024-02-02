# Java-MySQL-Project (Firm_dataManagement)
MySQL + Java JDBC를 이용한 사원정보 관리 프로그램 개발

## 🖥️ 프로젝트 소개
- CLI와 GUI(swing)를 사용하여 사용자가 편리하게 사원 테이블의 데이터를 검색, 추가, 삭제, 변경 작업을 수행 가능합니다.
- JDBC를 이용하여 MySQL 데이터베이스에 연결하고, SQL문을 실행하여 사원의 사원명, 사원 번호, 직업 등의 정보를 효과적으로 관리합니다.

## 🕰️ 개발 기간
* 24.01.25(목) - 24.02.01(목) 

### 🧑‍🤝‍🧑 참여자
 - 박여진

### ⚙️ 개발 환경
- `Java 11`
- `JDK 11.0.21`
- **Database** :  MySQL 8.0

## 📌 주요 기능
### ⚡CLI 프로그램
#### 메인메뉴 - <a href="Test1_CLI/Main.java" >상세보기 </a>
- 기본사항
  - MySQL 로그인은 자동으로 수행됨 (아래의 ⭐로그인 정보페이지 참고)
  - '사원번호'를 통해 작업들을 수행하므로 '메뉴 4️⃣-1. 전체 조회'를 먼저 수행하는 것을 권장함.
- 사용 방법
  - 사용자가 원하는 메뉴 선택 (1️⃣. 추가, 2️⃣. 삭제, 3️⃣. 변경, 4️⃣. 조회, 5️⃣. 종료)
  - 1️⃣~4️⃣ 메뉴의 작업 수행 완료 후, 메인메뉴로 다시 돌아옴 
  - '메뉴5️⃣. 종료'를 선택시 프로그램 종료
#### 메뉴1️⃣. 사원 정보 추가(등록) - <a href="Test1_CLI/Insert.java" >상세보기 </a> 
- 데이터를 추가할 사원의 '전체 항목'에 대해 하나씩 순차적으로 입력 (사원번호, 사원명, 직업명, 관리자번호, 고용날짜, 연봉, 성과금, 부서번호)
- 입력 완료
#### 메뉴2️⃣. 사원 정보 삭제 - <a href="Test1_CLI/Delete.java" >상세보기 </a> 
- 데이터를 삭제할 사원의 '사원번호'를 입력
- 삭제 완료
#### 메뉴3️⃣. 사원 정보 변경 - <a href="Test1_CLI/Update.java" >상세보기 </a>
- 데이터를 변경할 사원의 '사원번호'를 입력
- 변경 완료
#### 메뉴4️⃣. 사원 정보 조회 - <a href="Test1_CLI/Select.java" >상세보기 </a>
- 하위메뉴 선택(1. 전체 조회, 2. 사원별 조회)
  ##### 메뉴 4️⃣-1. 전체 조회
  - 전체 사원들의 데이터가 조회됨
  ##### 메뉴 4️⃣-2. 사원별 조회 
  - 데이터를 조회할 사원의 '사원번호'를 입력
  - 조회 완료
#### ⭐로그인 정보페이지- <a href="Test1_CLI/LoginInfo.java" >상세보기 </a>
- MySQL 데이터베이스에 연결하기 위한 정보들을 포함 (url, id, pass)
- 위의 정보들은 보안의 유지를 위해 private 접근 제한자를 활용함

### ⚡GUI 프로그램
#### 메인메뉴 - <a href="Test1_GUI/Main.java" >상세보기 </a>
- 기본사항
 - 중간의 창에 기본사항들이 안내되어 있음
 - '사원번호'와 '입사일'은 변경 불가능
- 사용 방법
  1. '전체 내용' 버튼을 눌러 전체 사원의 데이터를 조회
  2. '사원번호' 입력 후 원하는 메뉴 수행

#### ⭐로그인 정보페이지- <a href="Test1_GUI/LoginInfo.java" >상세보기 </a>
- MySQL 데이터베이스에 연결하기 위한 정보들을 포함 (url, id, pass)
- 위의 정보들은 보안의 유지를 위해 private 접근 제한자를 활용함

