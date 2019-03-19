package output;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LCDDisplay {

    public static LCDDisplay INSTANCE;

    public static LCDDisplay getInstance(){
        if(INSTANCE == null)
            return new LCDDisplay();
        return INSTANCE;
    }

    public void print(String... messages){
        for (String message : messages) {
            System.out.println("LCD_DISPLAY: " + message);
        }
    }
}
