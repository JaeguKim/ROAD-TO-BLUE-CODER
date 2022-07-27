package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func flatten(root *TreeNode) {
	if root == nil {
		return
	}
	var slices []*TreeNode
	preOrder(&slices,root)
	for i:=0; i<len(slices)-1; i++ {
		slices[i].Left = nil
		slices[i].Right = slices[i+1]
	}
	last := slices[len(slices)-1]
	last.Left = nil
	last.Right = nil
}

func preOrder(slices *[]*TreeNode, node *TreeNode) {
	if node == nil {
		return
	}
	*slices = append(*slices,node)
	preOrder(slices,node.Left)
	preOrder(slices,node.Right)
}

func main() {
	parent := new(TreeNode)
	parent.Val = 2
	n1 := new(TreeNode)
	n1.Val = 1
	n2 := new(TreeNode)
	n2.Val = 3
	parent.Left = n1
	parent.Right = n2
	flatten(parent)
}
