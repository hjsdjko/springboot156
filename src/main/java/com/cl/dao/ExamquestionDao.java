package com.cl.dao;

import com.cl.entity.ExamquestionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ExamquestionView;


/**
 * 试题管理
 * 
 * @author 
 * @email 
 * @date 2024-03-19 12:35:38
 */
public interface ExamquestionDao extends BaseMapper<ExamquestionEntity> {
	
	List<ExamquestionView> selectListView(@Param("ew") Wrapper<ExamquestionEntity> wrapper);

	List<ExamquestionView> selectListView(Pagination page,@Param("ew") Wrapper<ExamquestionEntity> wrapper);
	
	ExamquestionView selectView(@Param("ew") Wrapper<ExamquestionEntity> wrapper);
	
	List<ExamquestionView> selectGroupBy(Pagination page,@Param("ew") Wrapper<ExamquestionEntity> wrapper);

}
