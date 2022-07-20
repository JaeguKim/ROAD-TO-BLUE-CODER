package main

import (
	"fmt"
)

// TC : O(n^2)
// SC : O(n^2)
func main() {
	res := generate(5)
	for i:=0; i<len(res); i++ {
		for j:=0; j<len(res[i]); j++ {
			fmt.Printf("%d ",res[i][j])
		}
		println()
	}
}

func generate(numRows int) [][]int {
	var res = make([][]int, numRows)
	for i:=0; i<numRows; i++ {
		res[i] = make([]int,i+1)
		for j:=0; j<i+1; j++ {
			if j == 0 || j == i {
				res[i][j] = 1
			} else {
				res[i][j] = res[i-1][j-1] + res[i-1][j]
			}
		}
	}
	return res
}