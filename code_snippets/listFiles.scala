val files = (new java.io.File(".")).listFiles

for (file <- files)
  println(file)
