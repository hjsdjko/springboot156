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


import com.cl.dao.ChengjifenxiDao;
import com.cl.entity.ChengjifenxiEntity;
import com.cl.service.ChengjifenxiService;
import com.cl.entity.view.ChengjifenxiView;

@Service("chengjifenxiService")
public class ChengjifenxiServiceImpl extends ServiceImpl<ChengjifenxiDao, ChengjifenxiEntity> implements ChengjifenxiService {
	
	@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<ChengjifenxiEntity> wrapper) {
		Page<ChengjifenxiView> page =new Query<ChengjifenxiView>(params).getPage();
        page.setRecords(baseMapper.selectGroupBy(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChengjifenxiEntity> page = this.selectPage(
                new Query<ChengjifenxiEntity>(params).getPage(),
                new EntityWrapper<ChengjifenxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChengjifenxiEntity> wrapper) {
		  Page<ChengjifenxiView> page =new Query<ChengjifenxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ChengjifenxiView> selectListView(Wrapper<ChengjifenxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChengjifenxiView selectView(Wrapper<ChengjifenxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<ChengjifenxiEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<ChengjifenxiEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<ChengjifenxiEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
