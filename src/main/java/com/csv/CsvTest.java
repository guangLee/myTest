package com.csv;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * CSV操作(导出和导入)
 *读进入一个csv,然后把其中的一列的时间戳改成有格式的时间类型，然后输出一个新的csv
 */
public class CsvTest {

    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println();

        File file = new File("C:\\Users\\wb-lhg427173\\Desktop\\test_data.csv");
        List<String> dataList = CSVUtils.importCsv(file);

        List<String> dataListNew = new ArrayList<>();

        dataList.forEach(data->{
            String[] strArr = data.split(",");
            String timeLong = null;
            try {
                timeLong = strArr[6];
            } catch (Exception e) {
                e.printStackTrace();
                dataListNew.add(data);
            }
            if(StringUtils.isNotBlank(timeLong)){

                try {
                    strArr[6] = sdf.format(new Date(Long.valueOf(timeLong)));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    dataListNew.add(data);
                }
            }

            dataListNew.add(Arrays.toString(strArr));
        });

        File fileNew = new File("C:\\Users\\wb-lhg427173\\Desktop\\test_data_new.csv");
        CSVUtils.exportCsv(fileNew,dataListNew);
    }
}
