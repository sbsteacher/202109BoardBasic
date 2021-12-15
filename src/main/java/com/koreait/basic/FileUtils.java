package com.koreait.basic;

import java.io.File;

public class FileUtils {
    //폴더 삭제
    public static void delFolder(String path) {
        delFolderFiles(path, true);
    }

    //폴더 아래 파일만 삭제
    public static void delFolderFiles(String path, boolean isDelFolder) {
        File folder = new File(path);
        if(folder.exists()) {
            File[] fileList = folder.listFiles();
            if(fileList == null) { return; } //폴더 아래에 파일이 없는 의미
            for(File f : fileList) {
                if(f.isDirectory()) {
                    delFolderFiles(f.getPath(), true);
                } else {
                    f.delete();
                }
            }
        }
        if(isDelFolder) { folder.delete(); }
    }
}
