package com.ylzy56.diablo.controller;

import com.ylzy56.diablo.domain.MailingAddress;
import com.ylzy56.diablo.domain.entity.Condition;
import com.ylzy56.diablo.domain.entity.PageResult;
import com.ylzy56.diablo.domain.entity.Result;
import com.ylzy56.diablo.service.MailingAddressService;
import com.ylzy56.diablo.service.ImportService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/mailingAddress")
@Api(value = "/mailingAddress",description = "邮寄地址接口")
public class MailingAddressController {

    @Autowired
    private ImportService importService;


    @Autowired
    private MailingAddressService mailingAddressService;


    /**
     * 分页条件查询邮寄地址
     * @return
     */
    @GetMapping("/searchPage")
    @ApiOperation(value = "分页条件查询邮寄地址")
    public PageResult searchPage(Condition condition,String enterpriseId){
        try {
            return mailingAddressService.searchPage(condition,enterpriseId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



    /**
     * 查询指定邮寄地址
     * @param id
     * @return
     */
    @GetMapping("/findById")
    @ApiOperation(value = "查询指定邮寄地址")
    public MailingAddress findById(String id) {
        try {
            return mailingAddressService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 添加邮寄地址
     * @param mailingAddress
     * @return
     */
    @PostMapping
    @ApiOperation(value = "添加邮寄地址")
    public Result save(@RequestBody MailingAddress mailingAddress,String username,String enterpriseId){
        try {
            mailingAddress.setCreator(username);
            mailingAddress.setEnterpriseId(enterpriseId);
            mailingAddressService.save(mailingAddress);
            return new Result(true,"添加邮寄地址成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"添加邮寄地址失败");
        }
    }

    /**
     * 删除邮寄地址
     * @param id
     * @return
     */
    @DeleteMapping
    @ApiOperation(value = "删除邮寄地址")
    public Result delete(String id){
        try {
            mailingAddressService.delete(id);
            return new Result(true,"删除邮寄地址成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"删除邮寄地址失败");
        }
    }

    /**
     * 更新邮寄地址
     * @param mailingAddress
     * @return
     */
    @PutMapping
    @ApiOperation(value = "更新邮寄地址")
    public Result update(@RequestBody MailingAddress mailingAddress,String username){
        try {
            mailingAddress.setLastModifier(username);
            mailingAddressService.update(mailingAddress);
            return new Result(true,"更新邮寄地址成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"更新邮寄地址失败");
        }
    }


    /**
     * excel上传
     * @param request
     * @return
     * @throws IOException
     */
    @ApiOperation(value = "导入邮寄地址")
    @ResponseBody
    @PostMapping(value="/file")
    public ResponseEntity analyzeXml(HttpServletRequest request) throws IOException {

        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        MultipartFile excelFile = files.get(0);
        if (!excelFile.getOriginalFilename().endsWith("xlsx") && !excelFile.getOriginalFilename().endsWith("xls")){
//            throw new BadRequestException("导入的文件需要为Excel类型！");
        }
        if (excelFile.isEmpty()) {
//            throw new BadRequestException("文件不能为空!");
        }
        InputStream inputStream = excelFile.getInputStream();
        List<List<String>> list = null;
        try {
            list = importService.getBankListByExcel(inputStream, excelFile.getOriginalFilename());
        } catch (Exception e) {
            e.printStackTrace();
        }
        inputStream.close();
        if (ObjectUtils.isEmpty(list)){
//            throw new BadRequestException("文件不能为空");
        }
        mailingAddressService.lead(list);

        return new ResponseEntity(HttpStatus.OK);
    }

}
