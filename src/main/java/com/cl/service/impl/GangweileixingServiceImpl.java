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


import com.cl.dao.GangweileixingDao;
import com.cl.entity.GangweileixingEntity;
import com.cl.service.GangweileixingService;
import com.cl.entity.view.GangweileixingView;

@Service("gangweileixingService")
public class GangweileixingServiceImpl extends ServiceImpl<GangweileixingDao, GangweileixingEntity> implements GangweileixingService {
	
	@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<GangweileixingEntity> wrapper) {
		Page<GangweileixingView> page =new Query<GangweileixingView>(params).getPage();
        page.setRecords(baseMapper.selectGroupBy(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GangweileixingEntity> page = this.selectPage(
                new Query<GangweileixingEntity>(params).getPage(),
                new EntityWrapper<GangweileixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<GangweileixingEntity> wrapper) {
		  Page<GangweileixingView> page =new Query<GangweileixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<GangweileixingView> selectListView(Wrapper<GangweileixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public GangweileixingView selectView(Wrapper<GangweileixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
