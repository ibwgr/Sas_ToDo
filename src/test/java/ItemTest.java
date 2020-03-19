import com.despegar.http.client.HttpResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ItemTest extends FunctionalTest{

    @Test
    public void getItemsIsOK(){
        HttpResponse httpResponse = this.executeGet("/items");

        Assert.assertEquals(200, httpResponse.code());


        String body = new String(httpResponse.body());
        List<Item> deserializedItems = new JSONSerializer().deserialize(body, new TypeReference<ArrayList<Item>>() {});


        Assert.assertEquals("Hello World Item", deserializedItems.get(0).description);

        System.out.println(httpResponse);
    }
}
