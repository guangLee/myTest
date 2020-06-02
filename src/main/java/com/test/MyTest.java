package com.test;
import cn.hutool.core.util.ZipUtil;
import com.google.common.collect.*;
import com.test.Child;

import java.io.*;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.BlockingDeque;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.zip.GZIPInputStream;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.util.MyUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import sun.misc.BASE64Decoder;

import static com.test.SetCategory.CATEGORY_MAP;

public class MyTest {

    public static void main(String[] args) {

//        List<com.lombok.User> list = new ArrayList<>();
//        list.add(new com.lombok.User(1, 1));
//        list.add(new com.lombok.User(1, 2));
//        list.add(new com.lombok.User(2, 1));
//        list.add(new com.lombok.User(2, 3));
//        list.add(new com.lombok.User(2, 2));
//        list.add(new com.lombok.User(3, 1));
//        Map<Integer, List<com.lombok.User>> map = new HashMap<>();
//        for(com.lombok.User user : list){
//            if(map.containsKey(user.getId())){//map中存在此id，将数据存放当前key的map中
//                map.get(user.getId()).add(user);
//            }else{//map中不存在，新建key，用来存放数据
//                List<com.lombok.User> tmpList = new ArrayList<>();
//                tmpList.add(user);
//                map.put(user.getId(), tmpList);
//            }
//        }
//        System.out.println(map.toString());

//        Date date = new Date();//获取当前时间
//        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.MONTH, -1);
//        Date date = calendar.getTime();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String dateStr = sdf.format(date);
//        System.out.println(dateStr);

//        String str = "gecko) chrome/75.0.3770.80 safari/537.36";
//        String str = "gecko) chrome/75.0.3770.80";
//        System.out.println(str.indexOf("chrome/"));
//        String s = str.substring(str.indexOf("chrome/")+7).split("\\.")[0];
//        System.out.println(s);

//        String originalFilename = "员工映射Excel.xls";
//        String fileType = originalFilename.substring(0,originalFilename.lastIndexOf("."));
//        System.out.println(fileType);

//        int bianchang =25;
//        int zhongjianchang = (bianchang * 2) - 1;
//
//        for(int m = 1; m <=(zhongjianchang+1)/2; m++)
//        {
//            for(int b = 1; b <=(zhongjianchang+1)/2-m ; b++)
//            {
//                System.out.print(" ");
//            }
//            for(int c = 1; c <= m*2-1; c++)
//            {
//                System.out.print("*");
//            }
//            System.out.println();//换行
//        }
//        for(int d =(zhongjianchang+1)/2-1;d >= 1; d --)
//        {
//            for(int b = 1; b <= (zhongjianchang+1)/2-d; b++)
//            {
//                System.out.print(" ");
//            }
//            for(int c = (zhongjianchang+1)/2-d; c <=(zhongjianchang+1)/2-2+d; c ++)
//            {
//                System.out.print("*");
//            }
//            System.out.println();
//        }


// 普通Collection的创建
//        List<String> list = Lists.newArrayList();
//        Set<String> set = Sets.newHashSet();
//        Map<String, String> map = Maps.newHashMap();

// 不变Collection的创建
//        ImmutableList<String> iList = ImmutableList.of("a", "b", "c");
//        ImmutableSet<String> iSet = ImmutableSet.of("e1", "e2");
//        ImmutableMap<String, String> iMap = ImmutableMap.of("k1", "v1", "k2", "v2");

//        Map<String, Integer> items = new HashMap<>();
//        items.put("A", 10);
//        items.put("B", 20);
//        items.put("C", 30);
//        items.put("D", 40);
//        items.put("E", 50);
//        items.put("F", 60);
//
//        items.forEach((k,v)->System.out.println("Item : " + k + " Count : " + v));
//
//        items.forEach((k,v)->{
//            System.out.println("Item : " + k + " Count : " + v);
//            if("E".equals(k)){
//                System.out.println("Hello E");
//            }
//        });

//        String s = "标准的十个汉字不是吗";
//
//        while (s.contains("  ")){
//            s = s.replace("  "," ");
//        }
//        System.out.println(s);

//        String str = "标准的是个汉字不是吗标准的是个汉字不是吗标准的是个汉字不是吗标准的是个汉字不是吗标准的是个汉字不是吗标准的是个汉字不是吗标准的是个汉字不是吗标准的是个汉字不是吗标准的是个汉字不是吗标准的是个汉字不是吗标准的是个汉字不是吗标准的是个汉字不是吗标准的是个汉字不是吗标准的是个汉字不是吗标准的是个汉字不是吗标准的是个汉字不是吗标准的是个汉字不是吗标准的是个汉字不是吗标准的是个汉字不是吗标准的是个汉字不是吗标准的是个汉字不是吗标准的是个汉字不是吗标准的是个汉字不是吗标准的是个汉字不是吗标准的是个汉字不是吗标准的是个汉字不是吗标准的是个汉字不是吗标准的是个汉字不是吗标准的是个汉字不是吗标准的是个汉字不是吗标准的是个汉字不是吗标准的是个汉字不是吗标准的是个汉字不是吗标准的是个汉字不是吗标准的是个汉字不是吗标准的是个汉字不是吗标准的是个汉字不是吗标准的是个汉字不是吗标准的是个汉字不是吗标准的是个汉字不是吗标准的是个汉字不是吗标准的是个汉字不是吗标准的是个汉字不是吗标准的是个汉字不是吗标准的是个汉字不是吗标准的是个汉字不是吗标准的是个汉字不是吗标准的是个汉字不是吗标准的是个汉字不是吗标准的是个汉字不是吗";
//        String s = "标准的十个汉字不是吗";
//        StringBuilder sb = new StringBuilder();
//        for (int j = 0; j <100 ; j++) {
//            sb.append(s);
//        }
//        s = sb.toString();
//        System.out.println(s);
//        s = s.substring(0,999);
//        System.out.println(s);


//        System.out.println(str.length());

//       String str = "H4sIAAAAAAAAAE2SvW7DMAyE30WzBlGiKNFr12brVnQIEqcNkFqB4xYIgrx7ZesE1MuHI+/0Zz7M\n" +
//               "4Ws/TePlpRxHMxjvjTWnuXybgawpp9PlPI0v+2X8LPPdDI+nNde5HH8OCwLkOKmwjZmdRKs+J0eb\n" +
//               "irkVXUMrpmTFCUe2iZQl2Bx9iGpzdolqnHxktsqBRBqSJZeUNFvVGsWiDZlqM2RHNVJN3lkizhQF\n" +
//               "jLWtTHXTplPTOUBnaFq1F0pgBrWRHQgfezCADEZQkIcm2Y6p2tZZ79vY9gnS/KGds+pO9FPPwRd7\n" +
//               "H3Uh+AI0Q0cQOVnfI2p98cZA0ArtoOEL3c/QHuz5bR+pvw7MoIKxkbtPoB1IoEc/gFyH8LaUeVyH\n" +
//               "7PV8W8zw/lgH7/c8HUZMXnTr999Zi7qjXS+93a+97Fwwzw9rlmKGLff8A1iQe/b5AgAA";
//
//        System.out.println(ungzip("H4sIAAAAAAAAAKtWSivKz1WyMtRRyk9Ly8nMSw3Kzy9xzkksLnZKzcnPSw/JV7KKVjI0UtJRMjRW\n" +
//                "itVRKgEKmBoAQS0AZHGRxzwAAAA="));
//
//        User u1 = new User();
//        User u2 = new User();
//        User u3 = new User();
//        User u4 = new User();
//        u1.setName("wangwu");
//        u1.setAge(5);
//        u2.setName("zhangsan");
//        u2.setAddress("ttt");
//        u2.setAge(6);
//        u3.setName("lisi");
//        u3.setAge(2);
//        u4.setName("zhangsan");
//        u4.setAddress("ttt");
//        u4.setAge(9);
//        shopProductList.add(u1);
//        shopProductList.add(u2);
//        shopProductList.add(u3);
//        shopProductList.add(u4);
//
//        shopProductList = shopProductList.stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toList());
//
//        System.out.println(shopProductList);

//        shopProductList = shopProductList.stream()
//                .collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(f -> f.getName()+f.getAddress()))), ArrayList::new));

//        List<String> recordList = new ArrayList<>();
//        shopProductList.forEach(shopProduct->{
//            String record = shopProduct.getName()+shopProduct.getAddress();
//            if (recordList.contains(record)) {
//                shopProductList.remove(shopProduct);
//            }else{
//                recordList.add(record);
//            }
//        });

//        System.out.println(shopProductList);

//        for (int j = 0; j <10 ; j++) {
//            for (int k = 0; k <7 ; k++) {
//                System.out.print("*");
//            }
//            System.out.println();
//        }

//        List<String> channelList = new ArrayList<>();
//        String[] array = "bb".split("/");
//        for (String s : array) {
//            System.out.println(s);
//        }
//        channelList.add("aa");
//        channelList.add("bb");
//        channelList.add("cc");
//        System.out.println(channelList.stream().collect(Collectors.joining(",")));
//        String categoryPath = "受打击；是打开；的好时；机啊啊";
//        System.out.println(categoryPath);
//        categoryPath = categoryPath.replace("；",";");
//        System.out.println(categoryPath);

//        User u1 = new User();
//        User u2 = new User();
//        User u3 = new User();
//        User u4 = new User();
//        u1.setName("wangwu");
//        u2.setName("zhangsan");
//        u3.setName("lisi");
//        u4.setName("zhangsan");
//        List<User> userList = new ArrayList<>();
//        userList.add(u1);
//        userList.add(u2);
//        userList.add(u3);
//        userList.add(u4);
//
//        Map<String,Long> userMap =userList.stream().map(User::getName).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//
//        List<String> result = new ArrayList<>();
//        userMap.forEach((k,v)->{
//            if(v>1){
//                result.add(k);
//            }
//        });
//        if (CollUtil.isNotEmpty(result)) {
//            System.out.println("come in");
//        }
//
//        System.out.println(userList.subList(0, 4));

//        System.out.println(2 % 3);
//        System.out.println(2 / 3);
//        User u= new User();
//
//        if (null == u.getName()) {
//            System.out.println("6");
//        }

//        Objects.
//        String sapProductHash = MD5Util.getMD5String("2092,0.6");
//        System.out.println(sapProductHash);

//        String[] str = {"111","222","333","555"};
//
//        for (int j = 0; j <str.length ; j++) {
//            if (j == str.length -1) {
//                System.out.println(str[j]);
//            }
//        }

//        CATEGORY_MAP.get("19001").setCategory(u1,"lisi");
//        System.out.println(u1);

//        User u1 = new User();
//        User u2 = new User();
//        User u3 = new User();
//        User u4 = new User();
//        u1.setName("wangwu");
//        u2.setName("zhangsan");
//        u3.setName("lisi");
//        u4.setName("zhangsan");
//        List<User> userList = new ArrayList<>();
//        userList.add(u1);
//        userList.add(u2);
//        userList.add(u3);
//        userList.add(u4);
//
//        List<String> nameList = userList.stream().map(User::getName).distinct().collect(Collectors.toList());
//        System.out.println(nameList);

//        JSONArray json = new JSONArray();
//        Long test = 12346L;
//        Object  o = (Object)test;
//
//        String s = (String)o;
////        String s = test.toString();
////        String s = String.valueOf(test);
//
//        System.out.println(s);
//        List<String> codeList1 = new ArrayList<>(Arrays.asList("110000","220000","120000","820000","530000"));
//
//        System.out.println(codeList1.subList(1, 5));
//        List<String> codeList2 = new ArrayList<>(Arrays.asList("460000","450000","370000","610000","150000"));
//        List<String> codeList2 = new ArrayList<>(Arrays.asList("460000","450000"));
//
//
//        List<String> saleRegionSortList = codeList2.stream().sorted(
//                Comparator.comparing(Integer::valueOf)).collect(Collectors.toList());
//        String saleRegionSortStr = CollUtil.join(saleRegionSortList,"");
//
//        System.out.println("saleRegionSortStr = " + saleRegionSortStr);

//        codeList1.stream().sorted((code1,code2)->(Integer.valueOf(code1)<Integer.valueOf(code2))).collect(Collectors.toList());

//        Comparator<String> sortByName = ;
//        List<String> codeList3 = codeList2.stream().sorted(Comparator.comparing(Integer::valueOf)).collect(Collectors.toList());

//        System.out.println(codeList3);
//        List<String> codeList3 = new ArrayList<>(Arrays.asList("","","","",""));
//        List<String> codeList4 = new ArrayList<>(Arrays.asList("","","","",""));

//        StoreTypeEnum.values()
//
//        List list = new ArrayList<>(Arrays.asList("111"));
//
//        System.out.println(CollUtil.join(list, ","));

//        String s = "Bravo,Mini,卫星仓";
//        String s = "888 888 8888";
//        String s = "Bravo,Mini,卫星仓";
//        String s = "Bravo,Mini,卫星仓";
//        String s = "Bravo,Mini,卫星仓";
//        String s = "Bravo,Mini,卫星仓";

//        s = s.replace("，",",");
//        String[] strArray = s.split(",");
//
//        List<String> exclusiveStoreTypeCodeList = new ArrayList<>();
//        for (final String s1 : strArray) {
//            if(StoreTypeEnum.BRAVO_CODE.getName().equals(s1)){
//                exclusiveStoreTypeCodeList.add(StoreTypeEnum.BRAVO_CODE.getValue());
//            }else if(StoreTypeEnum.MINI_CODE.getName().equals(s1)){
//                exclusiveStoreTypeCodeList.add(StoreTypeEnum.MINI_CODE.getValue());
//            }else if(StoreTypeEnum.SATELLITE_CODE.getName().equals(s1)){
//                exclusiveStoreTypeCodeList.add(StoreTypeEnum.SATELLITE_CODE.getValue());
//            }else{
//                System.out.println("666");
//            }
//        }

//        String s = null;
//
//        String s2 = "";
//
//        String s3 = "  ";
//
//        String s4 = "\t\r\n";

//        System.out.println(StringUtils.isEmpty(s));
//        System.out.println(StringUtils.isEmpty(s2));
//        System.out.println(StringUtils.isEmpty(s3));
//        System.out.println(StringUtils.isEmpty(s4));
//
//        System.out.println("---------------------");
//
//        System.out.println(StringUtils.isBlank(s));
//        System.out.println(StringUtils.isBlank(s2));
//        System.out.println(StringUtils.isBlank(s3));
//        System.out.println(StringUtils.isBlank(s4));

//        String s = "22.22";
//
//        BigDecimal big = new BigDecimal(s);
//        System.out.println(big);

//        User u = new User();
//        String str = u.getLife() ?"shi":"fou";
//        System.out.println("str = " + str);

//        Integer s = (Integer)u.getObject();
//        System.out.println("s = " + s);

//        String s = "  sds sdsad rtrtr   sdsd  ";
//        s = s.trim();
//        System.out.println(s);
//
//        String str = "  \t  \r  \n  ";
//
//        System.out.println("StringUtils.isNotBlank(str) = " + StringUtils.isBlank(str));


//        File tempFile = new File("skuUpdateImport-" + System.currentTimeMillis() + ".xlsx");
//
//        System.out.println("tempFile.getAbsolutePath() = " + tempFile.getAbsolutePath());
//
//        System.out.println("tempFile.getPath() = " + tempFile.getPath());
//
//        try {
//            System.out.println("tempFile.getCanonicalPath() = " + tempFile.getCanonicalPath());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        User u = new User();
//        String str;
//        if (StringUtils.isEmpty(u.getName())) {
//             str = "test";
//        }else{
//             str = u.getName() + "test";
//        }
//
//        System.out.println(str);
//        test();

//        List<String> list = Arrays.asList("a", "b", "c");
//        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));
//        List<String> list2 = new ArrayList<>(Arrays.asList("d", "e", "f"));
//        List<String> list3 = new ArrayList<>(Arrays.asList("h", "i", "j"));

//        for (String s : list) {
//            s = s.concat("%");
//        }
//        System.out.println("list = " + list);
//        list.forEach(s->{
//            s = s.concat("%");
//        });
//        System.out.println("list = " + list);

//        String newLine = System.getProperty("line.separator");
//        for (int j = 0; j < 4; j++) {
//            System.out.printf("list.get(%d) = " + list.get(j)+newLine,j);
//        }
//
//        list.forEach(l->{
//            if (l.equals("b")) {
//                return;
//            }
//            System.out.println(l);
//        });
//        list.forEach(l->{
//            System.out.println(l);
//        });
//        Collections.reverse(list);
//
//        System.out.println(Collections.max(list));
//        System.out.println("*************");
//        list.forEach(l->{
//            System.out.println(l);
//        });
//         list.clear();
//         list.remove("a");
//         list.add("g");
//        list.forEach(l->{
//            System.out.println(l);
//        });

//        String str = "[\"你啥的\",\"你的撒开\",\"刷卡好的\",\"u 的卧底\",\"\"dfsfdsd]";
////        String str = "erwerfdsdf54645654  fdbdfgd&&&%^%^dfsdfd  dfd1111";
//
////        List<String> strList = (List<String>)JSON.parse(str);
////        System.out.println(strList);
//
//        List<String> strList = JSON.parseArray(str, String.class);
//
//        System.out.println(strList);

//        JSONArray array= null;
//        try {
//            array = JSONArray.parseArray(str);
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println(str);
//        }
//        if (array != null && !array.isEmpty()) {
//            for (int i = 0; i <array.size(); i++) {
//                if (StringUtils.isNotEmpty(array.get(i).toString())) {
//                    System.out.println(array.get(i).toString());
//                }
//            }
//        }
//        List<User> userList = new ArrayList<>();
////
//        User u1 = new User();
//        u1.setName("11");
//        u1.setAge(11);
//
//        User u2 = new User();
//        u2.setName("22");
//        u2.setAge(22);
//
//        User u3 = new User();
//        u3.setName("33");
//        u3.setAge(33);
//
//        userList.add(u1);
//        userList.add(u2);
//        userList.add(u3);
//
//        for (User user : userList) {
//            user.setAge(66);
//        }
//
//        System.out.println(userList);

//        userList.add(u2);
//        userList.add(u2);
//        userList.add(u1);
//
//        System.out.println(userList);
//        int i =7;
//
//        if(i==3){
//            System.out.println("3");
//        }else if(i == 6){
//            System.out.println("6");
//        }else if(i == 7){
//            System.out.println("7");
//        }else {
//            System.out.println("other");
//        }



//        List<Integer> integerList = new ArrayList<>();
//
//        for (int j = 0; j <20 ; j++) {
//            integerList.add(j);
//        }
//
//        List<List<Integer>> pageList = Lists.partition(integerList,80);
//
//        System.out.println(pageList);

//        testCopy();

//        System.out.println(ChannelCodeEnum.ELEME_CHANNEL_CODE.getName());
//        listNotEmpty();
//        String str = null;
//        try {
//            str = ChannelCodeEnum.fromValue("88").getName();
//            System.out.println(str+"222222222");
//        } catch (Exception e) {
//            System.out.println("渠道编码错误");
//        }
//        System.out.println(str);


//        String str = null;
//        String str2 = null;
//
//        System.out.println(str);
//        System.out.println(str2);
//        String str3 = "str "+str+str2;
//        System.out.println(str3);
//
//        List<String> items = new ArrayList<>();
//
//        items = null;
//
//        Optional<String> optional = items.stream().findFirst();
//
//        optional.ifPresent(System.out::println);

//        items.add("A");
//        items.add("B");
//        items.add("C");
//        items.add(null);
//        items.add("");
//        items.add("D");
//        items.add("E");

//        System.out.println(String.join(",", items));
//
//        String str = items.stream().collect(Collectors.joining("|"));
//        System.out.println(str);

        //lambda
        //Output : A,B,C,D,E
//        items.forEach(item->System.out.println(item));
//
//        //Output : C
//        items.forEach(item->{
//            item.toLowerCase();
//        });
//        List<String> items2 =items.stream().map(item->item.toLowerCase()).collect(Collectors.toList());
//
//        items2.forEach(System.out::println);
//
//        //method reference
//        //Output : A,B,C,D,E
//        items.forEach(System.out::println);
//
//        //Stream and filter
//        //Output : B
//        items.stream()
//                .filter(s->{
//                    if (s != null) {
//                        return s.contains("B");
//                    }
//                    return false;
//                })
//                .forEach(System.out::println);

//        Map<String, Integer> items = new HashMap<>();
//
//        items = null;

//        items.put("A", 10);
//        items.put("B", 20);
//        items.put("C", 30);
//        items.put("D", 40);
//        items.put("E", 50);
//        items.put("F", 60);

//        items.forEach((k,v)->System.out.println("Item : " + k + " Count : " + v));
//
//        items.forEach((k,v)->{
//            System.out.println("Item : " + k + " Count : " + v);
//            if("E".equals(k)){
//                System.out.println("Hello E");
//            }
//        });

//          String path = "55556";
//        path = path.substring(0,path.length()-1);
//        System.out.println(path);

//        String nul  = null;
//        System.out.println(path.equals(nul));
//        System.out.println(nul.equals(path));

//        method4();
//        List<String> strList = new ArrayList<>();
//        strList.add("33");
//        strList.add("22");
//        strList.add("55");
//        strList.add("66");
//        strList.add("88");
//        System.out.println(strList.stream().collect(Collectors.joining("|")));
//        User u = new User();
//        u.setName(null);
//        System.out.println(u);
//
//        com.datastructure.queue.User uOther = new com.datastructure.queue.User();
//
//        System.out.println(uOther);

//        System.out.println(i);

//        System.out.println((10 / 3));
//        System.out.println((10 % 3));

//        System.out.println((1 % 5));
//        System.out.println((2 % 5));
//        System.out.println((3 % 5));
//        System.out.println((4 % 5));
//        System.out.println((5 % 5));

//        System.out.println((-4)%(3));//取余
//        System.out.println(Math.floorMod(-4, 3));//取模
//
//
//        System.out.println(Math.floorMod(1, 5));//取模
//        System.out.println(Math.floorMod(2, 5));//取模
//        System.out.println(Math.floorMod(3, 5));//取模
//        System.out.println(Math.floorMod(4, 5));//取模


//        int i = 2670;
//        int ii = 666;
//        int iii = 23;
//        int j = 6;
//
//        BigDecimal bd =  new BigDecimal(i).divide(new BigDecimal(100));
//        System.out.println(bd);
//
//        BigDecimal bd1 =  new BigDecimal(ii).divide(new BigDecimal(100));
//        System.out.println(bd1);
//
//        BigDecimal bd2 =  new BigDecimal(iii).divide(new BigDecimal(100));
//        System.out.println(bd2);
//
//        BigDecimal bd3 =  new BigDecimal(j).divide(new BigDecimal(100));
//        System.out.println(bd3);


//        System.out.println(flag);
//        MyBank m = new MyBank();
//        m.liucheng();

        //StringBuilder s = new StringBuilder();
        //User u = new User();
        //u.setName("22");
        //System.out.println(u.getName());
        //MyUtil.getStrArray("我就试试这个方法").forEach(s-> System.out.println(s));
        //long l = 1529062650561L;
        //
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //try {
        //    System.out.println(sdf.format(new Date(Long.valueOf("gggggggg"))));
        //} catch (Exception e) {
        //    e.printStackTrace();
        //    System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        //}
        //System.out.println(getNum(6));

    }

