package com.etebarian.meowbottomnavigaion.generator;


import com.etebarian.meowbottomnavigaion.model.ScreenBO;

import java.util.ArrayList;
import java.util.List;

public class ScreenTwoGenerator {

    public static List<ScreenBO> screenTwoBOList(){
        List<ScreenBO> screenBOList = new ArrayList<ScreenBO>();

        for(int i = 0;i<10;i++){
            ScreenBO screenBO = new ScreenBO();
            screenBO.setId(i+"");
            screenBO.setTitle("South City");
            screenBO.setAddress("22, Prince Anwar Shah Road, 2nd Floor, Merlin Oxford.");
            screenBO.setPrice("Rs 2 crore onwards");
            screenBOList.add(screenBO);

        }
        return screenBOList;
    }
}
