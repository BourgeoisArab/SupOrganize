import praw
import urllib
import ctypes
import os

r = praw.Reddit(client_id = "zAXTI9GjBt2lqA",
				user_agent = "hackcambridgebot",
				client_secret = "oTqNPVMXXVzQM2McW_c0TV5dCTY",
				username = "hackcambridge2k18", 
				password = "hackcambridge2k18")

def get_image_urls(r, subreddit_name):
	submissions = r.subreddit(subreddit_name).top('day')
	img_urls = []
	for sub in submissions:
		if not sub.is_self and sub.url.endswith(".jpg") or sub.url.endswith(".png"):
			img_urls.append(sub.url)
	return img_urls
	
def downloadImage(url,filename):
	urllib.request.urlretrieve(url, filename)
	
def setBackground(path):
	ctypes.windll.user32.SystemParametersInfoW(20, 0, path, 0)
	

def getScreenRes():
	user32 = ctypes.windll.user32
	user32.SetProcessDPIAware()
	(w, h) = [user32.GetSystemMetrics(0), user32.GetSystemMetrics(1)]
	return (w,h)