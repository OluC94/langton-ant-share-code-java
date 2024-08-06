package org.academy.langton;

import processing.core.PApplet;

public class TricolourAnt extends AntTemplate implements Ant {
    private Direction direction;


    //there's no real "color" type, it's just stored as an int
    private final int myColour;

    public TricolourAnt(PApplet p5, Ground ground, GridPosition startPos) {
        super(p5, ground, startPos);
        this.direction = Direction.random();
        this.myColour = p5.color(255, 255, 0);
    }

    @Override
    public void display() {
        p5.fill(myColour);
        Ground.drawSquareAtGridPosition(gridPosition, p5, ground.getCellSize());
        displayGridPositionAsText();
    }

    void displayGridPositionAsText() {
        p5.fill(0);
        p5.textSize(20);
        p5.text(gridPosition.toString(), 20, 50);
    }

    @Override
    public void update() {
        Cell currentCell = ground.cellAt(gridPosition);

        CellColour cellColour = currentCell.getStateColour();
        switch (cellColour) {
            case WHITE -> turnCounterclockwise();
            case BLACK -> turnClockwise();
            case RED -> { /* no turn */ }
        }
        //in all cases...
        currentCell.advanceStateColour();
        moveForward();
    }

    private void moveForward() {
        moveInDirection(direction);
    }

    private void turnClockwise() {
        direction = direction.nextClockwise();
    }

    private void turnCounterclockwise() {
        direction = direction.nextCounterClockwise();
    }
}