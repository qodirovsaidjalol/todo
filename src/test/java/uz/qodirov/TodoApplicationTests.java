package uz.qodirov;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
class TodoApplicationTests {

    class User {
        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public String toString() {
            return username + "  " + password;
        }
    }

    @Test
    void contextLoads() {
        final User user = new User();
        user.setUsername("123");
        user.setPassword("123");
        System.out.println(user);
    }
}
