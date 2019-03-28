package cn.itcast.crawler.autohome.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cn.itcast.crawler.autohome.pojo.Talk_information;

@Mapper
public interface TalkMapper {

	/**
	 * 保存宣讲会信息
	 * @param talk
	 */
	void saveTalk(Talk_information talk);
	/**
	 * 分页查询宣讲会id
	 * @param map
	 * @return
	 */
	List<Integer> queryTalkIdByPage(Map<String, Object> map);
}
