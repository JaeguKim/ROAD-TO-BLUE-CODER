package main

func isAnagram(s string, t string) bool {
	m1 := getMp(s)
	m2 := getMp(t)
	if len(m1) != len(m2) {
		return false
	}
	for k := range m1 {
		if m1[k] != m2[k] {
			return false
		}
	}
	return true
}

func getMp(s string) map[uint8]int{
	var mp = make(map[uint8]int)
	for i:=0; i<len(s); i++ {
		mp[s[i]] += 1
	}
	return mp
}

func main() {
	res := isAnagram("anagram","nagaram")
	println(res)
	res = isAnagram("rat","car")
	println(res)
}
