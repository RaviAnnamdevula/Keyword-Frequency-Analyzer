package org.collectionsP;

public class Keyword {

    private String key;


    private int count;

    public Keyword(String keyword, Integer count) {
        this.key = keyword;
        this.count = count;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String keyword) {
        this.key = keyword;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
