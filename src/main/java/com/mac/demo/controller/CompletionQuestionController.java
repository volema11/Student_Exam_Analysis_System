package com.mac.demo.controller;

import com.mac.demo.model.CompletionQuestion;
import com.mac.demo.service.CompletionQuestionService;
import com.mac.demo.vo.QueryCompletionQuestionVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Map;


/**
 * @Classname CompletionQuestionController
 * @Description TODO
 * @Date 2019/9/12 12:59 上午
 * @Created by wangxianlin
 */
@Api(tags = "填空题接口")
@RequestMapping("completionquestion")
@Controller
public class CompletionQuestionController {
    @Resource
    private CompletionQuestionService completionQuestionService;

    @ApiOperation("获取填空题列表-分页")
    @PostMapping("/getCompletionQuestion")
    @ResponseBody
    public Map<String,Object> getCompletionQuestion(@RequestBody QueryCompletionQuestionVo queryCompletionQuestionVo){
        Map<String,Object> map = completionQuestionService.getCompletionQuestion(queryCompletionQuestionVo);
        map.put("msg","");
        map.put("code","0");
        return map;
    }

    @ApiOperation("添加填空题")
    @PostMapping("/insertCompletionQuestion")
    @ResponseBody
    public int insertSelective(@RequestBody CompletionQuestion completionQuestion){
        return completionQuestionService.insertSelective(completionQuestion);
    }

    @ApiOperation("修改填空题")
    @PostMapping("/updateCompletionQuestion")
    @ResponseBody
    public int updateCompletionQuestion(@RequestBody CompletionQuestion completionQuestion) {
        return completionQuestionService.updateByPrimaryKeySelective(completionQuestion);
    }

    @ApiOperation("删除填空题")
    @GetMapping("/deleteCompletionQuestion")
    @ResponseBody
    public int deleteCompletionQuestion(@RequestParam("completionId") Integer completionId) {
        return completionQuestionService.deleteByPrimaryKey(completionId);
    }

    @ApiOperation("批量导入填空题")
    @PostMapping("/uploadCompletionQuestion")
    @ResponseBody
    public String importCompletionQuestion(@RequestParam("file") MultipartFile file) {
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
        String pattern = fileName.substring(fileName.lastIndexOf(".") + 1);
        System.out.println(pattern);
        return pattern;
    }


}
