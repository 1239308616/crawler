package cn.itcast.crawler.autohome.service;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.crawler.autohome.Application;
import cn.itcast.crawler.autohome.mapper.CompanyMapper;
import cn.itcast.crawler.autohome.mapper.EduMapper;
import cn.itcast.crawler.autohome.mapper.JobMapper;
import cn.itcast.crawler.autohome.mapper.TalkMapper;
import cn.itcast.crawler.autohome.pojo.Edu;
import cn.itcast.crawler.autohome.pojo.Job;
import cn.itcast.crawler.autohome.pojo.Talk_information;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ApiServiceTest {

	@Autowired
	private ApiService apiService;
	@Autowired
	private TalkMapper talkMapper;
	@Autowired
	private CompanyMapper companyMapper;
	@Autowired
	private JobMapper jobMapper;
	@Autowired
	private EduMapper eduMapper;

	@Test
	public void testGet() {
		Talk_information talk = this.apiService.getTalk("http://jobs.xtu.edu.cn/detail/getcareerdetail?career_id=",
				"203243");
		System.out.println(talk);
		//talkMapper.saveTalk(talk);
		//companyMapper.saveCompany(talk.getCompany());
		int company_id = talk.getCompany_id();
		List<Job> jobs = talk.getJobs();
		for(Job j : jobs) {
			j.setCid(company_id);
		}
		jobMapper.saveJobs(jobs);
	}

	@Test
	public void testGetId(){
		List<String> talkId = this.apiService.getTalkId("http://jobs.xtu.edu.cn/module/getcareers?start=0&count=10&k=&address=&professionals=&career_type=&type=inner&day=");
		for(String id :talkId ){
			System.out.println(id);
		}
	}
	
	@Test
	public void testEdu(){
		Edu edu = this.eduMapper.getEduByName("湘潭大学");
		System.out.println(edu.getEdu_id());
		System.out.println(edu.getEdu_start_url());
	}
}
