package com.department.deng.boss直聘面试题;

/**
 * Created by deng on 19-5-8.
 * <p>
 * 使用两个线程分别打印aAbBcCdD....xXyYzZ
 */
public class PrintUpperAndLowerCharacters {

    private static String lock = "lock";

    private static int aIndex = 0;
    private static int bIndex = 0;

    private static String strA = "abcdefghigklmnopqrstuvwxyz";
    private static String strB = "ABCDEFGHIGKLMNOPQRSTUVWXYZ";

    private static volatile boolean flag;  //此处必须用volatile 否则，可能陷入死循环。

    public static void main(String[] args) throws InterruptedException {
//        KafkaProducer producer;
//        HashMap<String,String> map=new HashMap<String, String>();
//
//        map.put("A","b");
        long start = System.currentTimeMillis();

        final Thread a = new Thread(new Runnable() {
            public void run() {
                long start = System.currentTimeMillis();
                for (; aIndex < strA.length(); ) {
                    if (flag) {
                        System.out.println(strA.charAt(aIndex++));
                        flag = !flag;
                    }
                }

                System.out.println("thread a cost: " + (System.currentTimeMillis() - start));
            }
        });

        Thread b = new Thread(new Runnable() {
            public void run() {
                long start = System.currentTimeMillis();
                for (; bIndex < strB.length(); )
                    if (!flag) {
                        System.out.println(strB.charAt(bIndex++));
                        flag = !flag;
                    }

                System.out.println("thread b cost: " + (System.currentTimeMillis() - start));
            }
        });


        a.start();

        b.start();

        System.out.println("thread all cost: " + (System.currentTimeMillis() - start));
    }

}
