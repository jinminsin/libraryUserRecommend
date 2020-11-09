package com.example.recommend;

import java.util.HashMap;

public class QuestionHashmap {
    static HashMap<String, String[]> questionHash = new HashMap<String, String[]>(){
        {
            put("", new String[] {"현상?", "T","F"});
            put("T", new String[] {"자연?", "T", "F"});
            put("F", new String[] {"인류의 발자취?", "T", "F"});
            put("TT", new String[] {"이론보다 실용?", "T", "F"});
            put("TF", new String[] {"사회과학"});  // finalnode
            put("FT", new String[] {"사색을많이?", "T", "F"});
            put("FF", new String[] {"그림이나 조각?", "T", "F"});
            put("TTT", new String[] {"기술과학"});  // finalnode
            put("TTF", new String[] {"사회과학"});  // finalnode
            put("FTT", new String[] {"신을 믿음?", "T", "F"});
            put("FTF", new String[] {"역사에 관심?", "T", "F"});
            put("FFT", new String[] {"예술"});  // finalnode
            put("FFF", new String[] {"비문학보다 문학?", "T", "F"});
            put("FTTT", new String[] {"종교"});  // finalnode
            put("FTTF", new String[] {"철학"});  // finalnode
            put("FTFT", new String[] {"역사"});  // finalnode
            put("FTFF", new String[] {"언어"});  // finalnode
            put("FFFT", new String[] {"문학"});  // finalnode
            put("FFFF", new String[] {"총류(비문학)"});  // finalnode
        }
    };

}
