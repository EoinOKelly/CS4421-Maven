MODULES=com.team1.sysInfo com.team1.cpuInfo com.team1.pciInfo com.team1.usbInfo
SOURCES=$(MODULES:=.cc)
HEADERS=$(MODULES:%=../%.h)

#  Location of openjdk headers.  Change this according to your 
#  version and architecture
OPENJDK=/usr/lib/jvm/java-11-openjdk-amd64/include

libsysinfo.so: $(SOURCES) $(HEADERS)
	gcc -fPIC -I .. -I $(OPENJDK) \
        -I $(OPENJDK)/linux -shared \
        -o libsysinfo.so $(SOURCES)

