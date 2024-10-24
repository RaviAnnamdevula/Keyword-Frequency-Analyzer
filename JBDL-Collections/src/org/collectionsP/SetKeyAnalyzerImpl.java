package org.collectionsP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetKeyAnalyzerImpl implements KeyAnalyzer{

    Set<String> set;

    public SetKeyAnalyzerImpl(){
        set = new HashSet<>();
    }

    @Override
    public void storedKeyword(String keyword) {
        set.add(keyword);
    }

    @Override
    public List<String> getAllKeyword() {
        List<String> list =  new ArrayList<>(set);
        return list;
    }
}
