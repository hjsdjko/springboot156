package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.ExampaperEntity;
import com.cl.entity.view.ExampaperView;

import com.cl.service.ExampaperService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 试题练习
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-19 12:35:38
 */
@RestController
@RequestMapping("/exampaper")
public class ExampaperController {
    @Autowired
    private ExampaperService exampaperService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ExampaperEntity exampaper,
		HttpServletRequest request){
        EntityWrapper<ExampaperEntity> ew = new EntityWrapper<ExampaperEntity>();

		PageUtils page = exampaperService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, exampaper), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ExampaperEntity exampaper, 
		HttpServletRequest request){
        EntityWrapper<ExampaperEntity> ew = new EntityWrapper<ExampaperEntity>();

		PageUtils page = exampaperService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, exampaper), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ExampaperEntity exampaper){
       	EntityWrapper<ExampaperEntity> ew = new EntityWrapper<ExampaperEntity>();
      	ew.allEq(MPUtil.allEQMapPre( exampaper, "exampaper")); 
        return R.ok().put("data", exampaperService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ExampaperEntity exampaper){
        EntityWrapper< ExampaperEntity> ew = new EntityWrapper< ExampaperEntity>();
 		ew.allEq(MPUtil.allEQMapPre( exampaper, "exampaper")); 
		ExampaperView exampaperView =  exampaperService.selectView(ew);
		return R.ok("查询试题练习成功").put("data", exampaperView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ExampaperEntity exampaper = exampaperService.selectById(id);
		exampaper = exampaperService.selectView(new EntityWrapper<ExampaperEntity>().eq("id", id));
        return R.ok().put("data", exampaper);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ExampaperEntity exampaper = exampaperService.selectById(id);
		exampaper = exampaperService.selectView(new EntityWrapper<ExampaperEntity>().eq("id", id));
        return R.ok().put("data", exampaper);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ExampaperEntity exampaper, HttpServletRequest request){
    	exampaper.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(exampaper);
        exampaperService.insert(exampaper);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ExampaperEntity exampaper, HttpServletRequest request){
    	exampaper.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(exampaper);
        exampaperService.insert(exampaper);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ExampaperEntity exampaper, HttpServletRequest request){
        //ValidatorUtils.validateEntity(exampaper);
        exampaperService.updateById(exampaper);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        exampaperService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
