package fluff.crypto.codec;

import java.util.HashMap;
import java.util.Map;

import fluff.crypto.codec.algorithms.Base64CodingAlgorithm;

public class Coding {
	
    private static final Map<String, CodingFunctions> REG = new HashMap<>();
    
    //public static final CodingFunctions BASE85 = register("base85", new Base64CodingAlgorithm());
    //public static final CodingFunctions BASE32 = register("base32", new Base64CodingAlgorithm());
    //public static final CodingFunctions BASE45 = register("base45", new Base64CodingAlgorithm());
    //public static final CodingFunctions BASE62 = register("base62", new Base64CodingAlgorithm());
    //public static final CodingFunctions BASE91 = register("base91", new Base64CodingAlgorithm());
    //public static final CodingFunctions BASE94 = register("base94", new Base64CodingAlgorithm());
    //public static final CodingFunctions BASE122 = register("base122", new Base64CodingAlgorithm());
    
    public static final CodingFunctions BASE64 = register("base64", new Base64CodingAlgorithm());
    
    //public static final CodingFunctions URL = register("url", new Base64CodingAlgorithm());
    
    public static CodingFunctions get(String name) {
        return REG.get(name);
    }
    
    public static boolean has(String name) {
        return REG.containsKey(name);
    }
    
    public static CodingFunctions register(String name, ICodingAlgorithm algorithm) {
    	CodingFunctions funcs = new CodingFunctions(algorithm);
        REG.put(name, funcs);
        return funcs;
    }
    
    public static boolean unregister(String name) {
        return REG.remove(name) != null;
    }
}
