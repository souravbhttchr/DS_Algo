package com.main;

public class ModifiedSignalCount {

	public static void main(String[] args) {
		System.out.println(countChanges("SOSSOT"));
	}
	
	public static int countChanges(String message) {
        String sos = "SOS";
        int count = 0;
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) != sos.charAt(i % 3)) count++;
        }
        return count;
    }
}
