package com.cl.dao;

import com.cl.entity.ZiyuanleixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZiyuanleixingView;


/**
 * 资源类型
 * 
 * @author 
 * @email 
 * @date 2024-03-19 12:35:38
 */
public interface ZiyuanleixingDao extends BaseMapper<ZiyuanleixingEntity> {
	
	List<ZiyuanleixingView> selectListView(@Param("ew") Wrapper<ZiyuanleixingEntity> wrapper);

	List<ZiyuanleixingView> selectListView(Pagination page,@Param("ew") Wrapper<ZiyuanleixingEntity> wrapper);
	
	ZiyuanleixingView selectView(@Param("ew") Wrapper<ZiyuanleixingEntity> wrapper);
	
	List<ZiyuanleixingView> selectGroupBy(Pagination page,@Param("ew") Wrapper<ZiyuanleixingEntity> wrapper);

}
