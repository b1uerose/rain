package org.xiao.rain.test.other;

/**
 * Author: xiaojl
 * Date: 2021/8/3 15:17
 */
public class StringTest01 {

    public static void main(String[] args) {
        
//        String vusername = "051001900211";
//        
//        String string = vusername.substring(10,12);
//        System.out.println(string);
//        
//        
//        String formula = "freplyvalue->finitloss+nadminfreplyvalue";
//
//        
//        int index = formula.lastIndexOf("vreplyitemdoc");
        
//        String[] array = new String[]{"11", "22"};
//        System.out.println(Arrays.toString((String[])Array.newInstance(array.getClass().getComponentType(), 2)));
//        
//        
//        String num = "14.000000000000";
//
//        String t = num.replaceAll(" 0+$", "");
//        System.out.println(t);


        try {
            int i = 10 / 0;
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }
}
