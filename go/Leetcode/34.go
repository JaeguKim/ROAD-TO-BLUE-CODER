package main

import (
	"fmt"
)

func searchRange(nums []int, target int) []int {
	start := getL(nums,target)
	if start == -1 {
		return []int{-1,-1}
	}
	end := getR(nums,start,target)
	return []int{start,end}
}

func getL(nums []int, target int) int {
	var left = 0
	var right = len(nums)-1
	var start = -1
	for left <= right {
		var mid = (left+right)/2
		if nums[mid] == target {
			start = mid
		}
		if nums[mid] < target {
			left = mid+1
		} else {
			right = mid-1
		}
	}
	return start
}

func getR(nums []int, start int, target int) int {
	var left = start
	var right = len(nums)-1
	var end = -1
	for left <= right {
		var mid = (left+right)/2
		if nums[mid] == target {
			end = mid
			left = mid+1
		}
		if nums[mid] > target {
			right = mid-1
		}
	}
	return end
}

func main() {
	res := searchRange([]int{5,7,7,8,8,10},8)
	fmt.Printf("%d,%d\n",res[0],res[1])
	res = searchRange([]int{5,7,7,8,8,10},6)
	fmt.Printf("%d,%d\n",res[0],res[1])
	res = searchRange([]int{},0)
	fmt.Printf("%d,%d\n",res[0],res[1])
}
