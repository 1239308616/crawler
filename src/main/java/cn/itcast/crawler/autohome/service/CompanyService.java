package cn.itcast.crawler.autohome.service;

import cn.itcast.crawler.autohome.pojo.Company;

public interface CompanyService {

	/**
	 * 保存公司信息
	 * @param company
	 */
	void saveCompany(Company company);
	
	/**
	 * 通过id查询
	 * @param company_id
	 * @return
	 */
	Company getCompanyById(int company_id);
}
