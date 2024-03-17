#Requirement
- `Version info: 'GraalVM 22.3.0 Java 17 CE'`
- `Java version info: '17.0.5+8-jvmci-22.3-b08'`
#Compile
```
- mvn -Pnative clean package
```

#Run
You can run this app directly using
```
./target/java-native-cli-template
```

For showing help, 
You can run this app directly using
```
./target/java-native-cli-template -h
```

Test input using args
```
./target/java-native-cli-template -i your-txt
```
or
```
./target/java-native-cli-template --input your-txt
```




