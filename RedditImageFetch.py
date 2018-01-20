import praw
import urllib
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
	
urls = get_image_urls(r,"all")
downloadImage(urls[0],"first_image.jpg")