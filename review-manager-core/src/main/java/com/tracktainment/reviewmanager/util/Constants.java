package com.tracktainment.reviewmanager.util;

public class Constants {

    public Constants() {
        throw new IllegalStateException("Cannot instantiate an util class.");
    }

    // Required fields validation
    public static final String ENTITY_ID_MANDATORY_MSG = "'entityId' is mandatory.";
    public static final String ENTITY_TYPE_MANDATORY_MSG = "'entityType' is mandatory.";
    public static final String RATING_MANDATORY_MSG = "'rating' is mandatory.";


    // Regex
    public static final String ID_REGEX = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";
    public static final String TITLE_REGEX = "^[A-Za-z0-9\\s\\-,\\.\\'\\\";:!?()&]{1,200}$";
    public static final String TYPE_REGEX = "[ \\wÀ-ú\\.:,;\\-\\[\\]()]{1,30}";
    public static final String CONTENT_REGEX = "^[\\p{L}\\p{N}\\s\\p{P}]{10,2000}$";


    // Fields validation
    public static final String ID_INVALID_MSG = "'id' must match: " + ID_REGEX + ".";
    public static final String TITLE_INVALID_MSG = "'title' must match: " + TITLE_REGEX + ".";
    public static final String TYPE_INVALID_MSG = "'type' must match: " + TYPE_REGEX + ".";
    public static final String CONTENT_INVALID_MSG = "'content' must match: " + CONTENT_REGEX + ".";
    public static final String RATING_INVALID_MSG = "'rating' must be between 1 and 5.";
}
