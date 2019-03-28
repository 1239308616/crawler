package cn.itcast.crawler.autohome.mapper;

import org.apache.ibatis.annotations.Mapper;

import cn.itcast.crawler.autohome.pojo.Edu;

@Mapper
public interface EduMapper {

	/**
	 * 通过学习名称获取学校信息
	 * @param edu_name
	 * @return
	 */
	Edu getEduByName(String edu_name);
}
