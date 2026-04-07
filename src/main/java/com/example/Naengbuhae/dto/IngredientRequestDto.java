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