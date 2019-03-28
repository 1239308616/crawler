package cn.itcast.crawler.autohome.service;

import cn.itcast.crawler.autohome.pojo.Edu;

public interface EduService {

	/**
	 * 获取学校信息
	 * @param edu_name
	 * @return
	 */
	Edu getEduByName(String edu_name);
}
