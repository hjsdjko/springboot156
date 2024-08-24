package com.cl.dao;

import com.cl.entity.GangweileixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.GangweileixingView;


/**
 * 岗位类型
 * 
 * @author 
 * @email 
 * @date 2024-03-19 12:35:38
 */
public interface GangweileixingDao extends BaseMapper<GangweileixingEntity> {
	
	List<GangweileixingView> selectListView(@Param("ew") Wrapper<GangweileixingEntity> wrapper);

	List<GangweileixingView> selectListView(Pagination page,@Param("ew") Wrapper<GangweileixingEntity> wrapper);
	
	GangweileixingView selectView(@Param("ew") Wrapper<GangweileixingEntity> wrapper);
	
	List<GangweileixingView> selectGroupBy(Pagination page,@Param("ew") Wrapper<GangweileixingEntity> wrapper);

}
