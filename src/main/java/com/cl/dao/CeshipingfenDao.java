package com.cl.dao;

import com.cl.entity.CeshipingfenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.CeshipingfenView;


/**
 * 测试评分
 * 
 * @author 
 * @email 
 * @date 2024-03-19 12:35:38
 */
public interface CeshipingfenDao extends BaseMapper<CeshipingfenEntity> {
	
	List<CeshipingfenView> selectListView(@Param("ew") Wrapper<CeshipingfenEntity> wrapper);

	List<CeshipingfenView> selectListView(Pagination page,@Param("ew") Wrapper<CeshipingfenEntity> wrapper);
	
	CeshipingfenView selectView(@Param("ew") Wrapper<CeshipingfenEntity> wrapper);
	
	List<CeshipingfenView> selectGroupBy(Pagination page,@Param("ew") Wrapper<CeshipingfenEntity> wrapper);

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<CeshipingfenEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<CeshipingfenEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<CeshipingfenEntity> wrapper);



}
