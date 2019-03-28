package cn.itcast.crawler.autohome.pojo;

public class Job {

    private int publish_id; //职位id
    private String job_name; //职位名称
    private String about_major; //需求专业
    private String job_number; //职位人数
    private String city_name; //对象城市
    private String degree_require; //学历要求
    private String salary; //薪水
    private String create_time; //创建时间
    private int cid; //公司id

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getPublish_id() {
        return publish_id;
    }

    public void setPublish_id(int publish_id) {
        this.publish_id = publish_id;
    }

    public String getJob_name() {
        return job_name;
    }

    public void setJob_name(String job_name) {
        this.job_name = job_name;
    }

    public String getAbout_major() {
        return about_major;
    }

    public void setAbout_major(String about_major) {
        this.about_major = about_major;
    }

    public String getJob_number() {
        return job_number;
    }

    public void setJob_number(String job_number) {
        this.job_number = job_number;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getDegree_require() {
        return degree_require;
    }

    public void setDegree_require(String degree_require) {
        this.degree_require = degree_require;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "Job [publish_id=" + publish_id + ", job_name=" + job_name + ", about_major=" + about_major
                + ", job_number=" + job_number + ", city_name=" + city_name + ", degree_require=" + degree_require
                + ", salary=" + salary + ", create_time=" + create_time + ", cid=" + cid + "]";
    }

}
