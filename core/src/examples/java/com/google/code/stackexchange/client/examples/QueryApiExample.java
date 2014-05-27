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
package com.google.code.stackexchange.client.examples;

import java.text.MessageFormat;
import java.util.EnumSet;
import java.util.List;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.google.code.stackexchange.client.query.QuestionApiQuery;
import com.google.code.stackexchange.client.query.StackExchangeApiQueryFactory;
import com.google.code.stackexchange.schema.FilterOption;
import com.google.code.stackexchange.schema.Question;

/**
 * The Class QueryApiExample.
 */
public class QueryApiExample {

    /** The Constant APPLICATION_KEY_OPTION. */
    private static final String APPLICATION_KEY_OPTION = "key";
	
    /** The Constant HELP_OPTION. */
    private static final String HELP_OPTION = "help";
    
    /**
     * The main method.
     * 
     * @param args the arguments
     */
	public static void main(String[] args) {
		Options options = buildOptions();
        try {
            CommandLine line = new BasicParser().parse(options, args);
            processCommandLine(line, options);
        } catch(ParseException exp ) {
            System.err.println(exp.getMessage());
            printHelp(options);
        }
	}
	
    /**
     * Process command line.
     * 
     * @param line the line
     * @param options the options
     */
    private static void processCommandLine(CommandLine line, Options options) {
        if(line.hasOption(HELP_OPTION)) {
            printHelp(options);            
        } else if(line.hasOption(APPLICATION_KEY_OPTION)) {
    		final String keyValue = line.getOptionValue(APPLICATION_KEY_OPTION);
    		
    		final StackExchangeApiQueryFactory factory = StackExchangeApiQueryFactory.newInstance(keyValue);
    		final QuestionApiQuery query = factory.newQuestionApiQuery();
    		
			List<Question> questions = query.withFetchOptions(EnumSet.of(FilterOption.INCLUDE_BODY, FilterOption.INCLUDE_COMMENTS)).withSort(Question.SortOrder.HOT).list();
			for (Question question : questions) {
				printResult(question);
			}
        } else {
            printHelp(options);
        }
    }
	
	/**
	 * Prints the result.
	 * 
	 * @param question the question
	 */
	private static void printResult(Question question) {
		System.out.println(question.getTitle() + ":" + question.getAnswerCount());
	}

	/**
	 * Builds the options.
	 * 
	 * @return the options
	 */
    private static Options buildOptions() {
       
        Options opts = new Options();
        
        String helpMsg = "Print this message.";
        Option help = new Option(HELP_OPTION, helpMsg);
        opts.addOption(help);

        String consumerKeyMsg = "You API Key.";
        OptionBuilder.withArgName("key");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription(consumerKeyMsg);
        Option consumerKey = OptionBuilder.create(APPLICATION_KEY_OPTION);
        opts.addOption(consumerKey);
        
        return opts;
    }
    
    /**
     * Prints the help.
     * 
     * @param options the options
     */
    private static void printHelp(Options options) {
        int width = 80;
        String syntax = QueryApiExample.class.getName() + " <options>";
        String header = MessageFormat.format("\nThe -{0} option is required.", APPLICATION_KEY_OPTION);
        String footer = "";
        new HelpFormatter().printHelp(width, syntax, header, options, footer, false);
    }
}
