package pl.wiktor.reflectiontest;


import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ReflectionPrivateTest {


    @Test
    void shouldReturnNotNullResource() {
        MyResource resource = new MyResource("test");
        assertNotNull(resource.getResource());
    }

    @Test
    void shouldReturnNotNullResourceLinkString() throws Exception {
        ResourceConsumer consumer = new ResourceConsumer();

        Field field = ResourceConsumer.class.getDeclaredField("resource");
        field.setAccessible(true);
        field.set(consumer, new MyResource("test"));

        Method method = ResourceConsumer.class.getDeclaredMethod("getResourceLink");
        method.setAccessible(true);

        assertNotNull(method.invoke(consumer));
    }

    @Test
    void shouldReturnEnhancedLink() throws Exception{

        ResourceConsumer consumer = new ResourceConsumer();

        Field field = ResourceConsumer.class.getDeclaredField("resource");
        field.setAccessible(true);
        field.set(consumer, new MyResource("test"));


        assertNotNull(consumer.obtainEnhancedLink());

        assertEquals("http://localhost:80/resource/test/enhanced", consumer.obtainEnhancedLink());

    }



}
