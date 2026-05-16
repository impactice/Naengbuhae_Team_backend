# Naengbuhae_Team_backend

## 기본 세팅하기 

## Java(JDK 17 버전을 사용) - Amazon Corretto 17   
링크: https://aws.amazon.com/ko/corretto/  
화면에서 'Amazon Corretto 17 다운로드' 링크나 버튼을 찾아서 클릭  
Windows x64 줄에 있는 .msi 파일을 클릭해서 다운로드  
다운받은 설치 파일을 실행   
설치가 다 끝났다면, 시스템이 자바를 인식할 수 있도록 명령 프롬프을 연다  
```
java -version
```
화면에 openjdk version "17.0.x" (그리고 옆에 Corretto 어쩌고) 하는 문구가 예쁘게 뜨면 대성공

## 개발 툴(IDE): IntelliJ IDEA (인텔리제이)를 사용 
터미널로 설치 
```
winget install JetBrains.IntelliJIDEA.Community
```
약관 동의(Y/N)가 나오면 Y를 누르고 조금만 기다리면, 알아서 다운로드 된다

## spring boot 세팅 

<img width="1919" height="948" alt="spring boot" src="https://github.com/user-attachments/assets/c4b2d36b-580f-48ad-b06f-0402c1b27ae5" />

## 데이터베이스 구축하기 

<img width="1919" height="881" alt="image" src="https://github.com/user-attachments/assets/79e92f87-0e9f-4a57-91f9-bf559dcd8126" />

<img width="1919" height="879" alt="image" src="https://github.com/user-attachments/assets/6c962256-c913-463c-bfe2-a1fa6cd1a241" />

<img width="1919" height="883" alt="image" src="https://github.com/user-attachments/assets/c6695bae-0ffa-401c-b291-d2190ed1d849" />

<img width="1919" height="876" alt="image" src="https://github.com/user-attachments/assets/72a180fb-2e02-4f07-be1f-f86526d50249" />



## 데이터 베이스랑 연결시키기 

🛠️ 1단계: 스프링 부트에게 PostgreSQL 번역기 달아주기
스프링 부트는 처음에 우리가 설정했던 H2 데이터베이스만 알고 있어서, PostgreSQL이랑 대화하려면 전용 번역기(드라이버)를 하나 달아줘야 해.

1. 인텔리제이 왼쪽 프로젝트 파일 목록에서 build.gradle 이라는 코끼리 모양 파일을 더블클릭해서 열어줘.

2. 코드 아래쪽으로 쭉 내리다 보면 dependencies { ... } 라고 적힌 블록이 보일 거야.

3. 그 괄호 { } 안에 아래 코드 한 줄을 복사해서 맨 밑에 추가해 줘.

```
runtimeOnly 'org.postgresql:postgresql'
```
4. [제일 중요 ⭐️] 코드를 붙여넣으면 인텔리제이 화면 오른쪽 위 구석에 작은 코끼리 아이콘(Load Gradle Changes) 🐘이 둥둥 뜰 거야. 그걸 무조건! 꼭! 눌러줘야 번역기가 다운로드 돼. (화면 아래쪽 상태 표시줄에 로딩 바가 다 지나갈 때까지 잠깐 기다려줘!)

<img width="959" height="503" alt="image" src="https://github.com/user-attachments/assets/6df1d047-a1bf-487b-8351-beac0cb7253f" />

🔗 2단계: 마법의 DB 주소 입력하기
이제 진짜 주소를 알려줄 차례야.

인텔리제이 왼쪽 파일 목록에서 src ➔ main ➔ resources 폴더를 열면, 그 안에 application.properties (또는 application.yml) 파일이 있을 거야. 더블클릭해서 열어줘.

파일 안에 아래 코드를 통째로 복사해서 붙여넣어 줘.

```
# 데이터베이스 연결 주소 (여기에 아까 만든 주소를 넣을 거야!) 이 주소 절대 공개 금지(털려서...) ai한테도 당장 금지 나중에 .env파일을 분리하겠습니
spring.datasource.url=여기를_지우고_아까_완성한_긴_주소를_통째로_붙여넣어주세요
spring.datasource.driver-class-name=org.postgresql.Driver

# JPA (스프링 부트 <-> DB 번역기) 설정
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

## 재생 버튼을 눌러서 재생하기 
<img width="1915" height="53" alt="image" src="https://github.com/user-attachments/assets/9ae59589-778e-4278-98b6-46890b617c89" />

나 같은 경우 이렇게 저장을 했는데 불이 안 들어 왔다   

🟢 잠든 재생 버튼 깨우고 서버 켜는 법
1. 인텔리제이 왼쪽 폴더 목록에서 src ➔ main ➔ java ➔ com.example.어쩌구 폴더를 차례대로 열어줘.
2. 그 안에 보면 NaengbuhaeApplication (또는 이름이 비슷한 ~Application.java) 이라는 자바 파일이 딱 하나 있을 거야. 그걸 더블클릭해서 열어!
3. 파일이 열리면 코드 창 왼쪽 줄 번호 옆을 잘 봐. public static void main(String[] args) 라고 적힌 줄 바로 옆에 **초록색 재생 버튼(▶️)**이 귀엽게 붙어있을 거야.
4. 그 초록색 버튼을 클릭하고, 'Run NaengbuhaeApplication.main()' 을 선택해 줘!

근데 
```
Caused by: org.postgresql.util.PSQLException: The connection attempt failed.
```
이런 에러가   

🕵️ 원인: Supabase의 최신 정책 (IPv6) vs 우리 집 인터넷 (IPv4)
최근에 Supabase가 속도를 높이려고 'Direct connection(직접 연결)' 방식을 최신 인터넷 주소망(IPv6)으로 강제 업데이트했어. 그런데 우리나라의 많은 가정용 인터넷이나 와이파이는 아직 구형 주소망(IPv4)을 쓰는 경우가 많아서, 서로 대화가 안 통하고 튕겨버리는 거야.

💡 해결책: 'Session pooler (구형 인터넷용 터널)'로 바꿔주기!
아까 네가 나한테 캡처해서 보여줬던 화면(Connection Method 고르는 창) 혹시 기억나? 그 화면으로 딱 한 번만 다시 돌아가 보자!

1. Supabase 대시보드에서 아까 접속했던 [Connect] 창을 다시 열어줘.
2. Connection Method에서 Direct connection 대신, 맨 아래에 있는 Session pooler를 선택해!
(아까 네 캡처 화면에도 자세히 보면 "IPv4 네트워크 환경에서 연결할 때 추천함"이라고 적혀있었어!)
3. Type은 똑같이 JDBC로 둔 상태에서, 새롭게 짠! 하고 나타난 새로운 긴 주소를 복사해 줘. (이번엔 주소 끝부분 포트 번호가 5432가 아니라 6543으로 바뀌어 있을 거야!)
4. 복사한 주소에 아까처럼 진짜 비밀번호를 다시 끼워 넣어줘. (대괄호 [] 지우는 거 잊지 말고!)

🛠️ 마무리 인텔리제이 수정
이제 인텔리제이의 application.properties로 돌아와서, 방금 만든 새로운 Session pooler 주소로 싹 갈아끼워줘. 
```
spring.application.name=Naengbuhae

# 💡 포트번호가 6543으로 끝나는 Session pooler 주소로 변경!
spring.datasource.url=여기를_지우고_아까_완성한_긴_주소를_통째로_붙여넣어주세요
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

## 해결 
```
spring.application.name=Naengbuhae

spring.datasource.url=jdbc:postgresql://db.lulvkjjxtmnvvqvnatbp.supabase.co:6543/postgres

spring.datasource.username=postgres
# 데이터베이스 연결 주소 이 주소 절대 공개 금지(털려서...) ai한테도 당장 금지 나중에 .env파일을 분리하겠습니다
spring.datasource.password=여기에_비번을_넣어요

spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

이걸로 하고 휴대폰 핫스팟을 켜서 되니 연결이 됨


## .env 파일로 민갑한 정보 숨기기 

🛡️ 1단계: 스프링 부트한테 .env 읽는 법 가르치기
원래 Node.js 같은 건 .env를 바로 읽지만, 스프링 부트는 돋보기(라이브러리)를 하나 달아줘야 해.

1. 인텔리제이 왼쪽 파일 목록에서 🐘 build.gradle 파일을 열어줘.
2. dependencies { ... } 라고 적힌 블록 안에 아래 코드를 한 줄 추가해!
```
implementation 'me.paulschwarz:spring-dotenv:4.0.0'
```
3. 코드를 넣으면 화면 오른쪽 위에 작게 코끼리 아이콘(🐘)이랑 새로고침 버튼이 뜰 거야. 그걸 꼭! 눌러서 라이브러리를 설치해 줘. (밑에 게이지 다 찰 때까지 대기!)


📝 2단계: 최상위 폴더에 .env 파일 만들기
이제 진짜 비밀번호를 담을 금고를 만들 차례야.

1. 인텔리제이 왼쪽 파일 목록에서 프로젝트의 맨 꼭대기(루트) 폴더를 우클릭해. (아마 Naengbuhae라고 적힌 제일 위쪽 폴더일 거야. src 폴더 안이 아니야!)
2. [New] ➔ [File] 을 누르고, 파일 이름을 정확히 .env 라고 적고 엔터를 쳐.
3. 만들어진 .env 파일 안에 아래처럼 네 진짜 정보를 적어줘! (여긴 띄어쓰기나 따옴표 없이 적는 게 좋아)

🙈 3단계: 깃허브에서 .env 완벽하게 숨기기 (가장 중요!!!)
금고를 만들었으니, 깃허브라는 공개 광장에 이 금고가 올라가지 않도록 투명 망토를 씌워야 해!

1. 프로젝트 맨 꼭대기 폴더에 보면 .gitignore 라는 파일이 이미 있을 거야. (이게 투명 망토 파일이야!) 열어줘.
2. 파일 맨 아래 빈 공간에 딱 이렇게 한 줄을 추가해 줘.

```
# 환경변수 파일 숨기기
.env
```
이러면 깃허브 데스크탑 같은 곳에서 .env 파일이 아예 안 보이게 돼서, 절대 실수로 올라갈 일이 없어!  

🔄 4단계: application.properties 수정하기
이제 원래 파일로 돌아가서, "내 진짜 비밀번호는 .env 금고 안에 있으니까 거기서 꺼내 써!" 라고 연결해 주면 끝이야.

application.properties 파일을 열고 아까 적었던 부분을 이렇게 수정해 줘:

```
spring.application.name=Naengbuhae

# 주소는 안 가려도 됨!
spring.datasource.url=jdbc:postgresql://db.lulvkjjxtmnvvqvnatbp.supabase.co:6543/postgres

# .env 금고에서 가져오기! (달러 기호랑 중괄호 필수)
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}

spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

## 해결 

<img width="1919" height="1008" alt="image" src="https://github.com/user-attachments/assets/ab1d3c4e-64e3-46ce-a471-e9894e1fe7ba" />

<img width="1198" height="990" alt="image" src="https://github.com/user-attachments/assets/933543ce-e8a6-4c0c-be90-da17866b4bf6" />
환경 변수에 직접 경로를 입력하니 해결이 되었다 

## 식제료 도메인 기초 세팅 

<img width="1919" height="1008" alt="image" src="https://github.com/user-attachments/assets/b6394212-4c07-4a7b-a4d1-910358cce01e" />

Ingredient.java (domain 폴더) : 식재료 설계도
```
package com.example.Naengbuhae.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

// @Entity: "스프링아, 이 클래스 모양대로 Supabase DB에 '식재료' 테이블을 만들어줘!" 라는 뜻
@Entity
@Getter @Setter // 롬복(Lombok) 기능: 숨겨진 데이터(필드)를 꺼내고(Get) 바꿀(Set) 수 있게 해줌
@NoArgsConstructor // 롬복 기능: 텅 빈 기본 설계도(기본 생성자)를 알아서 만들어줌
public class Ingredient {

    // @Id: "이게 식재료들을 구분하는 고유 번호(주민등록번호)야!" 라는 뜻 (Primary Key)
    @Id
    // @GeneratedValue: "고유 번호는 내가 안 넣을 테니까, DB 네가 1, 2, 3... 알아서 1씩 올려가며 넣어줘!"
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Column: "이 데이터는 DB의 기둥(컬럼)이 될 건데, 이름은 무조건 있어야 해! (비어있으면 안 됨)"
    @Column(nullable = false)
    private String name; // 식재료 이름 (예: 계란)

    private Integer quantity; // 수량 (예: 10)

    private LocalDate expirationDate; // 유통기한 (예: 2026-04-15)

    // 식재료를 처음 만들 때 이름, 수량, 유통기한을 한 번에 쏙 넣기 위해 만든 틀(생성자)
    public Ingredient(String name, Integer quantity, LocalDate expirationDate) {
        this.name = name;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
    }
}
```

IngredientRepository.java (repository 폴더) : DB 창고지기
```
package com.example.Naengbuhae.repository;

import com.example.Naengbuhae.domain.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// @Repository: "스프링아, 얘는 DB 창고지기(Repository)니까 네가 관리해 줘!"
@Repository
// JpaRepository<Ingredient, Long>: 마법의 지팡이!
// "이 창고지기는 'Ingredient(식재료)' 데이터를 다룰 거고, 고유 번호는 'Long(숫자)' 타입이야."
// 이걸 상속(extends)받는 순간, 저장(save), 찾기(findById), 전체조회(findAll) 같은 SQL 코드를 안 짜도 다 쓸 수 있음!
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
```

IngredientService.java (service 폴더) : 프로젝트의 두뇌
```
package com.example.Naengbuhae.service;

import com.example.Naengbuhae.domain.Ingredient;
import com.example.Naengbuhae.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// @Service: "얘가 우리 프로그램의 비즈니스 로직(머리 쓰는 일)을 담당하는 애야!"
@Service
// @Transactional(readOnly = true): "여기 있는 기능들은 기본적으로 DB를 '읽기'만 할 거야. (조회 속도가 빨라짐!)"
@Transactional(readOnly = true)
// @RequiredArgsConstructor: 롬복 기능. 창고지기(Repository)를 자동으로 섭외해서 연결해 줌.
@RequiredArgsConstructor
public class IngredientService {

    // 두뇌(Service)가 일을 하려면 창고지기(Repository)가 무조건 필요함!
    private final IngredientRepository ingredientRepository;

    // --- 1. 식재료 저장 기능 ---
    // @Transactional: "이 기능은 DB에 데이터를 쓰는 거니까, 혹시 에러 나면 저장 취소(롤백)하고 완벽하게 처리해 줘!"
    @Transactional
    public Long saveIngredient(Ingredient ingredient) {
        ingredientRepository.save(ingredient); // 창고지기한테 "이 식재료 저장해!" 라고 시킴
        return ingredient.getId(); // 저장이 잘 끝났으면, DB가 부여한 고유 번호를 돌려줌
    }

    // --- 2. 식재료 전체 조회 기능 ---
    public List<Ingredient> findAllIngredients() {
        return ingredientRepository.findAll(); // 창고지기한테 "창고에 있는 식재료 싹 다 가져와!" 라고 시킴
    }
}
```

