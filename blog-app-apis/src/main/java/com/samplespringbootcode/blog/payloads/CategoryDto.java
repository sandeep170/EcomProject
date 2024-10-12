package com.samplespringbootcode.blog.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

    private Integer categoryId;

    @NotEmpty(message = "Title is invalid/notProvided !!")
    @Size(min = 3, message = "Title must be min 10 character !!")
    private String categoryTitle;

    @NotEmpty(message = "Description is not provided !!")
    private String categoryDescription;
}
