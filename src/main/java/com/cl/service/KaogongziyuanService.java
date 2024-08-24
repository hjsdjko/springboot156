package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.KaogongziyuanEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.KaogongziyuanView;


/**
 * 考公资源
 *
 * @author 
 * @email 
 * @date 2024-03-19 12:35:38
 */
public interface KaogongziyuanService extends IService<KaogongziyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KaogongziyuanView> selectListView(Wrapper<KaogongziyuanEntity> wrapper);
   	
   	KaogongziyuanView selectView(@Param("ew") Wrapper<KaogongziyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KaogongziyuanEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<KaogongziyuanEntity> wrapper);

}

