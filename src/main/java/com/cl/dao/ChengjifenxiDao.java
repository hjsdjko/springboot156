package com.cl.dao;

import com.cl.entity.ChengjifenxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ChengjifenxiView;


/**
 * 成绩分析
 * 
 * @author 
 * @email 
 * @date 2024-03-19 12:35:39
 */
public interface ChengjifenxiDao extends BaseMapper<ChengjifenxiEntity> {
	
	List<ChengjifenxiView> selectListView(@Param("ew") Wrapper<ChengjifenxiEntity> wrapper);

	List<ChengjifenxiView> selectListView(Pagination page,@Param("ew") Wrapper<ChengjifenxiEntity> wrapper);
	
	ChengjifenxiView selectView(@Param("ew") Wrapper<ChengjifenxiEntity> wrapper);
	
	List<ChengjifenxiView> selectGroupBy(Pagination page,@Param("ew") Wrapper<ChengjifenxiEntity> wrapper);

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ChengjifenxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ChengjifenxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ChengjifenxiEntity> wrapper);



}
