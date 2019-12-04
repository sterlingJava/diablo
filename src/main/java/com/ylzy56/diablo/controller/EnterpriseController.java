package com.ylzy56.diablo.controller;

import com.ylzy56.diablo.domain.Enterprise;
import com.ylzy56.diablo.service.EnterpriseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
     * @param enterprise
     * @return
     */
    @GetMapping("/save")
    @ApiOperation(value = "添加企业")
    public String save(Enterprise enterprise){
        return enterpriseService.save(enterprise)==0?"添加企业失败":"添加企业成功";
    }

    /**
     *删除企业
     * @param enterpriseId
     * @return
     */
    @GetMapping("/delete")
    @ApiOperation(value = "删除企业")
    public String delete(int enterpriseId){
        return enterpriseService.del(enterpriseId)==0?"添加企业失败":"添加企业成功";
    }

    /**
     * 修改企业信息
     * @param enterprise
     * @return
     */
    @GetMapping("/update")
    @ApiOperation(value = "修改企业信息")
    public String update(Enterprise enterprise){
        return enterpriseService.update(enterprise)==0?"修改企业失败":"修改企业成功";
    }

    /**
     * 根据id查询企业信息
     * @param enterpriseId
     * @return
     */
    @GetMapping("/findById")
    @ApiOperation(value = "根据id查询企业信息")
    public Enterprise findById(int enterpriseId){
        return enterpriseService.findById(enterpriseId);
    }

    /**
     * 查询所有企业信息
     * @return
     */
    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有企业信息")
    public List<Enterprise> findAll(){
        return enterpriseService.findAll();
    }

    @GetMapping("/updateStatus")
    @ApiOperation(value = "审核企业信息")
    public String updateStatus(int enterpriseId,String status){
        return enterpriseService.updateStatus(enterpriseId,status)==0 ? "审核企业失败":"审核企业完成";
    }
}
