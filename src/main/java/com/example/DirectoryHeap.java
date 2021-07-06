package com.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class DirectoryHeap {

  //acting as max heap
  private PriorityQueue<Directory> queue;

  private List<Directory> elements;

  public DirectoryHeap() {
    this.queue = new PriorityQueue<>(Comparator.comparing(Directory::getTotalSizeBytes).reversed());
  }

  public void addElement(Directory folders) {
    queue.add(folders);
  }

  //costly
  public void updateElement(Directory folders) {
    queue.remove(folders);
    queue.add(folders);
  }

  public List<Directory> getTopElement(int k) {
    Iterator<Directory> queueIterator = queue.iterator();
    List<Directory> elements = new ArrayList<>();
    while(k>0 && queueIterator.hasNext()) {
      elements.add(queueIterator.next());
      k--;
    }
    return elements;
  }
}