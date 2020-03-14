package org.learntotravel.web_ui.repository;

import org.learntotravel.web_ui.direction.Direction;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GenerateUuidListener extends AbstractMongoEventListener<Direction> {

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Direction> event) {
        Direction direction = event.getSource();
        if (direction.getId() == null) {
            direction.setId(UUID.randomUUID());
        }
    }
}
