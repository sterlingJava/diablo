package com.ylzy56.diablo.controller;

import com.ylzy56.diablo.domain.Invoice;
import com.ylzy56.diablo.domain.InvoiceTitle;
import com.ylzy56.diablo.domain.entity.PageResult;
import com.ylzy56.diablo.domain.entity.Result;
import com.ylzy56.diablo.service.InvoiceTitleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/invoiceTitle")
@Api(value = "invoiceTitle")
public class InvoiceTitleController {


    @Autowired
    private InvoiceTitleService invoiceTitleService;

    /**
     * 查询所有发票抬头
     * @return
     */
    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有发票抬头")
    public List<InvoiceTitle> findAll(){
        try {
            return invoiceTitleService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 分页查询发票抬头
     * @return
     */
    @GetMapping("/searchPage")
    @ApiOperation(value = "分页查询发票抬头")
    public PageResult searchPage(String keyword, int pageNum, int pageSize){
        try {
            return invoiceTitleService.searchPage(keyword,pageNum,pageSize);
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
            return invoiceTitleService.searchNoPage(keyworde);
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
    @ApiOperation(value = "查询指定发票抬头")
    public InvoiceTitle findById(int id){
        try {
            return invoiceTitleService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 添加发票抬头
     * @param invoiceTitle
     * @return
     */
    @PostMapping("/save")
    @ApiOperation(value = "添加发票抬头")
    public Result save(InvoiceTitle invoiceTitle){
        try {
            invoiceTitleService.save(invoiceTitle);
            return new Result(true,"添加发票抬头成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true,"添加发票抬头失败");
        }
    }

    /**
     * 删除发票抬头
     * @param id
     * @return
     */
    @GetMapping("/delete")
    @ApiOperation(value = "删除发票抬头")
    public Result delete(int id){
        try {
            invoiceTitleService.delete(id);
            return new Result(true,"删除发票抬头成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true,"删除发票抬头失败");
        }
    }

    /**
     * 更新发票抬头
     * @param invoiceTitle
     * @return
     */
    @GetMapping("/update")
    @ApiOperation(value = "更新发票抬头")
    public Result update(InvoiceTitle invoiceTitle){
        try {
            invoiceTitleService.update(invoiceTitle);
            return new Result(true,"更新发票抬头成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true,"更新发票抬头失败");
        }
    }

}
