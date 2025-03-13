package com.dxm.dxmbe.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.time.Instant;
import java.util.Date;

public interface BillRequest {

    @Setter
    @Getter
    @Builder
    public class createBill{
        private String name;
        private String description;
        private Long categoryId;
        private Long userId;
        private Double amount;
        private Long date;
    }
}
