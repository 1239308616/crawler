package cn.itcast.crawler.autohome.service;

import java.util.List;

import cn.itcast.crawler.autohome.pojo.Talk_information;

public interface ApiService {

	
	/**
	 * Get请求获取宣讲会id
	 * @param url
	 * @return 返回宣讲会id
	 */
	public List<String> getTalkId(String url);
	/**
	 * 根据宣讲会id获取talk_information对象
	 * @param url
	 * @param id
	 * @return
	 */
	public Talk_information getTalk(String url,String id);
}
