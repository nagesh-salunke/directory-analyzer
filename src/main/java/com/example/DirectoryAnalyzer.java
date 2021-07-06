package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DirectoryAnalyzer {

  private Map<String, Directory> collectionMap;

  private DirectoryHeap directoryHeap;

  public DirectoryAnalyzer() {
    directoryHeap = new DirectoryHeap();
    collectionMap = new HashMap<>();
  }

  public void add(List<FileDetails> files) {
    for (FileDetails file : files) {
      String collectionName = file.getCollectionName();
      if (collectionMap.containsKey(collectionName)) {
        Directory folders = collectionMap.get(collectionName);
        folders.addFile(file);
        directoryHeap.updateElement(folders);
      } else {
        Directory folders = new Directory(collectionName);
        folders.addFile(file);
        collectionMap.put(collectionName, folders);
        directoryHeap.addElement(folders);
      }
    }
  }

  public void add(FileDetails file) {
    List<FileDetails> files = new ArrayList<>();
    files.add(file);
    add(files);
  }

  public DirectoryReport getReport(int topK) {
    List<Directory> topElements = directoryHeap.getTopElement(topK);
    Long totalSize = topElements.stream().map(Directory::getTotalSizeBytes).reduce(0L, Long::sum);
    DirectoryReport report = new DirectoryReport(totalSize, topElements);
    return report;
  }
}
