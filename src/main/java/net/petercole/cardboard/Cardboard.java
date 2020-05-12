package net.petercole.cardboard;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
public class Cardboard {

    @Id
    public String id;

    public String colour;
    public Integer quantity;

    public Cardboard(String colour, Integer quantity) {
        this.colour = colour;
        this.quantity = quantity;
    }
}
