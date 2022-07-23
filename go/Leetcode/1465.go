package main

import (
	"math"
	"sort"
)

func maxArea(h int, w int, horizontalCuts []int, verticalCuts []int) int {
	sort.Ints(horizontalCuts)
	sort.Ints(verticalCuts)
	var maxW = horizontalCuts[0]
	for i:=1; i<=len(horizontalCuts); i++ {
		var curW = 0
		if i == len(horizontalCuts) {
			curW = h-horizontalCuts[i-1]
		} else {
			curW = horizontalCuts[i]-horizontalCuts[i-1]
		}
		maxW = int(math.Max(float64(maxW), float64(curW)))
	}
	var maxH = verticalCuts[0]
	for i:=1; i<=len(verticalCuts); i++ {
		var curH = 0
		if i == len(verticalCuts) {
			curH = w-verticalCuts[i-1]
		} else {
			curH = verticalCuts[i]-verticalCuts[i-1]
		}
		maxH = int(math.Max(float64(maxH),float64(curH)))
	}
	return (maxW * maxH) % 1000000007
}

func maxArea2(h int, w int, horizontalCuts []int, verticalCuts []int) int {
	horizontalCuts = append(horizontalCuts, []int{0,h}...)
	verticalCuts = append(verticalCuts, []int{0,w}...)

	sort.Ints(horizontalCuts)
	sort.Ints(verticalCuts)

	maxH, maxV := 0,0

	for i := 1; i < len(horizontalCuts); i++ {
		maxH = max(maxH, horizontalCuts[i]-horizontalCuts[i-1])
	}

	for i :=1; i < len(verticalCuts); i++ {
		maxV = max(maxV, verticalCuts[i]-verticalCuts[i-1])
	}

	return (maxH * maxV) % 1000000007
}

func max(a,b int) int {
	if a > b { return a }
	return b
}

func main() {
	res := maxArea(5,4,[]int{1,2,4},[]int{1,3})
	println(res)
	res = maxArea(5,4,[]int{3,1},[]int{1})
	println(res)
}
