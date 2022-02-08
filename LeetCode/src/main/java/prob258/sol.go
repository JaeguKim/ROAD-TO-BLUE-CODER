func addDigits(num int) int {
	for num >= 10 {
		s := strconv.Itoa(num)
		num = 0
		for _,ch := range s {
			num += int(ch)-int('0')
		}
	}
	return num
}