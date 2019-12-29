package com.blendworks.tony.aoe2_helper
import android.content.res.XmlResourceParser
import org.xmlpull.v1.XmlPullParserException
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.io.IOException
import java.io.InputStream

class ParseCivInfo {

    private val parsedCivs = ArrayList<ParsedCivs>()
    private var parsedCiv: ParsedCivs? = null
    private var text: String? = null

    fun parse(inputStream: XmlResourceParser): List<ParsedCivs> {



        //XmlResourceParser xpp = res.getXml(R.xml.myxml);
        //xpp.next();
        //int eventType = xpp.getEventType();
        //while (eventType != XmlPullParser.END_DOCUMENT)

        //inputStream.next()




        try {
            //val factory = XmlPullParserFactory.newInstance()
            //factory.isNamespaceAware = true

            //val parser = factory.newPullParser()
            //parser.setInput(inputStream, null)

            //var eventType = parser.eventType
            var eventType = inputStream.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {
                val tagname = inputStream.name
                when (eventType) {
                    XmlPullParser.START_TAG -> if (tagname.equals("Civ", ignoreCase = true)) {
                        // create a new instance of employee
                        parsedCiv = ParsedCivs()
                    }
                    XmlPullParser.TEXT -> text = inputStream.text
                    XmlPullParser.END_TAG -> if (tagname.equals("Civ", ignoreCase = true)) {
                        // add employee object to list
                        parsedCiv?.let { parsedCivs.add(it) }
                    } else if (tagname.equals("id", ignoreCase = true)) {
                        parsedCiv!!.id = Integer.parseInt(text)
                    } else if (tagname.equals("name", ignoreCase = true)) {
                        parsedCiv!!.name = text
                    } else if (tagname.equals("UU", ignoreCase = true)) {
                        parsedCiv!!.UU = text
                    }else if (tagname.equals("TeamBonus", ignoreCase = true)) {
                        parsedCiv!!.TeamBonus = text
                    }else if (tagname.equals("CivBonus", ignoreCase = true)) {
                        parsedCiv!!.CivBonus = text
                    }else if (tagname.equals("Focus", ignoreCase = true)) {
                        parsedCiv!!.Focus = text
                    }else if (tagname.equals("CUT", ignoreCase = true)) {
                        parsedCiv!!.CUT = text
                    }else if (tagname.equals("IUT", ignoreCase = true)) {
                        parsedCiv!!.IUT = text
                    }else if (tagname.equals("Missing", ignoreCase = true)) {
                        parsedCiv!!.Missing = text
                    }
                    else -> {
                    }
                }
                eventType = inputStream.next()
            }
        } catch (e: XmlPullParserException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return parsedCivs
    }
}