IngredientController.java (controller 폴더) : 레스토랑 안내 데스크
```
package com.example.Naengbuhae.controller;

import com.example.Naengbuhae.domain.Ingredient;
import com.example.Naengbuhae.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RestController: "얘는 외부(브라우저, Postman, AI 팀원)의 요청을 받는 API 안내 데스크야!"
@RestController
// @RequestMapping: "이 안내 데스크의 주소는 'http://localhost:8080/api/ingredients'야!"
@RequestMapping("/api/ingredients")
@RequiredArgsConstructor // 두뇌(Service)를 자동으로 섭외해서 연결해 줌.
public class IngredientController {

    // 안내 데스크는 들어온 요청을 처리하기 위해 두뇌(Service)에게 일을 넘겨야 함!
    private final IngredientService ingredientService;

    // --- API 1: 식재료 새로 등록하기 (POST 요청) ---
    // @PostMapping: 누군가 이 주소로 POST(저장) 요청을 보내면 이 메서드가 실행됨
    @PostMapping
    // @RequestBody: "요청으로 날아온 JSON 데이터(계란 10개 등)를 Ingredient 객체로 찰떡같이 변환해서 받아줘!"
    public Long create(@RequestBody Ingredient ingredient) {
        // 두뇌(Service)에게 저장을 부탁하고, 성공하면 받은 고유 번호를 돌려줌
        return ingredientService.saveIngredient(ingredient);
    }

    // --- API 2: 냉장고 속 식재료 다 보기 (GET 요청) ---
    // @GetMapping: 누군가 이 주소로 GET(조회) 요청을 보내면 이 메서드가 실행됨
    @GetMapping
    public List<Ingredient> list() {
        // 두뇌(Service)에게 싹 다 찾아오라고 시킨 결과를 리스트 형태(JSON)로 뱉어줌
        return ingredientService.findAllIngredients();
    }
}
```



## 포트 번호 막히는 거 해결하기 
1️⃣ Supabase PostgREST API 사용하기 (비추천 🙅‍♂️)
원리: Supabase는 DB(5432 포트)를 직접 안 찔러도, 웹사이트 접속하는 것처럼 443 포트(HTTPS)로 데이터를 넣고 뺄 수 있는 'REST API' 기능을 기본으로 제공해. 학교 와이파이도 443 포트는 웹서핑을 해야 하니까 절대 못 막거든! 그래서 이 방법을 쓰면 와이파이에서도 뻥뻥 뚫려.

우리가 쓰면 안 되는 이유: 이걸 쓰려면 우리가 어제 피땀 흘려 만든 Spring Data JPA (IngredientRepository, @Entity 등)를 전부 다 버려야 해! 😭
JPA는 무조건 5432 포트로 DB랑 '직접 연결(JDBC)'을 해야만 작동하는 마법이거든. API 방식으로 바꾸면 코드를 처음부터 끝까지 다 갈아엎어야 해서 지금 상황에선 절대 비추천이야!

2️⃣ Cloudflare WARP 쓰기 (초강력 추천 🌟🌟🌟🌟🌟)
원리: 클라우드플레어(Cloudflare) 워프는 아주 쉽고 빠르고 **무료인 VPN(비밀 터널)**이야.

왜 해결될까?: 이걸 켜면 원희 컴퓨터에서 나가는 5432 포트 요청을 'Cloudflare'라는 거대한 비밀 보따리에 꽁꽁 싸매서 학교 와이파이 공유기를 통과해. 공유기는 "어? 그냥 클라우드플레어 웹사이트 가는 트래픽이네? 통과!" 하고 속아 넘어가는 거지!

개이득 포인트: 제일 중요한 건, 우리가 어제 짠 스프링 부트 코드를 단 1글자도 수정할 필요가 없다는 거야!! 게다가 최근에 Supabase가 무료 버전에서 IPv4 지원을 중단해서 연결이 까다로워졌는데, WARP를 쓰면 이 문제까지 한 방에 해결돼.  

## 테스트 
파워셀은 잘 안 되어서 cmd로 함
<img width="1919" height="1007" alt="image" src="https://github.com/user-attachments/assets/988480ea-bbd1-47d4-b69f-2f787ffb6411" />

```
curl.exe -X POST http://localhost:8080/api/ingredients -H "Content-Type: application/json" -d "{\"name\": \"계란\", \"quantity\": 10, \"expirationDate\": \"2026-04-15\"}"
```

성공적으로 들어감

<img width="1919" height="998" alt="image" src="https://github.com/user-attachments/assets/afc74bb5-c4e3-418e-93fc-f5a7b3de9e75" />

## DTO(Data Transfer Object)를 사용해서 보안 올리기 
그러면 왜 써야 할까?  
DB에 있는 식재료 원본(Ingredient 엔티티)은 너무 소중해서 밖으로 함부로 내보내면 안 된다. 그래서 외부랑 데이터를 주고받을 때는 무조건 이 택배 상자(DTO)에 필요한 것만 딱 담아서 주고받는 거! (보안 + 깔끔함 상승!)  

IngredientRequestDto.java
```
package com.example.Naengbuhae.dto;

import com.example.Naengbuhae.domain.Ingredient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
public class IngredientRequestDto {

    // 외부에서 받을 데이터들만 딱 정의해 둬 (id는 DB가 알아서 넣을 거니까 안 받아도 됨!)
    private String name;
    private Integer quantity;
    private LocalDate expirationDate;

    // 편의 기능: "이 택배 상자(DTO)에 든 내용물을 실제 DB용 식재료(Entity)로 변환해 줘!"
    public Ingredient toEntity() {
        return new Ingredient(name, quantity, expirationDate);
    }
}
```
IngredientResponseDto.java
```
package com.example.Naengbuhae.dto;

import com.example.Naengbuhae.domain.Ingredient;
import lombok.Getter;
import java.time.LocalDate;

@Getter
public class IngredientResponseDto {
    private Long id;
    private String name;
    private Integer quantity;
    private LocalDate expirationDate;

    // 생성자: "DB에서 꺼낸 진짜 식재료(Entity)를 주면, 내가 택배 상자(DTO)에 예쁘게 옮겨 담을게!"
    public IngredientResponseDto(Ingredient ingredient) {
        this.id = ingredient.getId();
        this.name = ingredient.getName();
        this.quantity = ingredient.getQuantity();
        this.expirationDate = ingredient.getExpirationDate();
    }
}
```
IngredientService.java(변경)
```
package com.example.Naengbuhae.service;

import com.example.Naengbuhae.domain.Ingredient;
import com.example.Naengbuhae.dto.IngredientRequestDto;
import com.example.Naengbuhae.dto.IngredientResponseDto;
import com.example.Naengbuhae.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    // 1. 저장할 때: 원본 대신 '받는 택배 상자(RequestDto)'를 받음
    @Transactional
    public Long saveIngredient(IngredientRequestDto requestDto) {
        // 상자 내용물을 원본(Entity)으로 뜯어서 변환한 다음, DB 창고에 저장!
        return ingredientRepository.save(requestDto.toEntity()).getId();
    }

    // 2. 조회할 때: 원본 대신 '보내는 택배 상자(ResponseDto)' 리스트를 뱉음
    public List<IngredientResponseDto> findAllIngredients() {
        // DB 창고에서 원본들을 싹 꺼내온 다음, 하나하나 예쁜 택배 상자(DTO)에 옮겨 담아서(map) 반환!
        return ingredientRepository.findAll().stream()
                .map(IngredientResponseDto::new) // Ingredient 원본을 ResponseDto로 포장하는 마법의 코드
                .collect(Collectors.toList());
    }
}
```
IngredientController.java(변)
```
package com.example.Naengbuhae.controller;

import com.example.Naengbuhae.dto.IngredientRequestDto;
import com.example.Naengbuhae.dto.IngredientResponseDto;
import com.example.Naengbuhae.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredients")
@RequiredArgsConstructor
public class IngredientController {

    private final IngredientService ingredientService;

    // POST: 저장 요청이 오면 '받는 택배 상자(RequestDto)'로 안전하게 받기
    @PostMapping
    public Long create(@RequestBody IngredientRequestDto requestDto) {
        return ingredientService.saveIngredient(requestDto);
    }

    // GET: 전체 조회 요청이 오면 원본 말고 '보내는 택배 상자(ResponseDto)' 리스트로 안전하게 내보내기
    @GetMapping
    public List<IngredientResponseDto> list() {
        return ingredientService.findAllIngredients();
    }
}
```

<img width="1919" height="1012" alt="image" src="https://github.com/user-attachments/assets/a50bee7f-79cb-40b4-a153-65166135613e" />

## 결과 

<img width="1919" height="1013" alt="image" src="https://github.com/user-attachments/assets/a5dbbb5a-0b6b-4ac8-8d8a-43e4fffaf055" />

<img width="1919" height="1007" alt="image" src="https://github.com/user-attachments/assets/33dfc39e-44e5-4062-b7fb-ec75c05c4ca8" />

성공 

## 삭제하기 만들기 
IngredientService.java(수정)
```
// --- 3. 식재료 삭제 기능 ---
    @Transactional
    public void deleteIngredient(Long id) {
        // 창고지기한테 "이 번호표(id) 가진 식재료 찾아서 버려!" 라고 시킴
        ingredientRepository.deleteById(id);
    }
```

IngredientController.java(수정)
```
// --- API 3: 식재료 삭제하기 (DELETE 요청) ---
    // @DeleteMapping: 누군가 주소 뒤에 번호(id)를 달고 DELETE 요청을 보내면 실행됨
    // 예: /api/ingredients/1 (1번 지워줘!)
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        ingredientService.deleteIngredient(id);
        return id + "번 식재료가 냉장고에서 삭제되었습니다! 🗑️";
    }
```


<img width="1919" height="1008" alt="image" src="https://github.com/user-attachments/assets/ee6a2ac1-8616-4992-9a36-718f2638072d" />

```
curl.exe -X DELETE http://localhost:8080/api/ingredients/1
```

<img width="1919" height="1003" alt="image" src="https://github.com/user-attachments/assets/7007d057-7d33-4c64-b9a2-0bc06b8d8926" />

## 식재료 수정(Update) 기능 추가 

IngredientService.java
```
// --- 4. 식재료 수정 기능 (Update) ---
    // @Transactional이 여기서 진짜 중요한 마법을 부림!
    @Transactional
    public Long updateIngredient(Long id, IngredientRequestDto requestDto) {
        // 1. 창고에서 수정할 식재료를 번호(id)로 찾아온다. (없으면 에러 뱉음!)
        Ingredient ingredient = ingredientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 식재료가 없습니다. id=" + id));

        // 2. 찾아온 원본 식재료의 정보를 새 택배 상자(DTO)에 담긴 정보로 바꿔치기!
        ingredient.setName(requestDto.getName());
        ingredient.setQuantity(requestDto.getQuantity());
        ingredient.setExpirationDate(requestDto.getExpirationDate());

        // 3. 엥? 저장(save)을 안 하네?! 
        // 👉 맞음! 스프링 JPA의 '변경 감지' 마법 덕분에 값만 바꿔도 알아서 DB에 덮어씌워짐!
        return ingredient.getId();
    }
```

IngredientController.java
```
// --- API 4: 식재료 수정하기 (PUT 요청) ---
    // @PutMapping: 누군가 주소 뒤에 번호(id)를 달고 PUT(수정) 요청을 보내면 실행됨
    @PutMapping("/{id}")
    public Long update(@PathVariable Long id, @RequestBody IngredientRequestDto requestDto) {
        // 두뇌(Service)에게 "id번 식재료를 이 새 정보(requestDto)로 바꿔줘!" 라고 시킴
        return ingredientService.updateIngredient(id, requestDto);
    }
```

## 계란 10개 -> 8개로 줄여보기 테스트!

<img width="1919" height="1004" alt="image" src="https://github.com/user-attachments/assets/150c3bb3-9af1-4368-880c-a1bb591c0ab1" />

성공 

```
curl.exe -X PUT http://localhost:8080/api/ingredients/2 -H "Content-Type: application/json" -d "{\"name\": \"계란\", \"quantity\": 8, \"expirationDate\": \"2026-04-15\"}"
```

<img width="1919" height="1007" alt="image" src="https://github.com/user-attachments/assets/385d271d-b2dd-4292-9153-41f1fcb94d17" />

## 스웨거(Swagger) 

build.gradle  
dependencies { ... } 에 추가
```
// Swagger (springdoc-openapi)
    implementation 'org.springdoc:springdoc-openapi-starter-webmvc-ui:2.4.0'
```

<img width="400" height="201" alt="image" src="https://github.com/user-attachments/assets/79858825-803b-4fad-a991-4a8236d92141" />
코끼리 누르기   


## 레시피(Recipe) 도메인 1단계: 설계도 & 창고지기 만들기

Recipe.java 
```
package com.example.Naengbuhae.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title; // 요리 이름 (예: 계란말이)

    @Column(columnDefinition = "TEXT") 
    private String instructions; // 만드는 법 (글자가 길어질 수 있으니 TEXT 타입으로!)

    private Integer cookingTime; // 조리 시간(분 단위, 예: 15)

    // 레시피 생성자
    public Recipe(String title, String instructions, Integer cookingTime) {
        this.title = title;
        this.instructions = instructions;
        this.cookingTime = cookingTime;
    }
}
```
RecipeRepository.java
```
package com.example.Naengbuhae.repository;

import com.example.Naengbuhae.domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
```

## 레시피 전용 택배 상자(DTO) 2개랑, 두뇌(Service), 안내 데스크(Controller) 코드

RecipeRequestDto.java
```
package com.example.Naengbuhae.dto;

import com.example.Naengbuhae.domain.Recipe;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class RecipeRequestDto {

    private String title;
    private String instructions;
    private Integer cookingTime;

    // DTO를 DB용 엔티티로 찰떡 변환!
    public Recipe toEntity() {
        return new Recipe(title, instructions, cookingTime);
    }
}
```

RecipeResponseDto.java
```
package com.example.Naengbuhae.dto;

import com.example.Naengbuhae.domain.Recipe;
import lombok.Getter;

@Getter
public class RecipeResponseDto {

    private Long id;
    private String title;
    private String instructions;
    private Integer cookingTime;

    // DB에서 꺼낸 엔티티를 이 DTO 상자에 예쁘게 포장!
    public RecipeResponseDto(Recipe recipe) {
        this.id = recipe.getId();
        this.title = recipe.getTitle();
        this.instructions = recipe.getInstructions();
        this.cookingTime = recipe.getCookingTime();
    }
}
```

RecipeService.java
```
package com.example.Naengbuhae.service;

import com.example.Naengbuhae.domain.Recipe;
import com.example.Naengbuhae.dto.RecipeRequestDto;
import com.example.Naengbuhae.dto.RecipeResponseDto;
import com.example.Naengbuhae.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;

    // 1. 레시피 저장 (Create)
    @Transactional
    public Long saveRecipe(RecipeRequestDto requestDto) {
        return recipeRepository.save(requestDto.toEntity()).getId();
    }

    // 2. 레시피 전체 조회 (Read)
    public List<RecipeResponseDto> findAllRecipes() {
        return recipeRepository.findAll().stream()
                .map(RecipeResponseDto::new)
                .collect(Collectors.toList());
    }
    
    // (일단 가장 기본이 되는 등록/조회만 뚫어둘게! 수정/삭제는 나중에 필요하면 추가!)
}
```

RecipeController.java
```
package com.example.Naengbuhae.controller;

import com.example.Naengbuhae.dto.RecipeRequestDto;
import com.example.Naengbuhae.dto.RecipeResponseDto;
import com.example.Naengbuhae.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// 주의: 주소가 이번엔 /api/recipes 야!
@RequestMapping("/api/recipes")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    // POST: 레시피 등록 API
    @PostMapping
    public Long create(@RequestBody RecipeRequestDto requestDto) {
        return recipeService.saveRecipe(requestDto);
    }

    // GET: 레시피 전체 조회 API
    @GetMapping
    public List<RecipeResponseDto> list() {
        return recipeService.findAllRecipes();
    }
}
```

## 테스트 

이제 터미널에서 까만 화면 보면서 curl 칠 필요 없어! 아까 우리가 달아둔 스웨거 메뉴판으로 가서 바로 테스트해 보자.

