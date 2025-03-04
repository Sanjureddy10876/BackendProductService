package productservice;

import org.springframework.stereotype.Service;
import productentity.Category;
import productentity.Product;
import productrepository.ProductRepo;

import java.util.List;


@Service
public class ProductService {
    private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }

    public List<Product> getByCategoryName(String categoryName){
        return productRepo.findByCategoriesName(categoryName);
    }

    public List<Product> getByTagName(String tagName){
        return productRepo.findByTags(tagName);
    }


    public void initializeData() {
        if (productRepo.count() == 0) {
            Product p1 = new Product("0d835b0d-4d4e-46cc-88e1-5169f638f6dc", "Paint",
                    List.of(new Category(1, "Coverings"), new Category(3, "End product")),
                    List.of("new-product"));

            Product p2 = new Product("57f318aa-75ee-4b4b-a7c0-e17400b91897", "Mortar",
                    List.of(new Category(2, "Building products"), new Category(3, "End product")),
                    null);

            Product p3 = new Product("75ee-4baa-0d835bb-a7c0-e174005169f7", "Expanded cork",
                    List.of(new Category(4, "Insulation"), new Category(2, "Building products")),
                    List.of("bio-based"));

            productRepo.saveAll(List.of(p1, p2, p3));
        }
    }


}
