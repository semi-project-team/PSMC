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

| 이름    | 역할         | 깃허브 주소                   |
|---------|--------------|-------------------------------|
| 이호준  | 팀장 | [이호준의 깃허브](https://github.com/comaserious) |
| 서정민  | Backend | [서정민의 깃허브](https://github.com/wjdals83) |
| 김재중  | Backend | [김재중의 깃허브](https://github.com/Absensing) |
| 조승윤  | Frontend | [조승윤의 깃허브](https://github.com/tmddbs9313) |


## 1. 개발 환경
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

            psmc
            ├─auth
            │  ├─controller
            │  └─model
            ├─common
            │  ├─exception
            │  └─model
            ├─configuration
            │  └─handler
            ├─mainPage
            ├─mediConnect
            ├─mypage
            ├─staff
            ├─theraLink
            └─user

```

- 충돌을 방지 하기 위해서 기능별로 패키지를 만들었고 공통으로 사용하는 것은 common 패키지 하위에 담았습니다


## ✨주요 기능
1. 진료일지(의사만 작성) - 의사와 치료사가 모두 확인할 수 있으며 일지에 대한 코멘트를 작성
2. 치료일지(트레이너만 작성) - 의사와 치료사가 모두 확인할 수 있으며 일지에 대한 코멘트를 작성
3. 진료 및 재활운동 스케쥴 열람 기능 - 예정된 스케쥴을 한 눈에 확인하며, 예약을 통해 스케쥴을 업데이트

## 📅프로젝트 기간
- 2024.04.15 ~ 

## 👫개발자소개
- 이호준 :
- 서정민 :
- 조승윤 :
- 김재중 :

## ✔사용한 기술스택





