package patterns;

import java.util.LinkedList;
import java.util.List;

public class ObjectPool {
    public static void main(String[] args) {
        ObjectPooled objectPooled = new ObjectPooled();
        PooledObject pooledObject = objectPooled.getPooledObject();
        objectPooled.releasePooledObject(pooledObject);
    }
}
class PooledObject{

}
class ObjectPooled{
    private List<PooledObject> free = new LinkedList<>();
    private List<PooledObject> used = new LinkedList<>();


    public PooledObject getPooledObject() {
     if (free.isEmpty()){
         PooledObject pooledObject = new PooledObject();
         free.add(pooledObject);
         return pooledObject;
     }else {
         PooledObject pooledObject = free.get(0);
         used.add(pooledObject);
         free.remove(pooledObject);
         return pooledObject;
     }
    }

    public void releasePooledObject(PooledObject pooledObject){
        used.remove(pooledObject);
        free.add(pooledObject);
    }
}