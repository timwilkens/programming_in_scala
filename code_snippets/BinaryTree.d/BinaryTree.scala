import node.Node

class BinaryTree(nodes: Array[Int]) {

  require(nodes.size > 0)
  val root = new Node(nodes(0))

  for (n <- (1 to nodes.size - 1).map(nodes(_))) {
    var node = new Node(n)
    add(node)
  }

  def add(n: Node) = insert(n, root)

  // Overload for easy node addition by integer value alone.
  def add(n: Int) = insert(new Node(n), root)

  private def insert(n: Node, current: Node): Unit = {
    if (n.value > current.value) 
      if (current.right ne null) 
        insert(n, current.right)
      else
        current.right = n
    else if (n.value < current.value)
      if (current.left ne null)
        insert(n, current.left)
      else
        current.left = n
    else
      println("Value already exists: " + n.value)
  }

  def has(n: Node): Boolean = find(n.value, root)

  def has(n: Int): Boolean = find(n, root)

  private def find(n: Int, current: Node): Boolean = {

    if (n > current.value)
      if (current.right ne null)
        find(n, current.right)
      else
        false
    else if (n < current.value)
      if (current.left ne null)
        find(n, current.left)
      else
        false
    else
      true
  }
}

object BinaryTree {

  def main (args: Array[String]) = {

    require(!args.isEmpty)
    var nodeValues = args.map(_.toInt)
    val tree = new BinaryTree(nodeValues)

    tree.add(12)

    for (test <- 1 to 20) {
      if (tree.has(test))
        println(test + " is in our tree")
      else
        println(test + " is not in our tree")
    }
  }
}
