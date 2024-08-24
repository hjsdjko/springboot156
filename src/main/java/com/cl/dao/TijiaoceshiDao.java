package com.cl.dao;

import com.cl.entity.TijiaoceshiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.TijiaoceshiView;


/**
 * 提交测试
 * 
 * @author 
 * @email 
 * @date 2024-03-19 12:35:38
 */
public interface TijiaoceshiDao extends BaseMapper<TijiaoceshiEntity> {
	
	List<TijiaoceshiView> selectListView(@Param("ew") Wrapper<TijiaoceshiEntity> wrapper);

	List<TijiaoceshiView> selectListView(Pagination page,@Param("ew") Wrapper<TijiaoceshiEntity> wrapper);
	
	TijiaoceshiView selectView(@Param("ew") Wrapper<TijiaoceshiEntity> wrapper);
	
	List<TijiaoceshiView> selectGroupBy(Pagination page,@Param("ew") Wrapper<TijiaoceshiEntity> wrapper);

}
