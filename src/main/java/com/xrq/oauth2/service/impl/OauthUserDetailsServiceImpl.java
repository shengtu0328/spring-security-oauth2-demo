package com.xrq.oauth2.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xrq.oauth2.mapper.OauthUserDetailsMapper;
import com.xrq.oauth2.pojo.OauthUserDetails;
import com.xrq.oauth2.service.OauthUserDetailsService;
import org.springframework.stereotype.Service;


@Service
public class OauthUserDetailsServiceImpl extends ServiceImpl<OauthUserDetailsMapper, OauthUserDetails> implements OauthUserDetailsService {


    @Override
    public OauthUserDetails findByUsername(String userName) {
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userName);
        return baseMapper.selectOne(queryWrapper);
    }

}


