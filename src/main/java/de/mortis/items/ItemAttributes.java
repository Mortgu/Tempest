package de.mortis.items;

import de.mortis.items.weapons.WeaponAttributes;
import de.mortis.items.wearables.WearableAttributes;
import lombok.Getter;

@Getter
public class ItemAttributes {

    private WeaponAttributes weaponAttributes;
    private WearableAttributes wearableAttributes;
    private int value, modifier;

    public ItemAttributes(WeaponAttributes weaponAttributes, int value) {
        this.weaponAttributes = weaponAttributes;
        this.value = value;
        this.modifier = 0;
    }

    public ItemAttributes(WeaponAttributes weaponAttributes, int value, int modifier) {
        this.weaponAttributes = weaponAttributes;
        this.value = value;
        this.modifier = modifier;
    }

    public ItemAttributes(WearableAttributes wearableAttributes, int value) {
        this.wearableAttributes = wearableAttributes;
        this.value = value;
        this.modifier = 0;
    }

    public ItemAttributes(WearableAttributes wearableAttributes, int value, int modifier) {
        this.wearableAttributes = wearableAttributes;
        this.value = value;
        this.modifier = modifier;
    }
}
