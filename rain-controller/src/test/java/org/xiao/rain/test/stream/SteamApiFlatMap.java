package org.xiao.rain.test.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * flatmap
 * Author: xiaojl
 * Date:2022-07-02 13:38
 */
public class SteamApiFlatMap {
    
    @Test
    public void test() throws Exception {
        
        String[] array = new String[]{"hello", "world"};
        List<Stream<String>> list1 = Stream.of(array)
                .map(x -> Stream.of(x.split("")))
                .collect(Collectors.toList());

        System.out.println(list1);

        List<String> list2 = Stream.of(array)
                .flatMap(x -> Stream.of(x.split("")))
                .collect(Collectors.toList());

        System.out.println(list2);

        List<Stream<String>> collect = Stream.of(array)
                .flatMap(x -> {
                            String[] splitArray = x.split("");
                            Stream<Stream<String>> streamStream =
                                    Arrays.stream(splitArray).map(m -> Arrays.stream(m.split("")));
                            return streamStream;
                        }
                ).collect(Collectors.toList());

        System.out.println(collect);


        Stream.of(array)
                .flatMap(x -> Stream.of(x.split("")))
                .collect(Collectors.toList()).forEach(System.out::println);
    }
    
    
}
