package main

import (
	"log"
)

func badCall() {
	a, b := 10, 0
	n := a / b
	println(n)
}

func test() {
	defer func() {
		if e, ok := recover().(error); ok {
			log.Printf("run time panic: %v", e)
		}
	}()
	badCall()
}

func main() {
	test()
}
