package com.mindasoft._03_collection.mutiset;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Multiset允许重复，但是不保证顺序
 * 常见使用场景：Multiset有一个有用的功能，就是跟踪每种对象的数量，所以你可以用来进行数字统计。
 * Created by huangmin on 2017/9/19 22:08.
 */
public class MutisetStart {

    //HashMultiset TreeMutiset LinkedHashMutiset ConcurrentHashMutiset

    @Test
    public void hashMutiSetStart(){
        String strWorld="wer|dffd|ddsa|dfd|dreg|de|dr|ce|ghrt|cf|gt|ser|tg|ghrt|cf|gt|" +
                "ser|tg|gt|kldf|dfg|vcd|fg|gt|ls|lser|dfr|wer|dffd|ddsa|dfd|dreg|de|dr|" +
                "ce|ghrt|cf|gt|ser|tg|gt|kldf|dfg|vcd|fg|gt|ls|lser|dfr";
        String[] words=strWorld.split("\\|");

        //传统方式
        Map<String, Integer> countMap = new HashMap<String, Integer>();
        for (String word : words) {
            Integer count = countMap.get(word);
            if (count == null) {
                countMap.put(word, 1);
            }
            else {
                countMap.put(word, count + 1);
            }
        }
        System.out.println("##########countMap：");
        for(String key:countMap.keySet()){
            System.out.println(key+" count："+countMap.get(key));
        }

        //HashMultiset方式
        List<String> wordList=new ArrayList<String>();
        for (String word : words) {
            wordList.add(word);
        }
        Multiset<String> wordsMultiset = HashMultiset.create();
        wordsMultiset.addAll(wordList);
        System.out.println("###########HashMultiset：");
        for(String key:wordsMultiset.elementSet()){
            System.out.println(key+" count："+wordsMultiset.count(key));
        }

    }

    @Test
    public void testMultsetWordCount(){
        String strWorld="wer|dfd|dd|dfd|dda|de|dr";
        String[] words=strWorld.split("\\|");
        List<String> wordList=new ArrayList<String>();
        for (String word : words) {
            wordList.add(word);
        }
        Multiset<String> wordsMultiset = HashMultiset.create();
        wordsMultiset.addAll(wordList);

        if(!wordsMultiset.contains("peida")){
            wordsMultiset.add("peida", 2);
          }

        System.out.println("============================================");
        for(String key:wordsMultiset.elementSet()){
        System.out.println(key+" count："+wordsMultiset.count(key));
        }


        if(wordsMultiset.contains("peida")){
        wordsMultiset.setCount("peida", 23);
            }

        System.out.println("============================================");
        for(String key:wordsMultiset.elementSet()){
        System.out.println(key+" count："+wordsMultiset.count(key));
          }

        if(wordsMultiset.contains("peida")){
        wordsMultiset.setCount("peida", 23,45);
    }

        System.out.println("============================================");
        for(String key:wordsMultiset.elementSet()){
        System.out.println(key+" count："+wordsMultiset.count(key));
    }

        if(wordsMultiset.contains("peida")){
        wordsMultiset.setCount("peida", 44,67);
    }

        System.out.println("============================================");
        for(String key:wordsMultiset.elementSet()){
        System.out.println(key+" count："+wordsMultiset.count(key));
    }
    }
}
