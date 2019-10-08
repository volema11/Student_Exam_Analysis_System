package com.mac.demo.controller;

import com.mac.demo.model.SelectQuestion;
import com.mac.demo.service.SelectQuestionService;
import com.mac.demo.vo.QuerySelectQuestionVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Classname SelectQuestionController
 * @Description TODO
 * @Date 2019/9/12 1:01 上午
 * @Created by wangxianlin
 */
@Api(tags = "选择题接口")
@RequestMapping("selectquestion")
@Controller
public class SelectQuestionController {
    @Resource
    private SelectQuestionService selectQuestionService;

    @ApiOperation("获取选择题列表-分页")
    @PostMapping("/getSelectQuestion")
    @ResponseBody
    public Map<String,Object> getSelectQuestion(@RequestBody QuerySelectQuestionVo querySelectQuestionVo){
        Map<String,Object> map = selectQuestionService.getSelectQuestion(querySelectQuestionVo);
        map.put("msg","");
        map.put("code","0");
        return map;
    }

    @ApiOperation("添加选择题")
    @PostMapping("/insertSelectQuestion")
    @ResponseBody
    public int insertSelective(@RequestBody SelectQuestion selectQuestion){
        return selectQuestionService.insertSelective(selectQuestion);
    }

    @ApiOperation("修改选择题")
    @PostMapping("/updateSelectQuestion")
    @ResponseBody
    public int updateSelectQuestion(@RequestBody SelectQuestion selectQuestion) {
        return selectQuestionService.updateByPrimaryKeySelective(selectQuestion);
    }

    @ApiOperation("删除选择题")
    @GetMapping("/deleteSelectQuestion")
    @ResponseBody
    public int deleteSelectQuestion(@RequestParam("selectId") Integer selectId) {
        return selectQuestionService.deleteByPrimaryKey(selectId);
    }

    @ApiOperation("批量导入选择题")
    @PostMapping("/uploadSelect")
    @ResponseBody
    public String importSelect(@RequestParam("file") MultipartFile file) {
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
        String pattern = fileName.substring(fileName.lastIndexOf(".") + 1);
        System.out.println(pattern);
        return pattern;
    }

}
