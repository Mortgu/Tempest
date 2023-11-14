package de.mortis.player;

import de.mortis.Main;
import org.bson.Document;

public class PlayerLevelManager extends Document {

    private final Main plugin = Main.getInstance();
    public static final int MAX_PLAYER_LEVEL = 5;

    public PlayerLevelManager() {
        for (int i = 0; i < MAX_PLAYER_LEVEL; i++) {
            Document document = new Document();
            document.put("level", i);
            document.put("reward", "hier steht der Reward");

        }
    }
}
