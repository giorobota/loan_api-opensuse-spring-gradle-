//package LoanformTests;
//
//
//import main.AppController;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class test1 {
//
//    @Autowired
//    private TestRestTemplate template;
//
//    private static final String baseUrl = "http://localhost:8080/";
//
//    @Test
//    public void indexMessage() throws Exception {
//        System.out.println("starting index test");
//        assert(this.template.getForObject(baseUrl, String.class).contains("loan form api"));
//    }
//
//
//}