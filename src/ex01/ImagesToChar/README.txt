# compile
javac -d target `find . -name "*.java"`

# copy resources
cp -r src/resources target

# create JAR archive
jar -cfm target/images-to-chars-printer.jar src/manifest.txt -C target .

# run
java -jar target/images-to-chars-printer.jar . 0
