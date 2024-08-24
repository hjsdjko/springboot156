package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.GangweileixingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.GangweileixingView;


/**
 * 岗位类型
 *
 * @author 
 * @email 
 * @date 2024-03-19 12:35:38
 */
public interface GangweileixingService extends IService<GangweileixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<GangweileixingView> selectListView(Wrapper<GangweileixingEntity> wrapper);
   	
   	GangweileixingView selectView(@Param("ew") Wrapper<GangweileixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<GangweileixingEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<GangweileixingEntity> wrapper);

}

