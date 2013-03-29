def factorial( n ):
	if n > 1 :
		return (n * factorial( n - 1 ))
	return 1

def factorial_induction(n):
	ans = 1
	for i in range(n, 1, -1):
		ans*=i
	return ans

def search_induction(n, a, k):
	if n == 0:
		return -1
	min = 0
	max = int(n-1)

	while min < max:
		mid = min + (max-min)/2
		if a[mid] == k:
			return mid
		elif a[mid] < k:
			min = mid + 1
		else:
			max = mid - 1
	return -1


if __name__ == "__main__":
	n = input("Enter n: ")
	a = '1','2','3','5'

	print "----\nBy Induction"
	print factorial_induction(n)
	print "----\nBy Recursion"
	print factorial(n)
	print "----\nSearch Induction"
	print search_induction(a, 3, n)
