package com.tracktainment.reviewmanager.util;

public class Constants {

    public Constants() {
        throw new IllegalStateException("Cannot instantiate an util class.");
    }

    // Default values;
    public static final String DEFAULT_OFFSET = "0";
    public static final String DEFAULT_LIMIT = "10";
    public static final int MIN_OFFSET = 0;
    public static final int MIN_LIMIT = 1;
    public static final int MAX_LIMIT = 100;
    public static final String DEFAULT_ORDER = "ENTITY";
    public static final String DEFAULT_DIRECTION = "ASC";
    public static final int MIN_RATING = 1;
    public static final int MAX_RATING = 5;

    // Required fields validation
    public static final String ENTITY_ID_MANDATORY_MSG = "'entityId' is mandatory.";
    public static final String ENTITY_TYPE_MANDATORY_MSG = "'entityType' is mandatory.";
    public static final String RATING_MANDATORY_MSG = "'rating' is mandatory.";


    // Regex
    public static final String ID_REGEX = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";
    public static final String TITLE_REGEX = "^[A-Za-z0-9\\s\\-,\\.\\'\\\";:!?()&]{1,200}$";
    public static final String TYPE_REGEX = "[ \\wÀ-ú\\.:,;\\-\\[\\]()]{1,30}";
    public static final String CONTENT_REGEX = "^[\\p{L}\\p{N}\\s\\p{P}]{10,2000}$";
    public static final String ID_LIST_REGEX =
            "^([a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12})(," +
                    "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}){0," +
                    (MAX_LIMIT-1) + "}$";


    // Fields validation
    public static final String ID_INVALID_MSG = "'id' must match: " + ID_REGEX + ".";
    public static final String TITLE_INVALID_MSG = "'title' must match: " + TITLE_REGEX + ".";
    public static final String TYPE_INVALID_MSG = "'type' must match: " + TYPE_REGEX + ".";
    public static final String CONTENT_INVALID_MSG = "'content' must match: " + CONTENT_REGEX + ".";
    public static final String RATING_INVALID_MSG = "'rating' must be between 1 and 5.";
    public static final String OFFSET_INVALID_MSG = "'offset' must be positive.";
    public static final String LIMIT_INVALID_MSG = "'limit' must be in the range [" + MIN_LIMIT + ", " + MAX_LIMIT + "]";
    public static final String IDS_INVALID_MSG = "'ids' must match: " + ID_LIST_REGEX + ".";
}
