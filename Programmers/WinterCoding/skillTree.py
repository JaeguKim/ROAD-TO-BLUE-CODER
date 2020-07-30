def solution(skill, skill_trees):
    ans = 0
    for skillTree in skill_trees:
        ans+=1
        idx = 0
        for ch in skillTree:
            if ch in skill and idx < len(skill):
                if skill[idx] != ch:
                    ans-=1
                    break
                else:
                    idx+=1
    return ans

def test(tcs):
    for tc in tcs:
        res = solution(tc[0],tc[1])
        print(res)

tcs = [["CBD",["BACDE", "CBADF", "AECB", "BDA"]]]
test(tcs)