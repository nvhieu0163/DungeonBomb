package model.entity.item;

import model.entity.Dynamic;
import model.entity.Entity;

import static controller.ItemsController.LIST_INTERFACES_CLIP;
import static controller.ItemsController.getRandomInterfaces;

public class Interface extends Entity implements Dynamic {
    private final int UPDATE_RATE = 15;
    private final boolean hasItem;
    private final boolean destroyable;
    private final int typeOfInterface;

    private final int clipFrames;
    private int activeFrame;
    private int clipCounter;
    private final Integer[] clip;

    /**
     * Constructor for Interface destroyable
     */
    public Interface(int x, int y, boolean hasItem) {
        super(x, y);
        this.typeOfInterface = getRandomInterfaces();
        this.hasItem = hasItem;
        this.destroyable = true;

        this.clip = LIST_INTERFACES_CLIP.get(typeOfInterface).getValue();
        this.clipFrames = clip.length;
        this.activeFrame = 0;
        this.clipCounter = 0;
        this.imageID = clip[0];


    }

    /**
     * Constructor for Interface Un_destroyable
     */
    public Interface(int x, int y, int numberOfInterface) {
        super(x, y);
        this.typeOfInterface = numberOfInterface;
        this.clip = LIST_INTERFACES_CLIP.get(numberOfInterface).getValue();
        this.clipFrames = clip.length;
        this.activeFrame = 0;
        this.clipCounter = 0;
        this.imageID = clip[0];

        this.hasItem = false;
        this.destroyable = false;
    }

//    public static void main(String[] args) {
//        Interface test = new Interface(64, 64, 11);
//        test.getClip();
//    }
//
//    public void getClip() {
//        for (int i = 0; i < clip.length; i++) {
//            System.out.println(clip[i] + " ");
//        }
//    }

    public int getTypeOfInterface() {
        return typeOfInterface;
    }

    public boolean isDestroyable() {
        return destroyable;
    }

    public boolean isHasItem() {
        return hasItem;
    }

//    public Interface getInterfaceByType(int typeOfInterface) {
//        return new Interface(x, y, typeOfInterface);
//    }

    @Override
    public void update() {
        clipCounter = (clipCounter + 1) % UPDATE_RATE;
        if (clipCounter == 0) {
            activeFrame = (activeFrame + 1) % clipFrames;
            imageID = clip[activeFrame];
        }
    }
}
