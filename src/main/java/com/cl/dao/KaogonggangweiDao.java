package com.cl.dao;

import com.cl.entity.KaogonggangweiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.KaogonggangweiView;


/**
 * 考公岗位
 * 
 * @author 
 * @email 
 * @date 2024-03-19 12:35:38
 */
public interface KaogonggangweiDao extends BaseMapper<KaogonggangweiEntity> {
	
	List<KaogonggangweiView> selectListView(@Param("ew") Wrapper<KaogonggangweiEntity> wrapper);

	List<KaogonggangweiView> selectListView(Pagination page,@Param("ew") Wrapper<KaogonggangweiEntity> wrapper);
	
	KaogonggangweiView selectView(@Param("ew") Wrapper<KaogonggangweiEntity> wrapper);
	
	List<KaogonggangweiView> selectGroupBy(Pagination page,@Param("ew") Wrapper<KaogonggangweiEntity> wrapper);

}
