import  org.junit.*;

public class TestClass {

    @Test
    public void testKarel(){
        String expected = "Karel";
        System.out.println(JSON.getStudent(12345678).getNaam());
        Assert.assertEquals( expected, JSON.getStudent(12345678).getNaam());

    }
}