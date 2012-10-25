'''

'''
from pylab import *

def main():
	# Parameters
	N, P, gamma = 10, 0.8, .9 

	# Reward function
	r = zeros(N) - 0.1; r[0] = 1;  r[N-1] = -1

	# Initiality random start policy and value function
	policy = floor(2*rand(N))
	policy[0] = 2
	policy[N-1] = 2
	Vpi = rand(N)
	Vpi[0]=r[0]
	Vpi[N-1]=r[N-1]

	for iter in range(10):
	    # Estimate V for this policy usin
	    for i in range(100):
	        for s in range(1,N-1):
	        	# Eqaution 6.7 from textbook
	            snext  = s-1+2*policy[s]
	            sother = s+1-2*policy[s]
	            
	            Qpi[s,a] = r[s]+gamma*(P*(argmax())+(1-P)*())
	            
	            Vpi[s] = r[s]+gamma*(P*Vpi[snext]+(1-P)*Vpi[sother])

	    #Updating policy
	    for s in range(1,N-1):
	        policy[s] = argmax([Vpi[s-1],Vpi[s+1]])
	print policy     
	plot(Vpi); show()
'''

'''
def value_iteration():
	
'''

'''
def policy_iteration():

if __name__ == '__main__':
	main()