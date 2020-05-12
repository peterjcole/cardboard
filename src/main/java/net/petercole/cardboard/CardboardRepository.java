package net.petercole.cardboard;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CardboardRepository extends MongoRepository<Cardboard, String> {
    public List<Cardboard> findAll();
}
