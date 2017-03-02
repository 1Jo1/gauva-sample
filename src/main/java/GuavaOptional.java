import com.google.common.base.Optional;

/**
 * Created by josef on 2/19/17.
 */
public class GuavaOptional {


    public void testOptional() {
        Optional<Integer> possible = Optional.of(5);
        possible.isPresent(); // returns true
        possible.get(); // returns 5


        Optional<Integer> p2 = possible.fromNullable(null);


        System.out.println(p2.isPresent());
    }

    public static void main(String [] args) {





    }
}
