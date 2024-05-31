<p align= "center">
    <img src="https://capsule-render.vercel.app/api?type=waving&color=033d5e&height=300&section=header&text=PSMC&fontColor=f5f5f5&fontSize=90&fontAlignY=38&desc=Pro%20Sprots%20Medical%20Center&descAlignY=51" />
    </p>


## 프로젝트 배경

이 프로젝트는 주변 지인들의 재활 치료 및 스포츠 선수 관리에 대한 고충을 나누면서 제기된 문제들을 바탕으로 시작되었습니다.
<br>선수의 수술 및 재활 치료에 대한 소통이 주로 의사 사이에서만 이루어져 재활트레이너에게는 정보가 충분히 전달되지 못한다는 고충이 있다고 합니다.
<br>이를 해소하고자 의사와 트레이너 간 원할한 소통의 창구 역할을 할 수 있는 그룹웨어를 기획하게 되었습니다. 

    
## 🗣프로젝트 소개
- 환자 치료의 효율성을 높이고, 의료진 간의 원활한 소통을 위한 통합 그룹웨어 솔루션
- 의료진이 환자를 등록하고 관련 부상에 관련 있는 치료사를 할당
- 재활 치료사와 의료진 모두 스케쥴을 만드는데 있어 시간이 겹치지 않게 서버측에서 진료예약과 재활 치료 시간을 예약
- 재활과정과 치료 일정에 관해 재활 치료사와 의료진이 각각 TheraLink 와 MediConnect 공간에 작성
- 자신의 치료 및 진료하고 있는 환자를 자동으로 보여줌으로써 의사소통을 원할하게 할 수 있도록 함


## 팀 구성원 및 역할

<table>
  <tr>
    <td>
      <a href="https://github.com/syy0O">
        <img src="https://avatars.githubusercontent.com/u/86238720?v=4" width="100" style="max-width: 100%;">
      </a>
    </td>
    <td>
      <a href="https://github.com/SihyunSeo">
        <img src="https://avatars.githubusercontent.com/u/63051137?v=4" width="100" style="max-width: 100%;">
      </a>
    </td>
    <td>
      <a href="https://github.com/xeunnie">
        <img src="https://avatars.githubusercontent.com/u/138289674?v=4" width="100" style="max-width: 100%;">
      </a>
    </td>
    <td>
      <a href="https://github.com/subi930">
        <img src="https://avatars.githubusercontent.com/u/125132754?v=4" width="100" style="max-width: 100%;">
      </a>
    </td>
  </tr>
  <tr>
    <td align="center">
      <a href="https://github.com/comaserious">이호준</a>
    </td>
    <td align="center">
      <a href="https://github.com/wjdals83">서정민</a>
    </td>
    <td align="center">
      <a href="https://github.com/Absensing">김재중</a>
    </td>
    <td align="center">
      <a href="https://github.com/tmddbs9313">조승윤</a>
    </td>
  </tr>
    <tr>
        <td>팀장</td>
        <td>Backend</td>
        <td>Backend</td>
        <td>Frontend</td>
    </tr>
</table>

## 1. ✔개발 환경
- Front : HTML/CSS, javaScript, Bootstrap, Thymeleaf
- Back : java/javaScript
- 버전 및 이슈 관리 : Github
- 협업 툴 : Notion
- 서비스 배포 환경 : jar

## 2. 브랜치 전략
- 기능 별로 이름을 정하여 브랜치를 생성했습니다
- CSS : 뷰포트의 이미지를 생성하는 기능
- feature : CRUD 등 backend 관련 기능
- DB : db 업데이트
- bug : 기능에 오류 수정
- 브랜치 별로 커밋을 한 후 충돌이 발생하지 않거나 충돌을 해결한 후 master 브랜치에 merge 하는 방식을 채택했습니다

## 3. 프로젝트 구조

```
└─psmc
    ├─auth
    ├─common
    │  ├─exception
    │  └─model
    │      ├─dto
    │      └─method
    ├─configuration
    │  └─handler
    ├─mainPage
    ├─mediConnect
    ├─mypage
    ├─staff
    ├─theraLink
    └─user
```

충돌을 방지하기 위해서 기능 별로 역할을 분담하고 기능별로 패키지를 구성하였습니다
## 역할 분담

이호준
- 기능
  - 로그인, 아이디찾기, 비밀번호 찾기, 회원가입 약관, 회원가입 등록, 비밀번호 수정, mainpage 환자 등록, 스케쥴 작성, 식단표 작성, 스케쥴러 예약기능, theralink 블로그 생성 및 채팅 시스템
- DB
  - DB 테이블 생성

서정민
- UI
  - 페이지 : MediConnect
- 기능
   - MediConnect 생성하기 및 채팅 시스템, mainpage 의 MediConnect 최근 업데이트 정보
- DB
  - DB 테이블 생성

