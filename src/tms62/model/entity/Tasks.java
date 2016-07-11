package tms62.model.entity;

import java.util.Date;

public class Tasks {

  private int    taskId;
  private int    subjectId;
  private String name;
  private String description;
  private Date   createAt;
  private Date   updateAt;

  public int getTaskId() {

    return taskId;
  }

  public void setTaskId(int taskId) {

    this.taskId = taskId;
  }

  public int getSubjectId() {

    return subjectId;
  }

  public void setSubjectId(int subjectId) {

    this.subjectId = subjectId;
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
