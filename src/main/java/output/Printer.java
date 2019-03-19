package output;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Printer {
    public static Printer INSTANCE;

    public static Printer getInstance(){
        if(INSTANCE == null)
            return new Printer();
        return INSTANCE;
    }
}
