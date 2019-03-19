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
}
