package de.mortis.items;

import de.mortis.items.types.OriginTypes;
import de.mortis.items.types.gui.GuiTypes;
import de.mortis.items.types.item.ItemTypes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TempestPluginInfo {
    OriginTypes originType();
    ItemTypes itemType() default ItemTypes.NULL;
    GuiTypes guiTypes() default GuiTypes.NULL;
}
