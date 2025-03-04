package productrepository;

import productentity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepo extends MongoRepository<Product, String> {

    List<Product> findByCategoriesName(String catName);
    List<Product> findByTags(String tagName);
}
