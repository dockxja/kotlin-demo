package be.continuum;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class JavaBasics {

    @Test
    public void extensionTest() {
        String field = null;
        assertThat(Utils.isNotNullOrBlank(field), is(false));
        field = "";
        assertThat(Utils.isNotNullOrBlank(field), is(false));
        field = "Hello World!";
        assertThat(Utils.isNotNullOrBlank(field), is(true));
    }

    @Test
    public void singletonExample() {
        SingletonExample.INSTANCE.hello();
        SingletonExample.INSTANCE.hello();
        SingletonExample.INSTANCE.hello();
    }

}
