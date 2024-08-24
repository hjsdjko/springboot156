package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZiyuanleixingEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZiyuanleixingView;


/**
 * 资源类型
 *
 * @author 
 * @email 
 * @date 2024-03-19 12:35:38
 */
public interface ZiyuanleixingService extends IService<ZiyuanleixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZiyuanleixingView> selectListView(Wrapper<ZiyuanleixingEntity> wrapper);
   	
   	ZiyuanleixingView selectView(@Param("ew") Wrapper<ZiyuanleixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZiyuanleixingEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<ZiyuanleixingEntity> wrapper);

}

