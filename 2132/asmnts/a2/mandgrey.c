/**********************************************
*       Alex Moriarty, B00317947
*       Login: moriarty
*       CSCI 2132: Assignment 2, Question 3
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
        double n, x0, y0, dx, dy, x1, y1, x2, y2, t, g;
        scanf("%lf%lf%lf%lf%lf", &n, &x0, &y0, &dx, &dy);

        double sc = (512.0 / n);
        double mx = 0.5*dx/n;
        double my = 0.5*dy/n;

        double x3, y3, x4, y4;

        int r;
        int c;

        printf("%%!\n");
        printf("\t 50 50 translate\n");
        printf("\t 0 0 512 512 rectstroke\n");

	x1 = x0;

        for (r = 0; r < n; r++)
        {

                y1 = y0;
                x2 = x1 + mx;
		x3 = x2 + mx;
		x4 = sc * r;
		
                for (c = 0; c < n; c++)
                {
                        y2 = y1 + my;
			y3 = y2 + my;
                        y4 = sc * c;
                        t = mandel(x2, y2);
                        g = 1.0 - t / 255.0;
                        printf("\t %.3f setgray %.3f %.3f %.3f %.3f rectfill\n", g, x4, y4, sc, sc);
                        y1 = y3;

                }
                x1 = x3;
        }

        printf("\t showpage\n");
}

