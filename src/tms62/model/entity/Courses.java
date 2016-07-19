package tms62.model.entity;

import java.util.Date;

public class Courses {

  private int     courseId;
  private String  name;
  private String  description;
  private Date    startDate;
  private Date    endDate;
  private boolean status;
  private Date    createAt;
  private Date    updateAt;

  public int getCourseId() {

    return courseId;
  }

  public void setCourseId(int courseId) {

    this.courseId = courseId;
  }

  public String getName() {

    return name;
  }

  public void setName(String name) {

    this.name = name;
  }

  public String getDescription() {

    return description;
  }

  public void setDescription(String description) {

    this.description = description;
  }

  public Date getStartDate() {

    return startDate;
  }

  public void setStartDate(Date startDate) {

    this.startDate = startDate;
  }

  public Date getEndDate() {

    return endDate;
  }

  public void setEndDate(Date endDate) {

    this.endDate = endDate;
  }

  public boolean isStatus() {

    return status;
  }

  public void setStatus(boolean status) {

    this.status = status;
  }

  public Date getCreateAt() {

    return createAt;
  }

  public void setCreateAt(Date createAt) {

    this.createAt = createAt;
  }

  public Date getUpdateAt() {

    return updateAt;
  }

  public void setUpdateAt(Date updateAt) {

    this.updateAt = updateAt;
  }

}
