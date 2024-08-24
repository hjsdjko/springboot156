package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.CeshipingfenEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.CeshipingfenView;


/**
 * 测试评分
 *
 * @author 
 * @email 
 * @date 2024-03-19 12:35:38
 */
public interface CeshipingfenService extends IService<CeshipingfenEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CeshipingfenView> selectListView(Wrapper<CeshipingfenEntity> wrapper);
   	
   	CeshipingfenView selectView(@Param("ew") Wrapper<CeshipingfenEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CeshipingfenEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<CeshipingfenEntity> wrapper);

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<CeshipingfenEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<CeshipingfenEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<CeshipingfenEntity> wrapper);



}

