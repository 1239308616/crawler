package cn.itcast.crawler.autohome.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.itcast.crawler.autohome.pojo.Job;

@Mapper
public interface JobMapper {

	/**
	 * 保存招聘职位信息
	 * @param jobs
	 */
	void saveJobs(List<Job> jobs);
}
