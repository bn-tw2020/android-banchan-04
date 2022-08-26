<p align="middle" >
  <img width="200px;" src="https://user-images.githubusercontent.com/66770613/186708019-15f9a4ca-ca90-446e-8591-c70fe62e6e63.png?raw=true"/>
</p>
<h1 align="middle">반찬 주문 애플리케이션 [Ordering]</h1>
<p align="middle">먹고 싶은 반찬을 시켜보아요. 20분 내에 도착합니다!!</p>


## 📝 프로젝트 소개

고객은 대표 음식, 메인 요리, 국물 요리, 밑반찬을 선택해서 음식을 주문할 수 있습니다.  

장바구니에 담아 골라먹는 재미를 느껴볼 수 있습니다. 주문 시작 시 20분 뒤에 도착하는 음식을 신선하게 먹을 수 있습니다.  

까먹지 않고 알림을 받아 고객님에게 리마인드 시켜줄 수 있습니다.  

<br/>

## 🤼‍♂️ 이 주의 우수 판매 사원들 🤼‍♀️
|[남태우](https://github.com/bn-tw2020)|[김민지](https://github.com/rosf73)|
|:----:|:----: 
|<img src="https://avatars.githubusercontent.com/u/66770613?v=4" width="100">|<img src="https://avatars.githubusercontent.com/u/47631768?v=4" width="100">|

<br/>

## 📸 UI Structure
- One-Activity
![image](https://user-images.githubusercontent.com/47631768/185745140-a6291b81-839a-4c41-ab81-30beaa2c88e9.png)

<br/>

## ✏️ 프로젝트 기술 스택

- Hilt version 2.42
- Kotlin Coroutine version 1.6.1
- Jetpack Compose version 1.4.0
- ComposeViewModel version 2.4.1
- Glide version 4.13.2
- GlideCompose version 1.6.1
- Retrofit2 version 2.9.0
- Moshi version 1.13.0
- OkHttp version 4.10.0
- Room version 2.4.3
- Paging3 version 3.1.1
- Junit4 version 4.13.2
- AndroidxJunit version 1.1.3
- Truth version 1.1.2
- ktlint version 10.3.0

<br/>

## 🏠 개발 문화

#### 1. 필수 규칙

- 무시하지 않고 싸우지 말기
    - 싸우는 경우, 벌금 100,000원

#### 2. 데일리 만남과 헤어짐은 필수

  - 매일 9시 30분에 데일리 스크럼을 진행한다.
  - 매일 5시에 데일리 회고를 진행한다.
  - 매주 월요일은 스프린트 계획을 진행한다.
  - 매주 금요일은 스프린트 회고를 진행한다.

#### 3. 장소

- 온라인, 오프라인은 전 날 회의 후, 결정한다.

#### 4. 협업

- PR로 올린 정보는 이해할 수 있을 때 까지 질의 응답과 머지가 불가능하다.
- 모르는 내용은 즉각 공유하고 생각해본다.
    - 회피도 정답일 수가 있기 떄문이다.
    - 공유하고 스스로 생각한 뒤, 팀원의 이야기를 빠르게 들어볼 수 있기 때문이다.

<br/>

## 📝 기능

- 고객은 음식을 선택에 장바구니에 넣어서 음식을 주문할 수 있다.
- 주문한 음식은 20분 뒤에 배달이 완료된다.
- 배달이 완료되면 알람을 통해 리마인드 해준다.
- 주문했던 음식이나, 최근 본 상품은 리스트로 볼 수 있으며 다시 확인할 수 있다.

- 음식 메뉴
  - 음식은 뷰페이저(좌우로 스크롤 해서 카테고리 변경이 가능)를 통해 대표음식, 메인 요리, 국물 요리, 밑반찬 중에서 확인할 수 있다.
  - 음식 메뉴 화면에서 장바구니에 담을 수 있다.
    - 장바구니에 담을 때 수량을 팝업을 통해 결정할 수 있다.
    - 장바구니에 담은 후, 장바구니 이동이 가능하며, 계속 쇼핑을 이어서 할 수 있다.
  - 각 카테고리 별 음식을 선택해 상세 화면에 들어가서 상세한 정보를 볼 수 있다.

- 장바구니
  - 장바구니 화면에서 음식을 전체 삭제, 부분삭제를 할 수 있다.
  - 수량을 -, + 버튼을 통해 수정할 수 있다.
  - 체크를 통해 원하는 음식을 주문할 수 있다.
  - 장바구니 화면 하단에서 최근 본 상품 리스트를 최신 순 7개를 볼 수 있다.
  - 7개 외의 더보기 버튼을 통해서 전체 최근 본 목록 리스트를 다 볼 수 있다.

- 주문 화면
  - 장바구니에서 주문한 음식은 주문 화면에서 주문 대표 이미지를 볼 수 있다.
  - 주문의 상태를 배송 준비중, 배송완료의 상태를 확인할 수 있다.
  - 주문을 클릭 하면 주문 상세 화면을 볼 수 있다.

- 주문 상세 화면
  - 주문 상세 화면에서는 배달 완료까지 얼마나 남았는지 확인이 가능하다.
  - 주문에 몇개의 음식을 주문했는지 확인이 가능하다.
  - 새로고침 버튼을 통해 주문 상세 화면을 reload 가능하다.
  - 남은 시간이 다 지나면 배송완료되었다는 텍스트를 볼 수 있으며, 주문 화면에서도 배송 준비중에서 배송완료로 바뀐다.
  - 남은 시간이 다 지나면, 알림을 받아서 고객은 리마인드가 가능하다.

- 최근 본 상품
  - 최근 본 상품은 음식 상세화면에 들어가면 최근 본 상품으로 취급된다.
  - 최근 본 상품으 최신 순으로 보여지며, 하단에 몇분 전에 보았는지 확인이 가능하다.

<br/>

## 🔗 관련 링크

- 하단 링크는 같은 스프레드시트로 링크됩니다.
- 스프레드시트의 하단에 요구사항 명세서, 데일리 스크럼, 스프린트 계획/회고, 트러블 슈팅, 데이터베이스를 확인할 수 있다.

[기능적 요구사항 명세서](https://docs.google.com/spreadsheets/d/1hU1G8ZzBLXUD7sJSPrs_Cw3NrjP_mbFWGFshoSNzSBs/edit#gid=0)  
[데일리 스크럼](https://docs.google.com/spreadsheets/d/1hU1G8ZzBLXUD7sJSPrs_Cw3NrjP_mbFWGFshoSNzSBs/edit#gid=1)  
[스프린트 계획/회고](https://docs.google.com/spreadsheets/d/1hU1G8ZzBLXUD7sJSPrs_Cw3NrjP_mbFWGFshoSNzSBs/edit#gid=0)  
[트러블 슈팅](https://docs.google.com/spreadsheets/d/1hU1G8ZzBLXUD7sJSPrs_Cw3NrjP_mbFWGFshoSNzSBs/edit#gid=0)  
[데이터베이스](https://docs.google.com/spreadsheets/d/1hU1G8ZzBLXUD7sJSPrs_Cw3NrjP_mbFWGFshoSNzSBs/edit#gid=0)  
