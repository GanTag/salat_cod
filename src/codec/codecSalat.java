package codec;

import java.io.*;


public class codecSalat {

    private static final int alphavilesize = 255;
    //code procedure
    private static int codeChars(int input, int code){
        if ((input + code) > alphavilesize) {
            return (input + code - alphavilesize);
        } else {
            return input+code;
        }
    }
    //decode procedure
    private static int decodeChars(int input, int code){
        if ((input - code) < 0){
            return input-code+alphavilesize;
        } else {
            return input-code;
        }
    }
    //Check output file
    private static void checkOutputFile(File outputFile) throws Exception{
        if (outputFile.exists() == true){
            throw new Exception("OutputFile already exist, type another file");
        }
    }
    //Code with string
    public static void code(File inputFile, File outputFile, String codeString) throws Exception {
        try (FileInputStream inputStream = new FileInputStream(inputFile);
             FileOutputStream outputStream = new FileOutputStream(outputFile)  ) 
        {
            codecSalat.checkOutputFile(outputFile);
            int currentChar, stringCounter;
            stringCounter = 0;
            while ((currentChar = inputStream.read()) != -1){
                if (stringCounter < (codeString.length() - 1)){
                    stringCounter++;
                } else {
                    stringCounter = 0;
                }
                outputStream.write(codeChars(currentChar, codeString.charAt(stringCounter)));
            }
        } catch (FileNotFoundException | InterruptedIOException e){
            throw new Exception("Exeption : " + e);
        }

    }
    //Code with char UNUSED since String Overload exist
    public static void code(File inputFile, File outputFile, char codeChar) throws Exception {
        try (FileInputStream inputStream = new FileInputStream(inputFile);
             FileOutputStream outputStream = new FileOutputStream(outputFile)  )
        {
            codecSalat.checkOutputFile(outputFile);
            int currentChar, stringCounter;
            stringCounter = 0;
            while ((currentChar = inputStream.read()) != -1){
                outputStream.write(codeChars(currentChar, codeChar));
            }
        } catch (FileNotFoundException | InterruptedIOException e){
            throw new Exception("Exeption : " + e);
        }
    }
    //Code with file
    public static void code(File inputFile, File outputFile, File codeFile) throws Exception {
        try (FileInputStream inputStream = new FileInputStream(inputFile);
             FileOutputStream outputStream = new FileOutputStream(outputFile);
             RandomAccessFile codeStream = new RandomAccessFile(codeFile,"r"))
        {
            codecSalat.checkOutputFile(outputFile);
            int currentChar, currentCodeChar;
            while ((currentChar = inputStream.read()) != -1){
                if ((currentCodeChar = codeStream.read()) == -1){
                    codeStream.seek(0);
                    currentCodeChar = codeStream.read();
                } else {
                    currentCodeChar = codeStream.read();
                }
                outputStream.write(codeChars(currentChar,currentCodeChar));
            }
        } catch (FileNotFoundException | InterruptedIOException e){
            throw new Exception("Exeption : " + e);
        }

    }
    //Decode with string
    public static void decode(File inputFile, File outputFile, String codeString) throws Exception {
        try (FileInputStream inputStream = new FileInputStream(inputFile);
             FileOutputStream outputStream = new FileOutputStream(outputFile)  )
        {
            codecSalat.checkOutputFile(outputFile);
            int currentChar, stringCounter;
            stringCounter = 0;
            while ((currentChar = inputStream.read()) != -1){
                if (stringCounter < (codeString.length() - 1)){
                    stringCounter++;
                } else {
                    stringCounter = 0;
                }
                outputStream.write(decodeChars(currentChar,codeString.charAt(stringCounter)));
            }
        } catch (FileNotFoundException | InterruptedIOException e){
            throw new Exception("Exeption : " + e);
        }
    }
    //Decode with char UNUSED since String Overload exist
    public static void decode(File inputFile, File outputFile, char codeChar) throws Exception {
        try (FileInputStream inputStream = new FileInputStream(inputFile);
             FileOutputStream outputStream = new FileOutputStream(outputFile)  )
        {
            codecSalat.checkOutputFile(outputFile);
            int currentChar;
            while ((currentChar = inputStream.read()) != -1){
                outputStream.write(decodeChars(currentChar,codeChar));
            }
        } catch (FileNotFoundException | InterruptedIOException e){
            throw new Exception("Exeption : " + e);
        }
    }
    //Decode with file
    public static void decode(File inputFile, File outputFile, File codeFile) throws Exception {
        try (FileInputStream inputStream = new FileInputStream(inputFile);
             FileOutputStream outputStream = new FileOutputStream(outputFile);
             RandomAccessFile codeStream = new RandomAccessFile(codeFile,"r"))
        {
            codecSalat.checkOutputFile(outputFile);
            int currentChar, currentCodeChar;
            while ((currentChar = inputStream.read()) != -1){
                if ((currentCodeChar = codeStream.read()) == -1){
                    codeStream.seek(0);
                    currentCodeChar = codeStream.read();
                } else {
                    currentCodeChar = codeStream.read();
                }
                outputStream.write(decodeChars(currentChar,currentCodeChar));
            }
        } catch (FileNotFoundException | InterruptedIOException e){
            throw new Exception("Exeption : " + e);
        }

    }
}
