package com.ntarasov.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class AlbumUpdateRequest {
    private Integer userId;
    private Integer id;
    private String title;
}
