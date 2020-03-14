package org.learntotravel.web_ui.repository;

import org.learntotravel.web_ui.direction.Direction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DirectionRepository extends MongoRepository<Direction, UUID> {

    Direction findTopByOrderByIdDesc();

}
