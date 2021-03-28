package com.suzy.shiro.shirodemo.vo;

import lombok.Data;

/**
 * @Author Suzy
 * @Date 2021-03-28
 */
@Data
public class SelectNameVO {

    // 当前页数
    private Integer page;

    // 每页多少条
    private Integer size;

    // 从第几条开始查
    private Integer limit ;

    private String userName;

    private String realName;

    public Integer getLimit() {
        this.limit = (page - 1) * size;
        return limit;
    }
}
