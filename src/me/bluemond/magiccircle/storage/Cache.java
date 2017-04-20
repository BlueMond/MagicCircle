package me.bluemond.magiccircle.storage;

import java.util.AbstractMap;
import java.util.HashMap;

/**
 * Created by Cooper on 4/12/2017.
 */
public abstract class Cache  {
    private final String directory = "MagicCircle";
    protected AbstractMap<Object, Object> data;
    private Class key;
    private Class value;
    private String file;


    public Cache(Class key, Class value, String file){
        data = new HashMap<Object, Object>();
        this.key = key;
        this.value = value;
        this.file = file;

    }


    public void setEntry(Object sKey, Object sValue){

        //check if compatible key and value class
        if(key.isInstance(sKey) && value.isInstance(sValue)){

            //set
            data.put(sKey, sValue);
        }
    }



    public Object getEntry(Object sKey){

        //check if key compatible
        if(key.isInstance(sKey)){

            //return
            return data.get(sKey);
        }

        return null;
    }


    public void saveData(String[] keys, String[] values){

        /*
        Todo
        Write all current data to file specified
         */
    }

    public void loadData(){

        /*
        Todo
        This will most likely be an interface handled by the subclass

        or could return two String arrays (like it receives when saving)
        and be called by the subclass
         */
    }
}
