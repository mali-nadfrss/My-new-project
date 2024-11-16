package com.mali.ds.design;

import java.util.ArrayList;
import java.util.List;

/* https://jerry4013.github.io/Github-blog/2020/08/03/LeetCode-588.html */
public class InMemoryFileSystem {

  class File {
    boolean isFile = false;
    List<File> files;
    String content = "";
    String name;

    File(boolean isFile, String name) {
      this.isFile = isFile;
      this.name = name;
    }
  }

  File root = new File(false, "/");

  List<String> ls(String path) {
    List<String> ans = new ArrayList<>();
    File base = root;
    String[] paths = path.split("/");
    for (int i = 1; i < paths.length; i++) {
      for (File file : base.files) {
        if (file.name.equals(paths[i])) {
          base = file;
          break;
        }
      }
    }
    if (base.isFile == true) {
      ans.add(base.name);
    } else {
      for (File file : base.files) {
        ans.add(file.name);
      }
    }
    return ans;
  }

  void mkdir(String path) {
    String[] paths = path.split("/");
    File base = root;
    for (int i = 1; i < paths.length; ) {
      boolean found = false;
      if (base.files == null) {
        base.files = new ArrayList<>();
        base.files.add(new File(false, paths[i]));
      } else {
        for (File file : base.files) {
          if (file.name.equals(paths[i])) {
            base = file;
            found = true;
            i++;
            break;
          }
        }
        if (!found) {
          base.files.add(new File(false, paths[i]));
        }
      }
    }
  }

  // String readContent(String path) {}

  void addContents(String path) {}

  public static void main(String[] args) {

    InMemoryFileSystem fileSystem = new InMemoryFileSystem();
    fileSystem.mkdir("/home/nmali/idea");
  }
}
