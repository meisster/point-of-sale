package output;

import lombok.Data;

@Data
public abstract class OutputDevice {

    private String name;

    public void print(String message){
        System.out.println(getName() + ": " + message);
    }
}
