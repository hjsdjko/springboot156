package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ShenlunceshiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShenlunceshiView;


/**
 * 申论测试
 *
 * @author 
 * @email 
 * @date 2024-03-19 12:35:38
 */
public interface ShenlunceshiService extends IService<ShenlunceshiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShenlunceshiView> selectListView(Wrapper<ShenlunceshiEntity> wrapper);
   	
   	ShenlunceshiView selectView(@Param("ew") Wrapper<ShenlunceshiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShenlunceshiEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<ShenlunceshiEntity> wrapper);

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<ShenlunceshiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<ShenlunceshiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<ShenlunceshiEntity> wrapper);



}

