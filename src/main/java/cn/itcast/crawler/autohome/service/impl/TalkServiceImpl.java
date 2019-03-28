package cn.itcast.crawler.autohome.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.crawler.autohome.mapper.TalkMapper;
import cn.itcast.crawler.autohome.pojo.Talk_information;
import cn.itcast.crawler.autohome.service.TalkService;
@Service
public class TalkServiceImpl implements TalkService {
	
	@Autowired
	private TalkMapper talkMapper;

	@Override
	public List<Integer> queryIdByPage(int page, int rows) {
		// 计算从哪一条数据开始查
		int start = (page - 1) * rows;
		// 封装参数map
		Map<String , Object> map = new HashMap<>();
		map.put("start", start);
		map.put("rows", rows);
		List<Integer> list = this.talkMapper.queryTalkIdByPage(map);
		return list;
	}

	@Override
	public void saveTalk(Talk_information talk) {
		this.talkMapper.saveTalk(talk);
	}

}
