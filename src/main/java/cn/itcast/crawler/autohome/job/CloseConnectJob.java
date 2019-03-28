package cn.itcast.crawler.autohome.job;

import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 定时关闭HttpClient的无效连接
 * 
 * @author tree
 *
 */
// 当定时任务没有执行完的情况下，不会再次启动新的任务
@DisallowConcurrentExecution
public class CloseConnectJob extends QuartzJobBean {

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		// 获取Spring容器
		ApplicationContext applicationContext = (ApplicationContext) context.getJobDetail().getJobDataMap()
				.get("context");
		System.out.println("CloseConnectJob");
		// 从Spring容器中获取HttpClient的连接管理器，关闭无效连接
		applicationContext.getBean(PoolingHttpClientConnectionManager.class).closeExpiredConnections();
	}

}