    private static void testCopy() {
//        Book b1 = new Book("b1",50);
//        Book b2 = new Book("b1",50);
//        Book b3 = new Book("b1",50);
//        List<Book> bookList = new ArrayList<>();
//        bookList.add(b1);
//        bookList.add(b2);
//        bookList.add(b3);
//
//        Child c = new Child("boy",10);
//
//        User u = new User("lisi",30,true,"china",c,bookList);
//
//        System.out.println(u);
//
////        Bank b = new MyBank();
//        TestBean b = new TestBean();
//
//        BeanUtils.copyProperties(u,b);
//
//        System.out.println(b);
    }

    public static String ungzip(String zipVal) {
        if (zipVal == null) {
            return null;
        } else {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ByteArrayInputStream in = null;
            GZIPInputStream ginzip = null;
//            byte[] compressed = null;
            String decompressed = null;

            try {
                byte[] compressed = (new BASE64Decoder()).decodeBuffer(zipVal);
                in = new ByteArrayInputStream(compressed);
                ginzip = new GZIPInputStream(in);
                byte[] buffer = new byte[1024];
                boolean var7 = true;

                int offset;
                while((offset = ginzip.read(buffer)) != -1) {
                    out.write(buffer, 0, offset);
                }

                decompressed = out.toString();
            } catch (IOException var24) {
                var24.printStackTrace();
            } finally {
                if (ginzip != null) {
                    try {
                        ginzip.close();
                    } catch (IOException var23) {
                    }
                }

                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException var22) {
                    }
                }

                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException var21) {
                    }
                }

            }

            return decompressed;
        }
    }
    private static void listNotEmpty() {
        List<User> userList = new ArrayList<>();

        User u1 = new User();
        u1.setName("11");
        u1.setAge(11);

        User u2 = new User();
        u2.setName("22");
        u2.setAge(22);

        User u3 = new User();
        u3.setName("33");
        u3.setAge(33);

        User u4 = new User();
        u4.setName("44");
        u4.setAge(44);

        userList.add(u1);
        userList.add(u2);
        userList.add(new User());
//        userList.add(null);
        userList.add(u3);
        userList.add(u4);

//        List<User> userList2 = userList.stream().map(user->{
//            user.setName("lisi");
//            return user;
//        }).collect(Collectors.toList());

        for(User u:userList){
            u.setName("lisi");
        }

        userList.forEach(u->{
            if(u.getAge()==33){
                u.setName("zhangsan");
            }
        });

        System.out.println(userList);
//        for(User u:userList){
//            if (u != null) {
//                System.out.println(u.getName());
//            }
//        }
//
//        userList.forEach(user-> {
//            if (user != null) {
//                System.out.println(user.getName());
//            }
//            });
    }

    public static int getNum(int n){
        if(n <= 2){
            //System.out.println(1);
            return 1;
        }else {
            int ret = getNum(n-1) + getNum(n-2);
            System.out.println(ret);
            return ret;
        }
    }

    private static boolean flag;
    static int i;

    public static void method1() {
        System.out.println(5 / 0);
    }

    public static void method2(){
        method1();
    }
    public static void method3(){
        method2();
    }
    public static void method4(){
        try {
            method3();
        } catch (Exception e) {
            System.out.println("8888888888888");
        }
    }
}
