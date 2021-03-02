#TIME : 50min
class Solution:
    def validIPAddress(self, IP: str) -> str:
        ipv4_nums = IP.split('.')
        ipv6_nums = IP.split(':')
        isValid = True
        if len(ipv4_nums) == 4:
            for elem in ipv4_nums:
                if elem.isnumeric():
                    num = int(elem)
                    if len(elem) >= 2 and elem[0] == '0':
                        isValid = False
                        break
                    if num<0 or num>255:
                        isValid = False
                        break
                else:
                    isValid = False
                    break
            if isValid:
                return 'IPv4'
        elif len(ipv6_nums) == 8:
            for elem in ipv6_nums:
                if len(elem) == 0 or len(elem) > 4:
                    isValid = False
                    break
                for hex in elem:
                    if hex.isalpha() == True:
                        if hex.islower():
                            if ord(hex) < ord('a') or ord(hex) > ord('f'):
                                isValid = False
                                break
                        elif hex.isupper():
                            if ord(hex) < ord('A') or ord(hex) > ord('F'):
                                isValid = False
                                break
                    elif hex.isnumeric() == False:
                        isValid = False
                        break
 
            if isValid:
                return 'IPv6'
        return 'Neither'
        
            