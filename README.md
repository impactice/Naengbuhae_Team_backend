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
