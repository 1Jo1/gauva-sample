import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

/**
 * Created by josef on 2/23/17.
 */
public class GuavaString {

    public static void main(String [] args) {
        Joiner joiner = Joiner.on("; ").skipNulls();
        String joiner2 = joiner.join("Harry", null, "Ron", "Hermione");

        System.out.println(joiner2);
        splitter();

        splitterSimpleExample();
    }

    public static void splitter() {
        Iterable<String> list = Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()
                .split("foo,bar,,   qux");

        String t = list.toString();
        System.out.println(t);


    }


    public static void splitterSimpleExample() {
        String str = "a,b,c,d";

        Iterable<String> result = Splitter.on(',')
                .split(str);

        System.out.println("--start--");
        for(String s: result){
            System.out.println(s);
        }
        System.out.println("--end--");

        System.out.println(result);
    }
}
