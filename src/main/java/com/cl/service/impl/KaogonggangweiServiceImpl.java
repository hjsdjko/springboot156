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


import com.cl.dao.KaogonggangweiDao;
import com.cl.entity.KaogonggangweiEntity;
import com.cl.service.KaogonggangweiService;
import com.cl.entity.view.KaogonggangweiView;

@Service("kaogonggangweiService")
public class KaogonggangweiServiceImpl extends ServiceImpl<KaogonggangweiDao, KaogonggangweiEntity> implements KaogonggangweiService {
	
	@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<KaogonggangweiEntity> wrapper) {
		Page<KaogonggangweiView> page =new Query<KaogonggangweiView>(params).getPage();
        page.setRecords(baseMapper.selectGroupBy(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KaogonggangweiEntity> page = this.selectPage(
                new Query<KaogonggangweiEntity>(params).getPage(),
                new EntityWrapper<KaogonggangweiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KaogonggangweiEntity> wrapper) {
		  Page<KaogonggangweiView> page =new Query<KaogonggangweiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<KaogonggangweiView> selectListView(Wrapper<KaogonggangweiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KaogonggangweiView selectView(Wrapper<KaogonggangweiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
