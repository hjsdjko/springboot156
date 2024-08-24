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

import com.cl.entity.ZiyuanleixingEntity;
import com.cl.entity.view.ZiyuanleixingView;

import com.cl.service.ZiyuanleixingService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 资源类型
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-19 12:35:38
 */
@RestController
@RequestMapping("/ziyuanleixing")
public class ZiyuanleixingController {
    @Autowired
    private ZiyuanleixingService ziyuanleixingService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZiyuanleixingEntity ziyuanleixing,
		HttpServletRequest request){
        EntityWrapper<ZiyuanleixingEntity> ew = new EntityWrapper<ZiyuanleixingEntity>();

		PageUtils page = ziyuanleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, ziyuanleixing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZiyuanleixingEntity ziyuanleixing, 
		HttpServletRequest request){
        EntityWrapper<ZiyuanleixingEntity> ew = new EntityWrapper<ZiyuanleixingEntity>();

		PageUtils page = ziyuanleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, ziyuanleixing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZiyuanleixingEntity ziyuanleixing){
       	EntityWrapper<ZiyuanleixingEntity> ew = new EntityWrapper<ZiyuanleixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( ziyuanleixing, "ziyuanleixing")); 
        return R.ok().put("data", ziyuanleixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZiyuanleixingEntity ziyuanleixing){
        EntityWrapper< ZiyuanleixingEntity> ew = new EntityWrapper< ZiyuanleixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( ziyuanleixing, "ziyuanleixing")); 
		ZiyuanleixingView ziyuanleixingView =  ziyuanleixingService.selectView(ew);
		return R.ok("查询资源类型成功").put("data", ziyuanleixingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZiyuanleixingEntity ziyuanleixing = ziyuanleixingService.selectById(id);
		ziyuanleixing = ziyuanleixingService.selectView(new EntityWrapper<ZiyuanleixingEntity>().eq("id", id));
        return R.ok().put("data", ziyuanleixing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZiyuanleixingEntity ziyuanleixing = ziyuanleixingService.selectById(id);
		ziyuanleixing = ziyuanleixingService.selectView(new EntityWrapper<ZiyuanleixingEntity>().eq("id", id));
        return R.ok().put("data", ziyuanleixing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZiyuanleixingEntity ziyuanleixing, HttpServletRequest request){
    	ziyuanleixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(ziyuanleixing);
        ziyuanleixingService.insert(ziyuanleixing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZiyuanleixingEntity ziyuanleixing, HttpServletRequest request){
    	ziyuanleixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(ziyuanleixing);
        ziyuanleixingService.insert(ziyuanleixing);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZiyuanleixingEntity ziyuanleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(ziyuanleixing);
        ziyuanleixingService.updateById(ziyuanleixing);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        ziyuanleixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
