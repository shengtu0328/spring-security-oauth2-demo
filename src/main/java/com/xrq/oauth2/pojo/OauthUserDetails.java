package com.xrq.oauth2.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @Author: rqxiao
 * @Date: 2020-2-24 15:53
 * @Description:
 */
@TableName("oauth_user_details")
@Data
public class OauthUserDetails {


    private String username;
    private String password;

    /**
     * 主键ID
     */
    @TableId
    private String id;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

}

