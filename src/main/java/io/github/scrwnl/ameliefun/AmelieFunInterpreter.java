package io.github.scrwnl.ameliefun;

import org.kohsuke.args4j.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
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
        } catch (CmdLineException e) {
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
        
        // File check
        Path sourceFilePath = Paths.get(commandLine.fileName);
        if ( !Files.exists(sourceFilePath) ) {
            System.err.println("Fatal Error: No such file or directory");
            System.exit(1);
        } else if (!Files.isReadable(sourceFilePath)) {
            System.err.println("Fatal Error: It is not readable.");
            System.exit(1);
        } else if (Files.isDirectory(sourceFilePath)) {
            System.err.println("Fatal Error: It is a directory.");
            System.exit(1);
        }

        try {
            String code = String.join("", Files.readAllLines(sourceFilePath));
            runCode(code);
        } catch (IOException e) {
            System.err.println("Fatal Error: IO Error");
            System.exit(1);
        }
    }
    /**
     * RunnerStatus
     */
    public record RunnerStatus(int statusCode, String message) {};
    static int runCode(String code, String input) {
        return 0;
    }

    // Interactive mode
    static int runCode(String code) {
        return 0;
    }
}
