### 변경사항
<!-- 이 PR에서 어떤점들이 변경되었는지 기술해주세요. 가급적이면 as-is, to-be를 활용해서 작성해주세요.  -->

feat :  application (신청서), recruitment (모집 현황) 구현 완료.

신청서 기능 설명 : 신청서 CRUD 기능 구현 완료.
 이외에 신청서 제출과 회수 기능을 구현하여 작성한 신청서를 구인 게시글에 제출하고 제출을 취소하고 싶으면 회수하는 기능을 구현.
 그리고 자신의 신청서 리스트를 볼 수 있게 paging 요소 추가하여 구현완료.

Department (모집군) 관련 설명 : 기존에 생각했던 방식은 따로 DB를 두어 모집군을 다양하게 추가하며 관리하는 것이었는데,
 모집군을 다양하게 할 필요가 없고 매번 사용하는 모집군을 동일하게 사용할 것이기에 따로 DB 에 담기보다 Enum 으로 관리하는 것이 낫다고 판단하여 Enum 으로 구현.

모집 현황 기능 설명 : 기본적으로 모집 현황은 따로 DB 를 사용하나 게시글의 CRUD 에 맞춰서 함께 CRUD 되며 하나의 게시글에 여러개의 모집 현황이 존재할 수
 있기에 List 타입으로 구현함. 추가로 구인 게시글의 작성자인 팀장이 지원자의 신청서를 확인하고 승인했을 때, 해당되는 모집 현황에서 현재 모집 인원을 +1 하는 기능과
 반대로 -1 하는 기능도 구현함.

MappingProjectRecruit (DB) 설명 : 하나의 project 에 여러개의 recruitment 가 포함될 수 있기 때문에 projectId 와 recruitmentId 의 관계를
 mapping 해주는 관계형 DB 가 필요함. 하여 MappingProjectRecruit 라는 DB 를 추가로 만들어서 project (DB) 와 recruitment (DB) 의 관계를 정의함.

refactor : 데이터베이스 id 의 데이터 타입을 bigint 까지 사용할 필요가 없고 mysql 에서 long 을 지원하지 않기에
 모든 id 의 데이터 타입을 Integer 로 변경함.

**AS-IS**

application (신청서), recruitment (모집 현황) 구현 완료.

database 올바르게 작동하는지 확인 완료.

**TO-BE**

미흡한 부분 확인하여 추가할 예정.

api test 외에 test code 도 추가하여 안정성 확보할 예정.

### 테스트
<!-- 본 변경사항이 테스트가 되었는지 기술해주세요 --> 
- [ ] 테스트 코드

- [X] API 테스트