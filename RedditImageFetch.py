import praw
import urllib
import ctypes
import os
from PIL import Image
import requests
from PIL import Image
from io import BytesIO


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
	p = os.path.abspath(path)
	ctypes.windll.user32.SystemParametersInfoW(20, 0, p, 0)
	
def get_resolution(url):
    data = requests.get(url).content
    im = Image.open(BytesIO(data))    
    return im.size
	
def aspect_ratio(dimensions):
	return dimensions[0]/dimensions[1]

def getScreenRes():
	user32 = ctypes.windll.user32
	user32.SetProcessDPIAware()
	(w, h) = [user32.GetSystemMetrics(0), user32.GetSystemMetrics(1)]
	return (w,h)
	
def get_screen_aspect_ratio():
	return aspect_ratio(getScreenRes())
	
def select_best_url(urls):
	(w, h) = getScreenRes()
	desired_aspect_ratio = aspect_ratio((w, h))
	ratio_tolerance = 1.3
	max_ratio = ratio_tolerance*desired_aspect_ratio
	min_ratio = desired_aspect_ratio/ratio_tolerance
	width_tolerance = 1.3
	min_width = w/width_tolerance
	
	for url in urls:
		res = get_resolution(url)
		ratio = aspect_ratio(res)
		if min_ratio <= ratio <= max_ratio:
			if min_width <= res[0]:
				return url
	return urls[0]
		
url = select_best_url(get_image_urls(r, 'pics'))
downloadImage(url, 'mynewfile.jpg')
setBackground('C:\\Users\\Dan\\SupOrganize\\mynewfile.jpg')
	
	
