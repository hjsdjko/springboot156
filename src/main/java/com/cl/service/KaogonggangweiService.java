package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.KaogonggangweiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.KaogonggangweiView;


/**
 * 考公岗位
 *
 * @author 
 * @email 
 * @date 2024-03-19 12:35:38
 */
public interface KaogonggangweiService extends IService<KaogonggangweiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KaogonggangweiView> selectListView(Wrapper<KaogonggangweiEntity> wrapper);
   	
   	KaogonggangweiView selectView(@Param("ew") Wrapper<KaogonggangweiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KaogonggangweiEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<KaogonggangweiEntity> wrapper);

}

