package model.entity.character;

import static controller.EnemyController.SPEED_SKELETON;
import static model.GameConfig.RANDOM;

public class Enemy extends Character {
    protected final int visible;
    protected final boolean randomOblique;
    protected final boolean randomEveryDirection;
//    protected boolean moveAI;

    public Enemy(int x, int y, Integer[] clip, int speedX, int speedY, int visible, boolean randomOblique, boolean r_E_D) {
        super(x, y, clip, speedX, speedY);
        this.visible = visible;
        this.randomOblique = randomOblique;
        this.randomEveryDirection = r_E_D;
    }

    public void turnAround() {
        speedX = -speedX;
        speedY = -speedY;
    }

    public void randomVerticalHorizontal() {
        if (visible == 2) {
            double rand2 = RANDOM.nextDouble();
            if (speedX == 0) {
                speedY = 0;
                speedX = (rand2 > 0.5) ? SPEED_SKELETON : -SPEED_SKELETON;
            } else {
                speedX = 0;
                speedY = (rand2 > 0.5) ? SPEED_SKELETON : -SPEED_SKELETON;
            }
        }
    }

    public void randomOblique() {
        if (randomOblique) {
            double rand2 = RANDOM.nextDouble();
            if (rand2 < 0.3) {
                speedX = -speedX;
                speedY = -speedY;
            }
            if (rand2 > 0.3 && rand2 < 0.7) {
                speedY = -speedY;
            } else {
                speedX = -speedX;
            }
        }
    }

    public void randomEveryDirection() {
        if (randomEveryDirection) {
            double rand = RANDOM.nextDouble();
            int rand2 = RANDOM.nextInt(11) - 5;
            if (rand < 0.25) {
                speedX = rand2;
//                System.out.println(speedX + " " + speedY);
            }
            if (rand > 0.25 && rand < 0.5) {
                speedY = rand2;
//                System.out.println(speedX + " " + speedY);
            }
            if (rand > 0.5) {
                speedX = rand2;
                speedY = rand2;
//                System.out.println(speedX + " " + speedY);
            }
            if (speedX == speedY) {
                randomEveryDirection();
            }
        }
    }

    public int getVisible() {
        return visible;
    }

    public boolean isRandomOblique() {
        return randomOblique;
    }

    public boolean isRandomEveryDirection() {
        return randomEveryDirection;
    }

}
