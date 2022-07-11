package com.ntarasov.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class AlbumRequest {
    private Integer userId;
    private String title;
}
