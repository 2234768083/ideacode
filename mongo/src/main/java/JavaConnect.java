import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class JavaConnect {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        // 建立连接
        MongoClient mg = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));

        // 访问words数据库
        MongoDatabase db = mg.getDatabase("words");

        // 访问word_stats集合
        MongoCollection<Document> collection = db.getCollection("word_stats");

        // 访问word_stats集合中前10条数据
        FindIterable<Document> findIter = collection.find().limit(10);

        // 利用过滤器返回游标对象
        MongoCursor<Document> cur = findIter.iterator();

        // 输出集合中共有多少个文档
        System.out.println("该单词库中共有：" + collection.getDocumentClass() + "个单词。");

        System.out.println("前10个单词列表：");

        // 利用游标循环输出前10个文档的"word"字段
        while (cur.hasNext()) {
            Document doc = cur.next();
            System.out.println(doc.getString("word"));
        }

        mg.close();
    }
}
