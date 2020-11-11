package uet.oop.bomberman.entities;

import uet.oop.bomberman.graphics.Screen;
import uet.oop.bomberman.graphics.Sprite;

import java.util.LinkedList;

public class LayerEntity extends Entity {

    protected LinkedList<Entity> entities = new LinkedList<>();

    public LayerEntity(int x, int y, Entity ... entities) {
        this.x = x;
        this.y = y;

        for (int i = 0; i < entities.length; i++) {
            this.entities.add(entities[i]);

//            if(i > 1) { //Add to destroyable tiles the bellow sprite for rendering in explosion
//                if(entities[i] instanceof DestroyableTile)
//                    ((DestroyableTile)entities[i]).addBelowSprite(entities[i-1].getSprite());
//            }
        }
    }

    @Override
    public void update() {
        clearRemoved();
        getTopEntity().update();
    }

    @Override
    public void render(Screen screen) {
        getTopEntity().render(screen);
    }

    @Override
    public boolean checkcollision(Entity e) {
        return getTopEntity().checkcollision(e);
    }

    public Entity getTopEntity() {

        return entities.getLast();
    }

    private void clearRemoved() {
        Entity top  = getTopEntity();

        if(top.isRemoved())  {
            entities.removeLast();
        }
    }

    public void addBeforeTop(Entity e) {
        entities.add(entities.size() - 1, e);
    }

}
