package productcontroller;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import productentity.Product;
import productservice.ProductService;

import java.util.List;

@RestController
@RequestMapping("request/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/viewAll")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/categories/{cat_name}")
    public List<Product> getByCategoryName(@PathVariable String cat_name){

        return productService.getByCategoryName(cat_name);
    }
    @GetMapping("/tags/{tagname}")
    public  List<Product> getByTagName(@PathVariable String tagname){
        return productService.getByTagName(tagname);
    }

    @PostMapping("/init")
    public String initializeData(){
        productService.initializeData();
        return "Data initialized";
    }

    @GetMapping("/hello")
    public String test(){
        return "hello";
    }
    @PostConstruct
    public void init() {
        System.out.println("ProductController initialized");
    }


}
