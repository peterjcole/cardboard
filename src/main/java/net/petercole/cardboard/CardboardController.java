package net.petercole.cardboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class CardboardController {

    @Autowired
    private CardboardRepository cardboardRepository;

    @PostMapping("/cardboard")
    public ResponseEntity<Cardboard> postCardboard(@RequestParam String colour, @RequestParam Integer quantity) {
        Cardboard entity = new Cardboard(colour, quantity);
        cardboardRepository.save(entity);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(entity.getId())
                .toUri();

        return ResponseEntity.created(uri).body(entity);
    }

    @GetMapping("/cardboard")
    public ResponseEntity<List<Cardboard>> getCardboard() {
        return ResponseEntity.ok(cardboardRepository.findAll());
    }
}
