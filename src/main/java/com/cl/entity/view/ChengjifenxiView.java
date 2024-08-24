package com.cl.entity.view;

import com.cl.entity.ChengjifenxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 成绩分析
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-19 12:35:39
 */
@TableName("chengjifenxi")
public class ChengjifenxiView  extends ChengjifenxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ChengjifenxiView(){
	}
 
 	public ChengjifenxiView(ChengjifenxiEntity chengjifenxiEntity){
 	try {
			BeanUtils.copyProperties(this, chengjifenxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
