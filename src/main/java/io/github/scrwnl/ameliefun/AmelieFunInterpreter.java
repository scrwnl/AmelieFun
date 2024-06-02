package io.github.scrwnl.ameliefun;

import org.kohsuke.args4j.*;


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

    public static void main( String[] args )
    {
        AmelieFunInterpreter commandLine = new AmelieFunInterpreter();
        CmdLineParser parser = new CmdLineParser(commandLine);
        try {
            parser.parseArgument(args);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(1);
        }

        if ( commandLine.versionFlag ) {
            System.out.println( "AmelieFun Interpreter version 1.0.0" );
            System.exit(0);
        } else if ( commandLine.helpFlag ) {
            System.out.println( "Show Usage" );
            System.exit(0);
        }
    }
}
