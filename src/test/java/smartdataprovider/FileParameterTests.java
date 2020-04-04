package smartdataprovider;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;


import static smartdataprovider.DataSource.Type.RESOURCE;

@RunWith(DataProviderRunner.class)
public class FileParameterTests  {

    @Test
    @UseDataProvider(value = "dataSourceLoader", location = UniversalDataProvider.class)
    @DataSource(value = "/user.data", type = RESOURCE)
    public void test1(String user, String password) {
        System.out.println(user + ":" + password);
    }

}