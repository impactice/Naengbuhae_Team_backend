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