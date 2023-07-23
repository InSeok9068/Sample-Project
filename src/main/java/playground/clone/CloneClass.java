package playground.clone;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CloneClass implements Cloneable {
    private String val;

    @Override
    protected CloneClass clone() throws CloneNotSupportedException {
        return (CloneClass) super.clone();
    }
}
