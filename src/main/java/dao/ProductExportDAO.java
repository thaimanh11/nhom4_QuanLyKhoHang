package dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import entity.ProductExport;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ProductExportDAO {

    public static String FILE_NAME = "productExports.json";

    public List<ProductExport> getAll() {
        String currentDirectory = System.getProperty("user.dir");
        Gson gson = new Gson();
        List<ProductExport> ProductExports = new ArrayList();
        String path = currentDirectory + "/" + FILE_NAME;
        File file = new File(path);
        if (!file.exists()) {
            saveToFile(ProductExports);
            return ProductExports;
        }
        try (FileReader reader = new FileReader(path)) {
            Type userListType = new TypeToken<List<ProductExport>>() {
            }.getType();
            ProductExports = gson.fromJson(reader, userListType);
            if (ProductExports == null) {
                ProductExports = new ArrayList();
            }
            return ProductExports;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ProductExports;
    }

    public boolean insert(ProductExport productExport) {
        if (productExport == null) {
            return false;
        }
        String currentDirectory = System.getProperty("user.dir");
        Gson gson = new Gson();
        List<ProductExport> productExports = getAll();
        if (productExports == null) {
            productExports = new ArrayList<>();
        }
        productExport.setId(getNextId());
        try (FileWriter writer = new FileWriter(currentDirectory + "/" + FILE_NAME)) {
            productExports.add(productExport);
            gson.toJson(productExports, writer);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean saveToFile(List<ProductExport> ProductExports) {
        if (ProductExports == null || ProductExports.size() == 0) {
            return false;
        }
        String currentDirectory = System.getProperty("user.dir");
        Gson gson = new Gson();

        try (FileWriter writer = new FileWriter(currentDirectory + "/" + FILE_NAME)) {
            gson.toJson(ProductExports, writer);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private int getNextId() {
        List<ProductExport> productExports = getAll();
        if (productExports == null || productExports.size() == 0) {
            return 1;
        }
        int maxId = 1;
        for (ProductExport ProductExport : productExports) {
            if (ProductExport.getId() > maxId) {
                maxId = ProductExport.getId();
            }
        }
        maxId += 1;
        return maxId;
    }
}
