import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.reflect.*;


class Singleton{
    
    static Singleton singleton;
    public String str;
    
    private Singleton(){
        
    }
    
    public static Singleton getSingleInstance(){
        if (singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }
}