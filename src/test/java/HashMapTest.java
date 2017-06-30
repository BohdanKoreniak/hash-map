import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Bohdan on 30.06.2017.
 */
public class HashMapTest extends Assert
{
    private HashMap<Integer, Long> hashMap;

    private int key1;
    private int key2;
    private int key3;

    private long value1;
    private long value2;
    private long value3;
    private long value4;

    @Before
    public void initial()
    {
        hashMap = new HashMap<Integer, Long>(16);

        key1 = 753;
        key2 = 16;
        key3 = 1027;

        value1 = 45007800L;
        value2 = 9902200L;
        value3 = 7600160080L;
        value4 = 9902200L;

        hashMap.put(key1, value1);
        hashMap.put(key2, value2);
        hashMap.put(key3, value3);

        hashMap.put(key1, value4);
    }

    @Test
    public void testGet()
    {
        assertNotEquals("Getting value by key", value1, (long) hashMap.get(key1));

        assertEquals("Getting value by key", value2, (long) hashMap.get(key2));
        assertEquals("Getting value by key", value3, (long) hashMap.get(key3));
        assertEquals("Getting value by key", value4, (long) hashMap.get(key1));

        assertEquals("Getting value by wrong key", null, hashMap.get(key1 + key2 + key3));
    }

    @Test
    public void testDelete()
    {
        assertTrue("Deleting pair by key", hashMap.delete(key1));
        assertTrue("Deleting pair by key", hashMap.delete(key3));

        assertEquals("Getting value by wrong key", null, hashMap.get(key1));
        assertEquals("Getting value by wrong key", null, hashMap.get(key3));

        assertEquals("Getting size of the map", 1, hashMap.size());
    }

    @Test
    public void testSize()
    {
        assertEquals("Getting size of the map", 3, hashMap.size());
    }
}
