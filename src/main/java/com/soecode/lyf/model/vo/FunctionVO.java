package com.soecode.lyf.model.vo;


import lombok.Data;

import java.util.List;

@Data
public class FunctionVO extends BaseVO {

	private static final long serialVersionUID = 1L;

	//@TableId(value = "id")
	private Long id;

	//@ApiModelProperty(value = "权限code")
	private String code;

	//@ApiModelProperty(value = "构造权限树")
	private String parentCode;

	//@ApiModelProperty(value = "权限类型 1菜单,2按钮,3资源")
	private Integer type;

	//@ApiModelProperty(value = "权限名称")
	private String name;

	//@ApiModelProperty(value = "域")
	private String domain;

	//@ApiModelProperty(value = "访问路径")
	private String path;

	//@ApiModelProperty(value = "权限描述")
	private String description;

	//@ApiModelProperty(value = "菜单排序,越小越靠前")
	private Integer sort;

	private List<FunctionVO> children;

}
