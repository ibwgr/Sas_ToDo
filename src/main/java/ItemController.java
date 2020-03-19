import spark.Service;

import java.util.ArrayList;
import java.util.List;

public class ItemController {

    public ItemController() {
    }
    public void createRoutes(Service server) {
        server.get("/items", (request, response) -> {

            response.type("application/json");

            List<Item> items = new ArrayList<>();
            Item item1 = new Item();
            item1.description = "Hello World Item";
            items.add(item1);

            return items;
        }, items -> new JSONSerializer().serialize(items));
    }


}