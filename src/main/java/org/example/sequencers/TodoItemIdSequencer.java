package org.example.sequencers;

public class TodoItemIdSequencer {
    private static int currentId = 0;

    public static int nextId(){
        currentId += 1;
        return currentId;
    }
    public static int getCurrentId(){
        return currentId;
    }
    public static void setCurrentId(int id){
        currentId = id;
    }
}
