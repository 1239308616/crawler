package cn.itcast.crawler.autohome.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class DateFormat {

	public static String toDateFormatJSONString(String data) throws Exception{
		//将字符串转为JSON对象
		JSONObject parseObject = JSON.parseObject(data);
		//获取JSON对象中的meet_time属性
		String meet_time = parseObject.get("meet_time").toString();
		//创建格式化时间的类
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
		//转换时间对象
		Date date = dateFormat.parse(meet_time);
		//设置时间对象
		parseObject.replace("meet_time", date);
		//将处理好的JSON对象转为字符串
		String dataString = parseObject.toString();
		return dataString;
	}
}
