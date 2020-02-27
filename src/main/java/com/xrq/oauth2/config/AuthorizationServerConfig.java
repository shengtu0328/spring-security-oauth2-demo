package com.xrq.oauth2.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.ArrayList;

/**
 * @Author: rqxiao
 * @Date: 2020-1-22 09:54
 * @Description:
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    @Resource
    private DataSource dataSource;
    @Bean
    public ClientDetailsService clientDetails() {
        return new JdbcClientDetailsService(dataSource);
    }


    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

        endpoints
                .accessTokenConverter(jwtAccessTokenConverter)
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService);//refresh_token 的调用需要配置这个
    }


    @Autowired
    public PasswordEncoder passwordEncoder;

    //第三方应用的配置 clientId clientSecret 以这里配置的为准
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        clients.withClientDetails(clientDetails());


        //     clients.jdbc(); clients信息存在数据库
        //     clients.inMemory(); clients信息存在内存
//        clients.inMemory()
//                .withClient("imooc")
//                .secret(passwordEncoder.encode("imoocsecret"))
//                .accessTokenValiditySeconds(7200)//token有效时间 单位：秒  即/oauth/token 返回结果中的expires_in
//                .authorizedGrantTypes("refresh_token", "password","authorization_code")//对当前这个client  如imooc支持的授权模式 没有写出来的就不支持
//                .scopes("all","read","write");//发送出去token的权限 (oauth中的权限)  这里配了，客户端发请求就可以不带scope参数        如果请求传的scope不在配置的范围里会报错
//

//
//                .and()
//                .withClient("xxxxxxxxx");//认证服务器想支持多个应用 可以这样配置






    }


    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.allowFormAuthenticationForClients()
                .checkTokenAccess("isAuthenticated()");
    }










}
