#!/bin/sh

#java -Xms4096m -Xmx4096m OStest 4096 4096

#python memoryGraph.py -i 4096 -o 4096

#java Cooldown

#java -Xms256m -Xmx2048m OStest 256 2048

#python memoryGraph.py -i 256 -o 2048

#java Cooldown

#java -Xms512m -Xmx2048m OStest 512 2048

#python memoryGraph.py -i 512 -o 2048

#java Cooldown

#java -Xms1024m -Xmx2048m OStest 1024 2048

#python memoryGraph.py -i 1024 -o 2048

#java Cooldown

#java -Xms2048m -Xmx2048m OStest 2048 2048

#python memoryGraph.py -i 2048 -o 2048

#java Cooldown



java -Xms1024m -Xmx1024m OStest 1024 1024
python memoryGraph.py -i 1024 -o 1024
java Cooldown

java -Xms512m -Xmx512m OStest 512 512
python memoryGraph.py -i 512 -o 512
java Cooldown

java -Xms256m -Xmx256m OStest 256 256
python memoryGraph.py -i 256 -o 256
java Cooldown

java -Xms128m -Xmx128m OStest 128 128
python memoryGraph.py -i 128 -o 128
java Cooldown

java -Xms128m -Xmx1024m OStest 128 1024
python memoryGraph.py -i 128 -o 1024
java Cooldown

java -Xms256m -Xmx1024m OStest 256 1024
python memoryGraph.py -i 256 -o 1024
java Cooldown

java -Xms512m -Xmx1024m OStest 512 1024
python memoryGraph.py -i 512 -o 1024
java Cooldown