package helpers;

import org.apache.logging.log4j.Logger;

import static helpers.logColors.*;

public class logColorPrinter {
    public static void paintMesadgeInBlue(String message){
        System.out.println(BLUE_BOLD + message + RESET);
    }
    public  static void printColorMessage(String message, Logger logger, Level level){
        switch (level){
            case INFO: logger.info(BLUE + message + RESET);
            break;
        }
        switch (level){
            case DEBUG: logger.debug(YELLOW + message + RESET);
            break;
        }
        switch (level){
            case ERROR: logger.error(RED + message + RESET);
        }
    }
}
