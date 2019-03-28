package cn.itcast.crawler.autohome.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import cn.itcast.crawler.autohome.pojo.Talk_information;
import cn.itcast.crawler.autohome.service.ApiService;
/*import net.sf.json.JSONArray;
import net.sf.json.JSONObject;*/
import cn.itcast.crawler.autohome.util.DateFormat;

@Service
public class ApiServiceImpl implements ApiService {

	// 注入HttpClient连接管理器
	@Autowired
	private PoolingHttpClientConnectionManager cm;

	/**
	 * 获取请求参数对象
	 * 
	 * @return
	 */
	private RequestConfig getConfig() {
		RequestConfig config = RequestConfig.custom().setConnectTimeout(1000)// 设置创建连接的超时时间
				.setConnectionRequestTimeout(500) // 设置获取连接的超时时间
				.setSocketTimeout(10000) // 设置连接的超时时间
				.build();

		return config;
	}
	@Override
	public List<String> getTalkId(String url) {
		
		// 获取HttpClient对象
		CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();
		// 声明httpGet请求对象
		HttpGet httpGet = new HttpGet(url);
		// 设置用户代理信息
		httpGet.setHeader("User-Agent", "");
		// 设置请求参数RequestConfig
		httpGet.setConfig(this.getConfig());
		
		CloseableHttpResponse response  = null;
		try {
			response= httpClient.execute(httpGet);
			// 解析response返回数据
			if(response.getStatusLine().getStatusCode() == 200) {
				String html = "";
				List<String> list = new ArrayList<String>();
				// 需要对Entity进行非空的判断
				if(response.getEntity() != null){
					html = EntityUtils.toString(response.getEntity(),"UTF-8");
					//得到json对象
					 JSONObject parseObject = JSON.parseObject(html);
					//等到json对象中宣讲会相关信息的json数组
					JSONArray jsonArray = JSONArray.parseArray(parseObject.getString("data"));
					//遍历json数组，将等到的宣讲会相关的id存入list集合
					for(int i = 0;i < jsonArray.size();i++ ){
						JSONObject object = JSON.parseObject(jsonArray.get(i).toString());
						list.add(object.get("career_talk_id").toString());
					}
				}
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(response != null) {
				try {
					// 关闭连接
					response.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
 
		return null;
	}
	@Override
	public Talk_information getTalk(String url, String id) {
		// 获取HttpClient对象
		CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();
		//拼接url地址
		String realUrl = url + id;
		// 声明httpGet请求对象
		HttpGet httpGet = new HttpGet(realUrl);
		// 设置用户代理信息
		httpGet.setHeader("User-Agent", "");
		// 设置请求参数RequestConfig
		httpGet.setConfig(this.getConfig());

		CloseableHttpResponse response = null;
		try {
			response =  httpClient.execute(httpGet);
			//解析response返回的数据
			if(response.getStatusLine().getStatusCode() == 200) {
				String html = "";
				//对Entity进行非空判断
				if(response.getEntity() != null) {
					html = EntityUtils.toString(response.getEntity(),"UTF-8");
					
					//转换为json对象
					JSONObject jsonObject  = JSON.parseObject(html);
					//得到json对象中的data数据
					String data = jsonObject.get("data").toString();
					//处理data中的日期格式
					String dataString = DateFormat.toDateFormatJSONString(data);
					//将json字符串序列化为java类
					Talk_information talk = JSON.parseObject(dataString, new TypeReference<Talk_information>() {});
					return talk;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if (response != null) {
					// 关闭连接
					response.close();
				}
				// 不能关闭，现在使用的是连接管理器
				// httpClient.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

}
