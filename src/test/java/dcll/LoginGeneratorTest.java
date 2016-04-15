package dcll;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Matteo on 15/04/2016.
 */
public class LoginGeneratorTest {

    @Before
    public void setUp() throws Exception {
        String tab[] = new String[2];
        tab[0] = "MMOU";
        tab[1] = "EMOU";
        LoginService loginService = new LoginService(tab);
        LoginGenerator loginGenerator = new LoginGenerator(loginService);
    }

    @Test
    public void testGenerateLoginForNomAndPrenom() throws Exception {
        LoginService loginService = new LoginService(new String[] {"JROL", "BPER", "CGUR", "JDUP", "JRAL", "JRAL1"});
        LoginGenerator loginGenerator = new LoginGenerator(loginService);

        loginGenerator.generateLoginForNomAndPrenom("Durand", "Paul");
        assertTrue(loginService.loginExists("PDUR"));
        loginGenerator.generateLoginForNomAndPrenom("Rolling", "Jean");
        assertTrue(loginService.loginExists("JROL1"));


    }

    @Test
    public void testGenerateLoginForNomAndPrenomVersionAccent() throws Exception {
        LoginService loginService = new LoginService(new String[] {"JROL", "BPER", "CGUR", "JDUP", "JRAL", "JRAL1"});
        LoginGenerator loginGenerator = new LoginGenerator(loginService);

        loginGenerator.generateLoginForNomAndPrenom("Dùrand", "Paul");
        assertTrue(loginService.loginExists("PDUR"));

    }

}