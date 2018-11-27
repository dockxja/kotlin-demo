package be.continuum.data;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class UserTest {

    @Test
    public void createUser() {
        User user = new User();
        user.setSurname("John");
        user.setName("Doe");
        user.setAge(30);

        assertThat(user.getSurname(), equalTo("John"));
        assertThat(user.getName(), equalTo("Doe"));
        assertThat(user.getAge(), equalTo(30));
        assertThat(user.toString(), containsString("be.continuum.data.User@"));

        User sameUser = new User();
        sameUser.setSurname("John");
        sameUser.setName("Doe");
        sameUser.setAge(30);
        assertThat(user, not(equalTo(sameUser)));
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

        KotlinUser sameUser = new KotlinUser();
        sameUser.setSurname("John");
        sameUser.setName("Doe");
        sameUser.setAge(30);
        assertThat(user, equalTo(sameUser));
    }

}