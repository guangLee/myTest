package com.test;


import java.util.HashMap;
import java.util.Map;

public interface SetCategory{

    void setCategory(User productportVO, String category);

    Map<String, SetCategory> CATEGORY_MAP = new HashMap() {
        {
            put("22001",new BravoYh());
            put("2001",new BravoJd());
            put("19001",new BravoMt());
            put("7001", new BravoEle());

        }
    };
}

class BravoYh implements SetCategory {
    @Override
    public void setCategory(User productportVO, String category){
        productportVO.setName(category);
    }
}

class BravoJd implements SetCategory {
    @Override
    public void setCategory(User productportVO, String category){
        productportVO.setName(category);
    }
}

class BravoMt implements SetCategory {
    @Override
    public void setCategory(User productportVO, String category){
        productportVO.setName(category);
    }
}

class BravoEle implements SetCategory {
    @Override
    public void setCategory(User productportVO, String category){
        productportVO.setName(category);
    }
}
