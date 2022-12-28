package main

import (
	"fmt"
)

func SumOfSquares(mychan, quitChan chan int) {
	i := 1
	for {
		select {
		case <-quitChan:
			fmt.Println("quiting...")
			return
		case mychan <- i * i:
			i += 1
			//default:
			//	mychan <- i * i
			//	i += 1
		}
	}
}

func main() {
	mychannel := make(chan int)
	quitchannel := make(chan int)
	sum := 0
	go func() {
		for i := 0; i < 5; i++ {
			sum += <-mychannel
		}
		fmt.Println(sum)
		quitchannel <- 1
	}()
	SumOfSquares(mychannel, quitchannel)
	close(mychannel)
	close(quitchannel)
}
