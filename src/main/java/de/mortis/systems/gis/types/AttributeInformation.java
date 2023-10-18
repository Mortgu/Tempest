package de.mortis.systems.gis.types;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttributeInformation {

    private ItemAttributeTypes itemAttributeType;
    private int attributeValue;

    public AttributeInformation(ItemAttributeTypes itemAttributeType, int attributeValue) {
        this.itemAttributeType = itemAttributeType;
        this.attributeValue = attributeValue;
    }
}
