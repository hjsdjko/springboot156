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

import com.cl.entity.TijiaoceshiEntity;
import com.cl.entity.view.TijiaoceshiView;

import com.cl.service.TijiaoceshiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 提交测试
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-19 12:35:38
 */
@RestController
@RequestMapping("/tijiaoceshi")
public class TijiaoceshiController {
    @Autowired
    private TijiaoceshiService tijiaoceshiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TijiaoceshiEntity tijiaoceshi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			tijiaoceshi.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("yonghu")) {
			tijiaoceshi.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<TijiaoceshiEntity> ew = new EntityWrapper<TijiaoceshiEntity>();

		PageUtils page = tijiaoceshiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tijiaoceshi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,TijiaoceshiEntity tijiaoceshi, 
		HttpServletRequest request){
        EntityWrapper<TijiaoceshiEntity> ew = new EntityWrapper<TijiaoceshiEntity>();

		PageUtils page = tijiaoceshiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tijiaoceshi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TijiaoceshiEntity tijiaoceshi){
       	EntityWrapper<TijiaoceshiEntity> ew = new EntityWrapper<TijiaoceshiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tijiaoceshi, "tijiaoceshi")); 
        return R.ok().put("data", tijiaoceshiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TijiaoceshiEntity tijiaoceshi){
        EntityWrapper< TijiaoceshiEntity> ew = new EntityWrapper< TijiaoceshiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tijiaoceshi, "tijiaoceshi")); 
		TijiaoceshiView tijiaoceshiView =  tijiaoceshiService.selectView(ew);
		return R.ok("查询提交测试成功").put("data", tijiaoceshiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TijiaoceshiEntity tijiaoceshi = tijiaoceshiService.selectById(id);
		tijiaoceshi = tijiaoceshiService.selectView(new EntityWrapper<TijiaoceshiEntity>().eq("id", id));
        return R.ok().put("data", tijiaoceshi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TijiaoceshiEntity tijiaoceshi = tijiaoceshiService.selectById(id);
		tijiaoceshi = tijiaoceshiService.selectView(new EntityWrapper<TijiaoceshiEntity>().eq("id", id));
        return R.ok().put("data", tijiaoceshi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TijiaoceshiEntity tijiaoceshi, HttpServletRequest request){
    	tijiaoceshi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tijiaoceshi);
        tijiaoceshiService.insert(tijiaoceshi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody TijiaoceshiEntity tijiaoceshi, HttpServletRequest request){
    	tijiaoceshi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tijiaoceshi);
        tijiaoceshiService.insert(tijiaoceshi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody TijiaoceshiEntity tijiaoceshi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tijiaoceshi);
        tijiaoceshiService.updateById(tijiaoceshi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        tijiaoceshiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
