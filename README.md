# libraryUserRecommend

## 10.07 회의 이후
- 데이터 베이스 구축 필요
- 데이터 베이스 서버에 대한 고찰 중 ftp로는 적절한 성능을 낼 수 없다고 판단 -> 아파치, php 등으로 데이터 베이스 전용 서버 구축의 필요성
- 웹 서버의 네트워킹으로 자동적으로 db의 insert, delete, select 등의 기능을 구현할 예정
- 안드로이드에서는 db를 사용하기 위한 코드로는 url 형식으로 서버에 전달하는 구조로 구현할 필요가 있음

## 10.09
- 로그인 관련 php(안드로이드와의 연결 필요, apache를 통한 서버 구축 완료)
- user 관련 db 생성
-- pid int primary key autoincrement, _id char(20), pw char(20), authority int
