package app.myapp.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Board implements Serializable {

  private static final long serialVersionUID = 100L;

  private int category;
  private int no;
  private String title;
  private String content;
  private JJ_Member writer;
  private Date createdDate;
  private List<AttachedFile> files;
  private int fileCount;

  @Override
  public String toString() {
    return "Board{" +
        "category=" + category +
        ", no=" + no +
        ", title='" + title + '\'' +
        ", content='" + content + '\'' +
        ", writer=" + writer +
        ", createdDate=" + createdDate +
        ", files=" + files +
        ", fileCount=" + fileCount +
        '}';
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public JJ_Member getWriter() {
    return writer;
  }

  public void setWriter(JJ_Member writer) {
    this.writer = writer;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  public int getCategory() {
    return category;
  }

  public void setCategory(int category) {
    this.category = category;
  }

  public List<AttachedFile> getFiles() {
    return files;
  }

  public void setFiles(List<AttachedFile> files) {
    this.files = files;
  }

  public int getFileCount() {
    return fileCount;
  }

  public void setFileCount(int fileCount) {
    this.fileCount = fileCount;
  }
}
