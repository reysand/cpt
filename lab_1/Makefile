# Target Files
TASK1			= primes
TASK2			= palindrome

# Directories
SRC_DIR			= src

# Files
SRCS			= $(SRC_DIR)/Primes.java $(SRC_DIR)/Palindrome.java

# Programs
SHELL			= /bin/bash
JC				= javac
RM				= -rm -rf

# ANSI Escape Sequences
C_RESET			= \033[00m
COLOR_G			= \033[32m

## all:			Call targets 'primes' and 'palindrome'
PHONY			+= all
all:			$(TASK1) $(TASK2)

## primes:
$(TASK1):
	$(JC) -d $(CURDIR) $(word 1, $(SRCS))
	@printf "$(COLOR_G)PASS:$(C_RESET)\t$(TASK1)\n"

## palindrome:
$(TASK2):
	$(JC) -d $(CURDIR) $(word 2, $(SRCS))
	@printf "$(COLOR_G)PASS:$(C_RESET)\t$(TASK2)\n"

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
	$(RM) Primes.class Palindrome.class
	@printf "$(COLOR_G)PASS:$(C_RESET)\tmake clean\t[$(TASK1)]\n"
	@printf "$(COLOR_G)PASS:$(C_RESET)\tmake clean\t[$(TASK2)]\n"

## re:			Call targets 'clean' and 'all'
PHONY			+= re
re:				clean all

## V=1:			Enable verbose output
$(V).SILENT:

.PHONY:			$(PHONY)
