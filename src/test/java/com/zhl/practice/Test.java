package com.zhl.practice;

import java.util.*;

/**
 * @author Holley
 * @Description 请输入一句话进行描述
 * @create 2019-06-13 11:19
 **/
public class Test {

    public static void main(String[] args){
//        Map<Integer,a> map = new HashMap<Integer,a>();
//        Integer uid = null;
//        double redPackMoney = 0;
//        a aa = null;
//        for (int i = 1; i < 9; i++) {
//            uid = i%2;
//            if (map.get(uid) != null) {
//                aa = map.get(uid);
//                redPackMoney = aa.money;
//            }else{
//                aa = new Test().new a();
//            }
//            redPackMoney += 100;
//            aa.money = redPackMoney;
//            map.put(uid, aa);
//            System.out.println(uid + " 的值是 " + redPackMoney);
//        }
//        System.out.println("-------------------------------");
//        for (Map.Entry<Integer, a> e : map.entrySet()) {
//            System.out.println(e.getKey() + " 的值是 " + e.getValue().money);
//        }

//        int[] nums = {2,7,11,15}; int target = 9;
//        int[] aa = new int[2];
//        List<Integer> list = new ArrayList<Integer>();
//        for(int i = 0;i<nums.length;i++){
//            // aa[i] = nums[i];
//            list.add(nums[i]);
//        }
//        int b = 0;
//        for(int i = 0;i<list.size();i++){
//            System.out.println(list.get(i));
//            b = target-list.get(i);
//            if(list.contains(b)){
//                aa[0] = i;
//            }
//        }
//        for(int i = aa[0]+1;i<list.size();i++){
//            if(list.get(i)==b){
//                aa[1] = i;
//            }
//        }
//        System.out.println(aa[0] + "---------------" + aa[1]);
        String s = "";
        System.out.println(s != "");
        System.out.println(s.equals(""));

        int m=12,n=34;
        System.out.printf("%d%d",m++,++n);
        System.out.printf("%d%d\n",n++,++m);

        Set cc = new HashSet();
        cc.add(23);

        cc.add(41);
        cc.add(15);
        System.out.println(cc.toString());
        String aa = "4";
        System.out.println(String.format("%.1f",Float.valueOf(aa)));
    }
    class a{

        int uid;

        double money;
    }
}
