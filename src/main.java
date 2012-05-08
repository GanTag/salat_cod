import codec.*;

import java.io.File;

class main {
    public static void main(String args[]){
        if (args.length > 0){
            switch (args[0].toLowerCase()){
                case "--code" :
                    switch (args[1].toLowerCase()){
                        case "string" :
                            try {
                                codecSalat.code(new File(args[2]), new File(args[3]), args[4]);
                            } catch (Exception e) {
                                System.out.println("Exception while coding = " + e);
                            }
                            break;
                        case "char" :
                            try {
                                codecSalat.code(new File(args[2]), new File(args[3]), args[4]);
                            } catch (Exception e) {
                                System.out.println("Exception while coding = " + e);
                            }
                            break;
                        case "file" :
                            try {
                                codecSalat.code(new File(args[2]), new File(args[3]), new File(args[4]));
                            } catch (Exception e) {
                                System.out.println("Exception while coding = " + e);
                            }
                            break;
                        default:
                            main.showHelp();
                    }
                    break;
                case "--decode" :
                    switch (args[1].toLowerCase()){
                        case "string" :
                            try {
                                codecSalat.decode(new File(args[2]), new File(args[3]), args[4]);
                            } catch (Exception e) {
                                System.out.println("Exception while coding = " + e);
                            }
                            break;
                        case "char" :
                            try {
                                codecSalat.decode(new File(args[2]), new File(args[3]), args[4]);
                            } catch (Exception e) {
                                System.out.println("Exception while coding = " + e);
                            }
                            break;
                        case "file" :
                            try {
                                codecSalat.decode(new File(args[2]), new File(args[3]), new File(args[4]));
                            } catch (Exception e) {
                                System.out.println("Exception while coding = " + e);
                            }
                            break;
                        default:
                            main.showHelp();
                    }
                    break;
                default :
                    main.showHelp();
                    break;
            }
        } else {
            main.showHelp();
        }
    }
    public static void showHelp(){
        System.out.println("incorrect command(s)");
        System.out.println("use parameters --[code/decode] [string/char/file] [inputFilename] [outputFilename] [codestring/codechar/codefile]");
        System.out.println("for example to code file with char \'c\' type : --code char input.txt output.txt c");
    }
}
