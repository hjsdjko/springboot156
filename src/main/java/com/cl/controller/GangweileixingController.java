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

import com.cl.entity.GangweileixingEntity;
import com.cl.entity.view.GangweileixingView;

import com.cl.service.GangweileixingService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 岗位类型
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-19 12:35:38
 */
@RestController
@RequestMapping("/gangweileixing")
public class GangweileixingController {
    @Autowired
    private GangweileixingService gangweileixingService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GangweileixingEntity gangweileixing,
		HttpServletRequest request){
        EntityWrapper<GangweileixingEntity> ew = new EntityWrapper<GangweileixingEntity>();

		PageUtils page = gangweileixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gangweileixing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GangweileixingEntity gangweileixing, 
		HttpServletRequest request){
        EntityWrapper<GangweileixingEntity> ew = new EntityWrapper<GangweileixingEntity>();

		PageUtils page = gangweileixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gangweileixing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GangweileixingEntity gangweileixing){
       	EntityWrapper<GangweileixingEntity> ew = new EntityWrapper<GangweileixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( gangweileixing, "gangweileixing")); 
        return R.ok().put("data", gangweileixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GangweileixingEntity gangweileixing){
        EntityWrapper< GangweileixingEntity> ew = new EntityWrapper< GangweileixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( gangweileixing, "gangweileixing")); 
		GangweileixingView gangweileixingView =  gangweileixingService.selectView(ew);
		return R.ok("查询岗位类型成功").put("data", gangweileixingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GangweileixingEntity gangweileixing = gangweileixingService.selectById(id);
		gangweileixing = gangweileixingService.selectView(new EntityWrapper<GangweileixingEntity>().eq("id", id));
        return R.ok().put("data", gangweileixing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GangweileixingEntity gangweileixing = gangweileixingService.selectById(id);
		gangweileixing = gangweileixingService.selectView(new EntityWrapper<GangweileixingEntity>().eq("id", id));
        return R.ok().put("data", gangweileixing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GangweileixingEntity gangweileixing, HttpServletRequest request){
    	gangweileixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gangweileixing);
        gangweileixingService.insert(gangweileixing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GangweileixingEntity gangweileixing, HttpServletRequest request){
    	gangweileixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gangweileixing);
        gangweileixingService.insert(gangweileixing);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody GangweileixingEntity gangweileixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gangweileixing);
        gangweileixingService.updateById(gangweileixing);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        gangweileixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
