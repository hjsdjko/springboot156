package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.TijiaoceshiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.TijiaoceshiView;


/**
 * 提交测试
 *
 * @author 
 * @email 
 * @date 2024-03-19 12:35:38
 */
public interface TijiaoceshiService extends IService<TijiaoceshiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TijiaoceshiView> selectListView(Wrapper<TijiaoceshiEntity> wrapper);
   	
   	TijiaoceshiView selectView(@Param("ew") Wrapper<TijiaoceshiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TijiaoceshiEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<TijiaoceshiEntity> wrapper);

}

