package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 申论测试
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-19 12:35:38
 */
@TableName("shenlunceshi")
public class ShenlunceshiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ShenlunceshiEntity() {
		
	}
	
	public ShenlunceshiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 测试题目
	 */
					
	private String ceshitimu;
	
	/**
	 * 测试类型
	 */
					
	private String ceshileixing;
	
	/**
	 * 封面
	 */
					
	private String fengmian;
	
	/**
	 * 测试介绍
	 */
					
	private String ceshijieshao;
	
	/**
	 * 测试内容
	 */
					
	private String ceshineirong;
	
	/**
	 * 发布时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date fabushijian;
	
	/**
	 * 教师工号
	 */
					
	private String jiaoshigonghao;
	
	/**
	 * 教师姓名
	 */
					
	private String jiaoshixingming;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：测试题目
	 */
	public void setCeshitimu(String ceshitimu) {
		this.ceshitimu = ceshitimu;
	}
	/**
	 * 获取：测试题目
	 */
	public String getCeshitimu() {
		return ceshitimu;
	}
	/**
	 * 设置：测试类型
	 */
	public void setCeshileixing(String ceshileixing) {
		this.ceshileixing = ceshileixing;
	}
	/**
	 * 获取：测试类型
	 */
	public String getCeshileixing() {
		return ceshileixing;
	}
	/**
	 * 设置：封面
	 */
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}
	/**
	 * 设置：测试介绍
	 */
	public void setCeshijieshao(String ceshijieshao) {
		this.ceshijieshao = ceshijieshao;
	}
	/**
	 * 获取：测试介绍
	 */
	public String getCeshijieshao() {
		return ceshijieshao;
	}
	/**
	 * 设置：测试内容
	 */
	public void setCeshineirong(String ceshineirong) {
		this.ceshineirong = ceshineirong;
	}
	/**
	 * 获取：测试内容
	 */
	public String getCeshineirong() {
		return ceshineirong;
	}
	/**
	 * 设置：发布时间
	 */
	public void setFabushijian(Date fabushijian) {
		this.fabushijian = fabushijian;
	}
	/**
	 * 获取：发布时间
	 */
	public Date getFabushijian() {
		return fabushijian;
	}
	/**
	 * 设置：教师工号
	 */
	public void setJiaoshigonghao(String jiaoshigonghao) {
		this.jiaoshigonghao = jiaoshigonghao;
	}
	/**
	 * 获取：教师工号
	 */
	public String getJiaoshigonghao() {
		return jiaoshigonghao;
	}
	/**
	 * 设置：教师姓名
	 */
	public void setJiaoshixingming(String jiaoshixingming) {
		this.jiaoshixingming = jiaoshixingming;
	}
	/**
	 * 获取：教师姓名
	 */
	public String getJiaoshixingming() {
		return jiaoshixingming;
	}

}
