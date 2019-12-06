package com.ylzy56.diablo.controller;

import com.ylzy56.diablo.domain.Address;
import com.ylzy56.diablo.domain.Bill;
import com.ylzy56.diablo.domain.entity.PageResult;
import com.ylzy56.diablo.domain.entity.Result;
import com.ylzy56.diablo.service.BillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bill")
@Api(value = "bill")
public class BillController {



    @Autowired
    private BillService billService;

    /**
     * 查询所有账单
     * @return
     */
    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有账单")
    public List<Bill> findAll(){
        try {
            return billService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 分页查询账单
     * @return
     */
    @GetMapping("/searchPage")
    @ApiOperation(value = "分页查询账单")
    public PageResult searchPage(String keyword,int pageNum, int pageSize){
        try {
            return billService.searchPage(keyword,pageNum,pageSize);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据条件查询运单
     * @return
     */
    @GetMapping("/searchNoPage")
    @ApiOperation(value = "根据条件查询运单")
    public PageResult searchNoPage(String keyworde){
        try {
            return billService.searchNoPage(keyworde);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 查询指定
     * @param id
     * @return
     */
    @GetMapping("/findById")
    @ApiOperation(value = "查询指定账单")
    public Bill findById(int id){
        try {
            return billService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 添加账单
     * @param bill
     * @return
     */
    @PostMapping("/save")
    @ApiOperation(value = "添加账单")
    public Result save(Bill bill){
        try {
            billService.save(bill);
            return new Result(true,"添加账单成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true,"添加账单失败");
        }
    }

    /**
     * 删除账单
     * @param id
     * @return
     */
    @GetMapping("/delete")
    @ApiOperation(value = "删除账单")
    public Result delete(int id){
        try {
            billService.delete(id);
            return new Result(true,"删除账单成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true,"删除账单失败");
        }
    }

    /**
     * 更新账单
     * @param bill
     * @return
     */
    @GetMapping("/update")
    @ApiOperation(value = "更新账单")
    public Result update(Bill bill){
        try {
            billService.update(bill);
            return new Result(true,"更新账单成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true,"更新账单失败");
        }
    }



}
