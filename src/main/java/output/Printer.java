package output;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Printer extends OutputDevice{

    private static Printer INSTANCE;

    private Printer(String name){
        super(name);
    }

    public static Printer getInstance(){
        if(INSTANCE == null)
            INSTANCE = new Printer("PRINTER");
        return INSTANCE;
    }

}
