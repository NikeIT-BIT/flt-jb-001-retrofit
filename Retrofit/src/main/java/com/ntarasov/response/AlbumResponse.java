package com.ntarasov.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter

public class AlbumResponse {
    private Integer userId;
    private Integer id;
    private String title;
}
