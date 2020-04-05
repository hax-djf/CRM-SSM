package com.al.hax.crm.Service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.al.hax.crm.Service.BaseDictService;
import com.al.hax.crm.mapper.BaseDictMapper;
import com.al.hax.crm.pojo.BaseDict;

@Service
public class BaseDictServiceImp implements BaseDictService {
	@Autowired 
	private BaseDictMapper baseDictMapper;
	/**
	 * 根据dictTypeCode 行业编码进行数据查询
	 */
	@Override
	public List<BaseDict> getBaseDict(String dictTypeCode) {
		
		return this.baseDictMapper.queryBaseDictByDicTypeCode(dictTypeCode);
	}

}
