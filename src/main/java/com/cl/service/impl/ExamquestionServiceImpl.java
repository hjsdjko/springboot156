package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.ExamquestionDao;
import com.cl.entity.ExamquestionEntity;
import com.cl.service.ExamquestionService;
import com.cl.entity.view.ExamquestionView;

@Service("examquestionService")
public class ExamquestionServiceImpl extends ServiceImpl<ExamquestionDao, ExamquestionEntity> implements ExamquestionService {
	
	@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<ExamquestionEntity> wrapper) {
		Page<ExamquestionView> page =new Query<ExamquestionView>(params).getPage();
        page.setRecords(baseMapper.selectGroupBy(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ExamquestionEntity> page = this.selectPage(
                new Query<ExamquestionEntity>(params).getPage(),
                new EntityWrapper<ExamquestionEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ExamquestionEntity> wrapper) {
		  Page<ExamquestionView> page =new Query<ExamquestionView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ExamquestionView> selectListView(Wrapper<ExamquestionEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ExamquestionView selectView(Wrapper<ExamquestionEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
