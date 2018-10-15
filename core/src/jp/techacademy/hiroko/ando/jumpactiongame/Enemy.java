package jp.techacademy.hiroko.ando.jumpactiongame;

import com.badlogic.gdx.graphics.Texture;

public class Enemy extends GameObject {
    // 横幅、高さ
    public static final float Enemy_WIDTH = 1.0f;
    public static final float Enemy_HEIGHT = 1.0f;

    //早さ
    public static final float Enemy_MOVE_VELOCITY = 3.0f;
    public static final float EnemyDown_MOVE_VELOCITY = -1.0f;

    public static final int Enemy_STATE_NOMAL = 0;
    public static final int Enemy_STATE_VANISH = 1;

    int mState;

    public Enemy(Texture texture, int srcX, int srcY, int srcWidth, int srcHeight) {
        super(texture, srcX, srcY, srcWidth, srcHeight);
        setSize(Enemy_WIDTH, Enemy_HEIGHT);
        velocity.x = Enemy_MOVE_VELOCITY;
        velocity.y = EnemyDown_MOVE_VELOCITY;
        mState = Enemy_STATE_NOMAL;
    }
    public void update(float delta){
        setX(getX() + velocity.x * delta);
        setY(getY() + velocity.y * delta);

        if (getX() < Enemy_WIDTH / 2) {
            velocity.x = -velocity.x;
            setX(Enemy_WIDTH / 2);
        }
        if (getX() > GameScreen.WORLD_WIDTH - Enemy_WIDTH / 2) {
            velocity.x = -velocity.x;
            setX(GameScreen.WORLD_WIDTH - Enemy_WIDTH / 2);
        }

    }

    public void vanish() {
        mState = Enemy_STATE_VANISH;
        setAlpha(0);
        velocity.x = 0;
        velocity.y = 0;
    }
}
