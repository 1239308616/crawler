package cn.itcast.crawler.autohome.service;

import java.util.List;

import cn.itcast.crawler.autohome.pojo.Job;

public interface JobService {

	/**
	 * 保存招聘职位信息
	 * @param jobs
	 */
	void saveJobs(List<Job> jobs);
}
