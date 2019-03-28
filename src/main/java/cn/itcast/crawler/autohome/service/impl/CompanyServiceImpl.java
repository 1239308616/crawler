package cn.itcast.crawler.autohome.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.crawler.autohome.mapper.CompanyMapper;
import cn.itcast.crawler.autohome.pojo.Company;
import cn.itcast.crawler.autohome.service.CompanyService;
@Service
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	private CompanyMapper companyMapper;

	@Override
	public void saveCompany(Company company) {
		this.companyMapper.saveCompany(company);
	}

	@Override
	public Company getCompanyById(int company_id) {
		Company company = this.companyMapper.getCompanyById(company_id);
		return company;
	}

}
