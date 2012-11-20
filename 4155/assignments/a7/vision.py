# -*- coding: utf-8 -*-
"""
Created on Thu Nov 08 14:12:05 2012

@author: Kathleen
"""
SMOOTH1 = 5
SMOOTH2 = 3

import cv
import numpy as np

class Vision:
    def __init__(self):
        cv.NamedWindow("Vision", 1)
        self.capture = cv.CaptureFromCAM(1)
        
    def run(self):
        # Capture first frame to get size
        frame = cv.QueryFrame(self.capture)
        size = cv.GetSize(frame)
        masked = cv.CreateImage(size, 8, 3)
        hsv_frame = cv.CreateImage(size, cv.IPL_DEPTH_8U, 3)
        thresholded = cv.CreateImage(size, cv.IPL_DEPTH_8U, 1)
        thresholded2 = cv.CreateImage(size, cv.IPL_DEPTH_8U, 1)
        grey_image = cv.CreateImage(size, cv.IPL_DEPTH_8U, 1)
        hsv_min = cv.Scalar(0, 70, 220, 0)
        hsv_max = cv.Scalar(5, 220, 256, 0)
        hsv_min2 = cv.Scalar(170, 70, 220, 0)
        hsv_max2 = cv.Scalar(256, 180, 256, 0)
        
        locationV = np.zeros([2,1000])
        time = np.zeros(1000)
        #while True:
        for n in range(1000):
            color_image = cv.QueryFrame(self.capture)
            # Smooth to get rid of false positives
            cv.Smooth(color_image, color_image, cv.CV_GAUSSIAN, 3, 0)
            
            cv.CvtColor(color_image, hsv_frame, cv.CV_BGR2HSV)
            cv.InRangeS(hsv_frame, hsv_min, hsv_max, thresholded)
            cv.InRangeS(hsv_frame, hsv_min2, hsv_max2, thresholded2)
            cv.Or(thresholded, thresholded2, thresholded)
            # pre-smoothing improves Hough detector
            cv.Smooth(thresholded, thresholded, cv.CV_GAUSSIAN, 9, 9)
        
            # Dilate and erode to get people blobs
            cv.Dilate(thresholded, grey_image, None, 18)
            cv.Erode(grey_image, grey_image, None, 10)
            
            #mask original
            cv.Zero(masked)
            cv.Copy(color_image,masked,grey_image)
            
            storage = cv.CreateMemStorage(0)
            contour = cv.FindContours(grey_image, storage, cv.CV_RETR_CCOMP, cv.CV_CHAIN_APPROX_SIMPLE  )
            first =True
            fin1= [0,0]
            fin2 =[0,0]
            final = fin1
            while contour:
                bound_rect = cv.BoundingRect(list(contour))
                contour = contour.h_next()

                pt1 = (bound_rect[0], bound_rect[1])
                pt2 = (bound_rect[0] + bound_rect[2], bound_rect[1] + bound_rect[3])
                
                if(first):
                    fin1 = pt1
                    fin2 = pt2
                    dist = pow(pt1[0] - pt2[0],2) +  pow(pt1[1] - pt2[1],2)
                    first = False
                else:
                    dist2 =pow(pt1[0] - pt2[0],2) +  pow(pt1[1] - pt2[1],2)
                    if(dist2 > dist):
                        dist = dist2
                        fin1 = pt1
                        fin2 = pt2
            if(first==False):#if something was found
                cv.Rectangle(masked, fin1, fin2, cv.CV_RGB(255,0,0), 1)
                locationV[0][n] = final[0] = abs(fin1[0]- fin2[0])
                locationV[1][n]  = final[1] = abs(fin1[1]- fin2[1])
                print final
                

            #at this point need to figure out which square is lego man- maybe the large
                
           #cv.Copy(color_image,color_image,grey_image)
            cv.ShowImage("Vision", masked)
            
            # Listen for ESC key
            c = cv.WaitKey(7) % 0x100
            if c == 27:
                break
        plot(locationV[0],locationV[1],)

    def get_local(self):
        # Capture first frame to get size
        frame = cv.QueryFrame(self.capture)
        size = cv.GetSize(frame)
        masked = cv.CreateImage(size, 8, 3)
        hsv_frame = cv.CreateImage(size, cv.IPL_DEPTH_8U, 3)
        thresholded = cv.CreateImage(size, cv.IPL_DEPTH_8U, 1)
        thresholded2 = cv.CreateImage(size, cv.IPL_DEPTH_8U, 1)
        grey_image = cv.CreateImage(size, cv.IPL_DEPTH_8U, 1)
        hsv_min = cv.Scalar(0, 70, 220, 0)
        hsv_max = cv.Scalar(5, 220, 256, 0)
        hsv_min2 = cv.Scalar(170, 70, 220, 0)
        hsv_max2 = cv.Scalar(256, 180, 256, 0)
        locationV = np.zeros([2,1])
        time = np.zeros(1)
        #while True:
        color_image = cv.QueryFrame(self.capture)
        # Smooth to get rid of false positives
        cv.Smooth(color_image, color_image, cv.CV_GAUSSIAN, 3, 0)
        
        cv.CvtColor(color_image, hsv_frame, cv.CV_BGR2HSV)
        cv.InRangeS(hsv_frame, hsv_min, hsv_max, thresholded)
        cv.InRangeS(hsv_frame, hsv_min2, hsv_max2, thresholded2)
        cv.Or(thresholded, thresholded2, thresholded)
        # pre-smoothing improves Hough detector
        cv.Smooth(thresholded, thresholded, cv.CV_GAUSSIAN, 9, 9)
    
        # Dilate and erode to get people blobs
        cv.Dilate(thresholded, grey_image, None, 18)
        cv.Erode(grey_image, grey_image, None, 10)
        
        #mask original
        cv.Zero(masked)
        cv.Copy(color_image,masked,grey_image)
        
        storage = cv.CreateMemStorage(0)
        contour = cv.FindContours(grey_image, storage, cv.CV_RETR_CCOMP, cv.CV_CHAIN_APPROX_SIMPLE  )
        first =True
        fin1= [0,0]
        fin2 =[0,0]
        final = fin1
        if contour:
            bound_rect = cv.BoundingRect(list(contour))
            contour = contour.h_next()

            pt1 = (bound_rect[0], bound_rect[1])
            pt2 = (bound_rect[0] + bound_rect[2], bound_rect[1] + bound_rect[3])
            
            if(first):
                fin1 = pt1
                fin2 = pt2
                dist = pow(pt1[0] - pt2[0],2) +  pow(pt1[1] - pt2[1],2)
                first = False
            else:
                dist2 =pow(pt1[0] - pt2[0],2) +  pow(pt1[1] - pt2[1],2)
                if(dist2 > dist):
                    dist = dist2
                    fin1 = pt1
                    fin2 = pt2
        if(first==False):#if something was found
            cv.Rectangle(masked, fin1, fin2, cv.CV_RGB(255,0,0), 1)
            locationV[0][0] = final[0] = abs(fin1[0]- fin2[0])
            locationV[1][0]  = final[1] = abs(fin1[1]- fin2[1])
            #print final
            return final 
           

        #at this point need to figure out which square is lego man- maybe the large
            
       #cv.Copy(color_image,color_image,grey_image)
        #cv.ShowImage("Vision", masked)
        
        # Listen for ESC key
        #c = cv.WaitKey(7) % 0x100
        #if c == 27:
        #    break
    #plot(locationV[0],locationV[1],)


if __name__=="__main__":
    t = Vision()
    t.run()
