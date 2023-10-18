package de.mortis.systems.gis.types;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.inventory.ItemStack;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
public class AttributeInformation<T, Z> implements Serializable {

    private static final long serialVersionUID = 1L;

    private ItemAttributeTypes itemAttributeType;
    private int attributeValue;

    public AttributeInformation(ItemAttributeTypes itemAttributeType, int attributeValue) {
        this.itemAttributeType = itemAttributeType;
        this.attributeValue = attributeValue;
    }
}
