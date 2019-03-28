package cn.itcast.crawler.autohome.cfg;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.itcast.crawler.autohome.service.TalkService;
import cn.itcast.crawler.autohome.util.IdFilter;

@Configuration
public class IdFilterCfg {

	@Autowired
	private TalkService talkService;
	
	@Bean
	public IdFilter idFilter(){
		//创建宣讲会id去重过滤器
		IdFilter idFilter = new IdFilter();
		
		//声明页码数
		int page = 1,pageSize = 0;
		do{
			//查询数据库中的宣讲会id数据，因为数据量过大，采用分页查询
			List<Integer> ids = this.talkService.queryIdByPage(page, 500);
			
			// 初始化数据，把数据库中已有数据的的宣讲会id放到去重过滤器中
			for(Integer id : ids) {
				idFilter.add(id.toString());
			}
			
			// 执行完成后页码加一
			page++;
			// 获取查询的记录数
			pageSize = ids.size();
		}while(pageSize == 500);
		return idFilter;
	}
}
