package com.ylzy56.diablo.controller;

import com.ylzy56.diablo.domain.Address;
import com.ylzy56.diablo.domain.Customer;
import com.ylzy56.diablo.domain.Order;
import com.ylzy56.diablo.domain.entity.Condition;
import com.ylzy56.diablo.domain.entity.OrderVo;
import com.ylzy56.diablo.domain.entity.PageResult;
import com.ylzy56.diablo.domain.entity.Result;
import com.ylzy56.diablo.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@Api(value = "/order",description = "订单接口")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 分页条件查询订单列表
     * @return
     */
    @GetMapping("/searchPage")
    @ApiOperation(value = "分页条件查询订单列表")
    public PageResult searchPage(@RequestBody Condition condition,String enterpriseId){
        try {
            return orderService.searchPage(condition,enterpriseId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 查询指定订单信息
     * @param orderId
     * @return
     */
    @GetMapping("/findById")
    @ApiOperation(value = "查询指定订单信息")
    public Order findById(String orderId){
        try {
            return orderService.findById(orderId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 添加订单
     * @param order
     * @return
     */
    @PostMapping("/save")
    @ApiOperation(value = "添加订单")
    public Result save(@RequestBody Order order,String username,String enterpriseId){
        try {
            order.setCreator(username);
            order.setEnterpriseId(enterpriseId);
            orderService.save(order);
            return new Result(true,"添加订单成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true,"添加订单失败");
        }
    }

    /**
     * 删除订单
     * @param orderId
     * @return
     */
    @DeleteMapping("/delete")
    @ApiOperation(value = "删除订单")
    public Result delete(String orderId){
        try {
            orderService.delete(orderId);
            return new Result(true,"删除订单成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true,"删除订单失败");
        }
    }

    /**
     * 更新订单
     * @param order
     * @return
     */
    @PutMapping("/update")
    @ApiOperation(value = "更新订单")
    public Result update(@RequestBody Order order,String username){
        try {
            order.setLastModifier(username);
            orderService.update(order);
            return new Result(true,"更新订单成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true,"更新订单失败");
        }
    }

    /**
     * 导出订单
     * @return
     */
    @GetMapping("/exportOrder")
    @ApiOperation(value = "导出订单")
    public Result exportOrder(){
        return null;
    }
}