1. 크롬에서 http://localhost:8080/swagger-ui/index.html 새로고침!
2. 화면에 ingredient-controller 밑에 새로 생긴 recipe-controller 메뉴가 짠! 하고 나타난 걸 확인해.
3. 초록색 POST /api/recipes 누르고 [Try it out] 클릭!
4. 데이터 칸(Request body)에 요리 이름(title), 만드는 법(instructions), 조리 시간(cookingTime) 적당히 입력하고 [Execute] 파란 버튼 클릭!
5. 밑에 응답 결과(Response body)에 숫자 **1**이 딱 떨어지면 완벽하게 성공한 거야.

<img width="1919" height="1007" alt="image" src="https://github.com/user-attachments/assets/d9b0b942-b6ab-499c-9e92-0b324ce5f8a8" />

## 지금까지 한 거 정리 
```
📦 Naengbuhae (스마트 냉장고 관리 백엔드)
 ┣ 📂 src/main/java/com/example/Naengbuhae
 │ ┣ 📂 controller       # 클라이언트의 요청을 받고 응답하는 안내 데스크
 │ │ ┣ 📜 IngredientController.java
 │ │ ┗ 📜 RecipeController.java
 │ │
 │ ┣ 📂 domain           # DB 테이블과 직접 연결되는 설계도 (Entity)
 │ │ ┣ 📜 Ingredient.java
 │ │ ┗ 📜 Recipe.java
 │ │
 │ ┣ 📂 dto              # 계층 간 데이터를 안전하게 주고받는 택배 상자
 │ │ ┣ 📜 IngredientRequestDto.java
 │ │ ┣ 📜 IngredientResponseDto.java
 │ │ ┣ 📜 RecipeRequestDto.java
 │ │ ┗ 📜 RecipeResponseDto.java
 │ │
 │ ┣ 📂 repository       # DB 창고에 접근해서 데이터를 넣고 빼는 창고지기
 │ │ ┣ 📜 IngredientRepository.java
 │ │ ┗ 📜 RecipeRepository.java
 │ │
 │ ┗ 📂 service          # 핵심 비즈니스 로직을 처리하는 두뇌
 │   ┣ 📜 IngredientService.java
 │   ┗ 📜 RecipeService.java
 │
 ┗ 📜 build.gradle       # 외부 라이브러리(Swagger 등) 의존성 관리
```
본 프로젝트는 엔티티(Entity)의 외부 노출을 막고 보안과 유연성을 높이기 위해, Controller와 Service 계층 간의 데이터 통신에 DTO(Data Transfer Object) 패턴을 적극적으로 도입하여 설계했습니다. 

DTO의 특징
- 데이터 전달 전용: 비즈니스 로직을 담지 않고, 오직 데이터만 담습니다.
- 보안성 강화: 엔티티를 그대로 노출하면 민감한 정보까지 외부에 드러날 수 있는데, DTO는 필요한 필드만 선택적으로 담아 전달합니다.
- 유연성 확보: 엔티티 구조가 바뀌더라도 DTO를 통해 외부 API나 클라이언트와의 계약을 안정적으로 유지할 수 있습니다.
- 변환 용이: 엔티티 ↔ DTO 간 변환을 통해 원하는 형태로 데이터를 가공할 수 있습니다.


## 코드 통합하기

com vs org, 뭐가 더 좋을까?
무조건 com으로 통일하는 걸 추천해! 1. 대세는 com: 졸업 프로젝트로 끝나는 게 아니라 나중에 앱이나 웹 서비스로 출시한다고 생각했을 때, 대부분의 스타트업이나 상용 서비스는 com을 표준으로 써.

JwtUtil.java,build.gradle,UserController.java,SecurityConfig.java등 바꾸고 .env파일 추

🛠️ 스웨거(메뉴판) '프리패스' 등록하기
config 폴더에 있는 SecurityConfig.java 파일을 열어서, .authorizeHttpRequests 부분을 아래처럼 살짝만 바꿔줘! 스웨거 관련 주소들을 프리패스(permitAll) 명단에 추가하는 거야.

[수정 전]
```
.authorizeHttpRequests(auth -> auth
                .requestMatchers("/user/signup", "/user/login").permitAll()
                .anyRequest().authenticated()
        )
```
[수정 후]
```
.authorizeHttpRequests(auth -> auth
                // 로그인, 회원가입 + 스웨거 관련 주소는 신분증 없이 프리패스!
                .requestMatchers(
                        "/user/signup", 
                        "/user/login",
                        "/swagger-ui/**", 
                        "/v3/api-docs/**", 
                        "/swagger-resources/**"
                ).permitAll()
                .anyRequest().authenticated() // 나머지는 다 신분증(JWT) 검사해!
        )
```



🚨 근데 잠깐! 스웨거에 '자물쇠'가 없네?!

이게 무슨 말이냐면, 로그인을 해서 'JWT 출입증'을 발급받아도, 지금 이 스웨거 메뉴판에는 그 출입증을 문지기한테 보여줄 구멍이 안 뚫려 있다는 뜻이야. 이대로 /api/ingredients에 재료를 추가하려고 하면 출입증을 못 내밀어서 또 403 거절을 당하게 돼!

스웨거한테 "우리 이제 출입증 검사하는 기능 생겼으니까, 출입증 넣는 버튼 좀 만들어줘!"라고 알려주는 설정 파일 추가 

스웨거 자물쇠(Authorize) 버튼 달아주기
```
package com.example.Naengbuhae.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        String jwtSchemeName = "JWT";
        
        // 1. 스웨거한테 "우리는 JWT라는 이름의 Bearer 토큰을 쓴다"고 알려주기
        SecurityRequirement securityRequirement = new SecurityRequirement().addList(jwtSchemeName);
        Components components = new Components()
                .addSecuritySchemes(jwtSchemeName, new SecurityScheme()
                        .name(jwtSchemeName)
                        .type(SecurityScheme.Type.HTTP) // HTTP 방식
                        .scheme("bearer") // Bearer 토큰 방식
                        .bearerFormat("JWT")); // 토큰 형식은 JWT

        return new OpenAPI()
                .addSecurityItem(securityRequirement)
                .components(components);
    }
}
```

## 프로젝트 구조 
```
📦 Naengbuhae (스마트 냉장고 관리 백엔드)
┣ 📂 src/main/java/com/example/Naengbuhae
┃ ┣ 📂 config       # 🛡️ 문지기 & 도구함: CORS, JWT, 시큐리티, 스웨거 등 각종 설정 파일들
┃ ┃ ┣ 📜 CorsConfig.java
┃ ┃ ┣ 📜 JwtAuthenticationFilter.java
┃ ┃ ┣ 📜 JwtUtil.java
┃ ┃ ┣ 📜 SecurityConfig.java
┃ ┃ ┗ 📜 SwaggerConfig.java
┃ ┣ 📂 controller   # 🛎️ 안내데스크: 프론트엔드의 요청을 받고 응답을 보내는 API 창구
┃ ┃ ┣ 📜 IngredientController.java
┃ ┃ ┗ 📜 RecipeController.java
┃ ┣ 📂 domain       # 🗄️ 데이터 설계도: DB 테이블과 똑같이 생긴 자바 객체(Entity)들
┃ ┃ ┣ 📜 Ingredient.java
┃ ┃ ┗ 📜 Recipe.java
┃ ┣ 📂 dto          # 🚚 택배 상자: 클라이언트와 서버 간에 데이터를 주고받을 때 쓰는 포장지
┃ ┃ ┣ 📜 IngredientRequestDto.java
┃ ┃ ┣ 📜 IngredientResponseDto.java
┃ ┃ ┣ 📜 RecipeRequestDto.java
┃ ┃ ┗ 📜 RecipeResponseDto.java
┃ ┣ 📂 repository   # 💾 창고 관리인: DB에 직접 접근해서 데이터를 저장, 조회, 삭제하는 역할
┃ ┃ ┣ 📜 IngredientRepository.java
┃ ┃ ┗ 📜 RecipeRepository.java
┃ ┣ 📂 service      # 👨‍🍳 요리사: 컨트롤러가 넘겨준 데이터로 실제 비즈니스 로직을 처리하는 곳
┃ ┃ ┣ 📜 IngredientService.java
┃ ┃ ┗ 📜 RecipeService.java
┃ ┗ 📂 user         # 👤 회원 전용관: 회원가입, 로그인 등 유저 관련 기능이 모여있는 곳
┃   ┣ 📜 ApiResponse.java
┃   ┣ 📜 LoginRequest.java
┃   ┣ 📜 LoginResponse.java
┃   ┣ 📜 SignupRequest.java
┃   ┣ 📜 User.java
┃   ┣ 📜 UserController.java
┃   ┣ 📜 UserRepository.java
┃   ┗ 📜 UserService.java
┣ 📂 src/main/resources
┃ ┣ 📜 application.properties  # ⚙️ 앱 핵심 설정: DB 주소, 포트 번호 등 프로젝트 전반의 환경설정
┃ ┣ 📂 static                  # 🖼️ 정적 파일 보관: 이미지, CSS 등 (React 연동으로 현재 비어있음)
┃ ┗ 📂 templates               # 📄 HTML 보관: 서버 사이드 렌더링 화면 (현재 비어있음)
┣ 📂 src/test                  # 🧪 실험실: 작성한 코드가 잘 돌아가는지 테스트하는 곳
┃ ┗ 📜 NaengbuhaeApplicationTests.java
┣ 📜 .env                      # 🤫 1급 비밀: JWT 시크릿 키 등을 숨겨두는 곳 (깃허브 업로드 절대 금지!)
┣ 📜 build.gradle              # 🐘 부품 주문서: 스프링 부트 버전 및 프로젝트에 필요한 외부 라이브러리 목록
┗ 📜 settings.gradle           # 🏷️ 프로젝트 이름 설정
```

## 식재료 유효성 검사 및 전역 예외 처리 적용 완료
IngredientController.java
```
package com.example.Naengbuhae.controller;

import com.example.Naengbuhae.dto.IngredientRequestDto;
import com.example.Naengbuhae.dto.IngredientResponseDto;
import com.example.Naengbuhae.service.IngredientService;
import jakarta.validation.Valid; // 방어막 부품 딱 하나만 추가 임포트!
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredients")
@RequiredArgsConstructor
public class IngredientController {

    private final IngredientService ingredientService;

    // POST: 저장 요청이 오면 '받는 택배 상자(RequestDto)'로 안전하게 받기
    // @RequestBody 앞에 @Valid 방어막 추가!
    @PostMapping
    public Long create(@Valid @RequestBody IngredientRequestDto requestDto) {
        return ingredientService.saveIngredient(requestDto);
    }

    // GET: 전체 조회 요청이 오면 원본 말고 '보내는 택배 상자(ResponseDto)' 리스트로 안전하게 내보내기
    @GetMapping
    public List<IngredientResponseDto> list() {
        return ingredientService.findAllIngredients();
    }

    // --- API 3: 식재료 삭제하기 (DELETE 요청) ---
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        ingredientService.deleteIngredient(id);
        return id + "번 식재료가 냉장고에서 삭제되었습니다! 🗑️";
    }

    // --- API 4: 식재료 수정하기 (PUT 요청) ---
    //  수정할 때도 이상한 값 들어오면 안 되니까 여기도 @Valid 방어막 추가!
    @PutMapping("/{id}")
    public Long update(@PathVariable Long id, @Valid @RequestBody IngredientRequestDto requestDto) {
        // 두뇌(Service)에게 "id번 식재료를 이 새 정보(requestDto)로 바꿔줘!" 라고 시킴
        return ingredientService.updateIngredient(id, requestDto);
    }
}
```
IngredientRequestDto.java
```
package com.example.Naengbuhae.dto;

import com.example.Naengbuhae.domain.Ingredient;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class IngredientRequestDto {

    @NotBlank(message = "식재료 이름은 필수입니다!")
    private String name;

    @NotNull(message = "수량은 필수 입력값입니다!")
    @Min(value = 1, message = "수량은 최소 1개 이상이어야 합니다!")
    private Integer quantity;

    @NotNull(message = "유통기한은 필수 입력값입니다!")
    @FutureOrPresent(message = "유통기한은 오늘 또는 미래의 날짜여야 합니다!")
    private LocalDate expirationDate;

    // 편의 기능: "이 택배 상자(DTO)에 든 내용물을 실제 DB용 식재료(Entity)로 변환해 줘!"
    public Ingredient toEntity() {
        return new Ingredient(name, quantity, expirationDate);
    }
}
```
build.gradle
```
// 유효성 검사 (Validation) 방어막 추가!
    implementation 'org.springframework.boot:spring-boot-starter-validation'
```

SecurityConfig.java(이 부분은 BCrypt,JWT 검증이 아직 구현이 안 되어서 임의로 뚫음..)
```
package com.example.Naengbuhae.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; // 추가: 비밀번호 암호화 클래스
import org.springframework.security.crypto.password.PasswordEncoder; // 추가: 암호화 인터페이스
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    // 암호화 빈(Bean)! 서버 에러 방지용!
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception { // 주의: http.build() 때문에 throws Exception이 있어야 해!
        http
                .cors(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable())
                .formLogin(form -> form.disable())
                .httpBasic(basic -> basic.disable())
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authorizeHttpRequests(auth -> auth // 이 코드 수정 이유는 스웨거(Swagger) 메뉴판이랑 호환이 안 되어서..
                        // 로그인, 회원가입 + 스웨거 관련 주소는 신분증 없이 프리패스!
                        .requestMatchers(
                                "/user/signup",
                                "/user/login",
                                "/swagger-ui/**",
                                "/v3/api-docs/**",
                                "/swagger-resources/**",
                                "/api/ingredients", // 테스트를 위해 임시로 만든 통로2
                                "/api/ingredients/**",// 테스트를 위해 임시로 만든 통로
                                "/error" //에러를 출력하기 위한
                        ).permitAll()
                        .anyRequest().authenticated() // 나머지는 다 신분증(JWT) 검사해!
                );
                //.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
```
GlobalExceptionHandler.java(new)
```
package com.example.Naengbuhae.exception;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 스프링부트는 정책상 에러가 나도 보여주지 않는데 예외처리를 하므로 인해서 에러를 보여준다
@Hidden // 스웨거 투명 망토 (스웨거가 이 파일을 무시하게 만듦)
@RestControllerAdvice
public class GlobalExceptionHandler {

    // @Valid 방어막에 걸려서 튕겨났을 때 발생하는 에러만 쏙 낚아챔!
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {

        // DTO에 적어둔 예쁜 에러 메시지("수량은 최소 1개 이상이어야 합니다!") 추출하기
        String errorMessage = ex.getBindingResult()
                .getAllErrors()
                .get(0)
                .getDefaultMessage();

        // 까만 창에 400 Bad Request와 함께 메시지를 뱉어줌!
        return ResponseEntity.badRequest().body(errorMessage);
    }
}
```

## 지금까지 한 거 파일 구조 

