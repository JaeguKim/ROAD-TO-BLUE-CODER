package main

import (
	"fmt"
	"log"
)

func main() {
	err := fmt.Errorf("test error")
	logger := log.Logger{}
	logger.Output(4, fmt.Sprintf("%v", err))
	logger.Output(4, fmt.Sprintf("%+v", err))
	//log.Printf("%+v", err)
}
