package com.example;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

public class DirectoryReport {

  @Getter
  private Long totalSizeBytes;

  @Getter
  private List<Directory> topDirectories;

  public DirectoryReport(Long totalSizeBytes, List<Directory> topDirectories) {
    this.totalSizeBytes = totalSizeBytes;
    this.topDirectories = new ArrayList<>(topDirectories);
  }

  public void addCollection(Directory c) {
    topDirectories.add(c);
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Total size : "+totalSizeBytes);
    sb.append("\n");
    for(Directory c : topDirectories) {
      sb.append(c.toString());
      sb.append("\n");
    }
    return sb.toString();
  }
}
