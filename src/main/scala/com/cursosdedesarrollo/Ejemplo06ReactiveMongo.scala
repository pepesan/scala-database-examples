package com.cursosdedesarrollo



import scala.util.{Failure, Success, Try}
import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import reactivemongo.api.{DefaultDB, MongoConnection}
import reactivemongo.bson.BSONDocument
import reactivemongo.api.commands.{MultiBulkWriteResult, WriteResult}
import reactivemongo.api.collections.bson.BSONCollection

import scala.concurrent.duration.Duration

object Ejemplo06ReactiveMongo {
  def main(args: Array[String]): Unit = {
    /*
    def dbFromConnection(connection: MongoConnection): Future[BSONCollection] =
      connection.database("mydb").
        map(_.collection("mycoll"))



    // Simple: .insert.one(t)
    def simpleInsert(coll: BSONCollection,document:BSONDocument): Future[Unit] = {
      val writeRes: Future[WriteResult] = coll.insert(document)

      writeRes.onComplete { // Dummy callbacks
        case Failure(e) => e.printStackTrace()
        case Success(writeResult) =>
          println(s"successfully inserted document with result: $writeResult")
      }

      writeRes.map(_ => {}) // in this example, do nothing with the success
    }

    // Bulk: .insert.many(Seq(t1, t2, ..., tN))
    def bulkInsert(coll: BSONCollection,document: BSONDocument): Future[Unit] = {
      val writeRes: Future[MultiBulkWriteResult] =
        coll.insert(ordered = false).many(Seq(
          document, BSONDocument(
            "firstName" -> "Foo",
            "lastName" -> "Bar",
            "age" -> 1)))

      writeRes.onComplete { // Dummy callbacks
        case Failure(e) => e.printStackTrace()
        case Success(writeResult) =>
          println(s"successfully inserted document with result: $writeResult")
      }

      writeRes.map(_ => {}) // in this example, do nothing with the success
    }
    */
    //Conexión normal
    val driver1 = new reactivemongo.api.MongoDriver
    val connection3: MongoConnection = driver1.connection(List("localhost"))
    connection3.database("test").map( (db: DefaultDB) =>{
      val collection: BSONCollection = db.collection("test")
      val inserted=collection.insert(BSONDocument(
        "firstName" -> "Foo",
        "lastName" -> "Bar",
        "age" -> 1))
      Await.result(inserted,Duration(10, "s"))
      val listed=collection.find(BSONDocument()).one[BSONDocument]
      println(listed)
    })


    /*
    val futureColl=dbFromConnection(connection3)

    simpleInsert(futureColl.,BSONDocument(
      "firstName" -> "Foo",
      "lastName" -> "Bar",
      "age" -> 1))

    val mongoUri = "mongodb://localhost:27017/test"

    val driver = new MongoDriver

    val database = for {
      uri <- Future.fromTry(MongoConnection.parseURI(mongoUri))
      con = driver.connection(uri)
      dn <- Future(uri.db.get)
      db <- con.database(dn)
    } yield db

    database.onComplete {
      case resolution =>
        println(s"DB resolution: $resolution")
        resolution.
        driver.close()
    }
    */
  }

}
