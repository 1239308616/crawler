package cn.itcast.crawler.autohome.job;


import java.util.List;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import cn.itcast.crawler.autohome.pojo.Company;
import cn.itcast.crawler.autohome.pojo.Edu;
import cn.itcast.crawler.autohome.pojo.Job;
import cn.itcast.crawler.autohome.pojo.Talk_information;
import cn.itcast.crawler.autohome.service.ApiService;
import cn.itcast.crawler.autohome.service.CompanyService;
import cn.itcast.crawler.autohome.service.EduService;
import cn.itcast.crawler.autohome.service.JobService;
import cn.itcast.crawler.autohome.service.TalkService;
import cn.itcast.crawler.autohome.util.IdFilter;

//当前任务没有结束不会开启下一个任务
@DisallowConcurrentExecution
public class CrawlerAutohomeJob extends QuartzJobBean {

	@Autowired
	private ApiService apiService;
	@Autowired
	private TalkService talkService;
	@Autowired
	private IdFilter idFilter;
	@Autowired
	private EduService eduService;
	@Autowired
	private CompanyService companyService;
	@Autowired
	private JobService jobService;


	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		// 获取spring容器
		ApplicationContext applicationContext = (ApplicationContext) context.getJobDetail().getJobDataMap()
				.get("context");

		// 初始化bean
		this.apiService = applicationContext.getBean(ApiService.class);
		this.talkService = applicationContext.getBean(TalkService.class);
		this.idFilter = applicationContext.getBean(IdFilter.class);
		this.eduService = applicationContext.getBean(EduService.class);
		this.companyService = applicationContext.getBean(CompanyService.class);
		this.jobService = applicationContext.getBean(JobService.class);
		//获取学校信息
		Edu edu = this.eduService.getEduByName("湘潭大学");
		String edu_start_url = edu.getEdu_start_url();
		String edu_end_url = edu.getEdu_end_url();
		String edu_information_url = edu.getEdu_information_url();
		for(int i = 0; i < 100 ; i=i+10){
			//拼接url地址
			String url = edu_start_url + i +edu_end_url;
			//获取宣讲会id的集合
			List<String> talkId = this.apiService.getTalkId(url);
			for (String id : talkId) {
				//判断是否存在，去除重复
				if(idFilter.contains(id)){
					continue;
				}
				//获取宣讲会信息
				Talk_information talk = this.apiService.getTalk(edu_information_url, id);
				//判断宣讲会状态
				if(!talk.getAddress().equals("已取消")){
					//将宣讲会信息存入数据库
					this.talkService.saveTalk(talk);
					//获取对应的公司的信息
					Company company = talk.getCompany();
					//判断公司在数据库中是否存在
					if(this.companyService.getCompanyById(company.getCompany_id()) == null){
						//将公司信息存入数据库
						this.companyService.saveCompany(company);
						//获取对应的职位信息
						List<Job> jobs = talk.getJobs();
						//判断职位信息是否为空
						if((!jobs.isEmpty())&&(jobs.size()>0)){
							for (Job job : jobs) {
								job.setCid(company.getCompany_id());
							}
							//将职位信息存入数据库
							this.jobService.saveJobs(jobs);
						}
					}
					
				}
			}
		}
		

	}


}
