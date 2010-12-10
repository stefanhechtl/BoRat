package bgg

object BGGDataRetriever {
  import java.net.{URLConnection, URL}
  import scala.xml._ 

  def retrieveXML(url: String): Elem = {
    XML.load(new URL(url).openConnection.getInputStream)
  }

	
}