```
Naengbuhae
 ┣ 📂 src/main/java/com/example/Naengbuhae
 ┃ ┣ 📂 config                  // 🛡️ 보안 및 각종 설정 담당
 ┃ ┃ ┣ 📜 SecurityConfig.java         // 보안 규칙, 프리패스 설정 (수정 중)
 ┃ ┃ ┗ 📜 JwtAuthenticationFilter.java // 출입증 검사기 (앞으로 완성할 곳!)
 ┃ ┣ 📂 controller              // 🚪 클라이언트의 요청을 받는 문
 ┃ ┃ ┣ 📜 IngredientController.java
 ┃ ┃ ┣ 📜 RecipeController.java
 ┃ ┃ ┗ 📜 UserController.java         // 회원가입, 로그인 요청을 받는 곳
 ┃ ┣ 📂 domain                  // 📦 실제 DB 테이블과 매핑되는 핵심 데이터 (엔티티)
 ┃ ┃ ┣ 📜 Ingredient.java
 ┃ ┃ ┗ 📜 User.java                   // 유저 정보 (비밀번호가 저장될 곳)
 ┃ ┣ 📂 dto                     // 🚚 데이터를 실어 나르는 택배 상자
 ┃ ┃ ┣ 📜 IngredientRequestDto.java
 ┃ ┃ ┣ 📜 IngredientResponseDto.java
 ┃ ┃ ┗ ... (유저 관련 DTO들)
 ┃ ┣ 📂 exception               // 🚨 에러 처리 전담반
 ┃ ┃ ┗ 📜 GlobalExceptionHandler.java // 아까 만든 예쁜 에러 배달부
 ┃ ┣ 📂 repository              // 🗄️ DB에 직접 접근해서 데이터를 넣고 빼는 창고 관리자
 ┃ ┃ ┗ 📜 UserRepository.java
 ┃ ┣ 📂 service                 // 🧠 실제 비즈니스 로직(계산, 검증)을 처리하는 두뇌
 ┃ ┃ ┣ 📜 IngredientService.java
 ┃ ┃ ┗ 📜 UserService.java            // 비밀번호를 암호화하고 로그인을 처리할 곳 (앞으로 완성할 곳!)
 ┃ ┗ 📜 NaengbuhaeApplication.java  // 🚀 스프링 부트 서버 실행의 심장
 ┃
 ┣ 📂 src/main/resources
 ┃ ┣ 📜 application.yml (또는 properties) // DB 연결 및 프로젝트 환경 설정
 ┃ ┗ 📜 .env                          // JWT 시크릿 키 등 비밀 정보 숨겨둔 곳
 ┗ 📜 build.gradle                  // 🐘 외부 부품(라이브러리) 명세서
```

### 프론트랑 백엔드 로그인 확인 
SecurityConfig.java (코드 추가)
```
// ... 기존 코드들 ...
    import org.springframework.web.cors.CorsConfiguration;
    import org.springframework.web.cors.CorsConfigurationSource;
    import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
    import java.util.List;

    // (클래스 맨 밑쪽에 추가!)
    // 🛡️ CORS 에러 방어막: "우리 프론트엔드가 보내는 요청은 다 받아줘!"
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        // 🚨 프론트엔드가 켜진 포트 번호(보통 3000 또는 5173)를 적어줘야 해!
        configuration.setAllowedOrigins(List.of("http://localhost:3000", "http://localhost:5173")); 
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(true); // JWT 토큰을 주고받으려면 이거 꼭 true여야 해!

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration); // 모든 주소(/**)에 이 규칙을 적용!
        return source;
    }
}
```

프론트 코드 다운을 받고 폴더를 이동시킨 뒤에 

```
npm install
```
위 명령어로 필요한 파일을 다운
```
npm run dev
```
위 명령어로 실행 

<img width="1190" height="492" alt="image" src="https://github.com/user-attachments/assets/4326637b-43bf-428f-8b2a-e01240f20a3b" />

로그인 기능은 정상적으로 작동됨

### 식재료-유저 연관관계 매핑 및 개인 냉장고 데이터 격리 로직 구현

총 5개의 파일이 변경  
주요 변경 내용은 "누가 이 식재료를 넣었는가"를 기록하고, "내 데이터만 관리"하도록 보안 로직을 강화한 것

  1. Ingredient.java (엔티티 수정)
   * 변경 사항: User 객체와의 연관 관계(@ManyToOne)를 추가
   * 이유: 식재료 데이터가 저장될 때 DB에 user_id를 함께 저장하여 소유자를 구분하기 위함

  2. IngredientRepository.java (조회 메서드 추가)
   * 변경 사항: List<Ingredient> findByUser(User user) 메서드를 추가
   * 이유: 기존에는 findAll()로 모든 데이터를 가져왔으나, 이제는 특정 사용자의 것만 골라오기 위한 기능이 필요해졌기 때문

  3. IngredientRequestDto.java (데이터 변환 로직 수정)
   * 변경 사항: toEntity() 메서드가 User 객체를 인자로 받도록 수정
   * 이유: DTO를 실제 DB 저장용 객체(Entity)로 바꿀 때, 현재 로그인한 사용자 정보를 함께 넣어서 생성하기 위함

  4. IngredientService.java (핵심 비즈니스 로직 수정)
   * 저장: 로그인한 사용자의 ID를 찾아 식재료와 연결해 저장
   * 조회: 전체 조회가 아닌 findByUser를 호출하여 내 냉장고 데이터만 가져옴
   * 수정/삭제: if (!ingredient.getUser().getUsername().equals(username)) 로직을 추가, 다른 사람이 내 식재료를 지우거나 바꾸지 못하도록 본인 확인 절차를 넣음

  5. IngredientController.java (API 입구 수정)
   * 변경 사항: 모든 메서드에 Principal principal 파라미터를 추가
   * 이유: Spring Security가 제공하는 Principal 객체를 통해 현재 어떤 사용자가 로그인 중인지(토큰 주인)를 확인하고, 그 이름을 서비스 계층으로 넘겨주기 위함

밑의 사진은 데이터 유저를 찾아서 성공적으로 들어간 것
<img width="1276" height="365" alt="image" src="https://github.com/user-attachments/assets/9249d120-f549-4728-abdb-6faf6b0e8c8c" />

### 레시피-유저 연관관계 매핑 및 개인 데이터 격리 로직 추가 

📝 변경 내용 및 핵심 로직 요약

   1. Recipe.java (Entity): User와의 @ManyToOne 관계를 맺고, user_id 외래키 컬럼을 추가, 생성자도 유저 정보를 포함하도록 업데이트
   2. RecipeRepository.java: findByUser(User user)를 추가하여, DB에서 특정 사용자의 레시피만 골라올 수 있도록 했음
   3. RecipeRequestDto.java: toEntity(User user) 메서드로 수정하여, DTO를 엔티티로 바꿀 때 작성자 정보를 함께 넣을 수 있게 했음
   4. RecipeService.java:
       * 저장/조회: 로그인한 유저 정보를 찾아 연결하거나 필터링
       * 수정/삭제: recipe.getUser().getUsername().equals(username) 로직을 통해 본인이 작성한 레시피가 아닐 경우 에러를 던지도록 권한 체크를 강화
   5. RecipeController.java: Principal 객체를 사용해 토큰에 담긴 사용자 이름을 가져오고, 모든 API에서 이를 서비스로 전달하여 기능을 완성

밑에 있는 이미지는 데이터베이스에 제대로 들어가는지 확인된 거
<img width="1194" height="164" alt="image" src="https://github.com/user-attachments/assets/7f028163-1f11-45d2-8b08-fb5957a5c0a2" />


### 🔐 [기능 구현] 스프링 시큐리티 기반 유저 역할(Role) 시스템 도입

관리자 전용 기능(데이터 관리, 모니터링 등)을 확장하기 위해, Spring Security와 JWT를 활용한 권한(Authorization) 검증 기초 뼈대를 구축했습니다.

#### 📄 1. 신규 추가 및 변경된 파일 내역
* **`[추가]` UserRole.java (Enum):** * 사용자의 권한을 명확히 구분하기 위해 `USER("ROLE_USER")`, `ADMIN("ROLE_ADMIN")` 두 가지 상태를 정의했습니다.
* **`[수정]` User.java (Entity):** * DB 테이블에 권한을 저장할 `role` 필드를 추가하고, String 형태로 저장되도록 `@Enumerated(EnumType.STRING)`을 적용했습니다.
* **`[수정]` UserService.java:** * 회원가입 시 기본적으로 `USER` 권한을 부여하도록 로직을 수정했습니다. (단, 개발 테스트를 위해 `admin` 아이디로 가입 시 `ADMIN` 권한을 부여하는 임시 백도어 적용)
* **`[수정]` JwtUtil.java & UserController.java:** * 로그인 완료 후 JWT 토큰을 발급할 때, Payload 내부에 해당 유저의 권한(Role) 정보를 함께 암호화하여 담도록 수정했습니다.
* **`[수정]` JwtAuthenticationFilter.java:** * 클라이언트가 API를 요청할 때 전달한 토큰에서 Role 정보를 추출하여, Spring Security의 `Authentication` 객체에 실제 권한(`SimpleGrantedAuthority`)으로 주입하도록 필터 단을 보완했습니다.

---

#### 🚨 2. 현재 코드의 문제점 (Known Issue) 및 향후 개선 과제

**[문제점] 개발용 임시 백도어(Backdoor)로 인한 보안 취약점**
현재 `UserService`의 회원가입 로직에는 원활한 관리자 기능 테스트를 위해 아래와 같은 하드코딩된 조건문이 삽입되어 있습니다.
```java
if (username.equals("admin")) {
    role = UserRole.ADMIN;
}
```
이는 누구나 admin이라는 아이디로 가입하기만 하면 즉시 최고 관리자 권한을 획득할 수 있는 치명적인 보안 헛점입니다. 실제 상용 서비스에 배포될 경우 악의적인 공격자에 의해 시스템 전체가 제어될 위험이 있습니다.

#### [해결 방안 및 Next Step]
이러한 기술 부채(Tech Debt)를 해결하기 위해, 최종 배포(프로덕션) 전까지 다음 단계 중 하나로 로직을 개선할 예정입니다.

임시 로직 삭제: 해당 if문을 완전히 제거하여 일반 가입 경로로는 절대 ADMIN 권한을 얻을 수 없도록 원천 차단합니다.

초기 관리자 주입: 서비스 런칭 시 DB 초기화 스크립트(data.sql 등)를 통해 매우 복잡한 패스워드를 가진 '최초 슈퍼 관리자' 계정을 단 1개만 수동으로 생성합니다.

권한 승급 기능: 최초 관리자가 사내 시스템에 로그인하여 일반 유저의 권한을 관리자(ADMIN)로 변경해 주는 별도의 승급 API를 개발합니다.


### 🔐 [기능 구현] 관리자(Admin) 권한 시스템 및 전용 API 구축

서비스 운영 및 보안 강화를 위해 Spring Security와 JWT를 활용한 **역할 기반 접근 제어(RBAC, Role-Based Access Control)** 시스템을 설계하고 관리자 전용 기능을 구현했습니다.

#### 📄 1. 주요 변경 및 추가 파일
* **`AdminController.java` (신규):** 관리자 전용 엔드포인트를 분리하여 유지보수성을 높였습니다. (`/admin/**`)
* **`UserResponseDto.java` (신규):** 민감 정보(비밀번호 등) 유출을 방지하기 위해 사용자 정보 반환 전용 객체를 도입했습니다.
* **`UserRole.java` (Enum):** `USER`, `ADMIN` 권한 체계를 정의했습니다.
* **`SecurityConfig.java`:** * `@EnableMethodSecurity`를 활성화하여 메서드 단위의 세밀한 권한 제어를 가능하게 했습니다.
  * 로그인/회원가입 등 공용 API와 스웨거(Swagger) 주소에 대한 접근 권한을 최적화했습니다.
* **`JwtAuthenticationFilter.java` & `JwtUtil.java`:** * JWT 토큰 내에 사용자의 권한 정보(`auth` claim)를 포함하여 발급하고, 요청 시 이를 검증하여 인증 객체에 주입하는 로직을 완성했습니다.

#### 🛠️ 2. 구현 기능: 전체 유저 목록 조회 (Admin Only)
* **Endpoint:** `GET /admin/users`
* **Security:** `@PreAuthorize("hasRole('ADMIN')")` 적용
* **설계 특징:** * 일반 사용자가 해당 API 호출 시 `403 Forbidden` 에러를 반환하며 접근을 차단합니다.
  * 관리자 계정으로 로그인하여 발급받은 유효한 토큰이 있어야만 데이터 조회가 가능합니다.
  * `UserResponseDto`를 사용하여 DB 엔티티가 직접 노출되는 것을 방지하고 필요한 정보(`id`, `username`, `role`)만 안전하게 반환합니다.

#### ⚠️ 3. 보안 취약점 및 기술 부채 관리 (Known Issues)
현재 개발 및 테스트 편의를 위해 아래와 같은 임시 로직이 포함되어 있으며, 배포 전 개선이 필요함을 인지하고 관리하고 있습니다.

* **관리자 계정 생성 백도어:** `username`이 `"admin"`인 경우 자동으로 `ADMIN` 권한을 부여하는 로직이 `UserService`에 포함되어 있습니다.
* **해결 방안:** 향후 시스템 런칭 시 해당 로직을 제거하고, DB 초기화 스크립트 또는 별도의 관리자 승급 시스템을 통해 권한을 관리할 예정입니다.

---

#### 💡 검증 완료 내역
1. **JWT Payload 검증:** 발급된 토큰 내 권한 정보(`auth: ADMIN`) 포함 여부 확인.
2. **권한별 접근 테스트:** * `ADMIN` 권한 유저: 전체 유저 목록 조회 성공 (`200 OK`)
   * `USER` 권한 유저: 접근 차단 확인 (`403 Forbidden`)
3. **인증 예외 경로 확인:** 토큰 없이 로그인/회원가입/스웨거 페이지 접근 정상 작동 확인.

<img width="512" height="232" alt="image" src="https://github.com/user-attachments/assets/f3da7d51-5f19-47ff-9f81-4c09671f23e2" />

<img width="512" height="301" alt="image" src="https://github.com/user-attachments/assets/def0942d-e16f-4a11-9c1c-326fe465ee7d" />

<img width="512" height="255" alt="image" src="https://github.com/user-attachments/assets/cac2378e-d794-4631-bef2-9194979a72e1" />


### 🗑️ [기능 구현] 관리자 전용 레시피 강제 삭제 기능

부적절하거나 운영 정책에 위배되는 콘텐츠를 신속하게 관리하기 위해, 일반 유저의 권한을 상회하는 **관리자 전용 강제 삭제 API**를 추가 구현했습니다.

#### 📄 1. 주요 변경 및 추가 사항
* **`AdminController.java`:** `DELETE /admin/recipes/{recipeId}` 엔드포인트를 추가하여 관리자 전용 명령 통로를 확장했습니다.
* **`RecipeService.java`:** * `deleteRecipeByAdmin(Long id)` 메서드를 신설했습니다.
  * 기존 일반 삭제 로직과 달리 **작성자 본인 확인 절차(Ownership Check)를 생략**하고, 관리자의 권한으로 DB에서 데이터를 즉각 삭제하는 비즈니스 로직을 구축했습니다.
  * `@Transactional` 어노테이션을 적용하여 삭제 과정 중 발생할 수 있는 데이터 무결성 오류에 대비했습니다.

#### 🛠️ 2. 보안 및 설계 전략
* **권한 분리(Decoupling):** 일반 유저의 삭제 요청과 관리자의 강제 삭제 요청을 서비스 계층에서 별도의 메서드로 분리하여, 로직의 복잡도를 낮추고 사이드 이펙트를 최소화했습니다.
* **RBAC 보안 강화:** 컨트롤러 계층에서 `@PreAuthorize("hasRole('ADMIN')")`를 통해 2차 검증을 수행함으로써, 비인가된 사용자의 접근을 원천 차단했습니다.

#### 💡 검증 완료 내역
1. **DB 정합성 확인:** 관리자 API 호출 후 Supabase DB에서 해당 레시피 데이터가 즉시 삭제됨을 확인했습니다.
2. **응답 메시지 검증:** 삭제 성공 시 "O번 레시피가 관리자에 의해 강제 삭제되었습니다."라는 명확한 메시지를 반환하여 운영 편의성을 높였습니다.
3. **접근 제어 테스트:** * `ADMIN` 토큰 사용 시: 삭제 성공 (`200 OK`)
   * 일반 `USER` 토큰 사용 시: 접근 거부 (`403 Forbidden`)


<img width="1060" height="250" alt="image" src="https://github.com/user-attachments/assets/b46881fa-5efe-44ef-b346-16cd5724f926" />

<img width="1061" height="532" alt="image" src="https://github.com/user-attachments/assets/35bb259d-6011-486b-8cfa-c0f279f4241f" />


### 🔎 [기능 구현] 관리자 전용 전체 레시피 조회 (모니터링)

