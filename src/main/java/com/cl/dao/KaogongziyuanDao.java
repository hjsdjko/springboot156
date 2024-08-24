package com.cl.dao;

import com.cl.entity.KaogongziyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.KaogongziyuanView;


/**
 * 考公资源
 * 
 * @author 
 * @email 
 * @date 2024-03-19 12:35:38
 */
public interface KaogongziyuanDao extends BaseMapper<KaogongziyuanEntity> {
	
	List<KaogongziyuanView> selectListView(@Param("ew") Wrapper<KaogongziyuanEntity> wrapper);

	List<KaogongziyuanView> selectListView(Pagination page,@Param("ew") Wrapper<KaogongziyuanEntity> wrapper);
	
	KaogongziyuanView selectView(@Param("ew") Wrapper<KaogongziyuanEntity> wrapper);
	
	List<KaogongziyuanView> selectGroupBy(Pagination page,@Param("ew") Wrapper<KaogongziyuanEntity> wrapper);

}
