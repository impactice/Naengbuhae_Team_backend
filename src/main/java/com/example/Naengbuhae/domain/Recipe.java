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