서비스 내에 등록된 모든 레시피 콘텐츠를 통합적으로 모니터링하고 관리하기 위해, 사용자 필터링이 배제된 **관리자 전용 전체 조회 API**를 구현했습니다.

#### 📄 1. 주요 변경 및 추가 사항
* **`AdminController.java`:** `GET /admin/recipes` 엔드포인트를 추가하여 관리자 전용 데이터 접근 경로를 분리했습니다.
* **`RecipeService.java`:** * `getAllRecipesByAdmin()` 메서드를 신설하여, 본인 작성 여부와 관계없이 DB 내 모든 레시피(`findAll()`)를 조회하도록 로직을 구성했습니다.
* **`RecipeResponseDto.java`:** * 레시피 반환 데이터에 **작성자 식별 정보(`username`)** 필드를 추가했습니다. 이를 통해 관리자 대시보드에서 각 콘텐츠의 출처(작성자)를 직관적으로 파악할 수 있도록 개선했습니다.

#### 🛠️ 2. 보안 및 설계 전략
* **데이터 무결성 유지:** 관리자용 조회 로직을 독립된 서비스 메서드로 분리하여, 기존 일반 유저의 '내 레시피 조회' 기능 로직과 섞이거나 충돌하지 않도록 안전하게 격리했습니다.
* **보안 계층 강화:** `@PreAuthorize("hasRole('ADMIN')")` 어노테이션을 적용하여 마스터키(ADMIN 토큰)가 없는 사용자의 무단 데이터 크롤링 및 접근을 완벽하게 차단했습니다.

#### 💡 검증 완료 내역
1. **데이터 통합 조회:** 타겟 유저(예: `test`)가 작성한 레시피 데이터가 `admin` 계정의 요청 시에도 정상적으로 반환됨을 확인했습니다.
2. **DTO 매핑 검증:** 응답 JSON에 `username` 속성이 정상적으로 포함되어 렌더링됨을 확인했습니다 (`HTTP 200 OK`).

<img width="1425" height="315" alt="image" src="https://github.com/user-attachments/assets/7b3602aa-08fc-423e-8c7a-29576fe421e0" />

<img width="1397" height="475" alt="image" src="https://github.com/user-attachments/assets/0b1c8801-9100-472e-8ccb-684f80035547" />


### 📊 [기능 구현] 관리자 전용 시스템 통계 대시보드 API

서비스의 전반적인 활성도를 한눈에 파악하고 운영 지표로 활용하기 위해, 전체 시스템의 주요 데이터 개수를 통합하여 제공하는 **통계 대시보드 API**를 구현했습니다.

#### 📄 1. 주요 구현 사항
* **`SystemStatsResponseDto.java`:** 총 사용자 수(`totalUsers`), 총 레시피 수(`totalRecipes`), 총 식재료 수(`totalIngredients`)를 한 번에 담아 반환하는 통계 전용 DTO를 설계했습니다.
* **Service 계층 확장:** `UserService`, `RecipeService`, `IngredientService`에 각각 데이터 집계를 위한 `count` 메서드를 추가했습니다.
* **`AdminController.java`:** `GET /admin/stats` 엔드포인트를 신설하여, 각 서비스의 집계 결과를 하나의 DTO로 조립하여 반환하도록 구성했습니다.

#### 🛠️ 2. 성능 및 보안 최적화
* **쿼리 성능 최적화:** 전체 데이터를 메모리에 로드하여 개수를 세는 방식(`List.size()`)을 지양하고, JPA Repository의 `count()` 메서드를 활용해 DB 레벨에서 `SELECT COUNT(*)` 쿼리가 실행되도록 하여 대용량 데이터 환경에서도 성능 저하가 없도록 최적화했습니다.
* **엔드포인트 보안:** `@PreAuthorize("hasRole('ADMIN')")`를 통해 관리자 권한을 가진 유저만 시스템 통계에 접근할 수 있도록 보안을 유지했습니다.

<img width="1419" height="239" alt="image" src="https://github.com/user-attachments/assets/ca694757-d7b1-4206-b230-d5ca46b73429" />

<img width="1417" height="401" alt="image" src="https://github.com/user-attachments/assets/1b6091e7-b638-4b99-989e-91ce58524c9d" />

## 관리자 기능 정리
```
# 🚀 [백엔드 공유사항] 관리자(Admin) 권한 시스템 및 전용 API 구현 완료

안녕하세요! 우리 '냉부해' 프로젝트의 운영 효율성과 보안을 담당할 **관리자(Admin) 권한 제어 및 모니터링 API**의 기초 공사를 완료하여 공유해 드립니다. 

프론트엔드 팀원분들이 스웨거(Swagger)에서 바로 테스트하실 수 있도록 `SecurityConfig` 및 권한 세팅도 최적화해 두었습니다.

---

### 1️⃣ 새롭게 구현된 주요 기능

1. **스프링 시큐리티 기반 RBAC (Role-Based Access Control)**
   - `USER`와 `ADMIN` 권한을 명확히 분리했습니다.
   - `@EnableMethodSecurity`를 활성화하여 컨트롤러 메서드 단위에서 `@PreAuthorize("hasRole('ADMIN')")`로 접근을 철저하게 제어합니다.

2. **시스템 대시보드 통계 (`GET /admin/stats`)**
   - 관리자 메인 화면용 API입니다. 총 유저 수, 총 레시피 수, 총 식재료 수를 반환합니다.
   - **최적화:** 대용량 데이터를 고려해 메모리에 로드하지 않고, Repository의 `count()` 메서드를 사용하여 DB 레벨에서 집계하도록 구현했습니다.

3. **전체 유저 목록 조회 (`GET /admin/users`)**
   - 관리자가 서비스 유저 현황을 파악할 수 있습니다.
   - 비밀번호 등 민감 정보 유출 방지를 위해 전용 DTO(`UserResponseDto`)를 통해 안전하게 반환합니다.

4. **부적절한 레시피 강제 삭제 (`DELETE /admin/recipes/{recipeId}`)**
   - 운영 정책 위반 콘텐츠를 즉시 조치하기 위한 API입니다.
   - 일반 유저의 '본인 확인' 로직을 우회하여 관리자 권한으로 즉시 삭제가 가능한 전용 로직을 `RecipeService`에 별도로 구축했습니다.

5. **전체 레시피 모니터링 (`GET /admin/recipes`)**
   - 작성자 본인 여부와 관계없이 시스템의 모든 레시피를 조회합니다.
   - 관리 편의를 위해 `RecipeResponseDto`에 작성자(`username`) 필드를 추가했습니다.

---

### 2️⃣ 신규 추가 및 변경된 파일 목록

#### 📂 Controller
- `AdminController.java` (**신규**): 관리자 전용 엔드포인트 격리 및 관리
- `UserController.java` (**수정**): 매핑 주소 누락분 복구 및 경로 최적화

#### 📂 Service
- `UserService.java`, `RecipeService.java`, `IngredientService.java` (**수정**): 관리자 전용 삭제 로직 및 고성능 `count()` 기반 집계 로직 추가

#### 📂 DTO
- `SystemStatsResponseDto.java`, `UserResponseDto.java` (**신규 생성**)
- `RecipeResponseDto.java` (**수정**): 작성자 정보 확인을 위한 `username` 필드 추가

#### 📂 Config / Security
- `SecurityConfig.java` (**수정**): 인가 예외 경로(`permitAll()`) 재설정 및 메서드 단위 보안 활성화
- `UserRole.java` (Enum): 권한 명세 체계 정립

---

### 3️⃣ ⚠️ 현재 안고 있는 문제점 및 기술 부채 (논의 필요)

기능은 정상 작동하나, 실제 배포 및 운영을 위해 해결해야 할 **3가지 주요 기술 부채**가 있습니다. 다음 회의 때 리팩토링 방향을 같이 정했으면 합니다.

1. **관리자 계정 생성 로직 임시화 (보안 백도어)**
   - 현재 테스트 편의를 위해 회원가입 시 `username`이 `"admin"`이면 자동으로 `ADMIN` 권한을 부여하고 있습니다. 배포 전 이 로직을 제거하고, DB 초기화 스크립트나 별도의 승급 시스템을 도입해야 합니다.

2. **데이터 물리 삭제(Hard Delete)의 위험성**
   - 현재 삭제 API는 DB에서 데이터를 영구 제거합니다. 오삭제 복구 및 증거 보존을 위해 삭제 여부(`is_deleted`) 플래그만 변경하는 **논리 삭제(Soft Delete)** 도입 검토가 필요합니다.

3. **감사 로그(Audit Log) 부재**
   - 관리자가 특정 데이터를 삭제/수정했을 때 "누가, 언제, 왜" 했는지에 대한 기록이 남지 않습니다. 운영 안전성을 위해 로그 기록용 엔티티 추가를 제안합니다.

---

**💡 API 명세서(Swagger)가 업데이트되었으니 프론트엔드 팀원분들은 확인 부탁드립니다!**
기술 부채와 관련된 리팩토링 의견은 언제든 환영합니다. 고생하셨습니다!
```

## 프로젝트 구조 

```
🧊 냉부해 (Naengbuhae) 프로젝트 전체 구조도

  📦 Naengbuhae (스마트 냉장고 관리 백엔드)
  ┣ 📂 src/main/java/com/example/Naengbuhae
  ┃ ┣ 📂 config        # 🛡️ 문지기 & 도구함: CORS, JWT, 시큐리티 등 보안 설정
  ┃ ┃ ┣ 📜 CorsConfig.java
  ┃ ┃ ┣ 📜 JwtAuthenticationFilter.java
  ┃ ┃ ┣ 📜 JwtUtil.java
  ┃ ┃ ┣ 📜 SecurityConfig.java
  ┃ ┃ ┗ 📜 SwaggerConfig.java
  ┃ ┣ 📂 controller    # 🛎️ 안내데스크: 프론트엔드의 요청을 받는 API 창구 (식재료/레시피)
  ┃ ┃ ┣ 📜 IngredientController.java
  ┃ ┃ ┗ 📜 RecipeController.java
  ┃ ┣ 📂 domain        # 🗄️ 데이터 설계도: DB 테이블과 매핑되는 핵심 엔티티
  ┃ ┃ ┣ 📜 Ingredient.java
  ┃ ┃ ┗ 📜 Recipe.java
  ┃ ┣ 📂 dto           # 🚚 택배 상자: 계층 간 데이터를 실어 나르는 전송 객체
  ┃ ┃ ┣ 📜 IngredientRequestDto.java
  ┃ ┃ ┣ 📜 IngredientResponseDto.java
  ┃ ┃ ┣ 📜 RecipeRequestDto.java
  ┃ ┃ ┣ 📜 RecipeResponseDto.java
  ┃ ┃ ┗ 📜 SystemStatsResponseDto.java (🆕 관리자 통계용 택배 상자)
  ┃ ┣ 📂 exception     # 🚑 응급실: 서버에서 발생하는 모든 에러를 낚아채서 치료
  ┃ ┃ ┗ 📜 GlobalExceptionHandler.java
  ┃ ┣ 📂 repository    # 📦 창고 관리자: DB에 데이터를 넣고 빼는 일꾼들
  ┃ ┃ ┣ 📜 IngredientRepository.java
  ┃ ┃ ┗ 📜 RecipeRepository.java
  ┃ ┣ 📂 service       # ⚙️ 공장 생산라인: 핵심 비즈니스 로직이 돌아가는 곳
  ┃ ┃ ┣ 📜 IngredientService.java
  ┃ ┃ ┗ 📜 RecipeService.java
  ┃ ┗ 📂 user          # 👤 회원 전용 라운지: 사용자 가입, 로그인 및 관리자(Admin) 전용 구역
  ┃ ┃ ┣ 📜 AdminController.java (🆕 관리자 전용 마스터 키)
  ┃ ┃ ┣ 📜 ApiResponse.java
  ┃ ┃ ┣ 📜 LoginRequest.java
  ┃ ┃ ┣ 📜 LoginResponse.java
  ┃ ┃ ┣ 📜 SignupRequest.java
  ┃ ┃ ┣ 📜 User.java
  ┃ ┃ ┣ 📜 UserController.java
  ┃ ┃ ┣ 📜 UserRepository.java
  ┃ ┃ ┣ 📜 UserResponseDto.java (🆕 유저 정보 보호용 택배 상자)
  ┃ ┃ ┣ 📜 UserRole.java        (🆕 계급장: USER vs ADMIN)
  ┃ ┃ ┗ 📜 UserService.java
  ┣ 📂 src/main/resources
  ┃ ┣ 📜 application.properties  # ⚙️ 앱 핵심 설정: DB 주소 및 스프링 설정
  ┃ ┣ 📂 static                 # 🖼️ 정적 보관소: 이미지, CSS 등
  ┃ ┗ 📂 templates              # 📄 템플릿 창고: HTML 화면 파일들
  ┣ 📜 .env                # 🤫 1급 비밀: JWT 시크릿 키 등 민감 정보 (공유 엄금!)
  ┣ 📜 build.gradle        # 🐘 부품 주문서: 프로젝트에 필요한 라이브러리 목록
  ┣ 📜 settings.gradle      # 📝 프로젝트 이름표: 프로젝트 설정 정보
  🔍 구조적 특이사항 (Audit 결과 반영)
   1. 도메인 분리: 사용자 관련 기능(user)은 하나의 패키지에 모여 있는 도메인형 구조를 띠고 있으며, 그 외 기능들은 계층형
      구조(controller, service 등)로 관리되고 있습니다.
   2. 보안 강화: 최근 추가된 AdminController와 UserRole 등을 통해 일반 사용자와 관리자의 영역이 엄격히 분리되었습니다.
   3. 데이터 무결성: GlobalExceptionHandler를 통해 서버 내 예외 상황을 통합 관리하고 있습니다.
```

### 🛡️ [안정성 강화] 레시피 데이터 유효성 검사 (API Validation) 적용

프론트엔드 연동 및 실서비스 운영 시 발생할 수 있는 데이터 무결성 결함을 방지하고, 서버의 비정상 종료(500 Error)를 원천 차단하기 위해 **강력한 유효성 검사 방패**를 구축했습니다.

#### 1. 🔍 도입 배경 및 문제 해결
* **기존 문제:** 레시피 등록/수정 시 필수 데이터(제목, 조리법 등)가 누락된 채 들어오면 DB 제약 조건과 충돌하여 서버가 500 에러를 뱉으며 멈추는 현상 발생.
* **해결 방안:** 계층 간 데이터 전송 객체(DTO)에서 1차 검증을 수행하고, 컨트롤러 진입 전 문지기(`@Valid`)를 세워 부적절한 요청을 즉각 차단함.

#### 2. 🛠️ 주요 적용 사항
* **`RecipeRequestDto` 내 제약 조건 설정:**
  - `title`: `@NotBlank` (공백/Null 허용 안 함)
  - `instructions`: `@NotBlank` (조리 방법 필수 입력)
  - `cookingTime`: `@NotNull` 및 `@Min(1)` (최소 1분 이상의 숫자만 허용)
* **`RecipeController` 보호:**
  - `POST /recipes`, `PUT /recipes/{id}` 메서드에 `@Valid` 어노테이션을 적용하여 실시간 검증 활성화.

#### 3. 🎯 검증 결과 (Safety Check)
* **HTTP 400 Bad Request 반환:** 잘못된 데이터 유입 시 서버가 다운되지 않고, 사용자에게 구체적인 에러 메시지를 JSON 형태로 안전하게 반환함을 확인했습니다.
* **에러 메시지 예시:** `"레시피 제목은 필수 입력 항목입니다."`, `"조리 시간은 최소 1분 이상이어야 합니다."`

<img width="1456" height="620" alt="image" src="https://github.com/user-attachments/assets/5dfe2420-bf27-42e0-bb58-a8042c6e08ee" />

<img width="1406" height="421" alt="image" src="https://github.com/user-attachments/assets/8e45a946-f592-475b-b92b-f6b972630721" />


