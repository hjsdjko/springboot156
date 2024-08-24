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


import com.cl.dao.TijiaoceshiDao;
import com.cl.entity.TijiaoceshiEntity;
import com.cl.service.TijiaoceshiService;
import com.cl.entity.view.TijiaoceshiView;

@Service("tijiaoceshiService")
public class TijiaoceshiServiceImpl extends ServiceImpl<TijiaoceshiDao, TijiaoceshiEntity> implements TijiaoceshiService {
	
	@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<TijiaoceshiEntity> wrapper) {
		Page<TijiaoceshiView> page =new Query<TijiaoceshiView>(params).getPage();
        page.setRecords(baseMapper.selectGroupBy(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TijiaoceshiEntity> page = this.selectPage(
                new Query<TijiaoceshiEntity>(params).getPage(),
                new EntityWrapper<TijiaoceshiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TijiaoceshiEntity> wrapper) {
		  Page<TijiaoceshiView> page =new Query<TijiaoceshiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<TijiaoceshiView> selectListView(Wrapper<TijiaoceshiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TijiaoceshiView selectView(Wrapper<TijiaoceshiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
