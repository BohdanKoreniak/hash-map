/**
 * Created by Bohdan on 30.06.2017.
 */
public class HashMap<K, V>
{
    private Pair<K, V>[] hashTable;

    private int amountOfPairs;

    public HashMap()
    {
        hashTable = new Pair[16];
    }

    public HashMap(int tableSize)
    {
        hashTable = new Pair[tableSize];
    }

    public void put(K key, V value)
    {
        int hashCode = getHashCode(key);

        int i = hashCode;
        while (i < hashTable.length)
        {
            if (hashTable[i] == null)
            {
                hashTable[i] = new Pair(key, value);
                amountOfPairs++;
                return;
            }
            else if (hashTable[i].key.equals(key))
            {
                hashTable[i] = new Pair(key, value);
                return;
            }
            i++;
        }

        i = 0;
        while (i != hashCode)
        {
            if (hashTable[i] == null)
            {
                hashTable[i] = new Pair(key, value);
                amountOfPairs++;
                return;
            }
            else if (hashTable[i].key.equals(key))
            {
                hashTable[i] = new Pair(key, value);
                return;
            }
            i++;
        }
    }

    public boolean delete(K key)
    {
        int hashCode = getHashCode(key);

        int i = hashCode;
        while (i < hashTable.length)
        {
            if (hashTable[i] != null && key.equals(hashTable[i].key))
            {
                hashTable[i] = null;
                amountOfPairs--;
                return true;
            }
            i++;
        }

        i = 0;
        while (i != hashCode)
        {
            if (hashTable[i] != null && key.equals(hashTable[i].key))
            {
                hashTable[i] = null;
                amountOfPairs--;
                return true;
            }
            i++;
        }

        return false;
    }

    public V get(K key)
    {
        int hashCode = getHashCode(key);

        int i = hashCode;
        while (i < hashTable.length)
        {
            if (hashTable[i] != null && key.equals(hashTable[i].key))
            {
                return hashTable[i].value;
            }
            i++;
        }

        i = 0;
        while (i != hashCode)
        {
            if (hashTable[i] != null && key.equals(hashTable[i].key))
            {
                return hashTable[i].value;
            }
            i++;
        }

        return null;
    }

    public int size()
    {
        return amountOfPairs;
    }

    private int getHashCode(K key)
    {
        return key.hashCode() % hashTable.length;
    }

    private class Pair<K, V>
    {
        private K key;
        private V value;

        public Pair(K key, V value)
        {
            this.key = key;
            this.value = value;
        }
    }
}
