package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName = null;
    private String partOfContent = null;
    private int minSize = -1;
    private int maxSize = -1;
    private List<Path> foundFiles = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        if (checkOfContent(file)
                && checkPartOfName(file.getFileName().toString())
                && checkMinSize((int)attrs.size())
                && checkMaxSize((int)attrs.size())) {
            foundFiles.add(file);
        }
        return super.visitFile(file, attrs);
    }

    private boolean checkOfContent(Path file) throws IOException {
        if (partOfContent == null)
            return true;

        return new String(Files.readAllBytes(file)).contains(partOfContent);
    }

    private boolean checkPartOfName(String filename) {
        if (partOfName == null)
            return true;
        return filename.contains(partOfName);
    }

    private boolean checkMinSize(int fileSize) {
        if (minSize < 0)
            return true;
        return minSize <= fileSize;
    }

    private boolean checkMaxSize(int fileSize) {
        if (maxSize < 0)
            return true;
        return maxSize >= fileSize;
    }


    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

}
