// Imperative style
var i = 0
while (i < args.length) {
  println(args(i))
  i += 1
}

// Scala style For loop
for (arg <- args)
  println(arg)

// Function literal
args.foreach(arg => println(arg))
// OR
args.foreach(println)
