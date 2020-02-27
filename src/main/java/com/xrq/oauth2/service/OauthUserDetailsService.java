package com.xrq.oauth2.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xrq.oauth2.pojo.OauthUserDetails;


public interface OauthUserDetailsService extends IService<OauthUserDetails> {

    OauthUserDetails findByUsername(String userName);


}
