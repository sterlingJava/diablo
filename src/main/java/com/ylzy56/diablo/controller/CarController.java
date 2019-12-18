package com.ylzy56.diablo.controller;

import com.ylzy56.diablo.domain.Address;
import com.ylzy56.diablo.domain.Car;
import com.ylzy56.diablo.domain.entity.Condition;
import com.ylzy56.diablo.domain.entity.PageResult;
import com.ylzy56.diablo.domain.entity.Result;
import com.ylzy56.diablo.service.CarService;
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
@RequestMapping("/car")
@Api(value = "/car",description = "车辆接口")
public class CarController {

    @Autowired
    private ImportService importService;


    @Autowired
    private CarService carService;


    /**
     * 分页条件查询车辆
     * @return
     */
    @GetMapping("/searchPage")
    @ApiOperation(value = "分页条件查询车辆")
    public PageResult searchPage(@RequestBody Condition condition,String enterpriseId){
        try {
            return carService.searchPage(condition,enterpriseId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据车辆类型查询车辆数量
     * @return
     */
    @GetMapping("/findByProperties")
    @ApiOperation(value = "根据车辆类型查询车辆数量")
    public Map findByProperties(String enterpriseId){
        try {
            Map map = new HashMap();
            Integer privateNum = carService.findByProperties("自有车", enterpriseId);
            Integer transferNum = carService.findByProperties("外调车", enterpriseId);
            map.put("privateNum",privateNum);
            map.put("transferNum",transferNum);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 查询指定车辆
     * @param id
     * @return
     */
    @GetMapping("/findById")
    @ApiOperation(value = "查询指定车辆")
    public Car findById(String id) {
        try {
            return carService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 添加车辆
     * @param car
     * @return
     */
    @PostMapping
    @ApiOperation(value = "添加车辆")
    public Result save(@RequestBody Car car,String username,String enterpriseId){
        try {
            car.setCreator(username);
            car.setLastModifier(enterpriseId);
            carService.save(car);
            return new Result(true,"添加车辆成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"添加车辆失败");
        }
    }

    /**
     * 删除车辆
     * @param id
     * @return
     */
    @DeleteMapping
    @ApiOperation(value = "删除车辆")
    public Result delete(String id){
        try {
            carService.delete(id);
            return new Result(true,"删除车辆成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"删除车辆失败");
        }
    }

    /**
     * 更新车辆
     * @param car
     * @return
     */
    @PutMapping
    @ApiOperation(value = "更新车辆")
    public Result update(@RequestBody Car car,String username){
        try {
            car.setLastModifier(username);
            carService.update(car);
            return new Result(true,"更新车辆成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"更新车辆失败");
        }
    }


    /**
     * excel上传
     * @param request
     * @return
     * @throws IOException
     */
    @ApiOperation(value = "导入车辆")
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
        carService.lead(list);

        return new ResponseEntity(HttpStatus.OK);
    }

}
