package com.ylzy56.diablo.controller;

import com.ylzy56.diablo.domain.Invoice;
import com.ylzy56.diablo.domain.InvoiceTitle;
import com.ylzy56.diablo.domain.entity.PageResult;
import com.ylzy56.diablo.domain.entity.Result;
import com.ylzy56.diablo.service.InvoiceTitleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoiceTitle")
@Api(value = "invoiceTitle",description = "发票抬头接口")
public class InvoiceTitleController {


    @Autowired
    private InvoiceTitleService invoiceTitleService;


    /**
     * 查询正在使用的发票抬头
     * @return
     */
    @GetMapping("/findBeUse")
    @ApiOperation(value = "查询正在使用的发票抬头")
    public InvoiceTitle findBeUse(String enterpriseId){
        try {
            return invoiceTitleService.findBeUse("0",enterpriseId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 保存发票抬头
     * @param invoiceTitle
     * @return
     */
    @PostMapping
    @ApiOperation(value = "保存发票抬头")
    public Result save(@RequestBody InvoiceTitle invoiceTitle, String username, String enterpriseId){
        try {
            invoiceTitle.setCreator(username);
            invoiceTitle.setEnterpriseId(enterpriseId);
            invoiceTitleService.save(invoiceTitle);
            return new Result(true,"保存发票抬头成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true,"保存发票抬头失败");
        }
    }

}
