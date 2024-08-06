package org.academy.langton;

import processing.core.PApplet;

public class AntTemplate implements Ant{
    protected GridPosition gridPosition;
    protected Ground ground;
    protected PApplet p5;

    public AntTemplate(PApplet p5, Ground ground, GridPosition startingPos) {
        this.gridPosition = startingPos.copy();
        this.ground = ground;
        this.p5 = p5;
    }

    @Override
    public void update() {
        // remain empty for subclass implementation
    }

    @Override
    public void display() {
        // remain empty for subclass implementation
    }

    @Override
    public GridPosition getGridPosition() {
        return gridPosition.copy();
    }

    void moveInDirection(Direction givenDir) {
        DirectionalOffset offset = DirectionalOffset.offsetFor(givenDir);
        GridPosition candidatePosition = GridPosition.add(
                gridPosition, offset.x(), offset.y());
        if (ground.isPositionOutOfBounds(candidatePosition)) {
            gridPosition = ground.midpoint().copy();
        } else {
            gridPosition = candidatePosition;
        }
    }
}
