package com.mindasoft._01_data_type;

/**
 * @author: min
 * @date: 2018/11/8 17:26
 * @version: 1.0.0
 */
public class IntegerPlusPlusLearning implements Runnable{

    public static Integer i = new Integer(0);

    @Override
    public void run() {
        while (true){
            synchronized (i){
                if(i <200){
                    i++;
                    System.out.println(i);
                }else{
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new IntegerPlusPlusLearning());
        Thread t2 = new Thread(new IntegerPlusPlusLearning());
        t1.start();
        t2.start();
    }
}
