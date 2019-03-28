package cn.itcast.crawler.autohome.service;

import java.util.List;

import cn.itcast.crawler.autohome.pojo.Talk_information;

public interface TalkService {

	/**
	 * 分页查询宣讲会id
	 * @param page
	 * @param rows
	 * @return
	 */
	List<Integer> queryIdByPage(int page,int rows);
	/**
	 * 保存宣讲会信息
	 * @param talk
	 */
	void saveTalk(Talk_information talk);
}
