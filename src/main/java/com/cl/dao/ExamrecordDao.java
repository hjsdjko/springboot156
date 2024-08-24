package com.cl.dao;

import com.cl.entity.ExamrecordEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ExamrecordView;


/**
 * 考试记录
 * 
 * @author 
 * @email 
 * @date 2024-03-19 12:35:38
 */
public interface ExamrecordDao extends BaseMapper<ExamrecordEntity> {
	
	List<ExamrecordView> selectListView(@Param("ew") Wrapper<ExamrecordEntity> wrapper);

	List<ExamrecordView> selectListView(Pagination page,@Param("ew") Wrapper<ExamrecordEntity> wrapper);
	
	ExamrecordView selectView(@Param("ew") Wrapper<ExamrecordEntity> wrapper);
	
	List<ExamrecordView> selectGroupBy(Pagination page,@Param("ew") Wrapper<ExamrecordEntity> wrapper);

}
