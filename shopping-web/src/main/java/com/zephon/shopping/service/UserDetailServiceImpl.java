package com.zephon.shopping.service;

import com.zephon.pojo.TbSeller;
import com.zephon.shopping.config.SpringBeanUtil;
import com.zephon.shopping.service.SellerFeignService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.shopping.service
 * @date 2020/7/2 上午10:09
 * @Copyright ©
 */
@Component
public class UserDetailServiceImpl implements UserDetailsService {
    // 不能注入，注入为null
//    @Resource
//    private SellerFeignService sellerFeignService;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SellerFeignService sellerFeignService = SpringBeanUtil.getBean(SellerFeignService.class);
        // 构建角色集合
        List<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority("ROLE_USER"));
        TbSeller seller = sellerFeignService.findById(s);
        if(seller!=null&&seller.getStatus().equals("1")){
            return new User(s,seller.getPassword(),authorityList);
        }
        return null;
    }
}
