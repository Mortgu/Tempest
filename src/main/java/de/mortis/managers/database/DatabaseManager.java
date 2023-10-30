package de.mortis.managers.database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import de.mortis.Main;
import de.mortis.managers.PluginManager;
import de.mortis.player.TempestPlayer;
import lombok.Getter;
import org.bson.Document;

@Getter
public class DatabaseManager extends PluginManager {

    private final MongoClient mongoClient;
    private final MongoDatabase database;

    public DatabaseManager(Main plugin) {
        super(plugin);

        mongoClient = MongoClients.create("mongodb://localhost:27017");
        database = mongoClient.getDatabase("tempest");
    }

    public boolean registerTempestPlayer(TempestPlayer player) {
        return false;
    }

    public void saveTo() {
        MongoCollection<Document> collection = database.getCollection("");
    }
}
