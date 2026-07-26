package com.example.BillingSoftwarePractice.dto;


import lombok.*;

import java.sql.Timestamp;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryResponse {

    private String categoryId;
    private String name;
    private String bgColor;
    private String description;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String imgUrl;
}
