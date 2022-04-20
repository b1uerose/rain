package org.xiao.rain.test.array;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * 数组是对象，父类是Object
 * Author: xiaojl
 * Date: 2021/6/27 15:50
 */
public class ArrayTest01 implements Comparable {

    public static void main(String[] args) {
//        int[] array1 = {1, 2, 3, 4, 5, 6};
//        int[] array2 = new int[5];
//        System.arraycopy(array1, 1, array2, 0, 2);
//        for (int i : array2) {
//            System.out.println(i);
//        }
//
//        int[] array3 = new int[]{1, 23, 4, 5, 6, 1, 4};

        String xxx = "%7B%22serviceCode%22:%22webnc%22,%22sessionid%22:%22A0FFDC2427F55EB2B80C205379074370%22,%22isMobile%22:false,%22isOcr%22:false,%22cuserid%22:%220001V5100000000000UW%22,%22pk_corp%22:%221001%22,%22dataSource%22:%22NCDB%22,%22fileName%22:%22%E5%BE%85%E7%A1%AE%E8%AE%A4%E9%97%AE%E9%A2%98%EF%BC%88%E6%8C%81%E7%BB%AD%E6%9B%B4%E6%96%B0%EF%BC%89.docx%22,%22busiParam%22:%7B%22billType%22:%22%22,%22billId%22:%22tmpf1001A11000000002LWDM%22,%22nodepath%22:%22YXB1/tmpf1001A11000000002LWDM/%25E9%2593%25B6%25E8%25A1%258C%25E5%259B%259E%25E5%258D%2595%25EF%25BC%2588%25E6%2597%25A0%25E9%259C%2580%25E4%25B8%258A%25E4%25BC%25A0%25EF%25BC%2589%22,%22fileName%22:%22%E5%BE%85%E7%A1%AE%E8%AE%A4%E9%97%AE%E9%A2%98%EF%BC%88%E6%8C%81%E7%BB%AD%E6%9B%B4%E6%96%B0%EF%BC%89.docx%22,%22tempBillFileID%22:%22tmpf1001A11000000002LWDM%22,%22iorder%22:5,%22sysCode%22:%22webnc%22%7D%7D";
//        if(!YCPubUtils.isEmpty(nodepath)){
//            nodepath = URLDecoder.decode(nodepath,"UTF-8");
//        }

        try {
            String result = URLDecoder.decode(xxx, "ISO-8859-1");
            System.out.println(result);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }

    private void dosome() {
        int[] array = {1, 2, 3};
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}


