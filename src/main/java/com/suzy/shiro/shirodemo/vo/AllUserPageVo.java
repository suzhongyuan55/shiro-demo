package com.suzy.shiro.shirodemo.vo;

import com.suzy.shiro.shirodemo.enity.UserInfo;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @Author Suzy
 * @Date 2021-03-28
 */
@Data
public class AllUserPageVo {

    // 当前页数
    private Integer page;

    // 总记录数
    private Integer count;

    // 条数
    private Integer size;

    // 数据
    private List<UserInfo> data;
}