조승윤
- UI
  - 페이지 : 메인 페이지, mypage
- 기능
  - mypage 자신의 정보 수정

김재중
- UI
  - 페이지 : Staff
- 기능
    - staff 전공분야 또는 이름으로 의료진 또는 치료진 정보
- 오류 테스트

## 📅프로젝트 기간
-  전체 개발 기간 : 2024.04.25 ~ 2024.06.03
- DB 작성 : 2024.04.25 ~ 2024.05.02
- UI 구현 : 2024.05.03 ~ 2024.05.23
- 기능 구현 : 2024.05.04 ~ 2024.05.30

## 작업관리
- github 의 discussion 에 해당 일에 해야할 일을 작성
- discussion 에서 할당 받은 작업에 관해 issue 탭에 자신의 issue 를 작성
- 기능을 완수 하면 각각의 기능에 맞게 브랜치를 생성후 충돌을 모두 해결한 후 master 브랜치에 merge

## ERD

![asdadfasdfdsaf](https://github.com/semi-project-team/PSMC/assets/158137025/622cefcb-b247-41fd-8d21-5261461ce243)


## 기능 설명
- 첫 페이지 : 로그인, 회원가입, id 찾기, 비밀번호 찾기
- mypage : 가입한 회원의 정보를 조회 및 수정
- main page : 회원의 정보, 오늘의 식단표, 오늘의 스케쥴, mediconnect 과 theralink 의 최신 채팅 내용을 보여줍니다
  - 의료진의 경우 : 새로운 환자를 등록하여 새로운 프로젝트를 생성합니다, 또한 자신의 환자에 대해서 진료 예약을 할 수 있습니다
  - 재활 치료진의 경우 : 새로 부여받은 환자를 확인하고 재활 치료 시간을 예약할 수 있습니다
- scheduler : 해당 날짜 또는 사용자가 선택한 날짜를 기준으로 일요일부터 월요일까지의 전체 스케쥴을 보여줍니다. 또한 일정을 수정할 수 있습니다.
- mediconnect : 의료진에서 등록한 환자를 프로젝트 단위로 하여 프로젝트 하나당 하나의 공간을 생성하고 생성된 공간에서 할당된 재활 치료진과 의사소통을 할 수 있습니다
  - 의료진의 경우 : 현재 환자 상태에 대해서 소견을 작성하고 할당된 재활 치료사와 의사소통을 합니다. 또한 자신의 채팅을 삭제 및 프로젝트를 종료 할 수 있습니다
  - 재활 치료진의 경우 : 새로 부여 받은 환자에 대한 프로젝트를 확인할 수 있고 의료진의 소견을 확인하고 의견을 게시할 수 있고 또한 이에 근거하여 theralink를 생성하여 재활 치료에 관한 계획을 수립할 수 있습니다
- theralink : 할당된 환자에 따라 자동으로 프로젝트가 생성되고 그에 따라 각각의 소통 창구가 생성됩니다
  - 의료진의 경우 : 생성된 재활 일지를 확인하고 환자 상태에 대한 정보를 수집할 수 있고 또한 재활 치료진과 환자에 관하여 의사소통을 원할히 할 수 있습니다
  - 재활 치료진의 경우 : 할당된 환자에 따라 프로젝트가 생성 되고 이에 따라 재활 일지를 작성하고 자신의 소견을 작성 할 수 있습니다 작성된 소견에 대하여 의사와 의사소통을 할 수 있습니다
- staff : 기본적으로 각 분야에 해당하는 팀장 정보를 제공하여 의료 종사자 정보를 확인할 수 있습니다. 또한 전공 분야 또는 이름을 검색하여 해당 하는 의료전공자의 정보를 취득할 수 있습니다

## 신경 쓴 부분
- [예약 및 수정 시간 관련 방식](https://github.com/semi-project-team/PSMC/wiki/진료-시간-및-재활-치료시간-예약하기)
- [유사 채팅 생성](https://github.com/semi-project-team/PSMC/wiki/%EC%9C%A0%EC%82%AC-%EC%B1%84%ED%8C%85-%EA%B8%B0%EB%8A%A5-%EB%A7%8C%EB%93%A4%EA%B8%B0)
- [페이징 처리](https://github.com/semi-project-team/PSMC/wiki/Paging-%EC%B2%98%EB%A6%AC)
- [비밀번호찾기를 통한 이메일 전송](https://github.com/semi-project-team/PSMC/wiki/%EB%B9%84%EB%B0%80-%EB%B2%88%ED%98%B8-%EC%B0%BE%EA%B8%B0-%EA%B8%B0%EB%8A%A5)
- [이미지 저장](https://github.com/semi-project-team/PSMC/wiki/%EC%9D%B4%EB%AF%B8%EC%A7%80-%EC%A0%80%EC%9E%A5%ED%95%98%EA%B8%B0)
