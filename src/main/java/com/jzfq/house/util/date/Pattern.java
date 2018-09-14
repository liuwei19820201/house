package com.jzfq.house.util.date;

/**
 * The date and time format enumeration
 *
 * @author Garen Gosling
 * @create 2017-09-07 00:00
 * @since v1.0
 */
public enum Pattern {

    DATE("yyyy-MM-dd"),
    TIME("yyyy-MM-dd HH:mm:ss");

    private String pattern;

    private Pattern(String pattern) {
        this.pattern = pattern;
    }

    public String value() {
        return pattern;
    }
}
