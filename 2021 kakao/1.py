def solution(new_id):
    lower_case_id = new_id.lower()
    legalChars = ['-','_','.']
    new_id = new_id.lower()
    resId = ''
    for i in range(len(new_id)):
        if new_id[i].isalpha() or new_id[i].isdigit() or new_id[i] in legalChars:
            resId += new_id[i]
    while '..' in resId: resId = resId.replace('..','.')
    if resId[0] == '.':
        resId = resId[1:]
    if resId[-1] == '.':
        resId = resId[:len(resId)-1]
    if resId == '':
        resId += 'a'
    if len(resId) >= 16:
        resId = resId[:15]
    if resId[-1] == '.':
        resId = resId[:len(resId)-1]
    if len(resId) <= 2:
        while len(resId) <= 2: resId += 'a'
    return resId


def test(tcs):
    for tc in tcs:
        res = solution(tc)
        print(res)
tcs = ["...!@BaT#*..y.abcdefghijklm"]
test(tcs)