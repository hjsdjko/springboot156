package com.cl.entity.view;

import com.cl.entity.KaogongziyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 考公资源
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-19 12:35:38
 */
@TableName("kaogongziyuan")
public class KaogongziyuanView  extends KaogongziyuanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public KaogongziyuanView(){
	}
 
 	public KaogongziyuanView(KaogongziyuanEntity kaogongziyuanEntity){
 	try {
			BeanUtils.copyProperties(this, kaogongziyuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
