package example {
  case class Phrases (phrase: String)
}

package object example {
  import java.sql.{Array=>SQLArray, _}

  def by[Closeable <: {def close(): Unit}, B] (closeable: Closeable)(getB: Closeable => B): B =
    try {
      getB(closeable)
    } finally {
      closeable.close
    }

  def query[B](connection: Connection, sql: String)(process: ResultSet => B): B =
    by (connection) { connection =>
      by (connection.createStatement) { statement =>
        by (statement.executeQuery(sql)) { results =>
          process(results)
        }
      }
    }

  def collect[T](test: => Boolean)(block: => T): List[T] = {
    import scala.collection.mutable.ListBuffer
    val ret = new ListBuffer[T]
    while(test) ret += block
    ret.toList
  }

  def run[T](connection: Connection, sql: String)(process: ResultSet => T): List[T] =
    query(connection, sql) { results =>
      collect(results.next) {
        process(results)
      }
    }


}
