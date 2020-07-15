import sys
import os

def main():
	for i in range(16):
		os.mkdir("./" + str(i + 1))
		print(i)


if __name__ == '__main__':
	main()