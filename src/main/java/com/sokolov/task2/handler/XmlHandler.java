package com.sokolov.task2.handler;

import com.sokolov.task2.builder.PostcardBuilderManager;
import com.sokolov.task2.builder.RegularPostcardBuilder;
import com.sokolov.task2.entity.RegularPostcard;
import com.sokolov.task2.entity.type.PostcardType;
import com.sokolov.task2.exception.XmlParserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.IntStream;

public class XmlHandler extends DefaultHandler {
    private static final Logger logger = LogManager.getLogger();

    private final List<RegularPostcard> listOfPostcards;
    private RegularPostcardBuilder postcardBuilder;
    private boolean isPostcard;
    private PostcardType postcardType;
    private String currentElementContent;

    public XmlHandler() {
        listOfPostcards = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        try {
            if(postcardType.toString().equals(qName)) {
                isPostcard = true;

                String changeQname = qName.toUpperCase().replace("-","_");
                postcardType = PostcardType.valueOf(changeQname);

                PostcardBuilderManager postcardBuilderManager = new PostcardBuilderManager();
                postcardBuilder = postcardBuilderManager.createPostcard(postcardType);

                if(postcardBuilder != null) {
                    IntStream.range(0, attributes.getLength())
                            .forEach(i -> postcardBuilder.addAttributes(attributes.getValue(i)));
                }
            }
        } catch (XmlParserException e) {
            e.printStackTrace();
            isPostcard = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (isPostcard) {
            postcardBuilder.addElements(currentElementContent);
        }
        if (isPostcard && postcardType.toString().equals(qName.toString().replaceAll("-" , "_"))) {
            RegularPostcard currentPostcard = postcardBuilder.createRegularPostcard();
            listOfPostcards.add(currentPostcard);

            postcardType = null;
            isPostcard = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        currentElementContent = new String(ch, start, length);
    }

    public List<RegularPostcard> getListOfPostcards() {
        return listOfPostcards;
    }
}
