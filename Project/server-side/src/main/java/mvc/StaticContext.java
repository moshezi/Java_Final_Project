/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Moshe Itzhaki
 */
public class StaticContext {
    private static final List<String> USERS = new ArrayList<>();
    public static void registrationUser(String login) {
        USERS.add(login);
    }
}
