package wooapp.myapp.vo;

import java.io.Serializable;
import java.util.Date;

public class JJ_Member implements Serializable {

  private static final long serialVersionUID = 100L;

  private int no;
  private String belt;
  private String name;
  private int age;
  private String weight;
  private String team;
  private Date createdDate;

  @Override
  public String toString() {
    return "JJ_Member{" +
        "no=" + no +
        ", belt='" + belt + '\'' +
        ", name='" + name + '\'' +
        ", age='" + age + '\'' +
        ", weight='" + weight + '\'' +
        ", team='" + team + '\'' +
        ", createdDate=" + createdDate +
        '}';
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getBelt() {
    return belt;
  }

  public void setBelt(String belt) {
    this.belt = belt;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getWeight() {
    return weight;
  }

  public void setWeight(String weight) {
    this.weight = weight;
  }

  public String getTeam() {return team;}

  public void setTeam(String team) {
    this.team = team;

  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }
}



