package dcll;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Matteo on 15/04/2016.
 */
public class LoginServiceTest {

    @Before
    public void setUp() throws Exception {
        String tab[] = new String[2];
        tab[0] = "MMOU";
        tab[1] = "EMOU";
        LoginService loginService = new LoginService(tab);
    }

    @Test
    public void testLoginExists() throws Exception {
        String tab[] = new String[2];
        tab[0] = "MMAT";
        tab[1] = "MENZ";
        LoginService loginService = new LoginService(tab);
        assertTrue(loginService.loginExists("MMAT"));

    }

    @Test
    public void testAddLogin() throws Exception {

        String tab[] = new String[2];
        tab[0] = "MMAT";
        tab[1] = "MENZ";
        LoginService loginService = new LoginService(tab);
        loginService.addLogin("MMAT");
        assertTrue(loginService.loginExists("MMAT"));

    }

    @Test
    public void testFindAllLoginsStartingWith() throws Exception {
        String tab[] = new String[1];
        tab[0] = "MMAT";
        LoginService loginService = new LoginService(tab);
        loginService.addLogin("MMAT");
        List<String> list = loginService.findAllLoginsStartingWith("M");
        assertEquals(list.get(0), "MMAT");

    }

    @Test
    public void testFindAllLogins() throws Exception {
        String tab[] = new String[1];
        tab[0] = "MMAT";
        LoginService loginService = new LoginService(tab);
        loginService.addLogin("MMAT");
        List<String> list = loginService.findAllLogins();
        List<String> compare = new ArrayList<String>();
        compare.add("MMAT");
        assertEquals(list.get(0), compare.get(0));


    }
}