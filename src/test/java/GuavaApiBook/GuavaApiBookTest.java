package GuavaApiBook;


import GuavaApiBook.domain.Person;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import com.google.common.collect.*;

import static com.google.common.collect.Iterables.getFirst;
import static org.hamcrest.CoreMatchers.is;

public class GuavaApiBookTest {

    private Person person1;
    private Person person2;
    private Person person3;
    private Person person4;
    private List<Person> personList;

    @Before
    public void setUp() throws Exception {
        person1 = new Person("Wilma", "Flintstone", 30, "F");
        person2 = new Person("Fred", "Flintstone", 32, "M");
        person3 = new Person("Betty", "Rubble", 31, "F");
        person4 = new Person("Barney", "Rubble", 33, "M");
        personList = Lists.newArrayList(person1, person2, person3, person4);
    }

    @Test
    public void testPredicatehardCoded() {

        Iterable<Person> personFilterByAge = FluentIterable.from(personList).filter(new Predicate<Person>() {
            @Override
            public boolean apply(Person input) {
                return input.getAge()>31;
            }
        });

        Assert.assertThat(Iterables.contains(personFilterByAge,person2),is(true));
        Assert.assertThat(Iterables.contains(personFilterByAge,person4),is(true));
        Assert.assertThat(Iterables.contains(personFilterByAge,person3),is(false));
        Assert.assertThat(Iterables.contains(personFilterByAge,person1),is(false));

    }


    @Test
    public void testPredicateInyected() {
        Iterable<Person> personFilterByAge = FluentIterable.from(personList).filter(over31Years());

        Assert.assertThat(Iterables.contains(personFilterByAge,person2),is(true));
        Assert.assertThat(Iterables.contains(personFilterByAge,person4),is(true));
        Assert.assertThat(Iterables.contains(personFilterByAge,person3),is(false));
        Assert.assertThat(Iterables.contains(personFilterByAge,person1),is(false));
    }

    public Predicate<Person> over31Years(){
        return new Predicate<Person>() {
            @Override
            public boolean apply(Person input) {
                return input.getAge()>31;
            }
        };
    }


    @Test
    public void testInmutableList() {
       List<String> inmutableListJDK = Collections.unmodifiableList(Arrays.asList("one","two","three"));
       Assert.assertThat(inmutableListJDK.size(),is(3));

    }

    @Test
    public void testFluentIterableTransformFunctionHardCoded() {
        List<String> transformedList = FluentIterable.from(personList).transform(
                new Function<Person, String>() {
                    @Override
                    public String apply(Person input) {
                        return Joiner.on('#').join(input.getLastName(),input.getName(),input.getAge());
                    }
                }
        ).toList();

        Assert.assertThat(getFirst(transformedList,""),is("Flintstone#Wilma#30"));

    }

    @Test
    public void testFluentIterableTransformFunctionInyected() {
        List<String> transformedList = FluentIterable.from(personList).transform(joinPersonData()).toList();

        Assert.assertThat(getFirst(transformedList,""),is("Flintstone#Wilma#30"));

    }


    public Function<Person,String> joinPersonData(){
        return new Function<Person, String>() {
            @Override
            public String apply(Person input) {
                return Joiner.on('#').join(input.getLastName(),input.getName(),input.getAge());
            }
        };
    }
}
