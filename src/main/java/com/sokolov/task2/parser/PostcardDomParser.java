package com.sokolov.task2.parser;

import com.sokolov.task2.builder.PostcardBuilderManager;
import com.sokolov.task2.builder.RegularPostcardBuilder;
import com.sokolov.task2.entity.RegularPostcard;
import com.sokolov.task2.entity.type.PostcardType;
import com.sokolov.task2.exception.XmlParserException;
import com.sokolov.task2.validator.XmlValidator;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PostcardDomParser {
    private PostcardType postcardType;
    private RegularPostcardBuilder postcardBuilder;
    private List<RegularPostcard> listOfPostcards;

    public PostcardDomParser() {
        listOfPostcards = new ArrayList<>();
    }

    public void createListOfPostcards(String path) throws XmlParserException {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            File file = new File(ClassLoader.getSystemResource(path).getPath());
            Document document = builder.parse(file);
            Element element = document.getDocumentElement();
            NodeList nodeList = element.getChildNodes();

            for(int i = 0; i < nodeList.getLength(); i++) {
                if(nodeList.item(i).getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }

                Node elementNode = nodeList.item(i);

                String currentNode = elementNode.getNodeName();

                if(postcardType.toString().equals(currentNode)) {
                    PostcardBuilderManager builderManager = new PostcardBuilderManager();
                    postcardBuilder = builderManager.createPostcard(currentNode.toUpperCase().replaceAll("-","_"));
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    public List<RegularPostcard> getListOfPostcards() {
        return listOfPostcards;
    }

    private void setInfo(Node currentNode) {

        NamedNodeMap attributeMap = currentNode.getAttributes();
        for (int i = 0; i < attributeMap.getLength(); i++) {
            Node attribute = attributeMap.item(i);
            postcardBuilder.addAttributes(attribute.getTextContent());
        }

        NodeList childElements = currentNode.getChildNodes();
        for (int i = 0; i < childElements.getLength(); i++) {
            if (childElements.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            Node currentElement = childElements.item(i);
            postcardBuilder.addElements(currentElement.getTextContent());
        }
        listOfPostcards.add(postcardBuilder.createRegularPostcard());
    }

}
