package com.qy25.sm.entity.base;

import lombok.Data;

import java.util.Date;
@Data
public class BaseEntity<ID> {
    private ID id;
    private Date addTime;

    private Long creatorId;

    private Date updateTime;

    private Long updateId;
}
