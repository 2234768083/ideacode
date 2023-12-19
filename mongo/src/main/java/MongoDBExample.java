import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDBExample {
    public static void main(String[] args) {
        // MongoDB连接字符串
        String connectionString = "mongodb://localhost:27017";
        MongoClientURI uri = new MongoClientURI(connectionString);

        // 连接到MongoDB服务器
        MongoClient mongoClient = new MongoClient(uri);

        // 连接到数据库
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = database.getCollection("goodsinf");

        // 调用queryAll函数查询所有数据
        queryAll(collection);

        // 删除item值为“初中生教材”的数据
        deleteDocument(collection, "yzyitem", "初中生教材");

        // 再次调用queryAll函数显示操作后的数据
        queryAll(collection);

        // 关闭MongoDB客户端连接
        mongoClient.close();
    }

    // 查询并输出所有数据
    public static void queryAll(MongoCollection<Document> collection) {
        MongoCursor<Document> cursor = collection.find().iterator();
        try {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                System.out.println(doc.toJson());
            }
        } finally {
            cursor.close();
        }
    }

    // 删除匹配字段的文档
    public static void deleteDocument(MongoCollection<Document> collection, String field, String value) {
        Document query = new Document(field, value);
        collection.deleteMany(query);
        System.out.println("Deleted documents with " + field + " = " + value);
    }
}
