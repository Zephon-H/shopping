package com.zephon.sellergoods.controller;

import com.github.pagehelper.PageInfo;
import com.zephon.http.Result;
import com.zephon.pojo.TbBrand;
import com.zephon.pojo.TbSeller;
import com.zephon.sellergoods.service.SellerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.sellergoods.controller
 * @date 2020/7/2 上午8:56
 * @Copyright ©
 */
@RestController
@Slf4j
@RequestMapping("/seller")
public class SellerController {
    @Resource
    private SellerService sellerService;

    @PostMapping("/list")
    public PageInfo<TbSeller> list(@RequestParam(value = "page",required = false,defaultValue = "1")int page,
                                  @RequestParam(value = "size",required = false,defaultValue = "0")int size,
                                  @RequestBody TbSeller seller){
        return sellerService.findAll(page,size,seller);
    }

    @GetMapping("/{id}")
    public TbSeller findById(@PathVariable("id")String id){
        return sellerService.findById(id);
    }


    @PostMapping("/add")
    public Result add(@RequestBody TbSeller seller) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = encoder.encode(seller.getPassword());
        seller.setPassword(password);
        try {
            int count = sellerService.add(seller);
            if(count>0){
                // 添加成功
                return new Result(true,"增加成功");
            }
        } catch (Exception e) {
//            e.printStackTrace();
        }
        // 添加失败
        return new Result(false,"增加失败");
    }

    @GetMapping("/updateStatus")
    public Result updateStatus(@RequestParam("sellerId") String sellerId,@RequestParam("status") String status){
        try {
            sellerService.updateStatus(sellerId,status);
            return new Result(true);
        }catch (Exception e){

        }
        return new Result(false,"修改状态失败");
    }

}