## 🚀 [성능 최적화] N+1 쿼리 문제 해결 및 API 응답 속도 개선

관리자(Admin) 전용 전체 레시피 조회 API에서 발생하던 심각한 데이터베이스 병목 현상을 파악하고, 쿼리 최적화를 통해 서버 성능을 비약적으로 향상시켰습니다.

### 1. 🔍 도입 배경 및 문제 상황 (N+1 Query)
* **기존 문제:** `Recipe`와 작성자(`User`) 엔티티가 지연 로딩(Lazy Loading)으로 매핑되어 있어, 전체 레시피를 조회할 때 작성자 정보를 가져오기 위해 **레시피 개수(N)만큼의 추가 SELECT 쿼리**가 발생하는 'N+1 문제'가 존재했습니다.
* **성능 저하:** 레시피가 100개일 경우 총 101번의 쿼리가 실행되어 네트워크 오버헤드 및 DB 커넥션 고갈 위험이 컸습니다.

### 2. 🛠️ 해결 방안 (JOIN FETCH 적용)
* `RecipeRepository`에 커스텀 쿼리 메서드(`findAllWithUser()`)를 생성했습니다.
* `@Query("SELECT r FROM Recipe r JOIN FETCH r.user")` 구문을 적용하여, SQL 수준에서 `INNER JOIN`을 통해 레시피와 유저 데이터를 한 번에 즉시 로딩(Eager Fetch)하도록 강제했습니다.
* `RecipeService`의 관리자 조회 로직을 기존 `findAll()`에서 최적화된 메서드로 교체했습니다.

### 3. 🎯 최적화 결과 (Performance Impact)
* **쿼리 호출 횟수 감소:** 101번 실행되던 쿼리가 **단 1번의 쿼리**로 드라마틱하게 단축되었습니다.
* **응답 속도 개선:** 데이터베이스 I/O 병목이 해소되어, 대량의 데이터 조회 시에도 지연 없는 빠른 대시보드 로딩 속도를 확보했습니다.


## 👥 회원 관리 시스템 (User Management & Security)

프론트엔드와의 완벽한 데이터 연동을 위한 도메인 확장 및 엔터프라이즈급 보안 패치를 적용했습니다.

### 1. 🚀 프론트엔드 맞춤형 도메인 확장
* **데이터베이스 스키마 확장:** 사용자의 건강 정보 및 식단 추천을 위해 `User` 엔티티에 프론트엔드 기획과 동일한 9개의 신규 필드(이름, 키, 몸무게, 생년월일, 알레르기 등)를 추가했습니다.
* **DTO 및 Service 완벽 매핑:** `SignupRequest`를 통해 들어온 대량의 회원 데이터가 누락 없이 영속화(DB 저장)되도록 `UserService` 매핑 로직을 고도화했습니다.

### 2. 🔒 관리자(Admin) 권한 백도어 원천 차단
* **보안 취약점 제거:** 개발 초기 단계에 존재했던 특정 아이디(`username == "admin"`) 기반의 관리자 자동 승격 백도어 로직을 완전히 삭제했습니다.
* **권한 강제 할당:** 악의적인 페이로드 변조를 막기 위해, 모든 신규 회원가입 요청은 시스템 수준에서 강제로 `ROLE_USER` 권한만 부여받도록 인가(Authorization) 로직을 철통 방어했습니다. 관리자 권한은 오직 인가된 DB 접근을 통해서만 부여할 수 있습니다.

--------------

## 🛡️ 시스템 아키텍처 및 보안 (Security & Architecture)

본 프로젝트는 실서비스 수준의 안정성을 확보하기 위해 철저한 계층 간 책임 분리와 다중 보안 방어막을 구축했습니다.

### 1. DTO 기반 1차 방어막 (Validation Flow)
- **문제:** 기존 `UserService` 내부에 산재된 수많은 입력값 검증 로직으로 인한 결합도 증가 및 유지보수 저하.
- **해결:** `SignupRequest(DTO)`에 `jakarta.validation` 제약조건(`@NotBlank`, `@Pattern`, `@Email` 등)을 선언하고, `UserController`에 `@Valid`를 적용하여 부적절한 데이터의 서비스 계층 진입을 **원천 차단(입구컷)** 했습니다.
- **효과:** `UserService`의 코드를 60% 이상 경량화하고 오직 비즈니스 코어 로직(DB 중복 검사 등)에만 집중하도록 응집도를 높였습니다.

### 2. 관리자 권한 탈취(Backdoor) 원천 봉쇄
- **문제:** 회원가입 시 특정 아이디(`admin`) 입력 시 관리자 권한이 부여되는 고전적인 보안 취약점 존재.
- **해결:** `UserService.signup()` 로직 내에서 모든 신규 가입자의 권한을 `UserRole.USER`로 강제 하드코딩 할당하도록 리팩토링했습니다.
- **운영:** 초기 최고 관리자(Super Admin) 계정은 데이터베이스 접근 권한자(DBA)가 수동으로 권한을 격상하는 방식을 채택하여 보안성을 극대화했습니다.

### 3. 관리자 행위 추적 (Audit Logging)
- **문제:** 관리자의 막강한 권한(레시피 강제 삭제 등) 사용 시 누가 해당 행위를 했는지 증명할 수 없는 문제 발생.
- **해결:** `AdminController`에 스프링 시큐리티의 `SecurityContextHolder`를 연동하여, 중요 데이터 변경/삭제 시 현재 인가된 관리자의 ID(Username)를 추출해 `@Slf4j` `log.warn` 레벨로 영구 기록하는 Audit 로깅 시스템을 구축했습니다.

### 4. JWT 토큰 생명주기 최적화 (Stateless Security)
- 탈취된 토큰의 악용 가능성(Replay Attack 등)을 최소화하기 위해, `JwtUtil`의 Access Token 만료 시간을 기존 1시간에서 **30분으로 단축**하여 보안을 한층 강화했습니다.

------------------------
## 🛡️ 시스템 아키텍처 및 보안 (Security & Architecture)

본 프로젝트의 백엔드는 실서비스 트래픽과 대규모 유입 상황을 고려하여, 철저한 계층 간 책임 분리(Layered Architecture)와 다중 보안 방어막을 적용해 견고하게 구축되었습니다.

### 1. 전역 예외 처리 및 API 규격화 (Global Exception Handling)
- **문제:** 예외 상황(검증 실패, DB 중복 등)에서도 `200 OK`를 반환할 경우 프론트엔드 연동 시 에러 핸들링이 꼬이는 문제가 발생할 수 있습니다.
- **해결:** `@RestControllerAdvice` 기반의 `GlobalExceptionHandler`를 도입했습니다. 
- **효과:** 유효성 검증 실패 시 `400 Bad Request`, DB 제약조건 위반 시 `409 Conflict` 등 명확한 HTTP 상태 코드와 함께 규격화된 JSON(`ApiResponse`) 응답을 프론트엔드에 전달하여 통신 신뢰성을 확보했습니다.

### 2. DTO 기반 1차 방어막 (Validation Flow)
- **적용:** 서비스 레이어에 산재된 복잡한 값 검증 로직을 걷어내고, `SignupRequest(DTO)` 객체에 `jakarta.validation` 제약조건(`@NotBlank`, `@Email`, `@Pattern` 등)을 촘촘하게 선언했습니다.
- **효과:** `UserController` 입구에서 `@Valid` 어노테이션을 통해 불량 데이터를 즉시 차단(입구컷)함으로써, 불필요한 트랜잭션 소모를 막고 `UserService`가 핵심 비즈니스 로직에만 집중하도록 응집도를 높였습니다.

### 3. 동시성 제어 및 트랜잭션 보장 (Concurrency & Transaction)
- **문제:** 찰나의 순간에 동일 아이디로 동시 가입 요청이 들어오는 경쟁 상태(Race Condition) 시 DB 정합성이 깨질 위험이 존재했습니다.
- **해결:** `UserService`의 데이터 변경 로직에 `@Transactional`을 명시적으로 적용하여 작업의 원자성(Atomicity)을 보장하고, 예기치 못한 에러 발생 시 안전하게 롤백(Rollback)되도록 설계했습니다.

### 4. 무결점 권한 제어 및 Audit 로깅 (Security & Audit)
- **관리자 백도어 원천 차단:** 회원가입 시 모든 신규 유저에게 시스템 단에서 `UserRole.USER` 권한을 강제 하드코딩으로 할당하여, 외부 조작을 통한 관리자 권한 탈취를 100% 방어했습니다.
- **관리자 행위 추적 (Audit Log):** `AdminController`의 주요 데이터 강제 삭제 API 호출 시, `SecurityContextHolder`를 통해 인가된 관리자의 ID를 추출하고 `@Slf4j` `WARN` 레벨로 영구 기록하는 감사 로그(Audit Logging) 시스템을 구축했습니다.
- **JWT 생명주기 최적화:** 토큰 탈취(Replay Attack) 피해를 최소화하기 위해 Access Token의 유효 기간을 30분으로 단축하여 Stateless 보안 환경을 한층 강화했습니다.

### 5. 빌드 환경 안정화 및 API 문서화 (Build & Docs)
- 프론트엔드 및 타 서비스와의 원활한 협업(API 연동)을 위해 `springdoc-openapi`를 적용하여 **Swagger UI**를 구축 및 복구하였으며, 안정적인 의존성 관리를 위해 Spring Boot 환경을 `3.2.4` 최적화 버전으로 동기화했습니다.

### 6. 무중단 프론트엔드 연동 (CORS & Pre-flight 최적화)
- **문제:** 브라우저의 사전 요청(Pre-flight)인 `OPTIONS` 메서드가 Spring Security 필터에서 인증 거부되어 프론트엔드 단에서 억울한 CORS 에러가 발생하는 고질적인 통신 문제.
- **해결:** 파편화되어 있던 CORS 설정을 `SecurityConfig` 내부로 완벽하게 통합하여 설정 충돌을 방지했습니다. 또한 시큐리티 인가 목록에 `HttpMethod.OPTIONS`를 전면 허용(`permitAll()`)하여 토큰이 없는 사전 노크 요청이 안전하게 통과되도록 아키텍처를 수정했습니다.
- **효과:** 프론트엔드 로컬 개발 환경(`localhost`, `127.0.0.1`)에서 발생하는 교차 출처 리소스 에러를 원천 차단하여, 타 파트와의 협업 병목 현상과 디버깅 시간을 대폭 감소시켰습니다.

### 7. 백엔드 주도 데이터 규격 강제 (API Contract First)
- **문제:** 프론트엔드에서 전달되는 값(성별, 활동량 등)의 형식이 파편화될 경우, 핵심 비즈니스 로직(칼로리 계산 등)에서 예외가 발생하거나 분기 처리가 복잡해지는 문제가 있었습니다.
- **해결:** `SignupRequest(DTO)`의 주요 필드에 `@Pattern` 정규식을 적용하여, 백엔드가 요구하는 특정 텍스트(예: "남", "여", "보통 활동" 등)가 아닌 경우 컨트롤러 진입 전 즉시 `400 Bad Request`로 차단하도록 설계했습니다.
- **효과:** 프론트엔드와의 통신 규약을 시스템 레벨에서 강제함으로써 데이터 무결성을 확보하고, 향후 확장될 도메인 로직의 안정성을 극대화했습니다.

## build.gradle 해결한 방법

build.gradle 버전을 안정화 버전으로 할려고 했으나 에러가 뜸 
<img width="1919" height="1008" alt="image" src="https://github.com/user-attachments/assets/ed62083c-520e-46cd-8a1d-fa100b13ac4b" />

여기로 들어감 
<img width="428" height="141" alt="image" src="https://github.com/user-attachments/assets/28dfa0d3-4be2-4df8-a942-5ad52002dd90" />

이런 코드였는데 
<img width="1316" height="566" alt="image" src="https://github.com/user-attachments/assets/06a4fff1-7af5-49ea-8d01-b62f86d0187c" />

이렇게 바꿈
<img width="1327" height="562" alt="image" src="https://github.com/user-attachments/assets/cc2e0c26-adde-49d1-9105-168c9e8d7b4b" />

그리고 코끼리 모양 클릭해주니 이렇게 됨
<img width="1919" height="1008" alt="image" src="https://github.com/user-attachments/assets/2e90a760-5a15-4465-aa9d-3f6eaa884e81" />


## 💡 핵심 비즈니스 로직 (Core Business Logic)

### 1. 개인 맞춤형 일일 권장 칼로리 도출 엔진 (BMR & TDEE)
- **개요:** 회원가입 시 입력받은 6가지 신체/활동 데이터(성별, 생년월일, 키, 몸무게, 활동량, 식단 목표)를 기반으로 사용자의 하루 권장 칼로리를 자동 계산하여 DB에 저장합니다.
- **알고리즘 (Mifflin-St Jeor):** 현대 영양학에서 가장 정확도가 높다고 평가받는 미플린-지어 공식을 채택하여 기초대사량(BMR)을 산출하고, 활동 대사량(TDEE) 가중치 및 다이어트 목표(감량/증량)에 따른 가감 로직을 적용했습니다.
- **아키텍처 포인트:** 
  - 관심사 분리(SoC) 원칙에 따라 계산 로직을 `CalorieCalculator` 유틸리티 클래스로 완전히 격리했습니다.
  - 이로 인해 `UserService`는 복잡한 수학 공식 없이 도메인 흐름 제어와 트랜잭션 관리에만 집중할 수 있도록 응집도를 높였습니다.

### 2. 식재료 관리 (Ingredient) 도메인 - 완벽한 방어적 프로그래밍 적용
- **개요:** 사용자가 자신의 냉장고에 보관 중인 식재료를 등록, 조회, 수정, 삭제(CRUD)할 수 있는 핵심 API입니다.
- **보안 및 인가 (IDOR 방어):** 
  - `Controller` 계층에서 Spring Security의 `Principal` 객체를 활용해 안전하게 유저 식별자를 추출합니다.
  - `Service` 계층의 모든 수정/삭제 로직에서 `!ingredient.getUser().getUsername().equals(username)` 검증을 거쳐, 타인의 식재료를 조작할 수 없도록 완벽한 소유권(Ownership) 체크를 구현했습니다.
- **데이터 무결성 극대화 (@Valid):** 
  - 프론트엔드의 비정상적인 요청을 차단하기 위해 `IngredientRequestDto`에 철벽 방어막을 구축했습니다.
  - `@Min(1)`로 음수 수량 방지, `@FutureOrPresent`로 과거 유통기한 등록 차단, `@JsonFormat`으로 날짜 파싱 오류 방어, 그리고 정규식(`@Pattern(regexp = "^(냉장|냉동|실온)$")`)을 통해 데이터베이스에 들어가는 보관 방법 데이터의 정합성을 소프트웨어 레벨에서 2중으로 보호합니다.


### 3. 장보기 리스트 (Shopping List) - 심플 & 스피드 지향
- **개요:** 마트에서 한 손으로 빠르게 체크할 수 있도록 '이름, 수량, 단위' 위주의 간편 메모형 장보기 CRUD API를 구현했습니다.
- **주요 기능:**
  - 장보기 항목 추가, 내 장보기 전체 조회, 삭제 기능 (POST, GET, DELETE)
  - 장바구니 담기(구매 완료) 체크 상태 토글 기능 (PATCH 적용으로 RESTful 설계 준수)
- **보안 및 안정성:**
  - 식재료/레시피 도메인과 동일하게 `Principal`을 이용한 완벽한 소유권(Ownership) 방어 적용.
  - DTO 계층에서 수량(`quantity`) 양수 검증 등 `@Valid`를 통한 무결성 100% 보장.

post
<img width="1491" height="726" alt="image" src="https://github.com/user-attachments/assets/3e9814c9-3242-41c2-b0b1-ed84c6e0e06a" />

