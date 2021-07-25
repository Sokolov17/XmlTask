package com.sokolov.task2.builder;

import com.sokolov.task2.entity.RegularPostcard;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class RegularPostcardBuilder {
    private static final Logger logger = LogManager.getLogger();

    protected List<String> elements;
    protected List<String> attributes;

    public RegularPostcardBuilder() {
        this.elements = new ArrayList<>();
        this.attributes = new ArrayList<>();
    }

    public void addAttributes(String attribute) {
        attributes.add(attribute);
    }

    public void addElements(String element) {
        elements.add(element);
    }

    public RegularPostcard createRegularPostcard() {
        RegularPostcard postcard;

        if(attributes.size() == 1) {
            postcard = new RegularPostcard(attributes.get(0), elements.get(0), elements.get(1), LocalDate.parse(elements.get(2)), Boolean.parseBoolean(elements.get(3)), elements.get(4));
        } else {
            postcard = new RegularPostcard(attributes.get(0), attributes.get(1), elements.get(0), elements.get(1), LocalDate.parse(elements.get(2)), Boolean.parseBoolean(elements.get(3)), elements.get(4));
        }

        logger.info("RegularPostcard create: "+ postcard.toString()); //// TODO: 19.07.2021
        return postcard;
    }
}
