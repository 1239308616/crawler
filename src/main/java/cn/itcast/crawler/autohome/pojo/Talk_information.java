package cn.itcast.crawler.autohome.pojo;

import java.util.Date;
import java.util.List;

public class Talk_information {

    private int career_talk_id; //宣讲会id
    private String school_name; //学校名称
    private String meet_name; //公司名称
    private Date meet_time; //举行时间
    private String address; //举行地点
    private int company_id; //公司id
    private Company company; //公司信息对象
    private List<Job> jobs; //公司招聘职位集合

    public int getCareer_talk_id() {
        return career_talk_id;
    }

    public void setCareer_talk_id(int career_talk_id) {
        this.career_talk_id = career_talk_id;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getMeet_name() {
        return meet_name;
    }

    public void setMeet_name(String meet_name) {
        this.meet_name = meet_name;
    }

    public Date getMeet_time() {
        return meet_time;
    }

    public void setMeet_time(Date meet_time) {
        this.meet_time = meet_time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    @Override
    public String toString() {
        return "Talk_information [career_talk_id=" + career_talk_id + ", school_name=" + school_name + ", meet_name="
                + meet_name + ", address=" + address + ", company_id=" + company_id + ", company=" + company + ", jobs="
                + jobs + "]";
    }

}
