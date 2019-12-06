package com.ylzy56.diablo.controller;

import com.ylzy56.diablo.domain.Waybill;
import com.ylzy56.diablo.domain.entity.PageResult;
import com.ylzy56.diablo.domain.entity.Result;
import com.ylzy56.diablo.service.WayBillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/wayBill")
@Api(value = "wayBill")
public class WayBillController {


    @Autowired
    private WayBillService wayBillService;

    /**
     * 查询所有运单
     * @return
     */
    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有运单")
    public List<Waybill> findAll(){
        try {
            return wayBillService.findAll();
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
            return wayBillService.searchNoPage(keyworde);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



    /**
     * 分页查询运单
     * @return
     */
    @GetMapping("/searchPage")
    @ApiOperation(value = "分页查询运单")
    public PageResult searchPage(String keyword,int pageNum, int pageSize){
        try {
            return wayBillService.searchPage(keyword,pageNum,pageSize);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 查询指定运单
     * @param id
     * @return
     */
    @GetMapping("/findById")
    @ApiOperation(value = "查询指定运单")
    public Waybill findById(int id){
        try {
            return wayBillService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 添加运单：新增运单时也需要新增相应的账单
     * @param address
     * @return
     */
    @PostMapping("/save")
    @ApiOperation(value = "添加运单")
    public Result save(Waybill address){
        try {
            wayBillService.save(address);
            return new Result(true,"添加运单成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true,"添加运单失败");
        }
    }

    /**
     * 删除运单
     * @param id
     * @return
     */
    @GetMapping("/delete")
    @ApiOperation(value = "删除运单")
    public Result delete(int id){
        try {
            wayBillService.delete(id);
            return new Result(true,"删除运单成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true,"删除运单失败");
        }
    }

    /**
     * 更新运单
     * @param address
     * @return
     */
    @GetMapping("/update")
    @ApiOperation(value = "更新运单")
    public Result update(Waybill address){
        try {
            wayBillService.update(address);
            return new Result(true,"更新运单成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true,"更新运单失败");
        }
    }
    

}
