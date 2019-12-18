package com.ylzy56.diablo.controller;

import com.ylzy56.diablo.domain.Customer;
import com.ylzy56.diablo.domain.entity.Condition;
import com.ylzy56.diablo.domain.entity.PageResult;
import com.ylzy56.diablo.domain.entity.Result;
import com.ylzy56.diablo.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@Api(value = "/customer",description = "客户接口")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * 分页查询客户列表
     * @return
     *//*
    @GetMapping("/findPage")
    @ApiOperation(value = "分页查询客户列表")
    public PageResult findPage(Integer pageNum, Integer pageSize){
        try {
            return customerService.findPage(pageNum,pageSize);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }*/

    /**
     * 条件查询客户列表
     * @return
     *//*
    @GetMapping("/searchCustomerList")
    @ApiOperation(value = "条件查询客户列表")
    public PageResult searchCustomerList(Condition condition){
        try {
            return customerService.searchCustomerList(condition);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }*/

    /**
     * 分页条件查询客户列表
     * @return
     */
    @GetMapping("/searchPage")
    @ApiOperation(value = "分页条件查询客户列表")
    public PageResult searchPage(@RequestBody Condition condition,String enterpriseId){
        try {
            return customerService.searchPage(condition,enterpriseId);
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
    public Customer findById(String customerId){
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
    @PostMapping
    @ApiOperation(value = "添加客户")
    public Result save(@RequestBody Customer customer,String username,String enterpriseId){
        try {
            customer.setCreator(username);
            customer.setEnterpriseId(enterpriseId);
            customerService.save(customer);
            return new Result(true,"添加客户成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"添加客户失败");
        }
    }

    /**
     * 删除客户
     * @param customerId
     * @return
     */
    @DeleteMapping
    @ApiOperation(value = "删除客户")
    public Result delete(String customerId){
        try {
            customerService.delete(customerId);
            return new Result(true,"删除客户成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"删除客户失败");
        }
    }

    /**
     * 更新客户
     * @param customer
     * @return
     */
    @PutMapping
    @ApiOperation(value = "更新客户")
    public Result update(@RequestBody Customer customer,String username){
        try {
            customer.setLastModifier(username);
            customerService.update(customer);
            return new Result(true,"更新客户成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"更新客户失败");
        }
    }

    /**
     * 导入客户
     * @return
     */
    @GetMapping("/importCustomerList")
    @ApiOperation(value = "导入客户")
    public Result importCustomerList(){
        return null;
    }

    /**
     * 导出客户
     * @return
     */
    @GetMapping("/exportCustomerList")
    @ApiOperation(value = "导出客户")
    public Result exportCustomerList(){
        return null;
    }
}
