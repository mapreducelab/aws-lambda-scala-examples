package example

import java.io.File
import java.sql.{Array=>SQLArray, _}
import scala.collection.JavaConverters._

import com.typesafe.scalalogging._

import scala.util.Try

object Main extends LazyLogging {
  import java.io.{InputStream, OutputStream}

  val dbDriver = "org.postgresql.Driver"
  val dbSchema = "cyberdb"
  val dbPort = 5432
  val dbUsr = "cyberioni"
  val dbPwd = "Aladin2017"
  val dbHost = "cyberdb.czfe7kky88c3.us-east-1.rds.amazonaws.com"
  val DefaultSqlQuery = s"""SELECT
                           |  phrase
                           |FROM
                           |  phrases
                           |""".stripMargin.replaceAll("\n", " ")
  def dbUrl = s"jdbc:postgresql://$dbHost:$dbPort/$dbSchema"

  def main (args: Array[String] ): Unit = {
    val result = getHelloWorld(dbUrl, dbUsr, dbPwd, DefaultSqlQuery, dbDriver).mkString(",")
    logger.info(result)
  }


  def greeting(input: InputStream, output: OutputStream): Unit = {
    val result = getHelloWorld(dbUrl, dbUsr, dbPwd, DefaultSqlQuery, dbDriver).mkString(",")
    output.write(result.getBytes("UTF-8"))
  }


  // postgres https://jdbc.postgresql.org/documentation/head/connect.html
  //https://www.plotprojects.com/blog/why-we-use-postgresql-and-slick/
  //slick monad like example https://blog.scalac.io/2015/07/09/slick-3-overview.html
  // Unit tests https://www.superloopy.io/articles/2013/scala-slick-postgresql-unit-tests.html
  // discussion of slick https://users.scala-lang.org/t/using-slick-3-2-0-provides-classic-example-of-why-implicit-drives-people-out-of-scala/297/21


  def getHelloWorld (url: String, username: String, password: String, sqlQuery: String, driver: String): List[Phrases] = {
    logger.info(s"getHelloWorld from $url")
    Class.forName(driver)
    val connection = DriverManager.getConnection(url, username, password)
    run(connection, sqlQuery) { rs =>
      Phrases(Try(rs.getString("phrase")).getOrElse(""))
    }
  }

  // def slickCreateDatabase(db_name: String) = ???


  // anorm simple SQL data access https://www.playframework.com/documentation/2.6.x/ScalaAnorm
}
