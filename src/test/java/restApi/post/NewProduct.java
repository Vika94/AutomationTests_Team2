package restApi.post;

import lombok.Data;

@Data
public class NewProduct {
    public int quantity;
    public String position_id;
    public int shop_id;
    public int product_id;
    public String product_key;
}