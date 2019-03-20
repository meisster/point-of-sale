package output;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LCDDisplay extends OutputDevice{

    private static LCDDisplay INSTANCE;

    private LCDDisplay(String name){
        super(name);
    }

    public static LCDDisplay getInstance(){
        if(INSTANCE == null)
            INSTANCE = new LCDDisplay("LCD_DISPLAY");
        return INSTANCE;
    }

}
