/**********************************************
*	Alex Moriarty, B00317947
*	Login: moriarty
*	CSCI 2132: Assignment 2, Question 3
*	
**********************************************/

#include <stdio.h>
#include <math.h>
#include <stdlib.h>

int mandel(double x0, double y0)
{
	double xt = x0;
	double yt = y0;
	double x2, y2, n, xn, yn;
	int i = 0;
	for (; i < 255; i++)
	{
		n = 1.0 * i;
		x2 = xt * xt;
		y2 = yt * yt;
		if ( (x2 + y2) > 4.0)
		{
			return n;
			break;
		}
		else
		{
			xn = x0 + x2 - y2;
			yn = y0 + 2*xt*yt;
			xt = xn;
			yt = yn;
		}
	}		
	
	return 255;
}

int main(int argc, char *argv[])
{
	// n is the number of units in the region of interest
	// w, h define the width, height of the region of interest
	double px, py, ph, t, gray, mpx, mpy, n, x, y, w, h;
	scanf("%lf%lf%lf%lf%lf", &n, &x, &y, &w, &h);
	double baseY = y;
	double s = (512.0 / n);
	int row;
	int col;
	
	printf("%%!\n");
	printf("\t 50 50 translate\n");
	printf("\t 0 0 512 512 rectstroke\n");
	for (row = 0; row < n; row++)
	{
		y = baseY;
		for (col = 0; col < n; col++)
		{	
			mpx = x + (0.5 * w / n);
			mpy = y + (0.5 * w / n);
			t = mandel(mpx, mpy);
			gray = 1.0 - t / 255.0;
			px = s * row;
			py = s * col;
			printf("\t %.3f setgray %.3f %.3f %.3f %.3f rectfill\n", gray, px, py, s, s);
			y += h / n;
		}
		x += w / n;
	}

	printf("\t showpage\n");
}

