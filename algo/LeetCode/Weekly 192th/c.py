#30min
#코드를 더 깔끔하게 작성하여 라인수를 줄이고 더 간결하게 표현할수 있다.
class BrowserHistory:

    def __init__(self, homepage: str):
        self.history = [homepage]
        self.curIdx = -1

    def visit(self, url: str) -> None:
        self.history = self.history[:min(self.curIdx+2,len(self.history))]
        self.history.append(url)
        self.curIdx = len(self.history)-2

    def back(self, steps: int) -> str:
        x = max(self.curIdx-steps+1,0)
        lastHist = self.history[x]
        self.curIdx = x-1
        return lastHist

    def forward(self, steps: int) -> str:
        x = self.curIdx+steps+1
        x = min(self.curIdx+steps+1,len(self.history)-1)
        lastHist = self.history[x]
        self.curIdx = x-1
        return lastHist

obj = BrowserHistory("leetcode.com")
obj.visit("google.com")
obj.visit("facebook")
obj.visit("youtube")
obj.back(1)
obj.back(1)
obj.forward(1)
obj.visit("linkedin")
obj.forward(2)
obj.back(2)
obj.back(7)
