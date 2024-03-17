package main;

import org.apache.commons.cli.*;

import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    public static String VERSION = "0.0.1";
    static Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        LOGGER.setUseParentHandlers(false);
        LOGGER.addHandler(createHandler());


        Options options = new Options();

        options.addOption("h", "help", false, "Help");
        options.addOption("i", "input", true, "Input Text");

        CommandLineParser parser = new DefaultParser();

        CommandLine cmd = null;
        try {
            cmd = parser.parse( options, args);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        for (String string :
                cmd.getArgs()) {
            System.out.println(string);
        }

        if(cmd.hasOption("h")) {
            new HelpFormatter().printHelp("app -h ...", "Java Native CLI Template v"+VERSION+"\n"+BANNER, options, "Made by Programmer");
            return;
        }

        if (cmd.hasOption("i")){
            LOGGER.info("Output: "+cmd.getOptionValue("input"));

            return;
        }

        LOGGER.info("Processing the process");

    }

    public static String BANNER =
                    "     ██╗ █████╗ ██╗   ██╗ █████╗               \n" +
                    "     ██║██╔══██╗██║   ██║██╔══██╗              \n" +
                    "     ██║███████║██║   ██║███████║              \n" +
                    "██   ██║██╔══██║╚██╗ ██╔╝██╔══██║              \n" +
                    "╚█████╔╝██║  ██║ ╚████╔╝ ██║  ██║              \n" +
                    " ╚════╝ ╚═╝  ╚═╝  ╚═══╝  ╚═╝  ╚═╝              \n" +
                    "                                               \n" +
                    "███╗   ██╗ █████╗ ████████╗██╗██╗   ██╗███████╗\n" +
                    "████╗  ██║██╔══██╗╚══██╔══╝██║██║   ██║██╔════╝\n" +
                    "██╔██╗ ██║███████║   ██║   ██║██║   ██║█████╗  \n" +
                    "██║╚██╗██║██╔══██║   ██║   ██║╚██╗ ██╔╝██╔══╝  \n" +
                    "██║ ╚████║██║  ██║   ██║   ██║ ╚████╔╝ ███████╗\n" +
                    "╚═╝  ╚═══╝╚═╝  ╚═╝   ╚═╝   ╚═╝  ╚═══╝  ╚══════╝\n" +
                    "                                               \n" +
                    " ██████╗██╗     ██╗                            \n" +
                    "██╔════╝██║     ██║                            \n" +
                    "██║     ██║     ██║                            \n" +
                    "██║     ██║     ██║                            \n" +
                    "╚██████╗███████╗██║                            \n" +
                    " ╚═════╝╚══════╝╚═╝                            \n" +
                    "                                               ";

    private static ConsoleHandler createHandler(){
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(new SimpleFormatter() {
            private static final String format = "[%1$tF %1$tT] [%2$-7s] %3$s %n";

            @Override
            public synchronized String format(LogRecord lr) {
                return String.format(format,
                        new Date(lr.getMillis()),
                        lr.getLevel().getLocalizedName(),
                        lr.getMessage()
                );
            }
        });

        return handler;
    }
}
