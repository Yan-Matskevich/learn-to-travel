package org.learntotravel.web_ui.repository;

import org.learntotravel.web_ui.direction.Direction;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component("DirectionRepositoryList")
public class DirectionRepositoryListImpl implements DirectionReposiotry {

    private List<Direction> directions;
    private volatile long latest;

    DirectionRepositoryListImpl() {
        latest = 1;
        directions = new ArrayList<>();
        addInitItem("lalal");
        addInitItem("tort");
        addInitItem("stol");
    }

    private void addInitItem(String part) {
        Direction direction = new Direction();
        direction.setThreshold(1);
        direction.setEmails(Arrays.asList(part+"1@test.com", part+"2@test.com",part+"3@test.com"));
        direction.setSource(part +"some link");
        addDirection(direction);
    }

    @Override
    public long getNextFreeId() {
        return latest;
    }

    @Override
    public long addDirection(Direction direction) {
        direction.setId(getNextFreeId());
        directions.add(direction);
        latest++;
        return direction.getId();
    }

    @Override
    public long updateDirection(Direction direction) {
        Direction oldDirection = getDirection(direction.getId());
        oldDirection.setSource(direction.getSource());
        oldDirection.setEmails(direction.getEmails());
        oldDirection.setThreshold(direction.getThreshold());
        oldDirection.setSourceType(direction.getSourceType());
        return oldDirection.getId();
    }

    @Override
    public Direction getDirection(long id) {
        Optional<Direction> foundItem = directions.stream().filter(item -> item.getId() == id).findFirst();
        if (foundItem.isPresent()) {
            return foundItem.get();
        }
        return null;
    }
}
