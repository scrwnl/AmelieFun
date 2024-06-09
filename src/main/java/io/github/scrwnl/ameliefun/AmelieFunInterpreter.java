package io.github.scrwnl.ameliefun;

import org.kohsuke.args4j.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;


public class AmelieFunInterpreter
{
    @Option(name = "--version", aliases = "-v", usage = "Show version")
    private boolean versionFlag;

    @Option(name = "--help", aliases = "-h", usage = "Show help")
    private boolean helpFlag;

    //@Option(name = "--debug", usage = "Debug mode")
    //private boolean isDebugMode;

    @Argument(index = 0, metaVar = "program file")
    private String fileName;

    public static void main( String[] args ) {
        AmelieFunInterpreter commandLine = new AmelieFunInterpreter();
        CmdLineParser parser = new CmdLineParser(commandLine);
        try {
            parser.parseArgument(args);
        } catch (Exception e) {
            System.out.println("Fatal Error: " + e.getMessage());
            System.exit(1);
        }

        if ( commandLine.versionFlag ) {
            System.out.println( "AmelieFun Interpreter version 1.0.0" );
            System.exit(0);
        } else if ( commandLine.helpFlag ) {
            System.out.println( "Show Usage" );
            System.exit(0);
        }
        
        // File existence check
        Path sourceFile = Paths.get(commandLine.fileName);
        try {
            if ( !Files.exists(sourceFile) ) {
                System.err.println("Fatal Error: No such file or directory");
                System.exit(1);
            }
        } catch (SecurityException e) {
            System.err.println("Fatal Error: No read permission");
            System.exit(1);
        }
    }
}
