package com.sokolov.task2.builder;

import com.sokolov.task2.entity.type.PostcardType;
import com.sokolov.task2.exception.XmlParserException;

public class PostcardBuilderManager {
    public RegularPostcardBuilder createPostcard(PostcardType type) throws XmlParserException {
        RegularPostcardBuilder builder;

        switch (type) {
            case REGULAR_POSTCARD:
                builder = new RegularPostcardBuilder();
                break;
            case PROMOTIONAL_POSTCARD:
                builder = new PromotionalPostcardBuilder();
                break;
            case GREETING_POSTCARD:
                builder = new GreetingPostcardBuilder();
                break;
            default:
                throw new XmlParserException("Incorrectly entered data");
        }
        return builder;
    }

    public RegularPostcardBuilder createPostcard(String type) throws XmlParserException {
        RegularPostcardBuilder builder;

        switch (type) {
            case "REGULAR_POSTCARD":
                builder = new RegularPostcardBuilder();
                break;
            case "PROMOTIONAL_POSTCARD":
                builder = new PromotionalPostcardBuilder();
                break;
            case "GREETING_POSTCARD":
                builder = new GreetingPostcardBuilder();
                break;
            default:
                throw new XmlParserException("Incorrectly entered data");
        }
        return builder;
    }
}
