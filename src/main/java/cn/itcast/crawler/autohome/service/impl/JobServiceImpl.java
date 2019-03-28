package cn.itcast.crawler.autohome.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.crawler.autohome.mapper.JobMapper;
import cn.itcast.crawler.autohome.pojo.Job;
import cn.itcast.crawler.autohome.service.JobService;

@Service
public class JobServiceImpl implements JobService {
	
	@Autowired
	private JobMapper jobMapper;

	@Override
	public void saveJobs(List<Job> jobs) {
		this.jobMapper.saveJobs(jobs);
	}

}
