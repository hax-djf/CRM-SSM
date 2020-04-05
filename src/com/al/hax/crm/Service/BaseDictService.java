package com.al.hax.crm.Service;

import java.util.List;

import com.al.hax.crm.pojo.BaseDict;

public interface BaseDictService {
	/**
	 * @param dictTypeCode 字典行业编码
	 * @return 字典类的集合
	 */
	List<BaseDict> getBaseDict(String dictTypeCode);
}
