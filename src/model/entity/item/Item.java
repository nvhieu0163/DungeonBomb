package model.entity.item;

import model.entity.Dynamic;
import model.entity.Entity;

import static controller.ItemsController.LIST_ITEMS_CLIP;

public class Item extends Entity implements Dynamic {
    private final int UPDATE_RATE = 15;
    private final int typeOfItem;

    private final int clipFrames;
    private int activeFrame;
    private int clipCounter;
    private final Integer[] clip;

    public Item(int x, int y, int numberOfItems) {
        super(x, y);
        this.clip = LIST_ITEMS_CLIP.get(numberOfItems).getValue();
        this.clipFrames = clip.length;
        this.activeFrame = 0;
        this.clipCounter = 0;
        this.imageID = clip[0];

        this.typeOfItem = numberOfItems;
    }

//    public static void main(String[] args) {
//        Integer[] n = LIST_ITEMS_CLIP.get(0).getValue();
//        for (int i =0; i < n.length; i++) {
//            System.out.println(n[i]);
//        }
//    }

    public int getTypeOfItem() {
        return typeOfItem;
    }

    @Override
    public void update() {
        clipCounter = (clipCounter + 1) % UPDATE_RATE;
        if (clipCounter == 0) {
            activeFrame = (activeFrame + 1) % clipFrames;
            imageID = clip[activeFrame];
        }
    }
}
