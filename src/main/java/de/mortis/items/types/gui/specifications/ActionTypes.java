package de.mortis.items.types.gui.specifications;

public enum ActionTypes {
    OPEN_INVENTORY {
        @Override
        public void onTrigger() {

        }
    };

    public abstract void onTrigger();
}
