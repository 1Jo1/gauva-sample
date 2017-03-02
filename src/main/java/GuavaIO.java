import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.io.*;

import java.io.*;
import java.util.List;


/**
 * Created by josef on 2/23/17.
 */
public class GuavaIO {

    public static void main(String [] args) {
        try {
            whenWriteUsingFiles_thenWritten();
            whenWriteMultipleLinesUsingCharSink_thenWritten();
            whenReadUsingCharSource_thenRead();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            testCopyByteStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        charSourceTest();
    }

    public static void whenWriteUsingFiles_thenWritten() throws IOException {
        String expectedValue = "Hello world";
        File file = new File("test.txt");
        Files.write(expectedValue, file, Charsets.UTF_8);
        String result = Files.toString(file, Charsets.UTF_8);
        System.out.println(result);
    }


    public static void whenWriteMultipleLinesUsingCharSink_thenWritten() throws IOException {
        List<String> names = Lists.newArrayList("John", "Jane", "Adam", "Tom");
        File file = new File("test.txt");
        CharSink sink = Files.asCharSink(file, Charsets.UTF_8);
        sink.writeLines(names, " ");

        String result = Files.toString(file, Charsets.UTF_8);
        String expectedValue = Joiner.on(" ").join(names);
        System.out.println(result);
    }

    public static void testCopyByteStream() throws IOException {
        FileInputStream in = new FileInputStream("in.txt");
        FileOutputStream out = new FileOutputStream("out.txt");

        try {
            ByteStreams.copy(in,out);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (in != null) {
            in.close();
        }
        if (out != null) {
            out.close();
        }


    }

    public static void whenWriteUsingByteSink_thenWritten() throws IOException {
        String expectedValue = "Hello world";
        File file = new File("test.txt");
        ByteSink sink = Files.asByteSink(file);
        sink.write(expectedValue.getBytes());
        String result = Files.toString(file, Charsets.UTF_8);
    }

    public void whenReadUsingFiles_thenRead() throws IOException {
        String expectedValue = "Hello world";
        File file = new File("test.txt");
        String result = Files.toString(file, Charsets.UTF_8);

    }

    public void whenReadMultipleLinesUsingFiles_thenRead() throws IOException {
        File file = new File("test.txt");
        List<String> result = Files.readLines(file, Charsets.UTF_8);

    }

    public static void whenReadUsingCharSource_thenRead() throws IOException {
        String expectedValue = "Hello world";
        File file = new File("test.txt");
        CharSource source = Files.asCharSource(file, Charsets.UTF_8);

        String result = source.read();
        System.out.println(result);
    }

    public static void whenReadMultipleCharSources_thenRead() throws IOException {
        String expectedValue = "Hello worldTest";
        File file1 = new File("test1.txt");
        File file2 = new File("test2.txt");

        CharSource source1 = Files.asCharSource(file1, Charsets.UTF_8);
        CharSource source2 = Files.asCharSource(file2, Charsets.UTF_8);
        CharSource source = CharSource.concat(source1, source2);

        String result = source.read();
    }

    public static void whenReadUsingCharStream_thenRead() throws IOException {
        String expectedValue = "Hello world";
        FileReader reader = new FileReader("test.txt");
        String result = CharStreams.toString(reader);

        reader.close();
    }

    public static void charSourceTest() {
       CharSource charSource =  CharSource.wrap("Test");

        try {
            String result = charSource.read();
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
