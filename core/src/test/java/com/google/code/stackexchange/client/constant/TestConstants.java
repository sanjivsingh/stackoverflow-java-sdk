/*
 * Copyright 2010 Nabeel Mukhtar 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 * 
 */
package com.google.code.stackexchange.client.constant;
import java.io.IOException;
import java.util.Properties;

/**
 * The Class TestConstants.
 */
public final class TestConstants {

    /** The Constant TEST_CONSTANTS_FILE. */
    public static final String TEST_CONSTANTS_FILE = "TestConstants.properties";

    /** The Constant testConstants. */
    private static final Properties testConstants = new Properties();

    static {
        try {
            testConstants.load(TestConstants.class.getResourceAsStream(TEST_CONSTANTS_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /** The Constant STACK_OVERFLOW_TEST_API_KEY. */
    public static final String STACK_OVERFLOW_TEST_API_KEY =
        testConstants.getProperty("com.google.code.stackexchange.client.apiKey");

    /** The Constant STACK_OVERFLOW_TEST_USER_IDS. */
    public static final String STACK_OVERFLOW_TEST_USER_IDS =
        testConstants.getProperty("com.google.code.stackexchange.client.testUserIds");
    
    /** The Constant STACK_OVERFLOW_TEST_QUESTION_IDS. */
    public static final String STACK_OVERFLOW_TEST_QUESTION_IDS =
        testConstants.getProperty("com.google.code.stackexchange.client.testQuestionIds");
    
    /** The Constant STACK_OVERFLOW_TEST_ANSWER_ID. */
    public static final String STACK_OVERFLOW_TEST_ANSWER_ID =
        testConstants.getProperty("com.google.code.stackexchange.client.testAnswerId");
    
    /** The Constant STACK_OVERFLOW_TEST_PAGE_NO. */
    public static final String STACK_OVERFLOW_TEST_PAGE_NO =
        testConstants.getProperty("com.google.code.stackexchange.client.testPageNo");
    
    /** The Constant STACK_OVERFLOW_TEST_PAGE_SIZE. */
    public static final String STACK_OVERFLOW_TEST_PAGE_SIZE =
        testConstants.getProperty("com.google.code.stackexchange.client.testPageSize");
    
    /** The Constant STACK_OVERFLOW_TEST_TAGS. */
    public static final String STACK_OVERFLOW_TEST_TAGS =
        testConstants.getProperty("com.google.code.stackexchange.client.testTags");
    
    /** The Constant STACK_OVERFLOW_TEST_USER_FILTER. */
    public static final String STACK_OVERFLOW_TEST_USER_FILTER =
        testConstants.getProperty("com.google.code.stackexchange.client.testUserFilter");

    /**
     * Instantiates a new test constants.
     */
    private TestConstants() {}
}
