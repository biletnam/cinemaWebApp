package models;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: danfaulkner
 * Date: 29/04/2014
 * Time: 16:51
 * To change this template use File | Settings | File Templates.
 */
public class MongoDBManager {
//
//    public MongoDBManager(String collection) {
//        DB db = new MongoClient().getDB("cinema");
//
//        Jongo jongo = new Jongo(db);
//        MongoCollection
//
//    }
    public static void main (String[] args) throws UnknownHostException{
        DB db = new MongoClient().getDB("cinema");

        Jongo jongo = new Jongo(db);
        MongoCollection showings = jongo.getCollection("showings");

        List<String> allMovies = new ArrayList<String>();

        showings.find("{movie_title: 1}", allMovies);

        System.out.println(allMovies);


    }
}
