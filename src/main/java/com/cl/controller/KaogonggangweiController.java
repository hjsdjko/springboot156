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

import com.cl.entity.KaogonggangweiEntity;
import com.cl.entity.view.KaogonggangweiView;

import com.cl.service.KaogonggangweiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 考公岗位
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-19 12:35:38
 */
@RestController
@RequestMapping("/kaogonggangwei")
public class KaogonggangweiController {
    @Autowired
    private KaogonggangweiService kaogonggangweiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KaogonggangweiEntity kaogonggangwei,
		HttpServletRequest request){
        EntityWrapper<KaogonggangweiEntity> ew = new EntityWrapper<KaogonggangweiEntity>();

		PageUtils page = kaogonggangweiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kaogonggangwei), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KaogonggangweiEntity kaogonggangwei, 
		HttpServletRequest request){
        EntityWrapper<KaogonggangweiEntity> ew = new EntityWrapper<KaogonggangweiEntity>();

		PageUtils page = kaogonggangweiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kaogonggangwei), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KaogonggangweiEntity kaogonggangwei){
       	EntityWrapper<KaogonggangweiEntity> ew = new EntityWrapper<KaogonggangweiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kaogonggangwei, "kaogonggangwei")); 
        return R.ok().put("data", kaogonggangweiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KaogonggangweiEntity kaogonggangwei){
        EntityWrapper< KaogonggangweiEntity> ew = new EntityWrapper< KaogonggangweiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kaogonggangwei, "kaogonggangwei")); 
		KaogonggangweiView kaogonggangweiView =  kaogonggangweiService.selectView(ew);
		return R.ok("查询考公岗位成功").put("data", kaogonggangweiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KaogonggangweiEntity kaogonggangwei = kaogonggangweiService.selectById(id);
		kaogonggangwei = kaogonggangweiService.selectView(new EntityWrapper<KaogonggangweiEntity>().eq("id", id));
        return R.ok().put("data", kaogonggangwei);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KaogonggangweiEntity kaogonggangwei = kaogonggangweiService.selectById(id);
		kaogonggangwei = kaogonggangweiService.selectView(new EntityWrapper<KaogonggangweiEntity>().eq("id", id));
        return R.ok().put("data", kaogonggangwei);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KaogonggangweiEntity kaogonggangwei, HttpServletRequest request){
    	kaogonggangwei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kaogonggangwei);
        kaogonggangweiService.insert(kaogonggangwei);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KaogonggangweiEntity kaogonggangwei, HttpServletRequest request){
    	kaogonggangwei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kaogonggangwei);
        kaogonggangweiService.insert(kaogonggangwei);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KaogonggangweiEntity kaogonggangwei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kaogonggangwei);
        kaogonggangweiService.updateById(kaogonggangwei);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        kaogonggangweiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
