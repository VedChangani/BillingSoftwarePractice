package com.example.BillingSoftwarePractice.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRequest {
    private String name;
    private String bgColor;
    private String description;
}
