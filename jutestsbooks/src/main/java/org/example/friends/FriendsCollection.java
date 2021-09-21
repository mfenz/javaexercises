package org.example.friends;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

public class FriendsCollection {
    private MongoCollection friends;

    public FriendsCollection() {
        DB db = new MongoClient().getDB("friendships");
        friends = new Jongo(db).getCollection("friends");
    }

    public Person findByName(String name) {
        return friends.findOne("{_id: #}", name).as(Person.class);
    }

    public void save(Person p) {
        friends.save(p);
    }
}
