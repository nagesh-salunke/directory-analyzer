package com.example;

import java.util.HashSet;
import java.util.Set;
import lombok.Getter;

public class Directory {

  private String name;

  @Getter
  private Long totalSizeBytes;

  private Set<FileDetails> fileDetailsSet;

  public Directory(String name) {
    this.name = name;
    this.fileDetailsSet = new HashSet<>();
    this.totalSizeBytes = 0L;
  }

  public String toString() {
    return "name : " + name + " size: " + totalSizeBytes;
  }

  public void addFile(FileDetails file) {
    if (!fileDetailsSet.contains(file.getName())) {
      this.fileDetailsSet.add(file);
      this.totalSizeBytes += file.getFileSizeBytes();
    }
  }
}
