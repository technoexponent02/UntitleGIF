package com.etebarian.meowbottomnavigaion.generator;


import com.etebarian.meowbottomnavigaion.model.ScreenBO;

import java.util.ArrayList;
import java.util.List;

public class ScreenOneGenerator {

    public static List<ScreenBO> screenOneBOList(){
        List<ScreenBO> screenBOList = new ArrayList<ScreenBO>();

        for(int i = 0;i<10;i++){
            ScreenBO screenBO = new ScreenBO();
            screenBO.setId(i+"");
            screenBO.setTitle("Luxury villa");
            screenBO.setAddress("Central park");
            screenBOList.add(screenBO);

        }
        return screenBOList;
    }
}
