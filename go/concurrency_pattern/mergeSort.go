package main

import (
	"fmt"
)

func Merge(left, right []int) []int {
	merged := make([]int, 0, len(left)+len(right))
	for len(left) > 0 || len(right) > 0 {
		if len(left) == 0 {
			return append(merged, right...)
		} else if len(right) == 0 {
			return append(merged, left...)
		} else if left[0] < right[0] {
			merged = append(merged, left[0])
			left = left[1:]
		} else {
			merged = append(merged, right[0])
			right = right[1:]
		}
	}
	return merged
}

func MergeSort(data []int) []int {
	if len(data) <= 1 {
		return data
	}

	mid := len(data) / 2
	leftDoneCh := make(chan bool)
	var left []int
	go func() {
		left = MergeSort(data[:mid])
		leftDoneCh <- true
	}()
	var right []int
	rightDoneCh := make(chan bool)
	go func() {
		right = MergeSort(data[mid:])
		rightDoneCh <- true
	}()
	<-leftDoneCh
	<-rightDoneCh
	sortedArr := Merge(left, right)
	return sortedArr
}

func main() {
	data := []int{9, 4, 3, 6, 1, 2, 10, 5, 7, 8}
	fmt.Printf("%v\n%v\n", data, MergeSort(data))
}
