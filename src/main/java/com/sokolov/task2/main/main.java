package com.sokolov.task2.main;

import com.sokolov.task2.exception.XmlParserException;
import com.sokolov.task2.parser.PostcardDomParser;
import com.sokolov.task2.validator.XmlValidator;

public class main {
    public static void main(String[] args) {
        String xmlPath = ".//src//main//resources//files//OldCards.xml";
        String xsdPath = ".//src//main//resources//files//OldCards.xsd";
        try {
            XmlValidator.validateXml(xmlPath, xsdPath);

            PostcardDomParser domParser = new PostcardDomParser();
            domParser.createListOfPostcards(xmlPath);

            System.out.println("Dom parser result: " + domParser.getListOfPostcards().toString());
        } catch (XmlParserException e) {
            e.printStackTrace();
        }
    }
}
