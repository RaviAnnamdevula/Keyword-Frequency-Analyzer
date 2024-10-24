package org.collectionsP;

import java.util.*;

public interface KeyAnalyzer {
    void storedKeyword(String keyword);

    List<String> getAllKeyword();
    default Map<String , Keyword> getKeyFrequencies(){
        return null;
    }

    default Map<String,Integer> getTop5Records(){
        return null;
    }

}