<img width="1411" height="453" alt="image" src="https://github.com/user-attachments/assets/7abd3ee4-28cc-40ce-93b5-1d28d0332969" />

<img width="1299" height="141" alt="image" src="https://github.com/user-attachments/assets/203273fb-b880-4842-8c7c-c2e58427e185" />


get 
<img width="1461" height="564" alt="image" src="https://github.com/user-attachments/assets/2644d7f2-aa91-40e5-9e0d-87986d197c09" />

<img width="1411" height="472" alt="image" src="https://github.com/user-attachments/assets/845bb54e-f4ad-4c50-8f0b-8fdc23470d9d" />

patch
<img width="1414" height="608" alt="image" src="https://github.com/user-attachments/assets/18770a86-af0e-4008-af99-ce8a352277fd" />

<img width="1410" height="442" alt="image" src="https://github.com/user-attachments/assets/af4f4e95-4efe-4eeb-92c8-b6e71d7dbbe5" />

delete
<img width="1430" height="619" alt="image" src="https://github.com/user-attachments/assets/ea4d2025-9ee2-4c73-8b6e-17d1997693a7" />

<img width="1419" height="418" alt="image" src="https://github.com/user-attachments/assets/07aed3db-0731-432b-ab03-61aa88271416" />

### 4. 장보기 리스트 -> 냉장고 마법의 이관 API
- **개요:** 장보기가 끝난 후, 체크된 항목들을 내 냉장고로 한 번에 옮겨주는 핵심 자동화 로직입니다.
- **주요 기능:**
  - `checked=true` 상태인 장보기 항목만 필터링하여 `Ingredient` 엔티티로 자동 변환합니다. (소수점 수량은 정수로 안전하게 내림/변환 처리)
  - 구매일(오늘), 유통기한(오늘+7일), 카테고리(미분류), 보관상태(냉장) 등 필수 기본값을 자동으로 할당하여 무결성을 유지하며 DB에 저장합니다.
  - 냉장고 이관이 완료된 데이터는 `ShoppingItem` 테이블에서 일괄 삭제되어 깔끔한 상태를 유지합니다.

api/shopping-list/{id}/toggle (PATCH)
<img width="1415" height="622" alt="image" src="https://github.com/user-attachments/assets/aabe9ccb-e80f-4497-b245-8eed0baf3e24" />

<img width="1414" height="452" alt="image" src="https://github.com/user-attachments/assets/5108bec7-89b8-428b-9c89-e02770a111f6" />

/api/shopping-list/move-to-fridge (POST)
<img width="1414" height="522" alt="image" src="https://github.com/user-attachments/assets/eacaa603-2241-4683-b9b4-c5ad63ce8b9c" />

<img width="1420" height="412" alt="image" src="https://github.com/user-attachments/assets/586ca06b-c24d-42f3-94ed-be5decaa89d5" />

/api/shopping-list (GET)

<img width="1420" height="516" alt="image" src="https://github.com/user-attachments/assets/52698106-978f-43e4-815f-33cd54bf5960" />

<img width="1416" height="467" alt="image" src="https://github.com/user-attachments/assets/a6a46304-c936-40a1-9350-e9760c3ea2be" />


/api/ingredients (GET)
<img width="1416" height="512" alt="image" src="https://github.com/user-attachments/assets/7602e9a4-b869-4a58-8804-1475279b52f6" />

<img width="1416" height="515" alt="image" src="https://github.com/user-attachments/assets/0e74790e-20a5-444d-a82f-295ccd230bc4" />

### 5. 글로벌 예외 처리 (Global Exception Handling) 고도화
- **JSON 파싱 에러 완벽 방어 (`HttpMessageNotReadableException`):** 
  - 프론트엔드에서 날짜 형식(`yyyy-MM-dd`)에 슬래시(`/`)를 섞어 보내거나, 숫자 필드에 문자를 넣는 등 잘못된 타입의 데이터를 전송했을 때 발생하는 파싱 에러를 원천 차단합니다.
  - 서버가 다운되거나 알아보기 힘든 기본 에러를 뱉는 대신, 프로젝트 표준 규격인 `ApiResponse` (400 Bad Request) 형태로 젠틀하게 예외 메시지를 반환하여 프론트엔드와의 협업 안정성을 극대화했습니다.

## 🛠 트러블슈팅: 식재료 이관 시 소수점 수량 유실(Truncation) 버그 해결
* **이슈:** 장바구니에서는 수량을 소수점(`Double`)으로 관리하나(예: 대파 1.5단), 냉장고 식재료는 정수(`Integer`)로 관리되어, 장바구니에서 냉장고로 항목을 이관할 때 소수점이 증발하는 데이터 불일치 현상 발생[cite: 46].
* **해결 로직:**
  * `Ingredient` 엔티티 및 관련 입출력 DTO(`IngredientRequestDto`, `IngredientResponseDto`)의 `quantity` 데이터 타입을 모두 `Double`로 통일하여 장바구니와 규약 일치[cite: 43, 44, 45].
  * API 요청 시 `@Positive` 어노테이션을 적용하여 0.5 같은 소수점 단위의 입력 유효성 검사 완벽 지원[cite: 44].
  * 장바구니 ➡️ 냉장고 이관 비즈니스 로직(`ShoppingItemService`) 내에 존재하던 강제 형변환(`intValue()`)을 제거하여 데이터 정합성 100% 확보[cite: 46].


## 🛠️ 백엔드 보안 및 아키텍처 개선 (Hotfix 적용 완료) 

로컬(IntelliJ) 및 도커(Docker) 컨테이너 환경 모두에서 무중단으로 안정적으로 구동되도록 **환경변수 유연성을 확보**하고, 런타임 에러를 사전에 차단하기 위한 **방어적 프로그래밍(Defensive Programming)** 패치를 적용했습니다.

### 🚀 주요 업데이트 내역

**1. CORS 동적 파싱 및 휴먼 에러 방어 로직 추가 (`SecurityConfig.java`)**
- **문제:** 환경변수로 여러 도메인을 주입할 때, 콤마(`,`) 뒤에 공백이 포함되거나 비정상적인 문자열이 들어올 경우 CORS 파싱 에러 발생.
- **해결:** Java 8 Stream API를 활용하여 오리진 데이터 정제(Sanitization) 파이프라인 구축.
- **적용 로직:** `map(String::trim)`으로 공백을 제거하고, `filter(s -> !s.isEmpty())`로 빈 값을 필터링하여 안전한 도메인 리스트만 Spring Security에 등록하도록 개선.

**2. JWT 암호화 키 기본값(Fallback) 설정 (`JwtUtil.java`)**
- **문제:** `.env` 파일 누락 또는 도커 실행 시 환경변수가 주입되지 않으면 런타임 에러(Boot Failure) 발생.
- **해결:** 환경변수 누락 시 작동할 안전한 기본 키값을 설정 (`${JWT_SECRET_KEY:기본값}`).
- **보안성 확보:** HS256 알고리즘의 최소 요구 스펙(256 bit / 32 bytes)을 200% 충족하는 64 bytes 길이의 시크릿 키를 기본값으로 세팅하여 `WeakKeyException` 완벽 방어.

**3. JWT 토큰 파싱 Null-Safety 및 예외 흡수력 강화 (`JwtUtil.java`)**
- **문제:** 악의적이거나 손상된 토큰(권한 정보 누락, 알 수 없는 권한 명칭 등) 요청 시 500 Internal Server Error 발생 위험.
- **해결:** 2단계 예외 처리(Null Check + Exception Catch) 적용.
- **동작 방식:** 비정상적인 권한 정보 파싱 시(`IllegalArgumentException`), 서버가 다운되지 않고 조용히 해당 유저를 **일반 권한(`UserRole.USER`)으로 강등(Downgrade)**시켜 시스템 가용성(Availability) 유지.

---

### ⚙️ 환경 변수 (`.env`) 설정 가이드
도커 배포 또는 로컬 환경 세팅 시 아래 환경변수를 활용할 수 있습니다. (설정하지 않으면 안전한 로컬 기본값으로 작동합니다.)
```env
# 클라우드 DB 주소 (Supabase 등)
DB_URL=jdbc:postgresql://your-db-url:5432/postgres

# DB 비밀번호
DB_PASSWORD=your_db_password

# CORS 허용 도메인 리스트 (쉼표로 구분, 공백 허용)
ALLOWED_ORIGINS=http://localhost:3000, [https://your-production-domain.com](https://your-production-domain.com)

# JWT 시크릿 키 (운영 환경에서는 반드시 32자 이상의 복잡한 문자열로 재설정)
JWT_SECRET_KEY=your_very_long_and_secure_secret_key_here
```
🤝 프론트엔드 연동 참고 사항
현재 백엔드는 환경변수 유무와 상관없이 에러를 내뿜지 않는 Fail-Safe 상태입니다.

프론트엔드에서는 위 ALLOWED_ORIGINS에 등록된 주소를 통해 안전하게 API 호출(GET, POST, OPTIONS 등)이 가능합니다.


**6. 외부 AI (Gemini) 연동 아키텍처 사전 구축**

* **개요:** 향후 AI 파트의 맞춤형 음식 효능 및 레시피 추천 기능(FastAPI 연동)을 대비하여, 백엔드 서버에 외부 API 통신 전용 뼈대 및 데이터 통신 규격을 선제적으로 구축했습니다.
* **주요 기능:**
  * AI 파트의 예상 응답 포맷(`dish_name`, `additional_ingredients`, `health_benefits`, `recipe_tip`)에 맞춘 전용 수신 객체인 `AiRecipeResponseDto`를 설계하여 JSON 역직렬화(Deserialization)를 대비했습니다.
  * 프론트엔드에서 AI 추천을 즉시 요청할 수 있도록 `RecipeController`에 `GET /api/recipes/ai-recommendations` 엔드포인트를 개통했습니다.
* **아키텍처 포인트:** * **관심사 분리 및 시스템 격리:** 기존 DB 의존적인 레시피 비즈니스 로직(`RecipeService`)과 외부 AI 통신 로직(`AiRecipeService`)을 완벽히 분리(Decoupling)했습니다.
  * 이를 통해 타 서버(AI 서버)의 응답 지연이나 장애가 발생하더라도 백엔드 본 서버의 트랜잭션과 전반적인 가용성에 영향을 주지 않도록 시스템 안정성을 극대화했습니다.

**7. 시스템 보안 및 추적성(Observability) 강화를 위한 Audit Log 도입 (1차 MVP)**

* **개요:** 시스템의 투명성과 보안 강화를 위해, 관리자의 민감한 작업(예: 부적절한 콘텐츠 강제 삭제) 내역을 단순 콘솔 출력을 넘어 데이터베이스에 영구적으로 기록하는 감사 로그 시스템을 구축했습니다.
* **주요 기능:**
  * `AuditLog` 엔티티를 설계하여 '행위자(Admin)', '수행 작업', '대상 도메인', '상세 사유', '접속 IP' 등의 핵심 추적 데이터를 구조화하여 저장합니다.
  * 관리자 전용 API(`AdminController`) 실행 시 로깅 서비스(`AuditLogService`)가 호출되어, 실제 삭제 행위와 로그 기록이 동시에 이루어지도록 연동했습니다.
* **아키텍처 포인트 및 향후 고도화 계획:**
  * 현재는 비즈니스 로직 내부에 로깅 코드가 동기적(Synchronous)으로 결합되어 있는 상태입니다.
  * 🚀 **(Next Step):** 메인 비즈니스 로직의 속도 저하를 막고 관심사를 완벽히 분리하기 위해, **Spring AOP(관점 지향 프로그래밍) 커스텀 어노테이션**과 **`@Async` 기반의 비동기 독립 트랜잭션(`REQUIRES_NEW`)** 아키텍처로 대대적인 리팩토링을 진행할 예정입니다.
 
**8. Spring AOP 및 비동기 처리를 활용한 감사 로그 아키텍처 고도화 (Refactoring)**

* **개요:** 기존 비즈니스 로직(Controller/Service)에 강하게 결합되어 있던 감사 로그 기록 로직을 **Spring AOP(관점 지향 프로그래밍)**를 통해 완벽히 분리해 내어, 코드의 응집도를 높이고 유지보수성을 극대화했습니다.
* **주요 기능 및 아키텍처 포인트:**
  * **커스텀 어노테이션 기반 로깅:** `@Audit` 커스텀 어노테이션을 제작하여, 보안 추적이 필요한 관리자 API에 단 한 줄의 선언만으로 로깅이 작동하도록 자동화했습니다.
  * **관심사 분리 (Decoupling):** `AuditAspect` 클래스를 통해 핵심 비즈니스 로직(Target)과 횡단 관심사(Logging)를 분리하여, 컨트롤러가 본연의 역할(요청 처리)에만 집중할 수 있도록 다이어트에 성공했습니다.
  * **비동기 독립 트랜잭션 보장:** 로그 저장 로직에 `@Async`와 `@Transactional(propagation = Propagation.REQUIRES_NEW)`를 적용했습니다. 이를 통해 로그 기록 시 발생하는 DB I/O가 메인 API 응답 속도에 영향을 주지 않으며, 메인 트랜잭션이 롤백되더라도 감사 로그는 무조건 보존되도록 엔터프라이즈급 안정성을 확보했습니다.







EnvFile 설치하기 
<img width="496" height="849" alt="image" src="https://github.com/user-attachments/assets/5133ca3d-c4ab-4917-8fb2-28dd39537fd9" />
그리고 설치를 누른다
<img width="1469" height="996" alt="image" src="https://github.com/user-attachments/assets/1dc7516c-ecd3-4008-b707-132f7b3b6698" />

🛠️ 완벽한 2단계 세팅 가이드 
1. 지우기 (핵심!): 일단 '환경 변수(E)' 칸에 적어둔 C:/2026_TeamProject/Naengbuhae/.env 텍스트를 백스페이스로 싹 지워서 완전 빈칸으로 만들어 줘.

2. 체크하기: 그 바로 밑에 있는 네모난 Enable EnvFile 체크박스를 눌러서 체크(☑️)해 줘.

3. 추가하기: 체크하고 나면 그 아래쪽 영역이 활성화될 텐데, 거기서 + 모양 버튼을 누르고 메뉴에서 .env file을 클릭해.

4. 파일 선택: 파일 탐색기 창이 뜨면, 진짜 우리 프로젝트 폴더 안에 있는 .env 파일을 찾아서 선택(Open)해 줘.

5. 저장: 맨 밑에 파란색 [확인] 버튼을 누르면 완벽하게 끝!

<img width="421" height="215" alt="image" src="https://github.com/user-attachments/assets/6966f7a7-5555-4e32-9ed0-9ab12aad3dac" />

기존 .env파일을 인식하는 건 지워준다
<img width="1197" height="995" alt="image" src="https://github.com/user-attachments/assets/be567ece-41ac-46db-96af-38af91d5a669" />

.env file을 선택 
<img width="1198" height="984" alt="image" src="https://github.com/user-attachments/assets/06b1ec68-3b05-43d3-aec8-38c88674c6db" />

그러면 이런 파일이 나온다 
<img width="933" height="696" alt="image" src="https://github.com/user-attachments/assets/83d4a56a-6a4e-4d4e-818b-4578eba7ead0" />

이렇게 하면 된다
<img width="1200" height="995" alt="image" src="https://github.com/user-attachments/assets/5cb228d7-1aad-458b-8c63-1adc5797bb81" />


### 🤖 외부 AI(Gemini/FastAPI) 연동 및 가용성 설계
사용자 맞춤형 레시피 추천을 위해 외부 AI 서버와 통신하는 전용 아키텍처를 구축했습니다.

- **독립된 엔드포인트 개통**: 
  - 기존 DB 기반 추천(`/api/recipes/recommendations`)과 분리된 AI 전용 추천 API(`/api/recipes/ai-recommendations`)를 개통하여 서비스 간 간섭을 최소화했습니다.
