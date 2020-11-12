package uet.oop.bomberman.entities;

public abstract class AnimatedEntity extends Entity {

    public int _animate = 0;
    public final int MAX_ANIMATE = 7500; //save the animation status and dont let this get too big

    public void animate() {
        if(_animate < MAX_ANIMATE) _animate++; else _animate = 0; //reset animation
    }
}
