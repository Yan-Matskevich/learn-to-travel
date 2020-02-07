package org.learntotravel.web_ui.repository;

import org.learntotravel.web_ui.direction.Direction;

public interface DirectionReposiotry {

    long getNextFreeId();

    long addDirection(Direction direction);

    long updateDirection(Direction direction);

    Direction getDirection(long id);

}
