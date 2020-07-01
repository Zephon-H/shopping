package com.zephon.manager.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.manager.config
 * @date 2020/7/1 下午8:04
 * @Copyright ©
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 配置用户权限组和接口路径的关系
     * 和一些其他配置
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()     // 对请求进行验证
////                .antMatchers("/login.html").permitAll()
//                .antMatchers("/login_error").permitAll()
//                .antMatchers("/css/**").permitAll()
//                .antMatchers("/js/**").permitAll()
//                .antMatchers("/img/**").permitAll()
//                .antMatchers("/**").hasRole("USER")     // 必须有ADMIN权限
////                .antMatchers("/user/**").hasAnyRole("USER", "ADMIN")       //有任意一种权限
//                .anyRequest()     //任意请求（这里主要指方法）
//                .authenticated()   //// 需要身份认证
//                .and()   //表示一个配置的结束
//                .formLogin()
//                .loginPage("/login.html").permitAll()
//                .successForwardUrl("/admin/index.html")
////                .defaultSuccessUrl("/admin/index.html")
//                .failureUrl("/login_error.html")
////                .formLogin().permitAll()  //开启SpringSecurity内置的表单登录，会提供一个/login接口
//                .and()
//                .logout().permitAll()  //开启SpringSecurity内置的退出登录，会为我们提供一个/logout接口
//                .and()
//                .csrf().disable();    //关闭csrf跨站伪造请求
        http.formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/admin/index.html", true)
                .permitAll()
                .and()
                .authorizeRequests()
//                .antMatchers("/*.html").permitAll()
                .antMatchers("/*.html").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/img/**").permitAll()
                .antMatchers("/plugins/**").permitAll()
                .antMatchers("/**").hasRole("USER")
                .and()
                .headers().frameOptions().sameOrigin()
                .and()
                .logout()
                .and()
                .csrf().disable();        //暂时禁用CSRF，否则无法提交表单
    }

    /**
     * 重写该方法，添加自定义用户
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("admin").roles("USER");
    }
}
