package fluff.crypto.hash;

import java.util.HashMap;
import java.util.Map;

import fluff.crypto.hash.algorithms.MD2HashingAlgorithm;
import fluff.crypto.hash.algorithms.MD5HashingAlgorithm;
import fluff.crypto.hash.algorithms.SHA3_224HashingAlgorithm;
import fluff.crypto.hash.algorithms.SHA3_256HashingAlgorithm;
import fluff.crypto.hash.algorithms.SHA3_384HashingAlgorithm;
import fluff.crypto.hash.algorithms.SHA3_512HashingAlgorithm;
import fluff.crypto.hash.algorithms.SHA_1HashingAlgorithm;
import fluff.crypto.hash.algorithms.SHA_224HashingAlgorithm;
import fluff.crypto.hash.algorithms.SHA_256HashingAlgorithm;
import fluff.crypto.hash.algorithms.SHA_384HashingAlgorithm;
import fluff.crypto.hash.algorithms.SHA_512HashingAlgorithm;

/**
 * A class for managing and providing various hashing algorithms.
 */
public class Hashing {
	
    private static final Map<String, HashingFunctions> REG = new HashMap<>();
    
    public static final HashingFunctions MD2 = register("md2", new MD2HashingAlgorithm());
    public static final HashingFunctions MD5 = register("md5", new MD5HashingAlgorithm());
    
    public static final HashingFunctions SHA_1 = register("sha-1", new SHA_1HashingAlgorithm());
    
    public static final HashingFunctions SHA_224 = register("sha-224", new SHA_224HashingAlgorithm());
    public static final HashingFunctions SHA3_224 = register("sha3-224", new SHA3_224HashingAlgorithm());
    
    public static final HashingFunctions SHA_256 = register("sha-256", new SHA_256HashingAlgorithm());
    public static final HashingFunctions SHA3_256 = register("sha3-256", new SHA3_256HashingAlgorithm());
    
    public static final HashingFunctions SHA_384 = register("sha-384", new SHA_384HashingAlgorithm());
    public static final HashingFunctions SHA3_384 = register("sha3-384", new SHA3_384HashingAlgorithm());
    
    public static final HashingFunctions SHA_512 = register("sha-512", new SHA_512HashingAlgorithm());
    public static final HashingFunctions SHA3_512 = register("sha3-512", new SHA3_512HashingAlgorithm());
    
    /**
     * Retrieves the hashing functions associated with the specified name.
     *
     * @param name the name of the hashing algorithm
     * @return the hashing functions associated with the specified name, or null if not found
     */
    public static HashingFunctions get(String name) {
        return REG.get(name);
    }
    
    /**
     * Checks if the specified hashing algorithm is registered.
     *
     * @param name the name of the hashing algorithm
     * @return true if the hashing algorithm is registered, false otherwise
     */
    public static boolean has(String name) {
        return REG.containsKey(name);
    }
    
    /**
     * Registers a new hashing algorithm with the specified name.
     *
     * @param name the name of the hashing algorithm
     * @param algorithm the hashing algorithm to register
     * @return the hashing functions associated with the registered algorithm
     */
    public static HashingFunctions register(String name, IHashingAlgorithm algorithm) {
    	HashingFunctions funcs = new HashingFunctions(algorithm);
        REG.put(name, funcs);
        return funcs;
    }
    
    /**
     * Unregisters the hashing algorithm associated with the specified name.
     *
     * @param name the name of the hashing algorithm
     * @return true if the hashing algorithm was successfully unregistered, false otherwise
     */
    public static boolean unregister(String name) {
        return REG.remove(name) != null;
    }
}
