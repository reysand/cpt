# Target Files
NAME			= FractalExplorer

# Directories
SRC_DIR			= src

# Files
SRCS			= $(SRC_DIR)/FractalExplorer.java $(SRC_DIR)/FractalGenerator.java	\
				  $(SRC_DIR)/JImageDisplay.java	$(SRC_DIR)/Mandelbrot.java          \
				  $(SRC_DIR)/Tricorn.java $(SRC_DIR)/BurningShip.java

# Programs
SHELL			= /bin/bash
JC				= javac
JAR				= jar cfm
RM				= -rm -rf

# ANSI Escape Sequences
C_RESET			= \033[00m
COLOR_G			= \033[32m

## all:			Call targets 'FractalExplorer'
PHONY			+= all
all:			$(NAME)

## FractalExplorer:
$(NAME):
	$(JC) -d $(CURDIR) $(SRCS)
	@echo "Main-Class: FractalExplorer" > Manifest.txt
	$(JAR) $(NAME).jar Manifest.txt *.class
	@printf "$(COLOR_G)PASS:$(C_RESET)\t$(NAME)\n"

## help:		Show help message
PHONY			+= help
help:			Makefile
	@IFS=$$'\n' ; \
	help_lines=(`sed -n 's/^##//p' $<`); \
	printf "%-10s %s\n%-10s %s\n" "Target" "Help" "----------" "------------"; \
	for help_line in $${help_lines[@]}; do \
		IFS=$$':' ; help_split=($$help_line) ; \
		help_command=`echo $${help_split[0]} | tr -d ' '` ; \
		help_info=`echo $${help_split[1]} | sed -e 's/^[[:space:]]*//'` ; \
		printf "\033[36m%-10s \033[0m%s\n" $$help_command $$help_info; \
	done

## clean:		Remove object files
PHONY			+= clean
clean:
	$(RM) *.class Manifest.txt $(NAME).jar
	@printf "$(COLOR_G)PASS:$(C_RESET)\tmake clean\t[$(NAME)]\n"


## re:			Call targets 'clean' and 'all'
PHONY			+= re
re:				clean all

## V=1:			Enable verbose output
$(V).SILENT:

.PHONY:			$(PHONY)
