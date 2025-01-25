package com.demo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Indicates that this class is linked to additional documentation.
 * Use relative or absolute paths for documentation links.
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface DocumentationLink {
    String value(); // Path to the documentation
}

