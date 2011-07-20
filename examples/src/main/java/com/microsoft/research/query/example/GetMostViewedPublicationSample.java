/*
 * Copyright 2011 Nabeel Mukhtar 
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
package com.microsoft.research.query.example;

import java.text.MessageFormat;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.microsoft.research.PagedList;
import com.microsoft.research.Publication;
import com.microsoft.research.query.AcademicSearchQueryFactory;
import com.microsoft.research.query.GetMostViewedPublicationQuery;

/**
 * The Class GetMostViewedPublicationSample.
 */
public class GetMostViewedPublicationSample {

    /** The Constant APPLICATION_KEY_OPTION. */
    private static final String APPLICATION_KEY_OPTION = "appid";
	
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
    		AcademicSearchQueryFactory factory = AcademicSearchQueryFactory.newInstance(line.getOptionValue(APPLICATION_KEY_OPTION));
    		GetMostViewedPublicationQuery query = factory.newGetMostViewedPublicationQuery();
    		PagedList<Publication> response = query.withDomainId(1).list();
    		printResponse(response);
        } else {
        	printHelp(options);
        }
	}

	/**
	 * Prints the response.
	 * 
	 * @param response the response
	 */
	private static void printResponse(PagedList<Publication> response) {
		System.out.println(response.getStartIndex());
		System.out.println(response.getEndIndex());
		System.out.println(response.getTotalItems());
		for (Publication result : response) {
			System.out.println(result.getTitle());			
			System.out.println(result.getAbstract());			
			System.out.println(result.getAuthor());			
			System.out.println("=======================================");			
		}
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

        String applicationKeyMsg = "You Application ID.";
        OptionBuilder.withArgName("appid");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription(applicationKeyMsg);
        Option applicationKey = OptionBuilder.create(APPLICATION_KEY_OPTION);
        opts.addOption(applicationKey);
        
        return opts;
    }
    
    /**
     * Prints the help.
     * 
     * @param options the options
     */
    private static void printHelp(Options options) {
        int width = 80;
        String syntax = GetMostViewedPublicationSample.class.getName() + " <options>";
        String header = MessageFormat.format("\nThe -{0} option is required. All others are optional.", APPLICATION_KEY_OPTION);
        new HelpFormatter().printHelp(width, syntax, header, options, null, false);
    }
}
