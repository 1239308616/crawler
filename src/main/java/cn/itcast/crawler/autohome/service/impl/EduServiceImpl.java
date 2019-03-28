package cn.itcast.crawler.autohome.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.crawler.autohome.mapper.EduMapper;
import cn.itcast.crawler.autohome.pojo.Edu;
import cn.itcast.crawler.autohome.service.EduService;
@Service
public class EduServiceImpl implements EduService {
	
	@Autowired
	private EduMapper eduMapper;

	@Override
	public Edu getEduByName(String edu_name) {
		Edu edu = this.eduMapper.getEduByName(edu_name);
		return edu;
	}

}
