package com.bestbuy.bestbuyinfo;

import com.bestbuy.testbase.ServicesTestBase;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

@RunWith(SerenityRunner.class)
public class ServicesCURDTestWithSteps extends ServicesTestBase {
    static String name  = "Electronic Shop";
    static int servicesID;


    @Steps
    ServicesSteps servicesSteps;

    @Title("This will create new store")
    @Test
    public void test001(){
        ValidatableResponse response = servicesSteps.createService(name);
        response.log().all().statusCode(201);
    }

    @Title("Verify if the services is created")
    @Test
    public void test002(){
        HashMap<String, Object> value = servicesSteps.getServicesInfoByName(name);
        Assert.assertThat(value, hasValue(name));
        servicesID = (int) value.get("id");
    }

    @Title("Update Service information and verify the updated information")
    @Test
    public void test003() {
        name = name + "_updated ";
        servicesSteps.updateService(name, servicesID);
        HashMap<String, Object> value = servicesSteps.getServicesInfoByName(name);
        Assert.assertThat(value, hasValue(name));
    }
    @Title("Delete Service and verify if the Service is deleted")
    @Test
    public void test004() {
        servicesSteps.deleteService(servicesID).statusCode(200);
        servicesSteps.getServiceById(servicesID).statusCode(404);
    }
}
