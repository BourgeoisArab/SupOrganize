import praw
r = praw.Reddit(client_id = "hackcambridgebot",
				username = "hackcambridge2k18", 
				password = "hackcambridge2k18")
r.login


def get_images(r, subreddit_name):
	subreddit = r.subreddit(subreddit_name).top('day')
	return subreddit
	
