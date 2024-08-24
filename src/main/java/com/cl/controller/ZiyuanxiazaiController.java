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

import com.cl.entity.ZiyuanxiazaiEntity;
import com.cl.entity.view.ZiyuanxiazaiView;

import com.cl.service.ZiyuanxiazaiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 资源下载
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-19 12:35:39
 */
@RestController
@RequestMapping("/ziyuanxiazai")
public class ZiyuanxiazaiController {
    @Autowired
    private ZiyuanxiazaiService ziyuanxiazaiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZiyuanxiazaiEntity ziyuanxiazai,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			ziyuanxiazai.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			ziyuanxiazai.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZiyuanxiazaiEntity> ew = new EntityWrapper<ZiyuanxiazaiEntity>();

		PageUtils page = ziyuanxiazaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, ziyuanxiazai), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZiyuanxiazaiEntity ziyuanxiazai, 
		HttpServletRequest request){
        EntityWrapper<ZiyuanxiazaiEntity> ew = new EntityWrapper<ZiyuanxiazaiEntity>();

		PageUtils page = ziyuanxiazaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, ziyuanxiazai), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZiyuanxiazaiEntity ziyuanxiazai){
       	EntityWrapper<ZiyuanxiazaiEntity> ew = new EntityWrapper<ZiyuanxiazaiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( ziyuanxiazai, "ziyuanxiazai")); 
        return R.ok().put("data", ziyuanxiazaiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZiyuanxiazaiEntity ziyuanxiazai){
        EntityWrapper< ZiyuanxiazaiEntity> ew = new EntityWrapper< ZiyuanxiazaiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( ziyuanxiazai, "ziyuanxiazai")); 
		ZiyuanxiazaiView ziyuanxiazaiView =  ziyuanxiazaiService.selectView(ew);
		return R.ok("查询资源下载成功").put("data", ziyuanxiazaiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZiyuanxiazaiEntity ziyuanxiazai = ziyuanxiazaiService.selectById(id);
		ziyuanxiazai = ziyuanxiazaiService.selectView(new EntityWrapper<ZiyuanxiazaiEntity>().eq("id", id));
        return R.ok().put("data", ziyuanxiazai);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZiyuanxiazaiEntity ziyuanxiazai = ziyuanxiazaiService.selectById(id);
		ziyuanxiazai = ziyuanxiazaiService.selectView(new EntityWrapper<ZiyuanxiazaiEntity>().eq("id", id));
        return R.ok().put("data", ziyuanxiazai);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZiyuanxiazaiEntity ziyuanxiazai, HttpServletRequest request){
    	ziyuanxiazai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(ziyuanxiazai);
        ziyuanxiazaiService.insert(ziyuanxiazai);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZiyuanxiazaiEntity ziyuanxiazai, HttpServletRequest request){
    	ziyuanxiazai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(ziyuanxiazai);
        ziyuanxiazaiService.insert(ziyuanxiazai);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZiyuanxiazaiEntity ziyuanxiazai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(ziyuanxiazai);
        ziyuanxiazaiService.updateById(ziyuanxiazai);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        ziyuanxiazaiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
