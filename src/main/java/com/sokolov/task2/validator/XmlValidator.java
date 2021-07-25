package com.sokolov.task2.validator;

import com.sokolov.task2.exception.XmlParserException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XmlValidator {
    private static final Logger logger = LogManager.getLogger();

    public static boolean validateXml(String xmlPath, String xsdPath) throws XmlParserException {
        boolean result = false;
        SchemaFactory schemaFactory = SchemaFactory.newDefaultInstance();
        Schema schema;
        try {
            schema = schemaFactory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
            result = true;
        } catch (SAXException e) {
            throw new XmlParserException("XSD Scheme is not valid", e);
        } catch (IOException e) {
            throw new XmlParserException("XML File is not valid", e);
        }
        return result;
    }
}
