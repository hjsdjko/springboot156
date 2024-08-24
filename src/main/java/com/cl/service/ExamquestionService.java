package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ExamquestionEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ExamquestionView;


/**
 * 试题管理
 *
 * @author 
 * @email 
 * @date 2024-03-19 12:35:38
 */
public interface ExamquestionService extends IService<ExamquestionEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ExamquestionView> selectListView(Wrapper<ExamquestionEntity> wrapper);
   	
   	ExamquestionView selectView(@Param("ew") Wrapper<ExamquestionEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ExamquestionEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<ExamquestionEntity> wrapper);

}

