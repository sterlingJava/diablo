package com.ylzy56.diablo.controller;

import com.ylzy56.diablo.domain.Invoice;
import com.ylzy56.diablo.domain.entity.PageResult;
import com.ylzy56.diablo.domain.entity.Result;
import com.ylzy56.diablo.service.InvoiceService;
import com.ylzy56.diablo.service.ImportService;
import com.ylzy56.diablo.service.InvoiceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/invoice")
@Api(value = "invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    /**
     * 查询所有发票
     * @return
     */
    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有发票")
    public List<Invoice> findAll(){
        try {
            return invoiceService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 分页查询发票
     * @return
     */
    @GetMapping("/searchPage")
    @ApiOperation(value = "分页查询发票")
    public PageResult searchPage(String keyword,int pageNum, int pageSize){
        try {
            return invoiceService.searchPage(keyword,pageNum,pageSize);
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
            return invoiceService.searchNoPage(keyworde);
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
    @ApiOperation(value = "查询指定发票")
    public Invoice findById(int id){
        try {
            return invoiceService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 添加发票
     * @param invoice
     * @return
     */
    @PostMapping("/save")
    @ApiOperation(value = "添加发票")
    public Result save(Invoice invoice){
        try {
            invoiceService.save(invoice);
            return new Result(true,"添加发票成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true,"添加发票失败");
        }
    }

    /**
     * 删除发票
     * @param id
     * @return
     */
    @GetMapping("/delete")
    @ApiOperation(value = "删除发票")
    public Result delete(int id){
        try {
            invoiceService.delete(id);
            return new Result(true,"删除发票成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true,"删除发票失败");
        }
    }

    /**
     * 更新发票
     * @param invoice
     * @return
     */
    @GetMapping("/update")
    @ApiOperation(value = "更新发票")
    public Result update(Invoice invoice){
        try {
            invoiceService.update(invoice);
            return new Result(true,"更新发票成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true,"更新发票失败");
        }
    }



}
