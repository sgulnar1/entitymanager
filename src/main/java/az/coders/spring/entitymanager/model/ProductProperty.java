package az.coders.spring.entitymanager.model;

import az.coders.spring.entitymanager.entity.Category;

import java.util.List;
import java.util.Map;

public class ProductProperty {
    private String name;
    private List<Category> categories;
    private Map<String, Integer> sales;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Map<String, Integer> getSales() {
        return sales;
    }

    public void setSales(Map<String, Integer> sales) {
        this.sales = sales;
    }
}
