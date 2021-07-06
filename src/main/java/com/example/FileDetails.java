package com.example;

public class FileDetails {

  private Long fileSizeBytes;

  private String collectionName;

  private String name;

  public Long getFileSizeBytes() {
    return fileSizeBytes;
  }

  public String getCollectionName() {
    return collectionName;
  }

  public String getName() {
    return name;
  }

  public FileDetails(Long fileSizeBytes, String collectionName, String name) {
    this.fileSizeBytes = fileSizeBytes;
    this.collectionName = collectionName;
    this.name = name;
  }
}
