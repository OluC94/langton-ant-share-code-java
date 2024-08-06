package org.academy.langton;

import processing.core.PApplet;

public class RandomWalkAnt extends AntTemplate implements Ant {

    public RandomWalkAnt(PApplet p5, Ground ground, GridPosition startPos) {
        super(p5, ground, startPos);

    }


    @Override
    public void update() {
        Direction randomDirection = Direction.random();
        moveInDirection(randomDirection);

        ground.cellAt(gridPosition).advanceStateColour();
    }

    @Override
    public void display() {
        p5.fill(0, 255, 0);
        Ground.drawSquareAtGridPosition(gridPosition, p5, ground.getCellSize());
    }

    @Override
    public GridPosition getGridPosition() {
        return gridPosition;
    }
}