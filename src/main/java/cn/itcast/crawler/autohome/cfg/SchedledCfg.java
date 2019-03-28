package cn.itcast.crawler.autohome.cfg;

import org.quartz.CronTrigger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import cn.itcast.crawler.autohome.job.CloseConnectJob;
import cn.itcast.crawler.autohome.job.CrawlerAutohomeJob;

@Configuration
public class SchedledCfg {

	// 定义关闭无效连接任务
	@Bean("crawlerAutohomeJobBean")
	public JobDetailFactoryBean crawlerAutohomeJobBean() {
		// 创建任务描述的工厂bean
		JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
		// 设置spring容器的key，任务中，可以根据这个key获取spring容器
		jobDetailFactoryBean.setApplicationContextJobDataKey("context");
		// 设置任务
		jobDetailFactoryBean.setJobClass(CrawlerAutohomeJob.class);
		// 设置当没有触发器和任务绑定，不会删除任务
		jobDetailFactoryBean.setDurability(true);
		
		return jobDetailFactoryBean;
	}
	
	// 定义关闭无效连接触发器
	// @Qualifier注解是通过名字注入bean
	@Bean("crawlerAutohomeJobTrigger")
	public CronTriggerFactoryBean crawlerAutohomeJobTrigger(
			@Qualifier(value = "crawlerAutohomeJobBean") JobDetailFactoryBean itemJobBean) {
		// 创建表达式触发器工厂bean
		CronTriggerFactoryBean tigger = new CronTriggerFactoryBean();
		// 设置任务描述到触发器
		tigger.setJobDetail(itemJobBean.getObject());
		// 设置七子表达式
		tigger.setCronExpression("0/5 * * * * ? ");
		return tigger;
	}
	
	// 定义关闭无效连接任务
	@Bean("closeConnectJobBean")
	public JobDetailFactoryBean closeConnectJobBean() {
		// 创建任务描述的工厂bean
		JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
		// 设置spring容器的key，任务中，可以根据这个key获取spring容器
		jobDetailFactoryBean.setApplicationContextJobDataKey("context");
		// 设置任务
		jobDetailFactoryBean.setJobClass(CloseConnectJob.class);
		// 设置当没有触发器和任务绑定，不会删除任务
		jobDetailFactoryBean.setDurability(true);

		return jobDetailFactoryBean;
	}

	// 定义关闭无效连接触发器
	// @Qualifier注解是通过名字注入bean
	@Bean("closeConnectJobTrigger")
	public CronTriggerFactoryBean closeConnectJobTrigger(
			@Qualifier(value = "closeConnectJobBean") JobDetailFactoryBean itemJobBean) {
		// 创建表达式触发器工厂bean
		CronTriggerFactoryBean tigger = new CronTriggerFactoryBean();
		// 设置任务描述到触发器
		tigger.setJobDetail(itemJobBean.getObject());
		// 设置七子表达式
		tigger.setCronExpression("0/5 * * * * ? ");
		return tigger;
	}

	// 定义调度器
	@Bean
	public SchedulerFactoryBean schedulerFactory(CronTrigger[] cronTriggerImpl) {
		// 创建任务调度器的工厂Bean
		SchedulerFactoryBean bean = new SchedulerFactoryBean();
		// 给任务调度器设置触发器
		bean.setTriggers(cronTriggerImpl);

		return bean;
	}
}
