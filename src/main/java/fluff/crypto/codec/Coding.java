package fluff.crypto.codec;

import java.util.HashMap;
import java.util.Map;

import fluff.crypto.codec.algorithms.Base32CodingAlgorithm;
import fluff.crypto.codec.algorithms.Base64CodingAlgorithm;
import fluff.crypto.codec.algorithms.URLCodingAlgorithm;

/**
 * A utility class for managing and using various coding (encoding/decoding) algorithms.
 */
public class Coding {
	
    private static final Map<String, CodingFunctions> REG = new HashMap<>();
    
    // public static final CodingFunctions BASE85 = register("base85", new Base85CodingAlgorithm());
    // public static final CodingFunctions BASE45 = register("base45", new Base45CodingAlgorithm());
    // public static final CodingFunctions BASE62 = register("base62", new Base62CodingAlgorithm());
    // public static final CodingFunctions BASE91 = register("base91", new Base91CodingAlgorithm());
    // public static final CodingFunctions BASE94 = register("base94", new Base94CodingAlgorithm());
    // public static final CodingFunctions BASE122 = register("base122", new Base122CodingAlgorithm());
    
    public static final CodingFunctions BASE32 = register("base32", new Base32CodingAlgorithm());
    public static final CodingFunctions BASE64 = register("base64", new Base64CodingAlgorithm());
    public static final CodingFunctions URL = register("url", new URLCodingAlgorithm());
    
    /**
     * Retrieves the {@link CodingFunctions} associated with the specified name.
     *
     * @param name the name of the coding functions to retrieve
     * @return the {@link CodingFunctions} associated with the specified name, or {@code null} if not found
     */
    public static CodingFunctions get(String name) {
        return REG.get(name);
    }
    
    /**
     * Checks if a coding function with the specified name is registered.
     *
     * @param name the name of the coding function to check
     * @return {@code true} if the coding function is registered, {@code false} otherwise
     */
    public static boolean has(String name) {
        return REG.containsKey(name);
    }
    
    /**
     * Registers a new coding algorithm with the specified name.
     *
     * @param name the name to associate with the coding algorithm
     * @param algorithm the coding algorithm to register
     * @return the {@link CodingFunctions} created from the registered algorithm
     */
    public static CodingFunctions register(String name, ICodingAlgorithm algorithm) {
    	CodingFunctions funcs = new CodingFunctions(algorithm);
        REG.put(name, funcs);
        return funcs;
    }
    
    /**
     * Unregisters the coding algorithm associated with the specified name.
     *
     * @param name the name of the coding algorithm to unregister
     * @return {@code true} if the coding algorithm was successfully unregistered, {@code false} otherwise
     */
    public static boolean unregister(String name) {
        return REG.remove(name) != null;
    }
}
