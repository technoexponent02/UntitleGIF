package com.etebarian.meowbottomnavigaion.generator;


import com.etebarian.meowbottomnavigaion.model.ScreenBO;

import java.util.ArrayList;
import java.util.List;

public class ScreenThreeGenerator {

    public static List<ScreenBO> screenThreeBOList(){
        List<ScreenBO> screenBOList = new ArrayList<ScreenBO>();

        for(int i = 0;i<10;i++){
            ScreenBO screenBO = new ScreenBO();
            screenBO.setId(i+"");
            screenBO.setTitle("The 42 Chowringhee Kolkata");
            screenBO.setAddress("Elgin road");
            screenBO.setPrice("Rs 17 crore onwards");
            screenBOList.add(screenBO);

        }
        return screenBOList;
    }
}
