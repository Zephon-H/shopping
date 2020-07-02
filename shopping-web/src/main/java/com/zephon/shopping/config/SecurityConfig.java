package com.zephon.shopping.config;

import com.netflix.discovery.converters.Auto;
import com.zephon.shopping.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.manager.config
 * @date 2020/7/1 下午8:04
 * @Copyright ©
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new UserDetailServiceImpl()).passwordEncoder(new BCryptPasswordEncoder());
    }

    /**
     * 配置用户权限组和接口路径的关系
     * 和一些其他配置
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/admin/index.html", true)
                .permitAll()
                .and()
                .authorizeRequests()
//                .antMatchers("/*.html").permitAll()
                .antMatchers("/*.html").permitAll()
                .antMatchers("/seller/add").permitAll()
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

//    /**
//     * 重写该方法，添加自定义用户
//     */
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin").password("admin").roles("USER");
//    }
}
