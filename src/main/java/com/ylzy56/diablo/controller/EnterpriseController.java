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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/enterprise")
@Api(value = "Enterprise")
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    /**
     * 添加企业
     *
     * @param enterprise
     * @return
     */
    @PostMapping("/save")
    @ApiOperation(value = "添加企业")
    public Result save(Enterprise enterprise) {
        try {
            enterpriseService.save(enterprise);
            return new Result(true, "添加企业成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true, "添加企业失败");
        }
    }

    /**
     * 删除企业
     *
     * @param enterpriseId
     * @return
     */
    @GetMapping("/delete")
    @ApiOperation(value = "删除企业")
    public Result delete(String enterpriseId) {
        try {
            enterpriseService.delete(enterpriseId);
            return new Result(true, "删除企业成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true, "删除企业失败");
        }
    }

    /**
     * 修改企业信息
     *
     * @param enterprise
     * @return
     */
    @GetMapping("/update")
    @ApiOperation(value = "修改企业信息")
    public Result update(Enterprise enterprise) {
        try {
            enterpriseService.update(enterprise);
            return new Result(true, "更新企业成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true, "更新企业失败");
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
    @GetMapping("/updateStatus")
    @ApiOperation(value = "审核企业信息")
    public Result updateStatus(String enterpriseId, String status,String remark) {
        try {
            enterpriseService.updateStatus(enterpriseId, status,remark);
            return new Result(true, "审核企业成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true, "审核企业失败");
        }
    }

    /**
     * 分页条件查询企业列表
     *
     * @return
     */
    @GetMapping("/searchPage")
    @ApiOperation(value = "分页条件查询企业列表")
    public PageResult searchPage(Condition condition, Integer pageNum, Integer pageSize) {
        try {
            return enterpriseService.searchPage(condition, pageNum, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
