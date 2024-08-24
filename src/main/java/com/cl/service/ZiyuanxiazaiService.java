package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZiyuanxiazaiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZiyuanxiazaiView;


/**
 * 资源下载
 *
 * @author 
 * @email 
 * @date 2024-03-19 12:35:39
 */
public interface ZiyuanxiazaiService extends IService<ZiyuanxiazaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZiyuanxiazaiView> selectListView(Wrapper<ZiyuanxiazaiEntity> wrapper);
   	
   	ZiyuanxiazaiView selectView(@Param("ew") Wrapper<ZiyuanxiazaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZiyuanxiazaiEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<ZiyuanxiazaiEntity> wrapper);

}

