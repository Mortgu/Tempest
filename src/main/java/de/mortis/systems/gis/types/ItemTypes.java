package de.mortis.systems.gis.types;

public enum ItemTypes {
    WEAPON() {
        @Override
        String getLoreString() {
            return "&6WEAPON";
        }
    },
    FARMING() {
        @Override
        String getLoreString() {
            return "&6FARMING";
        }
    },
    FISHING() {
        @Override
        String getLoreString() {
            return null;
        }
    },
    MINING() {
        @Override
        String getLoreString() {
            return null;
        }
    },
    BUILDING() {
        @Override
        String getLoreString() {
            return null;
        }
    };

    abstract String getLoreString();
}
