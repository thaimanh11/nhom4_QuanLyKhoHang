package dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import entity.Product;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public static String FILE_NAME = "products.json";

    public ProductDAO() {
    }

    public Product get(int id) {
        List<Product> products = getAll();
        if (products == null || products.size() == 0) {
            return null;
        }
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public List<Product> search(String search) {
        List<Product> products = getAll();
        if (products == null || products.size() == 0) {
            return null;
        }
        List<Product> searchList = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(search.toLowerCase())) {
                searchList.add(product);
            }
        }
        return searchList;
    }

    public boolean delete(int id) {
        Product existProduct = get(id);
        if (existProduct == null) {
            return false;
        }
        List<Product> products = getAll();
        if (products == null || products.size() == 0) {
            return false;
        }
        products.remove(existProduct);
        return saveToFile(products);
    }

    public boolean update(Product product) {
        List<Product> products = getAll();
        if (products == null || products.size() == 0) {
            return false;
        }
        int index = 0;
        for (Product productInFile : products) {
            if (productInFile.getId() == product.getId()) {
                break;
            }
            index++;
        }
        products.remove(index);
        products.add(index, product);
        return saveToFile(products);
    }

    public List<Product> getAll() {
        String currentDirectory = System.getProperty("user.dir");
        Gson gson = new Gson();
        List<Product> products = new ArrayList();
        String path = currentDirectory + "/" + FILE_NAME;
        File file = new File(path);
        if (!file.exists()) {
            saveToFile(products);
            return products;
        }
        try (FileReader reader = new FileReader(path)) {
            Type userListType = new TypeToken<List<Product>>() {
            }.getType();
            products = gson.fromJson(reader, userListType);
            if (products == null) {
                products = new ArrayList();
            }
            return products;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }

    public boolean insert(Product product) {
        if (product == null) {
            return false;
        }
        String currentDirectory = System.getProperty("user.dir");
        Gson gson = new Gson();
        List<Product> products = getAll();
        if (products == null) {
            products = new ArrayList<>();
        }
        product.setId(getNextId());
        try (FileWriter writer = new FileWriter(currentDirectory + "/" + FILE_NAME)) {
            products.add(product);
            gson.toJson(products, writer);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean saveToFile(List<Product> products) {
        if (products == null || products.size() == 0) {
            return false;
        }
        String currentDirectory = System.getProperty("user.dir");
        Gson gson = new Gson();

        try (FileWriter writer = new FileWriter(currentDirectory + "/" + FILE_NAME)) {
            gson.toJson(products, writer);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private int getNextId() {
        List<Product> products = getAll();
        if (products == null || products.size() == 0) {
            return 1;
        }
        int maxId = 1;
        for (Product product : products) {
            if (product.getId() > maxId) {
                maxId = product.getId();
            }
        }
        maxId += 1;
        return maxId;
    }
}
