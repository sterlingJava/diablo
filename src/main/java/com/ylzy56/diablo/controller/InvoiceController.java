package com.ylzy56.diablo.controller;

import com.ylzy56.diablo.domain.Address;
import com.ylzy56.diablo.domain.entity.PageResult;
import com.ylzy56.diablo.domain.entity.Result;
import com.ylzy56.diablo.service.AddressService;
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
import java.util.List;

@RestController
@RequestMapping("/address")
@Api(value = "address")
public class InvoiceController {

    @Autowired
    private ImportService importService;


    @Autowired
    private AddressService addressService;

    /**
     * 查询所有地址
     * @return
     */
    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有地址")
    public List<Address> findAll(){
        try {
            return addressService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 分页查询地址
     * @return
     */
    @GetMapping("/searchPage")
    @ApiOperation(value = "分页查询地址")
    public PageResult searchPage(String keyword,int pageNum, int pageSize){
        try {
            return addressService.searchPage(keyword,pageNum,pageSize);
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
            return addressService.searchNoPage(keyworde);
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
    @ApiOperation(value = "查询指定地址")
    public Address findById(int id){
        try {
            return addressService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 添加地址
     * @param address
     * @return
     */
    @PostMapping("/save")
    @ApiOperation(value = "添加地址")
    public Result save(Address address){
        try {
            addressService.save(address);
            return new Result(true,"添加用户成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true,"添加用户失败");
        }
    }

    /**
     * 删除地址
     * @param id
     * @return
     */
    @GetMapping("/delete")
    @ApiOperation(value = "删除地址")
    public Result delete(int id){
        try {
            addressService.delete(id);
            return new Result(true,"删除用户成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true,"删除用户失败");
        }
    }

    /**
     * 更新地址
     * @param address
     * @return
     */
    @GetMapping("/update")
    @ApiOperation(value = "更新地址")
    public Result update(Address address){
        try {
            addressService.update(address);
            return new Result(true,"更新地址成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(true,"更新地址失败");
        }
    }


    /**
     * excel上传
     * @param request
     * @return
     * @throws IOException
     */
    @ApiOperation(value = "导入地址")
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
        addressService.lead(list);

        return new ResponseEntity(HttpStatus.OK);
    }

}
