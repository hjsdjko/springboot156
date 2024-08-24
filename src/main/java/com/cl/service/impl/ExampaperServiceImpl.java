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


import com.cl.dao.ExampaperDao;
import com.cl.entity.ExampaperEntity;
import com.cl.service.ExampaperService;
import com.cl.entity.view.ExampaperView;

@Service("exampaperService")
public class ExampaperServiceImpl extends ServiceImpl<ExampaperDao, ExampaperEntity> implements ExampaperService {
	
	@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<ExampaperEntity> wrapper) {
		Page<ExampaperView> page =new Query<ExampaperView>(params).getPage();
        page.setRecords(baseMapper.selectGroupBy(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ExampaperEntity> page = this.selectPage(
                new Query<ExampaperEntity>(params).getPage(),
                new EntityWrapper<ExampaperEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ExampaperEntity> wrapper) {
		  Page<ExampaperView> page =new Query<ExampaperView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ExampaperView> selectListView(Wrapper<ExampaperEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ExampaperView selectView(Wrapper<ExampaperEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
