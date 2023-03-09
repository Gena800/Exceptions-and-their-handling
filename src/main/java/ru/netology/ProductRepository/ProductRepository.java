package ru.netology.ProductRepository;

import ru.netology.Product.Product;
import ru.netology.exceptions.AlreadyExistsException;
import ru.netology.exceptions.NotFoundException;

public class ProductRepository {
    private Product[] products = new Product[0];

    public Product[] findAll() {
        return products;
    }

    public void save(Product product) {
        if (findById(product.getId()) != null) {
            throw new AlreadyExistsException(product.getId());
        }
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }
    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void removeById(int id) {
        if(findById(id) == null) {
            throw new NotFoundException(id);
        }
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }

        }
        products = tmp;
    }


}