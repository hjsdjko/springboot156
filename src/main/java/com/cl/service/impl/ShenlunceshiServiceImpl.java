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


import com.cl.dao.ShenlunceshiDao;
import com.cl.entity.ShenlunceshiEntity;
import com.cl.service.ShenlunceshiService;
import com.cl.entity.view.ShenlunceshiView;

@Service("shenlunceshiService")
public class ShenlunceshiServiceImpl extends ServiceImpl<ShenlunceshiDao, ShenlunceshiEntity> implements ShenlunceshiService {
	
	@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<ShenlunceshiEntity> wrapper) {
		Page<ShenlunceshiView> page =new Query<ShenlunceshiView>(params).getPage();
        page.setRecords(baseMapper.selectGroupBy(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShenlunceshiEntity> page = this.selectPage(
                new Query<ShenlunceshiEntity>(params).getPage(),
                new EntityWrapper<ShenlunceshiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShenlunceshiEntity> wrapper) {
		  Page<ShenlunceshiView> page =new Query<ShenlunceshiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ShenlunceshiView> selectListView(Wrapper<ShenlunceshiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShenlunceshiView selectView(Wrapper<ShenlunceshiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<ShenlunceshiEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<ShenlunceshiEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<ShenlunceshiEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
