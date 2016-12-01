package com.adoblas.cuke.stepDefintions.step;

import com.adoblas.cuke.stepDefintions.util.RestClientContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.javacrumbs.jsonunit.core.Option;
import org.springframework.beans.factory.annotation.Value;

import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.assertj.core.api.Assertions.assertThat;


@ContextConfiguration("classpath:cucumber.xml")
public class CommonStepsDef {


    @Value("${api.host}")
    private String apiHost;

    @Autowired
    protected RestClientContext restClientContext;

    private ClientResponse clientResponse;

    private Client client = new Client();


    @When("^I send a GET request to \"(.+)\"$")
    public void iSendAGetRequestTo(String uri) {
        WebResource webResource = client.resource(apiHost + uri);
        restClientContext.setResponse(webResource.get(ClientResponse.class));
    }

    @Then("^the response status should be (\\d+)$")
    public void theResponseStatusShouldBe(int statusCode) {
        clientResponse = restClientContext.getResponse();
        assertThat(clientResponse.getStatus()).isEqualTo(statusCode);
    }

    @And("^the JSON response should be$")
    public void theJSONResponseShouldBe(String expected) {
        System.out.println("-----------------------------------");
        System.out.println(restClientContext.getResponseJson());
        assertThatJson(restClientContext.getResponseJson()).when(Option.IGNORING_ARRAY_ORDER).isEqualTo(expected);
    }

    @And("^the JSON response should contain the key \"(.*?)\" and value \"(.*?)\"$")
    public void theJSONResponseShouldContainTheKeyAndValue(String key, Object value) {
        String entity = clientResponse.toString();
        try {
            ObjectNode node = (ObjectNode) new ObjectMapper().readTree(entity);
            assertThat(node.get(key).asText()).isEqualTo(value);
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }

    @Then("^the JSON response should contain the value \"(.*?)\"$")
    public void theJSONResponseShouldContainTheValue(String value){
        String entity = clientResponse.toString();
        try {
            ObjectNode node = (ObjectNode) new ObjectMapper().readTree(entity);
            assertThat(node.findValue(value)).isNotNull();
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }

    @Then("^the response should contain the text \"(.*?)\"$")
    public void textResponseShouldContainTheValue(String value){
        String entity = clientResponse.toString();
        try {
            assertThat(entity.contains(value));
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }


}
