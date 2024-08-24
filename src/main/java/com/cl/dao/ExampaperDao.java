package com.cl.dao;

import com.cl.entity.ExampaperEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ExampaperView;


/**
 * 试题练习
 * 
 * @author 
 * @email 
 * @date 2024-03-19 12:35:38
 */
public interface ExampaperDao extends BaseMapper<ExampaperEntity> {
	
	List<ExampaperView> selectListView(@Param("ew") Wrapper<ExampaperEntity> wrapper);

	List<ExampaperView> selectListView(Pagination page,@Param("ew") Wrapper<ExampaperEntity> wrapper);
	
	ExampaperView selectView(@Param("ew") Wrapper<ExampaperEntity> wrapper);
	
	List<ExampaperView> selectGroupBy(Pagination page,@Param("ew") Wrapper<ExampaperEntity> wrapper);

}
