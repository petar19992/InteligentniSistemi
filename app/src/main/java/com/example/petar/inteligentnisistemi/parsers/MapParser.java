package com.example.petar.inteligentnisistemi.parsers;

import android.content.Context;
import android.provider.SyncStateContract;

import com.example.petar.inteligentnisistemi.helpers.Constants;

import org.w3c.dom.Node;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;

/**
 * Created by PETAR on 10/19/2016.
 */

public class MapParser
{

    public void main(Context context) throws XmlPullParserException, IOException
    {
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        factory.setNamespaceAware(true);
        XmlPullParser xpp = factory.newPullParser();

        InputStream is = context.getAssets().open("map.xml");
        BufferedReader r = new BufferedReader(new InputStreamReader(is));
        /*StringBuilder total = new StringBuilder();
        String line;
        while ((line = r.readLine()) != null) {
            total.append(line).append('\n');
        }*/
        xpp.setInput(r);
        int eventType = xpp.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT)
        {
            if (eventType == XmlPullParser.START_DOCUMENT)
            {
                System.out.println("Start document");
            } else if (eventType == XmlPullParser.START_TAG)
            {
                startTag(xpp);
//                System.out.println("Start tag "+xpp.getName());
            } else if (eventType == XmlPullParser.END_TAG)
            {
                endTag(xpp);
//                System.out.println("End tag " + xpp.getName());
            } else if (eventType == XmlPullParser.TEXT)
            {
                System.out.println("Text " + xpp.getText());
            }
            eventType = xpp.next();
        }
        System.out.println("End document");
    }

    com.example.petar.inteligentnisistemi.models.Node tmpNode;

    public void startTag(XmlPullParser xpp) throws IOException, XmlPullParserException
    {
        String name = xpp.getName();
        if (name.equals("node"))
        {
            tmpNode = new com.example.petar.inteligentnisistemi.models.Node();
            tmpNode.setId(Integer.valueOf(xpp.getAttributeValue(0)));
            tmpNode.setName(xpp.getAttributeValue(1));
        } else if (name.equals("x"))
        {
            xpp.next();
            /*if (tmpNode != null)
            {
                tmpNode.setxCoordinate((int) (Float.parseFloat(xpp.getText())));
            }*/
        }else if (name.equals("y"))
        {
            xpp.next();
            /*if (tmpNode != null)
            {
                tmpNode.setyCoordinate((int) Float.parseFloat(xpp.getText()));
            }*/
        }else if (name.equals("nodeId"))
        {
            xpp.next();
            if (tmpNode != null)
            {
//                tmpNode.tmpEdges.add(Integer.parseInt(xpp.getText()));
            }
        }
    }

    public void endTag(XmlPullParser xpp)
    {
        String name = xpp.getName();
        if (name.equals("node"))
        {
            if(tmpNode!=null)
                Constants.getInstance().map.nodes.add(tmpNode);
        }
    }
}
