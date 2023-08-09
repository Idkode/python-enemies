package model;

import resources.Settings;
import resources.Utils;

import java.util.List;

public class Fruit extends Physical {
    public static final int SIZE = (35 * Settings.GRID_UNIT_SIZE /30);

    public enum Type {
        NORMAL(1), GOLDEN(10);
        final int score;
        private Type(int score) { this.score = score; }
    }

    private final Type type;

    public Fruit(int gridX, int gridY, Type type) {
        super(gridX * Settings.GRID_UNIT_SIZE, gridY * Settings.GRID_UNIT_SIZE);
        this.type = type;
        this.width = SIZE;
        this.height = SIZE;
    }

    public Type getType() { return type; }

    public int getScore() { return getType().score; }

    @Override
    public void onCollision(Physical object) {
        if (object.getClass() == Snake.class) {
            this.removeFromGame();
            Game.generateFruits(1);
        }
    }

    @Override
    public void checkCollision(List<Physical> objects) {
//        for (Physical object : objects) {
//            if (object.getClass() == Snake.class) {
//                checkSnakeCollision((Snake)object);
//            }
//        }
    }

    public boolean invalidPosition(int x, int y, List<Physical> objects){
        boolean a = false, b = false, c = false;
        for (Physical object : objects) {
            if (object.getClass() == Snake.class) {
                a = checkSnakeCollision(x, y,(Snake)object);
            } else if (object.getClass() == Block.class) {
                b = checkBlockCollision(x, y,(Block)object);
            }
            else{
                c = checkFruitCollision(x, y,(Fruit) object);
            }
            if(a || b || c) return true;
        }
        return false;
//        return (this.x < Settings.GRID_UNIT_SIZE || this.x >= (Settings.GRID_WIDTH - 1) * Settings.GRID_UNIT_SIZE ||
//                this.y < Settings.GRID_UNIT_SIZE || this.y >= (Settings.GRID_HEIGHT - 1) * Settings.GRID_UNIT_SIZE);
    }

    private boolean checkSnakeCollision(int x, int y, Snake snake){
        int lastPosX = snake.firstSegmentPositionX;
        int lastPosY = snake.firstSegmentPositionY;
        int newPosX;
        int newPosY;

        int numberOfSegments = snake.bodySegments.size() - 1;
        int num = -1;

        for (Snake.BodySegment bodySegment : snake.bodySegments) {
            num++;

            newPosX = Utils.incrementValueByDirection(
                    bodySegment.getDirection(), Settings.Direction.LEFT, lastPosX, bodySegment.length);
            newPosY = Utils.incrementValueByDirection(
                    bodySegment.getDirection(), Settings.Direction.UP, lastPosY, bodySegment.length);

            if (
                    Utils.checkCollision(
                            x, y,
                            lastPosX, lastPosY,
                            newPosX, newPosY
                    ) && (numberOfSegments - 1) > num) {
                return true;
            }

            lastPosX = newPosX;
            lastPosY = newPosY;
        }
        return false;
    }

    private boolean checkBlockCollision(int x, int y, Block block){
        return x == (int) block.x && y == (int) block.y;
    }
    private boolean checkFruitCollision(int x, int y, Fruit fruit){
        return x == (int) fruit.x && y == (int) fruit.y;
    }
}
