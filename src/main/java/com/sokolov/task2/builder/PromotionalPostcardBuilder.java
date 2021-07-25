package com.sokolov.task2.builder;

import com.sokolov.task2.entity.PromotionalPostcard;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;

public class PromotionalPostcardBuilder extends RegularPostcardBuilder {
    private static final Logger logger = LogManager.getLogger();

    public PromotionalPostcardBuilder() {
        super();
    }

    public PromotionalPostcard createPromotionalPostcard() {
        PromotionalPostcard postcard;
        if(attributes.size() == 1) {
            postcard = new PromotionalPostcard(attributes.get(0), elements.get(0), elements.get(1), LocalDate.parse(elements.get(2)), Boolean.parseBoolean(elements.get(3)), elements.get(4), Integer.parseInt(elements.get(5)));
        } else {
            postcard = new PromotionalPostcard(attributes.get(0), attributes.get(1), elements.get(0), elements.get(1), LocalDate.parse(elements.get(2)), Boolean.parseBoolean(elements.get(3)), elements.get(4), Integer.parseInt(elements.get(5)));
        }
        logger.info("PromotionalPostcard create: " + postcard.toString());//// TODO: 19.07.2021
        return postcard;
    }
}
