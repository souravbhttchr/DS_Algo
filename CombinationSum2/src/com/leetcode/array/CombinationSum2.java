package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

	List<List<Integer>> ans=new ArrayList();
	public static void main(String[] args) {
		int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
		int target = 8;
		System.out.println(new CombinationSum2().combinationSum2(candidates, target));
	}

	public List<List<Integer>> combinationSum2(int[] arr, int target) {
		Arrays.sort(arr);
		combinationSum_(arr,target,0,new ArrayList());
		return ans;
	}

	public void combinationSum_(int[] arr,int tar,int idx,List<Integer> list){
		if(tar==0){
			ans.add(new ArrayList<>(list));
			return;
		}
		for(int i=idx;i<arr.length;i++){
			if(tar-arr[i]>=0){
				list.add(arr[i]);
				combinationSum_(arr,tar-arr[i],i+1,list);
				list.remove(list.size()-1);
			}
			while(i+1<arr.length && arr[i+1]==arr[i])
				i++;
		}
	}
}
