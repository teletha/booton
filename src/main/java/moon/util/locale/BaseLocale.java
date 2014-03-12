/*
 * Copyright (C) 2014 Nameless Production Committee
 *
 * Licensed under the MIT License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://opensource.org/licenses/mit-license.php
 */
package moon.util.locale;

import sun.util.locale.BaseLocale;


/**
 * @version 2014/03/12 1:51:07
 */
// @JavaAPIProvider(sun.util.locale.BaseLocale.class)
class BaseLocale {

    public static final String SEP = "_";

    public static final BaseLocale ROOT = getInstance("", "", "", "");

    private String language = "";

    private String script = "";

    private String region = "";

    private String variant = "";

    private transient volatile int hash = 0;

    /**
     * @param language
     * @param script
     * @param region
     * @param variant
     */
    private BaseLocale(String language, String script, String region, String variant) {
        if (language != null) {
            this.language = language.toLowerCase();
        }
        if (script != null) {
            this.script = script.toLowerCase();
        }
        if (region != null) {
            this.region = region.toLowerCase();
        }
        if (variant != null) {
            this.variant = variant;
        }
    }

    public static BaseLocale getInstance(String language, String script, String region, String variant) {
        // JDK uses deprecated ISO639.1 language codes for he, yi and id
        if (language != null) {
            if (language.equalsIgnoreCase("he")) {
                language = "iw";
            } else if (language.equalsIgnoreCase("yi")) {
                language = "ji";
            } else if (language.equalsIgnoreCase("id")) {
                language = "in";
            }
        }
        return new BaseLocale(language, script, region, variant);
    }

    public String getLanguage() {
        return language;
    }

    public String getScript() {
        return script;
    }

    public String getRegion() {
        return region;
    }

    public String getVariant() {
        return variant;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BaseLocale)) {
            return false;
        }
        BaseLocale other = (BaseLocale) obj;
        return hashCode() == other.hashCode() && language.equals(other.language) && script.equals(other.script) && region.equals(other.region) && variant.equals(other.variant);
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        if (language.length() > 0) {
            buf.append("language=");
            buf.append(language);
        }
        if (script.length() > 0) {
            if (buf.length() > 0) {
                buf.append(", ");
            }
            buf.append("script=");
            buf.append(script);
        }
        if (region.length() > 0) {
            if (buf.length() > 0) {
                buf.append(", ");
            }
            buf.append("region=");
            buf.append(region);
        }
        if (variant.length() > 0) {
            if (buf.length() > 0) {
                buf.append(", ");
            }
            buf.append("variant=");
            buf.append(variant);
        }
        return buf.toString();
    }

    @Override
    public int hashCode() {
        int h = hash;
        if (h == 0) {
            // Generating a hash value from language, script, region and variant
            for (int i = 0; i < language.length(); i++) {
                h = 31 * h + language.charAt(i);
            }
            for (int i = 0; i < script.length(); i++) {
                h = 31 * h + script.charAt(i);
            }
            for (int i = 0; i < region.length(); i++) {
                h = 31 * h + region.charAt(i);
            }
            for (int i = 0; i < variant.length(); i++) {
                h = 31 * h + variant.charAt(i);
            }
            hash = h;
        }
        return h;
    }
}
