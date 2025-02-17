package com.samplespringbootcode.blog.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {
    private String title;
    private String content;

    private String imageName;

    private Date addedDate;

    private CategoryDto categoryDto;

    private UserDto userDto;
}
