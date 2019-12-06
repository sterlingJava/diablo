package com.ylzy56.diablo.controller;

import com.ylzy56.diablo.domain.Customer;
import com.ylzy56.diablo.domain.entity.Condition;
import com.ylzy56.diablo.domain.entity.PageResult;
import com.ylzy56.diablo.domain.entity.Result;
import com.ylzy56.diablo.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/customer")
@Api(value = "Customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * 查询所有客户列表
     * @return
     */
    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有客户列表")
    public List<Customer> findAll(){
        try {
            return customerService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 分页查询客户列表
     * @return
     */
    @GetMapping("/findPage")
    @ApiOperation(value = "分页查询客户列表")
    public PageResult findPage(int pageNum, int pageSize){
        try {
            return customerService.findPage(pageNum,pageSize);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 分页条件查询客户列表
     * @return
     */
    @GetMapping("/searchPage")
    @ApiOperation(value = "分页条件查询客户列表")
    public PageResult searchPage(Condition condition, int pageNum, int pageSize){
        try {
            return customerService.searchPage(condition,pageNum,pageSize);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 查询指定客户信息
     * @param customerId
     * @return
     */
    @GetMapping("/findById")
    @ApiOperation(value = "查询指定客户信息")
    public Customer findById(int customerId){
        try {
            return customerService.findById(customerId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 添加客户
     * @param customer
     * @return
     */
    @PostMapping("/save")
    @ApiOperation(value = "添加客户")
    public Result save(Customer customer){
        try {
            customerService.save(customer);
            return new Result(true,"添加客户成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true,"添加客户失败");
        }
    }

    /**
     * 删除客户
     * @param customerId
     * @return
     */
    @GetMapping("/delete")
    @ApiOperation(value = "删除客户")
    public Result delete(int customerId){
        try {
            customerService.delete(customerId);
            return new Result(true,"删除客户成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true,"删除客户失败");
        }
    }

    /**
     * 更新客户
     * @param customer
     * @return
     */
    @GetMapping("/update")
    @ApiOperation(value = "更新客户")
    public Result update(Customer customer){
        try {
            customerService.update(customer);
            return new Result(true,"更新客户成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true,"更新客户失败");
        }
    }
}
