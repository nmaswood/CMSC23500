package uchidb;

import java.util.List;
import java.util.Map;
import java.util.Set;

import java.util.HashSet;
import java.util.ArrayList;

import java.util.HashMap;

import java.util.Arrays;



/**
 * @author aelmore
 */

public class HW0Runner implements Containers<Integer, String>{



   	private static Containers<Integer, String> instance;
   	private static Map<String,Integer> storedMap;

	// This class is a factory for a singleton containers class.
	// https://www.tutorialspoint.com/java/java_using_singleton.htm


	//Containers<T, S> 

	public Set<Integer> initSet(Integer[] tArray){

		Set<Integer> set = new HashSet<Integer>(Arrays.asList(tArray));

		return set;
	}
	
	//Create a list that stores an the array of T objects

	public List<Integer> initList(Integer[] tArray){

		List<Integer> list = new ArrayList<Integer>(Arrays.asList(tArray));

		return list;

	}
	
	//Create an empty map that will use type S as keys, and T as values

	public Map<String,Integer> initEmptyMap(){

		Map<String, Integer> newMap = new HashMap<String, Integer>();

		return newMap;
	}
	
	//Store the map in a local field variable -- often called a setter 
	public void storeMap(Map<String,Integer> mapToStoreInClass){
		storedMap = mapToStoreInClass;
	}
	

	// Add a key value to the stored/local map with a boolean indicating whether to overwrite existing value
	// The return value indicates if you added the key value pair to the map
	// You do not need to check if the value changed or not (e.g. no need to compare values)

	public boolean addToMap(String key, Integer value, boolean overwriteExistingKey){

		// if the map doesn't contian the key just store key:value

		if (!storedMap.containsKey(key)){
			storedMap.put(key, value);
			return true;
		}

		// if overwrite is set then overwrite whatever value is present

		if (overwriteExistingKey){
			storedMap.put(key,value);
			return true;
		}

		// otherwise do nothing

		return false;
	}
	
	//get a value based on a key
	public Integer getValueFromMap(String key){

		return storedMap.get(key);
	}
	
	//an overloaded function to get value from map but with a default value
	//if the key is not present

	public Integer getValueFromMap(String key, Integer defaultValue){

		return storedMap.containsKey(key)? storedMap.get(key): defaultValue;

	}

	public static Containers<Integer, String> getContainers() {

		if (instance == null) {
			instance = new HW0Runner();
			storedMap = new HashMap<String,Integer>();
		}

		return instance;
	}

	public static void main(String[] args){
		
	}
}
