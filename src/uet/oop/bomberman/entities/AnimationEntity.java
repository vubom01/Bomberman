package uet.oop.bomberman.entities;

public abstract class AnimationEntity extends Entity {
    public int animation = 0;

    public void setAnimation() {
        if (animation < 7500) animation++;
        else animation = 0;
    }
}
