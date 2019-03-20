package output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class OutputDevice {

    private String name;

    public void print(String... messages){
        for (String message : messages) {
            System.out.println(getName() + ": " + message);
        }
    }
}
