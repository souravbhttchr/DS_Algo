package com.main;

import java.util.LinkedList;
import java.util.Queue;

public class TurnstileTimer {

	public static int[] turnstile(int[] time, int[] direction){
	    int[] result = new int[time.length];

	    boolean used = false, out = true;
	    int timer = 0, i = 0;
	    Queue<Integer> iq = new LinkedList();
	    Queue<Integer> oq = new LinkedList();

	    while (i < time.length || !iq.isEmpty() || !oq.isEmpty()){

	        while (i < time.length && timer == time[i]){
	            // enter
	            if (direction[i] == 0){
	                iq.offer(i);
	            }else{
	                oq.offer(i);
	            }
	            i++;
	        }


	        // for people in the queue, process which one go first
	        if (!iq.isEmpty() || !oq.isEmpty()){

	            // if not used, person wants to get out go first
	            if (!used){

	                if (!oq.isEmpty()){
	                    result[oq.poll()] = timer;
	                    out = true;
	                }else{
	                    result[iq.poll()] = timer;
	                    out = false;
	                }
	                used = true;

	            // if used, determine by the previous used direction
	            }else{

	                if (out && !oq.isEmpty()){
	                    result[oq.poll()] = timer;
	                    out = true;
	                }else{
	                    result[iq.poll()] = timer;
	                    out = false;
	                }
	            }
	        }else{
	            // if no one in the queue, reset used = false
	            used = false;
	        }

	        timer++;
	    }


	    return result;
	}

}
