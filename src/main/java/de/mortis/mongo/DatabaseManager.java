package de.mortis.mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import de.mortis.Main;
import lombok.Getter;
import org.bson.Document;

@Getter
public class DatabaseManager {

    private final Main plugin = Main.getInstance();
    private final MongoClient mongoClient;
    private final MongoDatabase mongoDatabase;

    public DatabaseManager() {
        mongoClient = MongoClients.create("mongodb://localhost:27017");
        mongoDatabase = mongoClient.getDatabase("tempest");
    }

    public void insert(Document document, String collectionName) {
        MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
        collection.insertOne(document);
    }
}
