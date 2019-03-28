package cn.itcast.crawler.autohome.pojo;

public class Company {

    private int company_id; //公司id
    private String company_name; //公司名称
    private String industry_category; //工作领域
    private String scale; //规模
    private String introduction; //公司介绍
    private String tel; //公司电话
    private String mail; //公司邮箱
    private String job_mail; //工作邮箱
    private String city_name;//公司所在城市
    private String address;//公司地址

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getIndustry_category() {
        return industry_category;
    }

    public void setIndustry_category(String industry_category) {
        this.industry_category = industry_category;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getJob_mail() {
        return job_mail;
    }

    public void setJob_mail(String job_mail) {
        this.job_mail = job_mail;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Company [company_id=" + company_id + ", company_name=" + company_name + ", industry_category="
                + industry_category + ", scale=" + scale + ", introduction=" + introduction + ", tel=" + tel + ", mail="
                + mail + ", job_mail=" + job_mail + ", city_name=" + city_name + ", address=" + address + "]";
    }

}
