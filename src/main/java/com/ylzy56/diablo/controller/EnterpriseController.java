package com.ylzy56.diablo.controller;

import com.ylzy56.diablo.domain.Enterprise;
import com.ylzy56.diablo.domain.entity.Condition;
import com.ylzy56.diablo.domain.entity.PageResult;
import com.ylzy56.diablo.domain.entity.Result;
import com.ylzy56.diablo.service.EnterpriseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enterprise")
@Api(value = "/enterprise",description = "企业接口")
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    /**
     * 添加企业
     *
     * @param enterprise
     * @return
     */
    @PostMapping
    @ApiOperation(value = "添加企业")
    public Result save(@RequestBody Enterprise enterprise) {
        try {
            enterpriseService.save(enterprise);
            return new Result(true, "添加企业成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "添加企业失败");
        }
    }

    /**
     * 删除企业
     *
     * @param enterpriseId
     * @return
     */
    @DeleteMapping
    @ApiOperation(value = "删除企业")
    public Result delete(String enterpriseId) {
        try {
            enterpriseService.delete(enterpriseId);
            return new Result(true, "删除企业成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除企业失败");
        }
    }

    /**
     * 修改企业信息
     *
     * @param enterprise
     * @return
     */
    @PutMapping
    @ApiOperation(value = "修改企业信息")
    public Result update(@RequestBody Enterprise enterprise) {
        try {
            enterpriseService.update(enterprise);
            return new Result(true, "更新企业成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "更新企业失败");
        }
    }

    /**
     * 根据id查询企业信息
     *
     * @param enterpriseId
     * @return
     */
    @GetMapping("/findById")
    @ApiOperation(value = "根据id查询企业信息")
    public Enterprise findById(String enterpriseId) {
        try {
            return enterpriseService.findById(enterpriseId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 审核企业信息
     * @param enterpriseId
     * @param status
     * @return
     */
    @PutMapping ("/updateStatus")
    @ApiOperation(value = "审核企业信息")
    public Result updateStatus(String enterpriseId, String status,String remark) {
        try {
            enterpriseService.updateStatus(enterpriseId, status,remark);
            return new Result(true, "审核企业成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "审核企业失败");
        }
    }

    /**
     * 分页条件查询企业列表
     *
     * @return
     */
    @GetMapping("/searchPage")
    @ApiOperation(value = "分页条件查询企业列表")
    public PageResult searchPage( Condition condition) {
        try {
            return enterpriseService.searchPage(condition);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
