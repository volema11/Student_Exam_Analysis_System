package com.mac.demo.controller;

import com.mac.demo.model.Paper;
import com.mac.demo.service.PaperService;
import com.mac.demo.vo.PaperTestAdminVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname PaperController
 * @Description TODO
 * @Date 2019/9/12 1:00 上午
 * @Created by wangxianlin
 */
@Api(tags = "试卷接口")
@RequestMapping("paper")
@Controller
public class PaperController {

    @Resource
    private PaperService paperService;

    @ApiOperation("删除试卷")
    @GetMapping("/deletePaper")
    @ResponseBody
    public int deletePaper(Integer paperId) {
        return paperService.deleteByPrimaryKey(paperId);
    }

    @ApiOperation("添加试卷")
    @PostMapping("/insertPaper")
    @ResponseBody
    public int insertPaper(Paper record) {
        return paperService.insertSelective(record);
    }

    @ApiOperation("修改试卷")
    @PostMapping("/updatePaper")
    @ResponseBody
    public int updatePaper(Paper record) {
        return paperService.updateByPrimaryKeySelective(record);
    }


    @ApiOperation("获取试卷列表-分页")
    @GetMapping("/getPaper")
    @ResponseBody
    public Map<String, Object> getPaper(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit) {
        Map<String, Object> map = paperService.getPaper(page,limit);
        map.put("code",0);
        map.put("msg","");
        return map;
    }

    @ApiOperation("----")
    @GetMapping("/getPaperByAuto")
    @ResponseBody
    Map<Object,Object> getPaperByAuto(@RequestParam("typeId") Integer typeId, @RequestParam("selectNum")Integer selectNum,
                                      @RequestParam("completionNum") Integer completionNum){
        return  paperService.getPaperByAuto(typeId,selectNum,completionNum);
    }
}
