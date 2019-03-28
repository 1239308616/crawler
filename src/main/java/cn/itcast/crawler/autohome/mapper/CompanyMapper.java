package cn.itcast.crawler.autohome.mapper;

import org.apache.ibatis.annotations.Mapper;

import cn.itcast.crawler.autohome.pojo.Company;

@Mapper
public interface CompanyMapper {

	/**
	 * 保存公司信息
	 * @param company
	 */
	void saveCompany(Company company);
	/**
	 * 通过id查询公司信息
	 * @param company_id
	 * @return
	 */
	Company getCompanyById(int company_id);
}
