package com.dxm.dxmbe.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public interface CategoryRequest {

    @Setter
    @Getter
    @Builder
    public class createCategory {
        private String name;
        private String description;
        private String icon;
    }
}
