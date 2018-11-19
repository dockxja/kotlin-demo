package be.continuum.data;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class UserTest {

    @Test
    public void createUser() {
        User user = createJohnDoeUser();

        assertThat(user.getSurname(), equalTo("John"));
        assertThat(user.getName(), equalTo("Doe"));
        assertThat(user.getAge(), nullValue());
        assertThat(user.toString(), containsString("be.continuum.data.User@"));
    }

    @Test
    public void createUserWithAge() {
        User user = createJohnDoeUser();
        user.setAge(30);

        assertThat(user.getAge(), equalTo(30));
    }

    @Test
    public void createKotlinUser() {
        KotlinUser user = new KotlinUser();
        user.setSurname("John");
        user.setName("Doe");
        user.setAge(30);

        assertThat(user.getSurname(), equalTo("John"));
        assertThat(user.getName(), equalTo("Doe"));
        assertThat(user.getAge(), equalTo(30));

        assertThat(user.toString(), equalTo("KotlinUser(surname=John, name=Doe, age=30, address=null, car=null)"));
    }

    private User createJohnDoeUser() {
        User user = new User();
        user.setSurname("John");
        user.setName("Doe");
        return user;
    }

}