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


import com.cl.dao.ZiyuanxiazaiDao;
import com.cl.entity.ZiyuanxiazaiEntity;
import com.cl.service.ZiyuanxiazaiService;
import com.cl.entity.view.ZiyuanxiazaiView;

@Service("ziyuanxiazaiService")
public class ZiyuanxiazaiServiceImpl extends ServiceImpl<ZiyuanxiazaiDao, ZiyuanxiazaiEntity> implements ZiyuanxiazaiService {
	
	@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<ZiyuanxiazaiEntity> wrapper) {
		Page<ZiyuanxiazaiView> page =new Query<ZiyuanxiazaiView>(params).getPage();
        page.setRecords(baseMapper.selectGroupBy(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZiyuanxiazaiEntity> page = this.selectPage(
                new Query<ZiyuanxiazaiEntity>(params).getPage(),
                new EntityWrapper<ZiyuanxiazaiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZiyuanxiazaiEntity> wrapper) {
		  Page<ZiyuanxiazaiView> page =new Query<ZiyuanxiazaiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ZiyuanxiazaiView> selectListView(Wrapper<ZiyuanxiazaiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZiyuanxiazaiView selectView(Wrapper<ZiyuanxiazaiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
