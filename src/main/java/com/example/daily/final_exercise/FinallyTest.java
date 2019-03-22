package com.example.daily.final_exercise;

import com.example.daily.DailyApplication;
import org.springframework.boot.SpringApplication;

import java.util.ArrayList;
import java.util.List;
/**
 * finally是在retrun语句执行后，return返回之前执行的，也就是说finally必执行（当然是建立在try执行的基础上） 
 *
 * finally中修改的基本类型没有return是不影响返回结果的，有了retrun才会影响
 *
 * finally中修改list ,map,set引用类型时，就算没有return，也是是影响返回结果的
 *
 */
public class FinallyTest {
    public static void main(String[] args) {

        SpringApplication.run(DailyApplication.class, args);
       /* int j = query1();
        System.out.println(j);
        int j = query2();
        System.out.println(j);*/

        List<String> cats = new ArrayList<>();
        cats = query3(cats);
        System.out.println("----");
        for (String cat : cats)
            System.out.println(cat);
    }


    public static void query() {
        int i = 0;
        try {
            i++;
            i = i / 0;// 抛出异常            
            System.out.println("某一些操作");
        } catch (Exception e) {
            i += 20;
        } finally {
            System.out.println("必需要执行的操作");
        }
    }


    public static int query1() {
        int i = 0;
        try {
            System.out.print("try\n");
            return i += 10;
        } catch (Exception e) {
            System.out.print("catch\n");
            i += 20;
        } finally {
            System.out.print("finally-i:" + i + "\n");
            i += 10;
            System.out.print("finally\n");
            //return i;
        }
        System.out.print("finally-i--:" + i + "\n");
        return i;
    }


    public static int query2() {
        int i = 0;
        try {
            System.out.print("try\n");
            return i += 10;
        } catch (Exception e) {
            System.out.print("catch\n");
            i += 20;
        } finally {
            System.out.print("finally-i:" + i + "\n");
            i += 10;
            System.out.print("finally\n");
            return i;
        }
    }

    public static List<String> query3(List<String> cats) {
        try {
            System.out.print("try\n");
            cats.add("xiaoMeng");
            return cats;
        } catch (Exception e) {
            System.out.print("catch\n");
        } finally {
            System.out.print("finally\n");
            cats.add("qiaoGeLi");
        }
        System.out.println("finish");
        return null;
    }
}
