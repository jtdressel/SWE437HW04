//fmtRewrap.java
//James Dressel
public class fmtRewrap {
	static public String fmtRewrap(String input, int width){

		StringBuilder build = new StringBuilder();
		StringBuilder line = new StringBuilder();
		String[] words = input.split(" ");
		exceptionCheck(input, width);

		for(String word:words){
			int projectedLength = line.length()+word.length()+1;
			
			if(line.length()==0){
				//nothing in the line
				line.append(word);
			} else if(projectedLength<width){
				line.append(" ");
				line.append(word);
			} else{
				build.append(line.toString());
				build.append("\n");
				line = new StringBuilder(word);
				
			}
			
			
		} 
		build.append(line.toString());
		
		newLineFormater(build);
		

		return build.toString();
	}

	private static void newLineFormater(StringBuilder build) {
		if(build.lastIndexOf("\n")!=build.length()-1){
			build.append("\n");	
		}
	}
	
	private static void exceptionCheck(String input, int width){
		if (input== null){
			throw new NullPointerException("The input string must not be null");
		}
		
		if (width <1){
			throw new IllegalArgumentException("Width must be at least 1");
		}
	}
	

}