package com.guppy.action;

public class GTPAnswer {
	
	String result;
	
	public static String answerToThink() {
		return "{\"actions_to_perform\":[{\"action_id\":1,\"action_name\":\"endpt-call-chatgtp-topic\"},{\"action_id\":2,\"action_name\":\"create-text-file\"}]}";

	}
	
	public static String answerToTopicQuery() {
		return "Stephen William Hawking (8 January 1942 – 14 March 2018) was an English theoretical physicist, cosmologist, and author who was director of research at the Centre for Theoretical Cosmology at the University of Cambridge.[6][17][18] Between 1979 and 2009, he was the Lucasian Professor of Mathematics at Cambridge, widely viewed as one of the most prestigious academic posts in the world";

	}

}
