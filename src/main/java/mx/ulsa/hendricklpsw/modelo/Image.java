package mx.ulsa.hendricklpsw.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }}
