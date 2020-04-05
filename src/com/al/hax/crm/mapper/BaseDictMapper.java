package com.al.hax.crm.mapper;

import java.util.List;

import com.al.hax.crm.pojo.BaseDict;

public interface BaseDictMapper {
	/**
	 * 根据代码类别查询数据
	 * @return List<BaseDict> 返回一个字典的集合
	 */
	List<BaseDict> queryBaseDictByDicTypeCode(String dictTypeCode);
}
