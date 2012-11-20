'''
'''

import cv

def count_cameras():
    for i in range(10):
        temp_camera = cv.CreateCameraCapture(i-1)
        temp_frame = cv.QueryFrame(temp_camera)
        del(temp_camera)
        if temp_frame==None:
            del(temp_frame)
            return i-1

if __name__ == '__main__':
	count_cameras()