- **시니어급 Fail-Safe(결함 허용) 방어막 구축**:
  - **타임아웃 설정**: LLM 응답 지연에 대비하여 `RestTemplateBuilder`를 통해 Connect(5s), Read(30s) 타임아웃을 명시적으로 설정했습니다.
  - **예외 복구 로직**: AI 서버 장애나 응답 지연 발생 시, 전체 시스템이 멈추지 않고 사용자에게 우아한 에러 메시지(Fallback Message)를 반환하도록 `try-catch` 방어막을 씌웠습니다.
- **Fail-Fast 전략**: 
  - 유저의 냉장고가 비어있을 경우, 외부 API 호출 전에 백엔드 단에서 즉시 차단하여 불필요한 네트워크 비용 및 토큰 소모를 방지합니다.
- **비동기 감사 로그(Audit Log) 연동**: 
  - AI 추천 요청 발생 시 관리자 감사 로그 시스템과 연동하여 누가, 언제 AI 기능을 호출했는지 기록할 수 있는 확장성을 확보했습니다.

### 🛠️ 외부 AI 연동 아키텍처 고도화 (v1.1)

최근 업데이트를 통해 외부 AI(FastAPI/Gemini) 서버와의 통신 안정성 및 설정 유연성을 강화했습니다.

- **설정의 외부화 (Externalized Configuration)**:
  - `ai.server.url` 설정을 `application.properties` 및 `.env` 파일로 분리했습니다.
  - 이를 통해 코드 수정 없이 환경변수 변경만으로 운영/개발 서버 주소를 즉시 전환할 수 있습니다.
- **서비스 가용성(Fail-Safe) 확보**:
  - `RestTemplateBuilder`를 사용하여 AI 서버 응답 지연에 대비한 타임아웃(30초)을 명시적으로 설정했습니다.
  - 외부 서버 장애 시에도 메인 서비스가 멈추지 않도록 예외 처리 방어막을 구축했습니다.
- **보안 및 안정성 복구**:
  - 시스템 구동의 핵심인 `jwt.secret` 설정을 최적화하여 인증 시스템의 안정성을 확보했습니다.
- **Fail-Fast 로직 적용**:
  - 식재료가 없는 상태에서의 불필요한 AI 호출을 백엔드 단에서 사전에 차단하여 네트워크 비용을 절감했습니다.

### 🛡️ 트래픽 및 메모리 최적화 (OOM 방어)
- **문제 인식**: 기존 `RateLimitFilter`가 `ConcurrentHashMap`을 사용하여 무한정 IP 기록을 적재, 악의적인 트래픽 공격(DDoS 등) 시 서버 메모리 고갈(OOM) 위험 존재.
- **해결 방안**: 로컬 캐시 라이브러리인 **Caffeine Cache**를 도입하여 방어 로직 고도화.
  - `maximumSize(10000)`: IP 기록의 최대치를 제한하여 메모리 공간 보호.
  - `expireAfterAccess`: 10분간 미사용된 IP 기록을 메모리에서 자동 퇴출(Eviction)시켜 효율적인 GC(Garbage Collection) 유도 및 시스템 가용성 극대화.


### 🚀 운영 환경(Production) 대비 인프라 및 보안 고도화 (v1.2)

실제 서비스 배포 및 운영을 고려하여 백엔드 시스템의 가용성, 보안, 자동화 수준을 대폭 끌어올렸습니다.

- **AOP 기반 감사 로그 정밀화**:
  - `@Audit` 커스텀 어노테이션에 `idParamName` 속성을 추가하여, 파라미터 순서나 타입이 변경되어도 정확한 Target ID를 추적할 수 있도록 AOP 확장성을 확보했습니다.
- **실전형 보안 자가 진단 방어막**:
  - `JwtUtil` 초기화(`@PostConstruct`) 단계에서 기본 시크릿 키 사용 여부를 검사하여, 배포 환경에서 실수로 취약한 키를 사용할 경우 즉시 `CRITICAL SECURITY WARNING` 로그를 발생시키도록 설계했습니다.
- **메모리 및 DB 부하 방지 (자동화)**:
  - 무한 증식하는 감사 로그로 인한 DB 병목을 막기 위해 **Spring Scheduler**를 도입, 매월 1일 새벽에 보관 주기(180일)가 지난 로그를 자동 청소(Eviction)합니다. 
  - **[Troubleshooting]** Spring Boot 3.2+ 버전 호환성을 고려하여, `AuditLogRepository`의 JPQL 파라미터 바인딩 시 `@Param` 어노테이션을 명시적으로 적용해 리눅스/클라우드 배포 환경에서의 런타임 에러(`IllegalArgumentException`)를 원천 차단했습니다.
- **커넥션 풀(HikariCP) 최적화**:
  - Supabase 무료 티어의 제한된 리소스 환경을 고려하여, `maximum-pool-size`를 명시적으로 10으로 제한해 서버의 DB 커넥션 독점 및 고갈 사태를 예방했습니다.

### 💎 코드베이스 품질 고도화 및 규격화 (v1.3)

프로젝트 전반의 유지보수성과 보안을 강화하기 위해 대대적인 리팩토링을 단행했습니다.

- **API 응답 표준화 (Standardization)**: 모든 컨트롤러의 반환형을 `ApiResponse` 객체로 통일하여, 프론트엔드에서 예측 가능하고 일관된 예외 처리 및 데이터 바인딩이 가능하도록 아키텍처를 개선했습니다.
- **최신 문법 적용 및 불변성 확보**: Java 17의 `.toList()`를 서비스 레이어 전체에 적용하여 코드 가독성을 높이고 반환된 컬렉션의 불변성(Immutability)을 보장했습니다.
- **보안 패치 (Security Update)**: 정적 분석 도구(Mend.io)를 통해 식별된 `jjwt` 라이브러리의 암호화 취약점(CVE-2024-31033)을 선제적으로 패치하여 인증 시스템의 안전성을 확보했습니다.
- **테스트 정합성 유지**: 변경된 비즈니스 로직에 맞추어 `MockMvc` 및 `Mockito` 기반의 단위 테스트 코드를 전면 갱신하여 100% 테스트 통과(`BUILD SUCCESSFUL`)를 달성했습니다.

### 💎 전역 코드 베이스 최적화 및 아키텍처 정밀 튜닝 (v1.4)

프로젝트 전반에 걸쳐 잔존하던 기술적 부채를 완전히 청산하고, 시니어급 개발 표준에 맞춘 전수 리팩토링을 완료했습니다.

- **Java 17 문법 전역 확산 (Modernization)**:
  - `FridgeService`, `RecipeService`, `SecurityConfig` 등 프로젝트 전역에서 사용되던 구식 `.collect(Collectors.toList())`를 Java 17 표준인 `.toList()`로 전수 교체했습니다.
  - 이를 통해 불필요한 보일러플레이트 코드를 제거하고 리스트의 불변성(Immutability)을 확보하여 데이터 무결성을 강화했습니다.

- **컨트롤러 계층 구조 혁신 (Architectural Integrity)**:
  - `UserController` 내 이메일 인증 및 비밀번호 재설정 로직에 산재해 있던 개별 `try-catch` 구문을 모두 제거했습니다.
  - 모든 비즈니스 예외는 `GlobalExceptionHandler`에서 중앙 집중식으로 처리하도록 아키텍처를 정립하여, 컨트롤러의 가독성을 극대화하고 에러 응답 규격을 100% 통일했습니다.

- **코드 클린업 및 정적 분석 대응 (Clean Code)**:
  - 컨트롤러 내 불필요한 패키지 풀네임 참조(`com.example...ApiResponse`)를 제거하고 임포트 최적화를 수행하여 코드 가독성을 높였습니다.
  - 인텔리제이 정적 분석 기반의 잔여 경고(Warning)를 전수 조사하여 해결함으로써 'Zero Warning' 수준의 코드 품질을 달성했습니다.

- **병합 무결성 확보 (Conflict Resolution)**:
  - 팀원과의 협업 과정에서 발생한 Git 충돌(Merge Conflict)을 해결하며 최신 리팩토링 로직과 신규 기능(냉장고 생성, 이메일 발송)을 완벽하게 통합했습니다.
  - 전수 테스트(`BUILD SUCCESSFUL`)를 통해 리팩토링 이후에도 기존 기능이 완벽하게 작동함을 검증했습니다.

### 🚀 엔터프라이즈급 아키텍처 완성 및 무결점 보안 패치 (v1.5)

프로젝트의 최종 완성도를 높이기 위해 **'AOP 기반 감사 로그 자동화'**와 **'유저 정지(Ban) 관리 시스템'**을 연동하고, 실제 운영 환경에서 발생할 수 있는 소셜 로그인 우회 등 치명적인 보안 취약점들을 철저하게 리팩토링했습니다.

#### 1. 📡 비동기(Async) AOP 기반 전역 감사 로그(Audit) 자동화
- **개요:** 관리자의 주요 활동(레시피 강제 삭제 등)을 기록할 때, 기존 비즈니스 로직에 결합되어 있던 로깅 코드를 **Spring AOP(관점 지향 프로그래밍)**를 통해 완벽히 분리(Decoupling)했습니다.
- **커스텀 어노테이션 시스템:** `@Audit` 어노테이션을 신설하여, 추적이 필요한 관리자 API 메서드 위에 선언만 하면 `AuditAspect`가 런타임에 이를 낚아채어(Pointcut) 동작하도록 자동화했습니다.
- **비동기 독립 트랜잭션:** 로그 저장이 메인 API의 응답 속도를 갉아먹지 않도록 `AsyncConfig` 스레드 풀을 통해 백그라운드에서 비동기(`@Async`)로 처리되며, 메인 로직이 실패해 롤백되더라도 로그는 무조건 남도록 안정성을 확보했습니다.

#### 2. 🚫 유저 정지(Ban) 철벽 시스템 및 보안 결함(Hotfix) 해결
- **강제 세션 만료(Eviction):** 관리자가 특정 유저를 정지시키는 즉시, 해당 유저가 발급받았던 모든 리프레시 토큰을 DB에서 강제 파기(`revokeAllForUser`)하도록 설계했습니다. 이로 인해 정지된 유저는 다음 토큰 갱신 시점에 즉각 튕겨 나가게 됩니다.
- **🔒 소셜 로그인(OAuth) 우회 프리패스 원천 차단:**
  - **문제:** 정지당한 유저가 일반 로그인이 막히더라도 카카오/네이버/구글 등 소셜 로그인 버튼을 다시 누르면 JWT를 새로 발급받아 시스템에 재침입할 수 있는 크리티컬한 우회 경로 발견.
  - **해결:** `CustomOAuth2UserService` 내부의 유저 로드 단계에서 `isBanned()` 상태를 즉시 검사하여, 정지된 회원일 경우 `OAuth2AuthenticationException("banned_user")` 예외를 강제로 던져 소셜 로그인 프로세스 자체를 셧다운시켰습니다.
- **🛡️ 관리자 '팀킬(Self-ban)' 방지 Guard Clause 추가:**
  - **문제:** 실수나 해킹으로 인해 최고 관리자(ADMIN) 계정이 정지되어 시스템 전체 통제권을 상실할 수 있는 논리적 엣지 케이스 존재.
  - **해결:** `updateUserBanStatus` 호출 시 대상 유저의 Role이 `UserRole.ADMIN`일 경우 예외를 먼저 던지도록 구현하여 시스템의 최상위 권한을 영구 보호했습니다.

---

## 🛠️ 트러블슈팅: 실전형 오류 해결 및 시스템 가용성(HA) 확보 일지

백엔드 병합 및 감사 로그 도입 과정에서 발생한 치명적인 런타임 에러들을 집요하게 추적하여 해결한 기록입니다.

### 1. PostgreSQL 예약어(Reserved Keyword) 충돌 에러
* **증상:** 서버 기동 시 `org.postgresql.util.PSQLException: ERROR: column "read" does not exist` 에러 발생과 함께 하이버네이트가 멈추는 현상.
* **원인:** `Notification` 엔티티에서 예약어 충돌을 피하기 위해 필드 컬럼명을 `is_read`로 우회했으나, 정작 클래스 상단의 `@Table` 내 `@Index` 설정에서는 옛날 이름인 `read`를 그대로 참조하고 있어 발생한 DDL 생성 오류.
* **해결:** `@Index(name = "...", columnList = "user_id, is_read")`로 인덱스가 바라보는 실제 컬럼명을 정확히 일치시켜 DB 정합성을 복구했습니다.

### 2. 외부 인프라 결함 시 '우아한 실패(Graceful Degradation)' 보장
* **증상:** 로컬 개발 환경에 Firebase FCM 인증 열쇠 파일(`.json`) 경로가 설정되지 않았을 때, `FcmService` 초기화(`@PostConstruct`) 단계에서 예외가 터지며 서버 전체가 다운되는 현상.
* **해결:** 푸시 알림은 부가 기능이므로 시스템 전체를 마비시켜선 안 된다는 판단하에, 파일이 없더라도 에러를 던지는 대신 `log.warn`으로 경고만 남기고 메서드를 부드럽게 끝내도록(`return;`) 리팩토링했습니다. 알림 기능만 비활성화된 채 메인 서버는 정상 구동되도록 가용성을 극대화했습니다.

### 3. 포트 충돌(Port 8080 already in use) 좀비 프로세스 대처
* **증상:** 코드를 수정하고 서버를 재기동할 때, 이전에 실행되던 자바 프로세스가 정상 종료되지 않고 8080 포트를 계속 독점하여 서버 기동이 무한 실패하는 현상.
* **해결:** 윈도우 운영체제(OS) 명령어를 활용해 배후의 좀비 프로세스를 직접 색출하고 강제 종료했습니다.
  1. `netstat -ano | findstr :8080` 명령어로 포트를 움켜쥐고 있는 프로세스 ID(PID) 확인.
  2. `taskkill /F /PID [확인된 PID]` 명령어로 해당 좀비 프로세스를 완벽하게 킬(Kill)하여 포트 자원을 회수했습니다.

### 🛡️ OAuth2 인증 실패 핸들러(UX/보안) 고도화 및 프론트엔드 연동 (v1.6)

소셜 로그인(OAuth) 과정에서 발생하는 예외를 서버 단에서 삼키거나 기본 에러 페이지로 넘기지 않고, **프론트엔드와 완벽하게 상호작용하는 UX/보안 통합 아키텍처**를 구축했습니다.

#### 1. 시니어급 예외 처리 (OAuth2FailureHandler)
- **문제:** 기존 스프링 시큐리티는 소셜 로그인 실패(예: 정지된 유저 접근) 시 기본 에러 페이지(`/login?error`)로 리다이렉트되어 단일 페이지 애플리케이션(SPA) 프론트엔드의 흐름이 끊기는 문제가 있었습니다.
- **해결:** `SimpleUrlAuthenticationFailureHandler`를 상속받은 커스텀 실패 핸들러(`OAuth2FailureHandler`)를 구현하여, 시큐리티 필터 체인(`SecurityConfig`)에 성공적으로 안착시켰습니다.

#### 2. 우아한 사용자 경험(UX) 및 프론트엔드 연동
- **동적 파라미터 리다이렉트:** `CustomOAuth2UserService`에서 정지된 유저를 적발해 예외를 던지면, 실패 핸들러가 이를 낚아채어 프론트엔드 콜백 URL(`.../oauth/callback`) 뒤에 `?error=banned` 라는 명확한 쿼리 파라미터를 붙여 리다이렉트 시킵니다.
- **효과:** 프론트엔드에서는 칙칙한 서버 에러 화면을 띄우는 대신, 이 쿼리 파라미터를 읽어 "정지된 계정입니다. 관리자에게 문의하세요."라는 자체적이고 깔끔한 UI 모달창을 사용자에게 띄워줄 수 있게 되었습니다. 백엔드와 프론트엔드의 완벽한 역할 분리(Decoupling)를 이뤄냈습니다.

