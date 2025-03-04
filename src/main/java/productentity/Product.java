package productentity;

import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "epd_data")
public class Product {
    @Id
    private String id;
    private String uuid;
    private String name;
    private List<productentity.Category> categories;  // This should use your Category class
    private List<String> tags;
    public Product(String uuid, String name, List<productentity.Category> categories, List<String> tags) {
        this.uuid = uuid;
        this.name = name;
        this.categories = categories;
        this.tags = tags;
    }

}
