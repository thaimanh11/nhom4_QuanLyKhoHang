package dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import entity.Account;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {

    public static String FILE_NAME = "accounts.json";

    public AccountDAO() {
    }

    public Account login(String username, String password) {
        List<Account> accounts = getAll();
        if (accounts == null || accounts.size() == 0) {
            return null;
        }
        for (Account account : accounts) {
            if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
                return account;
            }
        }
        return null;
    }

    public List<Account> getAll() {
        String currentDirectory = System.getProperty("user.dir");
        Gson gson = new Gson();
        List<Account> accounts = new ArrayList();
        String path = currentDirectory + "/" + FILE_NAME;
        File file = new File(path);
        if (!file.exists()) {
            insert(new Account(0, "admin", "123"));
            return getAll();
        }
        try (FileReader reader = new FileReader(path)) {
            Type userListType = new TypeToken<List<Account>>() {
            }.getType();

            accounts = gson.fromJson(reader, userListType);
            if (accounts == null) {
                accounts = new ArrayList();
            }
            return accounts;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    public boolean insert(Account user) {
        if (user == null) {
            return false;
        }
        String currentDirectory = System.getProperty("user.dir");
        Gson gson = new Gson();
        List<Account> accounts = getAll();
        if (accounts == null) {
            accounts = new ArrayList<>();
        }
        user.setId(getNextId());
        try (FileWriter writer = new FileWriter(currentDirectory + "/" + FILE_NAME)) {
            accounts.add(user);
            gson.toJson(accounts, writer);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean saveToFile(List<Account> accounts) {
        if (accounts == null || accounts.size() == 0) {
            return false;
        }
        String currentDirectory = System.getProperty("user.dir");
        Gson gson = new Gson();

        try (FileWriter writer = new FileWriter(currentDirectory + "/" + FILE_NAME)) {
            gson.toJson(accounts, writer);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private int getNextId() {
        List<Account> accounts = getAll();
        if (accounts == null || accounts.size() == 0) {
            return 1;
        }
        int maxId = 1;
        for (Account account : accounts) {
            if (account.getId() > maxId) {
                maxId = account.getId();
            }
        }
        maxId += 1;
        return maxId;
    }
}
