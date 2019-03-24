package output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@Data
@AllArgsConstructor
public abstract class OutputDevice {

    private String name;

    public void print(String... messages) {
        Arrays.stream(messages)
              .forEach(m -> System.out.println(getName() + ": " + m));
    }
}
