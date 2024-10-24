package org.collectionsP;

import java.util.*;

public class MapKeyAnalyzerImpl implements KeyAnalyzer{
    public Map<String, Keyword> map;

    public Queue<Keyword> queue ;



    public MapKeyAnalyzerImpl(){
        map =  new HashMap<>();
        queue = new PriorityQueue<>(comparator);
// comparable we use with the class and once comparable is inside the class and then we can use  basically call the comparator
// both are interfaces
/*
    Comparator
    . It contains the method called compare
*/
/*
    Comparable
    . It contains the method called compareTo
*/
    }

    Comparator<Keyword> comparator = new Comparator<Keyword>() {
        @Override
        public int compare(Keyword o1, Keyword o2) {
            return Integer.compare(o2.getCount() , o1.getCount());
            /*if(o1.getCount() > o2.getCount()){
                return 1;
            }else {
                return -1;
            }*/
        }
    };

    @Override
    public void storedKeyword(String key) {
        int count = 1;

        if(map.containsKey(key)){
            Keyword keyword = map.get(key);
            queue.remove(keyword);
            count = keyword.getCount();
            keyword.setCount(count+1);
            queue.add(keyword);
            map.put(key,keyword);
            //map.put(keyword, map.get(keyword)+1);
        }else{
            Keyword k = new Keyword(key ,count);
            map.put(key, k);
            queue.add(k);
        }
    }

    @Override
    public List<String> getAllKeyword() {
        return null;
    }

    @Override
    public Map<String , Keyword> getKeyFrequencies(){
        return map;
    }

    @Override
    public Map<String,Integer> getTop5Records(){
        Map<String , Integer> topFive = new LinkedHashMap<>();
        for (int i = 0; i < 5; i++) {
            Keyword k = queue.poll();
            topFive.put(k.getKey() , k.getCount());
        }
        for (Keyword keywords : queue) {

        }
        return topFive;
    }
}
