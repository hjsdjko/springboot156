package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ChengjifenxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ChengjifenxiView;


/**
 * 成绩分析
 *
 * @author 
 * @email 
 * @date 2024-03-19 12:35:39
 */
public interface ChengjifenxiService extends IService<ChengjifenxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChengjifenxiView> selectListView(Wrapper<ChengjifenxiEntity> wrapper);
   	
   	ChengjifenxiView selectView(@Param("ew") Wrapper<ChengjifenxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChengjifenxiEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<ChengjifenxiEntity> wrapper);

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<ChengjifenxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<ChengjifenxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<ChengjifenxiEntity> wrapper);



}

