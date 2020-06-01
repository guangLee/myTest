package com.io;

import java.io.File;

/**
 * 使用切记，要把 新建的file对象，目录要跟源文件保持一致，否则，源文件夹为空，修改后的文件都跑到了Java项目路径下
 */
public class UpdateFileName {

    public static void main(String[] args) {

        File f = new File("D:\\learnVideo\\韩顺平图解Java数据结构和算法\\视频");
        File[] files = f.listFiles();
        for (File file2 : files) {
            String fileName = file2.getName();
            String newFileName = fileName.replace("尚硅谷_佟刚", "");
            File newFile = new File("D:\\learnVideo\\韩顺平图解Java数据结构和算法\\视频\\" + newFileName);
            file2.renameTo(newFile);
        }
    }
}
