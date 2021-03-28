package com.suzy.shiro.shirodemo.enity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;

/**
 * @Author Suzy
 * @Date 2021-03-27
 */
@Data
@TableName("user_info")
@Accessors(chain = true)
public class UserInfo extends Model<UserInfo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    private String userName;

    private String password;

    private String realName;

    private Date createTime;

    private Date updateTime;

    private Integer status;

    private String perms;

}
