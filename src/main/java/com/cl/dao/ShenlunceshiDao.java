package com.cl.dao;

import com.cl.entity.ShenlunceshiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShenlunceshiView;


/**
 * 申论测试
 * 
 * @author 
 * @email 
 * @date 2024-03-19 12:35:38
 */
public interface ShenlunceshiDao extends BaseMapper<ShenlunceshiEntity> {
	
	List<ShenlunceshiView> selectListView(@Param("ew") Wrapper<ShenlunceshiEntity> wrapper);

	List<ShenlunceshiView> selectListView(Pagination page,@Param("ew") Wrapper<ShenlunceshiEntity> wrapper);
	
	ShenlunceshiView selectView(@Param("ew") Wrapper<ShenlunceshiEntity> wrapper);
	
	List<ShenlunceshiView> selectGroupBy(Pagination page,@Param("ew") Wrapper<ShenlunceshiEntity> wrapper);

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ShenlunceshiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ShenlunceshiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ShenlunceshiEntity> wrapper);



}
