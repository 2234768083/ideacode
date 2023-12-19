import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class MongoDb {
    // 1.定义MongoDb的数据库连接对象
    static MongoClient connection = null;
    // 2.定义数据库对象
    static MongoDatabase db = null;

    /**
     * 3.构造函数，用于建立和数据库的连接
     *
     * @param dbName 连接数据库名称
     */
    public MongoDb(String dbName) {
        connection = new MongoClient("127.0.0.1:27017");
        db = connection.getDatabase(dbName);
    }

    public static void main(String[] args) {
// TODO Auto-generated method stub
// 连接 test数据库
        MongoDb mongodb = new MongoDb("test");
/**
 * 1.创建一个名字叫mycollection的集合
 */
//    mongodb.createCollection("mycollection");
/**
 * 2.为集合mycollection添加一条数据
 */
//        Document doc = new Document();
//        doc.put("name", "zhangsan");
//        doc.put("age", 27);
//        List<String> books1 = new ArrayList<String>();
//        books1.add("c");
//        books1.add("java");
//        doc.put("books", books1);
//        mongodb.insert(doc, "mycollection");
/**
 * 3.批量插入数据
 */
//        List<Document> docs = new ArrayList<Document>();
//        Document jim = new Document("name", "jim");
//        jim.put("age", 18);
//        jim.put("m", 100);
//        Document lisi = new Document("name", "lisi");
//        lisi.put("country", "China");
//        docs.add(jim);
//        docs.add(lisi);
//        mongodb.insertBatch(docs, "mycollection");
/**
 * 4.根据ID删除数据
 */
//        int result = mongodb.deleteById("606b14d0ca7447295cc48d7b", "mycollection");
//        System.out.println("删除成功！");
/**
 * 5.根据条件删除数据
 */
//        Document lisi = new Document();
//        lisi.put("name", "lisi");
//        int count = mongodb.deleteByDocs(lisi, "mycollection");
//        System.out.println("删除条数：" + count);
/**
 * 6. 单条件更新数据
 */
//        Document updatedoc = new Document();
//        updatedoc.put("$set", new Document("email", "zs@126.com"));
//        Bson filter = Filters.eq("name", "zhangsan");
//        int count = mongodb.update(filter, updatedoc, "mycollection");
//        System.out.println("更新记录数：" + count);
/**
 * 7. 多条件更新数据
 */
//        Document updatedoc = new Document();
//        updatedoc.put("$set", new Document("age", 20));
//        Bson filters = Filters.and(Filters.eq("name", "zhangsan"), Filters.eq("email", "zs@126.com"));
//        int count = mongodb.update1(filters, updatedoc, "mycollection");
//        System.out.println("更新记录数：" + count);
/**
 * 8.查询出persons集合中name和age
 */
//        MongoCollection<Document> coll = db.getCollection("persons");
//        FindIterable<Document> iter = coll.find();
//        MongoCursor<Document> cursor = iter.iterator();
//        while (cursor.hasNext()) {
//            Document doc = cursor.next();
//            System.out.println(doc.get("name") + ">>" + doc.get("age"));
//        }
/**
 * 9.查询出年龄大于26岁并且英语成绩小于80分
 */
//        MongoCollection<Document> coll = db.getCollection("persons");
//        Bson filters = Filters.and(Filters.gte("age", 26), Filters.lte("e", 80));
//        FindIterable<Document> iter1 = coll.find(filters);
//        MongoCursor<Document> cursor1 = iter1.iterator();
//        while (cursor1.hasNext()) {
//            Document doc = cursor1.next();
//            System.out.println(doc.get("name") + ">>" + doc.get("age") + ">>" + doc.get("e"));
//        }
/**
 * 10.查询结果按年龄排序
 */
        MongoCollection<Document> coll2=db.getCollection("persons");
        FindIterable<Document> iter2=coll2.find().sort(new Document("age",-1));
        //FindIterable<Document> iter2=coll2.find().sort(new Document("age",-1)).skip(3).limit(3);
        MongoCursor<Document> cursor2=iter2.iterator();
        while(cursor2.hasNext()) {
            Document doc=cursor2.next();
        System.out.println(doc.get("name") + ">>" + doc.get("age") + ">>" + doc.get("country"));
        }
        connection.close();
    }


    public void createCollection(String collName) {
        db.createCollection(collName);
    }
    public void insert(Document doc, String collName) {
        MongoCollection<Document> coll = db.getCollection(collName);
        coll.insertOne(doc);
    }
    public void insertBatch(List<Document> docs, String collName) {
        MongoCollection<Document> coll = db.getCollection(collName);
        coll.insertMany(docs);
    }
    public int deleteById(String id, String collName) {
        MongoCollection<Document> coll = db.getCollection(collName);
        Document doc = new Document("_id", new ObjectId(id));
        int count = (int) coll.deleteOne(doc).getDeletedCount();
        return count;
    }
    public int deleteByDocs(Document doc, String collName) {
        MongoCollection<Document> coll = db.getCollection(collName);
        int count = (int) coll.deleteMany(doc).getDeletedCount();
        return count;
    }
    public int update(Bson find, Document updatedoc, String collName) {
        MongoCollection<Document> coll = db.getCollection(collName);
        int count = (int) coll.updateMany(find, updatedoc).getModifiedCount();
        FindIterable<Document> findIter = coll.find();
        MongoCursor<Document> mongocur = findIter.iterator();
        while (mongocur.hasNext()) {
            System.out.println(mongocur.next());
        }
        return count;
    }
    public int update1(Bson finds, Document updatedoc, String collName) {
        MongoCollection<Document> coll = db.getCollection(collName);
        int count = (int) coll.updateMany(finds, updatedoc).getModifiedCount();
        FindIterable<Document> findIter = coll.find();
        MongoCursor<Document> mongocur = findIter.iterator();
        while (mongocur.hasNext()) {
            System.out.println(mongocur.next());
        }
        return count;
    }
}