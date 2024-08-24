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

import com.cl.entity.KaogongziyuanEntity;
import com.cl.entity.view.KaogongziyuanView;

import com.cl.service.KaogongziyuanService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 考公资源
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-19 12:35:38
 */
@RestController
@RequestMapping("/kaogongziyuan")
public class KaogongziyuanController {
    @Autowired
    private KaogongziyuanService kaogongziyuanService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KaogongziyuanEntity kaogongziyuan,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			kaogongziyuan.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<KaogongziyuanEntity> ew = new EntityWrapper<KaogongziyuanEntity>();

		PageUtils page = kaogongziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kaogongziyuan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KaogongziyuanEntity kaogongziyuan, 
		HttpServletRequest request){
        EntityWrapper<KaogongziyuanEntity> ew = new EntityWrapper<KaogongziyuanEntity>();

		PageUtils page = kaogongziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kaogongziyuan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KaogongziyuanEntity kaogongziyuan){
       	EntityWrapper<KaogongziyuanEntity> ew = new EntityWrapper<KaogongziyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kaogongziyuan, "kaogongziyuan")); 
        return R.ok().put("data", kaogongziyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KaogongziyuanEntity kaogongziyuan){
        EntityWrapper< KaogongziyuanEntity> ew = new EntityWrapper< KaogongziyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kaogongziyuan, "kaogongziyuan")); 
		KaogongziyuanView kaogongziyuanView =  kaogongziyuanService.selectView(ew);
		return R.ok("查询考公资源成功").put("data", kaogongziyuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KaogongziyuanEntity kaogongziyuan = kaogongziyuanService.selectById(id);
		kaogongziyuan = kaogongziyuanService.selectView(new EntityWrapper<KaogongziyuanEntity>().eq("id", id));
        return R.ok().put("data", kaogongziyuan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KaogongziyuanEntity kaogongziyuan = kaogongziyuanService.selectById(id);
		kaogongziyuan = kaogongziyuanService.selectView(new EntityWrapper<KaogongziyuanEntity>().eq("id", id));
        return R.ok().put("data", kaogongziyuan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KaogongziyuanEntity kaogongziyuan, HttpServletRequest request){
    	kaogongziyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kaogongziyuan);
        kaogongziyuanService.insert(kaogongziyuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KaogongziyuanEntity kaogongziyuan, HttpServletRequest request){
    	kaogongziyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kaogongziyuan);
        kaogongziyuanService.insert(kaogongziyuan);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KaogongziyuanEntity kaogongziyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kaogongziyuan);
        kaogongziyuanService.updateById(kaogongziyuan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        kaogongziyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
