package am.bibliographic.entity;

public interface Entity {
   int getId();
   default boolean hasRequiredObjects(Object... fields){
      for(Object o : fields)
         if(o == null) return false;
      return true;
   }
   default boolean hasRequiredIndexed(int... indexes){
      for(int i : indexes)
         if(i == 0) return false;
      return true;
   }
}
