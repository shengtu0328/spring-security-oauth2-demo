package com.xrq.oauth2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @Author: rqxiao
 * @Date: 2020-1-23 13:45
 * @Description:
 */
@Configuration
public class TokenStoreConfig {


    @Configuration
    public static class JwtTokenConfig {



        //token的存取 不管token的生成
        @Bean
        public TokenStore JwtTokenStore() {
            return new JwtTokenStore(jwtAccessTokenConverter());
        }


        //做一些token的生成
        @Bean
        public JwtAccessTokenConverter jwtAccessTokenConverter() {
            JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
            jwtAccessTokenConverter.setSigningKey("imooc");//密签
            return jwtAccessTokenConverter;
        }


    }


}
