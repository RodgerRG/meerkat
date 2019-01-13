package parsers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class JSONParser {
	
	public static HashMap<String, String> parseGitJSON(String json) {
		HashMap<String, String> out = new HashMap<>();
		
		List<String> pairs = Arrays.asList(json.split(","));
		for(String p : pairs) {
			String[] vals = p.split(":");
			
			//remove quotation marks if present
			for(String v : vals) {
				if(v.startsWith("\"")) {
					v = v.substring(1, v.length() - 1);
				}
			}
			
			out.put(vals[0], vals[1]);
		}
		
		return out;
	}
}
