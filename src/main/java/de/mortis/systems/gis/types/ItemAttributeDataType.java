package de.mortis.systems.gis.types;

import org.apache.commons.lang3.SerializationUtils;
import org.bukkit.persistence.PersistentDataAdapterContext;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import java.io.*;

public class ItemAttributeDataType implements PersistentDataType<byte[], AttributeInformation> {

    @Override
    public @NotNull Class<AttributeInformation> getComplexType() {
        return AttributeInformation.class;
    }

    @Override
    public @NotNull Class<byte[]> getPrimitiveType() {
        return byte[].class;
    }

    @Override
    public byte @NotNull [] toPrimitive(@NotNull AttributeInformation attributeInformation, @NotNull PersistentDataAdapterContext persistentDataAdapterContext) {
        return SerializationUtils.serialize(attributeInformation);
    }

    @Override
    public @NotNull AttributeInformation fromPrimitive(byte @NotNull [] bytes, @NotNull PersistentDataAdapterContext persistentDataAdapterContext) {
        InputStream inputStream = new ByteArrayInputStream(bytes);
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            return (AttributeInformation) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
